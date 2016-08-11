package com.bbd.wtyh.web;

import com.bbd.wtyh.util.relation.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by win7 on 2016/8/10.
 */
public class PathBean {
    private List<String> keyList=new ArrayList<String>();
    private List<String> valueList=new ArrayList<String>();
    private List<String> postTypeList=new ArrayList<String>();//职务
    private Map<String,Integer> removalDuplicateMap = new HashMap<String,Integer>(); //key+"@"+value不能重复，用于去重,此map的value为investType（投资性质 1 ：投次人 0 ：高管）


    /**
     * 添加元素
     * @param key
     * @param value
     */
    public void add(String key,String value,Integer investType,String postType){
        String string=key+"@"+value;
        if(!removalDuplicateMap.keySet().contains(string)){
            keyList.add(key);
            valueList.add(value);
            postTypeList.add(postType);
            removalDuplicateMap.put(string, investType);
        }
    }
    /**
     * 获取key数组
     * @return
     */
    public List<String> getKeys(){
        return keyList;
    }
    /**
     * 获取value数组
     * @return
     */
    public List<String> getValues(){
        return valueList;
    }
    /**
     * 获取paramList数组
     * @return
     */
    public List<String> getPostTypeList(){
        return postTypeList;
    }

    /**
     * 获取键等key的个数
     * @param key
     * @return
     */
    public int getEqualsKey(String key){
        int count=0;
        if(!Utils.isNullForString(key)){
            for(String currentKey:keyList){
                if(currentKey.equals(key)){
                    count++;
                }
            }
        }
        return count;
    }
    /**
     * 获取值等value的个数
     * @param value
     * @return
     */
    public int getEqualsValue(String value){
        int count=0;
        if(!Utils.isNullForString(value)){
            for(String currentKey:valueList){
                if(currentKey.equals(value)){
                    count++;
                }
            }
        }
        return count;
    }
    /**
     * 通过key获取value
     * @param key
     * @return
     */
    public List<String> getValuesByKey(String key){
        List<String> list = new ArrayList<String>();
        if(!Utils.isNullForString(key)){
            int len=keyList.size();
            for(int i=0;i<len;i++){
                String currentKey = keyList.get(i);
                if(key.equals(currentKey)){
                    list.add(valueList.get(i));
                }
            }
        }
        return list;
    }

    /**
     *
     * @param value
     * @return
     */
    public List<String> getKeyByValue(String value){
        List<String> list = new ArrayList<String>();
        if(!Utils.isNullForString(value)){
            int len=valueList.size();
            for(int i=0;i<len;i++){
                String currentValue = valueList.get(i);
                if(value.equals(currentValue)){
                    list.add(keyList.get(i));
                }
            }
        }
        return list;
    }
    /**
     * 查找，将查打到的以PathObject对象返回
     * @param key
     * @return
     */
    public PathBean getPathObjectByKey(String key){
        PathBean object= new PathBean();
        if(!Utils.isNullForString(key)){
            List<String> oList = getKeys();
            List<String> oValueList=getValues();
            List<String> oParamList= getPostTypeList();
            int len=oList.size();
            for(int i=0;i<len;i++){
                String k=oList.get(i);
                if(k.equals(key)){
                    String value=oValueList.get(i);
                    String postType=oParamList.get(i);
                    String string=key+"@"+value;
                    object.add(k, value,removalDuplicateMap.get(string), postType);
                }
            }
        }
        return object;
    }

    /**
     * 获取投资性质
     * @param keyAndvalue
     * @return
     */
    public Integer getInvestType(String keyAndvalue){
        return removalDuplicateMap.get(keyAndvalue);
    }


}
