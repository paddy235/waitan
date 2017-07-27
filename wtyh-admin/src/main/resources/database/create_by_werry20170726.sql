drop table if exists dishonesty;

/*==============================================================*/
/* Table: dishonesty                                            */
/*==============================================================*/
CREATE TABLE `dishonesty` (
  `dis_id` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) DEFAULT '0',
  `age` varchar(255) DEFAULT NULL COMMENT '年龄',
  `bbd_dotime` date DEFAULT NULL COMMENT '抓取时间',
  `bbd_source` varchar(200) DEFAULT NULL COMMENT '数据源',
  `bbd_type` varchar(200) DEFAULT NULL COMMENT 'bbd_type',
  `bbd_uptime` int(11) DEFAULT NULL COMMENT 'uptime',
  `bbd_url` varchar(2000) DEFAULT NULL COMMENT '链接',
  `bbd_xgxx_id` varchar(45) DEFAULT NULL COMMENT '相关信息唯一ID',
  `case_code` varchar(30) DEFAULT NULL COMMENT '案号',
  `case_create_time` date DEFAULT NULL COMMENT '立案时间',
  `concrete_situation` varchar(200) DEFAULT NULL COMMENT '失信被执行人行为具体情形',
  `definiteo_bligation` varchar(2048) DEFAULT NULL COMMENT '生效法律文书确定义务',
  `exe_code` varchar(30) DEFAULT NULL COMMENT '执行依据文号',
  `exec_basunit` varchar(45) DEFAULT NULL COMMENT '做出执行依据单位',
  `exec_court_name` varchar(40) DEFAULT NULL COMMENT '执行法院',
  `frname` varchar(45) DEFAULT NULL COMMENT '法定代表人或者负责人姓名',
  `gender` varchar(255) DEFAULT NULL COMMENT '性别',
  `idtype` varchar(20) DEFAULT NULL COMMENT '证照类型',
  `perform_degree` varchar(200) DEFAULT NULL COMMENT '被执行人的履行情况',
  `pname` varchar(45) DEFAULT NULL COMMENT '被执行人姓名或名称',
  `pname_id` varchar(45) DEFAULT NULL COMMENT '身份证号码或组织机构代码',
  `province` varchar(20) DEFAULT NULL COMMENT '省份',
  `pubdate` date DEFAULT NULL COMMENT '发布时间',
  `type` varchar(255) DEFAULT NULL COMMENT 'type',
  `bbd_qyxx_id` varchar(40) DEFAULT NULL COMMENT '企业唯一ID',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `task_id` int(11) NOT NULL,
  PRIMARY KEY (`dis_id`)
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8 COMMENT='失信被执行人存储表';



drop table if exists ktgg;

