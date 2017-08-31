package com.bbd.bgo.web.controller;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.excel.ExportExcel;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.UserLogRecord;
import com.bbd.wtyh.service.EasyExportExeclService;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;
import com.bbd.wtyh.web.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
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

    // 行业类型 列表
    @RequestMapping(value = "/industry")
    @ResponseBody
    public ResponseBean industry() {
        Map<String, Byte> rst = new LinkedHashMap<>();
        rst.put("网络借贷", CompanyInfo.TYPE_P2P_1);
        rst.put("小额贷款", CompanyInfo.TYPE_XD_2);
        rst.put("融资担保", CompanyInfo.TYPE_RZDB_3);
        rst.put("线下理财", CompanyInfo.TYPE_XXLC_4);
        rst.put("私募基金", CompanyInfo.TYPE_SMJJ_5);
        rst.put("众筹", CompanyInfo.TYPE_ZC_6);
        rst.put("交易场所", CompanyInfo.TYPE_JYS_9);
        rst.put("商业保理", CompanyInfo.TYPE_SYBL_10);
        rst.put("预付卡", CompanyInfo.TYPE_YFK_11);
        rst.put("典当", CompanyInfo.TYPE_DD_12);
        rst.put("融资租赁", CompanyInfo.TYPE_RZZL_13);
        rst.put("外滩网络借贷", CompanyInfo.TYPE_WT_30);
        rst.put("外滩众筹", CompanyInfo.TYPE_WT_31);
        rst.put("外滩网银", CompanyInfo.TYPE_WT_32);
        rst.put("外滩支付", CompanyInfo.TYPE_WT_33);
        rst.put("外滩预付卡", CompanyInfo.TYPE_WT_34);
        rst.put("外滩融资租赁", CompanyInfo.TYPE_WT_35);
        return ResponseBean.successResponse(rst);
    }


    // 区域
    @RequestMapping(value = "/area")
    @ResponseBody
    public ResponseBean area() {
        Map<String, String> area = easyExportExeclService.area();
        area.remove("上海市");
        return ResponseBean.successResponse(area);
    }

    @RequestMapping(value = "/preview")
    @ResponseBody
    public ResponseBean preview(ExportCondition exportCondition, PageBean pageBean) {
        if (StringUtils.isEmpty(exportCondition.getIndustry())) {
            return ResponseBean.errorResponse("行业参数不可空");
        }
        switch (exportCondition.getIndustry()){
            case CompanyInfo.TYPE_P2P_1:// 网络借贷
                return ResponseBean.successResponseWithPage(easyExportExeclService.getWangdai(exportCondition, pageBean), pageBean);
            case CompanyInfo.TYPE_XD_2:// 小额贷款
                return ResponseBean.successResponseWithPage(easyExportExeclService.getLoan(exportCondition, pageBean), pageBean);
            case CompanyInfo.TYPE_RZDB_3:// 融资担保
                return ResponseBean.successResponseWithPage(easyExportExeclService.getGuarantee(exportCondition, pageBean), pageBean);
            case CompanyInfo.TYPE_XXLC_4:// 线下理财
                return ResponseBean.successResponseWithPage(easyExportExeclService.getOffLineFinance(exportCondition, pageBean), pageBean);
            case CompanyInfo.TYPE_SMJJ_5:// 私募基金
                return ResponseBean.successResponseWithPage(easyExportExeclService.getPrivateOfferedFund(exportCondition, pageBean), pageBean);
            case CompanyInfo.TYPE_ZC_6:// 众筹
                return ResponseBean.successResponseWithPage(easyExportExeclService.getCrowdfund(exportCondition, pageBean), pageBean);
            case CompanyInfo.TYPE_JYS_9:// 交易场所
                return ResponseBean.successResponseWithPage(easyExportExeclService.getTradeMarket(exportCondition, pageBean), pageBean);
            case CompanyInfo.TYPE_SYBL_10:// 商业保理
                return ResponseBean.successResponseWithPage(easyExportExeclService.getInsurance(exportCondition, pageBean), pageBean);
            case CompanyInfo.TYPE_YFK_11:// 预付卡
                return ResponseBean.successResponseWithPage(easyExportExeclService.getPerpaycard(exportCondition, pageBean), pageBean);
            case CompanyInfo.TYPE_DD_12:// 典当
                return ResponseBean.successResponseWithPage(easyExportExeclService.getPawn(exportCondition, pageBean), pageBean);
            case CompanyInfo.TYPE_RZZL_13:// 融资租赁
                return ResponseBean.successResponseWithPage(easyExportExeclService.getTenancy(exportCondition, pageBean), pageBean);
            case CompanyInfo.TYPE_WT_30:// 外滩网络借贷
            case CompanyInfo.TYPE_WT_31:// 外滩众筹
            case CompanyInfo.TYPE_WT_32:// 外滩网银
            case CompanyInfo.TYPE_WT_33:// 外滩支付
            case CompanyInfo.TYPE_WT_34:// 外滩预付卡
            case CompanyInfo.TYPE_WT_35:// 外滩融资租赁
                return ResponseBean.successResponseWithPage(easyExportExeclService.getWaiTanOther(exportCondition, pageBean), pageBean);
            default :break;

        }

        return ResponseBean.errorResponse("错误的行业参数");
    }

    @RequestMapping(value = "/export")
    @ResponseBody
    public ResponseBean export(ExportCondition exportCondition, PageBean pageBean, HttpServletRequest request) {
        if (StringUtils.isEmpty(exportCondition.getIndustry())) {
            return ResponseBean.errorResponse("行业参数不可空");
        }
        pageBean.setCurrentPage(0);
        pageBean.setPageSize(Math.toIntExact(pageBean.getTotalCount()));
        switch (exportCondition.getIndustry()){
            case CompanyInfo.TYPE_P2P_1:
                return ResponseBean.successResponse(
                        genExcel(easyExportExeclService.getWangdai(exportCondition, pageBean),
                                "网络借贷", request
                        ));
            case CompanyInfo.TYPE_XD_2:
                return ResponseBean.successResponse(
                        genExcel(easyExportExeclService.getLoan(exportCondition, pageBean),
                                "小额贷款", request
                        ));
            case CompanyInfo.TYPE_RZDB_3:
                return ResponseBean.successResponse(
                        genExcel(easyExportExeclService.getGuarantee(exportCondition, pageBean),
                                "融资担保", request
                        ));
            case CompanyInfo.TYPE_XXLC_4:
                return ResponseBean.successResponse(
                        genExcel(easyExportExeclService.getOffLineFinance(exportCondition, pageBean),
                                "线下理财", request
                        ));
            case CompanyInfo.TYPE_SMJJ_5:
                return ResponseBean.successResponse(
                        genExcel(easyExportExeclService.getPrivateOfferedFund(exportCondition, pageBean),
                                "私募基金", request
                        ));
            case CompanyInfo.TYPE_ZC_6:
                return ResponseBean.successResponse(
                        genExcel(easyExportExeclService.getCrowdfund(exportCondition, pageBean),
                                "众筹", request
                        ));
            case CompanyInfo.TYPE_JYS_9:
                return ResponseBean.successResponse(
                        genExcel(easyExportExeclService.getTradeMarket(exportCondition, pageBean),
                                "交易场所", request
                        ));
            case CompanyInfo.TYPE_SYBL_10:
                return ResponseBean.successResponse(
                        genExcel(easyExportExeclService.getInsurance(exportCondition, pageBean),
                                "商业保理", request
                        ));
            case CompanyInfo.TYPE_YFK_11:
                return ResponseBean.successResponse(
                        genExcel(easyExportExeclService.getPerpaycard(exportCondition, pageBean),
                                "预付卡", request
                        ));
            case CompanyInfo.TYPE_DD_12:
                return ResponseBean.successResponse(
                        genExcel(easyExportExeclService.getPawn(exportCondition, pageBean),
                                "典当", request
                        ));
            case CompanyInfo.TYPE_RZZL_13:
                return ResponseBean.successResponse(
                        genExcel(easyExportExeclService.getTenancy(exportCondition, pageBean),
                                "融资租赁", request
                        ));
            case CompanyInfo.TYPE_WT_30:// 外滩网络借贷
                return ResponseBean.successResponse(
                        genExcel(easyExportExeclService.getWaiTanOther(exportCondition, pageBean),
                                "外滩网络借贷", request
                        ));
            case CompanyInfo.TYPE_WT_31:// 外滩众筹
                return ResponseBean.successResponse(
                        genExcel(easyExportExeclService.getWaiTanOther(exportCondition, pageBean),
                                "外滩众筹", request
                        ));
            case CompanyInfo.TYPE_WT_32:// 外滩网银
                return ResponseBean.successResponse(
                        genExcel(easyExportExeclService.getWaiTanOther(exportCondition, pageBean),
                                "外滩网银", request
                        ));
            case CompanyInfo.TYPE_WT_33:// 外滩支付
                return ResponseBean.successResponse(
                        genExcel(easyExportExeclService.getWaiTanOther(exportCondition, pageBean),
                                "外滩支付", request
                        ));
            case CompanyInfo.TYPE_WT_34:// 外滩预付卡
                return ResponseBean.successResponse(
                        genExcel(easyExportExeclService.getWaiTanOther(exportCondition, pageBean),
                                "外滩预付卡", request
                        ));
            case CompanyInfo.TYPE_WT_35:// 外滩融资租赁
                return ResponseBean.successResponse(
                        genExcel(easyExportExeclService.getWaiTanOther(exportCondition, pageBean),
                                "外滩融资租赁", request
                        ));

            default :break;
        }

        return ResponseBean.errorResponse("错误的行业参数");
    }

    public <T> String genExcel(List<T> data, String title, HttpServletRequest request) {
        try {
            if (CollectionUtils.isEmpty(data)) {
                return "没有行业数据！";
            }
            ExportExcel exportExcel = new ExportExcel(title);

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
