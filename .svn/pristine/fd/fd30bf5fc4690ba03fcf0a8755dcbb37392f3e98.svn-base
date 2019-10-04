package com.techsoft.controller.quality;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.quality.ClientQualitySampleLevelService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.QualitySampleLevel;
import com.techsoft.entity.quality.QualitySampleLevelParamVo;
import com.techsoft.entity.quality.QualitySampleLevelVo;

@Controller
@RequestMapping("/quality/qualitySampleLevel")
public class QualitySampleLevelController extends BaseController {
	@Autowired
	private ClientQualitySampleLevelService clientQualitySampleLevelService;
	
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
		modelAndView.setViewName("quality/qualitySampleLevel-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("quality/qualitySampleLevel-edit");
		QualitySampleLevelVo entity = new QualitySampleLevelVo();
		try {
			if (id != null) {
				entity = clientQualitySampleLevelService.getVoByID(id, this.getCommonParam(request));
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
			QualitySampleLevelParamVo qualitySampleLevelParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(qualitySampleLevelParamVo==null){
            	qualitySampleLevelParamVo = new QualitySampleLevelParamVo();
            }
			pageInfo = clientQualitySampleLevelService.selectPageVoByParamVo(
					qualitySampleLevelParamVo, this.getCommonParam(request),
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
			QualitySampleLevelParamVo qualitySampleLevelParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    qualitySampleLevelParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientQualitySampleLevelService.saveOrUpdate(qualitySampleLevelParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	
	
	@RequestMapping(value = "/saveBatch", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage saveBatch(HttpServletRequest request,QualitySampleLevelParamVo qualitySampleLevelParamVo,String list) {
		ResultMessage resultMessage = new ResultMessage();
		   List<QualitySampleLevel> itemList = new ArrayList<QualitySampleLevel>();

	        //2、使用JSONArray
	        JSONArray jsonArray=JSONArray.parseArray(list);
	        for(int i=0;i<jsonArray.size();i++){
	        	
				String ts = jsonArray.get(i).toString();
				System.out.println(ts);
		        JSONObject jsonObject = JSONObject.parseObject(jsonArray.get(i).toString());
				Map<String, Object> map =jsonObject;
				for (Entry<String, Object> entry : map.entrySet()) {

				 Long sampleLevelDictId = Long.parseLong(entry.getKey().toString());
				 JSONObject jsonMinimumOrMaximum = JSONObject.parseObject(entry.getValue().toString());
					Map<String, Object> mapMinOrMax =jsonMinimumOrMaximum;
					for (Entry<String, Object> entryMinOrMax : mapMinOrMax.entrySet()) {
						String [] minOrmax = entryMinOrMax.getKey().split("[-]");
						 JSONObject jsonRank = JSONObject.parseObject(entryMinOrMax.getValue().toString());
							Map<String, Object> mapRank =jsonRank;
							for (Entry<String, Object> entryList : mapRank.entrySet()) {
								QualitySampleLevel sample= new QualitySampleLevel();
								
								sample.setSampleLetter(entryList.getValue().toString());//字母
					       	    sample.setSampleLevelRankDictId(Long.parseLong(entryList.getKey()));//抽样级别

						       	sample.setSampleLevelDictId(sampleLevelDictId);//特殊检验水平/一般检验水平
						       	
					   	       	sample.setMinimum(Integer.parseInt(minOrmax[0]));
					   	       	
					   	       int max=Integer.parseInt(minOrmax[1]);
					   	       	if(max!=0){
					   	     	   sample.setMaximum(Integer.parseInt(minOrmax[1]));
					   	       	}
						       	itemList.add(sample);
								
							}

					}
				}  
	        }
		    qualitySampleLevelParamVo.setModifyUserId(getLoginUserId(request)); 
			resultMessage = clientQualitySampleLevelService.saveBatchSampleLevel(qualitySampleLevelParamVo,this.getCommonParam(request),itemList);
		return resultMessage;
	}
	
	
	
	@ResponseBody
	@RequestMapping("/selectSampleLetter")
	public Map<String,Object> selectSampleLetter(HttpServletRequest request,QualitySampleLevelParamVo qualitySampleLevelParamVo) {
		 HashMap<String,Object> map=new HashMap<String,Object>();
		 List<QualitySampleLevelVo> list = null;
		 try {
			 list = clientQualitySampleLevelService.selectSampleLetter();
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	     map.put("list", list);
	     
	     return map;
		
	}
	
}
