package com.techsoft.service.warehouse;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumYesOrNo;
import com.techsoft.dao.warehouse.WarehouseLocationDao;
import com.techsoft.dao.warehouse.WarehouseRackDao;
import com.techsoft.entity.common.WarehouseLocation;
import com.techsoft.entity.common.WarehouseRack;
import com.techsoft.entity.warehouse.WarehouseRackParamVo;

@Service
public class WarehouseRackServiceImpl extends BaseServiceImpl<WarehouseRack> implements WarehouseRackService {
	@Autowired
	private WarehouseRackDao warehouseRackDao;
	@Autowired
	private WarehouseLocationDao warehouseLocationDao;

	@Override
	public BaseDao<WarehouseRack> getBaseDao() {
		return warehouseRackDao;
	}

	@Override
	public Class<WarehouseRack> getEntityClass() {
		return WarehouseRack.class;
	}

	private List<WarehouseLocation> buildLocationsByRack(WarehouseRack paramVo,WarehouseRackParamVo warehouseRackParamVo, CommonParam commonParam) {
		Integer index = 0;
		String idString = "";
		Long idLong = 0L;	
		String locationi = "";
		String locationj = "";		
		List<WarehouseLocation> Locations = new ArrayList<WarehouseLocation>();
		DecimalFormat df = new DecimalFormat("00");	
		DecimalFormat locationdf = new DecimalFormat("000000");
		Long locationId = warehouseLocationDao.getIdValue();
		for (int i = 1; i <= paramVo.getNumberLine(); i++) {
			for (int j = 1; j <= paramVo.getNumberColumn(); j++) {
				index++;
				WarehouseLocation warehouseLocation = new WarehouseLocation();
				warehouseLocation.setRackId(paramVo.getId());
				locationi = df.format(i);
				locationj = df.format(j);
				idString = locationdf.format(index);
				idLong = Long.valueOf(locationId.toString() + idString);				
				warehouseLocation.setTenantId(commonParam.getTenantId());
				warehouseLocation.setLocationCode(paramVo.getRackCode() + locationi + locationj);
				warehouseLocation.setLocationName(paramVo.getRackCode() + locationi + locationj);
				warehouseLocation.setFactoryId(paramVo.getFactoryId());
				warehouseLocation.setWarehouseId(paramVo.getWarehouseId());
				warehouseLocation.setSerialColumn(j);
				warehouseLocation.setSerialLine(i);
				warehouseLocation.setId(idLong);
				warehouseLocation.setProductTypeDictId(paramVo.getProductTypeDictId());
				warehouseLocation.setLocationTypeDictId(warehouseRackParamVo.getLocationTypeDictId());

				warehouseLocation.setAreaId(paramVo.getAreaId());
				warehouseLocation.setIsValid(EnumYesOrNo.YES.getValue());
				warehouseLocation.setCoordinateX(0);   
				warehouseLocation.setCoordinateY(j);
				warehouseLocation.setCoordinateZ(i);
				
				warehouseLocation.setLimitVolume(warehouseRackParamVo.getLimitVolume());
				warehouseLocation.setLimitWeight(warehouseRackParamVo.getLimitWeight());
				warehouseLocation.setLimitQuantity(warehouseRackParamVo.getLimitQuantity());
				warehouseLocation.setLimitQuantityBox(warehouseRackParamVo.getLimitQuantityBox());
				warehouseLocation.setLimitQuantityPallet(warehouseRackParamVo.getLimitQuantityPallet());
				
				warehouseLocation.setSizeLength(warehouseRackParamVo.getSizeLength());
				warehouseLocation.setSizeHeight(warehouseRackParamVo.getSizeHeight());
				warehouseLocation.setSizeWidth(warehouseRackParamVo.getSizeWidth());   
				warehouseLocation.setIsMixProduct(warehouseRackParamVo.getIsMixProduct());
				     
				warehouseLocation.setIsMixBatch(warehouseRackParamVo.getIsMixBatch());

				Locations.add(warehouseLocation);
			}
		}	
		
		return Locations;
	}
	
	@Override
	protected WarehouseRack insertEntity(WarehouseRack entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected WarehouseRack updatePartEntity(WarehouseRack entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected WarehouseRack updateEntity(WarehouseRack entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}
	
	
	
	
	@Override
	public WarehouseRack insertEntity(WarehouseRackParamVo entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		Long rackId = warehouseRackDao.getIdValue();
		entity.setId(rackId);
		WarehouseRack result = super.insertEntity(entity, commonParam);
		// 根据货架的列数和层次生成货位数据
		List<WarehouseLocation> locations = buildLocationsByRack(result,entity, commonParam);
		warehouseLocationDao.insertBatch(locations, commonParam);
		
		return result;
	}
	

	
}