/*==============================================================*/
/* Table: ktgg                                                  */
/*==============================================================*/
CREATE TABLE `ktgg` (
  `ktgg_id` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) DEFAULT '0',
  `action_cause` varchar(200) DEFAULT NULL COMMENT '案由',
  `bbd_dotime` date DEFAULT NULL COMMENT '抓取时间',
  `bbd_qyxx_id` varchar(40) DEFAULT NULL COMMENT '企业唯一ID',
  `bbd_source` varchar(200) DEFAULT NULL COMMENT '数据源',
  `bbd_type` varchar(20) DEFAULT NULL COMMENT 'bbd_type',
  `bbd_uptime` int(11) DEFAULT NULL COMMENT 'uptime',
  `bbd_version` varchar(100) DEFAULT NULL COMMENT 'version',
  `case_code` varchar(100) DEFAULT NULL COMMENT '案号',
  `city` varchar(20) DEFAULT NULL COMMENT 'city',
  `litigant` varchar(200) DEFAULT NULL COMMENT '当事人',
  `main` longtext COMMENT 'main',
  `title` varchar(200) DEFAULT NULL COMMENT 'title',
  `trial_date` date DEFAULT NULL COMMENT '开庭日期',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `bbd_url` varchar(2000) DEFAULT NULL,
  `asstarting` date DEFAULT NULL COMMENT '任职起始（上市公司）',
  `task_id` int(11) NOT NULL,
  PRIMARY KEY (`ktgg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3370 DEFAULT CHARSET=utf8 COMMENT='开庭公告';



drop table if exists qyxg_yuqing;

/*==============================================================*/
/* Table: qyxg_yuqing                                           */
/*==============================================================*/
CREATE TABLE `qyxg_yuqing` (
  `yuqing_id` int(40) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `abstract` varchar(450) DEFAULT NULL COMMENT '文章摘要',
  `author` varchar(450) DEFAULT NULL COMMENT '作者名称',
  `bbd_dotime` date DEFAULT NULL COMMENT '日期',
  `bbd_source` varchar(450) DEFAULT NULL COMMENT '数据源',
  `bbd_type` varchar(450) DEFAULT NULL COMMENT '表类型',
  `bbd_uptime` int(11) DEFAULT NULL COMMENT '时间戳',
  `bbd_url` varchar(2000) DEFAULT NULL COMMENT '网页链接',
  `bbd_xgxx_id` varchar(45) DEFAULT NULL COMMENT '相关信息唯一ID',
  `comment_num` int(11) DEFAULT NULL COMMENT '评论数',
  `main` longtext COMMENT '原文',
  `news_site` varchar(2000) DEFAULT NULL COMMENT '网站',
  `news_title` varchar(2000) DEFAULT NULL COMMENT '标题',
  `picture` longtext COMMENT '正文图片',
  `plate` varchar(450) DEFAULT NULL COMMENT '所属网站板块',
  `pubdate` datetime DEFAULT NULL COMMENT '发布时间',
  `rowkey` varchar(450) DEFAULT NULL COMMENT 'rowkey',
  `search_key` longtext COMMENT '搜索关键字',
  `status` int(11) DEFAULT NULL COMMENT 'status',
  `table_name` varchar(450) DEFAULT NULL COMMENT 'table_name',
  `transfer_num` int(11) DEFAULT NULL COMMENT '转发量',
  `id` int(11) DEFAULT NULL COMMENT 'id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'create_time',
  `bbd_qyxx_id` varchar(40) DEFAULT NULL COMMENT '企业唯一ID',
  `task_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`yuqing_id`)
) ENGINE=InnoDB AUTO_INCREMENT=167883 DEFAULT CHARSET=utf8 COMMENT='舆情数据-外滩一号';


drop table if exists qyxx_basic;

