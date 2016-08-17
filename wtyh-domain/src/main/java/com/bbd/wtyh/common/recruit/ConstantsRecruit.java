package com.bbd.wtyh.common.recruit;


import com.bbd.wtyh.util.relation.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;

public class ConstantsRecruit {
    public static String ctx;
    public static String isSaveRedis;//1 保存到redis 0是不保存到数据库
    public static String interfaceAesScret;//终端密钥des密钥
    public static String systemAesScret;//系统密钥des密钥
    public static String xinhua08AesScret;//新华08密钥
    public static String windowsAesScret;//window密钥
    public static String dafeiToHiggsBuyReportAesScret;//打非跳到浩格云购买报告
    public static final String isTerminal = "isTerminal";//终端
    public static final String terminalUser = "terminalUser";//终端
    public static final String filePath = "rals";//下载关联方法图片相对路径
    public static final String characterCode = "utf-8";
    public static final String enCode = "encode";
    public static final String SYSTEM_CODE = "system";
    public static final String SHOW_CODE = "show";
    public static final String admin = "admin";
    public static final String actionMethodMenu = "actionMethodMenu";
    public static final String actionButton = "actionButton";
    public static final String ACCESS_TOKEN = "273601cbd4ef2c358ab728025cb23e33";
    public static final String TABLE_QYXX = "qyxx";
    public static String data_search_version = ""; //search版本号
    public static final String SEARCH_TYPE_SEARCH = "search";
    public static final String SEARCH_REDIS = "search";
    public static final int searchRedis_time = 7;
    public static String registNotice = "";
    public static String addCount = "0";
    public static String dayCount = "0";
    public static final String UPDATE_TABLE = "update_records";
    public static final String thirdParty_roleId = "8";

    /**
     * 平安终端cookie的名字
     */
    public static final String TERMINAL_COOKIE_NAME = "_bbd_t_p";

    /**
     * 平安终端cookie的存在时间 ：７天
     */
    public static final int TERMINAL_COOKIE_AGE = 7*24*60*60;


    public static final String createSuccessUserName = "0"; //创建子用户 和 成功修改成功
    public static final String createSuccessUserNameErr = "1"; //父账号不存在
    public static final String createSuccessUserNameMoney = "2"; //充值金额异常
    public static final String createSuccessUserNameSAVESubAccountErr = "3"; //子账号添加网络异常
    public static final String createSuccessUserNameUPDATESubAccountErr = "4"; //子账号修改网络异常

    //	public static final String BIDDING_API_URL = "bidding.api.url";
    public static final String[] PROCUREMENT_ARRAY = {"项目名称", "项目编号", "地区", "行业", "资金来源", "代理机构名称", "招标期限", "开标时间", "招标公告发布时间", "中标单位名称", "中标公告发布时间"};
    public static final String[] SELL_ARRAY = {"项目名称", "项目编号", "地区", "行业", "招标单位名称", "资金来源", "代理机构名称", "招标期限", "开标时间", "招标公告发布时间", "中标公告发布时间"};

    //	public static final String KPI_API_URL = "kpi.api.url";//KPI接口 URL地址
//	public static final String KPI_API_INDUSTRY_URL = "kpi.api.industry.url";
//	public static final String KPI_API_COMMON_URL = "kpi.api.common.url";
//	public static final String KPI_API_PROP_URL = "kpi.api.prop.url";
    public static final String KPI_MARK = "1"; // 非财务共有指标标识
    public static final String KPI_NON_MARK = "0"; // 非财务专属指标标识
    public static final String KPI_COMMON_MARK = "1"; // 非财务共有指标标识
    public static final String KPI_PROP_MARK = "0"; // 非财务专属指标标识
    public static final String YEAR_WORD = "年";

//	public static final String YU_API_URL = "yu.api.url";

    public static final String WEB_DOMAIN = "web.doamin";//系统域名
    public static final String SCREEN_SHOOT_DOAMIN = "screen.shoot.doamin";//截屏域名

//	public static final String API_COMPANYSEARCH_URL = "api.companysearch.url";
//	public static final String RELATION_API_URL="relation.api.url";

