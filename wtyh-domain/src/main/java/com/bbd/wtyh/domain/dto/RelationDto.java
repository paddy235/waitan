package com.bbd.wtyh.domain.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bbd.wtyh.domain.enums.NodeLabel;
import com.bbd.wtyh.domain.enums.RelationType;
import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * 一条关联方关系链。
 * 能表示一个公司是怎么和目标公司关联起来的。
 *
 * dimensions有四个obj，依次：
 * dimensions[0]-公司nodes array obj(nodeobj[0]为查询主体)
 * dimensions[1]-结果主体到主体公司的度数
 * dimensions[2]-依次为nodeobj(公司主体间关系，第二个obj主体为上一个obj的关系主体),obj[2]为对此关系的描述
 * dimensions[3]-关联主体的labels
 * Created by zhaoyuan
 * 2016/5/23.
 */
public class RelationDto extends ArrayList<Object>{

    /**
     * 转成数据平台的数据格式 需要用到的字段
     * 第一列 投资方
     * 第二列 被投资方
     * 第三列 关联关系   完整的关系中文描述，如果有多个关系都会展示出来
     * 第四列 投资方关联度数
     * 第五列 被投资方关联度数
     * 第六列 关系类型（1代表股东0代表高管）  这一列只表示优先级最高的关系,股东最优先， 其它一样
     * 第七列 是否是自然人（1代表自然人0代表企业）
     * @return
     */
    private String startNode;
    private String endNode;

    //TreeSet是有序的集合， 而且是在插入时，就做好排序的。是升序排列，什么调用元素的compareTo方法来比较大小
    private TreeSet<String> relationDesc;
    private int startLevel;
    private int endLevel;
    private RelationType relationType;

    //投资方的Node类型， 不是主节点的
    private NodeLabel nodeType;

    private String mainNode;

    private int mainNodeLevel;

    /**
     * 表示该关系是不是查询主体
     */
    private boolean queryTarget = false;

    /**
     * 表示是否已经计算为数据平台格式的值
     */
    protected boolean converted = false;

    /**
     * 转化为数据平台格式的值。
     * 因为第一对象是接口返回值， 只有方法作用域的生命周期。
     * 所以此处不考虑同步
     */
    private void convert(){
        if(converted) return;
        JSONArray nodes = (JSONArray) get(0);
        mainNode = nodes.getString(nodes.size() - 1);
        String target = nodes.getString(0);


        //TreeSet是有序的集合， 而且是在插入时，就做好排序的。是升序排列，什么调用元素的compareTo方法来比较大小
        relationDesc = new TreeSet<>();

        JSONArray levels = (JSONArray) get(1);

        mainNodeLevel = (int) levels.get(1);

        //处理数据中自关联的错误数据
        if(mainNode.equals(target)){
            mainNodeLevel = 0;
        }
        int relationNodeLevel = (int) levels.get(0);
        if(mainNodeLevel == 0){
            queryTarget = true;
            return;
        }

        JSONArray nodeLabels = (JSONArray) get(3);
        //被投资方默认是公司。所以当主节点是startNode时， 本关系的nodeType才是
        nodeType = nodeLabels.getObject(nodeLabels.size() - 1, NodeLabel.class);

        JSONArray relations = (JSONArray) get(2);
        startNode = relations.getString(0);
        relationType = RelationType.valueOf(relations.getString(1).toUpperCase());
        String relationDescription = relations.getString(2);
        if(StringUtils.isEmpty(relationDescription)){
            relationDescription = relationType.getRelationDesc();
        }
        String relationNode = nodes.getString(nodes.size() - 2);
        if(mainNode.equals(startNode)){
            endNode = relationNode;
            startLevel = mainNodeLevel;
            endLevel = relationNodeLevel;
        }else{
            endNode = mainNode;
            startLevel = relationNodeLevel;
            endLevel = mainNodeLevel;
        }
        relationDesc.add(relationDescription);
        converted = true;
    }

    /**
     * 转成数据平台的数据格式
     * 第一列 投资方
     * 第二列 被投资方
     * 第三列 关联关系
     * 第四列 投资方关联度数
     * 第五列 被投资方关联度数
     * 第六列 关系类型（1代表股东0代表高管）
     * 第七列 是否是自然人（1代表自然人0代表企业）
     * @return
     */
    @Override
    public String toString(){
        convert();
        String[] oldFormatRelation = new String[]{
                String.valueOf(startNode),
                String.valueOf(endNode),
                Joiner.on("、").skipNulls().join(relationDesc),
                String.valueOf(startLevel),
                String.valueOf(endLevel),
                String.valueOf(relationType.getRelation()),
                String.valueOf(nodeType.ordinal())
        };
        return JSON.toJSONString(oldFormatRelation);
    }

    public String getStartNode() {
        convert();
        return startNode;
    }

    public String getEndNode() {
        convert();
        return endNode;
    }

    public Set<String> getRelationDesc() {
        convert();
        return relationDesc;
    }

    public int getStartLevel() {
        convert();
        return startLevel;
    }

    public int getEndLevel() {
        convert();
        return endLevel;
    }

    public NodeLabel getNodeType() {
        convert();
        return nodeType;
    }

    public RelationType getRelationType() {
        convert();
        return relationType;
    }

    public String getMainNode() {
        convert();
        return mainNode;
    }

    public void setMainNode(String mainNode) {
        this.mainNode = mainNode;
    }

    public int getMainNodeLevel() {
        convert();
        return mainNodeLevel;
    }

    public void setMainNodeLevel(int mainNodeLevel) {
        this.mainNodeLevel = mainNodeLevel;
    }

    public boolean isQueryTarget() {
        convert();
        return queryTarget;
    }

    public void setStartNode(String startNode) {
        this.startNode = startNode;
    }

    public void setEndNode(String endNode) {
        this.endNode = endNode;
    }

    public void setRelationDesc(TreeSet<String> relationDesc) {
        this.relationDesc = relationDesc;
    }

    public void setStartLevel(int startLevel) {
        this.startLevel = startLevel;
    }

    public void setEndLevel(int endLevel) {
        this.endLevel = endLevel;
    }

    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }

    public void setNodeType(NodeLabel nodeType) {
        this.nodeType = nodeType;
    }

}
