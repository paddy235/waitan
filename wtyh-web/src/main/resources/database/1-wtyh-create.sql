DROP TABLE IF EXISTS `company_modify`;
CREATE TABLE `company_modify` (
`id`  int(255) NOT NULL AUTO_INCREMENT ,
`name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '公司名称' ,
`platName`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '网络借贷-平台名称' ,
`beforeLevel`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '修改后的评级' ,
`afterLevel`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '变更前的等级' ,
`beforeIndustry`  tinyint(4) NULL DEFAULT NULL ,
`afterIndustry`  tinyint(4) NULL DEFAULT NULL ,
`create`  timestamp NULL DEFAULT CURRENT_TIMESTAMP ,
`update`  timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
`beforeOutLevel`  int(11) NULL DEFAULT NULL ,
`beforeInnnerLevel`  int(11) NULL DEFAULT NULL ,
`beforeLiveLevel`  int(11) NULL DEFAULT NULL ,
`afterOutLevel`  int(11) NULL DEFAULT NULL ,
`afterInnnerLevel`  int(11) NULL DEFAULT NULL ,
`afterLiveLevel`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=1 ROW_FORMAT=DYNAMIC;

drop table if exists tbl_relation;

CREATE TABLE `tbl_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `target_company` varchar(100) DEFAULT NULL COMMENT '目标公司',
  `investors` varchar(100) DEFAULT NULL COMMENT '投资方',
  `investee` varchar(100) DEFAULT NULL COMMENT '被投资方',
  `relationship` varchar(2) DEFAULT NULL COMMENT '关联关系（0：企业之间；1：个人与企业）',
  `investors_no` int(11) DEFAULT NULL COMMENT '投资方维度',
  `investee_no` int(11) DEFAULT NULL COMMENT '被投资方维度',
  `full_line` varchar(2) DEFAULT NULL COMMENT '是否投资方向（0：否；1：是）',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_date` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关联方表';

drop table if exists natural_person;
create table natural_person
(
   id                   int not null auto_increment comment '自然人代码',
   person_name          varchar(32) not null comment '姓名',
   duty                 varchar(32) not null comment '职务',
   duty_code            int not null comment '职务代码（1：法人股东；2：董监高）',
   company_name         varchar(100) not null comment '企业名称',
   unified_no           varchar(100) not null comment '平台统一编号',
   status               int not null default 0 comment '有效标识（0：无效；1有效）',
   create_by            varchar(32) comment '创建人',
   create_date          timestamp comment '创建时间',
   update_by            varchar(32) comment '修改人',
   update_date          timestamp DEFAULT CURRENT_TIMESTAMP comment '修改时间',
   primary key (id)
)
ENGINE=InnoDB DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci COMMENT='自然人表';

DROP TABLE IF EXISTS park_building_img;

CREATE TABLE park_building_img (
	id INT NOT NULL auto_increment COMMENT '逻辑主键',
	pic_name VARCHAR (100) NOT NULL COMMENT '图片名称',
	pic_url VARCHAR (200) COMMENT '访问路径',
	pic MEDIUMBLOB COMMENT '图片',
	pic_type INT NOT NULL DEFAULT 2 COMMENT '图片所属建筑类型（1：园区；2：楼宇）',
	pic_park_id INT COMMENT '所属园区',
	pic_building_id INT COMMENT '所属楼宇',
	STATUS INT NOT NULL DEFAULT 0 COMMENT '图片可用状态（0：不可用；1：可用；2：已用）',
	ip VARCHAR (25) COMMENT '服务器IP',
	create_by VARCHAR (50) COMMENT '创建人',
	create_date TIMESTAMP COMMENT '创建时间',
	update_by VARCHAR (50) COMMENT '修改人',
	update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
	PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT CHARACTER
SET = utf8 COLLATE = utf8_general_ci COMMENT = '园区以及楼宇图片表';

DROP TABLE IF EXISTS park_company_import;

CREATE TABLE park_company_import (
	id INT NOT NULL COMMENT '逻辑主键',
	import_no VARCHAR (100) NOT NULL COMMENT '导入批次号',
	company_name VARCHAR (100) NOT NULL COMMENT '企业名称',
	building_name VARCHAR (100) NOT NULL COMMENT '楼宇名称',
	company_id INT COMMENT '企业ID',
	building_id INT COMMENT '楼宇ID',
	error_company VARCHAR (200) COMMENT '企业异常信息',
	error_building VARCHAR (200) COMMENT '楼宇异常信息',
	create_by VARCHAR (50) COMMENT '创建人',
	create_date TIMESTAMP COMMENT '创建时间',
	update_by VARCHAR (50) COMMENT '修改人',
	update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
	PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT CHARACTER
SET = utf8 COLLATE = utf8_general_ci COMMENT = '园区企业导入表';

DROP TABLE IF EXISTS dishonesty;
CREATE TABLE `dishonesty` (
	`dis_id` INT (11) NOT NULL AUTO_INCREMENT,
	`id` INT (11) DEFAULT '0',
	`age` VARCHAR (255) DEFAULT NULL COMMENT '年龄',
	`bbd_dotime` date DEFAULT NULL COMMENT '抓取时间',
	`bbd_source` VARCHAR (200) DEFAULT NULL COMMENT '数据源',
	`bbd_type` VARCHAR (200) DEFAULT NULL COMMENT 'bbd_type',
	`bbd_uptime` INT (11) DEFAULT NULL COMMENT 'uptime',
	`bbd_url` VARCHAR (2000) DEFAULT NULL COMMENT '链接',
	`bbd_xgxx_id` VARCHAR (45) DEFAULT NULL COMMENT '相关信息唯一ID',
	`case_code` VARCHAR (30) DEFAULT NULL COMMENT '案号',
	`case_create_time` date DEFAULT NULL COMMENT '立案时间',
	`concrete_situation` VARCHAR (200) DEFAULT NULL COMMENT '失信被执行人行为具体情形',
	`definiteo_bligation` VARCHAR (2048) DEFAULT NULL COMMENT '生效法律文书确定义务',
	`exe_code` VARCHAR (50) DEFAULT NULL COMMENT '执行依据文号',
	`exec_basunit` VARCHAR (45) DEFAULT NULL COMMENT '做出执行依据单位',
	`exec_court_name` VARCHAR (40) DEFAULT NULL COMMENT '执行法院',
	`frname` VARCHAR (45) DEFAULT NULL COMMENT '法定代表人或者负责人姓名',
	`gender` VARCHAR (255) DEFAULT NULL COMMENT '性别',
	`idtype` VARCHAR (20) DEFAULT NULL COMMENT '证照类型',
	`perform_degree` VARCHAR (200) DEFAULT NULL COMMENT '被执行人的履行情况',
	`pname` VARCHAR (45) DEFAULT NULL COMMENT '被执行人姓名或名称',
	`pname_id` VARCHAR (45) DEFAULT NULL COMMENT '身份证号码或组织机构代码',
	`province` VARCHAR (20) DEFAULT NULL COMMENT '省份',
	`pubdate` date DEFAULT NULL COMMENT '发布时间',
	`type` VARCHAR (255) DEFAULT NULL COMMENT 'type',
	`bbd_qyxx_id` VARCHAR (40) DEFAULT NULL COMMENT '企业唯一ID',
	`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`task_id` INT (11) NOT NULL,
	PRIMARY KEY (`dis_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '失信被执行人存储表';

DROP TABLE IF EXISTS ktgg;

CREATE TABLE `ktgg` (
	`ktgg_id` INT (11) NOT NULL AUTO_INCREMENT,
	`id` INT (11) DEFAULT '0',
	`action_cause` VARCHAR (200) DEFAULT NULL COMMENT '案由',
	`bbd_dotime` date DEFAULT NULL COMMENT '抓取时间',
	`bbd_qyxx_id` VARCHAR (40) DEFAULT NULL COMMENT '企业唯一ID',
	`bbd_source` VARCHAR (200) DEFAULT NULL COMMENT '数据源',
	`bbd_type` VARCHAR (20) DEFAULT NULL COMMENT 'bbd_type',
	`bbd_uptime` INT (11) DEFAULT NULL COMMENT 'uptime',
	`bbd_version` VARCHAR (100) DEFAULT NULL COMMENT 'version',
	`case_code` VARCHAR (100) DEFAULT NULL COMMENT '案号',
	`city` VARCHAR (20) DEFAULT NULL COMMENT 'city',
	`litigant` VARCHAR (200) DEFAULT NULL COMMENT '当事人',
	`main` LONGTEXT COMMENT 'main',
	`title` VARCHAR (200) DEFAULT NULL COMMENT 'title',
	`trial_date` date DEFAULT NULL COMMENT '开庭日期',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`bbd_url` VARCHAR (2000) DEFAULT NULL,
	`asstarting` date DEFAULT NULL COMMENT '任职起始（上市公司）',
	`task_id` INT (11) NOT NULL,
	PRIMARY KEY (`ktgg_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '开庭公告';

DROP TABLE IF EXISTS qyxg_yuqing;

CREATE TABLE `qyxg_yuqing` (
	`yuqing_id` INT (40) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
	`abstract` VARCHAR (450) DEFAULT NULL COMMENT '文章摘要',
	`author` VARCHAR (450) DEFAULT NULL COMMENT '作者名称',
	`bbd_dotime` date DEFAULT NULL COMMENT '日期',
	`bbd_source` VARCHAR (450) DEFAULT NULL COMMENT '数据源',
	`bbd_type` VARCHAR (450) DEFAULT NULL COMMENT '表类型',
	`bbd_uptime` INT (11) DEFAULT NULL COMMENT '时间戳',
	`bbd_url` VARCHAR (2000) DEFAULT NULL COMMENT '网页链接',
	`bbd_xgxx_id` VARCHAR (45) DEFAULT NULL COMMENT '相关信息唯一ID',
	`comment_num` INT (11) DEFAULT NULL COMMENT '评论数',
	`main` LONGTEXT COMMENT '原文',
	`news_site` VARCHAR (2000) DEFAULT NULL COMMENT '网站',
	`news_title` VARCHAR (2000) DEFAULT NULL COMMENT '标题',
	`picture` LONGTEXT COMMENT '正文图片',
	`plate` VARCHAR (450) DEFAULT NULL COMMENT '所属网站板块',
	`pubdate` datetime DEFAULT NULL COMMENT '发布时间',
	`rowkey` VARCHAR (450) DEFAULT NULL COMMENT 'rowkey',
	`search_key` LONGTEXT COMMENT '搜索关键字',
	`status` INT (11) DEFAULT NULL COMMENT 'status',
	`table_name` VARCHAR (450) DEFAULT NULL COMMENT 'table_name',
	`transfer_num` INT (11) DEFAULT NULL COMMENT '转发量',
	`id` INT (11) DEFAULT NULL COMMENT 'id',
	`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'create_time',
	`bbd_qyxx_id` VARCHAR (40) DEFAULT NULL COMMENT '企业唯一ID',
	`task_id` INT (11) DEFAULT NULL,
	PRIMARY KEY (`yuqing_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '舆情数据-外滩一号';

DROP TABLE IF EXISTS qyxx_basic;

CREATE TABLE `qyxx_basic` (
	`basic_id` INT (11) NOT NULL AUTO_INCREMENT,
	`id` INT (11) DEFAULT '0',
	`address` VARCHAR (1000) DEFAULT NULL COMMENT '地址',
	`approval_date` date DEFAULT NULL COMMENT '核准日期',
	`bbd_dotime` date DEFAULT NULL COMMENT '抓取时间',
	`bbd_history_name` MEDIUMTEXT COMMENT '历名名称',
	`bbd_qyxx_id` VARCHAR (40) DEFAULT NULL COMMENT '企业唯一ID',
	`bbd_type` VARCHAR (20) DEFAULT NULL COMMENT 'bbd_type',
	`bbd_uptime` INT (11) DEFAULT NULL COMMENT '注销日期',
	`cancel_date` date DEFAULT NULL COMMENT '抓取时间',
	`company_companytype` VARCHAR (50) DEFAULT NULL COMMENT '企业类型_映射结果',
	`company_county` VARCHAR (50) DEFAULT NULL COMMENT '企业区县',
	`company_currency` VARCHAR (50) DEFAULT NULL COMMENT '注册币种_映射结果',
	`company_enterprise_status` VARCHAR (50) DEFAULT NULL COMMENT '登记状态_映射结果',
	`company_industry` VARCHAR (50) DEFAULT NULL COMMENT '行业分类',
	`company_name` VARCHAR (50) DEFAULT NULL COMMENT '名称',
	`company_province` VARCHAR (50) DEFAULT NULL COMMENT '省份_映射结果',
	`company_regorg` VARCHAR (50) DEFAULT NULL COMMENT '登记机关_映射结果',
	`company_type` VARCHAR (450) DEFAULT NULL COMMENT '类型',
	`credit_code` VARCHAR (50) DEFAULT NULL COMMENT '社会信用代码',
	`enterprise_status` VARCHAR (50) DEFAULT NULL COMMENT '登记状态',
	`esdate` date DEFAULT NULL COMMENT '成立日期',
	`form` VARCHAR (450) DEFAULT NULL COMMENT '组成形式',
	`frname` VARCHAR (450) DEFAULT NULL COMMENT '法定代表人',
	`frname_id` VARCHAR (50) DEFAULT NULL COMMENT '法定代表人唯一ID',
	`invest_cap` VARCHAR (200) DEFAULT NULL COMMENT '出资额',
	`investcap_amount` FLOAT DEFAULT NULL COMMENT '投资总额_金额',
	`investcap_currency` VARCHAR (100) DEFAULT NULL COMMENT '投资总额_币种',
	`ipo_company` VARCHAR (100) DEFAULT NULL COMMENT '上市公司标识',
	`openfrom` VARCHAR (20) DEFAULT NULL COMMENT '营业期限自',
	`opento` VARCHAR (20) DEFAULT NULL COMMENT '营业期限至',
	`operate_scope` MEDIUMTEXT COMMENT '经营范围',
	`operating_period` VARCHAR (100) DEFAULT NULL COMMENT '经营期限',
	`parent_firm` VARCHAR (450) DEFAULT NULL COMMENT '派出企业名称',
	`realcap` VARCHAR (200) DEFAULT NULL COMMENT '实收资本',
	`realcap_amount` FLOAT DEFAULT NULL COMMENT '实收资本_金额',
	`realcap_currency` VARCHAR (100) DEFAULT NULL COMMENT '实收资本_币种',
	`regcap` VARCHAR (200) DEFAULT NULL COMMENT '注册资金',
	`regcap_amount` FLOAT DEFAULT NULL COMMENT '注册资本_金额',
	`regcap_currency` VARCHAR (100) DEFAULT NULL COMMENT '注册资本_币种',
	`regcapcur` VARCHAR (100) DEFAULT NULL COMMENT '注册币种',
	`regno` VARCHAR (200) DEFAULT NULL COMMENT '注册号',
	`regno_or_creditcode` VARCHAR (400) DEFAULT NULL COMMENT '注册号/统一社会信用代码',
	`regorg` VARCHAR (450) DEFAULT NULL COMMENT '登记机关',
	`revoke_date` date DEFAULT NULL COMMENT '吊销日期',
	`type` VARCHAR (100) DEFAULT NULL COMMENT '爬虫源省份记录（ 中文）',
	`frname_compid` VARCHAR (45) DEFAULT NULL,
	`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`task_id` INT (11) DEFAULT NULL,
	PRIMARY KEY (`basic_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '企业基础信息存储表（qyxx拆表结果）';

DROP TABLE IF EXISTS qyxx_gdxx;

CREATE TABLE `qyxx_gdxx` (
	`gdxx_id` INT (11) NOT NULL AUTO_INCREMENT,
	`id` INT (11) DEFAULT '0',
	`bbd_dotime` date DEFAULT NULL COMMENT '抓取时间',
	`bbd_qyxx_id` VARCHAR (40) DEFAULT NULL COMMENT '企业唯一ID',
	`bbd_uptime` INT (11) DEFAULT NULL COMMENT 'uptime',
	`company_name` VARCHAR (450) DEFAULT NULL COMMENT '名称',
	`idno` VARCHAR (400) DEFAULT NULL COMMENT '证照号码',
	`idtype` VARCHAR (400) DEFAULT NULL COMMENT '证照类型',
	`invest_amount` VARCHAR (200) DEFAULT NULL COMMENT '出资额',
	`invest_name` VARCHAR (450) DEFAULT NULL COMMENT '出资方式',
	`invest_ratio` VARCHAR (200) DEFAULT NULL COMMENT '出资比例',
	`name_compid` VARCHAR (400) DEFAULT NULL COMMENT '股东的类别判断',
	`no` VARCHAR (200) DEFAULT NULL COMMENT '序号',
	`paid_contribution` VARCHAR (200) DEFAULT NULL COMMENT '实缴出资额',
	`shareholder_detail` LONGTEXT COMMENT '股东详情',
	`shareholder_id` VARCHAR (50) DEFAULT NULL COMMENT '股东唯一ID',
	`shareholder_name` VARCHAR (450) DEFAULT NULL COMMENT '股东',
	`shareholder_type` VARCHAR (200) DEFAULT NULL COMMENT '股东类型',
	`subscribed_capital` VARCHAR (400) DEFAULT NULL COMMENT '认缴出资额',
	`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`sumconam` VARCHAR (200) DEFAULT NULL,
	`task_id` INT (11) DEFAULT NULL,
	PRIMARY KEY (`gdxx_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '企业股东信息存储表（qyxx拆表结果）';

DROP TABLE IF EXISTS qyxx_zhuanli;

CREATE TABLE `qyxx_zhuanli` (
	`zhuanli_id` INT (11) NOT NULL AUTO_INCREMENT,
	`id` INT (11) DEFAULT '0',
	`bbd_qyxx_id` VARCHAR (40) DEFAULT NULL COMMENT '企业唯一ID',
	`address` VARCHAR (400) DEFAULT NULL COMMENT '申请人地址',
	`agent_name` VARCHAR (200) DEFAULT NULL COMMENT '代理人',
	`application_code` VARCHAR (200) DEFAULT NULL COMMENT '申请（专利）号	',
	`application_code_wanfang` VARCHAR (200) DEFAULT NULL COMMENT '申请（专利）号_万方	',
	`application_date` date DEFAULT NULL COMMENT '申请日期',
	`class_code` VARCHAR (2000) DEFAULT NULL COMMENT '分类号',
	`class_code_wanfang` VARCHAR (2000) DEFAULT NULL COMMENT '分类号_万方',
	`company_name` VARCHAR (2000) DEFAULT NULL COMMENT 'company_name',
	`inventor` VARCHAR (2000) DEFAULT NULL COMMENT '发明（设计）人	',
	`patent_type` VARCHAR (200) DEFAULT NULL COMMENT '专利类型',
	`patent_agency` VARCHAR (200) DEFAULT NULL COMMENT '专利代理机构',
	`title` VARCHAR (2000) DEFAULT NULL COMMENT '专利名称',
	`public_code` VARCHAR (200) DEFAULT NULL COMMENT '公开（公告）号	',
	`publidate` date DEFAULT NULL COMMENT '公开（公告）日	',
	`applicant` VARCHAR (200) DEFAULT NULL COMMENT '申请（专利权）人	',
	`independent_claim` LONGTEXT COMMENT '主权项',
	`law_state` VARCHAR (200) DEFAULT NULL COMMENT '法律状态',
	`main_classcode` VARCHAR (200) DEFAULT NULL COMMENT '主分类号',
	`npc_code` VARCHAR (200) DEFAULT NULL COMMENT '国别省市代码',
	`approval_issue_date` date DEFAULT NULL COMMENT '审定公告日',
	`approval_num` VARCHAR (200) DEFAULT NULL COMMENT '审定号',
	`bg_publication_date` date DEFAULT NULL COMMENT '更正文献出版日',
	`biology_preserve` VARCHAR (200) DEFAULT NULL COMMENT '生物保藏',
	`compare_file` VARCHAR (200) DEFAULT NULL COMMENT '对比文件',
	`decode_announce_date` VARCHAR (200) DEFAULT NULL COMMENT '解密公告日',
	`division_application` VARCHAR (200) DEFAULT NULL COMMENT '分案原申请',
	`fmgb` VARCHAR (200) DEFAULT NULL COMMENT 'fmgb',
	`fmsq` VARCHAR (200) DEFAULT NULL COMMENT 'fmsq',
	`homeland_prority` VARCHAR (200) DEFAULT NULL COMMENT '本国优先权',
	`pct_application_data` VARCHAR (200) DEFAULT NULL COMMENT 'PCT申请数据',
	`pct_enter_national` VARCHAR (200) DEFAULT NULL COMMENT 'PCT进入国家阶段日',
	`pct_publish_data` VARCHAR (200) DEFAULT NULL COMMENT 'PCT公布数据',
	`priority` VARCHAR (200) DEFAULT NULL COMMENT '优先权',
	`wgsq` VARCHAR (200) DEFAULT NULL COMMENT 'wgsq',
	`xxsq` VARCHAR (200) DEFAULT NULL COMMENT 'xxsq',
	`bbd_source` VARCHAR (200) DEFAULT NULL COMMENT '数据源',
	`bbd_dotime` date DEFAULT NULL COMMENT '爬虫抓取时间',
	`bbd_type` VARCHAR (200) DEFAULT NULL COMMENT '表名',
	`bbd_uptime` date DEFAULT NULL COMMENT '爬虫抓取时间戳',
	`bbd_url` VARCHAR (400) DEFAULT NULL COMMENT 'url',
	`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '入库时间',
	`sumconam` VARCHAR (200) DEFAULT NULL,
	`task_id` INT (11) DEFAULT NULL,
	PRIMARY KEY (`zhuanli_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '专利';

DROP TABLE IF EXISTS rmfygg;
CREATE TABLE `rmfygg` (
	`rmfygg_id` INT (11) NOT NULL AUTO_INCREMENT,
	`id` INT (11) DEFAULT '0',
	`attachment` LONGTEXT COMMENT '附件',
	`bbd_dotime` date DEFAULT NULL COMMENT '抓取时间',
	`bbd_source` VARCHAR (200) DEFAULT NULL COMMENT '数据源',
	`bbd_type` VARCHAR (20) DEFAULT NULL COMMENT 'bbd_type',
	`bbd_uptime` INT (11) DEFAULT NULL COMMENT 'uptime',
	`bbd_url` VARCHAR (2000) DEFAULT NULL COMMENT '链接',
	`bbd_xgxx_id` VARCHAR (45) DEFAULT NULL COMMENT '相关信息唯一ID',
	`litigant` VARCHAR (2000) DEFAULT NULL COMMENT '当事人',
	`notice_content` LONGTEXT COMMENT '公告内容',
	`notice_people` VARCHAR (200) DEFAULT NULL COMMENT '公告人',
	`notice_time` VARCHAR (20) DEFAULT NULL COMMENT '公告时间',
	`notice_type` VARCHAR (20) DEFAULT NULL COMMENT '公告类型',
	`bbd_qyxx_id` VARCHAR (40) DEFAULT NULL COMMENT '企业唯一ID',
	`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`task_id` INT (11) DEFAULT NULL,
	PRIMARY KEY (`rmfygg_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '人民法院公告';

DROP TABLE IF EXISTS zgcpwsw;
CREATE TABLE `zgcpwsw` (
	`zgcpwsw_id` INT (11) NOT NULL AUTO_INCREMENT,
	`id` INT (11) DEFAULT '0',
	`bbd_qyxx_id` VARCHAR (40) DEFAULT NULL COMMENT '企业唯一ID',
	`action_cause` MEDIUMTEXT COMMENT '案由',
	`applicable_law` MEDIUMTEXT COMMENT '适用法条',
	`bbd_dotime` date DEFAULT NULL COMMENT '抓取时间',
	`bbd_source` VARCHAR (200) DEFAULT NULL COMMENT '数据源',
	`bbd_type` VARCHAR (20) DEFAULT NULL COMMENT 'bbd_type',
	`bbd_uptime` INT (11) DEFAULT NULL COMMENT 'uptime',
	`bbd_url` VARCHAR (2000) DEFAULT NULL COMMENT '链接',
	`bbd_xgxx_id` VARCHAR (45) DEFAULT NULL COMMENT '相关信息唯一ID',
	`case_type` VARCHAR (20) DEFAULT NULL COMMENT '案件类型',
	`casecode` VARCHAR (200) DEFAULT NULL COMMENT '案号',
	`caseout_come` VARCHAR (200) DEFAULT NULL COMMENT '案件结果',
	`company_name` VARCHAR (200) DEFAULT NULL COMMENT 'company_name',
	`court_acceptance_fee` VARCHAR (100) DEFAULT NULL COMMENT '受理费',
	`court_litigant` VARCHAR (100) DEFAULT NULL COMMENT '法院当事人',
	`data_source` VARCHAR (20) DEFAULT NULL COMMENT 'datasource',
	`def_litigant` VARCHAR (200) DEFAULT NULL COMMENT '被诉方当事人',
	`def_other_related` VARCHAR (200) DEFAULT NULL COMMENT '被诉方其他相关人',
	`doc_type` VARCHAR (100) DEFAULT NULL COMMENT '文书类型',
	`historycase` VARCHAR (2048) DEFAULT NULL COMMENT '历审案例',
	`ju_proc` VARCHAR (200) DEFAULT NULL COMMENT '审理程序',
	`litigant` VARCHAR (200) DEFAULT NULL COMMENT '当事人',
	`litigant_type` VARCHAR (2000) DEFAULT NULL COMMENT '当事人类型',
	`main` LONGTEXT COMMENT '文书内容',
	`pro_litigant` VARCHAR (200) DEFAULT NULL COMMENT '起诉方当事人',
	`pro_other_related` VARCHAR (200) DEFAULT NULL COMMENT '起诉方其他相关人',
	`rawdata` LONGTEXT COMMENT 'rawdata',
	`rel_doc` MEDIUMTEXT COMMENT '关联文书',
	`rel_doc_url` VARCHAR (2000) DEFAULT NULL COMMENT '关联文书URL',
	`sentence_date` date DEFAULT NULL COMMENT '裁判日期',
	`title` MEDIUMTEXT COMMENT '案件标题',
	`trial_court` VARCHAR (200) DEFAULT NULL COMMENT '审理法院',
	`update` VARCHAR (200) DEFAULT NULL COMMENT '更新时间',
	`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`task_id` INT (11) DEFAULT NULL,
	PRIMARY KEY (`zgcpwsw_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '中国裁判文书';

DROP TABLE IF EXISTS zhixing;

CREATE TABLE `zhixing` (
	`zhixing_id` INT (11) NOT NULL AUTO_INCREMENT,
	`id` INT (11) DEFAULT '0',
	`bbd_dotime` date DEFAULT NULL COMMENT '抓取时间',
	`bbd_source` VARCHAR (200) DEFAULT NULL COMMENT '数据源',
	`bbd_type` VARCHAR (20) DEFAULT NULL COMMENT 'bbd_type',
	`bbd_uptime` INT (11) DEFAULT NULL COMMENT 'uptime',
	`bbd_url` VARCHAR (2000) DEFAULT NULL COMMENT '链接',
	`bbd_xgxx_id` VARCHAR (45) DEFAULT NULL COMMENT '相关信息唯一ID',
	`case_code` VARCHAR (200) DEFAULT NULL COMMENT '案号',
	`case_create_time` date DEFAULT NULL COMMENT '立案时间',
	`case_state` VARCHAR (200) DEFAULT NULL COMMENT '案件状态',
	`company_name` VARCHAR (450) DEFAULT NULL COMMENT 'company_name',
	`exec_court_name` VARCHAR (450) DEFAULT NULL COMMENT '执行法院',
	`exec_subject` FLOAT DEFAULT NULL COMMENT '执行标的',
	`idtype` VARCHAR (200) DEFAULT NULL COMMENT '证照类型',
	`pname` VARCHAR (450) DEFAULT NULL COMMENT '被执行人姓名/名称',
	`pname_id` VARCHAR (450) DEFAULT NULL COMMENT '身份证号码/组织机构代码',
	`type` VARCHAR (255) DEFAULT NULL COMMENT '类型',
	`bbd_qyxx_id` VARCHAR (40) DEFAULT NULL COMMENT '企业唯一ID',
	`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`task_id` INT (11) DEFAULT NULL,
	PRIMARY KEY (`zhixing_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '全国被执行人';

DROP TABLE IF EXISTS recruit_index;

CREATE TABLE `recruit_index` (
	`recruit_id` INT (11) NOT NULL AUTO_INCREMENT,
	`company_name` VARCHAR (450) DEFAULT NULL COMMENT 'company_name',
	`recruit_industryratio` VARCHAR (450) DEFAULT NULL COMMENT '行业分布',
	`recruit_salaryratio` VARCHAR (450) DEFAULT NULL COMMENT '薪资分布',
	`recruit_index` VARCHAR (450) DEFAULT NULL COMMENT '招聘指数',
	`dt` VARCHAR (450) DEFAULT NULL COMMENT '时间',
	`task_id` INT (11) DEFAULT NULL,
	PRIMARY KEY (`recruit_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '招聘指数表';

DROP TABLE IF EXISTS offline_financial_record;

CREATE TABLE `offline_financial_record` (
	`id` INT (11) NOT NULL AUTO_INCREMENT COMMENT 'PK',
	`company_id` INT (11) DEFAULT NULL COMMENT '企业ID',
	`credit_code` CHAR (20) DEFAULT NULL COMMENT '统一社会信用代码',
	`company_name` VARCHAR (100) DEFAULT NULL COMMENT '公司名',
	`organization_code` VARCHAR (50) DEFAULT NULL COMMENT '组织机构代码',
	`create_by` VARCHAR (50) DEFAULT NULL COMMENT '创建人',
	`create_date` date DEFAULT NULL COMMENT '创建时间',
	`update_by` VARCHAR (50) DEFAULT NULL COMMENT '修改人',
	`update_date` date DEFAULT NULL COMMENT '修改时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '线下理财接口上传信息';

DROP TABLE IF EXISTS data_loading_fail_info;

CREATE TABLE `data_loading_fail_info` (
	`id` INT (11) NOT NULL AUTO_INCREMENT COMMENT 'PK',
	`task_id` INT (11) DEFAULT NULL COMMENT '企业ID',
	`error_name` VARCHAR (100) DEFAULT NULL COMMENT '企业名称',
	`source_task_id` INT (11) DEFAULT NULL,
	`error_reason` VARCHAR (255) DEFAULT NULL,
	`type` VARCHAR (100) DEFAULT NULL,
	`data_version` VARCHAR (20) DEFAULT NULL COMMENT '数据版本号',
	`create_by` VARCHAR (50) DEFAULT NULL COMMENT '创建人',
	`create_date` TIMESTAMP NULL DEFAULT NULL COMMENT '创建时间',
	`update_by` VARCHAR (50) DEFAULT NULL COMMENT '修改人',
	`update_date` TIMESTAMP NULL DEFAULT NULL COMMENT '修改时间',
	PRIMARY KEY (`id`),
	KEY `index_company_id` (`task_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '数据落地失败数据表';

DROP TABLE IF EXISTS datashare_pull_file;
CREATE TABLE `datashare_pull_file` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `file_url` varchar(500) DEFAULT NULL COMMENT '文件路径',
  `data_version` int(11) DEFAULT NULL COMMENT '数据版本号',
  `is_pull` tinyint(1) DEFAULT '0' COMMENT '是否已经拉取',
  `task_id` int(11) DEFAULT NULL COMMENT '数据落地任务ID',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_date` date DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='datashare文件拉取';

DROP TABLE IF EXISTS `import_record`;

CREATE TABLE `import_record` (
	`id` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'ID',
	`file_name` VARCHAR (100) NOT NULL COMMENT '文件名',
	`imp_user` VARCHAR (50) DEFAULT NULL COMMENT '导入用户登录名',
	`file_size` BIGINT (20) DEFAULT NULL,
	`imp_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '导入时间',
	`imp_state` TINYINT (2) DEFAULT NULL COMMENT '导入状态',
	`remark` VARCHAR (50) DEFAULT '' COMMENT '备注',
	`imp_type` TINYINT (2) DEFAULT NULL COMMENT '类型。1：企业名单，2：行业数据',
	`have_error_file` TINYINT (1) DEFAULT '0' COMMENT '是否有错误文件生成',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `timing_task_info`;
CREATE TABLE `timing_task_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'task id',
  `task_name` varchar(50) DEFAULT NULL COMMENT '任务名称',
  `task_key` varchar(50) DEFAULT NULL COMMENT '任务KEY',
  `task_group` varchar(50) DEFAULT NULL,
  `cron` varchar(50) DEFAULT NULL COMMENT '时间表达式',
  `cron_desc` varchar(50) DEFAULT NULL COMMENT '时间表达式描述',
  `target_class` varchar(200) DEFAULT NULL COMMENT '执行目标类',
  `target_method` varchar(100) DEFAULT NULL COMMENT '执行目标方法',
  `description` varchar(50) DEFAULT NULL COMMENT '任务描述',
  `start_date` timestamp NULL DEFAULT NULL COMMENT '任务开始时间',
  `end_date` timestamp NULL DEFAULT NULL COMMENT '任务结束时间',
  `data_source` tinyint(2) DEFAULT NULL COMMENT '数据来源:1 BBD; 2 网贷之家; 3 公信中心 ',
  `state` tinyint(2) DEFAULT NULL COMMENT '任务状态',
  `is_show` tinyint(2) DEFAULT NULL COMMENT '是否在页面上显示。1：显示；其他：不显示',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`task_key`,`task_group`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务基础信息表';

DROP TABLE IF EXISTS `task_fail_info`;
CREATE TABLE `task_fail_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `task_id` int(11) DEFAULT NULL COMMENT '任务ID',
  `fail_name` varchar(100) DEFAULT NULL COMMENT '失败名称：企业/表',
  `fail_reason` varchar(255) DEFAULT NULL COMMENT '失败名称',
  `source_task_id` int(11) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `data_version` varchar(20) DEFAULT NULL COMMENT '数据版本号',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `index_task_id` (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务失败数据表';

DROP TABLE IF EXISTS `company_credit_data_items`;
CREATE TABLE `company_credit_data_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `resource_name` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `data_item` varchar(100) DEFAULT NULL COMMENT '数据项',
  `data_item_name` varchar(100) DEFAULT NULL COMMENT '数据项名称',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_date` date DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公信中心数据项字段对照表';


DROP TABLE IF EXISTS `area_index`;
CREATE TABLE `area_index` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area` varchar(45) DEFAULT NULL COMMENT '省份',
  `rank` int(11) DEFAULT NULL COMMENT '排名',
  `ecosystem` double DEFAULT NULL COMMENT '网贷生态环境',
  `scale` double DEFAULT NULL COMMENT '网贷规模',
  `popularity` double DEFAULT NULL COMMENT '网贷人气',
  `safety` double DEFAULT NULL COMMENT '网贷安全度',
  `recognition` double DEFAULT NULL COMMENT '资本认可度',
  `competitiveness` double DEFAULT NULL COMMENT '综合竞争力',
  `create_by` varchar(45) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='区域发展指数';

DROP TABLE IF EXISTS `crowd_funding_common`;
CREATE TABLE `crowd_funding_common` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reward` varchar(50) DEFAULT NULL COMMENT '奖励众筹',
  `non_pulic_equity_financing` varchar(50) DEFAULT NULL COMMENT '非公开股权融资',
  `public_welfare` varchar(50) DEFAULT NULL COMMENT '公益众筹',
  `blend` varchar(50) DEFAULT NULL COMMENT '混合众筹',
  `type` varchar(50) DEFAULT NULL COMMENT 'dataType',
  `create_by` varchar(45) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `crowd_funding_company_dataland`;
CREATE TABLE `crowd_funding_company_dataland` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '企业ID',
  `company_name` varchar(100) DEFAULT NULL COMMENT '公司名',
  `platform_name` varchar(50) DEFAULT NULL COMMENT '平台名',
  `website_url` varchar(200) DEFAULT NULL COMMENT '网站URL',
  `funding_business_type` varchar(50) DEFAULT NULL COMMENT '业务类型 1:公益型 2:综合型 3:权益型 4:股权型',
  `success_number` varchar(50) DEFAULT NULL COMMENT '成功项目数',
  `funded_amout` varchar(50) DEFAULT NULL COMMENT '已筹基金',
  `operation_address` varchar(200) DEFAULT NULL COMMENT '运营地址',
  `registration_address` varchar(200) DEFAULT NULL COMMENT '注册地址',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_date` date DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业基本信息';

DROP TABLE IF EXISTS `industry_compare`;

CREATE TABLE `industry_compare` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(45) DEFAULT NULL COMMENT '月份',
  `area` varchar(45) DEFAULT NULL COMMENT '地区',
  `amount` double DEFAULT NULL COMMENT '成交量',
  `balance_loans` double DEFAULT NULL COMMENT '贷款余额',
  `create_by` varchar(45) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `industry_problem`;

CREATE TABLE `industry_problem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(45) DEFAULT NULL COMMENT '月份',
  `area` varchar(45) DEFAULT NULL COMMENT '地区',
  `problem_plat_number` int(11) DEFAULT NULL COMMENT '问题平台数量',
  `create_by` varchar(45) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `industry_shanghai`;
CREATE TABLE `industry_shanghai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `new_plat_num` int(11) DEFAULT NULL COMMENT '上海新增P2P平台数量',
  `interest_rate` double DEFAULT NULL COMMENT '上海地区P2P综合利率',
  `total_plat_num` int(11) DEFAULT NULL COMMENT '上海累计P2P平台数量',
  `borrowed_num` int(11) DEFAULT NULL COMMENT '上海P2P月借款人数',
  `invest_num` int(11) DEFAULT NULL COMMENT '上海P2P月投资人数',
  `amount` double DEFAULT NULL COMMENT '上海地区P2P成交量',
  `area_num` text COMMENT '上海P2P月投资人数',
  `date` varchar(45) DEFAULT NULL,
  `create_by` varchar(45) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `plat_core_data`;

CREATE TABLE `plat_core_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plat_name` varchar(100) DEFAULT NULL COMMENT '平台名',
  `other_sum_amount` double DEFAULT NULL COMMENT '其余借款额',
  `interest_rate` double DEFAULT NULL COMMENT '平均利率',
  `bid_num_stay_stil` int(11) DEFAULT NULL COMMENT '待收投资人数',
  `bor_num_stay_stil` int(11) DEFAULT NULL COMMENT '待还借款人数',
  `plat_data_six_month` text COMMENT '近6个月每日详情数据',
  `company_name` varchar(200) DEFAULT NULL COMMENT '公司名称',
  `top10_sum_amount` double DEFAULT NULL COMMENT '最大十户借款额',
  `money_stock` double DEFAULT NULL COMMENT '贷款余额',
  `day30_net_inflow` double DEFAULT NULL COMMENT '近30日资金流入',
  `top1_sum_amount` double DEFAULT NULL COMMENT '最大单户借款额',
  `amount_total` double DEFAULT NULL COMMENT '平台累计成交量',
  `create_by` varchar(45) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `plat_list`;

CREATE TABLE `plat_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plat_name` varchar(100) DEFAULT NULL COMMENT '平台名',
  `company_name` varchar(200) DEFAULT NULL COMMENT '公司名',
  `logo_url` varchar(200) DEFAULT NULL,
  `area_id` varchar(45) DEFAULT NULL,
  `create_by` varchar(45) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `plat_rank_data`;
CREATE TABLE `plat_rank_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plat_name` varchar(45) DEFAULT NULL COMMENT '平台名称',
  `rank` int(11) DEFAULT NULL COMMENT '排名',
  `amount` double DEFAULT NULL COMMENT '成交量',
  `income_rate` double DEFAULT NULL COMMENT '平均利率',
  `loan_period` double DEFAULT NULL COMMENT '平均借款期限',
  `stay_still_of_total` double DEFAULT NULL COMMENT '累计待还金额',
  `plat_status` varchar(45) DEFAULT NULL COMMENT '平台状态',
  `registered_address` varchar(500) DEFAULT NULL COMMENT '注册地址',
  `area_id` varchar(45) DEFAULT NULL COMMENT '地区id',
  `create_by` varchar(45) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `radar_score`;
CREATE TABLE `radar_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plat_name` varchar(200) DEFAULT NULL COMMENT '平台名',
  `info_disclosure` double DEFAULT NULL COMMENT '信息披露',
  `fluidity` double DEFAULT NULL COMMENT '流动性',
  `dispersion` double DEFAULT NULL COMMENT '分散度',
  `capital` double DEFAULT NULL COMMENT '资本充足',
  `penalty_cost` double DEFAULT NULL COMMENT '违约成本',
  `operation` double DEFAULT NULL COMMENT '运营能力',
  `create_by` varchar(45) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `update_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `yuqing_warning`;

CREATE TABLE `yuqing_warning` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plat_name` varchar(100) DEFAULT NULL COMMENT '平台名称',
  `score` double DEFAULT NULL COMMENT '得分',
  `title` varchar(400) DEFAULT NULL COMMENT '标题',
  `content` longtext COMMENT '内容',
  `source` varchar(200) DEFAULT NULL COMMENT '来源',
  `date` varchar(100) DEFAULT NULL COMMENT '日期',
  `create_by` varchar(45) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 20170821 Beijing  publish begin                       */
drop table if exists park_public_sentiment;

/*==============================================================*/
/* Table: park_public_sentiment                                 */
/*==============================================================*/
create table park_public_sentiment
(
   id                   int not null auto_increment comment '逻辑主键',
   area_id              int not null comment '所属行政区编码',
   park                 varchar(100) not null comment '园区',
   get_date             date not null comment '舆情获取日期',
   news_site            varchar(100),
   search_key           text,
   author               varchar(100),
   main                 text,
   plate                varchar(200),
   news_title           varchar(100),
   bbd_type             varchar(200),
   bbd_url              varchar(200),
   pubdate              varchar(50),
   status               varchar(30),
   create_by            varchar(50) comment '创建人',
   create_date          datetime comment '创建时间',
   update_by            varchar(50) comment '修改人',
   update_date          datetime comment '修改时间',
   primary key (id)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='园区舆情'
;

drop table if exists building_public_sentiment;

/*==============================================================*/
/* Table: building_public_sentiment                             */
/*==============================================================*/
create table building_public_sentiment
(
   id                   int not null auto_increment comment '逻辑主键',
   building_id          int not null comment '楼宇ID',
   get_date             date not null comment '舆情获取日期',
   news_site            varchar(100),
   search_key           text,
   author               varchar(100),
   main                 text,
   plate                varchar(200),
   news_title           varchar(100),
   bbd_type             varchar(200),
   bbd_url              varchar(200),
   pubdate              varchar(50),
   status               varchar(30),
   create_by            varchar(50) comment '创建人',
   create_date          datetime comment '创建时间',
   update_by            varchar(50) comment '修改人',
   update_date          datetime comment '修改时间',
   primary key (id)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='楼宇舆情'
;
/* 20170821 Beijing  publish end                       */

/* 20170901 update park jurisdiction by Barney begin */
drop table if exists park_range;

/*==============================================================*/
/* Table: park_range                                            */
/*==============================================================*/
create table park_range
(
   id                   int not null auto_increment comment '逻辑主键',
   user_id              int not null comment '用户id',
   park_id              int not null comment '园区id',
   create_by            varchar(50) comment '创建人',
   create_date          datetime comment '创建时间',
   update_by            varchar(50) comment '修改人',
   update_date          datetime comment '修改时间',
   primary key (id)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='园区范围表'
;

drop table if exists park_and_building_relation;

/*==============================================================*/
/* Table: park_and_building_relation                            */
/*==============================================================*/
create table park_and_building_relation
(
   id                   int not null auto_increment comment '逻辑主键',
   park_id              int not null comment '园区id',
   building_id          int not null comment '楼宇id',
   create_by            varchar(50) comment '创建人',
   create_date          datetime comment '创建时间',
   update_by            varchar(50) comment '修改人',
   update_date          datetime comment '修改时间',
   primary key (id)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='园区与楼宇关系表'
;
/* 20170901 update park jurisdiction by Barney end */


/* 20170901  by chen gong jie begin */

#数仓tag表和黑白名单表集合运算后的最新版本数据本地存储
CREATE TABLE `qyxx_tag` (
  `kid` int(11) NOT NULL AUTO_INCREMENT,
  `bbd_qyxx_id` varchar(34) NOT NULL,
  `tag` varchar(20) NOT NULL COMMENT '标签',
  `company_name` varchar(60) NOT NULL COMMENT '企业名称',
  `uptime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `dt` int(10) DEFAULT NULL COMMENT '数据版本',
  PRIMARY KEY (`kid`),
  KEY `index_company_name` (`company_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=139994 DEFAULT CHARSET=utf8 COMMENT='企业标签表，对应数仓的dw.qyxx_tag表及黑白名单表加减后的最新版本数据';

CREATE TABLE `subscription_list_append` (
  `company_name` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `subscription_list_remove` (
  `company_name` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# capital_amount表添加数据版本列
ALTER TABLE `capital_amount`
ADD COLUMN `data_version`  int(11) NULL DEFAULT 2016 COMMENT '数据版本(年份)' AFTER `publish_company_number`;

/* 20170901  by chen gong jie end */

/* 20170901  by sun li ming begin */
DROP TABLE IF EXISTS tbl_relation;
DROP TABLE IF EXISTS tbl_point;
CREATE TABLE `tbl_point` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `bbd_qyxx_id` varchar(40) DEFAULT NULL COMMENT '企业唯一ID',
  `queried_company` varchar(100) DEFAULT NULL COMMENT '目标公司',
  `name` varchar(40) DEFAULT NULL COMMENT '关联方ID',
  `cname` varchar(100) DEFAULT NULL COMMENT '关联方名称',
  `level` varchar(2) DEFAULT NULL COMMENT '所处关联度数',
  `is_person` varchar(2) DEFAULT NULL COMMENT '是否是个人（0：公司；1：个人）',
  `is_son_com` varchar(2) DEFAULT NULL COMMENT '是否为子公司（0：否；1：是）',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
	KEY `idx_bbd_qyxx_id` (`bbd_qyxx_id`),
  KEY `idx_queried_company` (`queried_company`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='关联方点表';

DROP TABLE IF EXISTS tbl_line;
CREATE TABLE `tbl_line` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `bbd_qyxx_id` varchar(40) DEFAULT NULL COMMENT '企业唯一ID',
  `queried_company` varchar(100) DEFAULT NULL COMMENT '目标公司',
  `orig` varchar(40) DEFAULT NULL COMMENT '投资方ID',
  `orig_name` varchar(100) DEFAULT NULL COMMENT '投资方',
  `target` varchar(40) DEFAULT NULL COMMENT '被投资方ID',
	`target_name` varchar(100) DEFAULT NULL COMMENT '被投资方',
  `is_full_line` varchar(2) DEFAULT NULL COMMENT '是否为实线（0：否；1：是）',
	`type` varchar(20) DEFAULT NULL COMMENT '关联关系',
	`relationship` varchar(2) DEFAULT NULL COMMENT '关联方关系（0：公司与公司；1：人与公司）',
	`orig_level` varchar(2) DEFAULT NULL COMMENT '投资方关联维度',
  `tar_level` varchar(2) DEFAULT NULL COMMENT '被投资方关联维度',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
	KEY `idx_bbd_qyxx_id` (`bbd_qyxx_id`),
  KEY `idx_queried_company` (`queried_company`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='关联方线';

DROP TABLE IF EXISTS company_tag;
CREATE TABLE `company_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `company_name` varchar(100) NOT NULL COMMENT '企业名称',
  `tag` tinyint(4) DEFAULT NULL COMMENT 'TAG',
  `dt` int(10) DEFAULT NULL COMMENT '来源版本',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_date` date DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_company_name` (`company_name`),
  KEY `idx_tag` (`tag`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企业TAG';

/* 20170901  by sun li ming end */


