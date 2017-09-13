

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