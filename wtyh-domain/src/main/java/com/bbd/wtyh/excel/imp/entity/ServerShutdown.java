package com.bbd.wtyh.excel.imp.entity;

import com.bbd.wtyh.excel.imp.utils.ImpRecordUtil;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 通过init和destroy来修改导入记录的状态。将所有处理中的记录置为错误，并备注"服务器关闭"
 *
 * @author Created by LiYao on 2017-07-24 14:02.
 */
@Component
@DependsOn({ "applicationContextUtil", "baseServiceImpl" })
public class ServerShutdown {

	@PostConstruct
	private void init() {
		ImpRecordUtil.serverShutdown();
	}

	@PreDestroy
	private void destroy() {
		ImpRecordUtil.serverShutdown();
	}

}
