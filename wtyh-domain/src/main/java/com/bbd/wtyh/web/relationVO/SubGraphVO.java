package com.bbd.wtyh.web.relationVO;

import java.io.Serializable;
import java.util.Collection;

/**
 * description:
 * author:liaohao
 * date:2016/12/26 0026 14:58.
 */
public class SubGraphVO implements Serializable {
    private Collection<NodeVO> nodes;
    private Collection<LinkVO> links;

    public Collection<NodeVO> getNodes() {
        return nodes;
    }

    public void setNodes(Collection<NodeVO> nodes) {
        this.nodes = nodes;
    }

    public Collection<LinkVO> getLinks() {
        return links;
    }

    public void setLinks(Collection<LinkVO> links) {
        this.links = links;
    }
}
