DROP TABLE IF EXISTS risk_change_company;
CREATE TABLE `risk_change_company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `company_id` int(11) DEFAULT NULL COMMENT '公司ID',
  `company_name` varchar(100) DEFAULT NULL COMMENT '企业名称',
  `organization_code` varchar(50) DEFAULT NULL COMMENT '组织机构代码',
  `company_type` tinyint(4) DEFAULT NULL COMMENT '公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融 9:交易所 10:商业保理 11.预付卡 12.典当 13融资租赁 ',
  `area_id` int(11) DEFAULT NULL COMMENT '区域ID',
  `area_name` varchar(50) DEFAULT NULL COMMENT '名称',
  `building_id` int(11) DEFAULT NULL COMMENT '楼宇ID',
  `building_name` varchar(100) DEFAULT NULL COMMENT '楼宇名字',
  `risk_level` tinyint(4) DEFAULT NULL COMMENT '公司当前风险等级，1:已出风险(黑) 2:重点关注(红) 3:一般关注(黄) 4:正常(绿)。针对company_type=1/4/9/11',
  `old_risk_level` tinyint(4) DEFAULT NULL COMMENT '公司原始风险等级，1:已出风险(黑) 2:重点关注(红) 3:一般关注(黄) 4:正常(绿)。针对company_type=1/4/9/11',
  `out_Level` int(11) DEFAULT NULL COMMENT '当前外部评级值。针对company_type=2/3',
  `old_out_Level` int(11) DEFAULT NULL COMMENT '原始外部评级值。针对company_type=2/3',
  `inner_Level` int(11) DEFAULT NULL COMMENT '当前内部评级值。针对company_type=2/3',
  `old_inner_Level` int(11) DEFAULT NULL COMMENT '原始内部评级值。针对company_type=2/3',
  `live_Level` int(11) DEFAULT NULL COMMENT '当前现场检查值。针对company_type=2/3',
  `old_live_Level` int(11) DEFAULT NULL COMMENT '原始现场检查值。针对company_type=2/3',
  `have_risk` tinyint(1) DEFAULT NULL COMMENT '当前是否存在风险。针对company_type=13',
  `old_have_risk` tinyint(1) DEFAULT NULL COMMENT '原始是否存在风险。针对company_type=13',
  `source` tinyint(2) DEFAULT NULL COMMENT '来源，1：人工修改，2：模型评分',
  `change_date` timestamp NULL DEFAULT NULL COMMENT '变化时间',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_date` date DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='风险变化企业';

CREATE TABLE `company_status_change` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `company_id` int(11) DEFAULT '0' COMMENT '公司ID',
  `company_name` varchar(100) DEFAULT NULL COMMENT '企业名称',
  `organization_code` varchar(50) DEFAULT NULL COMMENT '组织机构代码',
  `company_type` tinyint(4) DEFAULT NULL COMMENT '公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融 9:交易所 10:商业保理 11.预付卡 12.典当 13融资租赁 ',
  `old_company_type` tinyint(4) DEFAULT NULL COMMENT '公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融 9:交易所 10:商业保理 11.预付卡 12.典当 13融资租赁 ',
  `area_id` int(11) DEFAULT NULL COMMENT '区域ID',
  `area_name` varchar(50) DEFAULT NULL COMMENT '区域名称',
  `register_date` date DEFAULT NULL COMMENT '注册时间',
  `adjust_date` date DEFAULT NULL COMMENT '调整时间',
  `closed_date` date DEFAULT NULL COMMENT '停业时间',
  `order_date` date DEFAULT NULL COMMENT '排序时间',
  `registered_capital_type` tinyint(4) DEFAULT NULL COMMENT '注册资本类型 1:人民币 2:美元',
  `registered_capital` int(11) DEFAULT NULL COMMENT '注册资本',
  `change_type` tinyint(2) DEFAULT NULL COMMENT '变化类型 1:新增,2:停业',
  `source` tinyint(2) DEFAULT NULL COMMENT '新增来源 1:新注册,2:新发现,3:人工修改',
  `closed_type` tinyint(2) DEFAULT NULL COMMENT '停业原因',
  `address` varchar(100) DEFAULT NULL COMMENT '注册地址',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企业增销';

UPDATE `resource` SET code='F_QXXX' WHERE CODE='F_QYQXXXCXPT';
INSERT INTO `resource` ( `code`, `name`, `parent_code`, `type`, `url`, `display_order`, `create_date`, `create_by`, `update_date`, `update_by`) VALUES ('F_QYQXXXCXPT', '企业搜索', 'F_QXXX', 'F', NULL, 310, '2017-3-28 00:00:00', 'sunliming', NULL, NULL);
INSERT INTO `resource` ( `code`, `name`, `parent_code`, `type`, `url`, `display_order`, `create_date`, `create_by`, `update_date`, `update_by`) VALUES ('F_QXXX_PCXXLR', '排查信息录入', 'F_QXXX', 'F', NULL, 320, '2017-3-28 00:00:00', 'sunliming', NULL, NULL);

