drop table if exists natural_person;

/*==============================================================*/
/* Table: natural_person                                        */
/*==============================================================*/
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
   update_date          timestamp comment '修改时间',
   primary key (id)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='自然人表'
;

drop table if exists park_building_img;

/*==============================================================*/
/* Table: park_building_img                                     */
/*==============================================================*/
create table park_building_img
(
   id                   int not null auto_increment comment '逻辑主键',
   pic_name             varchar(100) not null comment '图片名称',
   pic_url              varchar(200) comment '访问路径',
   pic                  mediumblob comment '图片',
   pic_type             int not null default 2 comment '图片所属建筑类型（1：园区；2：楼宇）',
   pic_park_id          int comment '所属园区',
   pic_building_id      int comment '所属楼宇',
   status               int not null default 0 comment '图片可用状态（0：不可用；1：可用；2：已用）',
   ip                   varchar(25) comment '服务器IP',
   create_by            varchar(50) comment '创建人',
   create_date          timestamp comment '创建时间',
   update_by            varchar(50) comment '修改人',
   update_date          timestamp comment '修改时间',
   primary key (id)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='园区以及楼宇图片表'
;

drop table if exists park_company_import;

/*==============================================================*/
/* Table: park_company_import                                   */
/*==============================================================*/
create table park_company_import
(
   id                   int not null comment '逻辑主键',
   import_no            varchar(100) not null comment '导入批次号',
   company_name         varchar(100) not null comment '企业名称',
   building_name        varchar(100) not null comment '楼宇名称',
   company_id           int comment '企业ID',
   building_id          int comment '楼宇ID',
   error_company        varchar(200) comment '企业异常信息',
   error_building       varchar(200) comment '楼宇异常信息',
   create_by            varchar(50) comment '创建人',
   create_date          timestamp comment '创建时间',
   update_by            varchar(50) comment '修改人',
   update_date          timestamp comment '修改时间',
   primary key (id)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='园区企业导入表'
;

#对“user_misc_parameter”表做表结构修改（增加了两个字段），并添加一条记录
ALTER TABLE `user_misc_parameter`
MODIFY COLUMN `name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数名称' AFTER `para_id`,
MODIFY COLUMN `value2`  int(11) NULL DEFAULT NULL COMMENT ' 参数的值2' AFTER `value1`,
ADD COLUMN `value3`  int(11) NULL DEFAULT NULL COMMENT ' 参数的值3' AFTER `value2`,
ADD COLUMN `str`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数的值，字符串类型' AFTER `value3`;
INSERT INTO `wtyh`.`user_misc_parameter` (`para_id`, `name`, `description`, `value1`, `value2`, `value3`, `str`)
VALUES ('2', 'naturalPersonTimeNum', '已下载的次数（v1）、当前日（v2，仅存第几日）和每天可下载的总次数（v3）', '0', '0', '50', '');