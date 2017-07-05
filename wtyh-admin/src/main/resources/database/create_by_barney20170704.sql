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
   status               int not null default 0 comment '有效标识（0：无效；1有效）',
   create_by            varchar(32) comment '创建人',
   create_date          timestamp comment '创建时间',
   update_by            varchar(32) comment '修改人',
   update_date          timestamp comment '修改时间',
   primary key (id)
);

alter table natural_person comment '自然人表';