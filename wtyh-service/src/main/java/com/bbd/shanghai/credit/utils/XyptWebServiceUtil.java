package com.bbd.shanghai.credit.utils;

import com.bbd.shanghai.credit.service.XyAppQueryService;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.codehaus.xfire.XFire;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.URI;

/**
 * 信用平台webService工具类
 *
 * @author Created by LiYao on 2017-04-24 14:36.
 */
public class XyptWebServiceUtil {

	// private static final String SERVICE_URL =
	// "http://127.0.0.1:8082/xyxxfwpt/services/XyAppQuery";

	private static final String SERVICE_URL = CreditConfig.serviceUrl();

	private static final String USER_NAME = CreditConfig.userName();

	private static final String PASSWORD = CreditConfig.password();

	// 操作人身份标识 具体使用数据的人员身份标识，只记录。
	private static final String UNAME = CreditConfig.uname();
	// 查询用途
	private static final String CXYT = CreditConfig.cxyt();

	private static final Logger LOGGER = LoggerFactory.getLogger(XyptWebServiceUtil.class);

	private static String httpProxyHost = null;
	private static int httpProxyPort = 0;
	private static String httpProxyUser = null;
	private static String httpProxyPwd = null;

	static {
		String httpProxy = System.getenv("http_proxy");
		if (StringUtils.isNotBlank(httpProxy)) {
			try {
				URI httpProxyUri = new URI(httpProxy);

				httpProxyHost = httpProxyUri.getHost();
				httpProxyPort = httpProxyUri.getPort();
				if (StringUtils.isNotEmpty(httpProxyUri.getUserInfo())) {
					UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(httpProxyUri.getUserInfo());
					httpProxyUser = credentials.getUserName();
					httpProxyPwd = credentials.getPassword();
				}

			} catch (Exception e) {
				LOGGER.error("获取代理地址失败！", e);
			}
		}
	}

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

			if (StringUtils.isNotEmpty(httpProxyHost) && httpProxyPort > 0) {
				serviceModel.setProperty(CommonsHttpMessageSender.DISABLE_PROXY_UTILS, true);
				serviceModel.setProperty(CommonsHttpMessageSender.HTTP_PROXY_HOST, httpProxyHost);
				serviceModel.setProperty(CommonsHttpMessageSender.HTTP_PROXY_PORT, httpProxyPort + "");
				if (StringUtils.isNotEmpty(httpProxyUser)) {
					serviceModel.setProperty(CommonsHttpMessageSender.HTTP_PROXY_USER, httpProxyUser);
					serviceModel.setProperty(CommonsHttpMessageSender.HTTP_PROXY_PASS, httpProxyPwd);
				}
			}

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
