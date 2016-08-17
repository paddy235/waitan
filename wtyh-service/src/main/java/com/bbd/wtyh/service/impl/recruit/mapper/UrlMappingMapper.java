package com.bbd.wtyh.service.impl.recruit.mapper;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/8/17 0017.
 */
public interface UrlMappingMapper {
    public List<Date> queryAllVersionDate();

    public List<UrlMapping> queryKPIUrlMapping();

    public List<UrlMapping> queryAllUrlMapping();

    public UrlMapping querySearchUrlMapping();

    public List<UrlMapping> queryUrlMappingByPrefix(String prefix);
}
