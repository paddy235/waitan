package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.enums.CompanyLevel;
import com.bbd.wtyh.service.CompanyInfoModifyService;
import com.bbd.wtyh.web.ResponseBean;
import com.bbd.wtyh.web.companyInfoModify.ModifyData;
import com.google.common.collect.Lists;
import org.apache.commons.collections.map.HashedMap;
import org.docx4j.wml.R;
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

    // 0. 搜索公司
    @RequestMapping(value = "/autoComplete")
    @ResponseBody
    public ResponseBean autoComplete(String q) {
        List<String> rst = companyInfoModify.autoComplete(q);
        return ResponseBean.successResponse(rst);
    }

    // 0. 搜索公司
    @RequestMapping(value = "/queryCompany")
    @ResponseBody
    public ResponseBean queryCompany(String name) {
        CompanyInfo rst = companyInfoModify.queryCompany(name);
        if (null == rst) {
            return ResponseBean.errorResponse("未找到公司");
        }
        return ResponseBean.successResponse(rst);
    }

    // 0. 修改公司 - 风险等级
    @RequestMapping(value = "/modify")
    @ResponseBody
    public ResponseBean modify(ModifyData modifyData) {
        CompanyInfo rst = null;
        try {
            rst = companyInfoModify.modifyLevel(modifyData);
        } catch (Exception e) {
            return ResponseBean.errorResponse(e.getMessage());
        }
        if (null == rst) {
            return ResponseBean.errorResponse("未找到公司");
        }
        return ResponseBean.successResponse(rst);
    }

    /**
     * 1. 网络借贷：正常4，一般关注3，重点关注2，问题1
     *
     * 2. 小额贷款： Enum类
     *   AAA_p("AAA+"), AAA("AAA"), AAA_m("AAA-"),
     AA_p("AA+"), AA("AA"), AA_m("AA-"),
     A_p("A+"), A("A"), A_m("A-"),
     BBB_p("BBB+"), BBB("BBB"), BBB_m("BBB-"),
     BB_p("BB+"), BB("BB"), BB_m("BB-"),
     B_p("B+"), B("B"), B_m("B-"),
     CCC_p("CCC+"), CCC("CCC"), CCC_m("CCC-"),
     CC_p("CC+"), CC("CC"), CC_m("CC-"),
     C_p("C+"), C("C"), C_m("C-"),
     D("D");
     */
    // 风险
    @RequestMapping(value = "/risk")
    @ResponseBody
    public ResponseBean risk() {
        Map<Byte, Map<String, Integer>> rst = new HashMap<>();
        // "网络借贷"
        Map<String, Integer> wangdai = new HashedMap();
        wangdai.put("正常",  4);
        wangdai.put("一般关注",  3);
        wangdai.put("重点关注",  2);
        wangdai.put("问题", 1);
        rst.put(CompanyInfo.TYPE_P2P_1, wangdai);
//        // "小额贷款"
        rst.put(CompanyInfo.TYPE_XD_2, CompanyLevel.getMap());
//        // "融资担保"
        rst.put(CompanyInfo.TYPE_RZDB_3, CompanyLevel.getMap());
//        // "线下理财"
        Map<String, Integer> offLine = new HashedMap();
        offLine.put("已出风险",  1);
        offLine.put("重点关注",  2);
        offLine.put("一般关注",  3);
        offLine.put("正常", 4);
        rst.put(CompanyInfo.TYPE_XXLC_4, offLine);
//        // "交易场所"
        rst.put(CompanyInfo.TYPE_JYS_9, offLine);
//        // "预付卡"
        rst.put(CompanyInfo.TYPE_YFK_11, offLine);
//        // "融资租赁"
        rst.put(CompanyInfo.TYPE_RZZL_13, offLine);
        return ResponseBean.successResponse(rst);
    }


    // 行业类型
    @RequestMapping(value = "/industry")
    @ResponseBody
    public ResponseBean industry() {
        Map<String, Byte> rst = new HashMap<>();
        rst.put("网络借贷", CompanyInfo.TYPE_P2P_1);
        rst.put("小额贷款", CompanyInfo.TYPE_XD_2);
        rst.put("融资担保", CompanyInfo.TYPE_RZDB_3);
        rst.put("线下理财", CompanyInfo.TYPE_XXLC_4);
        rst.put("交易场所", CompanyInfo.TYPE_JYS_9);
        rst.put("预付卡", CompanyInfo.TYPE_YFK_11);
        rst.put("融资租赁", CompanyInfo.TYPE_RZZL_13);
        return ResponseBean.successResponse(rst);
    }
}
