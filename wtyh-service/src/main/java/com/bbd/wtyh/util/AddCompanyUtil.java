package com.bbd.wtyh.util;

import java.math.BigDecimal;
import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.IndustryCodeDO;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.CompanyStatusChangeService;
import com.bbd.wtyh.service.HologramQueryService;
import com.bbd.wtyh.service.impl.CompanyServiceImpl;

/**
 * Created by Administrator on 2017/7/28.
 */
public class AddCompanyUtil {

    private List<Map.Entry<CompanyDO, BaseDataDO.Results>> insertList = new LinkedList<>();
    private Map<String, String> companyNames = new HashMap(); // 用于判断企业名称是否重复
    private CompanyService companyService = ApplicationContextUtil.getBean(CompanyServiceImpl.class);
    private HologramQueryService hologramQueryService = ApplicationContextUtil.getBean(HologramQueryService.class);
    private AreaService areaService = ApplicationContextUtil.getBean(AreaService.class);
    private CompanyStatusChangeService companyStatusChangeService = ApplicationContextUtil.getBean(CompanyStatusChangeService.class);

    /**
    
     */
    public AddCompanyUtil() {
    }

    public List<Map.Entry<CompanyDO, BaseDataDO.Results>> getInsertList() {
        return insertList;
    }


    /**
     * 准备用于新增和更新的数据，如果对应的行有错误，同样样会标记出来
     * 
     * @param tempList
     *            中的CompanyDo 必须包含企业名称，并通过setId(Integer id)设置行号
     *            此方法返回时，tempList表会被清空。
     *            insertList和updateList存放已经填充好的CompanyDo对象（可用
     *            getResultList()取到它们拼合后的List）， 其中
     *            CompanyDo.analysisResult用于返回从库中取回的CompanyDo.riskLevel供东均使用；
     *            同样的
     *            CompanyDo.oldCompanyType存放的是从库中取回的CompanyDo.CompanyType供天王使用。
     */


    public void processCp(List<CompanyDO> tempList) {

        if (null == tempList) {
            return;
        }
        companyNames.clear();
        // 准备企业名称列表
        List<String> cNameLst = new LinkedList<>();
        for (CompanyDO cDo : tempList) {
            boolean noErr = true;
            if (StringUtils.isBlank(cDo.getName()) || cDo.getName().length() < 3 || cDo.getName().length() > 40) {
                // "企业名称格式错误"
                noErr = false;
            }
            // 验证重复企业名称
            if (companyNames.containsKey(cDo.getName())) {
                // 此处企业名称重复与前面有重复
                noErr = false;
            } else {
                companyNames.put(cDo.getName(), cDo.getName());
            }
            if (cDo.getCompanyType() < 0) {
                //行业类别填写错误
                noErr = false;
            }
            if (noErr) {
                cNameLst.add(cDo.getName());
            }
        }
        // 获取批量企业信息
        List<BaseDataDO.Results> bdLst = hologramQueryService.getBbdQyxxAll(cNameLst);
        // 验证企业名单是否正确
        for (CompanyDO cDo : tempList) {
            String cName = cDo.getName();
            CompanyDO locCp = companyService.getCompanyByName(cName);
            BaseDataDO.Results cInfo = null;
            for (BaseDataDO.Results rs : bdLst) {
                // 搜索数据平台返回结果中是否有此企业
                if (rs.getJbxx().getCompany_name().equals(cName)) {
                    cInfo = rs;
                    break;
                }
            }
            if (null != cInfo) {
                // 数据平台有此企业
                if (null == locCp) { // 数据库中无此企业
                    // 按新增处理
                    addDataToList(true, cDo, null, cInfo);
                }

            } else {
                // 数据平台无此企业
                Map.Entry<CompanyDO, BaseDataDO.Results> me = new AbstractMap.SimpleEntry<>(cDo, null);
                if (null == locCp) { // 数据库中无此企业
                    // 产品确认说按新增处理
                    insertList.add(me);
                    cDo.setNeo(true);
                    cDo.setCompanyId(null);
                }
            }
        }
        tempList.clear();
    }

