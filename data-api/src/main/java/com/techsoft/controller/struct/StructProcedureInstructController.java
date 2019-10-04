package com.techsoft.controller.struct;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.equip.ClientEquipSpecsWorkService;
import com.techsoft.client.service.struct.ClientStructProcedureInstructService;
import com.techsoft.client.service.struct.ClientStructProcessNodeService;
import com.techsoft.client.service.struct.ClientStructProcessService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipSpecsWork;
import com.techsoft.entity.common.StructProcess;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.struct.StructProcedureInstructParamVo;
import com.techsoft.entity.struct.StructProcedureInstructVo;
import com.techsoft.entity.struct.StructProcessParamVo;

@Controller
@RequestMapping("/struct/structProcedureInstruct")
public class StructProcedureInstructController extends BaseController {
	@Autowired
	private ClientStructProcedureInstructService clientStructProcedureInstructService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientEquipSpecsWorkService clientEquipSpecsWorkService;
	@Autowired
	private ClientStructProcessService clientStructProcessService ;
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			List<ConfigDictionary> executiveDicList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.STRUCT_PROCEDUER_INSTUCT_TYPE.getValue());
			modelAndView.addObject("instructTypeDictIdList", executiveDicList);
			
			List<ConfigDictionary> executList =clientConfigDictionaryService.selectListByParentId(EnumDictionary.PROCESS_EXECUTIVE_TYPE.getValue());
			modelAndView.addObject("executList", executList);
			
			StructProcessParamVo structProcessParamVo = new StructProcessParamVo();
			List<StructProcess> structProcesseList = clientStructProcessService.selectListByParamVo(structProcessParamVo, this.getCommonParam(null));
			modelAndView.addObject("structProcesseList",structProcesseList);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structProcedureInstruct-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			//执行方集合
			List<ConfigDictionary> executList1 =clientConfigDictionaryService.selectListByParentId(EnumDictionary.PROCESS_EXECUTIVE_TYPE.getValue());
			modelAndView.addObject("executList1", executList1);
			StructProcedureInstructVo entity = new StructProcedureInstructVo();
			if (id != null) {
				entity = clientStructProcedureInstructService.getVoByID(id, this.getCommonParam(request));
				if(entity.getEquipSpecsWorkId()!= null){
					EquipSpecsWork	equipSpecsWork = clientEquipSpecsWorkService.getVoByID(entity.getEquipSpecsWorkId(), this.getCommonParam(request));
					modelAndView.addObject("equipSpecsWork", equipSpecsWork);
				}
			}
			modelAndView.addObject("entity", entity);
			modelAndView.setViewName("struct/structProcedureInstruct-edit");
			initData(modelAndView);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo listJson(HttpServletRequest request,
			StructProcedureInstructParamVo structProcedureInstructParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(structProcedureInstructParamVo==null){
            	structProcedureInstructParamVo = new StructProcedureInstructParamVo();
            }
			pageInfo = clientStructProcedureInstructService.selectPageVoByParamVo(
					structProcedureInstructParamVo, this.getCommonParam(request),
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
			StructProcedureInstructParamVo structProcedureInstructParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    structProcedureInstructParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientStructProcedureInstructService.saveOrUpdate(structProcedureInstructParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}

	@RequestMapping("/listProcedureInstruct")
	public ModelAndView lineProcess(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structProcedureEquipFixture-Instruct");
		return modelAndView;
	}
	

}
