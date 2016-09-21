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

    private Double amount;

    private Double income_rate;

    private Double loan_period;

    private Double stay_still_of_total;

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getIncome_rate() {
        return income_rate;
    }

    public void setIncome_rate(Double income_rate) {
        this.income_rate = income_rate;
    }

    public Double getLoan_period() {
        return loan_period;
    }

    public void setLoan_period(Double loan_period) {
        this.loan_period = loan_period;
    }

    public Double getStay_still_of_total() {
        return stay_still_of_total;
    }

    public void setStay_still_of_total(Double stay_still_of_total) {
        this.stay_still_of_total = stay_still_of_total;
    }
}
