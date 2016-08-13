package com.bbd.wtyh.domain.bbdAPI;

import java.util.List;

/**
 * Created by YanWenyuan on 2016/8/13.
 */
public class CourtAnnouncementDO {
    private List<Results> results;

    public class Results {
        private String main;
        private String trial_date;
    }
}
