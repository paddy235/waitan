package com.bbd.wtyh.test;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * Created by Administrator on 2017/6/30 0030.
 */
public class MainTest {

    public static void main(String[] args) {
        String qyxxId = "asdasf";
        String companyName = "一个公司";
        String taskId = "一个ID";

        StringBuilder sb = new StringBuilder(
                49 + StringUtils.length(taskId) + StringUtils.length(qyxxId) + StringUtils.length(companyName));

        System.out.println(sb.length());

        sb.append(",\"task_id\":\"").append(taskId).append("\"");

        if (StringUtils.isNotBlank(qyxxId)) {
            sb.append(",\"bbd_qyxx_id\":\"").append(qyxxId).append("\"");
        }
        if (StringUtils.isNotBlank(companyName)) {
            sb.append(",\"company_name\":\"").append(companyName).append("\"");
        }
        sb.append("}");

        System.out.println(sb.length());

        System.out.println(sb);

    }

}
