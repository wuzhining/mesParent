package com.techsoft.controller.home;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.techsoft.client.service.config.ClientConfigParameterService;
import com.techsoft.client.service.sys.ClientUserPassportService;
import com.techsoft.common.constants.ConstantParameter;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.CookieUtils;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.ConfigParameter;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.sys.UserPassportAuthorityVo;

@Controller
@RequestMapping("/passport")
public class PassportController extends  BaseController {
	@Autowired
	private ClientConfigParameterService clientConfigParameterService;
	@Autowired
	private ClientUserPassportService clientUserPassportService;

	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		try {
			ConfigParameter configParameter = clientConfigParameterService.getByCode(ConstantParameter.PLATFORM_NAME, getCommonParam(request));
			modelAndView.addObject("platFormName",configParameter.getParamValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 
		modelAndView.setViewName("passport-index");
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage login(HttpServletRequest request,
			HttpServletResponse response, String userName, String password,
			String verificationCode) {
		ResultMessage resultMessage = new ResultMessage();

		resultMessage = clientUserPassportService.loginByUserName(
				getCommonParam(request), userName, password,
				CookieUtils.getVisitIP(request));
		if (resultMessage.getIsSuccess()) { 
			try {
				// shiro管理的session
				Subject currentUser = SecurityUtils.getSubject();
				Session session = currentUser.getSession();
				// 获取session中的验证码
				// String sessionCode = (String)
				// session.getAttribute(Const.SESSION_SECURITY_CODE); 
				UserPassport userPassport = (UserPassport) resultMessage
						.getBaseEntity();
				List<String> authorityPermissionList = new ArrayList<String>();
				authorityPermissionList.add("list");
				List<String> authorityRoleList = new ArrayList<String>();
				authorityRoleList.add("admin");
				userPassport.setPassword(password);
				UserPassportAuthorityVo userPassportAuthorityVo = new UserPassportAuthorityVo(
						userPassport);
				userPassportAuthorityVo.setAuthorityPermissionList(authorityPermissionList);
				userPassportAuthorityVo.setAuthorityRoleList(authorityRoleList);
				
				session.setAttribute(Constants.SESSION_USER, userPassportAuthorityVo);
				session.removeAttribute(Constants.SESSION_SECURITY_CODE);
		        session.setTimeout(60 * 60 * 3 * 1000); 

				UsernamePasswordToken token = new UsernamePasswordToken(
						userPassport.getUserName(), password);
				 
				// shiro加入身份验证
				Subject subject = SecurityUtils.getSubject();

				resultMessage.setBaseEntity(userPassport);
				subject.login(token);
				resultMessage.setIsSuccess(true);
			} catch (AuthenticationException e) {
				e.printStackTrace();
				resultMessage.addErr("身份验证失败！");
			}
		}

		return resultMessage;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage logout(HttpServletRequest request,
			HttpServletResponse response) {
		ResultMessage resultMessage = new ResultMessage();
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();

		session.removeAttribute(Constants.SESSION_USER);

		// shiro销毁登录
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		resultMessage.setIsSuccess(true);
		return resultMessage;
	}
}
