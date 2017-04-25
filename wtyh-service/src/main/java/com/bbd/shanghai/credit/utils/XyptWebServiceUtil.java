package com.bbd.shanghai.credit.utils;

import com.bbd.shanghai.credit.service.XyAppQueryService;
import org.codehaus.xfire.XFire;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

/**
 * 信用平台webService工具类
 *
 * @author Created by LiYao on 2017-04-24 14:36.
 */
public class XyptWebServiceUtil {

	private static final String SERVICE_URL = "http://10.107.99.42:8080/xyxxfwpt/services/XyAppQuery";
	private static final String USER_NAME = "";
	private static final String PASSWORD = "";

	// 操作人身份标识 具体使用数据的人员身份标识，只记录。
	private static final String UNAME = "BBD-wtyh";

	/**
	 * 
	 * @param dwmc
	 * @param zzjgdm
	 * @param tydm
	 * @param cxyt
	 * @return
	 */
	public static String getCreditInfo(String dwmc, String zzjgdm, String tydm, String cxyt) {
		// 创建服务模型
		XyAppQueryService service;

		try {
			ObjectServiceFactory oClass = new ObjectServiceFactory();
			Service serviceModel = oClass.create(XyAppQueryService.class);
			// 获取XFire的代理对象
			XFire xfire = XFireFactory.newInstance().getXFire();
			XFireProxyFactory factory = new XFireProxyFactory(xfire);
			service = (XyAppQueryService) factory.create(serviceModel, SERVICE_URL);
			return service.queryFrKxHonest(dwmc, zzjgdm, tydm, USER_NAME, PASSWORD, cxyt, UNAME);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