    //	public static final String SUSONG_API_URL="susong.api.url";
//	public static final String COURT_NOTICE_API_URL = "court.notice.api.url"; // 法院公告接口 add by Barney Lau 2016-01-08
//	public static final String API_ZHAOZHONGBIAO_URL_NEW ="bidding.api.url.new"; //招中标新接口
//	public static final String API_SEARCH_URL = "api.search.url";
    //public static final String API_SEARCH_URL_ZL = "api.search.url.zl"; //专利url
    public static final Integer API_SEARCH_URL_ZL_page = -1; //专利不分页提供pdf下载
    public static final Integer API_SEARCH_URL_ZL_pageNum = 0; //专利不分页提供pdf下载

    public static final String EXCEL_SUFFIX = ".xlsx";
    public static final String[] titleArr = {"指标类别", "指标", "指标值", "行业平均KPI", "(具体KPI)/(行业平均KPI)"};
    public static final Map<String, Integer> nonKpiSeq = new HashMap<String, Integer>();

    //	public static String staticDataVersion;//静态只读数据库当前版本
//	public static String relationDataVersion;//关联方数据库当前版本
//	public static String data_version = "";//Api版本号
//	public static String related_party_hbase = "";//关联方版本号
//	public static String SSJL_DATA_VERSION = ""; // 诉讼记录API版本号
    public static final String SEARCH_FIELDS = "名称";
    public static final String SEARCH_HISTORY = "history_name";

    public static String registerFilter;//工商注册信息过滤链
    public static String shareDir;//分享附件文件夹
    public static String mappingPath;//附件文件夹映射到服务器的目录
    public static String attDir = "att";//
    public static String hbaseHost;
    public static String hbasePort;
    public static String hbaseKVMaxSize = "524288000";

    public static final String CLIENT_TYPE_COMMON = "common";
    public static final String CLIENT_TYPE_PINGAN = "pingan";
    public static final String CLIENT_TYPE_CQYH = "cqyh";
    public static final String CLIENT_TYPE_XYYH = "xyyh";
    public static final String CLIENT_TYPE_ZHONGJINGSHE = "zhongjingshe";

    public static Map<String, String> waterMarkerMap;//水印配置文件 对应为

//	public static List<Date> urlVesionDateList; //数据库表中存在的版本时间进行排序存储
//	public static Map<Date,List<UrlMapping>> urlMappings;//缓存url版本数据
//	public static Map<String, List<UrlMapping>> urlMappings; // URL版本数据系统级缓存

    public static Map<String, String> attPath = new HashMap<String, String>();
    ;

    static {
        attPath.put("pingan", "pingan");
        attPath.put("xyyh", "xyyh");
        attPath.put("cqyh", "cqyh");
        attPath.put("zhongjingshe", "zhongjingshe");
        attPath.put("common", "common");
    }
    /*//存储rediskey  普通用户附件缓存路径
	public static final String redis_common_attPath ="_common_attPath";
	//存储rediskey  平安终端附件缓存路径
	public static final String redis_paclient_attPath ="_paclient_attPath";*/

    public static long cacheDays;//redis缓存天数


    public static final class SESSION {
        public static final String permissionList = "permissionList"; //权限菜单
        public static final String gradeCode = "gradeCode";
        public static final String loginname = "loginname";//兼容以前的，所以n小写
        public static final String loginnameCn = "loginnameCn";//兼容以前的，所以n小写
        public static final String userType = "userType";//是否为管理账号
        public static final String email = "query.email";//是否为管理账号
        public static final String ctx = "ctx";
        public static final String cpuCode = "cpuCode";//cpu编码
        public static final String mainBoardCode = "mainBoardCode";//主板编码
        public static final String showLoginName = "showLoginName"; //前台用户名
        public static final String loginName = "loginName"; //前台用户名
        public static final String showRoles = "showRoles"; // 前台用户角色Id
        public static final String frontAdminCode = "frontAdminCode"; // 前后台角色
        public static final String xhLevel = "D"; //新华08  套系
        public static final String consumer = "consumer";

    }

