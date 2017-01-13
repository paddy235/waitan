package com.bbd.wtyh.web.relationVO;

import com.bbd.wellspring.common.service.facade.relation.NodeVoSymbolEnum;
import com.bbd.wellspring.common.service.facade.relation.NodeVoTypeEnum;

import java.io.Serializable;
import java.util.Set;

/**
 * description:
 * author:liaohao
 * date:2016/12/26 0026 14:54.
 */
public class NodeVO implements Serializable {

    private String              addflag = "false";
    private String              name;
    private int                 category;
    private Set<NodeVoTypeEnum> nodeVoTypes;
    private String              cname;
    private NodeVoSymbolEnum    symbol;
    private String              color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddflag() {
        return addflag;
    }

    public void setAddflag(String addflag) {
        this.addflag = addflag;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Set<NodeVoTypeEnum> getNodeVoTypes() {
        return nodeVoTypes;
    }

    public void setNodeVoTypes(Set<NodeVoTypeEnum> nodeVoTypes) {
        this.nodeVoTypes = nodeVoTypes;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public NodeVoSymbolEnum getSymbol() {
        return symbol;
    }

    public void setSymbol(NodeVoSymbolEnum symbol) {
        this.symbol = symbol;
    }
}