Insert into role_resource(role_id,resource_id,create_date,create_by) 
select role_id,(select id from resource where name='企业搜索')AS resource_id ,create_date,create_by from role_resource where resource_id in (select id from resource where name='企业全息信息查询平台');


CREATE TABLE `user_type_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `user_type` char(2) NOT NULL COMMENT '用户类型',
  `resource_code` varchar(50) NOT NULL COMMENT '权限代码',
  `resource_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (1, 'S', 'F_HYJCPT', '行业监测平台');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (2, 'S', 'F_HYJCPT_WLJD', '网络借贷');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (3, 'S', 'F_HYJCPT_XXLC', '线下理财');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (4, 'S', 'F_HYJCPT_XEDK', '小额贷款');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (5, 'S', 'F_HYJCPT_RZDB', '融资担保');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (6, 'S', 'F_HYJCPT_SMJJ', '私募基金');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (7, 'S', 'F_HYJCPT_JYCS', '交易场所');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (8, 'S', 'F_HYJCPT_ZC', '众筹');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (9, 'S', 'F_HYJCPT_DD', '典当');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (10, 'S', 'F_HYJCPT_RZZL', '融资租赁');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (11, 'S', 'F_HYJCPT_SYBL', '商业保理');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (12, 'S', 'F_HYJCPT_YFK', '预付卡');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (13, 'S', 'F_YQJCPT', '园区监测平台');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (14, 'S', 'F_QXXX', '企业全息信息查询平台');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (15, 'S', 'F_QYQXXXCXPT', '企业搜索');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (16, 'S', 'F_QXXX_PCXXLR', '排查信息录入');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (17, 'S', 'F_SSJCPT', '实时监测平台');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (18, 'S', 'B_HTGLQX', '用户角色管理');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (19, 'S', 'B_YHRZGL', '用户日志管理');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (21, 'S', 'B_QYBHJC', '企业变化检测');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (22, 'F', 'F_HYJCPT', '行业监测平台');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (23, 'F', 'F_HYJCPT_WLJD', '网络借贷');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (24, 'F', 'F_HYJCPT_XXLC', '线下理财');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (25, 'F', 'F_HYJCPT_XEDK', '小额贷款');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (26, 'F', 'F_HYJCPT_RZDB', '融资担保');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (27, 'F', 'F_HYJCPT_SMJJ', '私募基金');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (28, 'F', 'F_HYJCPT_JYCS', '交易场所');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (29, 'F', 'F_HYJCPT_ZC', '众筹');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (30, 'F', 'F_HYJCPT_DD', '典当');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (31, 'F', 'F_HYJCPT_RZZL', '融资租赁');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (32, 'F', 'F_HYJCPT_SYBL', '商业保理');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (33, 'F', 'F_HYJCPT_YFK', '预付卡');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (34, 'F', 'F_YQJCPT', '园区监测平台');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (35, 'F', 'F_QXXX', '企业全息信息查询平台');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (36, 'F', 'F_QYQXXXCXPT', '企业搜索');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (37, 'F', 'F_SSJCPT', '实时监测平台');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (38, 'D', 'F_HYJCPT', '行业监测平台');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (39, 'D', 'F_HYJCPT_WLJD', '网络借贷');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (40, 'D', 'F_HYJCPT_XXLC', '线下理财');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (41, 'D', 'F_HYJCPT_XEDK', '小额贷款');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (42, 'D', 'F_HYJCPT_RZDB', '融资担保');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (43, 'D', 'F_HYJCPT_SMJJ', '私募基金');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (44, 'D', 'F_HYJCPT_JYCS', '交易场所');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (45, 'D', 'F_HYJCPT_ZC', '众筹');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (46, 'D', 'F_HYJCPT_DD', '典当');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (47, 'D', 'F_HYJCPT_RZZL', '融资租赁');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (48, 'D', 'F_HYJCPT_SYBL', '商业保理');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (49, 'D', 'F_HYJCPT_YFK', '预付卡');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (50, 'D', 'F_YQJCPT', '园区监测平台');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (51, 'D', 'F_QXXX', '企业全息信息查询平台');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (52, 'D', 'F_QYQXXXCXPT', '企业搜索');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (53, 'D', 'F_QXXX_PCXXLR', '排查信息录入');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (54, 'D', 'F_SSJCPT', '实时监测平台');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (55, 'B', 'B_HTGLQX', '用户角色管理');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (56, 'B', 'B_YHRZGL', '用户日志管理');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (58, 'B', 'B_QYBHJC', '企业变化检测');

#将admin升级成超级管理员,拥有前后台访问权限,后台密码不变,前台初始密码是:12345678,首次登录要求修改密码
UPDATE `user_mgment` SET
`user_type`='S',
`fore_pwd`='08ed6d706fad33e253d64e6e1d52d025',
`fore_pwd_up_date` ='1970-01-02 06:00:00'
WHERE (`login_name`='admin');
