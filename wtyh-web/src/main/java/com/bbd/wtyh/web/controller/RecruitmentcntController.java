package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.common.recruit.BbdLocaleProvider;
import com.bbd.wtyh.common.recruit.ConstantsRecruit;
import com.bbd.wtyh.domain.recrut.CommonData;
import com.bbd.wtyh.service.impl.recruit.YUnitedService;
import com.bbd.wtyh.util.recruit.DateUtil;
import com.bbd.wtyh.util.relation.StringUtils;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 招聘Controller
 * @author wangchenge
 * @since 2016.08.16
 */
@Controller
@RequestMapping("show")
public class RecruitmentcntController extends BaseSuperController {
    private static final String NULL_DATA = "{'value':1,'name':'i18n:recruit.noData','itemStyle':{'normal':{'label':{'textStyle':{'color':'blank'}}}}}}";
    private static final String RECRUITMENTCNT = "show/recruitmentcnt/recruitmentcnt";
    private static final String RECRUITMENTCNT_SCREENSHOOT = "show/recruitmentcnt/recruitmentcntScreenshoot";
    private static final List SELECT_TYPE = Arrays.asList(ConstantsRecruit.COMMON_DATA_TYPE.str01_1, ConstantsRecruit.COMMON_DATA_TYPE.str01_2,
            ConstantsRecruit.COMMON_DATA_TYPE.str02, ConstantsRecruit.COMMON_DATA_TYPE.str03, ConstantsRecruit.COMMON_DATA_TYPE.str04);
    private static final String CHART_PARAM = "\"itemStyle\":{\"normal\":{\"label\":{\"textStyle\":{\"color\":\"blank\"}}}}";

    @Resource
    private BbdLocaleProvider bbdLocaleProvider;

    @Resource
    private YUnitedService yUnitedService;

