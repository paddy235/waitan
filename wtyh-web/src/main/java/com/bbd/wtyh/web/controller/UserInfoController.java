package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.service.UserInfoService;
import com.bbd.wtyh.service.UserService;
import com.bbd.wtyh.util.CipherUtils;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 用户信息维护
 * @author Yin Su
 * @since  2016/8/20
 */
@RestController
@RequestMapping("/user/info")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/query")
    public Object query(HttpSession session){

        String userName = (String)session.getAttribute(Constants.SESSION.loginName);

        if(StringUtils.isEmpty(userName)){
            return ResponseBean.errorResponse("请先登录。");
        }

        UserInfoTableDo user = userService.queryUserInfo(userName);
        user.setMobile(CipherUtils.decrypt(user.getMobile()) );
        user.setRealName(CipherUtils.decrypt(user.getRealName()));
        user.setForePwd(null);
        user.setBackPwd(null);


        return ResponseBean.successResponse(user);
    }



    @RequestMapping("/update")
    public Object updateInfo(@RequestParam Integer id,@RequestParam String mobile,@RequestParam String email)throws Exception{
        UserInfoTableDo user = new UserInfoTableDo();
         user.setId(id);
         user.setMobile(mobile);
         user.setEmail(email);
         userInfoService.updateUserInfo(user,null);

         return ResponseBean.successResponse("用户信息修改成功。");
    }

    @RequestMapping("/update/password")
    public Object updateInfo(@RequestParam Integer id,@RequestParam String password)throws Exception{
        UserInfoTableDo user = new UserInfoTableDo();
        user.setId(id);
        user.setForePwd(password);
        userInfoService.updateUserInfo(user,null);

        return ResponseBean.successResponse("用户密码修改成功。");
    }

}
