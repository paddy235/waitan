package com.bbd.wtyh.domain.wangDaiAPI;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

/**
 * Created by YanWenyuan on 2016/8/12.
 */
public class PlatDataDO {
    private String plat_name;   // 平台名称
    private double plat_score;  // 平台评分
    private String plat_status; // 平台营业状态
    private String company_name;    // 平台公司名称
    private double amount_total;    // 平台累计成交量
    private double interest_rate;   // 平均利率
    private double money_stock;     // 贷款余额
    @JSONField(name="30_day_net_inflow")
    private double day30_net_inflow;    // 近30日资金流入
    private int bid_num_stay_stil;  // 待收投资人数
    private int bor_num_stay_stil;  // 待还借款人数
    private double top10_sum_amount;    // 最大十户借款额
    private double other_sum_amount;    // 其余借款额
    private double top1_sum_amount; // 最大单户借款额
    private List<PlatDataSixMonth> plat_data_six_month; // 近6个月每日详情数据

    public class PlatDataSixMonth {
        private String date;
        private double day_interest_rate;   // 平台利率
        private double day_amount;  // 平台成交量
        private double day_money_stock; // 贷款余额

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public double getDay_interest_rate() {
            return day_interest_rate;
        }

        public void setDay_interest_rate(double day_interest_rate) {
            this.day_interest_rate = day_interest_rate;
        }

        public double getDay_amount() {
            return day_amount;
        }

        public void setDay_amount(double day_amount) {
            this.day_amount = day_amount;
        }

        public double getDay_money_stock() {
            return day_money_stock;
        }

        public void setDay_money_stock(double day_money_stock) {
            this.day_money_stock = day_money_stock;
        }
    }

    public String getPlat_name() {
        return plat_name;
    }

    public void setPlat_name(String plat_name) {
        this.plat_name = plat_name;
    }

    public double getPlat_score() {
        return plat_score;
    }

    public void setPlat_score(double plat_score) {
        this.plat_score = plat_score;
    }

    public String getPlat_status() {
        return plat_status;
    }

    public void setPlat_status(String plat_status) {
        this.plat_status = plat_status;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public double getAmount_total() {
        return amount_total;
    }

    public void setAmount_total(double amount_total) {
        this.amount_total = amount_total;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }

    public double getMoney_stock() {
        return money_stock;
    }

    public void setMoney_stock(double money_stock) {
        this.money_stock = money_stock;
    }

    public double getDay30_net_inflow() {
        return day30_net_inflow;
    }

    public void setDay30_net_inflow(double day30_net_inflow) {
        this.day30_net_inflow = day30_net_inflow;
    }

    public int getBid_num_stay_stil() {
        return bid_num_stay_stil;
    }

    public void setBid_num_stay_stil(int bid_num_stay_stil) {
        this.bid_num_stay_stil = bid_num_stay_stil;
    }

    public int getBor_num_stay_stil() {
        return bor_num_stay_stil;
    }

    public void setBor_num_stay_stil(int bor_num_stay_stil) {
        this.bor_num_stay_stil = bor_num_stay_stil;
    }

    public double getTop10_sum_amount() {
        return top10_sum_amount;
    }

    public void setTop10_sum_amount(double top10_sum_amount) {
        this.top10_sum_amount = top10_sum_amount;
    }

    public double getOther_sum_amount() {
        return other_sum_amount;
    }

    public void setOther_sum_amount(double other_sum_amount) {
        this.other_sum_amount = other_sum_amount;
    }

    public double getTop1_sum_amount() {
        return top1_sum_amount;
    }

    public void setTop1_sum_amount(double top1_sum_amount) {
        this.top1_sum_amount = top1_sum_amount;
    }

    public List<PlatDataSixMonth> getPlat_data_six_month() {
        // TODO: 获取数据中的，最近的 15条
        return plat_data_six_month;
    }

    public void setPlat_data_six_month(List<PlatDataSixMonth> plat_data_six_month) {
        this.plat_data_six_month = plat_data_six_month;
    }
}
