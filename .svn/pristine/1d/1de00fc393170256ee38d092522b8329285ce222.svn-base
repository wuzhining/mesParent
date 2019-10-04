package com.techsoft.entity.product;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.common.ProductClasses;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.WarehouseStrategyDownshelf;
import com.techsoft.entity.common.WarehouseStrategyUpshelf;

public class ProductMaterialVo extends ProductMaterial {
	private static final long serialVersionUID = 505744775745102830L;
	private ProductMain productMain;//物品主类
	private FirmPartner firmPartner;//供应商
	private ConfigDictionary  productType;//物品类型名称数据字典
	private ConfigDictionary  materialStatus;//实物状态名称数据字典
	private ConfigDictionary  stockUnitDict;//库存单位
	private ConfigDictionary  workUnitDict;//生产单位
	private ProductClasses productClasses;//物品类型
	private StructWarehouse structWarehouse;//仓库
	private String sku;//物料规格值通用格式
	private WarehouseStrategyDownshelf warehouseStrategyDownshelf;//下架策略
	private WarehouseStrategyUpshelf warehouseStrategyUpshelf;//下架策略
	public WarehouseStrategyDownshelf getWarehouseStrategyDownshelf() {
		return warehouseStrategyDownshelf;
	}

	public void setWarehouseStrategyDownshelf(WarehouseStrategyDownshelf warehouseStrategyDownshelf) {
		this.warehouseStrategyDownshelf = warehouseStrategyDownshelf;
	}

	public WarehouseStrategyUpshelf getWarehouseStrategyUpshelf() {
		return warehouseStrategyUpshelf;
	}

	public void setWarehouseStrategyUpshelf(WarehouseStrategyUpshelf warehouseStrategyUpshelf) {
		this.warehouseStrategyUpshelf = warehouseStrategyUpshelf;
	}

	public ProductMain getProductMain() {
		return productMain;
	}

	public void setProductMain(ProductMain productMain) {
		this.productMain = productMain;
	}

	public FirmPartner getFirmPartner() {
		return firmPartner;
	}

	public void setFirmPartner(FirmPartner firmPartner) {
		this.firmPartner = firmPartner;
	}

	public ProductMaterialVo() {	
	}
	
	public ProductMaterialVo(ProductMaterial value) {
		value.cloneProperties(this);
	}

	public ProductClasses getProductClasses() {
		return productClasses;
	}

	public void setProductClasses(ProductClasses productClasses) {
		this.productClasses = productClasses;
	}

	public ConfigDictionary getProductType() {
		return productType;
	}

	public void setProductType(ConfigDictionary productType) {
		this.productType = productType;
	}

	public StructWarehouse getStructWarehouse() {
		return structWarehouse;
	}

	public void setStructWarehouse(StructWarehouse structWarehouse) {
		this.structWarehouse = structWarehouse;
	}

	public ConfigDictionary getMaterialStatus() {
		return materialStatus;
	}

	public void setMaterialStatus(ConfigDictionary materialStatus) {
		this.materialStatus = materialStatus;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getSku() {
		if(StringUtils.isNotBlank(super.getSkuValue())){
				//String str=super.getSkuValue();
				String skuValue =super.getSkuValue();
				if(skuValue!=null&&skuValue!=""){
					skuValue = skuValue.replace("\",\"value\":\"", ":");
					skuValue = skuValue.replace("\"},{\"name\":\"", ",");
					skuValue = skuValue.replace("{\"name\":\"", "");
					skuValue = skuValue.replace("[", "");
					skuValue = skuValue.replace("\"}", "");
					skuValue = skuValue.replace("]", "");
				}
				// JSONArray json = JSON.parseArray(str); // 首先把字符串转成 JSONArray  对象
				 	
				/* String skuStr="";
				if(json.size()>0){
				  for(int i=0;i<json.size();i++){
				    JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
				    skuStr+=job.get("name")+":"+job.get("value");
				    if(json.size()>0&&i!=json.size()-1){
				    	skuStr+=","; 
				    }
				    
				  }
				}*/
			
				sku=skuValue;
				//sku=skuStr;
			 
		}else{
			sku="";
		}
		return sku;
	}

	public ConfigDictionary getStockUnitDict() {
		return stockUnitDict;
	}

	public void setStockUnitDict(ConfigDictionary stockUnitDict) {
		this.stockUnitDict = stockUnitDict;
	}

	public ConfigDictionary getWorkUnitDict() {
		return workUnitDict;
	}

	public void setWorkUnitDict(ConfigDictionary workUnitDict) {
		this.workUnitDict = workUnitDict;
	}
	

		
}
