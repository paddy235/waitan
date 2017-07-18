package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.service.CompanyInfoModifyService;
import com.bbd.wtyh.web.ResponseBean;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    // 1. 网络借贷 - 暂无方案

    // 2. 小额贷款
    @RequestMapping(value = "/loan")
    @ResponseBody
    public ResponseBean loan(Integer areaId) {
        //产品提出要排序，不读库的方式，写死
        List<String> list = Lists.newArrayList("浦东新区", "黄浦区", "静安区", "徐汇区",
                "长宁区", "普陀区", "虹口区", "杨浦区",
                "宝山区", "闵行区", "嘉定区", "金山区",
                "松江区", "青浦区", "奉贤区", "崇明县");
        return ResponseBean.successResponse(list);
    }


    // 3. 融资担保
    @RequestMapping(value = "/guarantee")
    @ResponseBody
    public ResponseBean guarantee(Integer areaId) {
        //产品提出要排序，不读库的方式，写死
        List<String> list = Lists.newArrayList("浦东新区", "黄浦区", "静安区", "徐汇区",
                "长宁区", "普陀区", "虹口区", "杨浦区",
                "宝山区", "闵行区", "嘉定区", "金山区",
                "松江区", "青浦区", "奉贤区", "崇明县");
        return ResponseBean.successResponse(list);
    }

    // 4. 线下理财
    @RequestMapping(value = "/offLineFinance")
    @ResponseBody
    public ResponseBean offLineFinance(Integer areaId) {
        //产品提出要排序，不读库的方式，写死
        List<String> list = Lists.newArrayList("浦东新区", "黄浦区", "静安区", "徐汇区",
                "长宁区", "普陀区", "虹口区", "杨浦区",
                "宝山区", "闵行区", "嘉定区", "金山区",
                "松江区", "青浦区", "奉贤区", "崇明县");
        return ResponseBean.successResponse(list);
    }

    // 5. 交易场所
    @RequestMapping(value = "/tradeMarket")
    @ResponseBody
    public ResponseBean tradeMarket(Integer areaId) {
        //产品提出要排序，不读库的方式，写死
        List<String> list = Lists.newArrayList("浦东新区", "黄浦区", "静安区", "徐汇区",
                "长宁区", "普陀区", "虹口区", "杨浦区",
                "宝山区", "闵行区", "嘉定区", "金山区",
                "松江区", "青浦区", "奉贤区", "崇明县");
        return ResponseBean.successResponse(list);
    }

    // 6. 预付卡
    @RequestMapping(value = "/perpaycard")
    @ResponseBody
    public ResponseBean perpaycard(Integer areaId) {
        //产品提出要排序，不读库的方式，写死
        List<String> list = Lists.newArrayList("浦东新区", "黄浦区", "静安区", "徐汇区",
                "长宁区", "普陀区", "虹口区", "杨浦区",
                "宝山区", "闵行区", "嘉定区", "金山区",
                "松江区", "青浦区", "奉贤区", "崇明县");
        return ResponseBean.successResponse(list);
    }

    // 7. 融资租赁
    @RequestMapping(value = "/tenancy")
    @ResponseBody
    public ResponseBean tenancy(Integer areaId) {
        //产品提出要排序，不读库的方式，写死
        List<String> list = Lists.newArrayList("浦东新区", "黄浦区", "静安区", "徐汇区",
                "长宁区", "普陀区", "虹口区", "杨浦区",
                "宝山区", "闵行区", "嘉定区", "金山区",
                "松江区", "青浦区", "奉贤区", "崇明县");
        return ResponseBean.successResponse(list);
    }

    // 8. 光谱
    @RequestMapping(value = "/spectrum")
    @ResponseBody
    public ResponseBean spectrum(Integer areaId) {
        //产品提出要排序，不读库的方式，写死
        List<String> list = Lists.newArrayList("浦东新区", "黄浦区", "静安区", "徐汇区",
                "长宁区", "普陀区", "虹口区", "杨浦区",
                "宝山区", "闵行区", "嘉定区", "金山区",
                "松江区", "青浦区", "奉贤区", "崇明县");
        return ResponseBean.successResponse(list);
    }


    // 9. 定时任务
    @RequestMapping(value = "/timedTask")
    @ResponseBody
    public ResponseBean timedTask(Integer areaId) {
        //产品提出要排序，不读库的方式，写死
        List<String> list = Lists.newArrayList("浦东新区", "黄浦区", "静安区", "徐汇区",
                "长宁区", "普陀区", "虹口区", "杨浦区",
                "宝山区", "闵行区", "嘉定区", "金山区",
                "松江区", "青浦区", "奉贤区", "崇明县");
        return ResponseBean.successResponse(list);
    }
}