    public static final class CAPTCHA {
        public static final String errorTimes = "errorTimes"; //登陆次数
        public static final String j_captcha = "j_captcha"; //前面传值到后面
        public static final String captchaInfo = "captchaInfo"; //提示使用
    }

    //账号类型
    public static final class UserType {
        public static final String str_0 = "0";//后台账号
        public static final String str_1 = "1";//普通账号
        public static final String str_2 = "2";//终端基础账号
        public static final String str_3 = "3";//平安定制
        public static final String str_4 = "4";//新华08
        public static final String str_6 = "6";//代理商
        public static final String str_7 = "7";//代理商客户
        public static final String str_8 = "8";//打非请求
        public static final String str_9 = "9";//window终端用户
        public static final String str_10 = "A";//第三方平台用户
    }

    //购买类型
    public static final class BuyType {
        public static final Integer give_type = 0;   //赠送类型
        public static final Integer buy_type = 1;   //购买类型
        public static final Integer share_type = 2; //共享类型
        public static final Integer update_type = 3; //升级
        public static final Integer renew_type = 4; //续费
    }

    //前端登陆账号角色
    public static final class CUSTOMER_ROLE {
        public static final String str_1 = "1";//普通A套系
        public static final String str_2 = "2";//普通E套系
        public static final String str_3 = "3";//后代理商A套系
        public static final String str_4 = "4";//代理商E套系
        public static final String str_5 = "5";//平安终端E套系
        public static final String str_6 = "6";//新华08E套系
        public static final String str_7 = "7";//母账号套系
    }

    //后端信息推送，对应账号类型(同上)
    public static List<String> ManagementTypelIST = new ArrayList<String>();

    static {
        ManagementTypelIST.add("0");
        ManagementTypelIST.add("1");
        ManagementTypelIST.add("2");
        ManagementTypelIST.add("3");
        ManagementTypelIST.add("4");
        ManagementTypelIST.add("6");
        ManagementTypelIST.add("7");
    }

    //NoticInfo表的type
    public static final class NoticInfoType {
        public static final String str_1 = "1";//全员通知
        public static final String str_2 = "2";//代理商下用户注册通知
    }

    // 套系类型
    public static final class SetType {
        public static final String A = "A";// A
        public static final String E = "E";// E
        public static final String S = "S";// S
        public static final String D = "D";// 只针对新华08的套系
    }

    //套系价钱
    public static Map<String, BigDecimal> setTypeMap = new HashMap<String, BigDecimal>();

    static {
        setTypeMap.put(SetType.A, new BigDecimal(200));//A套系200元
        setTypeMap.put(SetType.E, new BigDecimal(500));//E套系500元
        setTypeMap.put(SetType.S, new BigDecimal(2000));//S套系2000元
    }

    //system_parameter表查询常量
    public static final class SystemParameter {
        public static final String IMAGE_LOGO = "IMAGE_LOGO";//水印查询常量
    }





    // 系统自带的方法，所有人都有此功能
    public static Map<String, String> SystemActionMethod = new HashMap<String, String>();
    public static Map<String, String> provinceMap = new HashMap<String, String>();

//    public static List<ReportDescVO> S_LIST = new ArrayList<ReportDescVO>();
//    public static List<ReportDescVO> E_LIST = new ArrayList<ReportDescVO>();
//    public static List<ReportDescVO> A_LIST = new ArrayList<ReportDescVO>();


