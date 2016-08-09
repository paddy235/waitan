package com.bbd.wtyh.dao.impl;

import com.bbd.wtyh.dao.HologramQueryDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 企业全息信息查询平台dao层实现类
 *
 * @author wangchenge
 * @since 2016.08.09
 */
@Repository("hologramQueryDao")
public class HologramQueryDaoImpl implements HologramQueryDao {


    /**
     * 信息查询平台搜索
     *
     * @return
     */
    @Override
    public Map<String, Object> search() {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("含注册号", "876156451231xxx");
        data.put("类型", "有限责任公司");
        data.put("法定代表人", "黄光裕");
        data.put("注册资本", "4万元");
        data.put("成立日期", "2016年08月09日");
        data.put("注册地址", "上海市浦东新区···");
        data.put("企业总数", "101");
        data.put("页数", "101");
        data.put("每页几条", "10");
        return data;
    }

    /**
     * 信息查询平台导航栏
     *
     * @return
     */
    @Override
    public Map<String, Object> guidance() {
        Map<String, Object> data = new HashMap<>();
        data.put("企业名称", "上海明城投资有限公司");
        data.put("登记状态", "存续");
        return data;
    }


    /**
     * 公司新闻舆情
     *
     * @return
     */
    @Override
    public Map<String, Object> newsConsensus() {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("舆情信息序号", "1");
        data.put("标题", "发展融资租担保行业打造高效监管体系");
        data.put("缩略内容", "昨日下午，发展融资租担保行业打造高效监管体系···");
        data.put("信息来源网站", "光明网");
        data.put("更新日期", "2016年6月27日");
        return data;
    }
}