    @RequestMapping("recruitmentcnt.do")
    public ModelAndView recruitmentcnt(@RequestParam String companyName, @RequestParam(value = "flag", defaultValue = "true") boolean flag, HttpServletRequest request) throws Exception {
        super.setLeveMenu();//设左侧菜单
        companyName = decryptCompanyName(companyName);
        // 最近12个月
        String[] last12Months = DateUtil.get12Months();

        //保留2位小数
        DecimalFormat df = new DecimalFormat(".##");

        ModelAndView mav = null;
        if (flag) {
            mav = new ModelAndView(RECRUITMENTCNT);
        } else {
            mav = new ModelAndView(RECRUITMENTCNT_SCREENSHOOT);
        }

		/*
		 * List<CommonData> commonDate = commonData.getCommonDate(new
		 * ParamObject(null, SELECT_TYPE, companyCode.substring(2),
		 * DateUtil.strToDate("2014-08-01"), DateUtil.strToDate("2015-08-01"),
		 * null));
		 */
        String username = request.getParameter("username");
        if (StringUtils.isNullOrEmpty(username)) {
            username = (String) request.getSession().getAttribute(ConstantsRecruit.SESSION.showLoginName);
        } else {
            username = decryptCompanyName(username);
        }
        Float sumPerson = 0f, sumX3 = 0f;
        List<CommonData> commonDate = new ArrayList<CommonData>();
        List<CommonData> data1 = yUnitedService.queryYUnitedData("token", companyName, username, ConstantsRecruit.COMMON_DATA_TYPE.str01);
        List<CommonData> data2 = yUnitedService.queryYUnitedData("token", companyName, username, ConstantsRecruit.COMMON_DATA_TYPE.str02);
        List<CommonData> data3 = yUnitedService.queryYUnitedData("token", companyName, username, ConstantsRecruit.COMMON_DATA_TYPE.str03);
        List<CommonData> data4 = yUnitedService.queryYUnitedData("token", companyName, username, ConstantsRecruit.COMMON_DATA_TYPE.str04);

        for (CommonData commonData : data3) {
            String xValue = commonData.getxValue();
            if (xValue != null && !"".equals(xValue) && !xValue.toLowerCase().equals("null"))
                sumX3 += Float.parseFloat(commonData.getxValue());
        }

        for (CommonData commonData : data4) {
            String yValue = commonData.getyValue();
            if (yValue != null && !"".equals(yValue) && !yValue.toLowerCase().equals("null"))
                sumPerson += Float.parseFloat(commonData.getyValue());
        }

        commonDate.addAll(data1);
        commonDate.addAll(data3);
        //commonDate.addAll(data4);

        int yCount = 0;

        List<String> xAxis1_1 = new ArrayList<String>();
        // 默认数字为0，前端线条会跳跃，为满足需求只能使用拼接字符串[,,1,2,3,4,5] 前面两个空的才能不显示，
        // 用arraylist要么null，要么0，要么"",不能解决，如果去前端replace前段后分离不够彻底。
        // 【2015/9/6】： 由于空点问题，现在又实用正常方式 [0,0,1,2,3,4,5] 项目紧张直接在数组上添加
        List<CommonData> yAxis1_1 = new ArrayList<CommonData>();
        List<CommonData> yAxis1_2 = new ArrayList<CommonData>();

        //组装饼图
        String xAxis3 = "[";
        boolean pieNotData = false;
        //饼图没有数据则显示空的
        if (data3.size() == 0) {
            if (flag) {
                xAxis3 += NULL_DATA.replace("i18n:recruit.noData", bbdLocaleProvider.i18n("recruit.noData"));
            } else {
                xAxis3 += NULL_DATA.replace("i18n:recruit.noData", "暂无数据");
            }

            pieNotData = true;
        }

        //薪酬分布

        String[] salaryDistribution = {"2K" + bbdLocaleProvider.i18n("rep.show.action.thefollowing"), "2K-5K", "5K-10K", "10K-20K", "20K-30K", "30K" + bbdLocaleProvider.i18n("rep.show.action.theabove")};
        String[] salaryDistribution_cn = {"2K以下", "2K-5K", "5K-10K", "10K-20K", "20K-30K", "30K以上"};
        List xAxisValue4 = new ArrayList<Map>();
        // 传入x轴,y轴
        for (CommonData data : commonDate) {

            String type = data.getType();
            double yValue;
            switch (type) {
                case ConstantsRecruit.COMMON_DATA_TYPE.str01_1:
                    yAxis1_1.add(data);
                    break;
                case ConstantsRecruit.COMMON_DATA_TYPE.str01_2:
                    yCount++;
                    yAxis1_2.add(data);
                    break;
                case ConstantsRecruit.COMMON_DATA_TYPE.str03:
                    String itemJson = "";
                    try {
                        String xUtil = data.getxUnit();
                        if (xUtil.split("\\|").length > 2) {
                            int index = xUtil.lastIndexOf("|");
                            xUtil = xUtil.substring(0, index + 1) + "\\n" + xUtil.substring(index + 1);
                        }
                        Double xValue = Double.parseDouble(data.getxValue());
                        if (xValue / sumX3 * 100 >= 0.01)
                            itemJson = "{\"value\":" + xValue + ",\"name\":\"" + xUtil + "\"," + CHART_PARAM + "},";
                    } catch (NumberFormatException e) {
                        itemJson = "{\"value\":0,\"name\":\"" + data.getxUnit() + "\"," + CHART_PARAM + "},";
                    }
                    xAxis3 += itemJson;
                    break;
//			case Constants.COMMON_DATA_TYPE.str04:
//				try {
//					xAxisValue4.add(Float.parseFloat(data.getxValue()) / sumPerson * 100);
//				} catch (Exception e) {
//					e.printStackTrace();
//					System.out.println("不是数字型");
//					xAxisValue4.add(0);
//				}
//				break;
            }
        }

        String yAxis1_1RealValue = "[", yAxis1_2RealValue = "[", yAxis2 = "[", yAxis4 = "[";

        int y1Index = 0;
        int y2Index = 0;

        outer:
        for (int i = 0; i < last12Months.length; i++) {
            for (CommonData commonData : yAxis1_1) {
                if (last12Months[i].equals(commonData.getxValue())) {
                    yAxis1_1RealValue += commonData.getyValue() + ",";
                    continue outer;
                }
            }
            yAxis1_1RealValue += ",";
        }


        outer:
        for (int i = 0; i < last12Months.length; i++) {
            for (CommonData commonData : yAxis1_2) {
                if (last12Months[i].equals(commonData.getxValue())) {
                    yAxis1_2RealValue += commonData.getyValue() + ",";
                    continue outer;
                }
            }
            yAxis1_2RealValue += ",";
        }

        outer:
        for (int i = 0; i < last12Months.length; i++) {
            for (CommonData commonData : data2) {
                if (last12Months[i].equals(commonData.getxValue())) {
                    yAxis2 += commonData.getyValue() + ",";
                    continue outer;
                }
            }
            yAxis2 += ",";
        }

        if (flag) {
            outer:
            for (int i = 0; i < salaryDistribution.length; i++) {
                for (CommonData commonData : data4) {
                    if (salaryDistribution[i].equals(commonData.getxValue())) {
                        String yValue = commonData.getyValue();
                        if (yValue != null && !"".equals(yValue) && !yValue.toLowerCase().equals("null"))
                            yAxis4 += df.format(Float.parseFloat(commonData.getyValue()) / sumPerson * 100) + ",";
                        else
                            yAxis4 += "0,";
                        continue outer;
                    }
                }
                yAxis4 += "0,";
            }
        } else {
            outer:
            for (int i = 0; i < salaryDistribution_cn.length; i++) {
                for (CommonData commonData : data4) {
                    if (salaryDistribution_cn[i].equals(commonData.getxValue())) {
                        String yValue = commonData.getyValue();
                        if (yValue != null && !"".equals(yValue) && !yValue.toLowerCase().equals("null"))
                            yAxis4 += df.format(Float.parseFloat(commonData.getyValue()) / sumPerson * 100) + ",";
                        else
                            yAxis4 += "0,";
                        continue outer;
                    }
                }
                yAxis4 += "0,";
            }
        }


        //删除最后一个逗号
        if (yAxis1_1RealValue.length() > 1)
            yAxis1_1RealValue = yAxis1_1RealValue.substring(0, yAxis1_1RealValue.length() - 1);
        if (yAxis1_2RealValue.length() > 1)
            yAxis1_2RealValue = yAxis1_2RealValue.substring(0, yAxis1_2RealValue.length() - 1);
        if (yAxis2.length() > 1)
            yAxis2 = yAxis2.substring(0, yAxis2.length() - 1);
        if (xAxis3.length() > 1)
            xAxis3 = xAxis3.substring(0, xAxis3.length() - 1);
        if (yAxis4.length() > 1)
            yAxis4 = yAxis4.substring(0, yAxis4.length() - 1);

        yAxis1_1RealValue += "]";
        yAxis1_2RealValue += "]";
        yAxis2 += "]";
        xAxis3 += "]";
        yAxis4 += "]";

        mav.addObject("xAxis1_1", JSONArray.fromObject(last12Months));
        mav.addObject("yAxis1_1", yAxis1_1RealValue);

        mav.addObject("yAxis1_2", yAxis1_2RealValue);

        mav.addObject("xAxis2", JSONArray.fromObject(last12Months));
        mav.addObject("yAxis2", yAxis2);

        mav.addObject("xAxis3", xAxis3);

        mav.addObject("xAxis4", JSONArray.fromObject(salaryDistribution));
        mav.addObject("xAxisValue4", yAxis4);

        mav.addObject("pieNotData", pieNotData);

        mav.addObject("decCompany", companyName);

        mav.addObject("companyName", encryptCompanyName(companyName));

        // 查询订单信息
        super.setOrderParam(mav, companyName, username);

        return mav;
    }

}
