package com.techsoft.context.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
 

public class InterceptorVisit implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(InterceptorVisit.class);

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse arg1,
			Object arg2) throws Exception {
		String path = httpServletRequest.getServletPath();
		try {
			 
			if (StringUtils.isNotBlank(path)) {
				if ((!path.startsWith("/passport"))) {
					HttpSession session = httpServletRequest.getSession();
//					SysUser sysUser = (SysUser) session.getAttribute("SysUser");
//					if (sysUser == null) {
//						response.sendRedirect(httpServletRequest
//								.getContextPath() + "/default/out");
//						return false;
//					}
				}

			}
		} catch (Exception e) {
		}
		
		return true;
	}
 

}