    static {
        provinceMap.put("北京", null);
        provinceMap.put("天津", null);
        provinceMap.put("上海", null);
        provinceMap.put("重庆", null);
        provinceMap.put("河北", null);
        provinceMap.put("山西", null);
        provinceMap.put("陕西", null);
        provinceMap.put("山东", null);
        provinceMap.put("河南", null);
        provinceMap.put("辽宁", null);
        provinceMap.put("吉林", null);
        provinceMap.put("黑龙江", null);
        provinceMap.put("江苏", null);
        provinceMap.put("浙江", null);
        provinceMap.put("安徽", null);
        provinceMap.put("江西", null);
        provinceMap.put("福建", null);
        provinceMap.put("湖北", null);
        provinceMap.put("湖南", null);
        provinceMap.put("四川", null);
        provinceMap.put("贵州", null);
        provinceMap.put("云南", null);
        provinceMap.put("广东", null);
        provinceMap.put("海南", null);
        provinceMap.put("甘肃", null);
        provinceMap.put("青海", null);
        provinceMap.put("台湾", null);
        provinceMap.put("内蒙古", null);
        provinceMap.put("新疆", null);
        provinceMap.put("西藏", null);
        provinceMap.put("广西", null);
        provinceMap.put("宁夏", null);

//        ReportDescVO rd1 = new ReportDescVO("基本资料", "企业的工商注册基本信息、股东信息和管理层信息。其中包括企业信息，投资人名称和类型，董事会、监事会及高级管理人才的名称及职务。");
//        ReportDescVO rd2 = new ReportDescVO("静态图谱", "企业DNA图谱，迅速定位企业结构。");
//        ReportDescVO rd3 = new ReportDescVO("动态图谱", "涉及目标企业与发生投资及管理行为关系的自然人（公司）的三级关联网络图谱，包含子公司、一度关联自然人（公司）、二度关联自然人（公司）。");
//        ReportDescVO rd4 = new ReportDescVO("KPI分析", "提供企业的财务和非财务指标，同时给定行业标准和企业行业位置。");
//        ReportDescVO rd5 = new ReportDescVO("诉讼记录", "涉及目标企业在近三年内裁判文书、失信人被执行信息。");
//        ReportDescVO rd6 = new ReportDescVO("招聘指数", "根据企业的招聘数据全面分析出企业所在行业招聘匹配度，招聘人员指数，职位分布，薪酬区间。");
//        ReportDescVO rd7 = new ReportDescVO("招中标", "包括目标公司的招标及中标信息。");
//
//        ReportDescVO rd31 = new ReportDescVO("动态图谱", "涉及目标企业与发生投资及管理行为关系的自然人（公司）的三级关联网络图谱，包含子公司、一度关联自然人（公司）、二度关联自然人（公司）、三度关联自然人（公司）。");
//        ReportDescVO rd51 = new ReportDescVO("诉讼记录", "涉及目标企业在近三年内裁判文书、失信人被执行信息，和实时的开庭公告。");

//        S_LIST.add(rd1);
//        S_LIST.add(rd2);
//        S_LIST.add(rd31);
//        S_LIST.add(rd4);
//        S_LIST.add(rd51);
//        S_LIST.add(rd6);
//        S_LIST.add(rd7);
//
//        E_LIST.add(rd1);
//        E_LIST.add(rd2);
//        E_LIST.add(rd31);
//        E_LIST.add(rd4);
//        E_LIST.add(rd51);
//
//        A_LIST.add(rd1);
//        A_LIST.add(rd2);
//        A_LIST.add(rd3);
//        A_LIST.add(rd4);
//        A_LIST.add(rd5);

        nonKpiSeq.put("关联图谱基本面", 0);
        nonKpiSeq.put("管理层基本面", 1);
        nonKpiSeq.put("其他", 2);
    }

    public static final Integer ClickNumber = 1;//统计累加值
    public static final Integer InitialValue = 0;//初始值

    //	public static List<String> downloadEAPList;  //下载统计
//	public static List<String> modularList; //模块点击量统计
//	public static List<String> modularPDFList; //模块点击量统计
    public static Map<String, String> gotoPage;

    //购买初始状态
    public static final class consumer {
        public static final String buy_state = "0";
        public static final String buy_level = "E";
        public static final String buy_reportPrice = "500";
        public static final String buy_amountMoney = "0.0";
        public static final String buy_roleId = "2";
    }


    // 是与否
    public static final class YesOrNo {
        public static final String YES = "1";
        public static final String NO = "0";
        public static final String YN = "-1";
    }

