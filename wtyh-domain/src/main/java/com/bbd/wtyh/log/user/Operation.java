package com.bbd.wtyh.log.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		blank("--", 0, true, true),  //blank("[blank]", 0)
		login("登录页面", 1, true, true),
		home("平台首页", 2, true, true),

		borrow("网络借贷", 3, true, false),
		licaiHome("线下理财", 4, true, false),
		loan("小额贷款", 5, true, false),
		guarantee("融资担保", 6, true, false),
		privateFund("私募基金", 7, true, false),
		exchange("交易场所", 8, true, false),
		crowdFunding("众筹", 9, true, false),
		pawn("典当", 10, true, false),
		financeLease("融资租赁", 11, true, false),
		factoring("商业保理", 12, true, false),
		prepaid("预付卡", 13, true, false),

		licaiRisk("线下理财详情", 14, true, false),
		platform("网络借贷详情", 15, true, false),

		hologram("全息信息页面", 16, true, false),

		park("园区监测", 17, true, false),
		building("楼宇页面", 18, true, false),

		realCtrl("实时监测页面", 19, true, false),

		userList("用户列表", 20, false,true),
		userOwnInfo("个人中心", 21, true, true),
		userCreate("新增用户", 22, false ,true),
		userInfoModify("编辑用户", 23, false, true ),
		userOwnPwdModify("修改密码", 24, true, true), //自己的
		userLogList("日志审计", 25, false, true),
		userInfoBrowse("用户信息浏览" ,26, false, true ),

		roleList("角色列表", 27, false, true),
		roleBrowse("浏览角色", 28, false, true),
		roleCreate("新增角色", 29, false, true),
		roleModify("编辑角色", 30, false, true),
		roleAssign("分配角色", 31, false, true),

		companyAddClose("企业增销", 32, false, true),
		companyRiskChange("风险变化企业", 33, false, true),
		naturalPerson("自然人检索", 34, false, true),
		informationReport("排查信息上报", 35, false, true)
		; //


		/** 页面 */
		private String page;
		/** 代码 */
		private int code;
		/** 存在于在前台系统中*/
		private boolean inForeSys;
		/** 存在于在后台系统中*/
		private boolean inBackSys;

		Page(String page, int code, boolean inForeSys, boolean inBackSys) {
			this.page = page;
			this.code = code;
			this.inForeSys = inForeSys;
			this.inBackSys = inBackSys;
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

		public static final String OP_PAGE_MAP_KEY ="opPageMap"; //返回map的KEY

		/**
		 * 生成Page列表及字典
		 * @param joinAll 是否加入“全部”项
		 * @param sys null：所有页面，front 前台页面，back：后台页面
		 * @param returnMap 是否返回Page字典
		 * @return 返回List<Map>结果。注意：map字典是附加到List.Map.Map中返回的，若true ==returnMap，
		 * 提取后应去除List最后这个元素{remove(size-1)}。
		 */
		public static List<Map<String, Object>> getOpPageListBySystem(boolean joinAll, System sys, boolean returnMap) {
			String codeName ="opPgCd"; //code of name
			String nameName ="opPage"; //name of name
			return new ArrayList<Map<String, Object>>() {{
				if( joinAll ) {
					add(new HashMap<String, Object>() {{
						put(codeName, (Integer) (-1));
						put(nameName, "全部");
					}});
				}
				for (Page opPg : Page.values()) {
					if( opPg.code >0 && ( null ==sys ||( sys.equals(System.front) &&opPg.inForeSys )
							||( sys.equals(System.back) &&opPg.inBackSys ) )  ) {
						add(new HashMap<String, Object>() {{
							put(codeName, (Integer) opPg.code());
							put(nameName, opPg.page());
						}});
					}
				}
				if( returnMap ) {
					Map<Integer, String> opPageMap = new HashMap<>();
					for ( Map<String, Object>itr: this ) { //构造一个操作页面字典
						opPageMap.put( (Integer) itr.get("opPgCd") , (String) itr.get("opPage"));
					}
					add( new HashMap<String, Object>() {{
						put(OP_PAGE_MAP_KEY, opPageMap);
					}} );
				}
			}};
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
		lock("锁定", 8),
		active("激活", 9),
		REPORT_EXPORT("报告导出",10),
		DATA_EXPORT("数据导出",11),
		LOG_EXPORT("日志导出",12),
		INFO_REPORT("排查信息上报", 13);

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
