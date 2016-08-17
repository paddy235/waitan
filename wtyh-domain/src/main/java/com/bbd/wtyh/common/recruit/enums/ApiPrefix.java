package com.bbd.wtyh.common.recruit.enums;

/**
 * Created by wangchenge on 2016/8/17 0017.
 */
public enum ApiPrefix {
    RELATION_API("relation.api.url"),
    SEARCH_API("api.search.url"),

    /**
     * 备案信息接口
     */
    COMPANY_SEARCH_API("api.companysearch.url"),

    /**
     * 诉讼记录api
     */
    SUSONG_API("susong.api.url"),

    /**
     * 法院公告
     */
    COURT_NOTICE("court.notice.api.url"),

    /**
     * 招中标
     */
    BIDDING_API("bidding.api.url"),

    /**
     * 招聘api
     */
    YU_API("yu.api.url"),

    BIDDING_API_NEW("bidding.api.url.new"),

    KPI_API("kpi.api.url"),

    KPI_INDUSTRY_API("kpi.api.industry.url"),

    KPI_COMMON_API("kpi.api.common.url"),

    KPI_PROP_API("kpi.api.prop.url");


    private String apiPrefix;

    ApiPrefix(String apiPrefix) {
        this.apiPrefix = apiPrefix;
    }

    public String getApiPrefix() {
        return apiPrefix;
    }

}
