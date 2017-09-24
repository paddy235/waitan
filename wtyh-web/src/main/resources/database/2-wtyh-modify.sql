-- add resource
INSERT INTO `resource` (`id`, `code`, `name`, `parent_code`, `type`, `url`, `display_order`, `create_date`, `create_by`, `update_date`, `update_by`) VALUES (23, 'B_DSRW', '定时任务', NULL, 'B', NULL, 330, '2017-7-31 10:00:00', 'sunliming', NULL, NULL);
INSERT INTO `resource` (`id`, `code`, `name`, `parent_code`, `type`, `url`, `display_order`, `create_date`, `create_by`, `update_date`, `update_by`) VALUES (24, 'B_YWSJGL', '业务数据管理', NULL, 'B', NULL, 340, '2017-7-31 10:00:00', 'sunliming', NULL, NULL);
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (59, 'S', 'B_DSRW', '定时任务');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (60, 'S', 'B_YWSJGL', '业务数据管理');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (61, 'B', 'B_DSRW', '定时任务');
INSERT INTO `user_type_resource` (`id`, `user_type`, `resource_code`, `resource_name`) VALUES (62, 'B', 'B_YWSJGL', '业务数据管理');
insert into role_resource(role_id,resource_id) value (1,23);
insert into role_resource(role_id,resource_id) value (1,24);

