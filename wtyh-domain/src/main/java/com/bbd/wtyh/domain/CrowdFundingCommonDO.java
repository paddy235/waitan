package com.bbd.wtyh.domain;

/**
 * Created by lixudong on 2017/7/19.
 */
public class CrowdFundingCommonDO extends BaseDO{

    private String reward;//奖励众筹
    private String nonPulicEquityFinancing;//非公开股权融资
    private String publicWelfare;
    private String blend;
    private String type;

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getNonPulicEquityFinancing() {
        return nonPulicEquityFinancing;
    }

    public void setNonPulicEquityFinancing(String nonPulicEquityFinancing) {
        this.nonPulicEquityFinancing = nonPulicEquityFinancing;
    }

    public String getPublicWelfare() {
        return publicWelfare;
    }

    public void setPublicWelfare(String publicWelfare) {
        this.publicWelfare = publicWelfare;
    }

    public String getBlend() {
        return blend;
    }

    public void setBlend(String blend) {
        this.blend = blend;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CrowdFundingCommonDO{" +
                "reward='" + reward + '\'' +
                ", nonPulicEquityFinancing='" + nonPulicEquityFinancing + '\'' +
                ", publicWelfare='" + publicWelfare + '\'' +
                ", blend='" + blend + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
