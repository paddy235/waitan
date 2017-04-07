package com.bbd.bgo.auth;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;

/**
 * Created by cgj on 2017/4/6.
 */
public class TimeOutSessionListener extends SessionListenerAdapter {
    @Override
    public void onExpiration(Session session) {//会话过期时触发
        System.out.println("会话过期：" + session.getId());
        System.out.println("会话过期1：" + session);

    }

}
