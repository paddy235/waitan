package com.bbd.wtyh.constants;

/**
 * 常量类
 */
public class Constants {

	// 加密salt
	public static final String SALT = "123456";//
	// 状态值
	public static final String ACTIVE = "A";// 激活

	public static final String FREEZE = "F";// 冻结

	public static final String DEFAULT_ROLE = "D";// 预设模板角色

	public static final String ALL = "A";// 所有

	public static final String UNDEFINED = "U";// 未定义

	public static class role {

		/** 角色类型：临时角色 */
		public static final String TYPE_TEMP = "T";
		/** 超级管理员角色类型 */
		public static final String TYPE_SUPER = "S";
		/** 预设模板角色类型：系统管理员角色 普通用户角色 */
		public static final String TYPE_DEFAULT = "D";
		/** 正式角色类型 */
		public static final String TYPE_REGULAR = "R";

	}

	public static class resource {

		/** redis key:resource:code:id。用于存放权限code和Id 的对应关系 */
		public static final String REDIS_KEY_RESOURCE_CODE_ID = "resource:code:id";

	}

	/** 风险变化公司 */
	public static class RiskChgCo {

		/** 来源：人工修改 */
		public static final Integer SOURCE_MANUAL_MODIFY = 1;
		/** 来源：模型评分 */
		public static final Integer SOURCE_MODEL_SCORE = 2;
	}

	// 角色类型

	// 权限列表
	public static final String F_HYJCPT = "F_HYJCPT";// 行业监测平台

	public static final String F_HYJCPT_WLJD = "F_HYJCPT_WLJD";// 网络借贷

	public static final String F_HYJCPT_XXLC = "F_HYJCPT_XXLC";// 线下理财

	public static final String F_HYJCPT_XEDK = "F_HYJCPT_XEDK";// 小额贷款

	public static final String F_HYJCPT_RZDB = "F_HYJCPT_RZDB";// 融资担保

	public static final String F_HYJCPT_SMJJ = "F_HYJCPT_SMJJ";// 私募基金

	public static final String F_HYJCPT_JYCS = "F_HYJCPT_JYCS";// 交易场所

	public static final String F_HYJCPT_ZC = "F_HYJCPT_ZC";// 众筹

	public static final String F_HYJCPT_DD = "F_HYJCPT_DD";// 典当

	public static final String F_HYJCPT_RZZP = "F_HYJCPT_RZZP";// 融资租赁

	public static final String F_HYJCPT_SYBL = "F_HYJCPT_SYBL";// 商业保理

	public static final String F_HYJCPT_YFK = "F_HYJCPT_YFK";// 预付卡

	public static final String F_YQJCPT = "F_YQJCPT";// 园区监测平台

	public static final String F_QYQXXXCXPT = "F_QYQXXXCXPT";// 企业全息信息查询平台

	public static final String F_SSJCPT = "F_SSJCPT";// 实时监测平台

	public static final String B_HTGLQX = "B_HTGLQX";// 用户角色管理

	public static final String B_YHRZGL = "B_YHRZGL";// 用户日志管理

	public static final String B_DSRWGL = "B_DSRWGL";// 定时任务管理

}