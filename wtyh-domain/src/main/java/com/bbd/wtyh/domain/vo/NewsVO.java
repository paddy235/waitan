package com.bbd.wtyh.domain.vo;

import java.util.List;

/**
 *
 * 輿情VO
 * Created by suyin on 2016/8/27.
 */
public class NewsVO {
    private String msg;//: "ok",
    private Integer rsize;//: 19,
    private Integer total;//: 19,
    private List<Result> results;//:

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getRsize() {
        return rsize;
    }

    public void setRsize(Integer rsize) {
        this.rsize = rsize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public static class Result{

        private String _id;//: "",
        private String bbd_type;//: "qyxg_sinablog_data",
        private Integer bbd_uptime;//: 1471431130,
        private String bbd_dotime;//: "2016-08-17",
        private String bbd_source;//: null,
        private String bbd_url;//: "http://finance.sina.com.cn/roll/2016-04-04/doc-ifxqxqmf3954990.shtml",
        private String bbd_xgxx_id;//: "2582fc757043f080f359ea05b83ced6b",
        private Integer comment_num;//: 90,
        private String main;//: "【大大集团被查后“死灰复燃”】在去年底被警方调查，且出现兑付危机的互联网金融公司大大集团，竟然又开始公开招聘了。值得一提的是，这次招聘的主体换成了上海申彤大大资产管理有限公司，薪资在10万元至50万元不等。事实上，大大集团被查后几个月，许多投资者仍在维权路上。 http://t.cn/RqywEqW",
        private String news_site;//: null,
        private String news_title;//: null,
        private String picture;//: "[]",
        private String plate;//: null,
        private String pubdate;//: "2016-04-04T05:01:00+00:00",
        private String rowkey;//: null,
        private Integer status;//: 0,
        private String table_name;//: "sinablog_raw",
        private Integer transfer_num;//: 158,
        private String search_key;//: "上海值得资产管理有限公司",
        private String aBstract;//: null,
        private String author;//: "新浪财经"

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
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

        public String getBbd_dotime() {
            return bbd_dotime;
        }

        public void setBbd_dotime(String bbd_dotime) {
            this.bbd_dotime = bbd_dotime;
        }

        public String getBbd_source() {
            return bbd_source;
        }

        public void setBbd_source(String bbd_source) {
            this.bbd_source = bbd_source;
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

        public String getPubdate() {
            return pubdate;
        }

        public void setPubdate(String pubdate) {
            this.pubdate = pubdate;
        }

        public String getRowkey() {
            return rowkey;
        }

        public void setRowkey(String rowkey) {
            this.rowkey = rowkey;
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

        public String getSearch_key() {
            return search_key;
        }

        public void setSearch_key(String search_key) {
            this.search_key = search_key;
        }

        public String getaBstract() {
            return aBstract;
        }

        public void setaBstract(String aBstract) {
            this.aBstract = aBstract;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }
}
