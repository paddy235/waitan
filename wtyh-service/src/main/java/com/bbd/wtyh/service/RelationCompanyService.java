package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.*;

import java.util.List;


/**
* 关联方数据接口
* @author
* @since 2016.08.10
*/
public interface RelationCompanyService {

	public String getAPIDynamicRelatedPartUploadJTTP(String companyName,int degreesLevel,String dataVersion) throws Exception;

}
