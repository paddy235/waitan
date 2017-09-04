package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.MiscParameterDO;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    //判断导出文件是否能被下载（次数是否超限），每返回一次true就会扣除一次下载次数
    public synchronized boolean allowDownFile() {
        MiscParameterDO mpd =mapper.queryParameterDoByName();
        if( null ==mpd || null ==mpd.getValue1() || null ==mpd.getValue2() || null ==mpd.getValue3() ) {
            return false;
        }
        int localDay =LocalDate.now().getDayOfMonth();
        if( mpd.getValue2() != localDay ) {
            mapper.updateDownCurrDay(localDay);
            mapper.updateDownTimeNum(1); //已扣除下载的第一次
            return true;
        }
        if( mpd.getValue1() <mpd.getValue3() ) {
            mapper.updateDownTimeNum(mpd.getValue1() +1);
            return true;
        }
        return false;
    }

    public static void main(String []argc) {
        int aa = LocalDate.now().getDayOfMonth();
        int aa2 = LocalDate.now().getDayOfYear();
        int aa1 = LocalDate.now().getYear();
        int bb =0;
    }


    private List<NaturalPersonVO> getNaturalPersonAll( List<NaturalPersonVO> shInList, String nalName ) {
        boolean isProvince = (null ==shInList);
        List<CompanySearch2DO.Rdata> csList =new LinkedList<>();;
        if ( isProvince ) { //查询省内范围
            csList =hologramQueryService.getNaturalPersonListMul( nalName, true, "mix", null );
        } else { //查询省外范围
            int pgLimit =shInList.size();
            if( pgLimit <4500 ) {
                pgLimit =4500 -pgLimit;
            } else {
                pgLimit =0;
            }
            List<CompanySearch2DO.Rdata> tmpCsList = hologramQueryService.getNaturalPersonListMul( nalName, false, "mix", pgLimit);
            //去除上海市的企业
            for ( CompanySearch2DO.Rdata rd : tmpCsList ) {
                /*boolean existence =false;
                for ( NaturalPersonVO npv : shInList ) {
                    if ( null !=rd.getBbd_qyxx_id() && null !=npv.getBbdQyxxId() && npv.getBbdQyxxId().equals(rd.getBbd_qyxx_id()) ) {
                        existence =true;
                        break;
                    }
                }
                if (!existence) { //不存在，则保留
                    csList.add(rd);
                }*/
                if (  StringUtils.isNotBlank(rd.getProvince()) && (! rd.getProvince().equals("上海市") ) ) { //不存在，则保留
                    csList.add(rd);
                }
            }
        }
        //转存到新的对象并按地域分类
        List<String> shCpyNames =new LinkedList<>();
        List<NaturalPersonVO> npvList =new LinkedList<>();
        for ( CompanySearch2DO.Rdata rd : csList ) {
            NaturalPersonVO npv =new NaturalPersonVO();
            if( StringUtils.isBlank(rd.getCompany_name()) )
                continue;
            npv.setRelatedCompany(rd.getCompany_name().replace("<em>","").replace("</em>",""));
            //todo  企业名称中可能含有高亮标签，需要去除。
            boolean isPosition =false;
            if ( null !=rd.getHighlight() ) {
                String positions ="";
                if ( null !=rd.getHighlight().getFrname() ) {
                    isPosition =true;
                    positions ="法人代表";
                    npv.setFrGud(true);
                    npv.setPosition(positions);
                }
                if ( null !=rd.getHighlight().getGdxx_person() ) {
                    isPosition =true;
                    if ( positions.isEmpty() ) {
                        positions ="自然人股东";
                    } else {
                        positions +="、" +"自然人股东";
                    }
                    npv.setFrGud(true);
                    npv.setPosition(positions);
                }
                if ( null !=rd.getHighlight().getBaxx() ) {
                    isPosition =true;
                    if ( positions.isEmpty() ) {
                        positions ="董监高";
                    } else {
                        positions +="、" +"董监高";
                    }
                    npv.setDjg(true);
                    npv.setPosition(positions);
                }
            }
            if ( ! isPosition ) { //没有匹配到企业法人或董监高，此条数据丢弃
                continue;
            }
            npv.setNalName(nalName);
            npv.setEsDate(rd.getEsdate());
            npv.setFrName(rd.getFrname());
            npv.setRegCapital(rd.getRegcap());
            npv.setRegAddress(rd.getAddress());
            npv.setBbdQyxxId(rd.getBbd_qyxx_id());
            if( isProvince ) {
                shCpyNames.add(rd.getCompany_name());
            } else {
                npv.setRange("全国");
            }
            npvList.add(npv);
        }
        if (isProvince) {  //分类排序类金融
            //Date start =new Date();
            List<String> kindredFinanceCpyNames =new LinkedList<>();
            if(  shCpyNames.size() >0) {
                kindredFinanceCpyNames = companyMapper.findKindredFinanceCompanyNameByCompanyName(shCpyNames);
            }
            //long dltSec =(new Date()).getTime() -start.getTime();
            //logger.info("findKindredFinanceCompanyNameByCompanyName--num[{}]--{}ms", kindredFinanceCpyNames.size(), dltSec );
            if( null !=kindredFinanceCpyNames && kindredFinanceCpyNames.size() >0 ) {
                List<NaturalPersonVO> kindredFinances =new LinkedList<>();
                List<NaturalPersonVO> noKindredFinances =new LinkedList<>();
                for (NaturalPersonVO npv : npvList) {
                    boolean kddFin =false;
                    for( String na :kindredFinanceCpyNames ) {
                        if( null !=na && null !=npv.getRelatedCompany() && na.equals(npv.getRelatedCompany()) ) {
                            kddFin =true;
                            break;
                        }
                    }
                    if(kddFin) {
                        kindredFinances.add(npv);
                        npv.setRange("类金融企业");
                    } else {
                        noKindredFinances.add(npv);
                        npv.setRange("上海市");
                    }
                }
                npvList =kindredFinances; //替换成类金融企业
                npvList.addAll(noKindredFinances); //加入非类金融企业
            } else {
                for (NaturalPersonVO npv : npvList) {
                    npv.setRange("上海市");
                }
            }
        }
        return npvList;
    }

    private List<NaturalPersonVO> getNaturalPersonAllAndWriteCache( List<NaturalPersonVO> shInList, String nalName ) {
        boolean isProvince  = (null ==shInList);
        final String redisKey = Constants.REDIS_KEY_NATURAL_PERSON_LIST_ALL_TYPE + "_" + nalName + "_" + isProvince;
        List<NaturalPersonVO> npaList =getNaturalPersonAll(shInList, nalName);
        try {
            redisDAO.addObject(redisKey, npaList, Constants.cacheDay_One_Day, List.class);
        } catch (Exception e) {
            logger.warn(e.toString());
        }
        return npaList;
    }

    /**
     * 获取自然人列表，先尝试从cache取，若没有再从接口取；“gdxx”和“baxx”合并缓存成“all”。
     * @param shInList 若为null则获取上海市内的自然人列表，反之则获取上海市外的自然人列表。
     * @param nalName
     * @param noCache
     * @return
     */
    private List<NaturalPersonVO> getNaturalPersonAllByCache( List<NaturalPersonVO> shInList, String nalName, Boolean noCache ) {
        boolean isProvince  = (null ==shInList);
        final String redisKey = Constants.REDIS_KEY_NATURAL_PERSON_LIST_ALL_TYPE + "_" + nalName + "_" + isProvince;
        List<NaturalPersonVO> npaList;
        if ( null !=noCache && noCache ) {
            npaList =getNaturalPersonAllAndWriteCache(shInList, nalName);
        } else {
            try {
                Object rObj = redisDAO.getObject(redisKey);
                if (null != rObj && rObj instanceof List ) {
                    npaList = ( List )rObj;
                } else {
                    npaList =getNaturalPersonAllAndWriteCache(shInList, nalName);
                }
            } catch (Exception e) {
                npaList =getNaturalPersonAllAndWriteCache(shInList, nalName);
            }
        }
        return npaList;
    }

    //
    @Override
    public Map<String, Object> queryNaturalPerson2( String nalName, String type, Boolean isProvince,
                    String companyKeyword, Integer pageSize, Integer page, Boolean noCache ) {
        if (null == isProvince) {
            isProvince =false;
        }
        final boolean fIsProvince =isProvince;
        Map<String, Object> rst=new HashMap<>();
        rst.put("total", 0);
        if( StringUtils.isBlank(nalName) ) {
            return rst;
        }

        //获取all type list
        List<NaturalPersonVO> naturalPersons =getNaturalPersonAllByCache(null, nalName, noCache);
        if ( !isProvince ) {
            naturalPersons.addAll( getNaturalPersonAllByCache(naturalPersons, nalName, noCache) );
        }

        //按筛选条件过滤
        if ( StringUtils.isNotBlank(type) && (!type.equals("all")) ) {
            List<NaturalPersonVO> tmpLst = new LinkedList<>();
            if ( type.equals("gdxx") ) { //仅返回法人代表和自然人股东包含此人的企业
                for (NaturalPersonVO npv : naturalPersons ) {
                    if ( npv.isFrGud() ) {
                        tmpLst.add(npv);
                    }
                }
                naturalPersons  =tmpLst;
            } else if ( type.equals("baxx") ) { //仅返回董监高包含此人的企业
                for (NaturalPersonVO npv : naturalPersons ) {
                    if ( npv.isDjg() ) {
                        tmpLst.add(npv);
                    }
                }
                naturalPersons  =tmpLst;
            }
        }

        //按条件重构传给前端的完整列表
        List<String> companyNames =new LinkedList<>();
        if (StringUtils.isNotBlank(companyKeyword)) { //筛选包含企业关键字的自然人信息列表
            companyNames = new LinkedList<>();
            List<NaturalPersonVO> tmpLst = new LinkedList<>();
            for (NaturalPersonVO npv : naturalPersons ) {
                if (npv.getRelatedCompany().contains(companyKeyword)) {
                    companyNames.add(npv.getRelatedCompany());
                    tmpLst.add(npv);
                }
            }
            naturalPersons  = tmpLst;
        } else {
            for (NaturalPersonVO npv : naturalPersons ) {
                companyNames.add(npv.getRelatedCompany());
            }
        }
        rst.put("total", companyNames.size()); //告诉前端总条数
        //加序号
        int idx =1;
        for (NaturalPersonVO npv : (List<NaturalPersonVO>)(naturalPersons) ) {
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
            naturalPersons = naturalPersons.subList(page, page +pageSize);
        }
        rst.put("naturalPersons", naturalPersons );
        rst.put("companyNames", companyNames);
        return rst;
    }

    //（后面的都是暂不使用的）

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
        List<String> kindredFinanceCpyNames =new LinkedList<>();
        if(  shCpyNames.size() >0) {
            kindredFinanceCpyNames = companyMapper.findKindredFinanceCompanyNameByCompanyName(shCpyNames);
        }
        long dltSec =(new Date()).getTime() -start.getTime();
        //logger.info("findKindredFinanceCompanyNameByCompanyName--num[{}]--{}ms", kindredFinanceCpyNames.size(), dltSec );
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

    /*private List<NaturalPersonVO> getNaturalPerson2( String nalName, boolean isProvince, String type ) {
        List<CompanySearch2DO.Rdata> csList;
        if( type.equals("all") ) {
            type ="mix";
        }
        csList =hologramQueryService.getNaturalPersonListMul(nalName, true, type, null);
        if( !isProvince ) {
            //查全国范围
            int pgLimit =csList.size();
            if( pgLimit <3900 ) {
                pgLimit =3900 -pgLimit;
            } else {
                pgLimit =0;
            }
            if( type.equals("mix") ) {
                pgLimit +=900;
            }
            csList.addAll( hologramQueryService.getNaturalPersonListMul( nalName, false, type, pgLimit) );
        }
        LinkedHashMap<String, CompanySearch2DO.Rdata> lhMap =new LinkedHashMap<>(); //用于 去重
        if( null !=csList && csList.size() >0 ) {
            for ( CompanySearch2DO.Rdata rd : csList ) {
                lhMap.put( rd.getCompany_name(), rd );
            }
        }
        csList =new ArrayList<>( lhMap.values() );
        //转存到新的对象并按地域分类
        List<String> shCpyNames =new LinkedList<>();
        List<NaturalPersonVO> shangHaiList =new LinkedList<>();
        List<NaturalPersonVO> otherList =new LinkedList<>();
        for ( CompanySearch2DO.Rdata rd : csList ) {
            NaturalPersonVO npv =new NaturalPersonVO();
            npv.setNalName(nalName);
            if( StringUtils.isBlank(rd.getCompany_name()) )
                continue;
            npv.setRelatedCompany(rd.getCompany_name());
            boolean isPosition =false;
            if ( StringUtils.isNotBlank(rd.getFrname()) && rd.getFrname().equals(nalName) && ! type.equals("baxx") ) {
                npv.setPosition("法人代表");
                isPosition =true;
            }
            if ( !isPosition && ! type.equals("gdxx")  ) {
                List<String> djg =rd.getBaxx();
                if ( null !=djg ) {
                    for (String name : djg) {
                        if (  StringUtils.isNotBlank(name) && name.equals(nalName) ) {
                            npv.setPosition("董监高");
                            isPosition =true; break;
                        }
                    }
                }
            }
            if ( ! isPosition ) { //没有匹配到企业法人或董监高，此条数据丢弃
                continue;
            }
            npv.setEsDate(rd.getEsdate());
            npv.setFrName(rd.getFrname());
            npv.setRegCapital(rd.getRegcap());
            npv.setRegAddress(rd.getAddress());
            if( StringUtils.isNotBlank(rd.getProvince()) && rd.getProvince().equals("上海市") ) {
                shangHaiList.add(npv);
                shCpyNames.add(rd.getCompany_name());
            } else {
                otherList.add(npv);
                npv.setRange("全国");
            }
        }
        //分类排序类金融
        Date start =new Date();
        List<String> kindredFinanceCpyNames =new LinkedList<>();
        if(  shCpyNames.size() >0) {
            kindredFinanceCpyNames = companyMapper.findKindredFinanceCompanyNameByCompanyName(shCpyNames);
        }
        long dltSec =(new Date()).getTime() -start.getTime();
        //logger.info("findKindredFinanceCompanyNameByCompanyName--num[{}]--{}ms", kindredFinanceCpyNames.size(), dltSec );
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
                    npv.setRange("类金融企业");
                } else {
                    noKindredFinances.add(npv);
                    npv.setRange("上海市");
                }
            }
            shangHaiList =kindredFinances; //替换成类金融企业
            shangHaiList.addAll(noKindredFinances); //加入非类金融企业
        } else {
            for (NaturalPersonVO npv : shangHaiList) {
                npv.setRange("上海市");
            }
        }
        if ( ! isProvince ) {
            shangHaiList.addAll(otherList); //加入非上海的企业
        }
        return shangHaiList;
    }*/

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

}
