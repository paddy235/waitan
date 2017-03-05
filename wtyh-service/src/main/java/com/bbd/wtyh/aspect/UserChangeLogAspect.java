package com.bbd.wtyh.aspect;

import com.bbd.wtyh.domain.ResourceDo;
import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.mapper.RoleResourceMapper;
import com.bbd.wtyh.mapper.UserInfoMapper;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.ArrayUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.*;
import java.util.List;

/**
 * Created by Yin Su on 2017/3/5.
 */
@Component
@Aspect
public class UserChangeLogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserChangeLogAspect.class);

    @Autowired
    private RoleResourceMapper resourceMapper;

    @Autowired
    private UserInfoMapper userInfo;

    @Pointcut("execution(* com.bbd.wtyh.service.impl.UserInfoServiceImpl.createUser(..))")
    private void createUser(){}


    public void createUserLog(UserInfoTableDo uitd,String resourceSet,String msg){

        StringBuilder resource = new StringBuilder("");
        if (!StringUtils.isEmpty(resourceSet)){
            String [] rs = resourceSet.split(",");
            for (String r:rs) {
                ResourceDo rd = resourceMapper.getResourceByCode(r);
                if (rd != null)
                    resource.append("{").append(r).append("=").append(rd.getName()).append("}");
            }
        }
        LOGGER.info("{}信息为：{}，包括权限：[{}]",msg,uitd.toString(),resource.toString());
    }


    @AfterThrowing("createUser() && args(uitd,resourceSet)")
    public void doCreateUserAfterThrow(UserInfoTableDo uitd,String resourceSet){
        createUserLog( uitd, resourceSet ,"创建用户失败，");
    }

    @AfterReturning("createUser() && args(uitd,resourceSet)")
    public void doCreateUserAfter(UserInfoTableDo uitd,String resourceSet){
        createUserLog( uitd, resourceSet ,"创建用户成功，");
    }







    @Pointcut("execution(* com.bbd.wtyh.service.impl.UserInfoServiceImpl.updateUserInfo(..))")
    private void updateUserInfo(){}


    @AfterThrowing("updateUserInfo() && args(uitd,resourceSet)")
    public void doUpdateUserInfoAfterThrow(UserInfoTableDo uitd,String resourceSet){
        createUserLog( uitd, resourceSet ,"修改用户失败，");
    }

    @Before("updateUserInfo() && args(uitd,resourceSet)")
    public void doUpdateUserInfoBefore(UserInfoTableDo uitd,String resourceSet){
        if(uitd == null || uitd.getId() == null){
            return;
        }
        UserInfoTableDo bean = userInfo.selectUserAllInfoById(uitd.getId());
        List<String> rs = resourceMapper.queryResourceCodeByLoginName(bean.getLoginName());

        createUserLog( bean , StringUtils.join(rs,",") ,"修改用户信息，原");
    }


    @After("updateUserInfo() && args(uitd,resourceSet)")
    public void doUpdateUserInfoAfter(UserInfoTableDo uitd,String resourceSet){
        UserInfoTableDo bean = userInfo.selectUserAllInfoById(uitd.getId());
        createUserLog( bean, resourceSet ,"修改用户成功，");
    }









}
