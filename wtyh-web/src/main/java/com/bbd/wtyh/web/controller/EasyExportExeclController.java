package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.enums.CompanyLevel;
import com.bbd.wtyh.excel.ExportExcel;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.UserLogRecord;
import com.bbd.wtyh.service.EasyExportExeclService;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;
import com.bbd.wtyh.web.ResponseBean;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YanWenyuan on 2017/7/18.
 */
@Controller
@RequestMapping("/easyExportExecl")
public class EasyExportExeclController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EasyExportExeclController.class);

    @Autowired
    private EasyExportExeclService easyExportExeclService;

    @RequestMapping(value = "/preview")
    @ResponseBody
    public ResponseBean preview(ExportCondition exportCondition, PageBean pageBean) {
        if (CompanyInfo.TYPE_P2P_1 == exportCondition.getIndustry()) { // 网络借贷
            return ResponseBean.successResponseWithPage(easyExportExeclService.getWangdai(exportCondition, pageBean), pageBean);
        } else if (CompanyInfo.TYPE_XD_2 == exportCondition.getIndustry()) { // 小额贷款
            return ResponseBean.successResponseWithPage(easyExportExeclService.getLoan(exportCondition, pageBean), pageBean);
        } else if (CompanyInfo.TYPE_RZDB_3 == exportCondition.getIndustry()) { // 融资担保
            return ResponseBean.successResponseWithPage(easyExportExeclService.getGuarantee(exportCondition, pageBean), pageBean);
        } else if (CompanyInfo.TYPE_XXLC_4 == exportCondition.getIndustry()) { // 线下理财
            return ResponseBean.successResponseWithPage(easyExportExeclService.getOffLineFinance(exportCondition, pageBean), pageBean);
        } else if (CompanyInfo.TYPE_JYS_9 == exportCondition.getIndustry()) { // 交易场所
            return ResponseBean.successResponseWithPage(easyExportExeclService.getTradeMarket(exportCondition, pageBean), pageBean);
        } else if (CompanyInfo.TYPE_YFK_11 == exportCondition.getIndustry()) { // 预付卡
            return ResponseBean.successResponseWithPage(easyExportExeclService.getPerpaycard(exportCondition, pageBean), pageBean);
        } else if (CompanyInfo.TYPE_RZZL_13 == exportCondition.getIndustry()) { // 融资租赁
            return ResponseBean.successResponseWithPage(easyExportExeclService.getTenancy(exportCondition, pageBean), pageBean);
        } else if (CompanyInfo.TYPE_SMJJ_5 == exportCondition.getIndustry()) { // 私募基金
            return ResponseBean.successResponseWithPage(easyExportExeclService.getPrivateOfferedFund(exportCondition, pageBean), pageBean);
        } else if (CompanyInfo.TYPE_ZC_6 == exportCondition.getIndustry()) { // 众筹
            return ResponseBean.successResponseWithPage(easyExportExeclService.getCrowdfund(exportCondition, pageBean), pageBean);
        } else if (CompanyInfo.TYPE_DD_12 == exportCondition.getIndustry()) { // 典当
            return ResponseBean.successResponseWithPage(easyExportExeclService.getPawn(exportCondition, pageBean), pageBean);
        } else if (CompanyInfo.TYPE_SYBL_10 == exportCondition.getIndustry()) { // 商业保理
            return ResponseBean.successResponseWithPage(easyExportExeclService.getInsurance(exportCondition, pageBean), pageBean);
        }
        return ResponseBean.errorResponse("错误的行业参数");
    }

    @RequestMapping(value = "/export")
    @ResponseBody
    public ResponseBean export(ExportCondition exportCondition, PageBean pageBean, HttpServletRequest request) {
        if (CompanyInfo.TYPE_P2P_1 == exportCondition.getIndustry()) { // 网络借贷
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getWangdai(exportCondition, pageBean),
                            "网络借贷", request
                    ));
        } else if (CompanyInfo.TYPE_XD_2 == exportCondition.getIndustry()) { // 小额贷款
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getLoan(exportCondition, pageBean),
                            "小额贷款", request
                    ));
        } else if (CompanyInfo.TYPE_RZDB_3 == exportCondition.getIndustry()) { // 融资担保
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getGuarantee(exportCondition, pageBean),
                            "融资担保", request
                    ));
        } else if (CompanyInfo.TYPE_XXLC_4 == exportCondition.getIndustry()) { // 线下理财
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getOffLineFinance(exportCondition, pageBean),
                            "线下理财", request
                    ));
        } else if (CompanyInfo.TYPE_JYS_9 == exportCondition.getIndustry()) { // 交易场所
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getTradeMarket(exportCondition, pageBean),
                            "交易场所", request
                    ));
        } else if (CompanyInfo.TYPE_YFK_11 == exportCondition.getIndustry()) { // 预付卡
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getPerpaycard(exportCondition, pageBean),
                            "预付卡", request
                    ));
        } else if (CompanyInfo.TYPE_RZZL_13 == exportCondition.getIndustry()) { // 融资租赁
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getTenancy(exportCondition, pageBean),
                            "融资租赁", request
                    ));
        } else if (CompanyInfo.TYPE_SMJJ_5 == exportCondition.getIndustry()) { // 私募基金
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getPrivateOfferedFund(exportCondition, pageBean),
                            "私募基金", request
                    ));
        } else if (CompanyInfo.TYPE_ZC_6 == exportCondition.getIndustry()) { // 众筹
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getCrowdfund(exportCondition, pageBean),
                            "众筹", request
                    ));
        } else if (CompanyInfo.TYPE_DD_12 == exportCondition.getIndustry()) { // 典当
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getPawn(exportCondition, pageBean),
                            "典当", request
                    ));
        } else if (CompanyInfo.TYPE_SYBL_10 == exportCondition.getIndustry()) { // 商业保理
            return ResponseBean.successResponse(
                    genExcel(easyExportExeclService.getInsurance(exportCondition, pageBean),
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

            int totalCount = data.size();
            int pageSize = totalCount > 10000 ? 10000 : totalCount;
            int pageCount = (totalCount + pageSize - 1) / pageSize;

            int fromIndex;
            int toIndex;
            for (int i = 1; i <= pageCount; i++) {

                fromIndex = (i - 1) * pageSize;
                toIndex = fromIndex + pageSize;
                toIndex = toIndex < totalCount ? toIndex : totalCount;

                exportExcel.createSheet(title + i, data.subList(fromIndex, toIndex));
            }

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
