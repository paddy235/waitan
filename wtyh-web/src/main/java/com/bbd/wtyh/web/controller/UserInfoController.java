package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.web.ResponseBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息维护
 * @author Yin Su
 * @since  2016/8/20
 */
@RestController
@RequestMapping("/user/info")
public class UserInfoController {


    @RequestMapping("query")
    public Object query(){


        return ResponseBean.successResponse("");
    }

}
