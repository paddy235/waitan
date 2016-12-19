package com.bbd.wtyh.domain.bbdAPI;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouxuan on 2016/12/16.
 */
public class RecruitDataDO extends BaseDO implements Serializable {
    private List<RecruitInfo> results;

    public static class RecruitInfo implements Serializable {
        private Map<String, String> index;
        private Map<String, String> salary_ratio;
        private Map<String, String> industry_ratio;

        public Map<String, String> getIndex() {
            return index;
        }

        public void setIndex(Map<String, String> index) {
            this.index = index;
        }

        public Map<String, String> getSalary_ratio() {
            return salary_ratio;
        }

        public void setSalary_ratio(Map<String, String> salary_ratio) {
            this.salary_ratio = salary_ratio;
        }

        public Map<String, String> getIndustry_ratio() {
            return industry_ratio;
        }

        public void setIndustry_ratio(Map<String, String> industry_ratio) {
            this.industry_ratio = industry_ratio;
        }
    }


    public List<RecruitInfo> getResults() {
        return results;
    }

    public void setResults(List<RecruitInfo> results) {
        this.results = results;
    }
}
