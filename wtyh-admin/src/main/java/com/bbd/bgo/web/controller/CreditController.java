package com.bbd.bgo.web.controller;

import com.bbd.data.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by suyin on 2016/8/27.
 */
@Controller
@RequestMapping("/credit")
public class CreditController {

    @Autowired
    private DataService dataService;

    @RequestMapping("/info")
    public String info(String companyName, HttpServletRequest request){

        if(StringUtils.hasText(companyName)){
            request.setAttribute("list",dataService.getCredit(companyName));
        }

        return "geo/credit";
    }

}
