package com.bbd.wtyh.domain.dto;


import java.util.*;

/**
 * KunLun返回的关联方数据主体结构
 * Created by zhaoyuan
 * 2016/5/23.
 */
public class RelationData {

    private int status;

    private String msg;

    private List<Relation> data;

    /**
     * data是否已经清洗
     */
    private boolean isEtl = false;

    /**
     * 数据清洗
     * 去重、整合关系
     */
    private void etl(){
        if (isEtl) return;

        if (data != null) {
            Iterator<Relation> iterator = data.iterator();
            Map<String,Relation> uniqueRelations = new LinkedHashMap<>();
            Map<String,Integer> nodeLevelMap = new HashMap<>();
            while (iterator.hasNext()){
                Relation temp = iterator.next();
                if(nodeLevelMap.containsKey(temp.getMainNode())){
                    nodeLevelMap.put(temp.getMainNode(),Math.min(temp.getMainNodeLevel(),nodeLevelMap.get(temp.getMainNode())));
                }else{
                    nodeLevelMap.put(temp.getMainNode(),temp.getMainNodeLevel());
                }
            }

            iterator = data.iterator();
            while (iterator.hasNext()){
                Relation temp = iterator.next();
                if(temp.isQueryTarget()) continue;

                String key = temp.getStartNode() + "->" + temp.getEndNode();
                if (!uniqueRelations.containsKey(key)) {
                    uniqueRelations.put(key,temp);
                    continue;
                }

                Relation existRelation = uniqueRelations.get(key);
                integrateRelation(existRelation,temp,nodeLevelMap);
            }

            data = new LinkedList<>(uniqueRelations.values());
        }
//        Collections.sort(data, new Comparator<Relation>() {
//            @Override
//            public int compare(Relation o1, Relation o2) {
//                return Math.min(o1.getStartLevel(),o1.getEndLevel()) - Math.min(o2.getEndLevel(),o2.getStartLevel());
//            }
//        });
        isEtl = true;

    }

    /**
     * 整合关系
     * @param exist
     * @param that
     */
    private void integrateRelation(Relation exist,Relation that,Map<String,Integer> nodeLevelMap){
        Integer startLevel = nodeLevelMap.get(exist.getStartNode());
        startLevel = startLevel == null ? 0 : startLevel;
        exist.setStartLevel(startLevel);
        Integer endLevel = nodeLevelMap.get(exist.getEndNode());
        endLevel = endLevel == null ? 0 : endLevel;
        exist.setEndLevel(endLevel);
        RelationType existRelationType = exist.getRelationType();
        RelationType thatRelationType = that.getRelationType();
        exist.setRelationType(existRelationType.compareTo(thatRelationType) < 0 ? existRelationType : thatRelationType);
        exist.getRelationDesc().addAll(that.getRelationDesc());
    }


    public List<Relation> getData() {
        return data;
    }

    public void setData(List<Relation> data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        etl();
        return data == null ? "[]" : data.toString();
    }
}
