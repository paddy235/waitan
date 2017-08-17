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

drop table if exists park_public_sentiment;

/*==============================================================*/
/* Table: park_public_sentiment                                 */
/*==============================================================*/
create table park_public_sentiment
(
   areaId               int not null comment '所属行政区编码',
   park                 varchar(100) not null comment '园区',
   get_date             date not null comment '舆情获取日期',
   comment_num          char(10),
   news_site            varchar(100),
   search_key           text,
   author               varchar(100),
   main                 text,
   plate                varchar(200),
   abstract             varchar(200),
   table_name           varchar(100),
   pricture             varchar(200),
   transfer_num         varchar(30),
   news_title           varchar(100),
   bbd_type             varchar(200),
   bbd_dotime           varchar(50),
   bbd_url              varchar(200),
   pubdate              varchar(50),
   status               varchar(30),
   create_by            varchar(50) comment '创建人',
   create_date          datetime comment '创建时间',
   update_by            varchar(50) comment '修改人',
   update_date          datetime comment '修改时间',
   primary key (areaId, park, get_date)
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
   building_id          int not null comment '楼宇ID',
   get_date             date not null comment '舆情获取日期',
   comment_num          char(10),
   news_site            varchar(100),
   search_key           text,
   author               varchar(100),
   main                 text,
   plate                varchar(200),
   abstract             varchar(200),
   table_name           varchar(100),
   pricture             varchar(200),
   transfer_num         varchar(30),
   news_title           varchar(100),
   bbd_type             varchar(200),
   bbd_dotime           varchar(50),
   bbd_url              varchar(200),
   pubdate              varchar(50),
   status               varchar(30),
   create_by            varchar(50) comment '创建人',
   create_date          datetime comment '创建时间',
   update_by            varchar(50) comment '修改人',
   update_date          datetime comment '修改时间',
   primary key (building_id, get_date)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='楼宇舆情'
;