package com.bbd.wtyh.domain.wangDaiAPI;

import java.util.List;

/**
 * Created by YanWenyuan on 2016/8/13.
 */
public class YuQing {
    private String plat_name;
    private String score;
    private List<Warning> warning;

    private class Warning {
        private String info;

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
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
