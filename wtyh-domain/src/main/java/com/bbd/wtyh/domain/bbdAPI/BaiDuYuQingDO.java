package com.bbd.wtyh.domain.bbdAPI;

import com.google.gson.annotations.SerializedName;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by YanWenyuan on 2016/8/13.
 */
public class BaiDuYuQingDO {
    // TODO
    private String msg;
    private Integer rsize;
    private String total;
    private List<Results> results;

    public class  Results {

        private String news_title;
        private String news_site;
        private String pubdate;
        @SerializedName("abstract")
        private String content; // TODO 新闻内容
        private String main;
        private String bbd_url;
        private String bbd_type;


        public String getBbd_url() {
            return bbd_url;
        }

        public void setBbd_url(String bbd_url) {
            this.bbd_url = bbd_url;
        }

        public String getBbd_type() {
            return bbd_type;
        }

        public void setBbd_type(String bbd_type) {
            this.bbd_type = bbd_type;
        }



        public String getNews_title() {
            return news_title;
        }

        public void setNews_title(String news_title) {
            this.news_title = news_title;
        }

        public String getNews_site() {
            return news_site;
        }

        public void setNews_site(String news_site) {
            this.news_site = news_site;
        }

        public String getPubdate() {
            return pubdate;
        }

        public void setPubdate(String pubdate) {
            this.pubdate = pubdate;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }
    }

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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
