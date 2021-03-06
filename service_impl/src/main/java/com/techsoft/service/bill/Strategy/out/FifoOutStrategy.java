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
*@version:2019年6月3日下午1:49:18
*@param:
*@description 出库先进先出策略实现类
*/
/**
*@auther:Wang
*@version:2019年6月3日下午2:17:17
*@description
*/
public class FifoOutStrategy implements WareHouseStrategy{
	private BarcodeMainDao barcodeMainDao;
	
	//物料ID
	private Long materialId;
	//排序
	private Long instoreDate;

	/* (出库先进先出策略实现方法)
	 * @param:materialId 物料id
	 * @description:按照物料的入库日期查出仓库最早入库的标签以升序的方式返回
	 */
	@Override
	public Object Startegy() {
		BarcodeMainParamVo paramVo=new BarcodeMainParamVo();
		paramVo.setMaterialId(materialId);
		paramVo.setBarcodeStatusDictId(EnumBarcodeStatus.INSTORE.getValue());
		long barcodePackbox = 0;// 最外箱
		paramVo.setBarcodePackboxId(barcodePackbox);
		if (instoreDate.equals(EnumDownShelfAttributeAdcdesOrder.ASC.getValue())) {
			paramVo.setInstoreDateAsc("1");
		}
		if (instoreDate.equals(EnumDownShelfAttributeAdcdesOrder.DES.getValue())) {
			paramVo.setInstoreDateDesc("1");
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

	public Long getInstoreDate() {
		return instoreDate;
	}

	public void setInstoreDate(Long instoreDate) {
		this.instoreDate = instoreDate;
	}


	public BarcodeMainDao getBarcodeMainDao() {
		return barcodeMainDao;
	}

	public void setBarcodeMainDao(BarcodeMainDao barcodeMainDao) {
		this.barcodeMainDao = barcodeMainDao;
	}
	
}
