package com.bbd.wtyh.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bbd.wtyh.domain.dataLoading.ZgcpwswDO;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 
 * Created by Administrator on 2017/6/30 0030.
 */
public class MainTest {

    public static void main(String[] args) {

        String str = "{\"tn\": \"zgcpwsw\", \"bbd_qyxx_id\": \"d8a3f22d829f47d7867d6c65020ddb06\", \"data\": {\"zgcpwsw\": [{\"is_nolle_prosequi\": \"是\", \"bbd_version\": null, \"casecode\": \"（2017）津72民初443号\", \"litigant_type\": null, \"bbd_dotime\": \"2017-07-28\", \"def_other_related\": null, \"bbd_source\": null, \"bbd_xgxx_id\": \"79286ed7f1b6482a58e66a5f65231821\", \"def_litigant\": \"万享供应链管理（上海）有限公司\", \"court_litigant\": \"刘树立\", \"litigant\": null, \"sentence_date\": \"2017-07-11\", \"id\": \"38402070\", \"caseout_come\": \"原告撤诉\", \"ju_proc\": \"一审\", \"litigation_status\": \"{\\\"万享供应链管理（上海）有限公司\\\": \\\"被告\\\", \\\"北京泛亚利华国际投资咨询有限公司\\\": \\\"原告\\\"}\", \"title\": \"北京泛亚利华国际投资咨询有限公司与万享供应链管理（上海）有限公司货运代理合同纠纷一审民事裁定书\", \"judgmen_result\": \"裁定如下：\\n准许原告北京泛亚利华国际投资咨询有限公司撤诉。\\n案件受理费376元，减半收取计188元，由原告北京泛亚利华国际投资咨询有限公司负担。\", \"pro_other_related\": null, \"case_type\": \"民事一审案件\", \"company_name\": null, \"bbd_type\": \"qyxg_zgcpwsw_app\", \"main\": \"原告：北京泛亚利华国际投资咨询有限公司。住所地：北京市东城区广渠门大街90号新裕商务大厦A座601室。\\n法定代表人：陈燕，该公司总经理。\\n被告：万享供应链管理（上海）有限公司。住所地：上海市浦东新区张杨路3611弄6号907、906室。\\n原告北京泛亚利华国际投资咨询有限公司与被告万享供应链管理（上海）有限公司货运代理合同纠纷一案，本院于2017年7月4日立案。原告北京泛亚利华国际投资咨询有限公司于2017年7月7日向本院提出撤诉申请。\\n本院认为，原告撤回对被告的起诉符合我国民事法律的有关规定，且不损害国家公共利益和其他公民或组织的利益。\\n依照《中华人民共和国民事诉讼法》第一百四十五条第一款规定，裁定如下：\\n准许原告北京泛亚利华国际投资咨询有限公司撤诉。\\n案件受理费376元，减半收取计188元，由原告北京泛亚利华国际投资咨询有限公司负担。\\n代理审判员　　刘树立\\n二〇一七年七月十一日\\n书　记　员　　刘　晓\", \"applicable_law\": \"《中华人民共和国民事诉讼法》第一百四十五条第一款\", \"action_cause\": \"货运代理合同纠纷\", \"bbd_uptime\": \"1501171200\", \"rel_doc_url\": null, \"update\": \"2017-07-26\", \"court_acceptance_fee\": \"188元\", \"trial_court\": \"天津海事法院\", \"doc_type\": \"裁定书\", \"data_source\": \"裁判文书网APP\", \"rel_doc\": null, \"pro_litigant\": \"北京泛亚利华国际投资咨询有限公司\", \"create_time\": \"2017-07-28 05:39:41\", \"rawdata\": null, \"historycase\": null, \"is_beneficial\": \"{\\\"万享供应链管理（上海）有限公司\\\": \\\"其他\\\", \\\"北京泛亚利华国际投资咨询有限公司\\\": \\\"其他\\\"}\", \"bbd_url\": \"http://wenshu.court.gov.cn/content/content?DocID=2e44c071-6746-4df9-a92d-a7bc0092330c\"}]}, \"company_name\": \"万享供应链管理（上海）有限公司\"}";

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
        System.out.println(dataStr);

        List<ZgcpwswDO> list = JSONArray.parseArray(dataStr, ZgcpwswDO.class);
        System.out.println(list.size());
    }

}
