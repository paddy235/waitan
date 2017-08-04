package com.bbd.wtyh.service.impl.companyInfoModify;

import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyInfoModify.LoanModify;
import com.bbd.wtyh.domain.CompanyInfoModify.OffLineModify;
import com.bbd.wtyh.domain.CompanyInfoModify.WangdaiModify;
import com.bbd.wtyh.mapper.CompanyInfoModifyMapper;
import com.bbd.wtyh.service.*;
import com.bbd.wtyh.web.companyInfoModify.ModifyData;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by YanWenyuan on 2017/7/17.
 */
@Component
public class CompanyInfoMudifyUtil {
    Logger logger = LoggerFactory.getLogger(CompanyInfoMudifyUtil.class);

    private static String TAG = "外滩线下理财企业";

    @Value("${api.appkey}")
    private String appkey;

    @Autowired
    private P2PImageService p2PImageService;    // 网络借贷

    @Autowired
    private CompanyLevelService companyLevelService;    // 小额贷款、融资担保

    @Autowired
    private RiskCompanyService riskCompanyService;  // 线下理财、交易场所

    @Autowired
    private HologramQueryService hologramQueryService;

    @Autowired
    private CompanyStatusChangeService companyStatusChangeService;//企业状态变化

    @Autowired
    private CompanyInfoModifyMapper companyInfoModifyMapper;


    @Autowired
    private CompanyInfoQueryUtil companyInfoQueryUtil;


    /**
     * 网络借贷 风险等级
     *
     * @param modifyData
     */
    public void modifyWangdai(ModifyData modifyData) throws Exception {
        CompanyInfo wangdai = companyInfoQueryUtil.getWangdaiInfo(modifyData.getName());
        WangdaiModify wangdaiModify = new WangdaiModify();
        wangdaiModify.setName(modifyData.getName());
        wangdaiModify.setPlatName(wangdai.getPlatName());
        wangdaiModify.setBeforeLevel(wangdai.getCurrentLevel());
        wangdaiModify.setAfterLevel(modifyData.getLevel());
        wangdaiModify.setBeforeIndustry(CompanyInfo.TYPE_P2P_1);
        // 记录行为
        p2PImageService.recordWangdai(wangdaiModify);
        // 修改风险等
        riskCompanyService.modifyLevel(modifyData.getName(), wangdaiModify.getConvertAfterLevel());
        // 修改行业
        modifyIndustry(modifyData.getName(), modifyData.getIndustry());
    }

    /**
     * 小额贷款、融资担保 风险等级
     *
     * @param modifyData
     */
    public void modifyLoad(ModifyData modifyData) throws Exception {
        CompanyInfo companyInfo = companyInfoQueryUtil.getLoan(modifyData.getName());
        LoanModify loanModify = new LoanModify();
        loanModify.setName(companyInfo.getName());
        loanModify.setBeforeOutLevel(companyInfo.getOutLevel());
        loanModify.setBeforeInnnerLevel(companyInfo.getInnnerLevel());
        loanModify.setBeforeLiveLevel(companyInfo.getLiveLevel());
        loanModify.setAfterOutLevel(modifyData.getOutLevel());
        loanModify.setAfterInnnerLevel(modifyData.getInnnerLevel());
        loanModify.setAfterLiveLevel(modifyData.getLiveLevel());
        loanModify.setBeforeIndustry(CompanyInfo.TYPE_XD_2);
        // 记录行为
        companyLevelService.recordLoad(loanModify);
        companyLevelService.modifyLoad(loanModify);
        // 修改行业
        modifyIndustry(modifyData.getName(), modifyData.getIndustry());
    }

    /**
     * 线下理财、交易场所、预付卡、融资租赁 风险等级
     *
     * @param modifyData
     * @return
     */
    public void modifyOffLine(ModifyData modifyData) throws Exception {
        CompanyInfo companyInfo = companyInfoModifyMapper.queryCompany(modifyData.getName());
        OffLineModify offLineModify = new OffLineModify();
        offLineModify.setName(companyInfo.getName());
        offLineModify.setBeforeLevel(companyInfo.getCurrentLevel());
        offLineModify.setAfterLevel(modifyData.getLevel());
        offLineModify.setBeforeIndustry(CompanyInfo.TYPE_XXLC_4);
        // 记录行为
        riskCompanyService.recordOffLine(offLineModify);
        riskCompanyService.modifyOffLine(offLineModify);
        // 修改行业
        modifyIndustry(modifyData.getName(), modifyData.getIndustry());
    }

    /**
     * 修改行业
     *
     * @param name
     * @param industry
     * @throws Exception
     */
    public void modifyIndustry(String name, String industry) throws Exception {
        // 修改行业
        if (StringUtils.isEmpty(industry)) {
            return;
        }
        // 记录企业状态变化-放在修改之前，因为要记录修改前的类型
        companyStatusChangeService.companyStatusChange(false, name, Byte.valueOf(industry));
        // 修改company的行业类型
        riskCompanyService.modifyIndustry(name, industry);
        // 判断是否修改为线下理财
        if (!String.valueOf(CompanyInfo.TYPE_XXLC_4).equals(industry)) {
            // 通知数据平台的api
            //addTagWhite(name);
        }
    }

//    private void addTagWhite(String companyName) throws Exception {
//        String  url= null;//http://dataapi.bbdservice.com/api/add_tag_white/?tag=
//        if(null==url){
//            return;
//        }
//        StringBuffer sb = new StringBuffer();
//        sb.append(url + TAG + "&appkey=")
//                .append(appkey)
//                .append("&company_name=")
//                .append(companyName)
//                .append("&bbd_qyxx_id=")
//                .append(getQyxxid(companyName));
//        try {
//            String result = new HttpTemplate().get(sb.toString());
//            JSONObject jsonObject = JSONObject.fromObject(result);
//            String message = jsonObject.getString("message");
//            if (!"ok".equalsIgnoreCase(message)) {
//                logger.error("线下理财名单数据上传错误，错误公司：" + companyName + "错误原因：" + message);
//                throw new Exception("修改行业类型失败：线下理财名单数据上传错误");
//            }
//        } catch (Exception e) {
//            logger.error("线下理财名单数据上传错误，错误公司：" + companyName + "错误原因：" + e);
//            throw new Exception("修改行业类型失败：线下理财名单数据上传错误");
//        }
//    }
//
//    private String getQyxxid(String companyName) throws Exception {
//        Map batchData = hologramQueryService.getBbdQyxxBatch(companyName);
//        if (CollectionUtils.isEmpty(batchData)) {
//            throw new Exception("修改行业类型失败：接口查询错误");
//        }
//        String msg = (String) (batchData.get("msg"));
//        if (null == msg || !msg.equals("ok")) {
//            throw new Exception("修改行业类型失败：接口查询错误");
//        }
//        List<Map> rList = (List) (batchData.get("results"));
//        if (CollectionUtils.isEmpty(rList)) {
//            throw new Exception("修改行业类型失败：接口未查询到对应数据");
//        }
//        String qyxx_id = "";
//        for (Map itr1 : rList) {
//            Map itr = (Map) (itr1.get("jbxx"));
//            qyxx_id = (String) (itr.get("qyxx_id"));
//        }
//        return qyxx_id;
//    }
}
