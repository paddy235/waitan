package com.bbd.wtyh.dao.impl;

import com.alibaba.fastjson.JSON;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.dao.HologramQueryDao;
import com.bbd.wtyh.domain.bbdAPI.BaiDuYuQingDo;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${api.baidu.news.url}")
    private String url;

    @Value("${api.baidu.news.ak}")
    private String ak;

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
     * 企业概要信息
     *
     * @return
     */
    @Override
    public BaseDataDO outlineMsg(String companyName) {
        String coreDataDealURL = String.format("http://dataom.api.bbdservice.com/api/bbd_qyxx/?company=攀枝花市交通旅游客运有限责任公司&ak=0516d1c0db8d5cd1933cc2442c9f8d40");
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(coreDataDealURL, new HttpCallback<BaseDataDO>() {
                @Override
                public boolean valid() {
                    return true;
                }
                @Override
                public BaseDataDO parse(String result) {
                    Gson gson = new Gson();
                    return gson.fromJson(result, BaseDataDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 公司新闻舆情
     *
     * @return
     */
    @Override
    public BaiDuYuQingDo newsConsensus(String company) {
        String api = url + "?company=" + company + "&ak=" + ak;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(api, new HttpCallback<BaiDuYuQingDo>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public BaiDuYuQingDo parse(String result) {
                    return JSON.parseObject(result, BaiDuYuQingDo.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 企业信息详情-工商信息
     *
     * @return
     */
    @Override
    public Map<String, Object> businessInfo() {
        Map<String, Object> data = new HashMap<>();
        data.put("法定代表人", "王伟");
        data.put("注册资本", "王伟");
        data.put("状态", "王伟");
        data.put("注册时间", "王伟");
        data.put("行业", "王伟");
        data.put("工商注册号", "王伟");
        data.put("企业类型", "王伟");
        data.put("组织机构代码", "王伟");
        data.put("营业期限", "王伟");
        data.put("登记机关", "王伟");
        data.put("核准日期", "王伟");
        data.put("统一信用代码", "王伟");
        data.put("经营范围", "王伟");
        return data;
    }

    /**
     * 企业信息详情-股东高管
     *
     * @return
     */
    @Override
    public Map<String, Object> shareholdersSenior() {
        Map<String, Object> data = new HashMap<>();
        data.put("股东", "王伟");
        data.put("股东类型", "建工单");
        data.put("国务院", "王伟");
        data.put("机关法人", "王伟");
        data.put("股东", "王伟");
        return data;
    }

    /**
     * 企业信息详情-诉讼记录
     *
     * @return
     */
    @Override
    public Map<String, Object> lawsuitRecord() {
        Map<String, Object> data = new HashMap<>();
        data.put("诉讼信息", "");
        return data;
    }

    /**
     * 企业信息详情-招聘信息
     *
     * @return
     */
    public Map<String, Object> recruitMsg() {
        Map<String, Object> data = new HashMap<>();
        data.put("招聘信息", "招聘嘻嘻");
        return data;
    }


}
