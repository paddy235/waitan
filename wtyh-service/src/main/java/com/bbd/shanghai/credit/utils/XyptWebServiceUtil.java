package com.bbd.shanghai.credit.utils;

import com.bbd.shanghai.credit.service.XyAppQueryService;
import org.codehaus.xfire.XFire;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * 信用平台webService工具类
 *
 * @author Created by LiYao on 2017-04-24 14:36.
 */
public class XyptWebServiceUtil {

	// private static final String SERVICE_URL =
	// "http://10.107.99.42:8080/xyxxfwpt/services/XyAppQuery";
	@Value("${sh_credit_info_url}")
	private static  String SERVICE_URL ;
	@Value("${sh_credit_info_name}")
	private static  String USER_NAME ;
	@Value("${sh_credit_info_password}")
	private static  String PASSWORD ;


	// 操作人身份标识 具体使用数据的人员身份标识，只记录。
	private static final String UNAME = "BBD-wtyh";
	// 查询用途
	private static final String CXYT = "BBD-company-credit-score";

	private static final Logger LOGGER = LoggerFactory.getLogger(XyptWebServiceUtil.class);

	/**
	 *
	 * 获取信用信息。三个参数至少具备一项
	 *
	 * @param dwmc
	 *            单位名称
	 * @param zzjgdm
	 *            组织机构代码
	 * @param tydm
	 *            社会信用统一代码
	 * @return
	 */
	public static String getCreditInfo(String dwmc, String zzjgdm, String tydm) {
		// 创建服务模型
		XyAppQueryService service;

		try {

			ObjectServiceFactory oClass = new ObjectServiceFactory();
			Service serviceModel = oClass.create(XyAppQueryService.class);
			// 获取XFire的代理对象
			XFire xfire = XFireFactory.newInstance().getXFire();
			XFireProxyFactory factory = new XFireProxyFactory(xfire);
			service = (XyAppQueryService) factory.create(serviceModel, SERVICE_URL);
			return service.queryFrKxHonest(dwmc, zzjgdm, tydm, USER_NAME, PASSWORD, CXYT, UNAME);
		} catch (Exception e) {

			String msg = "获取公司：【%s/%s/%s】信用信息出错。请求地址：%s，参数：dwmc：%s，zzjgdm：%s，tydm：%s，username：%s，password：%s，cxyt：%s，uname：%s";
			msg = String.format(msg, dwmc, zzjgdm, tydm, SERVICE_URL, dwmc, zzjgdm, tydm, USER_NAME, PASSWORD, CXYT, UNAME);
			LOGGER.error(msg, e);

			return null;
		}
	}

}
