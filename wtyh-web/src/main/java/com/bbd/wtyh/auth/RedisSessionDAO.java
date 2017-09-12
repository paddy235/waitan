package com.bbd.wtyh.auth;

import com.bbd.wtyh.core.utils.redis.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Collection;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-09-08 16:19.
 */
public class RedisSessionDAO extends AbstractSessionDAO {

    @SuppressWarnings("unused")
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String SESSION_CACHE_REDIS_KEY_PREFIX = "shiro:session:cache:";
    public static final String LOGIN_USER_SESSION_REDIS_KEY = "login:name:sessionid";

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
            RedisUtil.hset(LOGIN_USER_SESSION_REDIS_KEY, loginName, session.getId().toString());
        }
        String redisKey = SESSION_CACHE_REDIS_KEY_PREFIX + session.getId();
        RedisUtil.setObject(redisKey, session);
        RedisUtil.expire(redisKey, (int) timeoutSeconds);
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        String redisKey = SESSION_CACHE_REDIS_KEY_PREFIX + sessionId;
        return RedisUtil.getObject(redisKey, SimpleSession.class);
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        setSessionToRedis((SimpleSession) session);
    }

    @Override
    public void delete(Session session) {
        String redisKey = SESSION_CACHE_REDIS_KEY_PREFIX + session.getId();
        RedisUtil.del(redisKey);
    }

    @Override
    public Collection<Session> getActiveSessions() {
        return null;
    }
}
