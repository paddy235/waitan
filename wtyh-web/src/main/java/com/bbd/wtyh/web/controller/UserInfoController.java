package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.exception.BusinessException;
import com.bbd.wtyh.service.UserInfoService;
import com.bbd.wtyh.service.UserService;
import com.bbd.wtyh.util.CipherUtils;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

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
    public Object updateInfo(@RequestParam Integer id,@RequestParam String mobile,@RequestParam String email,HttpSession session)throws Exception{

         UserInfoTableDo user = new UserInfoTableDo();
         user.setId(id);
         user.setMobile(mobile);
         user.setEmail(email);
         user.setUpdateBy((String)session.getAttribute(Constants.SESSION.loginName));

         userInfoService.updateUserInfo(user,null);

         return ResponseBean.successResponse("用户信息修改成功。");
    }

    @RequestMapping("/update/password")
    public Object updatePassword(@RequestParam Integer id,@RequestParam String oldPassword,@RequestParam String newPassword,HttpSession session)throws Exception{

        UserInfoTableDo user = new UserInfoTableDo();
        user.setId(id);
        user.setForePwd(newPassword);
        //user.setOldPwd(oldPassword);
        user.setUpdateBy((String)session.getAttribute(Constants.SESSION.loginName));
        if( ! userInfoService.compareUserNameMatchPassword( user.getUpdateBy(), oldPassword, "fore_pwd" ) ) {
            throw new BusinessException("原密码验证失败");
        }
        userInfoService.updateUserInfo(user,null);
        // TODO：此处最好添加使修改后的密码在缓存中立即生效的代码
        return ResponseBean.successResponse("用户密码修改成功。");
    }

}
