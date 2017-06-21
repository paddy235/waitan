package com.bbd.wtyh.report.service;

import java.util.Map;

/**
 * Created by cgj on 2017/6/14.
 */
public interface WordReportService {
    Map<String, Object> reportExport(String companyName, String loginName, String areaCode ) throws Exception;

}
