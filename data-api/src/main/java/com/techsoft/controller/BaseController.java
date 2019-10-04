package com.techsoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.techsoft.common.CommonParam;
import com.techsoft.common.constants.Constants;
import com.techsoft.entity.sys.UserPassportAuthorityVo;

public class BaseController {

	/**
	 * 获取当前登陆的用户对象
	 */
	public UserPassportAuthorityVo getLoginUserPassport(
			HttpServletRequest request) {
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		UserPassportAuthorityVo userPassport = (UserPassportAuthorityVo) session
				.getAttribute(Constants.SESSION_USER);
		return userPassport;
	}

	/**
	 * 获取当前登陆的用户ID
	 */
	public Long getLoginUserId(HttpServletRequest request) { 
		UserPassportAuthorityVo userPassport = getLoginUserPassport(request);
		if (userPassport != null) {
			return userPassport.getId();
		} else {
			return null;
		}
	}

	/**
	 * 获取当前登陆的SaaS租户ID
	 */
	public Long getLoginTenantId(HttpServletRequest request) { 
		UserPassportAuthorityVo userPassport = getLoginUserPassport(request);
		if (userPassport != null) {
			return userPassport.getTenantId();
		} else {
			return null;
		}
	}
    
	protected CommonParam getCommonParam(HttpServletRequest request) {
		CommonParam commonParam = new CommonParam();
		 Long tenantId = getLoginTenantId(request);
         if(tenantId!=null){
			commonParam.setTenantId(tenantId);
         }
         Long userId=getLoginUserId(request);
 		if (userId!=null) {
			commonParam.setUserId(String.valueOf(userId));
		}
		return commonParam;
	}

}
