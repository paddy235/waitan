package com.bbd.bgo.service.imp.handler.assist;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.IndustryCodeDO;
import com.bbd.wtyh.excel.imp.entity.ImportError;
import com.bbd.wtyh.excel.imp.entity.Sheet;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.CompanyStatusChangeService;
import com.bbd.wtyh.service.HologramQueryService;
import com.bbd.wtyh.service.impl.CompanyServiceImpl;
import com.bbd.wtyh.util.ApplicationContextUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by Administrator on 2017/7/28.
 */
public class CompanyImportAssist {
    private List<ImportError> errList;
    private Sheet sheet;
    private List< Map.Entry<CompanyDO, BaseDataDO.Results> > insertList =new LinkedList<>();
    private List< Map.Entry<CompanyDO, BaseDataDO.Results> > updateList =new LinkedList<>();
    private CompanyService companyService = ApplicationContextUtil.getBean(CompanyServiceImpl.class);
    private HologramQueryService hologramQueryService = ApplicationContextUtil.getBean(HologramQueryService.class);
    private AreaService areaService = ApplicationContextUtil.getBean(AreaService.class);
    private CompanyStatusChangeService companyStatusChangeService =ApplicationContextUtil.getBean(CompanyStatusChangeService.class);

    /**
     *
     * @param errList 来自AbstractImportHandler的errorList();
     * @param sheet 来自AbstractImportHandler的getSheet();
     */
    public CompanyImportAssist(List<ImportError> errList, Sheet sheet) {
        this.errList = errList;
        this.sheet = sheet;
    }

    public List<Map.Entry<CompanyDO, BaseDataDO.Results>> getInsertList() {
        return insertList;
    }

    public List<Map.Entry<CompanyDO, BaseDataDO.Results>> getUpdateList() {
        return updateList;
    }

    public List< Map.Entry<CompanyDO, BaseDataDO.Results> > getResultList() {
        List< Map.Entry<CompanyDO, BaseDataDO.Results> > rstList =getUpdateList();
        rstList.addAll( getInsertList() );
        return rstList;
    }

    private void addError(Integer rowNum, String msg)
    {
        if ( null ==rowNum ) return;
         ImportError error = new ImportError(sheet.getName(), rowNum, 0, msg);
         errList.add(error);
    }


    /**
     * 准备用于新增和更新的数据，如果对应的行有错误，同样样会标记出来
     * @param tempList 中的CompanyDo 必须包含企业名称，并通过setId(Integer id)设置行号
     *                 此方法返回时，tempList表会被清空。
     *                 insertList和updateList存放已经填充好的CompanyDo对象（可用 getResultList()取到它们拼合后的List），
     *                 其中 CompanyDo.analysisResult用于返回从库中取回的CompanyDo.riskLevel供东均使用；
     *                 同样的 CompanyDo.oldCompanyType存放的是从库中取回的CompanyDo.CompanyType供天王使用。
     */
    public void processCp( List<CompanyDO> tempList ) {

        //准备企业名称列表
        List<String> cNameLst =new LinkedList<>();
        for (CompanyDO cDo : tempList) {
            if( StringUtils.isBlank( cDo.getName() ) || cDo.getName().length() <3 || cDo.getName().length() >39) {
                addError(cDo.getId(), "企业名称格式错误");
            } else if( cDo.getCompanyType() <0 ) {
                addError(cDo.getId(), "行业类别填写错误");
            } else {
                cNameLst.add(cDo.getName());
            }
        }
        //获取批量企业信息
        List<BaseDataDO.Results> bdLst =hologramQueryService.getBbdQyxxAll(cNameLst);
        //验证企业名单是否正确
        for (CompanyDO cDo : tempList) {
            String cName =cDo.getName();
            CompanyDO locCp =companyService.getCompanyByName(cName);
            BaseDataDO.Results cInfo =null;
            for( BaseDataDO.Results rs : bdLst ) {  //搜索数据平台返回结果中是否有此企业
                if( rs.getJbxx().getCompany_name().equals(cName) ) {
                    cInfo =rs;
                    break;
                }
            }
            boolean bCrd =true;
            boolean bRegNo =true; //注册号
            if( null !=cInfo ) { //数据平台有此企业
                if( StringUtils.isNotEmpty( cDo.getCreditCode() ) && StringUtils.isNotBlank( cInfo.getJbxx().getCredit_code() ) &&
                        ! cDo.getCreditCode().equals( cInfo.getJbxx().getCredit_code() ) ) {
                    bCrd =false;
                }
                if( StringUtils.isNotEmpty( cDo.getOrganizationCode() ) && StringUtils.isNotBlank( cInfo.getJbxx().getRegno() ) &&
                        ! cDo.getOrganizationCode().equals( cInfo.getJbxx().getRegno() ) ) {
                    bCrd =false;
                }
                cDo.setOrganizationCode(null);
                if (bCrd && bRegNo) { //用数据平台数据验证成功
                    if ( null ==locCp ) { //数据库中无此企业
                        //按新增处理
                        addDataToList( true, cDo, locCp, cInfo );
                    } else { //有
                        //按更新处理
                        addDataToList( false, cDo, locCp, cInfo );
                    }
                } else { //验证失败
                    addError(cDo.getId(), "这一条导入信息有误");
                    continue;
                }
            } else { //数据平台无此企业
                cDo.setOrganizationCode(null);
                Map.Entry<CompanyDO, BaseDataDO.Results> me =new AbstractMap.SimpleEntry<>( cDo, cInfo );
                if ( null ==locCp ) { //数据库中无此企业
                    //产品确认说按新增处理
                    insertList.add(me);
                    cDo.setNeo(true);
                    cDo.setCompanyId(null);
                } else { //有
                    //产品确认按更新处理
                    updateList.add(me);
                    cDo.setNeo(false);
                    cDo.setCompanyId(locCp.getCompanyId());
                    cDo.setOldCompanyType( locCp.getCompanyType() );
                }
            }
        }
        tempList.clear();
    }