    // 插入或更新、客户导入的、从本地库查询的、来自数据平台
    private void addDataToList(boolean isIns, CompanyDO impCp, CompanyDO locCp, BaseDataDO.Results bddRst) {
        Map.Entry<CompanyDO, BaseDataDO.Results> me = new AbstractMap.SimpleEntry<>(impCp, bddRst);
        if (isIns) {// 插入
            insertList.add(me);
            impCp.setNeo(true);
            impCp.setCompanyId(null);
            // 只有客户没有填写统一信用代码时，才使用BBD数据平台的统一信用代码
            if (StringUtils.isBlank(impCp.getCreditCode()) && StringUtils.isNotBlank(bddRst.getJbxx().getCredit_code())) {
                impCp.setCreditCode(bddRst.getJbxx().getCredit_code());
            }
        }
        if (StringUtils.isNotBlank(bddRst.getJbxx().getCompany_gis_lon())) {
            impCp.setLongitude(new Double(bddRst.getJbxx().getCompany_gis_lon()));
        }
        if (StringUtils.isNotBlank(bddRst.getJbxx().getCompany_gis_lat())) {
            impCp.setLatitude(new Double(bddRst.getJbxx().getCompany_gis_lat()));
        }
        if (StringUtils.isNotBlank(bddRst.getJbxx().getFrname())) {
            impCp.setLegalPerson(bddRst.getJbxx().getFrname());
        }
        impCp.setAreaId(
                areaService.selectByCountyCodeOrProvinceName(bddRst.getJbxx().getCompany_county(), bddRst.getJbxx().getCompany_province())
                        .getAreaId());
        if (StringUtils.isNotBlank(bddRst.getJbxx().getAddress())) {
            impCp.setAddress(bddRst.getJbxx().getAddress());
        }

        if (null != bddRst.getJbxx().getRegcap_amount()) {
            BigDecimal regA = BigDecimal.valueOf(bddRst.getJbxx().getRegcap_amount());
            regA = regA.divide(BigDecimal.valueOf(10000D), 0, BigDecimal.ROUND_HALF_UP);
            impCp.setRegisteredCapital(regA.intValue());
        }
        String currency = bddRst.getJbxx().getRegcap_currency();
        if (null != currency) {
            impCp.setRegisteredCapitalType(bddRst.getJbxx().getRegcap_currency().equals("美元") ? 2 : 1);
        }
        Date regDate = null;
        try {
            regDate = DateUtils.parseDate(bddRst.getJbxx().getEsdate(), "yyyy-MM-dd");
        } catch (Exception e) {
        }
        impCp.setRegisteredDate(regDate);
        if (StringUtils.isNotBlank(bddRst.getJbxx().getCompany_type())) {
            impCp.setRegisteredType(bddRst.getJbxx().getCompany_type());
        }
        if (StringUtils.isNotBlank(bddRst.getJbxx().getCompany_industry())) {
            impCp.setBusinessType(IndustryCodeDO.getValueByNameStr(bddRst.getJbxx().getCompany_industry()));
        }
        if (StringUtils.isNotBlank(bddRst.getJbxx().getEnterprise_status())) {
            impCp.setStatus(bddRst.getJbxx().getEnterprise_status().equals("注销") ? (byte) 2 : (byte) 1);
        }
    }

    public void saveForNewSource(String loginName) {
        // insert
        for (Map.Entry<CompanyDO, BaseDataDO.Results> me : insertList) {
            me.getKey().setCreateBy(loginName);
            me.getKey().setCreateDate(new Date());
            int rst = companyService.insert(me.getKey());
            if (null == me.getKey().getCompanyId()) {
                me.getKey().setCompanyId(me.getKey().getId()); // 暂时这样修复，其他类似用法的地方还没有去核实
            }
            // 企业状态变化
            companyStatusChangeService.companyStatusChangeForNewSource(true, me.getKey(), me.getValue());
        }

    }

    public void clearList() {
        insertList.clear();
    }

}
