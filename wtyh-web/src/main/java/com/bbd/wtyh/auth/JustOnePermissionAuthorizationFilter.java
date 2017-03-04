package com.bbd.wtyh.auth;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by Administrator on 2017/3/4 0004.
 */
public class JustOnePermissionAuthorizationFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        Subject subject = getSubject(request, response);
        String[] perms = (String[]) mappedValue;
        boolean isPer=false;
        if (perms == null || perms.length == 0) {
            //no roles specified, so nothing to check - allow access.
            return true;
        }

        for(int i=0;i<perms.length;i++){
            if(subject.isPermitted(perms[i])){
                return true;
            }
        }
        return false;

    }
}
