package com.techsoft.controller.quality;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.quality.ClientQualitySampleRuleItemService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.QualitySampleRuleItem;
import com.techsoft.entity.quality.QualitySampleRuleItemParamVo;
import com.techsoft.entity.quality.QualitySampleRuleItemVo;


@Controller
@RequestMapping("/quality/qualitySampleRuleItem")
public class QualitySampleRuleItemController extends BaseController {
	@Autowired
	private ClientQualitySampleRuleItemService clientQualitySampleRuleItemService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("quality/qualitySampleRuleItem-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("quality/qualitySampleRuleItem-edit");
		QualitySampleRuleItemVo entity = new QualitySampleRuleItemVo();
		try {
			if (id != null) {
				entity = clientQualitySampleRuleItemService.getVoByID(id, this.getCommonParam(request));
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
			QualitySampleRuleItemParamVo qualitySampleRuleItemParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(qualitySampleRuleItemParamVo==null){
            	qualitySampleRuleItemParamVo = new QualitySampleRuleItemParamVo();
            }
			pageInfo = clientQualitySampleRuleItemService.selectPageVoByParamVo(
					qualitySampleRuleItemParamVo, this.getCommonParam(request),
					pageIndex, pageNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return new ReturnPageInfo(pageInfo);
	}
	
	@ResponseBody
	@RequestMapping("/list/ruleItemJson")
	public List<QualitySampleRuleItem> ruleItemJson(HttpServletRequest request,
			QualitySampleRuleItemParamVo qualitySampleRuleItemParamVo, Integer pageIndex) {
		List<QualitySampleRuleItem> list = new ArrayList<QualitySampleRuleItem>();
		try {
            if(qualitySampleRuleItemParamVo==null){
            	qualitySampleRuleItemParamVo = new QualitySampleRuleItemParamVo();
            }
                list = clientQualitySampleRuleItemService.selectListByParamVo(qualitySampleRuleItemParamVo, this.getCommonParam(request));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  return list;
	}
	
	
     //截取中括号的字符串
	public static String extractMessageByRegular(String str){	
		str =str.replace("\"", "");
		str =str.replace("[", "");
		str =str.replace("]", "");
		str.split(",");
		return str;

	}
	


	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage save(HttpServletRequest request,
			QualitySampleRuleItemVo qualitySampleRuleItemVo,String listSampleLetter,String listQuantity,String listACValue,String listREValue,String ids) {
		ResultMessage resultMessage = new ResultMessage();
		
		List<QualitySampleRuleItem> itemList = new ArrayList<QualitySampleRuleItem>();
        ids =ids.replace("[", "");
        ids =ids.replace("]", "");

        String[] pids =extractMessageByRegular(ids).split(",");
        String[] Letter = extractMessageByRegular(listSampleLetter).split(",");
        String[] quantity = extractMessageByRegular(listQuantity).split(",");
        String[] acvalue = extractMessageByRegular(listACValue).split(",");
        String[] revalue = extractMessageByRegular(listREValue).split(",");
        Integer index = 0;
        for(String Letters : Letter){
        	QualitySampleRuleItem sample= new QualitySampleRuleItem();
        	sample.setSampleLetter(Letters);
        	sample.setQuantity(Integer.parseInt(quantity[index]));
        	sample.setQuantityAc(Integer.parseInt(acvalue[index]));
        	sample.setQuantityRe(Integer.parseInt(revalue[index]));
            if(!"".equals(ids)){
            	sample.setId(Long.parseLong(pids[index]));
            	qualitySampleRuleItemVo.setId(sample.getId());
             }
        	itemList.add(sample);
        	index++;
        	
        };
        
	    qualitySampleRuleItemVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientQualitySampleRuleItemService.batchInsertList(qualitySampleRuleItemVo,this.getCommonParam(request), itemList);

		return resultMessage;
	}


}
