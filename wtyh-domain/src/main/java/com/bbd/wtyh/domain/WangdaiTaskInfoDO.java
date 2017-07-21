package com.bbd.wtyh.domain;

/**
 * 网贷 众筹数据落地失败 记录
 * Created by lixudong on 2017/7/20.
 */
public class WangdaiTaskInfoDO extends TaskFailInfoDO{

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "WangdaiTaskInfoDO{" +
                "description='" + description + '\'' +
                '}';
    }
}
