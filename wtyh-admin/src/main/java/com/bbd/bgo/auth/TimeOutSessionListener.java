package com.bbd.bgo.auth;

import com.bbd.higgs.utils.StringUtils;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.UserLogRecord;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;


/**
 * Created by cgj on 2017/4/6.
 */
public class TimeOutSessionListener extends SessionListenerAdapter {
    @Override
    public void onExpiration(Session session) {
        //会话过期时触发
        String name=(String)session.getAttribute("loginName");
        if(!StringUtils.isNullOrEmpty(name)){
            UserLogRecord.recordForShiroSession("用户登出(会话过期)", Operation.Type.logout, Operation.Page.blank, Operation.System.back,  session);
        }
    }

}
