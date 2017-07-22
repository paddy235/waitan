package com.bbd.bgo.service.imp.handler;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.IndustryCodeDO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.HologramQueryService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cgj on 2017/7/19.
 */

@Component
@Scope("prototype") //非单例模式
public class CompanyListHandler extends AbstractImportHandler<CompanyDO> {

    private Logger log = LoggerFactory.getLogger(CompanyLevelHandler.class);
    @Autowired
    private CompanyService companyService;

    @Autowired
    private HologramQueryService hologramQueryService;

    @Autowired
    private AreaService areaService;

    private List< Map.Entry<CompanyDO, BaseDataDO.Results> > insertList = null;
    private List< Map.Entry<CompanyDO, BaseDataDO.Results> > updateList = null;
    private List<CompanyDO> tempList = null;
    String loginName ="";



    //@Transactional //事务--原子性操作
    @Override
    public void start(HttpServletRequest request) throws Exception {
        loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        if( null ==loginName ) {
            loginName ="";
        }
        //Object ob= request.getHeaderNames();
        log.info("开始导入企业名单");
        insertList = new ArrayList<>();
        updateList = new ArrayList<>();
        tempList = new LinkedList<>();
    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {
        int aa =row.size();
    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {
        String companyName =row.get("name");
        if( StringUtils.isBlank( companyName ) || companyName.length() <3 ) {
            addError("企业名称无效");
            return false;
        }
        String creditCode =row.get("creditCode");
        if( StringUtils.isNotEmpty( creditCode ) || creditCode.matches("^([A-Z]|[0-9]){18}$") ) {
            addError("统一信用代码格式错误");
            return false;
        }
        String organizationCode =row.get("organizationCode");
        if( StringUtils.isNotEmpty( organizationCode ) || !organizationCode.matches("^([0-9]){15}$") ) {
            addError("注册号格式错误"); //原组织机构代码变更成验证注册号
            return false;
        }
        return true;
    }

    //BusinessException()
    @Override
    public void endRow(Map<String, String> row, CompanyDO bean) throws Exception {
        bean.setId(getRowNumber()); //将行号存下
        tempList.add(bean);
        if( tempList.size() <200 ) {
            return;
        }
        processCp( );
        tempList =new LinkedList<>(); //列表清零
    }

    @Override
    public void end() throws Exception {
        if ( tempList.size() >0 ) {
            //有企业没有处理完
            processCp( );
        }
        if( errorList().size() <1 ) {
            //导入的数据有错，不予入库
            return;
        }
        //update
        for ( Map.Entry<CompanyDO, BaseDataDO.Results> me : updateList ) {
            me.getKey().setUpdateBy(loginName);
            me.getKey().setUpdateDate(new Date());
            companyService.update( me.getKey() );
            //todo 以下放天王和其他同事的方法 ：
            //me.getValue()
        }
        //insert
        for ( Map.Entry<CompanyDO, BaseDataDO.Results> me : insertList ) {
            me.getKey().setCreateBy(loginName);
            me.getKey().setCreateDate(new Date());
            companyService.insert( me.getKey() );
            //todo 以下放天王和其他同事的方法 ：
            //me.getValue()
        }
    }


    private void processCp( ) {

        //准备企业名称列表
        List<String> cNameLst =new LinkedList<>();
        for (CompanyDO cDo : tempList) {
            cNameLst.add(cDo.getName());
        }
        //获取批量企业信息
        List<BaseDataDO.Results> bdLst =hologramQueryService.getBbdQyxxAll(cNameLst);
        //验证企业名单是否正确
        for (CompanyDO cDo : tempList) {
            String cName =cDo.getName();
            CompanyDO locCp =companyService.getCompanyByName(cName);
            BaseDataDO.Results cInfo =null;
            for( BaseDataDO.Results rs : bdLst ) {
                if( rs.getJbxx().getCompany_name().equals(cName) ) {
                    cInfo =rs;
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
                if ( null ==locCp ) { //数据库中无此企业
                    //todo 此企业可能不存在，可判为错误名称的企业，或新增（只能写入企业名称、统一代码和行业类别），待产品确认
                    /*addError(cDo.getId(), "此企业不存在！");
                    continue;*/
                } else { //有
                    //todo 数据平台查询不到基本信息，只能更新用户提供的统一信用代码和行业类别，待产品确认
                }
            }
        }
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
        Float regA =bddRst.getJbxx().getRegcap_amount()/1000F;
        impCp.setRegisteredCapital( regA.intValue() );
        impCp.setRegisteredCapitalType( bddRst.getJbxx().getRegcap_currency().equals("美元") ? 2:1 );
        Date regDate =null;
        try {
            regDate =DateUtils.parseDate( bddRst.getJbxx().getEsdate(),"yyyy-MM-dd");
        } catch (Exception e) { }
        impCp.setRegisteredDate( regDate );
        if( StringUtils.isNotBlank( bddRst.getJbxx().getCompany_type() ) ) {
            impCp.setRegisteredType( bddRst.getJbxx().getCompany_type() );
        }
        impCp.setCompanyType( CompanyDO.companyType( impCp.getComTypeCnItself() ) );
        if ( StringUtils.isNotBlank( bddRst.getJbxx().getCompany_industry() ) ) {
            impCp.setBusinessType( IndustryCodeDO.getValueByNameStr( bddRst.getJbxx().getCompany_industry() ) );
        }
        if ( StringUtils.isNotBlank( bddRst.getJbxx().getEnterprise_status() ) ) {
            impCp.setStatus( bddRst.getJbxx().getEnterprise_status().equals("注销") ? (byte)2 : (byte)1 );
        }
    }

    @Override
    public void exception(Exception e) {
        addError("服务器异常：" + e.getMessage());
        e.printStackTrace();

    }
}
