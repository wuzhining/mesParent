package com.techsoft.client.service.warehouse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductClasses;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.WarehouseArea;
import com.techsoft.entity.common.WarehouseRack;
import com.techsoft.entity.warehouse.WarehouseRackParamVo;
import com.techsoft.entity.warehouse.WarehouseRackVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.product.ProductClassesService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructWarehouseService;
import com.techsoft.service.warehouse.WarehouseAreaService;
import com.techsoft.service.warehouse.WarehouseLocationService;
import com.techsoft.service.warehouse.WarehouseRackService;

@org.springframework.stereotype.Service
public class ClientWarehouseRackServiceImpl extends BaseClientServiceImpl<WarehouseRack>
		implements ClientWarehouseRackService {
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseRackService warehouseRackService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWarehouseService StructWarehouseService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService ConfigDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductClassesService ProductClassesService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseLocationService warehouseLocationService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseAreaService warehouseAreaService;
	@Override
	public BaseService<WarehouseRack> getBaseService() {
		return warehouseRackService;
	}

	private WarehouseRackVo getVo(WarehouseRack warehouseRack, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehouseRackVo vo = new WarehouseRackVo(warehouseRack);
		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (structFactory != null) {
				vo.setStructFactory(structFactory);
			}
		}
		if (vo.getWarehouseId() != null && vo.getWarehouseId() > 0L) {
			StructWarehouse structWarehouse = StructWarehouseService.selectById(vo.getWarehouseId(), commonParam);
			if (structWarehouse != null) {
				vo.setStructWarehouse(structWarehouse);
			}
		}
		if (vo.getProductClassesId() != null && vo.getProductClassesId() > 0L) {
			ProductClasses productClasses = ProductClassesService.selectById(vo.getProductClassesId(), commonParam);
			if (productClasses != null) {
				vo.setProductClasses(productClasses);
			}
		}
		if (vo.getProductTypeDictId() != null && vo.getProductTypeDictId() > 0L) {
			ConfigDictionary configDictionary = ConfigDictionaryService.selectById(vo.getProductTypeDictId(),
					commonParam);
			if (configDictionary != null) {
				vo.setConfigDictionary(configDictionary);
			}
		}
		if(vo.getAreaId() != null && vo.getAreaId() > 0L){
			WarehouseArea warehouseArea = warehouseAreaService.selectById(vo.getAreaId(), commonParam);
			if(warehouseArea != null){
				vo.setWarehouseArea(warehouseArea);
			}
		}
		return vo;
	}

	private WarehouseRackVo getExtendVo(WarehouseRack warehouseRack, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehouseRackVo vo = this.getVo(warehouseRack, commonParam);

		return vo;
	}

	private List<WarehouseRackVo> getVoList(List<WarehouseRack> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<WarehouseRackVo> voList = new ArrayList<WarehouseRackVo>();
		for (WarehouseRack entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<WarehouseRackVo> getExtendVoList(List<WarehouseRack> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<WarehouseRackVo> voList = new ArrayList<WarehouseRackVo>();
		for (WarehouseRack entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public WarehouseRackVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WarehouseRack entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<WarehouseRackVo> selectListVoByParamVo(WarehouseRackParamVo warehouseRack, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (warehouseRack == null) {
			warehouseRack = new WarehouseRackParamVo();
		}
		warehouseRack.setTenantId(commonParam.getTenantId());

		List<WarehouseRack> list = (List<WarehouseRack>) this.getBaseService().selectListByParamVo(warehouseRack,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WarehouseRackVo> selectPageVoByParamVo(WarehouseRackParamVo warehouseRack, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (warehouseRack == null) {
			warehouseRack = new WarehouseRackParamVo();
		}
		warehouseRack.setTenantId(commonParam.getTenantId());

		PageInfo<WarehouseRack> list = (PageInfo<WarehouseRack>) this.getBaseService()
				.selectPageByParamVo(warehouseRack, commonParam, pageNo, pageSize);
		List<WarehouseRackVo> volist = new ArrayList<WarehouseRackVo>();

		Iterator<WarehouseRack> iter = list.getList().iterator();
		WarehouseRackVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WarehouseRackVo> vpage = new Page<WarehouseRackVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public WarehouseRackVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WarehouseRack entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<WarehouseRackVo> selectListExtendVoByParamVo(WarehouseRackParamVo warehouseRack,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (warehouseRack == null) {
			warehouseRack = new WarehouseRackParamVo();
		}
		warehouseRack.setTenantId(commonParam.getTenantId());

		List<WarehouseRack> list = (List<WarehouseRack>) this.getBaseService().selectListByParamVo(warehouseRack,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WarehouseRackVo> selectPageExtendVoByParamVo(WarehouseRackParamVo warehouseRack,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (warehouseRack == null) {
			warehouseRack = new WarehouseRackParamVo();
		}
		warehouseRack.setTenantId(commonParam.getTenantId());

		PageInfo<WarehouseRack> list = (PageInfo<WarehouseRack>) this.getBaseService()
				.selectPageByParamVo(warehouseRack, commonParam, pageNo, pageSize);
		List<WarehouseRackVo> volist = new ArrayList<WarehouseRackVo>();

		Iterator<WarehouseRack> iter = list.getList().iterator();
		WarehouseRackVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WarehouseRackVo> vpage = new Page<WarehouseRackVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(WarehouseRackParamVo warehouseRackParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		WarehouseRack warehouseRack = null;

		try {
			if (warehouseRackParamVo.getId() == null) {// 新增

				warehouseRackParamVo.setTenantId(commonParam.getTenantId());

				warehouseRack = warehouseRackService.insertEntity(warehouseRackParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				WarehouseRack warehouseRackVoTemp = this.selectById(warehouseRackParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(warehouseRackVoTemp, warehouseRackParamVo);

				warehouseRack = warehouseRackService.saveOrUpdate(warehouseRackVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(warehouseRack);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultMessage;
	}
}