    //customer_table表和statu
    public static final class CUSTOMER_STATUS {
        public static final String str_0 = "0";//注册成功,未激活
        public static final String str_1 = "1";//激活成功
        public static final String str_2 = "2";
    }

    //USERRECYCLINGSTATION表和statu
    public static final class USERRECYCLINGSTATION_STATUS {
        public static final String strate_1 = "1";//删除到回收站
        public static final String strate_2 = "2";//从回收站删除
    }

    //PDF、图谱、Excel生成方法调用标识
    public static final class CreateFileMethod {
        public static final String PDF = "1";
        public static final String PICTURE = "2";
        public static final String EXCEL = "3";
    }

    //文件生成状态
    public static final class CreateFileStatus {
        public static final String INIT = "0";
        public static final String SUCCESS = "1";
        public static final String FAIL = "2";
    }

    public static final class ZipFileStatus {
        public static final String INIT = "0";
        public static final String SUCCESS = "1";
        public static final String FAIL = "2";
    }

    //时间标识
    public static final class TimeFlag {
        public static final String ONEWEEK = "1";
        public static final String ONEMONTH = "2";
        public static final String THREEMONTHS = "3";
        public static final String THREEDAYS = "4";
        public static final String HARFAYEAR = "5";
    }

    //common_data表的type字段类型
    public static final class COMMON_DATA_TYPE {
        public static final String str01 = "01"; // 招聘行业匹配度
        public static final String str01_1 = "01-1"; //1代表招聘行业匹配度第一条线
        public static final String str01_2 = "01-2"; //1代表招聘行业匹配度第二条线
        public static final String str02 = "02"; //招聘人数指数
        public static final String str03 = "03"; //招聘人数指数圆饼
        public static final String str04 = "04"; //为薪酬分布
        public static final String str05 = "05";  //下属关联公司注资总和
    }

    public static void loadProperties() {
        Properties systemProp = new Properties();
        Properties priviledgeProp = new Properties();
        InputStream systemIn = null;
        InputStream priviledgeIn = null;
        try {
            systemIn = ConstantsRecruit.class.getClassLoader().getResource("config/system.properties").openStream();
            priviledgeIn = ConstantsRecruit.class.getClassLoader().getResource("config/priviledge.properties").openStream();
            systemProp.load(systemIn);
            priviledgeProp.load(priviledgeIn);

            Set<Object> priviledgeKey = priviledgeProp.keySet();
            if (priviledgeKey != null) {
                for (Object o : priviledgeKey) {
                    String values = priviledgeProp.getProperty(o.toString()).trim();
                    String[] value = values.split(",");
                    for (String str : value) {
                        if (ConstantsRecruit.SYSTEM_CODE.equals(str)) {
                            SystemActionMethod.put(o.toString(), str);
                        } else {
                            SystemActionMethod.put(o.toString() + "@" + Utils.trimString(str), str);
                        }
                    }
                }
            }
            isSaveRedis = systemProp.getProperty("isSaveRedis", "0").trim();
            interfaceAesScret = systemProp.getProperty("interfaceAesScret", "1234567887654321").trim();
            systemAesScret = systemProp.getProperty("systemAesScret", "12345678abcdefgh").trim();
            xinhua08AesScret = systemProp.getProperty("xinhua08AesScret", "abcdefghijklmnop").trim();
            windowsAesScret = systemProp.getProperty("windowsAesScret", "12345678abcdabc").trim();
            dafeiToHiggsBuyReportAesScret = systemProp.getProperty("dafeiToHiggsBuyReportAesScret", "1234567887654321").trim();
            registerFilter = systemProp.getProperty("registerFilter", "").trim();
            shareDir = systemProp.getProperty("sharePath", "").trim();
            mappingPath = systemProp.getProperty("mappingPath", "").trim();
            cacheDays = Long.parseLong(systemProp.getProperty("cacheDays", "").trim()) * 24 * 3600;
            registNotice = systemProp.getProperty("registNotice", "").trim();
            hbaseHost = systemProp.getProperty("hbase.host", "").trim();
            hbasePort = systemProp.getProperty("hbase.port", "").trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
