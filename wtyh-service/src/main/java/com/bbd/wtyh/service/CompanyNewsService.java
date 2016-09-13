package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.AreaDO;
import com.bbd.wtyh.domain.NvDO;
import com.bbd.wtyh.domain.vo.NewsVO;

import java.util.List;

/**
* 公司舆情接口
* @author tracy zhou
* @since  2016.8.12
*/
public interface CompanyNewsService {

	/**
	 * 获取某个公司的舆情,查询不到时，获取所有公司的舆情
	 * @param company
	 * @return String
     */
	public String getCompanyNews(String company);

	/**
	 * 获取所有的公司的舆情
	 * @return String
     */
	public String getCompanyNews();


	/**
	 * 获取某个公司的舆情,查询不到时不做其他查询
	 * @param company
	 * @return String
	 */
	public String findCompanyNews(String company);



	/**
	 * 根据关键字取舆情
	 * @param key   查询字段
	 * @param size 数据量
	 * @return NewsVO
	 */
	public NewsVO findNews(String key, Integer size);



	/**
	 * 取 “上海金融办舆情”， “未央网金融舆情”， “中国金融新闻网” 的舆情
	 * @return NewsVO
	 */
	public NewsVO findNews();


}
