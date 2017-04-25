package com.bbd.bgo.service.task.impl;

import com.bbd.bgo.service.task.ShangHaiInfoCentreTaskService;
import com.bbd.shanghai.credit.utils.XyptWebServiceUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/4/24 0024.
 */
public class ShangHaiInfoCentreTaskServiceImpl implements ShangHaiInfoCentreTaskService {

	@Override
	public void getData() {
		// 前三个参数至少具备一项
		// dwmc 单位名称 信息主体标识
		// zzjgdm 组织机构代码 信息主体标识
		// tydm 社会信用统一代码 信息主体标识
		// cxyt 查询用途 使用单位身份标识

		String xmlData = XyptWebServiceUtil.getCreditInfo(null, null, null, "test");

	}

    public static void test(String data) {
        // 前三个参数至少具备一项
        // dwmc 单位名称 信息主体标识
        // zzjgdm 组织机构代码 信息主体标识
        // tydm 社会信用统一代码 信息主体标识
        // cxyt 查询用途 使用单位身份标识

        //String xmlData = XyptWebServiceUtil.getCreditInfo(null, null, null, "test");
        SAXReader reader = new SAXReader();
        try {
            Document document = DocumentHelper.parseText(data);

            Element root = document.getRootElement();
            root.attributeValue("");
            String resultCode=root.elementText("RESULT");
            if(!"1005".equals(resultCode)){
                return;
            }

            List nodes = root.elements("RESOURCE");
            for (Iterator it = nodes.iterator(); it.hasNext();) {
                Element resource = (Element) it.next();
                System.out.println(resource.attributeValue("XXLB"));
                System.out.println(resource.attributeValue("XXSSDW"));
                System.out.println(resource.attributeValue("RESOURCENAME"));
                System.out.println(resource.attributeValue("RESOURCECODE"));
                System.out.println(resource.attributeValue("XXSSDWDM"));
                System.out.println(resource.attributeValue("RESOURCES"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("<GRZX name=\"上海\" zjhm=\"\" tydm=\"\" cxbh=\"JKCX201603101718300000101000005852\">");
        sb.append("<RESULT>1005</RESULT>");
        sb.append(
                "<RESOURCE XXLB=\"监管类\" XXSSDW=\"市食品药品监管局\" RESOURCENAME=\"使用不合格药包材\" RESOURCECODE=\"0801082\" XXSSDWDM=\"D010044\" RESOURCES=\"punishnotes\">");
        sb.append("<punishmeasures>处罚种类:药包材;处罚内容:罚款</punishmeasures>");
        sb.append("<licensestatus></licensestatus>");
        sb.append("<illegaldate></illegaldate>");
        sb.append("<illegalcontext>使用不合格药包材</illegalcontext>");
        sb.append("<punishdate>2011-01-04 00:00:00.0</punishdate>");
        sb.append("<punishlimit></punishlimit>");
        sb.append("<punishbasis>《管理办法》第六十五条</punishbasis>");
        sb.append("</RESOURCE>");

        sb.append("</GRZX>");
        test(sb.toString());

    }
}
