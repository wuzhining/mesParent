package com.techsoft.service.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.entity.barcode.BarcodeMainVo;
import com.techsoft.entity.common.WarehouseLocationStock;
import com.techsoft.entity.warehouse.WarehouseLocationStockVo;
import com.techsoft.dao.warehouse.WarehouseLocationStockDao;

@Service
public class WarehouseLocationStockServiceImpl extends BaseServiceImpl<WarehouseLocationStock> implements WarehouseLocationStockService {
	@Autowired
	private WarehouseLocationStockDao warehouseLocationStockDao;
	
	@Override
	public BaseDao<WarehouseLocationStock> getBaseDao() {
		return warehouseLocationStockDao;
	}	
	
	@Override
	public Class<WarehouseLocationStock> getEntityClass() {
		return WarehouseLocationStock.class;
	}
	
	@Override
	protected WarehouseLocationStock insertEntity(WarehouseLocationStock entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected WarehouseLocationStock updatePartEntity(WarehouseLocationStock entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected WarehouseLocationStock updateEntity(WarehouseLocationStock entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}		
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WarehouseLocationStockVo> selectPageByParamVo(WarehouseLocationStockVo Vo, CommonParam commonParam, int pageNo, int pageSize)
			throws SQLException {
		Page<WarehouseLocationStockVo> list = warehouseLocationStockDao.selectPageByParamVo(Vo, pageNo, pageSize);

		Page<WarehouseLocationStockVo> vpage = new Page<WarehouseLocationStockVo>();
		vpage.addAll(list);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}
}
