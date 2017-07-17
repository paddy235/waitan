package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.NaturalPersonDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.CompanySearch2DO;
import com.bbd.wtyh.domain.query.NaturalPersonQuery;
import com.bbd.wtyh.domain.vo.NaturalPersonVO;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.NaturalPersonMapper;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.HologramQueryService;
import com.bbd.wtyh.service.NaturalPersonService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Barney on 2017/7/5.
 */
@Service
public class NaturalPersonServiceImpl implements NaturalPersonService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private NaturalPersonMapper mapper;

    @Resource
    private CompanyMapper companyMapper;

    @Autowired
    private HologramQueryService hologramQueryService;

    @Autowired
    private RedisDAO redisDAO;


    @Override
    public int batchInsertNaturalPerson(List<NaturalPersonDO> list) {
        return mapper.batchInsertNaturalPerson(list);
    }

    @Override
    public int updateNaturalPersonInvalid() {
        return mapper.updateNaturalPersonInvalid();
    }

    @Override
    public int deleteNaturalPersonInvalid() {
        return mapper.deleteNaturalPersonInvalid();
    }

    @Override
    public int queryNaturalPersonCount(NaturalPersonQuery query) {
        return mapper.queryNaturalPersonCount(query);
    }

    @Override
    public List<NaturalPersonVO> queryNaturalPerson(NaturalPersonQuery query) {
        return mapper.queryNaturalPerson(query);
    }

    @Override
    public List<String> queryCompanyByPerson(String person) {
        return mapper.queryCompanyByPerson(person);
    }

    @Override
    public Map<String, Object> queryNaturalPerson2(
            String nalName, String type, String companyKeyword, Integer pageSize, Integer page ) {
        Map<String, Object> rst=new HashMap<>();
        if( StringUtils.isBlank(nalName) ||StringUtils.isBlank(type)
                ||( !type.equals("all") && !type.equals("gdxx") && !type.equals("baxx") ) ) {
            return rst;
        }
        //准备CompanySearch2DO.Rdata数据
        // List<NaturalPersonVO> naturalPersons1;
        final Object[] naturalPersonArr =new Object[1];
        final String redisKey = Constants.REDIS_KEY_NATURAL_PERSON_LIST + "_" + nalName + "_" + type;
        Gson gson =new Gson();
        GetAndRedisAdd gr =()->{
            try {
                naturalPersonArr[0] = getNaturalPerson(nalName, type);
                redisDAO.addObject(redisKey, naturalPersonArr[0], Constants.cacheDay_One_Day, List.class);
                //String str = gson.toJson(naturalPersonArr, List.class);
                //String str = gson.toJson(naturalPersonArr[0], (new TypeToken<List<NaturalPersonVO>>() { }).getType());
                //redisDAO.addString(redisKey, str, Constants.cacheDay_One_Day);
            } catch (Exception e) {
                logger.warn(e.toString());
            }
        };
        try {
            Object rObj = redisDAO.getObject(redisKey);
            //String jStr = redisDAO.getString(redisKey);
            if (null != rObj && rObj instanceof List /*null !=jStr*/) {
                try {
                    naturalPersonArr[0] = rObj;
                    //naturalPersonArr[0] =gson.fromJson( jStr, (new TypeToken<List<NaturalPersonVO>>() { }).getType() );
                } catch (Exception e) {
                    gr.fun();
                }
            } else {
                gr.fun();
            }
        } catch (Exception e) {
            gr.fun();
        }
        List<String> companyNames =new LinkedList<>();
        int cnt =0;
        for ( ; cnt <2; cnt++) {
            try {
                if (StringUtils.isNotBlank(companyKeyword)) {
                    companyNames = new LinkedList<>();
                    List<NaturalPersonVO> tmpLst = new LinkedList<>();
                    for (NaturalPersonVO npv : (List<NaturalPersonVO>)(naturalPersonArr[0]) ) {
                        if (npv.getRelatedCompany().contains(companyKeyword)) {
                            companyNames.add(npv.getRelatedCompany());
                            tmpLst.add(npv);
                        }
                    }
                    naturalPersonArr[0]  = tmpLst;
                } else {
                    for (NaturalPersonVO npv : (List<NaturalPersonVO>)(naturalPersonArr[0]) ) {
                        companyNames.add(npv.getRelatedCompany());
                    }
                }
                break;
            } catch (Exception e) {
                gr.fun();
            }
        }
        if( cnt >=2 ) { //重试失败
            companyNames =new LinkedList<>();
            naturalPersonArr[0] =new LinkedList<>();
        }
        rst.put("total", companyNames.size()); //告诉前端总条数
        //加序号
        int idx =1;
        for (NaturalPersonVO npv : (List<NaturalPersonVO>)(naturalPersonArr[0]) ) {
            npv.setIdx(idx++);
        }
        //分页
        if( null ==pageSize || pageSize <=0 ) { //前端不传此参数或错传
            pageSize =100;
        }
        if ( null !=page && page >=1 ) {
            page =(page -1) *pageSize;
        } else {
            page =0;
        }
        rst.put("page", page/pageSize +1);
        rst.put("pageSize", pageSize);
        if ( page < companyNames.size() ){
            if( (page +pageSize) >=companyNames.size() ){
                pageSize =companyNames.size() -page;
            }
            companyNames =companyNames.subList(page, page +pageSize);
            naturalPersonArr[0] =((List<NaturalPersonVO>)(naturalPersonArr[0])).subList(page, page +pageSize);
        }
        rst.put("naturalPersons", naturalPersonArr[0] );
        rst.put("companyNames", companyNames);
        return rst;
    }

    @FunctionalInterface
    interface GetAndRedisAdd {
        void fun( );
    };

    private List<NaturalPersonVO> getNaturalPerson( String nalName, String type ) {
        List<CompanySearch2DO.Rdata> csList;
        if( type.equals("all") ) {
            LinkedHashMap<String, CompanySearch2DO.Rdata> lhMap =new LinkedHashMap<>(); //用于 去重
            List<CompanySearch2DO.Rdata> gdList =hologramQueryService.getNaturalPersonList(nalName, "gdxx");
            if( null !=gdList && gdList.size() >0 ) {
                for ( CompanySearch2DO.Rdata rd : gdList ) {
                    lhMap.put( rd.getCompany_name(), rd );
                }
            }
            List<CompanySearch2DO.Rdata> baList =hologramQueryService.getNaturalPersonList(nalName, "baxx");
            if( null !=baList && baList.size() >0 ) {
                for ( CompanySearch2DO.Rdata rd : baList ) {
                    lhMap.put( rd.getCompany_name(), rd );
                }
            }
            csList =new ArrayList<>( lhMap.values() );
        } else {
            csList =hologramQueryService.getNaturalPersonList(nalName, type);
        }
        //转存到新的对象并按地域分类
        List<NaturalPersonVO> shangHaiList =new LinkedList<>();
        List<String> shCpyNames =new LinkedList<>();
        List<NaturalPersonVO> otherList =new LinkedList<>();
        for ( CompanySearch2DO.Rdata rd : csList ) {
            NaturalPersonVO npv =new NaturalPersonVO();
            npv.setNalName(nalName);
            if( StringUtils.isBlank(rd.getCompany_name()) )
                continue;
            npv.setRelatedCompany(rd.getCompany_name());
            //npv.setPosition("职务");
            npv.setEsDate(rd.getEsdate());
            npv.setFrName(rd.getFrname());
            npv.setRegCapital(rd.getRegcap());
            npv.setRegAddress(rd.getAddress());
            if( StringUtils.isNotBlank(rd.getProvince()) && rd.getProvince().equals("上海市") ) {
                shangHaiList.add(npv);
                shCpyNames.add(rd.getCompany_name());
            } else {
                otherList.add(npv);
            }
        }
        //分类排序类金融
        Date start =new Date();
        List<String> kindredFinanceCpyNames = companyMapper.findKindredFinanceCompanyNameByCompanyName(shCpyNames);
        long dltSec =(new Date()).getTime() -start.getTime();
        logger.debug("findKindredFinanceCompanyNameByCompanyName--shCpyNames[{}]--num[{}]--{}ms", shCpyNames, kindredFinanceCpyNames.size(), dltSec );
        if( null !=kindredFinanceCpyNames && kindredFinanceCpyNames.size() >0 ) {
            List<NaturalPersonVO> kindredFinances =new LinkedList<>();
            List<NaturalPersonVO> noKindredFinances =new LinkedList<>();
            for (NaturalPersonVO npv : shangHaiList) {
                boolean kddFin =false;
                for( String na :kindredFinanceCpyNames ) {
                    if( null !=na && null !=npv.getRelatedCompany() && na.equals(npv.getRelatedCompany()) ) {
                        kddFin =true;
                        break;
                    }
                }
                if(kddFin) {
                    kindredFinances.add(npv);
                } else {
                    noKindredFinances.add(npv);
                }
            }
            shangHaiList =kindredFinances; //替换成类金融企业
            shangHaiList.addAll(noKindredFinances); //加入非类金融企业
        }
        shangHaiList.addAll(otherList); //加入非上海的企业
        /*if (shangHaiList.size() >=360) { //截断过大的结果集合
            shangHaiList = shangHaiList.subList(0, 360);
            //shangHaiList = new LinkedList<>(shangHaiList.subList(0, 300));
        }*/
        //为所有成员加入职务
        List<String> companyNames =new LinkedList<>();
        for (NaturalPersonVO npv : shangHaiList) {
            companyNames.add(npv.getRelatedCompany());
        }
        List<BaseDataDO.Results> rs =hologramQueryService.getBbdQyxxAll(companyNames);
        if( null !=rs && rs.size() >0 ) {
            for( BaseDataDO.Results rt :rs ) { //遍历企业详情列表
                String tCompanyNa = null !=rt.getJbxx() ? rt.getJbxx().getCompany_name() : "";
                if( StringUtils.isBlank(tCompanyNa) )
                    continue;
                for (NaturalPersonVO npv : shangHaiList) { //从NPVO列表中搜索企业名称相同的条目
                    if( npv.getRelatedCompany().equals(tCompanyNa) ) {
                        List<BaseDataDO.Baxx> baL = rt.getBaxx();
                        for (BaseDataDO.Baxx ba :baL) {
                            if( StringUtils.isNotBlank(ba.getName()) && ba.getName().equals(npv.getNalName()) ) {
                                npv.setPosition(ba.getPosition());
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
        return shangHaiList;
    }

}
