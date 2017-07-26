drop table if exists tbl_relation;

/*==============================================================*/
/* Table: tbl_relation                                          */
/*==============================================================*/
create table tbl_relation
(
   id                   int not null auto_increment comment '逻辑主键',
   target_company       varchar(100) comment '目标公司',
   investors            varchar(100) comment '投资方',
   investee             varchar(100) comment '被投资方',
   relationship         varchar(2) comment '关联关系（0：企业之间；1：个人与企业）',
   investors_no         int comment '投资方维度',
   investee_no          int comment '被投资方维度',
   full_line            varchar(2) comment '是否投资方向（0：否；1：是）',
   create_by            varchar(50) comment '创建人',
   create_date          timestamp comment '创建时间',
   update_by            varchar(50) comment '修改人',
   update_date          timestamp comment '修改时间',
   primary key (id)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='关联方表'
;