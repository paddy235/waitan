package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.enums.CompanyLevel;
import com.bbd.wtyh.service.CompanyInfoModifyService;
import com.bbd.wtyh.web.ResponseBean;
import com.bbd.wtyh.web.companyInfoModify.ModifyData;
import org.apache.commons.collections.map.HashedMap;
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
        return ResponseBean.successResponse(rst);
    }

    // 2. 修改公司 - 风险等级
    @RequestMapping(value = "/modify")
    @ResponseBody
    public ResponseBean modify(ModifyData modifyData) {
        try {
            companyInfoModify.modify(modifyData);
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
        Map<String, String> wangdai = new HashedMap();
        wangdai.put("A", "优良");
        wangdai.put("B", "一般关注");
        wangdai.put("C", "重点关注");
        wangdai.put("D", "问题及停业平台");
        rst.put(CompanyInfo.TYPE_P2P_1, wangdai);
//        // "小额贷款"
        rst.put(CompanyInfo.TYPE_XD_2, CompanyLevel.getMap());
//        // "融资担保"
        rst.put(CompanyInfo.TYPE_RZDB_3, CompanyLevel.getMap());
//        // "线下理财"
        Map<String, Integer> offLine = new HashedMap();
        offLine.put("已出风险", 1);
        offLine.put("重点关注", 2);
        offLine.put("一般关注", 3);
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


    // 4. 行业类型 列表
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

    // 5. 公司是否被修改过
    @RequestMapping(value = "/isModify")
    @ResponseBody
    public ResponseBean isModify(String name) {
        return ResponseBean.successResponse(companyInfoModify.isModify(name));
    }
}
