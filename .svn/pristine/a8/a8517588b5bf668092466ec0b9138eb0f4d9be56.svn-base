package com.techsoft.service.barcode;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.dao.barcode.BarcodeMainDao;
import com.techsoft.dao.bill.BillWarehouseDao;
import com.techsoft.dao.bill.BillWarehouseItemDao;
import com.techsoft.dao.product.ProductMaterialDao;
import com.techsoft.dao.struct.StructWarehouseDao;
import com.techsoft.dao.track.TrackBarcodeDao;
import com.techsoft.dao.track.TrackBarcodeUnpackDao;
import com.techsoft.dao.warehouse.WarehouseLocationDao;
import com.techsoft.entity.barcode.BarcodeMainParamVo;
import com.techsoft.entity.barcode.BarcodeMainVo;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.TrackBarcode;
import com.techsoft.entity.common.WarehouseLocation;
import com.techsoft.mapper.product.ProductMaterialMapper;

@Service
public class BarcodeMainServiceImpl extends BaseServiceImpl<BarcodeMain> implements BarcodeMainService {
	@Autowired
	private BarcodeMainDao barcodeMainDao;
	@Autowired
	private TrackBarcodeDao trackBarcodeDao;
	@Autowired
	private BillWarehouseItemDao billWarehouseItemDao;
	@Autowired
	private BillWarehouseDao billWarehouseDao;
	@Autowired
	private TrackBarcodeUnpackDao trackBarcodeUnpackDao;
	@Autowired
	private ProductMaterialDao productMaterialDao;
	@Autowired
	private StructWarehouseDao structWarehouseDao;
	@Autowired
	private WarehouseLocationDao warehouseLocationDao;
	

	@Override
	public BaseDao<BarcodeMain> getBaseDao() {
		return barcodeMainDao;
	}

	@Override
	public Class<BarcodeMain> getEntityClass() {
		return BarcodeMain.class;
	}

	@Override
	protected BarcodeMain insertEntity(BarcodeMain entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected BarcodeMain updatePartEntity(BarcodeMain entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected BarcodeMain updateEntity(BarcodeMain entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	public int insertPrintBarcodeMain(BarcodeMainParamVo barcodeMainParamVo, CommonParam commonParam)
			throws BusinessException, SQLException {

		int result = barcodeMainDao.insertPrintBarcodeMain(barcodeMainParamVo.getBarcodeMainVoList(), commonParam);
		return result;
	}

	@Override
	public Double selectSumQtyByEntity(BarcodeMainParamVo paramVo, CommonParam commonParam)
			throws BusinessException, SQLException {
		Double sumQty = barcodeMainDao.selectSumQtyByEntity(paramVo, commonParam);
		return sumQty;
	}


	@Override
	public BarcodeMain updateBatch(List<BarcodeMain> everybarList, CommonParam commonParam) throws BusinessException, SQLException {
		 barcodeMainDao.updateBatch(everybarList, commonParam);
		return null;
	}
	
	@Override
	public List<BarcodeMainVo> selectSumQtyByCondition(BarcodeMainParamVo paramVo)throws BusinessException, SQLException {

		//根据条件汇总数量
		List<BarcodeMainVo> VoList =new ArrayList<BarcodeMainVo>();
		List<BarcodeMainVo> returnList =new ArrayList<BarcodeMainVo>();
		returnList=barcodeMainDao.selectSumQtyByCondition(paramVo);
		for (BarcodeMainVo barcodeMainVo : returnList) {
			if (barcodeMainVo.getMaterialId() != null && barcodeMainVo.getMaterialId() > 0L) {
				ProductMaterial productMaterial = productMaterialDao.selectById(barcodeMainVo.getMaterialId());
				barcodeMainVo.setMaterialName(productMaterial.getMaterialName());
			}
			if (barcodeMainVo.getWarehouseId() != null && barcodeMainVo.getWarehouseId() > 0L) {
				StructWarehouse warehouse = structWarehouseDao.selectById(barcodeMainVo.getWarehouseId());
				barcodeMainVo.setWarehouseName(warehouse.getWarehouseName());
			}
			if (barcodeMainVo.getLocationId() != null && barcodeMainVo.getLocationId() > 0L) {
				WarehouseLocation location = warehouseLocationDao.selectById(barcodeMainVo.getLocationId());
				barcodeMainVo.setLocationName(location.getLocationName());
			}
			VoList.add(barcodeMainVo);
		}
		
		
		return VoList;
	}

	@Override
	public BarcodeMain getByCode(String code, CommonParam commonParam) throws BusinessException, SQLException {
		List<BarcodeMain> list = new ArrayList<BarcodeMain>();
		BarcodeMainParamVo barcodeMain = new BarcodeMainParamVo();
		barcodeMain.setTenantId(commonParam.getTenantId());
		barcodeMain.setBarcode(code);
		list = barcodeMainDao.selectListByParamVo(barcodeMain);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
