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
import com.techsoft.client.service.alarm.ClientAlarmLevelService;
import com.techsoft.client.service.alarm.ClientAlarmProblemService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.alarm.AlarmLevelParamVo;
import com.techsoft.entity.alarm.AlarmLevelVo;
import com.techsoft.entity.alarm.AlarmProblemParamVo;
import com.techsoft.entity.common.AlarmProblem;

@Controller
@RequestMapping("/alarm/alarmLevel")
public class AlarmLevelController extends BaseController {
	@Autowired
	private ClientAlarmLevelService clientAlarmLevelService;
	@Autowired
	private ClientAlarmProblemService clientAlarmProblemService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		AlarmProblemParamVo paramVo=new AlarmProblemParamVo();
		List<AlarmProblem> problemList;
		try {
			problemList = clientAlarmProblemService.selectListByParamVo(paramVo,
					this.getCommonParam(null));
		
		modelAndView.addObject("problemList", problemList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("alarm/alarmLevel-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
		modelAndView.setViewName("alarm/alarmLevel-edit");
		AlarmLevelVo entity = new AlarmLevelVo();
			if (id != null) {
				entity = clientAlarmLevelService.getVoByID(id, this.getCommonParam(request));
				AlarmProblem alarmProblem = clientAlarmProblemService.getVoByID(entity.getProblemId(), this.getCommonParam(request));
				modelAndView.addObject("alarmProblem", alarmProblem);
			}
		modelAndView.addObject("entity", entity);
		initData(modelAndView);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo listJson(HttpServletRequest request,
			AlarmLevelParamVo alarmLevelParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}
				
		try {
            if(alarmLevelParamVo==null){
            	alarmLevelParamVo = new AlarmLevelParamVo();
            }
			pageInfo = clientAlarmLevelService.selectPageVoByParamVo(
					alarmLevelParamVo, this.getCommonParam(request),
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
			AlarmLevelParamVo alarmLevelParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    alarmLevelParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientAlarmLevelService.saveOrUpdate(alarmLevelParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
