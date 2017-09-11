package com.bbd.wtyh.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by cgj on 2017-09-06.
 */
@Table(name = "subscription_list")
public class SubscriptionListDO {
        @Column(name = "company_name")
        private String companyName;

        public String getCompanyName() {
            return companyName;
        }
        @SuppressWarnings("unused")
        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }
}
