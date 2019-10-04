package com.techsoft.controller.product;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.product.ClientProductBomItemRepalceService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.product.ProductBomItemRepalceParamVo;
import com.techsoft.entity.product.ProductBomItemRepalceVo;

@Controller
@RequestMapping("/product/productBomItemRepalce")
public class ProductBomItemRepalceController extends BaseController {
	@Autowired
	private ClientProductBomItemRepalceService clientProductBomItemRepalceService;
	
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
		modelAndView.setViewName("product/productBomItemRepalce-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("product/productBomItemRepalce-edit");
		ProductBomItemRepalceVo entity = new ProductBomItemRepalceVo();
		try {
			if (id != null) {
				entity = clientProductBomItemRepalceService.getVoByID(id, this.getCommonParam(request));
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
			ProductBomItemRepalceParamVo productBomItemRepalceParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(productBomItemRepalceParamVo==null){
            	productBomItemRepalceParamVo = new ProductBomItemRepalceParamVo();
            }
			pageInfo = clientProductBomItemRepalceService.selectPageVoByParamVo(
					productBomItemRepalceParamVo, this.getCommonParam(request),
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
			ProductBomItemRepalceParamVo productBomItemRepalceParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    productBomItemRepalceParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientProductBomItemRepalceService.saveOrUpdate(productBomItemRepalceParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}


}
