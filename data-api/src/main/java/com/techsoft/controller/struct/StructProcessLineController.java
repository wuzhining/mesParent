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
import com.techsoft.common.BusinessException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.SQLException;
import com.techsoft.controller.BaseController;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.struct.ClientStructProcessLineService;
import com.techsoft.client.service.struct.ClientStructProcessNodeService;
import com.techsoft.client.service.struct.ClientStructProcessService;
import com.techsoft.entity.struct.StructProcessLineVo;
import com.techsoft.entity.struct.StructProcessNodeVo;
import com.techsoft.entity.struct.StructProcessParamVo;
import com.techsoft.entity.struct.StructProcessVo;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProcess;
import com.techsoft.entity.common.StructProcessLine;
import com.techsoft.entity.struct.StructFactoryParamVo;
import com.techsoft.entity.struct.StructProcessLineParamVo;

@Controller
@RequestMapping("/struct/structProcessLine")
public class StructProcessLineController extends BaseController {
	@Autowired
	private ClientStructProcessLineService clientStructProcessLineService;
	@Autowired
	private ClientStructProcessService clientStructProcessService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientStructProcessNodeService clientStructProcessNodeService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		StructProcessParamVo paramVo = new StructProcessParamVo();
		List<StructProcess> processList;
		try {
			processList = clientStructProcessService.selectListByParamVo(paramVo, null);
			modelAndView.addObject("processList", processList);
			modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("struct/structProcessLine-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("struct/structProcess-edit");
		StructProcessVo entity = new StructProcessVo();
		try {
			if (id != null) {
				entity = clientStructProcessService.getVoByID(id, this.getCommonParam(request));
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
			StructProcessLineParamVo structProcessLineParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(structProcessLineParamVo==null){
            	structProcessLineParamVo = new StructProcessLineParamVo();
            }
			pageInfo = clientStructProcessLineService.selectPageVoByParamVo(
					structProcessLineParamVo, this.getCommonParam(request),
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
			StructProcessLineVo structProcessLineVo) {
		ResultMessage resultMessage = new ResultMessage();
		
		StructProcessLineParamVo ParamVo = new StructProcessLineParamVo();
		Long id = Long.parseLong(request.getParameter("id"));

		System.out.println(request.getParameter("processVersion"));
		
		StructProcessVo entity = new StructProcessVo();
		List<ConfigDictionary> lineTypeList = null;
		List<StructProcessLineVo> processLineList = null;
		ParamVo.setProcessId(Long.parseLong(request.getParameter("id")));
		ParamVo.setProcessVersion(Integer.parseInt(request.getParameter("processVersion")));
		try {
			 entity = clientStructProcessService.getVoByID(id, this.getCommonParam(request));
			 lineTypeList = clientConfigDictionaryService.selectListByParentId(EnumDictionary.PROCESS_LINE_TYPE.getValue());
			 processLineList = clientStructProcessLineService.selectListVoByParamVo(ParamVo, this.getCommonParam(request));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] NodeLine = request.getParameter("serliza").split("&");
	    structProcessLineVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientStructProcessLineService.saveBatchListInsert(lineTypeList,entity,NodeLine,processLineList,this.getCommonParam(request));
		return resultMessage;
	}

	
	@ResponseBody
	@RequestMapping(value = "/routList", method = RequestMethod.POST)
	public ResultMessage getList(HttpServletRequest request, Long id) {
		ResultMessage resultMessage = new ResultMessage();
		StructProcessLineParamVo ParamVo = new StructProcessLineParamVo();
		try {
			ParamVo.setProcessId(Long.parseLong(request.getParameter("routId")));
			ParamVo.setProcessVersion(Integer.parseInt(request.getParameter("routVersion")));
			
			List<StructProcessLineVo> processLineList = clientStructProcessLineService.selectListVoByParamVo(ParamVo, this.getCommonParam(request)); 
			resultMessage.put(processLineList);
			resultMessage.setIsSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			resultMessage.setIsSuccess(false);
		}
		return resultMessage;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getNodeNames", method = RequestMethod.POST)
	public ResultMessage getNodeNames(HttpServletRequest request, Long id) {
		ResultMessage resultMessage = new ResultMessage();
		try {
			StructProcessNodeVo structProcessNodeVo = clientStructProcessNodeService.getExtendVoByID(Long.parseLong(request.getParameter("NodeId")), this.getCommonParam(request)); 
			resultMessage.put(structProcessNodeVo);
			resultMessage.setIsSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			resultMessage.setIsSuccess(false);
		}
		return resultMessage;
	}
	
	
}
