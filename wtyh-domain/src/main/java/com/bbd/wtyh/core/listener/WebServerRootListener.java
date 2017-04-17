package com.bbd.wtyh.core.listener;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;

/**
 * 服务器根目录
 *
 * @author Created by LiYao on 2017-03-21 14:00.
 */
public class WebServerRootListener implements ServletContextListener {

	public WebServerRootListener() {
	}

	public void contextInitialized(ServletContextEvent event) {
		WebUtils.setWebAppRootSystemProperty(event.getServletContext());
		setWebServerRootSystemProperty(event.getServletContext());
	}

	public void contextDestroyed(ServletContextEvent event) {
		WebUtils.removeWebAppRootSystemProperty(event.getServletContext());
		Assert.notNull(event.getServletContext(), "ServletContext must not be null");
		String param = event.getServletContext().getInitParameter("webAppRootKey");
		String key = param != null ? param : "server.root";
		System.getProperties().remove(key);
	}

	private void setWebServerRootSystemProperty(ServletContext servletContext) throws IllegalStateException {
		Assert.notNull(servletContext, "ServletContext must not be null");
		String param = servletContext.getInitParameter("webServerRootKey");
		String key = param != null ? param : "server.root";

		String osName = System.getProperty("os.name");
		if (StringUtils.isNotBlank(osName) && osName.toUpperCase().startsWith("WIN")) {
			File[] listRoots = File.listRoots();
			System.setProperty(key, listRoots[listRoots.length - 1] + File.separator + "wtyh_logs" + File.separator);
			return;
		}

		String root = servletContext.getRealPath("/");
		if (root == null) {
			throw new IllegalStateException("Cannot set web app root system property when WAR file is not expanded");
		}
		String[] strs = StringUtils.split(root, File.separator);
		if (root.startsWith(File.separator)) {
			// 表示往后退两层
			root = File.separator + StringUtils.join(strs, File.separator, 0, strs.length - 2) + File.separator;
		} else {
			root = StringUtils.join(strs, File.separator, 0, strs.length - 2) + File.separator;
		}

		System.setProperty(key, root);
		servletContext.log("Set web app root system property: \'" + key + "\' = [" + root + "]");
	}
}