/*==============================================================*/
/* Table: qyxx_basic                                            */
/*==============================================================*/
CREATE TABLE `qyxx_basic` (
  `basic_id` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) DEFAULT '0',
  `address` varchar(1000) DEFAULT NULL COMMENT '地址',
  `approval_date` date DEFAULT NULL COMMENT '核准日期',
  `bbd_dotime` date DEFAULT NULL COMMENT '抓取时间',
  `bbd_history_name` mediumtext COMMENT '历名名称',
  `bbd_qyxx_id` varchar(40) DEFAULT NULL COMMENT '企业唯一ID',
  `bbd_type` varchar(20) DEFAULT NULL COMMENT 'bbd_type',
  `bbd_uptime` int(11) DEFAULT NULL COMMENT '注销日期',
  `cancel_date` date DEFAULT NULL COMMENT '抓取时间',
  `company_companytype` varchar(50) DEFAULT NULL COMMENT '企业类型_映射结果',
  `company_county` varchar(50) DEFAULT NULL COMMENT '企业区县',
  `company_currency` varchar(50) DEFAULT NULL COMMENT '注册币种_映射结果',
  `company_enterprise_status` varchar(50) DEFAULT NULL COMMENT '登记状态_映射结果',
  `company_industry` varchar(50) DEFAULT NULL COMMENT '行业分类',
  `company_name` varchar(50) DEFAULT NULL COMMENT '名称',
  `company_province` varchar(50) DEFAULT NULL COMMENT '省份_映射结果',
  `company_regorg` varchar(50) DEFAULT NULL COMMENT '登记机关_映射结果',
  `company_type` varchar(450) DEFAULT NULL COMMENT '类型',
  `credit_code` varchar(50) DEFAULT NULL COMMENT '社会信用代码',
  `enterprise_status` varchar(50) DEFAULT NULL COMMENT '登记状态',
  `esdate` date DEFAULT NULL COMMENT '成立日期',
  `form` varchar(450) DEFAULT NULL COMMENT '组成形式',
  `frname` varchar(450) DEFAULT NULL COMMENT '法定代表人',
  `frname_id` varchar(50) DEFAULT NULL COMMENT '法定代表人唯一ID',
  `invest_cap` varchar(200) DEFAULT NULL COMMENT '出资额',
  `investcap_amount` float DEFAULT NULL COMMENT '投资总额_金额',
  `investcap_currency` varchar(100) DEFAULT NULL COMMENT '投资总额_币种',
  `ipo_company` varchar(100) DEFAULT NULL COMMENT '上市公司标识',
  `openfrom` varchar(20) DEFAULT NULL COMMENT '营业期限自',
  `opento` varchar(20) DEFAULT NULL COMMENT '营业期限至',
  `operate_scope` mediumtext COMMENT '经营范围',
  `operating_period` varchar(100) DEFAULT NULL COMMENT '经营期限',
  `parent_firm` varchar(450) DEFAULT NULL COMMENT '派出企业名称',
  `realcap` varchar(200) DEFAULT NULL COMMENT '实收资本',
  `realcap_amount` float DEFAULT NULL COMMENT '实收资本_金额',
  `realcap_currency` varchar(100) DEFAULT NULL COMMENT '实收资本_币种',
  `regcap` varchar(200) DEFAULT NULL COMMENT '注册资金',
  `regcap_amount` float DEFAULT NULL COMMENT '注册资本_金额',
  `regcap_currency` varchar(100) DEFAULT NULL COMMENT '注册资本_币种',
  `regcapcur` varchar(100) DEFAULT NULL COMMENT '注册币种',
  `regno` varchar(200) DEFAULT NULL COMMENT '注册号',
  `regno_or_creditcode` varchar(400) DEFAULT NULL COMMENT '注册号/统一社会信用代码',
  `regorg` varchar(450) DEFAULT NULL COMMENT '登记机关',
  `revoke_date` date DEFAULT NULL COMMENT '吊销日期',
  `type` varchar(100) DEFAULT NULL COMMENT '爬虫源省份记录（ 中文）',
  `frname_compid` varchar(45) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `task_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`basic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1206059 DEFAULT CHARSET=utf8 COMMENT='企业基础信息存储表（qyxx拆表结果）';


