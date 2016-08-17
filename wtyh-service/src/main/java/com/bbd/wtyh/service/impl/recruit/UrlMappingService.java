package com.bbd.wtyh.service.impl.recruit;

import com.bbd.higgs.utils.ListUtil;
import com.bbd.wtyh.common.recruit.StringUtil;
import com.bbd.wtyh.service.impl.recruit.mapper.UrlMapping;
import com.bbd.wtyh.service.impl.recruit.mapper.UrlMappingMapper;
import com.bbd.wtyh.util.relation.BbdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wangchenge on 2016/8/17 0017.
 */
@Service
public class UrlMappingService {
    @Autowired
    private UrlMappingMapper urlMappingMapper;
    public UrlMapping getUrlMapping(String apiPrefix, Date deadline) {
        if (StringUtil.isNullOrEmpty(apiPrefix) || null == deadline) {
            throw new BbdException("请求异常，原因：参数为空。apiPrefix=" + apiPrefix + ";deadline=" + deadline);
        }
        UrlMapping urlMapping = null;
        List<UrlMapping> list = urlMappingMapper.queryUrlMappingByPrefix(apiPrefix);
        if (ListUtil.isNotEmpty(list)) {
            for (UrlMapping mapping : list) {
                if (deadline.after(mapping.getVersionDate())) {
                    urlMapping = mapping;
                    break;
                }
            }
            if (null == urlMapping) {
                urlMapping = list.get(list.size() - 1);
            }
        }
        return urlMapping;
    }
}
