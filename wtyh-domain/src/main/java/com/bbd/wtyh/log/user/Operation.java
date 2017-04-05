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

		blank("--", 0),  //blank("[blank]", 0)
		login("登录页面", 1),
		home("平台首页", 2),

		borrow("网络借贷", 3),
		licaiHome("线下理财", 4),
		loan("小额贷款", 5),
		guarantee("融资担保", 6),
		privateFund("私募基金", 7),
		exchange("交易场所", 8),
		crowdFunding("众筹", 9),
		pawn("典当", 10),
		financeLease("融资租赁", 11),
		factoring("商业保理", 12),
		prepaid("预付卡", 13),

		licaiRisk("线下理财详情", 14),
		platform("网络借贷详情", 15),

		hologram("全息信息页面", 16),

		park("园区监测", 17),
		building("楼宇页面", 18),

		realCtrl("实时监测页面", 19),

		userList("用户列表", 20),
		userOwnInfo("个人中心", 21), //用户(自我)信息(修改)
		userCreate("新增用户", 22),
		userInfoModify("编辑用户", 23 ),
		userOwnPwdModify("修改密码", 24), //自己的
		userLogList("日志审计", 25),
		userInfoBrowse("用户信息浏览" ,26 ),

		roleList("角色列表", 27),
		roleBrowse("浏览角色", 28),
		roleCreate("新增角色", 29),
		roleModify("编辑角色", 30),
		roleAssign("分配角色", 31)
		; //


		/** 页面 */
		private String page;
		/** 代码 */
		private int code;

		Page(String page, int code) {
			this.code = code;
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
		public int code() {
			return this.code;
		}
	}

	/**
	 * 用户操作类型
	 */
	public enum Type {
		login("登录", 1),
		logout("登出", 2),
		query("搜索", 3),
		browse("浏览", 4),
		add("新增", 5),
		modify("修改", 6),
		del("删除", 7),
		lock("锁定", 8), //
		active("激活", 9); //

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
		front(1, "前台"),
		back(2, "后台");

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
