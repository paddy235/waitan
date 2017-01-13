package com.bbd.wtyh.domain.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * description:
 * author:liaohao
 * date:2016/11/30 0030 10:58.
 */
public class RelationDTO extends BaseDTO {
    private List<Result> results;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public static class Result {

        /**
         * 投资方纬度
         */
        @SerializedName("investor_degree")
        private String  investor_degree;

        /**
         * 被投资方纬度
         */
        @SerializedName("investee_degree")
        private String  investee_degree;

        /**
         * 关系 1 实线 (投资人) 0 虚线（企业高管）
         */
        @SerializedName("rel_type")
        private Integer relType;

        /**
         * 类型
         */
        @SerializedName("rel")
        private String  type;

        /**
         * 是否是自然人 0 否 1是
         */
        @SerializedName("is_natural")
        private Integer isNatural;

        /**
         * 投资方
         */
        @SerializedName("investor")
        private String  investor;

        /**
         * 被投资方
         */
        @SerializedName("investee")
        private String  investee;

        public String getInvestor_degree() {
            return investor_degree;
        }

        public void setInvestor_degree(String investor_degree) {
            this.investor_degree = investor_degree;
        }

        public String getInvestee_degree() {
            return investee_degree;
        }

        public void setInvestee_degree(String investee_degree) {
            this.investee_degree = investee_degree;
        }

        public Integer getRelType() {
            return relType;
        }

        public void setRelType(Integer relType) {
            this.relType = relType;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getIsNatural() {
            return isNatural;
        }

        public void setIsNatural(Integer isNatural) {
            this.isNatural = isNatural;
        }

        public String getInvestor() {
            return investor;
        }

        public void setInvestor(String investor) {
            this.investor = investor;
        }

        public String getInvestee() {
            return investee;
        }

        public void setInvestee(String investee) {
            this.investee = investee;
        }
    }
}
