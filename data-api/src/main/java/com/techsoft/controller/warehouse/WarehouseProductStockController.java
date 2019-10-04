package com.techsoft.controller.warehouse;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import com.techsoft.common.BusinessException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.common.utils.ExportXssfUtils;
import com.techsoft.common.SQLException;
import com.techsoft.controller.BaseController;

import com.techsoft.client.service.warehouse.ClientWarehouseProductStockService;
import com.techsoft.entity.warehouse.WarehouseProductStockVo;
import com.techsoft.entity.bill.BillWarehouseParamVo;
import com.techsoft.entity.bill.BillWarehouseVo;
import com.techsoft.entity.warehouse.WarehouseProductStockParamVo;

@Controller
@RequestMapping("/warehouse/warehouseProductStock")
public class WarehouseProductStockController extends BaseController {
	@Autowired
	private ClientWarehouseProductStockService clientWarehouseProductStockService;
	
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
		modelAndView.setViewName("warehouse/warehouseProductStock-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("warehouse/warehouseProductStock-edit");
		WarehouseProductStockVo entity = new WarehouseProductStockVo();
		try {
			if (id != null) {
				entity = clientWarehouseProductStockService.getVoByID(id, this.getCommonParam(request));
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
			WarehouseProductStockParamVo warehouseProductStockParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(warehouseProductStockParamVo==null){
            	warehouseProductStockParamVo = new WarehouseProductStockParamVo();
            }
			pageInfo = clientWarehouseProductStockService.selectPageVoByParamVo(
					warehouseProductStockParamVo, this.getCommonParam(request),
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
			WarehouseProductStockParamVo warehouseProductStockParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    warehouseProductStockParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientWarehouseProductStockService.saveOrUpdate(warehouseProductStockParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	/**
     * 导出Excel文件
     * @return
     */
    @RequestMapping(value = "/export",method = RequestMethod.POST)
    @ResponseBody
    public ResultMessage export(HttpServletRequest request,HttpServletResponse response,WarehouseProductStockParamVo warehouseProductStockParamVo) throws Exception {
    	ResultMessage resultMessage = new ResultMessage();
        //获取数据
        List<WarehouseProductStockVo> list = clientWarehouseProductStockService.selectListVoByParamVo(warehouseProductStockParamVo, this.getCommonParam(request));

    	
    	//创建HSSFWorkbook 
    	 String fileName = "库存报表";
    	 String[] title = {"工厂名称","物品类型","物品编码","物品名称","物品规格编码","物品规格名称","物品规格值","库存数量"};
    	 
    	 //定义一个二维数组
    	 String[][] content = new String[list.size()][title.length];
	       for (int i = 0; i < list.size(); i++) {
	        content[i] = new String[title.length];
	        WarehouseProductStockVo obj = list.get(i);
	        content[i][0] = obj.getStructFactory().getFactoryName();
	        content[i][1] = obj.getProductType().getDictName();
	        content[i][2] = obj.getProductMain().getProductCode();
	        content[i][3] = obj.getProductMain().getProductName();
	        content[i][4] = obj.getProductMaterial().getMaterialCode();
	        content[i][5] = obj.getProductMaterial().getMaterialName();
	        content[i][6] = obj.getProductMaterialVo().getSku();
	        content[i][7] = obj.getQuantityStock().toString();
	       } 
	     //将数据传回导出Excel文件
	     resultMessage.setMessage(ExportXssfUtils.main(response,fileName,title,content));
         resultMessage.setIsSuccess(true);
         return resultMessage;
         
}

}
