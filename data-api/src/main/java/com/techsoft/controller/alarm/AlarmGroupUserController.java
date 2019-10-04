package com.techsoft.controller.alarm;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.alarm.ClientAlarmGroupUserService;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.firm.ClientFirmEmployeeService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.alarm.AlarmGroupUserParamVo;
import com.techsoft.entity.alarm.AlarmGroupUserVo;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmEmployee;
import com.techsoft.entity.firm.FirmEmployeeParamVo;

@Controller
@RequestMapping("/alarm/alarmGroupUser")
public class AlarmGroupUserController extends BaseController {
	@Autowired
	private ClientAlarmGroupUserService clientAlarmGroupUserService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientFirmEmployeeService clientFirmEmployeeService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) {
		try {
		//取员工集合
		FirmEmployeeParamVo ParamVouser = new FirmEmployeeParamVo();
		List<FirmEmployee> userList = clientFirmEmployeeService.selectListByParamVo(ParamVouser,this.getCommonParam(null));
		modelAndView.addObject("userList", userList);
		
		//取报警组集合
		List<ConfigDictionary> alarmGroupList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.ALARM_GROUP.getValue());
		modelAndView.addObject("alarmGroupList", alarmGroupList);
		
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
		
		} catch (SQLException e) {  
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("alarm/alarmGroupUser-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("alarm/alarmGroupUser-edit");
		AlarmGroupUserVo entity = new AlarmGroupUserVo();
		try {
			if (id != null) {
				entity = clientAlarmGroupUserService.getVoByID(id, this.getCommonParam(request));
				FirmEmployee firmEmployee = clientFirmEmployeeService.getVoByID(entity.getUserId(), this.getCommonParam(request));
				modelAndView.addObject("firmEmployee", firmEmployee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("entity", entity);
		initData(modelAndView);
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo listJson(HttpServletRequest request,
			AlarmGroupUserParamVo alarmGroupUserParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}
		try {
            if(alarmGroupUserParamVo==null){
            	alarmGroupUserParamVo = new AlarmGroupUserParamVo();
            }
            //alarmGroupUserParamVo.setTenantId(getLoginTenantId(request)); 
			pageInfo = clientAlarmGroupUserService.selectPageVoByParamVo(
					alarmGroupUserParamVo, this.getCommonParam(request),
					pageIndex, pageNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return new ReturnPageInfo(pageInfo);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage save(HttpServletRequest request,
			AlarmGroupUserParamVo alarmGroupUserParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    alarmGroupUserParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientAlarmGroupUserService.saveOrUpdate(alarmGroupUserParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
