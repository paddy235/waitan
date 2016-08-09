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
