package com.bbd.bgo.service.impl;

import com.bbd.bgo.service.SyncFileService;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.service.RelationDataService;
import com.bbd.wtyh.service.SyncDataService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-05-18 9:53.
 */
@Service
public class SyncFileServiceImpl extends BaseServiceImpl implements SyncFileService {

	private static final Logger logger = LoggerFactory.getLogger(SyncFileServiceImpl.class);

	private static final String PULL_FILE_SAVE_PATH = "/data/wtyh/admin/";

	@Autowired
	private SyncDataService syncDataService;

	@Autowired
	private RelationDataService relationDataService;

	@Value("${api.bbd.broker.url}")
	private String brokerUrl;

	@Override
	public void pullFile() {
		try {
			logger.info("--------- pull data file start ------");
			String dataVersion = relationDataService.getNewestDataVersion();
			logger.info("--------- pull dataVersion ---------：" + dataVersion);
			HttpGet httpRequest = new HttpGet(brokerUrl + "?dataVersion=" + dataVersion);
			httpRequest.setConfig(RequestConfig.custom().setConnectTimeout(3600 * 1000).setSocketTimeout(3600 * 1000).build());
			CloseableHttpResponse response = HttpClients.createDefault().execute(httpRequest);
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