drop table if exists qyxx_baxx;
/*==============================================================*/
/* Table: qyxx_baxx                                             */
/*==============================================================*/
CREATE TABLE `qyxx_baxx` (
  `baxx_id` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) DEFAULT '0',
  `bbd_dotime` date DEFAULT NULL COMMENT '抓取时间',
  `bbd_qyxx_id` varchar(40) DEFAULT NULL COMMENT '企业唯一ID',
  `bbd_uptime` int(11) DEFAULT NULL COMMENT 'uptime',
  `company_name` varchar(450) DEFAULT NULL COMMENT '名称',
  `no` varchar(100) DEFAULT NULL COMMENT '序号',
  `position` varchar(100) DEFAULT NULL COMMENT '职务',
  `sex` varchar(100) DEFAULT NULL COMMENT '性别',
  `type` varchar(100) DEFAULT NULL COMMENT '职务类型',
  `idno` varchar(400) DEFAULT NULL COMMENT '证照号码',
  `idtype` varchar(400) DEFAULT NULL COMMENT '证照类型',
  `name` varchar(400) DEFAULT NULL COMMENT '姓名',
  `name_id` varchar(50) DEFAULT NULL COMMENT '自然人唯一ID',
  `resume` longtext COMMENT '简历（上市公司）',
  `salary` varchar(200) DEFAULT NULL COMMENT '薪酬（上市公司）',
  `asstarting` date DEFAULT NULL COMMENT '任职起始（上市公司）',
  `task_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`baxx_id`)
) ENGINE=InnoDB AUTO_INCREMENT=441554 DEFAULT CHARSET=utf8 COMMENT='企业高管信息存储表（qyxx拆表结果）';


drop table if exists qyxx_gdxx;
/*==============================================================*/
/* Table: qyxx_gdxx                                             */
/*==============================================================*/
CREATE TABLE `qyxx_gdxx` (
  `gdxx_id` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) DEFAULT '0',
  `bbd_dotime` date DEFAULT NULL COMMENT '抓取时间',
  `bbd_qyxx_id` varchar(40) DEFAULT NULL COMMENT '企业唯一ID',
  `bbd_uptime` int(11) DEFAULT NULL COMMENT 'uptime',
  `company_name` varchar(450) DEFAULT NULL COMMENT '名称',
  `idno` varchar(400) DEFAULT NULL COMMENT '证照号码',
  `idtype` varchar(400) DEFAULT NULL COMMENT '证照类型',
  `invest_amount` varchar(200) DEFAULT NULL COMMENT '出资额',
  `invest_name` varchar(450) DEFAULT NULL COMMENT '出资方式',
  `invest_ratio` varchar(200) DEFAULT NULL COMMENT '出资比例',
  `name_compid` varchar(400) DEFAULT NULL COMMENT '股东的类别判断',
  `no` varchar(200) DEFAULT NULL COMMENT '序号',
  `paid_contribution` varchar(200) DEFAULT NULL COMMENT '实缴出资额',
  `shareholder_detail` longtext COMMENT '股东详情',
  `shareholder_id` varchar(50) DEFAULT NULL COMMENT '股东唯一ID',
  `shareholder_name` varchar(450) DEFAULT NULL COMMENT '股东',
  `shareholder_type` varchar(200) DEFAULT NULL COMMENT '股东类型',
  `subscribed_capital` varchar(400) DEFAULT NULL COMMENT '认缴出资额',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sumconam` varchar(200) DEFAULT NULL,
  `task_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`gdxx_id`)
) ENGINE=InnoDB AUTO_INCREMENT=516752 DEFAULT CHARSET=utf8 COMMENT='企业股东信息存储表（qyxx拆表结果）';


drop table if exists qyxx_zhuanli;
/*==============================================================*/
/* Table: qyxx_zhuanli                                          */
/*==============================================================*/
CREATE TABLE `qyxx_zhuanli` (
  `zhuanli_id` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) DEFAULT '0',
  `bbd_qyxx_id` varchar(40) DEFAULT NULL COMMENT '企业唯一ID',
  `address` varchar(400) DEFAULT NULL COMMENT '申请人地址',
  `agent_name` varchar(200) DEFAULT NULL COMMENT '代理人',
  `application_code` varchar(200) DEFAULT NULL COMMENT '申请（专利）号	',
  `application_code_wanfang` varchar(200) DEFAULT NULL COMMENT '申请（专利）号_万方	',
  `application_date` date DEFAULT NULL COMMENT '申请日期',
  `class_code` varchar(2000) DEFAULT NULL COMMENT '分类号',
  `class_code_wanfang` varchar(2000) DEFAULT NULL COMMENT '分类号_万方',
  `company_name` varchar(2000) DEFAULT NULL COMMENT 'company_name',
  `inventor` varchar(2000) DEFAULT NULL COMMENT '发明（设计）人	',
  `patent_type` varchar(200) DEFAULT NULL COMMENT '专利类型',
  `patent_agency` varchar(200) DEFAULT NULL COMMENT '专利代理机构',
  `title` varchar(2000) DEFAULT NULL COMMENT '专利名称',
  `public_code` varchar(200) DEFAULT NULL COMMENT '公开（公告）号	',
  `publidate` date DEFAULT NULL COMMENT '公开（公告）日	',
  `applicant` varchar(200) DEFAULT NULL COMMENT '申请（专利权）人	',
  `independent_claim` longtext COMMENT '主权项',
  `law_state` varchar(200) DEFAULT NULL COMMENT '法律状态',
  `main_classcode` varchar(200) DEFAULT NULL COMMENT '主分类号',
  `npc_code` varchar(200) DEFAULT NULL COMMENT '国别省市代码',
  `approval_issue_date` date DEFAULT NULL COMMENT '审定公告日',
  `approval_num` varchar(200) DEFAULT NULL COMMENT '审定号',
  `bg_publication_date` date DEFAULT NULL COMMENT '更正文献出版日',
  `biology_preserve` varchar(200) DEFAULT NULL COMMENT '生物保藏',
  `compare_file` varchar(200) DEFAULT NULL COMMENT '对比文件',
  `decode_announce_date` varchar(200) DEFAULT NULL COMMENT '解密公告日',
  `division_application` varchar(200) DEFAULT NULL COMMENT '分案原申请',
  `fmgb` varchar(200) DEFAULT NULL COMMENT 'fmgb',
  `fmsq` varchar(200) DEFAULT NULL COMMENT 'fmsq',
  `homeland_prority` varchar(200) DEFAULT NULL COMMENT '本国优先权',
  `pct_application_data` varchar(200) DEFAULT NULL COMMENT 'PCT申请数据',
  `pct_enter_national` varchar(200) DEFAULT NULL COMMENT 'PCT进入国家阶段日',
  `pct_publish_data` varchar(200) DEFAULT NULL COMMENT 'PCT公布数据',
  `priority` varchar(200) DEFAULT NULL COMMENT '优先权',
  `wgsq` varchar(200) DEFAULT NULL COMMENT 'wgsq',
  `xxsq` varchar(200) DEFAULT NULL COMMENT 'xxsq',
  `bbd_source` varchar(200) DEFAULT NULL COMMENT '数据源',
  `bbd_dotime` date DEFAULT NULL COMMENT '爬虫抓取时间',
  `bbd_type` varchar(200) DEFAULT NULL COMMENT '表名',
  `bbd_uptime` date DEFAULT NULL COMMENT '爬虫抓取时间戳',
  `bbd_url` varchar(400) DEFAULT NULL COMMENT 'url',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '入库时间',
  `sumconam` varchar(200) DEFAULT NULL,
  `task_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`zhuanli_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11050 DEFAULT CHARSET=utf8 COMMENT='专利';


drop table if exists rmfygg;
/*==============================================================*/
/* Table: rmfygg                                                */
/*==============================================================*/
CREATE TABLE `rmfygg` (
  `rmfygg_id` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) DEFAULT '0',
  `attachment` longtext COMMENT '附件',
  `bbd_dotime` date DEFAULT NULL COMMENT '抓取时间',
  `bbd_source` varchar(200) DEFAULT NULL COMMENT '数据源',
  `bbd_type` varchar(20) DEFAULT NULL COMMENT 'bbd_type',
  `bbd_uptime` int(11) DEFAULT NULL COMMENT 'uptime',
  `bbd_url` varchar(2000) DEFAULT NULL COMMENT '链接',
  `bbd_xgxx_id` varchar(45) DEFAULT NULL COMMENT '相关信息唯一ID',
  `litigant` varchar(2000) DEFAULT NULL COMMENT '当事人',
  `notice_content` longtext COMMENT '公告内容',
  `notice_people` varchar(200) DEFAULT NULL COMMENT '公告人',
  `notice_time` varchar(20) DEFAULT NULL COMMENT '公告时间',
  `notice_type` varchar(20) DEFAULT NULL COMMENT '公告类型',
  `bbd_qyxx_id` varchar(40) DEFAULT NULL COMMENT '企业唯一ID',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `task_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`rmfygg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=749 DEFAULT CHARSET=utf8 COMMENT='人民法院公告';


drop table if exists zgcpwsw;
/*==============================================================*/
/* Table: zgcpwsw                                               */
/*==============================================================*/
CREATE TABLE `zgcpwsw` (
  `zgcpwsw_id` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) DEFAULT '0',
  `bbd_qyxx_id` varchar(40) DEFAULT NULL COMMENT '企业唯一ID',
  `action_cause` mediumtext COMMENT '案由',
  `applicable_law` mediumtext COMMENT '适用法条',
  `bbd_dotime` date DEFAULT NULL COMMENT '抓取时间',
  `bbd_source` varchar(200) DEFAULT NULL COMMENT '数据源',
  `bbd_type` varchar(20) DEFAULT NULL COMMENT 'bbd_type',
  `bbd_uptime` int(11) DEFAULT NULL COMMENT 'uptime',
  `bbd_url` varchar(2000) DEFAULT NULL COMMENT '链接',
  `bbd_xgxx_id` varchar(45) DEFAULT NULL COMMENT '相关信息唯一ID',
  `case_type` varchar(20) DEFAULT NULL COMMENT '案件类型',
  `casecode` varchar(200) DEFAULT NULL COMMENT '案号',
  `caseout_come` varchar(200) DEFAULT NULL COMMENT '案件结果',
  `company_name` varchar(200) DEFAULT NULL COMMENT 'company_name',
  `court_acceptance_fee` varchar(100) DEFAULT NULL COMMENT '受理费',
  `court_litigant` varchar(100) DEFAULT NULL COMMENT '法院当事人',
  `data_source` varchar(20) DEFAULT NULL COMMENT 'datasource',
  `def_litigant` varchar(200) DEFAULT NULL COMMENT '被诉方当事人',
  `def_other_related` varchar(200) DEFAULT NULL COMMENT '被诉方其他相关人',
  `doc_type` varchar(100) DEFAULT NULL COMMENT '文书类型',
  `historycase` varchar(2048) DEFAULT NULL COMMENT '历审案例',
  `ju_proc` varchar(200) DEFAULT NULL COMMENT '审理程序',
  `litigant` varchar(200) DEFAULT NULL COMMENT '当事人',
  `litigant_type` varchar(2000) DEFAULT NULL COMMENT '当事人类型',
  `main` longtext COMMENT '文书内容',
  `pro_litigant` varchar(200) DEFAULT NULL COMMENT '起诉方当事人',
  `pro_other_related` varchar(200) DEFAULT NULL COMMENT '起诉方其他相关人',
  `rawdata` longtext COMMENT 'rawdata',
  `rel_doc` mediumtext COMMENT '关联文书',
  `rel_doc_url` varchar(2000) DEFAULT NULL COMMENT '关联文书URL',
  `sentence_date` date DEFAULT NULL COMMENT '裁判日期',
  `title` mediumtext COMMENT '案件标题',
  `trial_court` varchar(200) DEFAULT NULL COMMENT '审理法院',
  `update` varchar(200) DEFAULT NULL COMMENT '更新时间',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `task_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`zgcpwsw_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18702 DEFAULT CHARSET=utf8 COMMENT='中国裁判文书';


drop table if exists zhixing;
/*==============================================================*/
/* Table: zhixing                                               */
/*==============================================================*/
CREATE TABLE `zhixing` (
  `zhixing_id` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) DEFAULT '0',
  `bbd_dotime` date DEFAULT NULL COMMENT '抓取时间',
  `bbd_source` varchar(200) DEFAULT NULL COMMENT '数据源',
  `bbd_type` varchar(20) DEFAULT NULL COMMENT 'bbd_type',
  `bbd_uptime` int(11) DEFAULT NULL COMMENT 'uptime',
  `bbd_url` varchar(2000) DEFAULT NULL COMMENT '链接',
  `bbd_xgxx_id` varchar(45) DEFAULT NULL COMMENT '相关信息唯一ID',
  `case_code` varchar(200) DEFAULT NULL COMMENT '案号',
  `case_create_time` date DEFAULT NULL COMMENT '立案时间',
  `case_state` varchar(200) DEFAULT NULL COMMENT '案件状态',
  `company_name` varchar(450) DEFAULT NULL COMMENT 'company_name',
  `exec_court_name` varchar(450) DEFAULT NULL COMMENT '执行法院',
  `exec_subject` float DEFAULT NULL COMMENT '执行标的',
  `idtype` varchar(200) DEFAULT NULL COMMENT '证照类型',
  `pname` varchar(450) DEFAULT NULL COMMENT '被执行人姓名/名称',
  `pname_id` varchar(450) DEFAULT NULL COMMENT '身份证号码/组织机构代码',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `bbd_qyxx_id` varchar(40) DEFAULT NULL COMMENT '企业唯一ID',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `task_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`zhixing_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4407 DEFAULT CHARSET=utf8 COMMENT='全国被执行人';


drop table if exists recruit_index;
/*==============================================================*/
/* Table: recruit_index                                         */
/*==============================================================*/
CREATE TABLE `recruit_index` (
  `recruit_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(450) DEFAULT NULL COMMENT 'company_name',
  `recruit_industryratio` varchar(450) DEFAULT NULL COMMENT '行业分布',
  `recruit_salaryratio` varchar(450) DEFAULT NULL COMMENT '薪资分布',
  `recruit_index` varchar(450) DEFAULT NULL COMMENT '招聘指数',
  `dt` varchar(450) DEFAULT NULL COMMENT '时间',
  `task_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`recruit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4510 DEFAULT CHARSET=utf8 COMMENT='招聘指数表';

