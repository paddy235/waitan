package com.bbd.shanghai.credit.utils;

import com.bbd.shanghai.credit.service.XyAppQueryService;
import org.apache.commons.httpclient.params.HttpClientParams;
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
import java.util.Random;

/**
 * 信用平台webService工具类
 *
 * @author Created by LiYao on 2017-04-24 14:36.
 */
public class XyptWebServiceUtil {

	// private static final String SERVICE_URL =
	// "http://127.0.0.1:8082/xyxxfwpt/services/XyAppQuery";

	private static  String SERVICE_URL = CreditConfig.serviceUrl();

	private static  String USER_NAME = CreditConfig.userName();

	private static  String PASSWORD = CreditConfig.password();

	// 操作人身份标识 具体使用数据的人员身份标识，只记录。
	private static  String UNAME = CreditConfig.uname();
	// 查询用途
	private static  String CXYT = CreditConfig.cxyt();

	private static int TIMEOUT = CreditConfig.timeOut();

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
			SERVICE_URL = CreditConfig.serviceUrl();
			USER_NAME = CreditConfig.userName();
			PASSWORD = CreditConfig.password();
			UNAME = CreditConfig.uname();
			CXYT = CreditConfig.cxyt();
			TIMEOUT = CreditConfig.timeOut();

			ObjectServiceFactory oClass = new ObjectServiceFactory();
			Service serviceModel = oClass.create(XyAppQueryService.class);

			//设置连接参数
			if(TIMEOUT>0){

				HttpClientParams params = new HttpClientParams();
				params.setParameter(HttpClientParams.USE_EXPECT_CONTINUE, Boolean.FALSE);
				params.setParameter(HttpClientParams.CONNECTION_MANAGER_TIMEOUT, (long)(TIMEOUT * 1000));
				serviceModel.setProperty(CommonsHttpMessageSender.HTTP_CLIENT_PARAMS,params);
			}


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

			Random random = new Random();
			int i=random.nextInt(3);
			if(i==0){
				return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><GRZX name=\"" +
						dwmc +
						"\" zjhm=\"null\" tydm=\"null\" cxbh=\"JKCX201706061455331004001000028469\"><RESULT>1005</RESULT><RESOURCE XXSSDWDM=\"D010025\" XXLB=\"监管类\" RESOURCENAME=\"经营异常名录\" XXSSDW=\"市工商局\" RESOURCES=\"except\" RESOURCECODE=\"except\"><move_in_reason>通过登记的住所或者经营场所无法联系的</move_in_reason><undo_date></undo_date><move_in_organ_id></move_in_organ_id><undo_reason></undo_reason><move_in_date>20170210</move_in_date></RESOURCE></GRZX>";
			}else if(i==1){
				return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><GRZX name=\"" +
						dwmc +
						"\" zjhm=\"null\" tydm=\"null\" cxbh=\"JKCX201706061455561004001000073736\"><RESULT>1003</RESULT></GRZX>";
			}else if(i==2){
				return "50X";
			}else{
				return service.queryFrKxHonest(dwmc, zzjgdm, tydm, USER_NAME, PASSWORD, CXYT, UNAME);
			}
			//return service.queryFrKxHonest(dwmc, zzjgdm, tydm, USER_NAME, PASSWORD, CXYT, UNAME);
		} catch (Exception e) {

			String msg = "获取公司：【%s/%s/%s】信用信息出错。请求地址：%s，参数：dwmc：%s，zzjgdm：%s，tydm：%s，username：%s，password：%s，cxyt：%s，uname：%s";
			msg = String.format(msg, dwmc, zzjgdm, tydm, SERVICE_URL, dwmc, zzjgdm, tydm, USER_NAME, "***", CXYT, UNAME);
			LOGGER.error(msg, e);

			String message=e.getMessage();
			if(message!=null && message.contains("Server returned error code = 50")){
				return "50X";
			}
			return null;
		}
	}

}
