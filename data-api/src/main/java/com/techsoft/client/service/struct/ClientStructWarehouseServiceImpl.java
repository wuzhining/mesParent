package com.techsoft.client.service.struct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alibaba.dubbo.common.utils.StringUtils;
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
import com.techsoft.entity.common.StructFloor;
import com.techsoft.entity.common.StructWarehouse;
import com.techsoft.entity.struct.StructWarehouseParamVo;
import com.techsoft.entity.struct.StructWarehouseVo;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructFloorService;
import com.techsoft.service.struct.StructWarehouseService;

@org.springframework.stereotype.Service
public class ClientStructWarehouseServiceImpl extends BaseClientServiceImpl<StructWarehouse>
		implements ClientStructWarehouseService {
	@com.alibaba.dubbo.config.annotation.Reference
	private StructWarehouseService structWarehouseService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFloorService structFloorService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;

	@Override
	public BaseService<StructWarehouse> getBaseService() {
		return structWarehouseService;
	}

	private StructWarehouseVo getVo(StructWarehouse structWarehouse, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructWarehouseVo vo = new StructWarehouseVo(structWarehouse);
		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (structFactory != null) {
				vo.setStructFactory(structFactory);
			}
		}
		if (vo.getFloorId() != null && vo.getFloorId() > 0L) {
			StructFloor structFloor = structFloorService.selectById(vo.getFloorId(), commonParam);
			if (structFloor != null) {
				vo.setStructFloor(structFloor);
			}
		}
		if (vo.getProductTypeDictId() != null && vo.getProductTypeDictId() > 0L) {
			ConfigDictionary productType = configDictionaryService.selectById(vo.getProductTypeDictId(), commonParam);
			if (productType != null) {
				vo.setProductTypeDic(productType);
			}
		}
		if (vo.getWarehouseTypeDictId() != null && vo.getWarehouseTypeDictId() > 0L) {
			ConfigDictionary warehouseType = configDictionaryService.selectById(vo.getWarehouseTypeDictId(),
					commonParam);
			if (warehouseType != null) {
				vo.setWarehouseTypeDic(warehouseType);
			}
		}
		return vo;
	}

	private StructWarehouseVo getExtendVo(StructWarehouse structWarehouse, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructWarehouseVo vo = this.getVo(structWarehouse, commonParam);

		return vo;
	}

	private List<StructWarehouseVo> getVoList(List<StructWarehouse> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructWarehouseVo> voList = new ArrayList<StructWarehouseVo>();
		for (StructWarehouse entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<StructWarehouseVo> getExtendVoList(List<StructWarehouse> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructWarehouseVo> voList = new ArrayList<StructWarehouseVo>();
		for (StructWarehouse entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public StructWarehouseVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructWarehouse entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<StructWarehouseVo> selectListVoByParamVo(StructWarehouseParamVo structWarehouse,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (structWarehouse == null) {
			structWarehouse = new StructWarehouseParamVo();
		}
		structWarehouse.setTenantId(commonParam.getTenantId());

		List<StructWarehouse> list = (List<StructWarehouse>) this.getBaseService().selectListByParamVo(structWarehouse,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<StructWarehouseVo> selectPageVoByParamVo(StructWarehouseParamVo structWarehouse,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (structWarehouse == null) {
			structWarehouse = new StructWarehouseParamVo();
		}
		structWarehouse.setTenantId(commonParam.getTenantId());

		PageInfo<StructWarehouse> list = (PageInfo<StructWarehouse>) this.getBaseService()
				.selectPageByParamVo(structWarehouse, commonParam, pageNo, pageSize);
		List<StructWarehouseVo> volist = new ArrayList<StructWarehouseVo>();

		Iterator<StructWarehouse> iter = list.getList().iterator();
		StructWarehouseVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<StructWarehouseVo> vpage = new Page<StructWarehouseVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public StructWarehouseVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructWarehouse entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<StructWarehouseVo> selectListExtendVoByParamVo(StructWarehouseParamVo structWarehouse,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (structWarehouse == null) {
			structWarehouse = new StructWarehouseParamVo();
		}
		structWarehouse.setTenantId(commonParam.getTenantId());

		List<StructWarehouse> list = (List<StructWarehouse>) this.getBaseService().selectListByParamVo(structWarehouse,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<StructWarehouseVo> selectPageExtendVoByParamVo(StructWarehouseParamVo structWarehouse,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (structWarehouse == null) {
			structWarehouse = new StructWarehouseParamVo();
		}
		structWarehouse.setTenantId(commonParam.getTenantId());

		PageInfo<StructWarehouse> list = (PageInfo<StructWarehouse>) this.getBaseService()
				.selectPageByParamVo(structWarehouse, commonParam, pageNo, pageSize);
		List<StructWarehouseVo> volist = new ArrayList<StructWarehouseVo>();

		Iterator<StructWarehouse> iter = list.getList().iterator();
		StructWarehouseVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<StructWarehouseVo> vpage = new Page<StructWarehouseVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(StructWarehouseParamVo structWarehouseParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		StructWarehouse structWarehouse = null;
		/*if (structWarehouseParamVo.getWarehouseCode() == null) {
			resultMessage.addErr("仓库编码不能为空");
			return resultMessage;
		}*/
		if (structWarehouseParamVo.getWarehouseName() == null) {
			resultMessage.addErr("仓库名称不能为空");
			return resultMessage;
		}
		if (structWarehouseParamVo.getFactoryId() == null) {
			resultMessage.addErr("请选择工厂名称");
			return resultMessage;
		}
		if (structWarehouseParamVo.getFloorId() == null) {
			resultMessage.addErr("请选择所属楼层");
			return resultMessage;
		}
		try {
			if (structWarehouseParamVo.getId() == null) {// 新增
				//生成编码
				String code = structWarehouseParamVo.getWarehouseCode();
				if(StringUtils.isBlank(code)){
					code = configCodeRuleService.createCode(StructWarehouse.class.getName(), null, null, commonParam);
					structWarehouseParamVo.setWarehouseCode(code);
				}
				if(StringUtils.isBlank(code)){
					resultMessage.addErr("仓库编码不能为空");
					return resultMessage;
				}
				//检验编码是否已存在
				StructWarehouseParamVo structWarehouseSearch = new StructWarehouseParamVo();
				structWarehouseSearch.setWarehouseCode(code);
				List<StructWarehouse> list = structWarehouseService.selectListByParamVo(structWarehouseSearch, commonParam);
				if((list!=null)&&(!list.isEmpty())){
					resultMessage.addErr("仓库编码已存在");
					return resultMessage;
				}
				structWarehouseParamVo.setTenantId(commonParam.getTenantId());
				structWarehouse = structWarehouseService.saveOrUpdate(structWarehouseParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				StructWarehouse structWarehouseVoTemp = this.selectById(structWarehouseParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(structWarehouseVoTemp, structWarehouseParamVo);

				structWarehouse = structWarehouseService.saveOrUpdate(structWarehouseVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(structWarehouse);
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
