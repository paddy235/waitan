package com.bbd.bgo.service.task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.service.RelationDataService;
import com.bbd.wtyh.service.SyncDataService;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-05-18 9:53.
 */
@Service
public class SyncFileServiceImpl extends BaseServiceImpl implements SyncFileService {

	private static final Logger logger = LoggerFactory.getLogger(SyncFileServiceImpl.class);

	private static final String PULL_FILE_SAVE_PATH = "/data1/wtyh/admin/";

	@Autowired
	private SyncDataService syncDataService;

	@Autowired
	private RelationDataService relationDataService;

	@Value("${api.bbd.broker.ip}")
	private String brokerIp;
	private String brokerUri = "/syncFile/supplyFile.do";
	private String httpProxy = System.getenv("http_proxy");

	@Override
	public void pullFile() {
		try {
			logger.info("--------- pull data file start ------");
			String dataVersion = relationDataService.getNewestDataVersion();
			logger.info("--------- pull dataVersion ---------：" + dataVersion);

			String url = brokerIp+brokerUri+ "?dataVersion=" + dataVersion;

			HttpGet httpRequest = new HttpGet(url);
			HttpClientBuilder httpClientBuilder = HttpClients.custom();
			// 设置http代理
			if (StringUtils.isNotEmpty(httpProxy)) {
				URI httpProxyUri = new URI(httpProxy);
				if (StringUtils.isNotEmpty(httpProxyUri.getUserInfo())) {
					CredentialsProvider credsProvider = new BasicCredentialsProvider();
					credsProvider.setCredentials(new AuthScope(httpProxyUri.getHost(), httpProxyUri.getPort()),
							new UsernamePasswordCredentials(httpProxyUri.getUserInfo()));
					httpClientBuilder.setDefaultCredentialsProvider(credsProvider);
				}
				httpClientBuilder.setProxy(new HttpHost(httpProxyUri.getHost(), httpProxyUri.getPort(), httpProxyUri.getScheme()));
			}
			httpRequest.setConfig(RequestConfig.custom().setConnectTimeout(36000 * 1000).setSocketTimeout(36000 * 1000).build());
			CloseableHttpResponse response = httpClientBuilder.build().execute(httpRequest);
			InputStream inputStream = response.getEntity().getContent();

			String fileName = dataVersion + ".txt";

			File file = new File(PULL_FILE_SAVE_PATH + fileName);
			FileUtils.forceMkdirParent(file);
			IOUtils.copyLarge(inputStream, new FileOutputStream(file));
			logger.info("--------- pull data file end --------");

			logger.info("--------- parse data file start -----");
			this.syncDataService.receiveFileData(file);
			logger.info("--------- parse data file end -------");

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}
}
