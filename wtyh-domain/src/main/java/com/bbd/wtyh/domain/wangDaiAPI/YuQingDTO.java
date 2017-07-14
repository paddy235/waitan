package com.bbd.wtyh.domain.wangDaiAPI;

import java.util.List;

public class YuQingDTO {
    private String plat_name;
    private String score;
    private List<Warning> warning;

    public class Warning {
        private String title;
        private String content;
        private String source;
        private String date;

        @Override
        public String toString() {
            return "{" +
                    "title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    ", source='" + source + '\'' +
                    ", date='" + date + '\'' +
                    '}';
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

    public String getPlat_name() {
        return plat_name;
    }

    public void setPlat_name(String plat_name) {
        this.plat_name = plat_name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public List<Warning> getWarning() {
        return warning;
    }

    public void setWarning(List<Warning> warning) {
        this.warning = warning;
    }
}
