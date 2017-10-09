package com.bbd.wtyh.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bbd.wtyh.constants.CreditType;
import com.bbd.wtyh.domain.PlatRankDataDO;
import com.bbd.wtyh.domain.dataLoading.QyxxBasicDO;
import com.bbd.wtyh.domain.dataLoading.ZgcpwswDO;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * 
 * Created by Administrator on 2017/6/30 0030.
 */
public class MainTest {

    public static void main(String[] args) {
       /* String str2="1";
        BigDecimal  bigDecimal=new BigDecimal(str2).setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal.toString());*/
        PlatRankDataDO platRankDataDO = new PlatRankDataDO();
        System.out.println(platRankDataDO.getAmount());
        /*
        String str = "{\"tn\": \"qyxx_basic\", \"bbd_qyxx_id\": \"1bf7e41bf5d948ad85271b8771455fe5\", \"data\": {\"qyxx_basic\": [{\"operating_period\": null, \"regno\": \"310108000594243\", \"company_regorg\": \"310007\", \"parent_firm\": null, \"ipo_company\": null, \"company_type\": \"有限责任公司（自然人独资）\", \"approval_date\": \"2015-04-02\", \"create_time\": \"2017-03-19 15:58:24\", \"esdate\": \"2015-04-02\", \"realcap_amount\": null, \"credit_code\": \"913101083324845904\", \"regcap\": \"200万人民币\", \"id\": null, \"enterprise_status\": \"存续（在营、开业、在册）\", \"invest_cap\": null, \"openfrom\": \"2015-04-02\", \"regorg\": \"静安区市场监督管理局\", \"frname\": \"李勇\", \"bbd_qyxx_id\": \"1bf7e41bf5d948ad85271b8771455fe5\", \"company_county\": \"310108\", \"operate_scope\": \"在信息、通讯、计算机科技专业领域内从事技术开发、技术咨询、技术转让、技术服务，投资咨询，投资管理，实业投资，企业管理咨询，通讯设备、机电设备、电子产品、电子元器件的销售。【依法须经批准的项目，经相关部门批准后方可开展经营活动】\", \"regcap_currency\": \"人民币\", \"regcapcur\": null, \"bbd_type\": \"shanghai\", \"company_industry\": \"M\", \"regno_or_creditcode\": null, \"type\": \"上海\", \"revoke_date\": null, \"company_name\": \"上海效同信息科技有限公司\", \"form\": null, \"bbd_history_name\": \"[{\\\"change_date\\\": \\\"2016年01月26日\\\", \\\"company_name\\\": \\\"上海效通投资咨询有限公司\\\"}]\", \"bbd_uptime\": \"1489903619\", \"bbd_dotime\": \"2017-03-19\", \"investcap_amount\": null, \"regcap_amount\": \"2000000.0\", \"address\": \"上海市闸北区江场三路250号628室\", \"opento\": \"2045-04-01\", \"company_enterprise_status\": \"存续\", \"company_province\": \"上海\", \"company_currency\": null, \"realcap_currency\": null, \"cancel_date\": null, \"investcap_currency\": null, \"realcap\": null, \"frname_id\": \"0bade39b6e7ed9c5eeb8370f5a15cab7\", \"frname_compid\": \"1\", \"company_companytype\": \"1151\"}]}, \"company_name\": \"上海效同信息科技有限公司\"}";

        JSONObject jsonObject = JSONObject.parseObject(str);
        String data = jsonObject.getString("data");
        String tn = jsonObject.getString("tn");
        String qyxxId = jsonObject.getString("bbd_qyxx_id");
        String companyName = jsonObject.getString("company_name");

        JSONObject jsonData = JSONObject.parseObject(data);
        String dataStr = jsonData.getString(tn);
        String taskId = String.valueOf(789);

        // 拼装一段字符串，替换原JSON串的 }，变相追加元素。
        StringBuilder sb = new StringBuilder(
                49 + StringUtils.length(taskId) + StringUtils.length(qyxxId) + StringUtils.length(companyName));

        sb.append(",\"task_id\":\"").append(taskId).append("\"");

        if (StringUtils.isNotBlank(qyxxId)) {
            sb.append(",\"bbd_qyxx_id\":\"").append(qyxxId).append("\"");
        }
        if (StringUtils.isNotBlank(companyName)) {
            sb.append(",\"company_name\":\"").append(companyName).append("\"");
        }
        sb.append("}");

        // [{"a":"1"}] --> [{"a":"1","b":"2"}]
        dataStr = dataStr.replaceAll("}", sb.toString());
        dataStr = dataStr.replaceAll("\\\\\"", "\"");
        dataStr = dataStr.replaceAll("\"\\{", "{").replaceAll("}\"", "}");
        dataStr = dataStr.replaceAll("\"\\[", "[").replaceAll("]\"", "]");

        List<QyxxBasicDO> list = JSONArray.parseArray(dataStr, QyxxBasicDO.class);
        System.out.println(list.size());*/
    }

}
