package com.bbd.bgo.web.controller;

import com.bbd.wtyh.constants.JYSCoRiskLevel;
import com.bbd.wtyh.constants.PrepaidCoRiskLevel;
import com.bbd.wtyh.constants.RZZLCoRiskLevel;
import com.bbd.wtyh.domain.CompanyAnalysisResultDO;
import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.enums.CompanyLevel;
import com.bbd.wtyh.domain.enums.WangDaiRiskLevel;
import com.bbd.wtyh.service.CompanyInfoModifyService;
import com.bbd.wtyh.util.DateUtils;
import com.bbd.wtyh.web.ResponseBean;
import com.bbd.wtyh.web.companyInfoModify.ModifyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YanWenyuan on 2017/7/13.
 */
@Controller
@RequestMapping("/companyInfoModify")
public class CompanyInfoModifyController {

    @Autowired
    private CompanyInfoModifyService companyInfoModify;

    // 0. 自动补全公司名
    @RequestMapping(value = "/autoComplete")
    @ResponseBody
    public ResponseBean autoComplete(String q) {
        List<String> rst = companyInfoModify.autoComplete(q);
        return ResponseBean.successResponse(rst);
    }

    // 1. 搜索公司
    @RequestMapping(value = "/queryCompany")
    @ResponseBody
    public ResponseBean queryCompany(String name) {
        CompanyInfo rst = companyInfoModify.queryCompany(name);
        if (null == rst) {
            return ResponseBean.errorResponse("未找到公司");
        }
        CompanyAnalysisResultDO comAna = companyInfoModify.queryCompanyAnalysisResultDO(rst.getCompanyId());
        if(null!=comAna&&null!=comAna.getExposureDate()){
            rst.setExposureDate(comAna.getExposureDate());
        }
        return ResponseBean.successResponse(rst);
    }

    // 2. 修改公司 - 风险等级
    @RequestMapping(value = "/modify")
    @ResponseBody
    public ResponseBean modify(ModifyData modifyData,String exDate) {
        try {
            modifyData.setExposureDate(DateUtils.stringToDateYmd(exDate));
            companyInfoModify.modify(modifyData, "企业信息变更");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse(e.getMessage());
        }
        return ResponseBean.successResponse("修改成功");
    }

    // 3. 风险 列表
    @RequestMapping(value = "/risk")
    @ResponseBody
    public ResponseBean risk() {
        Map<Byte, Map> rst = new HashMap<>();
        // "网络借贷"
        rst.put(CompanyInfo.TYPE_P2P_1, WangDaiRiskLevel.getMap());
        // "小额贷款"
        rst.put(CompanyInfo.TYPE_XD_2, CompanyLevel.getMap());
        // "融资担保"
        rst.put(CompanyInfo.TYPE_RZDB_3, CompanyLevel.getMap());
        // "线下理财"
        Map<String, Integer> offLine = JYSCoRiskLevel.getMap();
        rst.put(CompanyInfo.TYPE_XXLC_4, offLine);
        //  "私募基金"
        rst.put(CompanyInfo.TYPE_SMJJ_5, offLine);
        //  "众筹"
        rst.put(CompanyInfo.TYPE_ZC_6, offLine);
        //  "交易场所"
        rst.put(CompanyInfo.TYPE_JYS_9, offLine);
        //  "商业保理"
        rst.put(CompanyInfo.TYPE_SYBL_10, offLine);
        //  "典当"
        rst.put(CompanyInfo.TYPE_DD_12, offLine);
        //  "预付卡"
        rst.put(CompanyInfo.TYPE_YFK_11, PrepaidCoRiskLevel.getMap());
        // "融资租赁"
        rst.put(CompanyInfo.TYPE_RZZL_13, RZZLCoRiskLevel.getMap());
        // "金融"
        rst.put(CompanyInfo.TYPE_JR_7, RZZLCoRiskLevel.getMap());
        // "其他"
        rst.put(CompanyInfo.TYPE_QT_8, RZZLCoRiskLevel.getMap());
        // "外滩网络借贷"
        rst.put(CompanyInfo.TYPE_WT_30, RZZLCoRiskLevel.getMap());
        // "外滩众筹"
        rst.put(CompanyInfo.TYPE_WT_31, RZZLCoRiskLevel.getMap());
        // "外滩网银"
        rst.put(CompanyInfo.TYPE_WT_32, RZZLCoRiskLevel.getMap());
        // "外滩支付"
        rst.put(CompanyInfo.TYPE_WT_33, RZZLCoRiskLevel.getMap());
        // "外滩预付卡"
        rst.put(CompanyInfo.TYPE_WT_34, RZZLCoRiskLevel.getMap());
        // "外滩融资租赁"
        rst.put(CompanyInfo.TYPE_WT_35, RZZLCoRiskLevel.getMap());
        return ResponseBean.successResponse(rst);
    }

    // 4. 行业类型 列表
    @RequestMapping(value = "/industry")
    @ResponseBody
    public ResponseBean industry() {
        Map<String, Byte> rst = new HashMap<>();
        rst.put("网络借贷", CompanyInfo.TYPE_P2P_1);
        rst.put("小额贷款", CompanyInfo.TYPE_XD_2);
        rst.put("融资担保", CompanyInfo.TYPE_RZDB_3);
        rst.put("线下理财", CompanyInfo.TYPE_XXLC_4);
        rst.put("私募基金", CompanyInfo.TYPE_SMJJ_5);
        rst.put("众筹", CompanyInfo.TYPE_ZC_6);
        rst.put("典当", CompanyInfo.TYPE_DD_12);
        rst.put("交易场所", CompanyInfo.TYPE_JYS_9);
        rst.put("预付卡", CompanyInfo.TYPE_YFK_11);
        rst.put("融资租赁", CompanyInfo.TYPE_RZZL_13);
        rst.put("商业保理", CompanyInfo.TYPE_SYBL_10);
        rst.put("金融", CompanyInfo.TYPE_JR_7);
        rst.put("其他", CompanyInfo.TYPE_QT_8);
        rst.put("外滩网络借贷", CompanyInfo.TYPE_WT_30);
        rst.put("外滩众筹", CompanyInfo.TYPE_WT_31);
        rst.put("外滩网银", CompanyInfo.TYPE_WT_32);
        rst.put("外滩支付", CompanyInfo.TYPE_WT_33);
        rst.put("外滩预付卡", CompanyInfo.TYPE_WT_34);
        rst.put("外滩融资租赁", CompanyInfo.TYPE_WT_35);
        return ResponseBean.successResponse(rst);
    }

    // 5. 公司是否被修改过
    @RequestMapping(value = "/isModify")
    @ResponseBody
    public ResponseBean isModify(String name) {
        return ResponseBean.successResponse(companyInfoModify.isModify(name));
    }
}
