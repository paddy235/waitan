package com.bbd.wtyh.mapper;

import java.util.List;

import com.bbd.wtyh.entity.Area;


/**
* @ClassName: AreaMapper
* @Description: 区域mapper
* @author Ian.Su
* @date 2016年8月5日 下午1:52:45
*/
public interface AreaMapper{
	
    
    /**
    *
    * @Title: 获取所有的区域数据
    * @Description: TODO
    * @return List<Area>    返回类型
    * @throws
    * @author Ian.Su
    * @date 2016年8月5日 下午1:51:00 
    */
    List<Area> list();
}
