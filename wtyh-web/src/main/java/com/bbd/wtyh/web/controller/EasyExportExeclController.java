package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.excel.ExportExcel;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.UserLogRecord;
import com.bbd.wtyh.service.EasyExportExeclService;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by YanWenyuan on 2017/7/18.
 */
@Controller
@RequestMapping("/easyExportExecl")
public class EasyExportExeclController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EasyExportExeclController.class);

    @Autowired
    private EasyExportExeclService easyExportExeclService;

    @RequestMapping(value = "export")
    @ResponseBody
    public ResponseBean export(ExportCondition exportCondition, HttpServletRequest request) {
        // 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹
        // 7:金融 8:其他 9:交易所 10:商业保理 11.预付卡 12.典当 13融资租赁

        if (CompanyInfo.TYPE_P2P_1 == exportCondition.getIndustry()) { // 网络借贷
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getWangdai(exportCondition),
                            "网络借贷", request
                    ));
        } else if (CompanyInfo.TYPE_XD_2 == exportCondition.getIndustry()) { // 小额贷款
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getLoan(exportCondition),
                            "小额贷款", request
                    ));
        } else if (CompanyInfo.TYPE_RZDB_3 == exportCondition.getIndustry()) { // 融资担保
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getGuarantee(exportCondition),
                            "融资担保", request
                    ));
        } else if (CompanyInfo.TYPE_XXLC_4 == exportCondition.getIndustry()) { // 线下理财
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getOffLineFinance(exportCondition),
                            "线下理财", request
                    ));
        } else if (CompanyInfo.TYPE_JYS_9 == exportCondition.getIndustry()) { // 交易场所
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getTradeMarket(exportCondition),
                            "交易场所", request
                    ));
        } else if (CompanyInfo.TYPE_YFK_11 == exportCondition.getIndustry()) { // 预付卡
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getPerpaycard(exportCondition),
                            "预付卡", request
                    ));
        } else if (CompanyInfo.TYPE_RZZL_13 == exportCondition.getIndustry()) { // 融资租赁
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getTenancy(exportCondition),
                            "融资租赁", request
                    ));
        } else if (CompanyInfo.TYPE_SMJJ_5 == exportCondition.getIndustry()) { // 私募基金
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getPrivateOfferedFund(exportCondition),
                            "私募基金", request
                    ));
        } else if (CompanyInfo.TYPE_ZC_6 == exportCondition.getIndustry()) { // 众筹
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getCrowdfund(exportCondition),
                            "众筹", request
                    ));
        } else if (CompanyInfo.TYPE_DD_12 == exportCondition.getIndustry()) { // 典当
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getPawn(exportCondition),
                            "典当", request
                    ));
        } else if (CompanyInfo.TYPE_SYBL_10 == exportCondition.getIndustry()) { // 商业保理
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getInsurance(exportCondition),
                            "商业保理", request
                    ));
        }
        return ResponseBean.errorResponse("错误的行业参数");
    }

    public <T> String genExcel(List<T> data, String title, HttpServletRequest request) {
        try {
            if (CollectionUtils.isEmpty(data)) {
                return "没有行业数据！";
            }
            ExportExcel exportExcel = new ExportExcel(title);
            exportExcel.createSheet(title, data);
            exportExcel.exportExcel();
            UserLogRecord.record("导出【" + title + "】行业数据",
                    Operation.Type.DATA_EXPORT, Operation.Page.hologram,
                    Operation.System.front, request);

            return exportExcel.getDownloadURL();
        } catch (Exception e) {
            e.printStackTrace();
            return "导出数据发生错误";
        }
    }
}
