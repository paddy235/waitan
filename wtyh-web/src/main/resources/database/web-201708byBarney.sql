drop table if exists park_public_sentiment;

/*==============================================================*/
/* Table: park_public_sentiment                                 */
/*==============================================================*/
create table park_public_sentiment
(
   area_id               int not null comment '所属行政区编码',
   park                 varchar(100) not null comment '园区',
   get_date             date not null comment '舆情获取日期',
   news_site            varchar(100),
   search_key           text,
   author               varchar(100),
   main                 text,
   plate                varchar(200),
   abstract             varchar(200),
   pricture             varchar(200),
   news_title           varchar(100),
   bbd_type             varchar(200),
   bbd_url              varchar(200),
   pubdate              varchar(50),
   status               varchar(30),
   create_by            varchar(50) comment '创建人',
   create_date          datetime comment '创建时间',
   update_by            varchar(50) comment '修改人',
   update_date          datetime comment '修改时间',
   primary key (area_id, park, get_date)
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
   news_site            varchar(100),
   search_key           text,
   author               varchar(100),
   main                 text,
   plate                varchar(200),
   abstract             varchar(200),
   pricture             varchar(200),
   news_title           varchar(100),
   bbd_type             varchar(200),
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