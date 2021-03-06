package com.techsoft.service.bill.Strategy.in;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumBarcodeStatus;
import com.techsoft.common.enums.EnumYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.entity.barcode.BarcodeMainParamVo;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.WarehouseLocation;
import com.techsoft.entity.common.WarehouseStrategyUpshelf;
import com.techsoft.entity.warehouse.WarehouseStrategyUpshelfParamVo;
import com.techsoft.service.bill.Strategy.WareHouseStrategy;
import com.techsoft.dao.barcode.BarcodeMainDao;
import com.techsoft.dao.warehouse.WarehouseLocationDao;
import com.techsoft.dao.warehouse.WarehouseStrategyUpshelfDao;

@Service
public class UpShelfStrategyServiceImpl  implements WareHouseStrategy {
	private WarehouseStrategyUpshelfDao warehouseStrategyUpshelfDao;
	private WarehouseLocationDao warehouseLocationDao;
	private BarcodeMainDao barcodeMainDao;
	
	
	private String barcode;
	private Long warehouseId;
	private Long locationId;
	private Long strategyCode;
	private int resultCode;
	
	
	@Override
	public Object Startegy(){
		
		try{
			//查询策略信息
			WarehouseStrategyUpshelf warehouseStrategyUpshelf=warehouseStrategyUpshelfDao.selectById(strategyCode);
			
			//查询货位信息
			WarehouseLocation warehouseLocation =new WarehouseLocation();
			warehouseLocation=warehouseLocationDao.selectById(locationId);
			
			//查询策略信息
			List<BarcodeMain> barcodeList =new ArrayList<BarcodeMain>();
			BarcodeMainParamVo barparamVo=new BarcodeMainParamVo();
			barparamVo.setBarcode(barcode);
			barcodeList=barcodeMainDao.selectListByParamVo(barparamVo);
			
			resultCode=0;
			
			//先判断工厂是否匹配
			if(warehouseStrategyUpshelf.getFactoryId()!=null && warehouseStrategyUpshelf.getFactoryId()!=0){
				if(!warehouseStrategyUpshelf.getFactoryId().equals(warehouseLocation.getFactoryId())){
					 resultCode=1;
				}
				else{
					 resultCode=0;
				}
			}
			
			//判断仓库是否匹配
			if (resultCode==0) {
				if(warehouseStrategyUpshelf.getWarehouseId()!=null && warehouseStrategyUpshelf.getWarehouseId()!=0){
					if(!warehouseStrategyUpshelf.getWarehouseId().equals(warehouseLocation.getWarehouseId())){
						 resultCode=2;
					}
					else{
						 resultCode=0;
					}
				}
			}
			
			//判断区域是否匹配
			if (resultCode==0) {
				if(warehouseStrategyUpshelf.getAreaId()!=null && warehouseStrategyUpshelf.getAreaId()!=0){
					if(!warehouseStrategyUpshelf.getAreaId().equals(warehouseLocation.getAreaId())){
						 resultCode=3;
					}
					else{
						 resultCode=0;
					}
				}
			}
			
			//判断货架是否匹配
			if (resultCode==0) {
				if(warehouseStrategyUpshelf.getRackId()!=null && warehouseStrategyUpshelf.getRackId()!=0){
					if(!warehouseStrategyUpshelf.getRackId().equals(warehouseLocation.getRackId())){
						 resultCode=4;
					}
					else{
						 resultCode=0;
					}
				}
			}
			
			//判断货位是否匹配
			if (resultCode==0) {
				if(warehouseStrategyUpshelf.getLocationId()!=null && warehouseStrategyUpshelf.getLocationId()!=0){
					if(!warehouseStrategyUpshelf.getLocationId().equals(warehouseLocation.getId())){
						 resultCode=5;
					}
					else{
						 resultCode=0;
					}
				}
			}
			
			//判断库位是否为空
			if (resultCode==0 && warehouseStrategyUpshelf.getLocationId()!=null && warehouseStrategyUpshelf.getLocationId()!=0) {
				if(warehouseStrategyUpshelf.getLocationIsEmpty().equals(EnumYesOrNo.YES.getValue())){
					//查询货位是否为空
					List<BarcodeMain> barcodeMains=new ArrayList<BarcodeMain>();
					BarcodeMainParamVo barcodeMainParamVo=new BarcodeMainParamVo();
					barcodeMainParamVo.setLocationId(locationId);
					barcodeMainParamVo.setBarcodeStatusDictId(EnumBarcodeStatus.INSTORE.getValue());
					barcodeMains=barcodeMainDao.selectListByParamVo(barcodeMainParamVo);
					
					
					if(barcodeMains.size()>0){
						 resultCode=6;
					}
					else{
						 resultCode=0;
					}
				}
			}
			
			//判断库位是否不允许混放批次
			if (resultCode==0 && warehouseStrategyUpshelf.getLocationId()!=null) {
				if(warehouseStrategyUpshelf.getLocationIsNotmixBatch().equals(EnumYesOrNo.YES.getValue())){
					//查询货位是否为空
					List<BarcodeMain> barcodeMains=new ArrayList<BarcodeMain>();
					BarcodeMainParamVo barcodeMainParamVo=new BarcodeMainParamVo();
					barcodeMainParamVo.setLocationId(locationId);
					barcodeMainParamVo.setBarcodeStatusDictId(EnumBarcodeStatus.INSTORE.getValue());
					barcodeMains=barcodeMainDao.selectListByParamVo(barcodeMainParamVo);
					
					if(barcodeMains.size()>0){
					for (BarcodeMain barcodeMain : barcodeMains) {
						if(!barcodeMain.getBatchNumber().equals(barcodeList.get(0).getBatchNumber())){
							 resultCode=7;
							 break;
						}
					  }
					}else{
						 resultCode=0;
					}
					
				}
			}
			
			//判断库位是否不允许混放物品
			if (resultCode==0 && warehouseStrategyUpshelf.getLocationId()!=null) {
				if(warehouseStrategyUpshelf.getLocationIsNotmixBatch().equals(EnumYesOrNo.YES.getValue())){
					//查询货位是否为空
					List<BarcodeMain> barcodeMains=new ArrayList<BarcodeMain>();
					BarcodeMainParamVo barcodeMainParamVo=new BarcodeMainParamVo();
					barcodeMainParamVo.setLocationId(locationId);
					barcodeMainParamVo.setBarcodeStatusDictId(EnumBarcodeStatus.INSTORE.getValue());
					barcodeMains=barcodeMainDao.selectListByParamVo(barcodeMainParamVo);
					
					
					if(barcodeMains.size()>0){
						for (BarcodeMain barcodeMain : barcodeMains) {
							if(!barcodeMain.getProductId().equals(barcodeList.get(0).getProductId())){
								 resultCode=8;
								 break;
							}
						  }
						}else{
							 resultCode=0;
						}
				}
			}
			
			//判断库位是否必须有相同批次
			if (resultCode==0 && warehouseStrategyUpshelf.getLocationId()!=null) {
				if(warehouseStrategyUpshelf.getLocationIsSameBatch().equals(EnumYesOrNo.YES.getValue())){
					//查询货位是否为空
					List<BarcodeMain> barcodeMains=new ArrayList<BarcodeMain>();
					BarcodeMainParamVo barcodeMainParamVo=new BarcodeMainParamVo();
					barcodeMainParamVo.setLocationId(locationId);
					barcodeMainParamVo.setBatchNumber(barcodeList.get(0).getBatchNumber());
					barcodeMainParamVo.setBarcodeStatusDictId(EnumBarcodeStatus.INSTORE.getValue());
					barcodeMains=barcodeMainDao.selectListByParamVo(barcodeMainParamVo);
					
					
					if(barcodeMains.size()==0){
						 resultCode=9;
					}
					else{
						 resultCode=0;
					}
				}
			}
			
			//判断库位是否必须有相同物品
			if (resultCode==0 && warehouseStrategyUpshelf.getLocationId()!=null) {
				if(warehouseStrategyUpshelf.getLocationIsSameBatch().equals(EnumYesOrNo.YES.getValue())){
					//查询货位是否为空
					List<BarcodeMain> barcodeMains=new ArrayList<BarcodeMain>();
					BarcodeMainParamVo barcodeMainParamVo=new BarcodeMainParamVo();
					barcodeMainParamVo.setLocationId(locationId);
					barcodeMainParamVo.setProductId(barcodeList.get(0).getProductId());
					barcodeMainParamVo.setBarcodeStatusDictId(EnumBarcodeStatus.INSTORE.getValue());
					barcodeMains=barcodeMainDao.selectListByParamVo(barcodeMainParamVo);
					
					
					if(barcodeMains.size()==0){
						 resultCode=10;
					}
					else{
						 resultCode=0;
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		return resultCode;
	}


	public String getBarcode() {
		return barcode;
	}


	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}


	public Long getWarehouseId() {
		return warehouseId;
	}


	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}


	public Long getLocationId() {
		return locationId;
	}


	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}


	public Long getStrategyCode() {
		return strategyCode;
	}


	public void setStrategyCode(Long strategyCode) {
		this.strategyCode = strategyCode;
	}


	public int getResultCode() {
		return resultCode;
	}


	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}


	public WarehouseStrategyUpshelfDao getWarehouseStrategyUpshelfDao() {
		return warehouseStrategyUpshelfDao;
	}


	public void setWarehouseStrategyUpshelfDao(WarehouseStrategyUpshelfDao warehouseStrategyUpshelfDao) {
		this.warehouseStrategyUpshelfDao = warehouseStrategyUpshelfDao;
	}


	public WarehouseLocationDao getWarehouseLocationDao() {
		return warehouseLocationDao;
	}


	public void setWarehouseLocationDao(WarehouseLocationDao warehouseLocationDao) {
		this.warehouseLocationDao = warehouseLocationDao;
	}


	public BarcodeMainDao getBarcodeMainDao() {
		return barcodeMainDao;
	}


	public void setBarcodeMainDao(BarcodeMainDao barcodeMainDao) {
		this.barcodeMainDao = barcodeMainDao;
	}


				
}
