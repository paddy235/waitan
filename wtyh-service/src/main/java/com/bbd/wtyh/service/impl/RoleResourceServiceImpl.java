package com.bbd.wtyh.service.impl;

import com.bbd.higgs.utils.DateUtils;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.mapper.RoleResourceMapper;
import com.bbd.wtyh.service.RoleResourceService;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2017/3/1 0001.
 */
@Service
public class RoleResourceServiceImpl implements RoleResourceService {
    @Autowired
    private RoleResourceMapper roleResourceMapper;
    @Override
    public Set<String> queryResourceCodeByLoginName(String userName) {
        Set set=new HashSet();
        List list = roleResourceMapper.queryResourceCodeByLoginName(userName);
        set.addAll(list);
        return set;
    }

    @Override
    public Set<String> queryResourceCodeByUserId(Integer userId) {
        Set set=new HashSet();
        List list = roleResourceMapper.queryResourceCodeByUserId(userId);
        set.addAll(list);
        return set;
    }

    @Override
    public RoleDo addRoleBase(String roleName, String roleDes, String roleType, String loginName) {

        RoleDo roleDo=new RoleDo();
        try{
            roleDo.setName(roleName);
            roleDo.setDescription(roleDes);
            roleDo.setType(roleType);
            roleDo.setCreateBy(loginName);
            roleDo.setCreateDate(DateUtils.parserDate(DateUtils.format(new Date(),"yyyyMMddHHmmss"),"yyyyMMddHHmmss"));

            roleResourceMapper.addRoleBase(roleDo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return roleDo;
    }

    /*
     *新建用户的角色基本信息、角色-权限关系、角色-用户关系
     */
    @Override
    public void addUserRoleResource(UserInfoTableDo userInfoTableDo,String resourceSet,String loginName) {
        //如果 用户ID为空 或者权限为空，则不创建
        Integer userId=userInfoTableDo.getId();
        if(null==userId || StringUtils.isEmpty(resourceSet)){
            return ;
        }
        //新增角色基本信息
        RoleDo roleDo=this.addRoleBase(null, null, null,loginName);

        //新增角色用户关系
        UserRoleDo userRoleDo=new UserRoleDo();
        userRoleDo.setUserId(userId);
        userRoleDo.setRoleId(roleDo.getId());
        userRoleDo.setCreateBy(loginName);
        userRoleDo.setCreateDate(DateUtils.parserDate(DateUtils.format(new Date(),"yyyyMMddHHmmss"),"yyyyMMddHHmmss"));
        roleResourceMapper.addUserRoleRelation(userRoleDo);

        //新增角色权限关系
        addRoleResourceRelation(roleDo.getId(), resourceSet, loginName);

    }
    /*
     *修改 某用户的角色对应的权限-限删除角色-权限关系，再建立新的角色-权限关系
     */
    @Override
    public void updateUserRoleResource(UserInfoTableDo userInfoTableDo,String resourceSet,String loginName) {
        //与陈功杰约定，如果resourceSet==null,则不更新，若为""，则需要删除已有的权限关系
        if(null==resourceSet || null==userInfoTableDo.getId()){
            return;
        }
        Integer userId=userInfoTableDo.getId();
        List<UserRoleDo> list=roleResourceMapper.getUserRoleByUser(userId);
        for(UserRoleDo userRoleDo:list){
            //删除角色权限关系
            roleResourceMapper.deleteRoleResourceRelation(userRoleDo.getRoleId());
            //新增角色权限关系
            addRoleResourceRelation(userRoleDo.getRoleId(), resourceSet, loginName);

        }
    }

    /*
     *删除某用户的 角色-权限关系、角色基本信息、用户-角色关系
     */
    @Override
    public void deleteUserRoleResource(Integer userId, String loginName) {
        //如果 用户ID为空 则不执行
        if(userId==null){
            return ;
        }
        List<UserRoleDo> list=roleResourceMapper.getUserRoleByUser(userId);
        for(UserRoleDo userRoleDo:list){
            //删除角色权限关系
            roleResourceMapper.deleteRoleResourceRelation(userRoleDo.getRoleId());
            //删除角色基本信息
            roleResourceMapper.deleteRoleBase(userRoleDo.getRoleId());

        }
        //删除角色用户关系
        roleResourceMapper.deleteUserRoleRelation(userId);
    }

    /*
     *新增角色权限关系
     */
    @Override
    public void addRoleResourceRelation(Integer roleId, String resourceSet, String loginName) {
        if(null==roleId || StringUtils.isEmpty(resourceSet)){
            return ;
        }
        //新增角色权限关系
        String [] resourceArr=resourceSet.split(",");
        RoleResourceDo roleResourceDo=null;
        ResourceDo resourceDo=null;
        Date currentDate=DateUtils.parserDate(DateUtils.format(new Date(),"yyyyMMddHHmmss"),"yyyyMMddHHmmss");
        for(int i=0;i<resourceArr.length;i++){
            resourceDo=roleResourceMapper.getResourceByCode(resourceArr[i]);
            if(resourceDo==null){
                continue;
            }
            roleResourceDo=new RoleResourceDo();
            roleResourceDo.setRoleId(roleId);
            roleResourceDo.setResourceId(resourceDo.getId());
            roleResourceDo.setCreateBy(loginName);
            roleResourceDo.setCreateDate(currentDate);
            roleResourceMapper.addRoleResourceRelation(roleResourceDo);
        }
    }


}

