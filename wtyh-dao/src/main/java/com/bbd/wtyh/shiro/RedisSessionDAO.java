package com.bbd.wtyh.shiro;

import com.bbd.wtyh.core.utils.redis.RedisUtil;
import com.bbd.wtyh.util.IPUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Collection;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-09-08 16:19.
 */
@SuppressWarnings("unused")
public class RedisSessionDAO extends AbstractSessionDAO {

    private static Logger logger = LoggerFactory.getLogger(RedisSessionDAO.class);

    private static volatile String sessionKey = null;
    private static volatile String loginNameKey = null;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = super.generateSessionId(session);
        super.assignSessionId(session, sessionId);
        setSessionToRedis((SimpleSession) session);
        return sessionId;
    }

    private void setSessionToRedis(SimpleSession session) {
        long timeoutSeconds = 15;

        Object objName = session.getAttribute(com.bbd.wtyh.common.Constants.SESSION.loginName);
        String loginName = objName == null ? "" : objName.toString();
        if (StringUtils.isNotBlank(loginName)) {
            timeoutSeconds = session.getTimeout() / 1000;
            RedisUtil.hset(loginNameKey, loginName, session.getId().toString());
        }
        String redisKey = sessionKey + session.getId();
        RedisUtil.setObject(redisKey, session);
        RedisUtil.expire(redisKey, (int) timeoutSeconds);
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        String redisKey = sessionKey + sessionId;
        return RedisUtil.getObject(redisKey, SimpleSession.class);
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        setSessionToRedis((SimpleSession) session);
    }

    @Override
    public void delete(Session session) {
        String redisKey = sessionKey + session.getId();
        RedisUtil.del(redisKey);
    }

    @Override
    public Collection<Session> getActiveSessions() {
        return null;
    }

    public static void forcedLogout(HttpServletRequest request, String userName) {
        String haveLoginSessionId = RedisUtil.hget(RedisSessionDAO.loginNameKey, userName);
        if (StringUtils.isNotBlank(haveLoginSessionId) && RedisUtil.exists(RedisSessionDAO.sessionKey + haveLoginSessionId)) {
            RedisUtil.del(RedisSessionDAO.sessionKey + haveLoginSessionId);
            RedisUtil.hdel(RedisSessionDAO.loginNameKey, userName);
            logger.info("强制登出：账号[{}]，在{}处强制登录。sessionId：{}被强制登出。", userName, IPUtil.getRemoteAddress(request), haveLoginSessionId);
        }
    }

    public static boolean isAlreadyLogin(String userName) {
        String haveLoginSessionId = RedisUtil.hget(RedisSessionDAO.loginNameKey, userName);
        if (StringUtils.isBlank(haveLoginSessionId)) {
            return false;
        }
        String key = RedisSessionDAO.sessionKey + haveLoginSessionId;
        return RedisUtil.exists(key);
    }

    public void setSessionKey(String sessionKey) {
        if (RedisSessionDAO.sessionKey == null) {
            RedisSessionDAO.sessionKey = sessionKey;
        }
    }

    public void setLoginNameKey(String loginNameKey) {
        if (RedisSessionDAO.loginNameKey == null) {
            RedisSessionDAO.loginNameKey = loginNameKey;
        }
    }
}
