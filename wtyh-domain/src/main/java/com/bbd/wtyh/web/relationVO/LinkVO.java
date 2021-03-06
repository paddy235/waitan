package com.bbd.wtyh.web.relationVO;

import com.bbd.wellspring.common.service.facade.relation.LineTypeEnum;

import java.io.Serializable;

/**
 * description:
 * author:liaohao
 * date:2016/12/26 0026 14:55.
 */
public class LinkVO implements Serializable {

    private String       addflag = "false";
    private String       guanlian;
    private LineTypeEnum line;
    private String       target;
    private String       source;
    private String       relatedParyName;

    public String getAddflag() {
        return addflag;
    }

    public void setAddflag(String addflag) {
        this.addflag = addflag;
    }

    public String getGuanlian() {
        return guanlian;
    }

    public void setGuanlian(String guanlian) {
        this.guanlian = guanlian;
    }

    public LineTypeEnum getLine() {
        return line;
    }

    public void setLine(LineTypeEnum line) {
        this.line = line;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRelatedParyName() {
        return relatedParyName;
    }

    public void setRelatedParyName(String relatedParyName) {
        this.relatedParyName = relatedParyName;
    }
}
