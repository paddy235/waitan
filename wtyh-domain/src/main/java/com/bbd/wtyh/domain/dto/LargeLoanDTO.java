package com.bbd.wtyh.domain.dto;

/**
 * Created by Marco on 2016/8/9.
 */
public class LargeLoanDTO {

    private Integer lenderId;
    private Integer borrowerId;
    private String borrowerName;
    private String lenderName;
    private String borrowerBusinessType;
    private String borrowerRegisteredCapital;

    public Integer getLenderId() {
        return lenderId;
    }

    public void setLenderId(Integer lenderId) {
        this.lenderId = lenderId;
    }

    public Integer getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Integer borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getLenderName() {
        return lenderName;
    }

    public void setLenderName(String lenderName) {
        this.lenderName = lenderName;
    }

    public String getBorrowerBusinessType() {
        return borrowerBusinessType;
    }

    public void setBorrowerBusinessType(String borrowerBusinessType) {
        this.borrowerBusinessType = borrowerBusinessType;
    }

    public String getBorrowerRegisteredCapital() {
        return borrowerRegisteredCapital;
    }

    public void setBorrowerRegisteredCapital(String borrowerRegisteredCapital) {
        this.borrowerRegisteredCapital = borrowerRegisteredCapital;
    }
}
