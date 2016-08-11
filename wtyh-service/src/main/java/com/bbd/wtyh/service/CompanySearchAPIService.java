package com.bbd.wtyh.service;


/**
* 
* @author Ian.Su
* @since 2016年8月11日 上午10:38:01
*/

public interface CompanySearchAPIService {
	
	/**
	 * 查询企业通过第三方接口
	 * 
	 * @param params
	 * @return
	 * @throws Exception 
	 */
	public String searchCompanyByKeyword(String keyword) throws Exception;

}
