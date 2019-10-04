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
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.WarehouseArea;
import com.techsoft.entity.common.WarehouseLocation;
import com.techsoft.entity.common.WarehouseRack;
import com.techsoft.entity.warehouse.WarehouseLocationParamVo;
import com.techsoft.entity.warehouse.WarehouseLocationVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.product.ProductClassesService;
import com.techsoft.service.product.ProductMaterialService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructWarehouseService;
import com.techsoft.service.warehouse.WarehouseAreaService;
import com.techsoft.service.warehouse.WarehouseLocationService;
import com.techsoft.service.warehouse.WarehouseRackService;

@org.springframework.stereotype.Service
public class ClientWarehouseLocationServiceImpl extends BaseClientServiceImpl<WarehouseLocation>
		implements ClientWarehouseLocationService {
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseLocationService warehouseLocationService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWarehouseService StructWarehouseService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductClassesService ProductClassesService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseRackService WarehouseRackService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMaterialService ProductMaterialService;
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseAreaService warehouseAreaService;

	@Override
	public BaseService<WarehouseLocation> getBaseService() {
		return warehouseLocationService;
	}

	private WarehouseLocationVo getVo(WarehouseLocation warehouseLocation, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehouseLocationVo vo = new WarehouseLocationVo(warehouseLocation);
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
		if (vo.getRackId() != null && vo.getRackId() > 0L) {
			WarehouseRack warehouseRack = WarehouseRackService.selectById(vo.getRackId(), commonParam);
			if (warehouseRack != null) {
				vo.setWarehouseRack(warehouseRack);
			}
		}
		if (vo.getProductTypeDictId() != null && vo.getProductTypeDictId() > 0L) {
			ConfigDictionary productType = configDictionaryService.selectById(vo.getProductTypeDictId(), commonParam);
			if (productType != null) {
				vo.setProductTypeDic(productType);
			}
		}
		if (vo.getLocationTypeDictId() != null && vo.getLocationTypeDictId() > 0L) {
			ConfigDictionary warehouseType = configDictionaryService.selectById(vo.getLocationTypeDictId(),
					commonParam);
			if (warehouseType != null) {
				vo.setWarehouseTypeDic(warehouseType);
			}
		}

		if (vo.getAreaId() != null && vo.getAreaId() > 0L) {
			WarehouseArea warehouseArea = warehouseAreaService.selectById(vo.getAreaId(), commonParam);
			if (warehouseArea != null) {
				vo.setWarehouseArea(warehouseArea);
			}
		}
		return vo;
	}

	private WarehouseLocationVo getExtendVo(WarehouseLocation warehouseLocation, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehouseLocationVo vo = this.getVo(warehouseLocation, commonParam);

		return vo;
	}

	private List<WarehouseLocationVo> getVoList(List<WarehouseLocation> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<WarehouseLocationVo> voList = new ArrayList<WarehouseLocationVo>();
		for (WarehouseLocation entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<WarehouseLocationVo> getExtendVoList(List<WarehouseLocation> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<WarehouseLocationVo> voList = new ArrayList<WarehouseLocationVo>();
		for (WarehouseLocation entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public WarehouseLocationVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WarehouseLocation entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<WarehouseLocationVo> selectListVoByParamVo(WarehouseLocationParamVo warehouseLocation,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (warehouseLocation == null) {
			warehouseLocation = new WarehouseLocationParamVo();
		}
		warehouseLocation.setTenantId(commonParam.getTenantId());

		List<WarehouseLocation> list = (List<WarehouseLocation>) this.getBaseService()
				.selectListByParamVo(warehouseLocation, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WarehouseLocationVo> selectPageVoByParamVo(WarehouseLocationParamVo warehouseLocation,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (warehouseLocation == null) {
			warehouseLocation = new WarehouseLocationParamVo();
		}
		warehouseLocation.setTenantId(commonParam.getTenantId());

		PageInfo<WarehouseLocation> list = (PageInfo<WarehouseLocation>) this.getBaseService()
				.selectPageByParamVo(warehouseLocation, commonParam, pageNo, pageSize);
		List<WarehouseLocationVo> volist = new ArrayList<WarehouseLocationVo>();

		Iterator<WarehouseLocation> iter = list.getList().iterator();
		WarehouseLocationVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WarehouseLocationVo> vpage = new Page<WarehouseLocationVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public WarehouseLocationVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehouseLocation entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<WarehouseLocationVo> selectListExtendVoByParamVo(WarehouseLocationParamVo warehouseLocation,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (warehouseLocation == null) {
			warehouseLocation = new WarehouseLocationParamVo();
		}
		warehouseLocation.setTenantId(commonParam.getTenantId());

		List<WarehouseLocation> list = (List<WarehouseLocation>) this.getBaseService()
				.selectListByParamVo(warehouseLocation, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WarehouseLocationVo> selectPageExtendVoByParamVo(WarehouseLocationParamVo warehouseLocation,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (warehouseLocation == null) {
			warehouseLocation = new WarehouseLocationParamVo();
		}
		warehouseLocation.setTenantId(commonParam.getTenantId());

		PageInfo<WarehouseLocation> list = (PageInfo<WarehouseLocation>) this.getBaseService()
				.selectPageByParamVo(warehouseLocation, commonParam, pageNo, pageSize);
		List<WarehouseLocationVo> volist = new ArrayList<WarehouseLocationVo>();

		Iterator<WarehouseLocation> iter = list.getList().iterator();
		WarehouseLocationVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WarehouseLocationVo> vpage = new Page<WarehouseLocationVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(WarehouseLocationParamVo warehouseLocationParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		WarehouseLocation warehouseLocation = null;

		if (warehouseLocationParamVo.getLocationCode() == null) {
			resultMessage.addErr("货位编码不能为空");
			return resultMessage;
		}
		if (warehouseLocationParamVo.getLocationName() == null) {
			resultMessage.addErr("货位名称不能为空");
			return resultMessage;
		}
		if (warehouseLocationParamVo.getRackId() == null) {
			resultMessage.addErr("货架编码不能为空");
			return resultMessage;
		}

		if (warehouseLocationParamVo.getSerialColumn() == null) {
			resultMessage.addErr("列数不能为空");
			return resultMessage;
		}
		if (warehouseLocationParamVo.getSerialLine() == null) {
			resultMessage.addErr("层数不能为空");
			return resultMessage;
		}

		try {
			if (warehouseLocationParamVo.getId() == null) {// 新增

				warehouseLocationParamVo.setTenantId(commonParam.getTenantId());
				warehouseLocation = warehouseLocationService.saveOrUpdate(warehouseLocationParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				WarehouseLocation warehouseLocationVoTemp = this.selectById(warehouseLocationParamVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(warehouseLocationVoTemp, warehouseLocationParamVo);

				warehouseLocation = warehouseLocationService.saveOrUpdate(warehouseLocationVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(warehouseLocation);
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
