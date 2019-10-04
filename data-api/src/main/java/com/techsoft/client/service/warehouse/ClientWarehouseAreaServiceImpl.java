package com.techsoft.client.service.warehouse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.common.WarehouseArea;
import com.techsoft.entity.warehouse.WarehouseAreaVo;
import com.techsoft.entity.warehouse.WarehouseAreaParamVo;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructWarehouseService;
import com.techsoft.service.warehouse.WarehouseAreaService;

@org.springframework.stereotype.Service
public class ClientWarehouseAreaServiceImpl extends BaseClientServiceImpl<WarehouseArea>
		implements ClientWarehouseAreaService {
	@com.alibaba.dubbo.config.annotation.Reference
	private WarehouseAreaService warehouseAreaService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWarehouseService StructWarehouseService;

	@Override
	public BaseService<WarehouseArea> getBaseService() {
		return warehouseAreaService;
	}

	private WarehouseAreaVo getVo(WarehouseArea warehouseArea, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehouseAreaVo vo = new WarehouseAreaVo(warehouseArea);
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
		return vo;
	}

	private WarehouseAreaVo getExtendVo(WarehouseArea warehouseArea, CommonParam commonParam)
			throws BusinessException, SQLException {
		WarehouseAreaVo vo = this.getVo(warehouseArea, commonParam);

		return vo;
	}

	private List<WarehouseAreaVo> getVoList(List<WarehouseArea> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<WarehouseAreaVo> voList = new ArrayList<WarehouseAreaVo>();
		for (WarehouseArea entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<WarehouseAreaVo> getExtendVoList(List<WarehouseArea> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<WarehouseAreaVo> voList = new ArrayList<WarehouseAreaVo>();
		for (WarehouseArea entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public WarehouseAreaVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WarehouseArea entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<WarehouseAreaVo> selectListVoByParamVo(WarehouseAreaParamVo warehouseArea, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (warehouseArea == null) {
			warehouseArea = new WarehouseAreaParamVo();
		}
		warehouseArea.setTenantId(commonParam.getTenantId());

		List<WarehouseArea> list = (List<WarehouseArea>) this.getBaseService().selectListByParamVo(warehouseArea,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WarehouseAreaVo> selectPageVoByParamVo(WarehouseAreaParamVo warehouseArea, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (warehouseArea == null) {
			warehouseArea = new WarehouseAreaParamVo();
		}
		warehouseArea.setTenantId(commonParam.getTenantId());

		PageInfo<WarehouseArea> list = (PageInfo<WarehouseArea>) this.getBaseService()
				.selectPageByParamVo(warehouseArea, commonParam, pageNo, pageSize);
		List<WarehouseAreaVo> volist = new ArrayList<WarehouseAreaVo>();

		Iterator<WarehouseArea> iter = list.getList().iterator();
		WarehouseAreaVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WarehouseAreaVo> vpage = new Page<WarehouseAreaVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public WarehouseAreaVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		WarehouseArea entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<WarehouseAreaVo> selectListExtendVoByParamVo(WarehouseAreaParamVo warehouseArea,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (warehouseArea == null) {
			warehouseArea = new WarehouseAreaParamVo();
		}
		warehouseArea.setTenantId(commonParam.getTenantId());

		List<WarehouseArea> list = (List<WarehouseArea>) this.getBaseService().selectListByParamVo(warehouseArea,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<WarehouseAreaVo> selectPageExtendVoByParamVo(WarehouseAreaParamVo warehouseArea,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (warehouseArea == null) {
			warehouseArea = new WarehouseAreaParamVo();
		}
		warehouseArea.setTenantId(commonParam.getTenantId());

		PageInfo<WarehouseArea> list = (PageInfo<WarehouseArea>) this.getBaseService()
				.selectPageByParamVo(warehouseArea, commonParam, pageNo, pageSize);
		List<WarehouseAreaVo> volist = new ArrayList<WarehouseAreaVo>();

		Iterator<WarehouseArea> iter = list.getList().iterator();
		WarehouseAreaVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<WarehouseAreaVo> vpage = new Page<WarehouseAreaVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(WarehouseAreaParamVo warehouseAreaParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		WarehouseArea warehouseArea = null;
		try { 	
			if (warehouseAreaParamVo.getFactoryId() == null) {
				resultMessage.addErr("工厂名称不能为空");
				return resultMessage;
			}
			if (warehouseAreaParamVo.getWarehouseId() == null) {
				resultMessage.addErr("所属仓库不能为空");
				return resultMessage;
			}
			if (warehouseAreaParamVo.getAreaCode() == null) {
				resultMessage.addErr("区域编码不能为空");
				return resultMessage;
			}			
			if (warehouseAreaParamVo.getAreaName() == null) {
				resultMessage.addErr("区域名称不能为空");
				return resultMessage;
			}

			if (warehouseAreaParamVo.getBaseCoordinateX() == null) {
				resultMessage.addErr("基点坐标X不能为空");
				return resultMessage;
			}
			
			if (warehouseAreaParamVo.getBaseCoordinateY() == null) {
				resultMessage.addErr("基点坐标Y不能为空");
				return resultMessage;
			}
			if (warehouseAreaParamVo.getBaseCoordinateZ() == null) {
				resultMessage.addErr("基点坐标Z不能为空");
				return resultMessage;
			}
			
			if (warehouseAreaParamVo.getId() == null) {// 新增

				warehouseAreaParamVo.setTenantId(commonParam.getTenantId());
				warehouseArea = warehouseAreaService.saveOrUpdate(warehouseAreaParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				WarehouseArea warehouseAreaVoTemp = this.selectById(warehouseAreaParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(warehouseAreaVoTemp, warehouseAreaParamVo);

				warehouseArea = warehouseAreaService.saveOrUpdate(warehouseAreaVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(warehouseArea);
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
