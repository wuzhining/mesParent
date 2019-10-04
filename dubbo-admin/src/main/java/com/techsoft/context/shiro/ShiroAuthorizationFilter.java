package com.techsoft.context.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import com.techsoft.common.constants.Constants;
import com.techsoft.entity.sys.UserPassportAuthorityVo;

//AuthorizationFilter抽象类事项了javax.servlet.Filter接口，是个过滤器。
public class ShiroAuthorizationFilter  extends AuthorizationFilter {
    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) { 
 
		
        Subject subject = getSubject(request, response);
	 
        String[] permissionsArray = (String[]) mappedValue;
	 
        if (permissionsArray == null || permissionsArray.length == 0) {
            return true;
        }
        
    	Session session = subject.getSession();
	 
		UserPassportAuthorityVo userPassport = (UserPassportAuthorityVo) session
				.getAttribute(Constants.SESSION_USER);
		
		if(userPassport==null){
	        return false; 
		}

	
		for(String role:userPassport.getAuthorityRoleList()){
			 if (subject.hasRole(role)) {
	                return true;
	       }
		}
		
        for (String permi : permissionsArray) {
         
        }
        return false;
    }
//https://www.cnblogs.com/007sx/p/7381475.html   
}
