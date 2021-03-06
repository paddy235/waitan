package com.bbd.wtyh.domain.dataLoading;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by wangchenge on 2016/8/21 0021.
 */
@Table(name = "qyxg_yuqing")
public class QyxgYuqingDO {

    @Id
    @Column(name = "yuqing_id")
    private Integer id;

    @Column(name = "abstract")
    private String articleAbstract;//文章摘要
    @Column
    private String author;//作者名称
    @Column
    private Date bbd_dotime;//日期
    @Column
    private String bbd_source;//数据源
    @Column
    private String bbd_type;//表类型
    @Column
    private Integer bbd_uptime;//时间戳
    @Column
    private String bbd_url;//网页链接
    @Column
    private String bbd_xgxx_id;//相关信息唯一ID
    @Column
    private Integer comment_num;//评论数
    @Column
    private String main;//原文
    @Column
    private String news_site;//网站
    @Column
    private String news_title;//标题
    @Column
    private String picture;//正文图片
    @Column
    private String plate;//所属网站板块
    @Column
    private Date pubdate;//发布时间
    @Column
    private String rowkey;//rowkey
    @Column
    private String search_key;//搜索关键字
    @Column
    private Integer status;//status
    @Column
    private String table_name;//table_name
    @Column
    private Integer transfer_num;//转发量
    @Column
    private Date create_time;
    @Column
    private String create_by;
    @Column
    private String bbd_qyxx_id;//企业唯一ID
    @Column
    private Integer task_id;

    public QyxgYuqingDO() {
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getBbd_dotime() {
        return bbd_dotime;
    }

    public void setBbd_dotime(Date bbd_dotime) {
        this.bbd_dotime = bbd_dotime;
    }

    public String getBbd_source() {
        return bbd_source;
    }

    public void setBbd_source(String bbd_source) {
        this.bbd_source = bbd_source;
    }

    public String getBbd_type() {
        return bbd_type;
    }

    public void setBbd_type(String bbd_type) {
        this.bbd_type = bbd_type;
    }

    public Integer getBbd_uptime() {
        return bbd_uptime;
    }

    public void setBbd_uptime(Integer bbd_uptime) {
        this.bbd_uptime = bbd_uptime;
    }

    public String getBbd_url() {
        return bbd_url;
    }

    public void setBbd_url(String bbd_url) {
        this.bbd_url = bbd_url;
    }

    public String getBbd_xgxx_id() {
        return bbd_xgxx_id;
    }

    public void setBbd_xgxx_id(String bbd_xgxx_id) {
        this.bbd_xgxx_id = bbd_xgxx_id;
    }

    public Integer getComment_num() {
        return comment_num;
    }

    public void setComment_num(Integer comment_num) {
        this.comment_num = comment_num;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getNews_site() {
        return news_site;
    }

    public void setNews_site(String news_site) {
        this.news_site = news_site;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getRowkey() {
        return rowkey;
    }

    public void setRowkey(String rowkey) {
        this.rowkey = rowkey;
    }

    public String getSearch_key() {
        return search_key;
    }

    public void setSearch_key(String search_key) {
        this.search_key = search_key;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public Integer getTransfer_num() {
        return transfer_num;
    }

    public void setTransfer_num(Integer transfer_num) {
        this.transfer_num = transfer_num;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getBbd_qyxx_id() {
        return bbd_qyxx_id;
    }

    public void setBbd_qyxx_id(String bbd_qyxx_id) {
        this.bbd_qyxx_id = bbd_qyxx_id;
    }

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }
}
