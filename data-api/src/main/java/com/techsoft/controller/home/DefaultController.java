package com.techsoft.controller.home;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techsoft.client.service.config.ClientConfigParameterService;
import com.techsoft.common.constants.ConstantParameter;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.ConfigParameter;
import com.techsoft.entity.sys.UserPassportAuthorityVo;

@Controller
@RequestMapping("/default")
public class DefaultController extends BaseController {
	@Autowired
	private ClientConfigParameterService clientConfigParameterService;

	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("default-index");

		try {
			ConfigParameter configParameter = clientConfigParameterService.getByCode(ConstantParameter.PLATFORM_NAME, getCommonParam(request));
			modelAndView.addObject("platFormName",configParameter.getParamValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		UserPassportAuthorityVo userPassportAuthorityVo = getLoginUserPassport(request);
		modelAndView.addObject("realName", userPassportAuthorityVo.getRealName());

		return modelAndView;
	}

	@RequestMapping("/welcome")
	public ModelAndView welcome(HttpServletRequest request, ModelMap modelMap) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("default-welcome");
		return modelAndView;
	}

}
