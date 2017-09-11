package com.bbd.bgo.service.task;

import com.bbd.wtyh.domain.SubscriptionListDO;

import java.io.File;
import java.util.List;

/**
 * Created by cgj on 2017-09-05.
 */
public interface TagUpdateService {

    void operateData();

    void modifySubscriptionList(List<SubscriptionListDO> list, boolean isDel) throws Exception;
}

