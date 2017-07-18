package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.service.EasyExportExeclService;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by YanWenyuan on 2017/7/18.
 */
@Controller
@RequestMapping("/easyExportExecl")
public class EasyExportExeclController {

    @Autowired
    private EasyExportExeclService easyExportExeclService;

    @RequestMapping(value = "export")
    @ResponseBody
    public ResponseBean export(ExportCondition exportCondition) {
        // 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹
        // 7:金融 8:其他 9:交易所 10:商业保理 11.预付卡 12.典当 13融资租赁

//        if (CompanyInfo.TYPE_P2P_1 == exportCondition.getIndustry()) { // 网络借贷
//            return companyInfoModifyUtil.getWangdaiInfo(name);
//        } else if (CompanyInfo.TYPE_XD_2 == exportCondition.getIndustry()) { // 小额贷款
//            return companyInfoModifyUtil.getLoan(name);
//        } else if (CompanyInfo.TYPE_RZDB_3 == exportCondition.getIndustry()) { // 融资担保
//            return companyInfoModifyUtil.getGuarantee(name);
//        } else if (CompanyInfo.TYPE_XXLC_4 == exportCondition.getIndustry()) { // 线下理财
//            return companyInfoModifyUtil.getOffLineFinance(name);
//        } else if (CompanyInfo.TYPE_JYS_9 == exportCondition.getIndustry()) { // 交易场所
//            return companyInfoModifyUtil.getTradeMarket(name);
//        } else if (CompanyInfo.TYPE_YFK_11 == exportCondition.getIndustry()) { // 预付卡
//            return companyInfoModifyUtil.getPerpaycard(name);
//        } else if (CompanyInfo.TYPE_RZZL_13 == exportCondition.getIndustry()) { // 融资租赁
//            return companyInfoModifyUtil.getTenancy(name);
//        } else if (CompanyInfo.TYPE_SMJJ_5 == exportCondition.getIndustry()) { // 私募基金
//        } else if (CompanyInfo.TYPE_ZC_6 == exportCondition.getIndustry()) { // 众筹
//        } else if (CompanyInfo.TYPE_DD_12 == exportCondition.getIndustry()) { // 典当
//        } else if (CompanyInfo.TYPE_SYBL_10 == exportCondition.getIndustry()) { // 商业保理
//        }
//        return ResponseBean.successResponse(list);

        return null;
    }
}
