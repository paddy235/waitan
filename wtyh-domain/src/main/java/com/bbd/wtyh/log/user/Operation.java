package com.bbd.wtyh.log.user;

/**
 * 用户操作
 *
 * @author Created by LiYao on 2017-03-17 16:59.
 */
public class Operation {

	/**
	 * 用户操作页码
	 */
	public enum Page {
		hologramSearch("企业全息信息查询平台", "/hologram/search.do"),
		enterprisehologram("公司全息页面", "/offlineFinance/queryDynamicPicDataRealTime.do"),
		realCtrl("实时监测页面", "/realTimeMonitor/spectrumAnalysis.do"),

		blank("", ""), home("首页", "/getSysAnalyze.do"), borrow("网络借贷", "/PToPMonitor/platRankData.do"),
		licai("线下理财", "/risk/getScanner.do"), loan("小额借贷", "/loan/areaStatistic.do"), guarantee("融资担保", "/guarantee/areaStatistic.do"),
		privateFund("私募基金", "/privateFund/qflpInfoList.do"), exchange("交易场所", "/exchangeCompany/exchangeCompanyCategory.do"),
		crowdFunding("众筹", "/crowdFunding/distribute.do"), pawn("典当", "/mortgage/companyList.do"),
		financeLease("融资租赁", "/financeLease/leaseCompanyStatistic.do"), factoring("商业保理", "/factoring/companys.do"),
		prepaid("预付卡", "/prepaid/amount.do");

		/** 页面 */
		private String page;
		/** 地址 */
		private String uri;

		Page(String page, String uri) {
			this.uri = uri;
			this.page = page;
		}

		/**
		 * 获取 页面
		 *
		 * @return page 页面
		 */
		public String page() {
			return this.page;
		}

		/**
		 * 获取 地址
		 *
		 * @return uri 地址
		 */
		public String uri() {
			return this.uri;
		}
	}

	/**
	 * 用户操作类型
	 */
	public enum Type {
		login("登录", 1), logout("登出", 2), query("查询", 3), browse("浏览", 4), add("新增", 5), modify("修改", 6), del("删除", 7), lock("锁定", 8);

		private String desc;
		private int code;

		Type(String desc, int code) {
			this.desc = desc;
			this.code = code;
		}

		/**
		 * 描述
		 *
		 * @return 描述
		 */
		public String desc() {
			return desc;
		}

		/**
		 * 代码
		 *
		 * @return 代码
		 */
		public int code() {
			return code;
		}
	}

	public enum System {
		front(1, "前台"), back(2, "后台");

		/** 系统代码 */
		private int sysCode;
		/** 系统名称 */
		private String sysName;

		System(int sysCode, String sysName) {
			this.sysCode = sysCode;
			this.sysName = sysName;
		}

		/**
		 * 获取 系统代码
		 *
		 * @return code 系统代码
		 */
		public int sysCode() {
			return this.sysCode;
		}

		/**
		 * 获取 系统名称
		 *
		 * @return name 系统名称
		 */
		public String sysName() {
			return this.sysName;
		}

	}

}
