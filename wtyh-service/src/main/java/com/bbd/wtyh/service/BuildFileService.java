package com.bbd.wtyh.service;

import java.util.List;

/**
 * Created by win7 on 2016/8/10.
 */
public interface BuildFileService {

    public boolean buildImage(List<List<Object>> data, String company, String filePath, boolean flag)throws Exception;
}
