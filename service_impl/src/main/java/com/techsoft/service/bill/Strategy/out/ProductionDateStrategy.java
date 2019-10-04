package com.techsoft.service.bill.Strategy.out;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumBarcodeStatus;
import com.techsoft.common.enums.EnumDownShelfAttributeAdcdesOrder;
import com.techsoft.dao.barcode.BarcodeMainDao;
import com.techsoft.entity.barcode.BarcodeMainParamVo;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.service.bill.Strategy.WareHouseStrategy;

/**
*@auther:Wang
*@version:2019年6月3日下午3:16:56
*@param:
*@description 生产日期出库策略实现类
*/
public class ProductionDateStrategy   implements WareHouseStrategy{
	private BarcodeMainDao barcodeMainDao;
	
	//物料ID
	private Long materialId;
	//排序
	private Long productionDate;
	
	
	@Override
	public Object Startegy() {
		BarcodeMainParamVo paramVo=new BarcodeMainParamVo();
		paramVo.setMaterialId(materialId);
		paramVo.setBarcodeStatusDictId(EnumBarcodeStatus.INSTORE.getValue());
		long barcodePackbox = 0;// 最外箱
		paramVo.setBarcodePackboxId(barcodePackbox);
		if (productionDate.equals(EnumDownShelfAttributeAdcdesOrder.ASC.getValue())) {
			paramVo.setProductionDateAsc("1");
		}
		if (productionDate .equals(EnumDownShelfAttributeAdcdesOrder.DES.getValue())) {
			paramVo.setProductionDateDesc("1");
		}
		List<BarcodeMain> list=new ArrayList<>();
		try {
			 list=barcodeMainDao.selectListByParamVo(paramVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}


	public Long getProductionDate() {
		return productionDate;
	}


	public void setProductionDate(Long productionDate) {
		this.productionDate = productionDate;
	}


	 

	public BarcodeMainDao getBarcodeMainDao() {
		return barcodeMainDao;
	}


	public void setBarcodeMainDao(BarcodeMainDao barcodeMainDao) {
		this.barcodeMainDao = barcodeMainDao;
	}


	
}
