package com.bbd.bgo.web.controller;

import com.bbd.higgs.utils.StringUtils;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by Administrator on 2017/5/8 0008.
 */
@Controller
@RequestMapping("/redisManager")
public class RedisController {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@RequestMapping("/flushAll")
	@ResponseBody
	public Object flushAll() {
		try {
			Set<String> keys = redisTemplate.keys("*");
			redisTemplate.delete(keys);
		} catch (Exception e) {
			return ResponseBean.errorResponse(e);
		}
		return ResponseBean.successResponse("redis缓存情理成功!");
	}

    @RequestMapping("/deleteByKey")
    @ResponseBody
    public Object deleteByKey(@RequestParam String key) {
        try {
            if(StringUtils.isNullOrEmpty(key)){
                return ResponseBean.errorResponse("请情理正确的key");
            }
            redisTemplate.delete(key);
        } catch (Exception e) {
            return ResponseBean.errorResponse(e);
        }
        return ResponseBean.successResponse("redis缓存情理成功!");
    }

}