    //插入或更新、客户导入的、从本地库查询的、来自数据平台
    private void addDataToList( boolean isIns, CompanyDO impCp, CompanyDO locCp, BaseDataDO.Results bddRst ) {
        Map.Entry<CompanyDO, BaseDataDO.Results> me =new AbstractMap.SimpleEntry<>( impCp, bddRst );
        if (isIns) {//插入
            insertList.add(me);
            impCp.setNeo(true);
            impCp.setCompanyId(null);
        } else {
            updateList.add(me);
            impCp.setNeo(false);
            impCp.setCompanyId(locCp.getCompanyId());
            impCp.setOldCompanyType( locCp.getCompanyType() );//供天王使用
            impCp.setAnalysisResult( locCp.getRiskLevel() ); //供东均使用
        }
        if( StringUtils.isNotBlank( bddRst.getJbxx().getCredit_code() ) ) {
            impCp.setCreditCode(bddRst.getJbxx().getCredit_code());
        }
        if( StringUtils.isNotBlank( bddRst.getJbxx().getCompany_gis_lon() ) ) {
            impCp.setLongitude(new Double(bddRst.getJbxx().getCompany_gis_lon()));
        }
        if( StringUtils.isNotBlank( bddRst.getJbxx().getCompany_gis_lat() ) ) {
            impCp.setLatitude(new Double(bddRst.getJbxx().getCompany_gis_lat()));
        }
        if( StringUtils.isNotBlank( bddRst.getJbxx().getFrname() ) ) {
            impCp.setLegalPerson(bddRst.getJbxx().getFrname());
        }
        impCp.setAreaId( areaService.selectByCountyCodeOrProvinceName( bddRst.getJbxx().getCompany_county(),
                bddRst.getJbxx().getCompany_province() ).getAreaId() );
        if( StringUtils.isNotBlank( bddRst.getJbxx().getAddress() ) ) {
            impCp.setAddress(bddRst.getJbxx().getAddress());
        }
        /*//清洗注册资本字符串
        String regCap ="0";
        Pattern pattern =Pattern.compile("\\d+");
        Matcher matcher =pattern.matcher( bddRst.getJbxx().getRegcap() );
        if ( matcher.find() ) {
            regCap = matcher.group(); new Integer(regCap);
        }*/
        Float regA =bddRst.getJbxx().getRegcap_amount()/10000F;
        impCp.setRegisteredCapital( regA.intValue() );
        impCp.setRegisteredCapitalType( bddRst.getJbxx().getRegcap_currency().equals("美元") ? 2:1 );
        Date regDate =null;
        try {
            regDate = DateUtils.parseDate( bddRst.getJbxx().getEsdate(),"yyyy-MM-dd");
        } catch (Exception e) { }
        impCp.setRegisteredDate( regDate );
        if( StringUtils.isNotBlank( bddRst.getJbxx().getCompany_type() ) ) {
            impCp.setRegisteredType( bddRst.getJbxx().getCompany_type() );
        }
        if ( StringUtils.isNotBlank( bddRst.getJbxx().getCompany_industry() ) ) {
            impCp.setBusinessType( IndustryCodeDO.getValueByNameStr( bddRst.getJbxx().getCompany_industry() ) );
        }
        if ( StringUtils.isNotBlank( bddRst.getJbxx().getEnterprise_status() ) ) {
            impCp.setStatus( bddRst.getJbxx().getEnterprise_status().equals("注销") ? (byte)2 : (byte)1 );
        }
    }

    public void save(String loginName) {
        //update
        for ( Map.Entry<CompanyDO, BaseDataDO.Results> me : updateList ) {
            me.getKey().setUpdateBy(loginName);
            me.getKey().setUpdateDate(new Date());
            companyService.update( me.getKey() );
            //todo 以下放天王和其他同事的方法 ：
            //企业状态变化
            companyStatusChangeService.companyStatusChange(false, me.getKey(),me.getValue());
        }
        //insert
        for ( Map.Entry<CompanyDO, BaseDataDO.Results> me : insertList ) {
            me.getKey().setCreateBy(loginName);
            me.getKey().setCreateDate(new Date());
            int rst =companyService.insert( me.getKey() );
            if ( null ==me.getKey().getCompanyId() ) {
                me.getKey().setCompanyId(me.getKey().getId()); //暂时这样修复，其他类似用法的地方还没有去核实
            }
            //大尧说：插入的主键这样取: int companyId = me.getKey().getCompanyId();  不用再去查库了
            //todo 以下放天王和其他同事的方法 ：
            //企业状态变化
            companyStatusChangeService.companyStatusChange(true, me.getKey(),me.getValue());
        }

    }

    public List<ImportError> getErrList() {
        return errList;
    }
}
