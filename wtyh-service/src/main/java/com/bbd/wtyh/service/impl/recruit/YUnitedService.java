package com.bbd.wtyh.service.impl.recruit;

import com.bbd.data.mapper.OrderTable;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.common.recruit.StringUtil;
import com.bbd.wtyh.common.recruit.enums.ApiPrefix;
import com.bbd.wtyh.domain.recrut.CommonData;
import com.bbd.wtyh.service.OrderService;
import com.bbd.wtyh.service.impl.recruit.mapper.UrlMapping;
import com.bbd.wtyh.service.impl.relation.exception.BbdException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class YUnitedService {

    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private YUnitedContainerService yunitedContainerService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UrlMappingService urlMappingService;

    @SuppressWarnings("unchecked")
    public List<CommonData> queryYUnitedData(String token, String companyName, String username, String type) {
        UrlMapping urlMapping = null;
        if (StringUtil.isNotNullOrEmpty(companyName)) {
            OrderTable order = orderService.getOrderTableBySurveyFirmNameAndCustomerId(companyName, username);
            urlMapping = urlMappingService.getUrlMapping(ApiPrefix.YU_API.getApiPrefix(), order.getDeadlines());
            companyName = companyName.replace("(", "（");
            companyName = companyName.replace(")", "）");
        }
        String responseData = yunitedContainerService.queryYUnitedInfo(urlMapping.getApiUrl(), this.getUrlParam(token, companyName, type, urlMapping.getApiVersion()));
        logger.info("API返回信息：" + responseData);
        System.out.println("API返回信息：" + responseData);
        List<CommonData> commonDataList = new ArrayList<CommonData>();
        Map<String, Object> totalMap = JSONObject.fromObject(responseData);
        Integer errCode = (Integer) totalMap.get("err_code");
        if (null != errCode && errCode == 0) {
            List<Map<String, Object>> rdataList = JSONArray.fromObject(totalMap.get("rdata"));
            for (int i = 0; i < rdataList.size(); i++) {
                Map<String, Object> rdataMap = rdataList.get(i);
                CommonData commonData = new CommonData();
                commonData.setCompanyName(StringUtil.StringValueOf(rdataMap.get("company_name")));
                commonData.setIndustry(StringUtil.StringValueOf(rdataMap.get("industry")));
                commonData.setIslist(StringUtil.StringValueOf(rdataMap.get("islist")));
                commonData.setTime(StringUtil.StringValueOf(rdataMap.get("time")));
                commonData.setType(StringUtil.StringValueOf(rdataMap.get("type")));
                commonData.setxUnit(StringUtil.StringValueOf(rdataMap.get("x_unit")));
                commonData.setxValue(StringUtil.StringValueOf(rdataMap.get("x_value")));
                commonData.setyUnit(StringUtil.StringValueOf(rdataMap.get("y_unit")));
                commonData.setyValue(StringUtil.StringValueOf(rdataMap.get("y_value")));
                commonDataList.add(commonData);
            }
        }
        return commonDataList;
    }

    /**
     * 拼接参数
     *
     * @param token
     * @param companyName
     * @param type
     * @return
     */
    private String getUrlParam(String token, String companyName, String type, String version) {
        StringBuffer buffer = new StringBuffer();
        try {
            buffer.append("access_token=")
                    .append(token)
                    .append("&company=")
                    .append(URLEncoder.encode(companyName, Constants.characterCode))
                    .append("&type=")
                    .append(type)
                    .append("&version=")
                    .append(version);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
            throw new BbdException(e.getMessage(), e);
        }
        return buffer.toString();
    }

}
