package com.bbd.wtyh.domain.wangDaiAPI;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by lixudong on 2017/7/18.
 */
public class PlatCoreDataDTO {
    private String plat_name;
    private Double other_sum_amount;
    private Double  interest_rate;
    private Integer bid_num_stay_stil;
    private Integer bor_num_stay_stil;
    private List<PlatDataSixMonth> plat_data_six_month; // 近6个月每日详情数据 plat_data_six_month
    private String company_name;
    private Double top10_sum_amount;
    private Double money_stock;
    @JSONField(name="30_day_net_inflow")
    private Double day30_net_inflow;    // 近30日资金流入
    private Double top1_sum_amount;
    private Double amount_total;

    public class PlatDataSixMonth {
        private String date;
        private Double day_interest_rate;   // 平台利率
        private Double day_net_inflow;
        private Double day_amount;  // 平台成交量
        private Double day_money_stock; // 贷款余额

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Double getDay_interest_rate() {
            return day_interest_rate;
        }

        public void setDay_interest_rate(Double day_interest_rate) {
            this.day_interest_rate = day_interest_rate;
        }

        public Double getDay_net_inflow() {
            return day_net_inflow;
        }

        public void setDay_net_inflow(Double day_net_inflow) {
            this.day_net_inflow = day_net_inflow;
        }

        public Double getDay_amount() {
            return day_amount;
        }

        public void setDay_amount(Double day_amount) {
            this.day_amount = day_amount;
        }

        public Double getDay_money_stock() {
            return day_money_stock;
        }

        public void setDay_money_stock(Double day_money_stock) {
            this.day_money_stock = day_money_stock;
        }

        @Override
        public String toString() {
            return "{" +
                    "date='" + date + '\'' +
                    ", day_interest_rate=" + day_interest_rate +
                    ", day_net_inflow=" + day_net_inflow +
                    ", day_amount=" + day_amount +
                    ", day_money_stock=" + day_money_stock +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PlatCoreDateDTO{" +
                "plat_name='" + plat_name + '\'' +
                ", other_sum_amount=" + other_sum_amount +
                ", interest_rate=" + interest_rate +
                ", bid_num_stay_stil=" + bid_num_stay_stil +
                ", bor_num_stay_stil=" + bor_num_stay_stil +
                ", plat_data_six_month=" + plat_data_six_month +
                ", company_name='" + company_name + '\'' +
                ", top10_sum_amount=" + top10_sum_amount +
                ", money_stock=" + money_stock +
                ", day30_net_inflow=" + day30_net_inflow +
                ", top1_sum_amount=" + top1_sum_amount +
                ", amount_total=" + amount_total +
                '}';
    }

    public String getPlat_name() {
        return plat_name;
    }

    public void setPlat_name(String plat_name) {
        this.plat_name = plat_name;
    }

    public Double getOther_sum_amount() {
        return other_sum_amount;
    }

    public void setOther_sum_amount(Double other_sum_amount) {
        this.other_sum_amount = other_sum_amount;
    }

    public Double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(Double interest_rate) {
        this.interest_rate = interest_rate;
    }

    public Integer getBid_num_stay_stil() {
        return bid_num_stay_stil;
    }

    public void setBid_num_stay_stil(Integer bid_num_stay_stil) {
        this.bid_num_stay_stil = bid_num_stay_stil;
    }

    public Integer getBor_num_stay_stil() {
        return bor_num_stay_stil;
    }

    public void setBor_num_stay_stil(Integer bor_num_stay_stil) {
        this.bor_num_stay_stil = bor_num_stay_stil;
    }

    public List<PlatDataSixMonth> getPlat_data_six_month() {
        return plat_data_six_month;
    }

    public void setPlat_data_six_month(List<PlatDataSixMonth> plat_data_six_month) {
        this.plat_data_six_month = plat_data_six_month;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Double getTop10_sum_amount() {
        return top10_sum_amount;
    }

    public void setTop10_sum_amount(Double top10_sum_amount) {
        this.top10_sum_amount = top10_sum_amount;
    }

    public Double getMoney_stock() {
        return money_stock;
    }

    public void setMoney_stock(Double money_stock) {
        this.money_stock = money_stock;
    }

    public Double getDay30_net_inflow() {
        return day30_net_inflow;
    }

    public void setDay30_net_inflow(Double day30_net_inflow) {
        this.day30_net_inflow = day30_net_inflow;
    }

    public Double getTop1_sum_amount() {
        return top1_sum_amount;
    }

    public void setTop1_sum_amount(Double top1_sum_amount) {
        this.top1_sum_amount = top1_sum_amount;
    }

    public Double getAmount_total() {
        return amount_total;
    }

    public void setAmount_total(Double amount_total) {
        this.amount_total = amount_total;
    }
}
