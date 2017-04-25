package com.bbd.shanghai.credit.service;

/**
 * 上海市信息中心-查询法人指定信用信息接口
 *
 * @author Created by LiYao on 2017-04-24 14:33.
 */
public interface XyAppQueryService {

	String queryFrKxHonest(String dwmc, String zzjgdm, String tydm, String username, String password, String cxyt, String uname);
}