drop table if exists offline_financial_record;
/*==============================================================*/
/* Table: recruit_index                                         */
/*==============================================================*/
CREATE TABLE `offline_financial_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `company_id` int(11) DEFAULT NULL COMMENT '企业ID',
  `credit_code` char(20) DEFAULT NULL COMMENT '统一社会信用代码',
  `company_name` varchar(100) DEFAULT NULL COMMENT '公司名',
  `organization_code` varchar(50) DEFAULT NULL COMMENT '组织机构代码',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_date` date DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=131125 DEFAULT CHARSET=utf8 COMMENT='线下理财接口上传信息';


drop table if exists data_loading_fail_info;
/*==============================================================*/
/* Table: data_loading_fail_info                                */
/*==============================================================*/
CREATE TABLE `data_loading_fail_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `task_id` int(11) DEFAULT NULL COMMENT '企业ID',
  `error_name` varchar(100) DEFAULT NULL COMMENT '企业名称',
  `source_task_id` int(11) DEFAULT NULL,
  `error_reason` varchar(255) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `data_version` varchar(20) DEFAULT NULL COMMENT '数据版本号',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `index_company_id` (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=356699 DEFAULT CHARSET=utf8 COMMENT='数据落地失败数据表';


drop table if exists datashare_pull_file;
/*==============================================================*/
/* Table: datashare_pull_file                                   */
/*==============================================================*/
CREATE TABLE `datashare_pull_file` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(50) DEFAULT NULL COMMENT '文件名称',
  `file_url` varchar(500) DEFAULT NULL COMMENT '文件路径',
  `task_id` int(11) DEFAULT NULL COMMENT '数据落地任务ID',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_date` date DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6524 DEFAULT CHARSET=utf8 COMMENT='datashare文件拉取';