ALTER TABLE `user_misc_parameter`
MODIFY COLUMN `name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数名称' AFTER `para_id`,
MODIFY COLUMN `value2`  int(11) NULL DEFAULT NULL COMMENT ' 参数的值2' AFTER `value1`,
ADD COLUMN `value3`  int(11) NULL DEFAULT NULL COMMENT ' 参数的值3' AFTER `value2`,
ADD COLUMN `str`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数的值，字符串类型' AFTER `value3`;
INSERT INTO `wtyh`.`user_misc_parameter` (`para_id`, `name`, `description`, `value1`, `value2`, `value3`, `str`) VALUES ('2', 'naturalPersonTimeNum', '已下载的次数（v1）、当前日（v2，仅存第几日）和每天可下载的总次数（v3）', '0', '0', '50', '');

ALTER TABLE `wtyh`.`qdlp_progress` 
CHANGE COLUMN `index_num` `index_num` INT(11) NULL DEFAULT NULL COMMENT '顺序' ;

-- ----------------------------
-- Records of timing_task_info
-- ----------------------------
INSERT INTO `timing_task_info` (`id`, `task_name`, `task_key`, `task_group`, `cron`, `cron_desc`, `target_class`, `target_method`, `description`, `data_source`, `is_show`) VALUES (1, '企业与网贷平台对照表更新', 'platformJob', 'job_work', '0 0 23 * * ?', '每天23点更新', 'com.bbd.bgo.service.task.PlatUpdateTaskServiceImpl', 'start', '更新platform_name_information表的信息', 1, 1);
INSERT INTO `timing_task_info` (`id`, `task_name`, `task_key`, `task_group`, `cron`, `cron_desc`, `target_class`, `target_method`, `description`, `data_source`, `is_show`) VALUES (2, '企业基本信息更新', 'companyBaseInfoJob', 'job_work', '0 0 21 5,20 * ?', '每月5、20号 21点更新', 'com.bbd.bgo.service.task.SystemDataUpdateServiceImpl', 'start', '更新company表的企业基本信息', 1, 1);
INSERT INTO `timing_task_info` (`id`, `task_name`, `task_key`, `task_group`, `cron`, `cron_desc`, `target_class`, `target_method`, `description`, `data_source`, `is_show`) VALUES (3, '企业风险等级更新', 'riskLevelJob', 'job_work', '0 0 19 6,21 * ?', '每月6、21号19点更新', 'com.bbd.wtyh.service.impl.OfflineFinanceServiceImpl', 'start', '更新company表的企业风险等级', 1, 1);
INSERT INTO `timing_task_info` (`id`, `task_name`, `task_key`, `task_group`, `cron`, `cron_desc`, `target_class`, `target_method`, `description`, `data_source`, `is_show`) VALUES (4, 'BBD企业全息舆情数据更新', 'holographicAndOpinionJob', 'bbd_work', '0 30 18 * * ?', '每天18:30更新', 'com.bbd.bgo.service.task.DataLoadingServiceImpl', 'start', '企业全息数据和舆情数据落地', 1, 1);
INSERT INTO `timing_task_info` (`id`, `task_name`, `task_key`, `task_group`, `cron`, `cron_desc`, `target_class`, `target_method`, `description`, `data_source`, `is_show`) VALUES (5, '线下理财风险数据', 'offlineFinanceJob', 'bbd_work', '0 59 23 5,20 * ?', '每月5、20号 21点更新', 'com.bbd.bgo.service.task.SyncFileServiceImpl', 'start', '线下理财数据落地', 1, 1);
INSERT INTO `timing_task_info` (`id`, `task_name`, `task_key`, `task_group`, `cron`, `cron_desc`, `target_class`, `target_method`, `description`, `data_source`, `is_show`) VALUES (6, '网络借贷其他数据更新', 'p2pMonitorJob', 'wd_work', '0 0 1 12 * ?', '每月12号01点更新', 'com.bbd.wtyh.service.impl.PToPMonitorServiceImpl', 'start', '网络借贷其他接口数据', 2, 1);
INSERT INTO `timing_task_info` (`id`, `task_name`, `task_key`, `task_group`, `cron`, `cron_desc`, `target_class`, `target_method`, `description`, `data_source`, `is_show`) VALUES (7, '众筹数更新', 'crowdFundingJob', 'wd_work', '0 0 1 12 * ?', '每月12号01点更新', 'com.bbd.wtyh.service.impl.CrowdFundingServiceImpl', 'start', '众筹数据落地', 2, 1);
INSERT INTO `timing_task_info` (`id`, `task_name`, `task_key`, `task_group`, `cron`, `cron_desc`, `target_class`, `target_method`, `description`, `data_source`, `is_show`) VALUES (8, '网络借贷核心数据更新', 'p2pImageJob', 'wd_work', '0 0 1 * * ?', '每天01点更新', 'com.bbd.wtyh.service.impl.P2PImageServiceImpl', 'start', '网络借贷舆情、核心数据和集中度数据', 2, 1);
INSERT INTO `timing_task_info` (`id`, `task_name`, `task_key`, `task_group`, `cron`, `cron_desc`, `target_class`, `target_method`, `description`, `data_source`, `is_show`) VALUES (9, '公信中心数据更新', 'shangHaiCreditJob', 'credit_work', '0 0 18 ? * 6', '每周五18点更新', 'com.bbd.wtyh.service.impl.CoCreditScoreServiceImpl', 'start', '公信中心数据落地', 3, 1);
INSERT INTO `timing_task_info` (`id`, `task_name`, `task_key`, `task_group`, `cron`, `cron_desc`, `target_class`, `target_method`, `description`, `data_source`, `is_show`) VALUES (10, '停止公信中心数据更新', 'closeShangHaiCreditJob', 'credit_work', '0 0 7 ? * 2', '每周一7点停止', 'com.bbd.wtyh.service.impl.CoCreditServiceCloseImpl', 'start', '公信中心数据落地任务停止', 3, 0);

alter table task_success_fail_info add state int(2)  DEFAULT NULL COMMENT '任务状态 ' after fail_count;
alter table task_success_fail_info add re_execute int(2)  DEFAULT NULL COMMENT '重新执行标志: 0和其他表示不可执行 1可执行 2 已手动执行 ' after state;

INSERT INTO `company_credit_data_items` VALUES ('93', '民事执行-生效判决未执行', 'A3', '被执行人', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('94', '民事执行-生效判决未执行', 'A6', '执行标的金额（单位：元）', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('95', '民事执行-生效判决未执行', 'A7', '判决案号', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('96', '民事执行-限制高消费令', 'A1', '执行案号', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('97', '民事执行-限制高消费令', 'A2', '立案日期', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('98', '民事执行-限制高消费令', 'A3', '被执行人姓名', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('99', '民事执行-限制高消费令', 'A4', '执行标的金额（单位：元）', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('100', '民事执行-限制高消费令', 'A9', '判决案号', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('101', '民事执行-限制高消费令', 'A5', '限高令撤销日期', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('102', '民事执行-曝光台', 'A1', '执行案号', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('103', '民事执行-曝光台', 'A7', '立案日期', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('104', '民事执行-曝光台', 'A3', '被执行人', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('105', '民事执行-曝光台', 'A6', '执行标的金额(单位：元)', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('106', '民事执行-曝光台', 'A9', '判决案号', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('107', '民事执行-曝光台', 'A8', '曝光台撤销日期', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('108', '失信被执行人信息', 'A1', '执行案号', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('109', '失信被执行人信息', 'A2', '发布日期', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('110', '失信被执行人信息', 'A3', '被执行人', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('111', '失信被执行人信息', 'A6', '法定代表人或负责人', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('112', '失信被执行人信息', 'A7', '失信情形', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('113', '失信被执行人信息', 'A12', '履行情况', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('114', '失信被执行人信息', 'A8', '执行依据制作单位', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('115', '失信被执行人信息', 'A9', '执行依据文号', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('116', '失信被执行人信息', 'A10', '立案时间', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('117', '民事执行-网上追查', 'A1', '执行案号', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('118', '民事执行-网上追查', 'A2', '立案日期', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('119', '民事执行-网上追查', 'A3', '被执行人', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('120', '民事执行-网上追查', 'A4', '执行标的金额（单位：元）', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('121', '民事执行-网上追查', 'A5', '网上追查撤销日期', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('122', '民事执行-限制出境', 'A1', '案号', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('123', '民事执行-限制出境', 'A2', '立案日期', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('124', '民事执行-限制出境', 'A3', '被执行人', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('125', '民事执行-限制出境', 'A4', '执行标的金额（单位：元）', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('126', '民事执行-限制出境', 'A5', '限制出境开始日期', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('127', '民事执行-限制出境', 'A6', '限制出境结束日期', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('128', '民事执行-限制出境', 'A7', '操作时间', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('129', '民事执行-限制出境', 'A8', '操作名称', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('130', '民事执行-限制出境', 'A11', '判决案号', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('131', '刑事判决', 'A1', '判决案号', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('132', '刑事判决', 'A2', '所判罪名', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('133', '刑事判决', 'A3', '判决时间', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('134', '刑事判决', 'A4', '刑法种类和期限', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('135', '刑事判决', 'A5', '附加刑', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('136', '刑事判决', 'A6', '剥夺政治权利', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('137', '刑事判决', 'A7', '涉案金额（单位：元）', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('138', '民事判决', 'A1', '判决案号', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('139', '民事判决', 'A2', '原告', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('140', '民事判决', 'A3', '被告', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('141', '民事判决', 'A4', '第三人', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('142', '民事判决', 'A7', '案由', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('143', '民事判决', 'A9', '判决时间', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('144', '非正常户认定', 'assessdate', '非正常户认定日期', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('145', '用人单位欠缴社会保险费，被依法责令限期缴纳信息', 'A1', '违法对象', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('146', '用人单位欠缴社会保险费，被依法责令限期缴纳信息', 'A2', '违法内容', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('147', '用人单位欠缴社会保险费，被依法责令限期缴纳信息', 'A6', '责令限期缴纳文书号', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('148', '用人单位欠缴社会保险费，被依法责令限期缴纳信息', 'A7', '作出责令限期缴纳文书日期', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('149', '用人单位欠缴社会保险费，被依法责令限期缴纳信息', 'A8', '备注', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('150', '市场监管类行政处罚（法人）', 'A1', '委办名称', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('151', '市场监管类行政处罚（法人）', 'A2', '行政处罚决定书文号', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('152', '市场监管类行政处罚（法人）', 'A3', '案件名称', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('153', '市场监管类行政处罚（法人）', 'A6', '违法行为类型', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('154', '市场监管类行政处罚（法人）', 'A7', '行政处罚的内容', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('155', '市场监管类行政处罚（法人）', 'A8', '做出决定机关名称', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('156', '市场监管类行政处罚（法人）', 'A9', '作出行政处罚决定日期', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('157', '经营异常名录', 'A1', '委办名称', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('158', '经营异常名录', 'A4', '列入时间', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('159', '经营异常名录', 'A5', '移出时间', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('160', '经营异常名录', 'move_in_reason', '企业列入经营异常名录原因', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('161', '经营异常名录', 'move_in_date', '列入日期', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('162', '经营异常名录', 'undo_reason', '企业移出经营异常名录原因', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('163', '经营异常名录', 'undo_date', '移出日期', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('164', '经营异常名录', 'move_in_organ_id', '作出决定机关', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('165', '行政处罚信息', 'pen_dec_no', '处罚决定书文号', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('166', '行政处罚信息', 'illeg_act', '违法行为类型', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('167', '行政处罚信息', 'pen_type', '处罚种类', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('168', '行政处罚信息', 'pen_amount', '罚款金额', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('169', '行政处罚信息', 'forf_amount', '没收金额', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('170', '行政处罚信息', 'pen_organ', '处罚决定机关', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('171', '行政处罚信息', 'pen_deciss_date', '处罚决定日期', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('172', '行政处罚信息', 'reg_no', '当事人注册号', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('173', '行政处罚信息', 'enty_name', '当事人单位名称', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('174', '行政处罚信息', 'person_name', '当事人法定代表人', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('175', '行政处罚信息', 'change_content', '变更内容', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('176', '行政处罚信息', 'change_date', '变更日期', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('177', '行政处罚信息', 'change_punish_organ', '作出变更决定机关名称', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('178', '对不正当竞争行为的处罚', 'illegalcontext', '违法事实', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('179', '对不正当竞争行为的处罚', 'illegaldate', '违法日期', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('180', '对不正当竞争行为的处罚', 'punishbasis', '处罚依据', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('181', '对不正当竞争行为的处罚', 'punishmeasures', '处罚措施', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('182', '对不正当竞争行为的处罚', 'punishdate', '处罚决定时间', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('183', '对不正当竞争行为的处罚', 'punishlimit', '履罚期限', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('184', '民事执行-生效判决未执行', 'A2', '立案日期', null, null, null, null);
INSERT INTO `company_credit_data_items` VALUES ('185', '民事执行-生效判决未执行', 'A1', '执行案号', null, null, null, null);
/* 20170901  by liyao begin */
UPDATE company SET previous_risk_level = null, risk_level = null WHERE company_type in (2, 3, 11, 13);
/* 20170901  by liyao end */