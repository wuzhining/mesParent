package com.techsoft.controller.work;

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
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.SQLException;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmScheduling;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProductionline;
import com.techsoft.entity.firm.FirmSchedulingParamVo;
import com.techsoft.entity.struct.StructFactoryParamVo;
import com.techsoft.entity.struct.StructProductionlineParamVo;
import com.techsoft.entity.struct.StructWorkCalendarParamVo;
import com.techsoft.entity.struct.StructWorkCalendarVo;
import com.techsoft.client.service.firm.ClientFirmSchedulingService;
import com.techsoft.client.service.struct.ClientStructFactoryService;
import com.techsoft.client.service.struct.ClientStructWorkCalendarService;


@Controller
@RequestMapping("/work/workCalendar")
public class WorkCalendarController extends BaseController {
	@Autowired
	private ClientStructWorkCalendarService clientStructWorkCalendarService;
	@Autowired
	private ClientFirmSchedulingService clientFirmSchedulingService;
	@Autowired
	private ClientStructFactoryService clientStructFactoryService;
	
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
		
		try{
		  //取班别集合
		  FirmSchedulingParamVo ParamVoFirmScheduling = new FirmSchedulingParamVo();
		  List<FirmScheduling> firmSchedulingList = clientFirmSchedulingService.selectListByParamVo(ParamVoFirmScheduling,this.getCommonParam(null));
		  modelAndView.addObject("firmSchedulingList", firmSchedulingList);
		  
		  //取工厂集合
		  StructFactoryParamVo ParamVoStructFactory = new StructFactoryParamVo();
		  List<StructFactory> structFactoryList = clientStructFactoryService.selectListByParamVo(ParamVoStructFactory,this.getCommonParam(null));
		  modelAndView.addObject("structFactoryList", structFactoryList);
	    
		} catch (SQLException e) {  
			e.printStackTrace();
		} 
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("work/workCalendar-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("work/workCalendar-edit");
		StructWorkCalendarVo entity = new StructWorkCalendarVo();
		try {
			if (id != null) {
				entity = clientStructWorkCalendarService.getVoByID(id, this.getCommonParam(request));
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
			StructWorkCalendarParamVo structWorkCalendarParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(structWorkCalendarParamVo==null){
            	structWorkCalendarParamVo = new StructWorkCalendarParamVo();
            }
			pageInfo = clientStructWorkCalendarService.selectPageVoByParamVo(
					structWorkCalendarParamVo, this.getCommonParam(request),
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
			StructWorkCalendarParamVo structWorkCalendarParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
		structWorkCalendarParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientStructWorkCalendarService.saveOrUpdate(structWorkCalendarParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	



//    @RequestMapping("/skuOpen")
//	public ModelAndView skuOpen(HttpServletRequest request, Long productId) {
//		ModelAndView modelAndView = new ModelAndView();
//		StructWorkCalendarVo entity = new StructWorkCalendarVo();
//		try {
//		 
//			if(productId!=null){
//				ProductMain productMain=clientWorkPlanEquipFixtureService.selectById(productId,  this.getCommonParam(null));
//				String skuName="";
//				if(productMain!=null){
//						skuName=productMain.getSkuName();
//				}
//				if(skuName!=""&&skuName!=null){
//					String[] skuNames = skuName.split(",");
//					List<Map<String,String>> skuNameList=new ArrayList<>();
//					if (skuNames.length>0){
//						for (String name : skuNames) {
//							Map<String,String> map=new HashMap<>();
//							map.put("skuName", name);
//							skuNameList.add(map);
//						}
//						modelAndView.addObject("skuNameList", skuNameList);
//					}
//					
//				}
//			}
//			modelAndView.setViewName("product/productSkuOpen");
//			modelAndView.addObject("entity", entity);
//			initData(modelAndView);
//		} catch (SQLException | BusinessException e) {
//			e.printStackTrace();
//		}
//		return modelAndView;
//	}
	
}
