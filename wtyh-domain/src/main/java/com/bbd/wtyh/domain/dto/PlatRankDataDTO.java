package com.bbd.wtyh.domain.dto;


/**
 * 上海网贷平台数据展示
 *
 * @author Ian.Su
 * @since 2016年8月10日 下午2:50:44
 */
public class PlatRankDataDTO {


    private int rank;

    private String plat_name;

    private String amount;

    private String income_rate;

    private String loan_period;

    private String stay_still_of_total;

    private String plat_status;

    private String registered_address;

    public String getRegistered_address() {
        return registered_address;
    }

    public void setRegistered_address(String registered_address) {
        this.registered_address = registered_address;
    }

    public String getPlat_status() {
        return plat_status;
    }

    public void setPlat_status(String plat_status) {
        this.plat_status = plat_status;
    }

    public int getRank() {
        return rank;
    }


    public void setRank(int rank) {
        this.rank = rank;
    }


    public String getPlat_name() {
        return plat_name;
    }

    public void setPlat_name(String plat_name) {
        this.plat_name = plat_name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getIncome_rate() {
        return income_rate;
    }

    public void setIncome_rate(String income_rate) {
        this.income_rate = income_rate;
    }

    public String getLoan_period() {
        return loan_period;
    }

    public void setLoan_period(String loan_period) {
        this.loan_period = loan_period;
    }

    public String getStay_still_of_total() {
        return stay_still_of_total;
    }

    public void setStay_still_of_total(String stay_still_of_total) {
        this.stay_still_of_total = stay_still_of_total;
    }
}
