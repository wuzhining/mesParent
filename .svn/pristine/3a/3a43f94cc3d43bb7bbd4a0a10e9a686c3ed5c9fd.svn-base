package com.techsoft.client.service.struct;

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
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructFloor;
import com.techsoft.entity.struct.StructFloorParamVo;
import com.techsoft.entity.struct.StructFloorVo;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.struct.StructFloorService;

@org.springframework.stereotype.Service
public class ClientStructFloorServiceImpl extends BaseClientServiceImpl<StructFloor>
		implements ClientStructFloorService {
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFloorService structFloorService;
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;

	@Override
	public BaseService<StructFloor> getBaseService() {
		return structFloorService;
	}

	private StructFloorVo getVo(StructFloor structFloor, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructFloorVo vo = new StructFloorVo(structFloor);
		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (structFactory != null) {
				vo.setStructFactory(structFactory);
			}
		}
		return vo;
	}

	private StructFloorVo getExtendVo(StructFloor structFloor, CommonParam commonParam)
			throws BusinessException, SQLException {
		StructFloorVo vo = this.getVo(structFloor, commonParam);

		return vo;
	}

	private List<StructFloorVo> getVoList(List<StructFloor> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructFloorVo> voList = new ArrayList<StructFloorVo>();
		for (StructFloor entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<StructFloorVo> getExtendVoList(List<StructFloor> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<StructFloorVo> voList = new ArrayList<StructFloorVo>();
		for (StructFloor entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public StructFloorVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructFloor entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<StructFloorVo> selectListVoByParamVo(StructFloorParamVo structFloor, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (structFloor == null) {
			structFloor = new StructFloorParamVo();
		}
		structFloor.setTenantId(commonParam.getTenantId());

		List<StructFloor> list = (List<StructFloor>) this.getBaseService().selectListByParamVo(structFloor,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<StructFloorVo> selectPageVoByParamVo(StructFloorParamVo structFloor, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (structFloor == null) {
			structFloor = new StructFloorParamVo();
		}
		structFloor.setTenantId(commonParam.getTenantId());

		PageInfo<StructFloor> list = (PageInfo<StructFloor>) this.getBaseService().selectPageByParamVo(structFloor,
				commonParam, pageNo, pageSize);
		List<StructFloorVo> volist = new ArrayList<StructFloorVo>();

		Iterator<StructFloor> iter = list.getList().iterator();
		StructFloorVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<StructFloorVo> vpage = new Page<StructFloorVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public StructFloorVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		StructFloor entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<StructFloorVo> selectListExtendVoByParamVo(StructFloorParamVo structFloor, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (structFloor == null) {
			structFloor = new StructFloorParamVo();
		}
		structFloor.setTenantId(commonParam.getTenantId());

		List<StructFloor> list = (List<StructFloor>) this.getBaseService().selectListByParamVo(structFloor,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<StructFloorVo> selectPageExtendVoByParamVo(StructFloorParamVo structFloor, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (structFloor == null) {
			structFloor = new StructFloorParamVo();
		}
		structFloor.setTenantId(commonParam.getTenantId());

		PageInfo<StructFloor> list = (PageInfo<StructFloor>) this.getBaseService().selectPageByParamVo(structFloor,
				commonParam, pageNo, pageSize);
		List<StructFloorVo> volist = new ArrayList<StructFloorVo>();

		Iterator<StructFloor> iter = list.getList().iterator();
		StructFloorVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<StructFloorVo> vpage = new Page<StructFloorVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(StructFloorParamVo structFloorParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		StructFloor structFloor = null;
		if (structFloorParamVo.getFloorCode() == null) {
			resultMessage.addErr("楼层编码不能为空");
			return resultMessage;
		}
		if (structFloorParamVo.getFloorName() == null) {
			resultMessage.addErr("楼层名不能为空");
			return resultMessage;
		}
		if (structFloorParamVo.getFactoryId() == null) {
			resultMessage.addErr("请选择工厂名称");
			return resultMessage;
		}

		try {
			if (structFloorParamVo.getId() == null) {// 新增

				structFloorParamVo.setTenantId(commonParam.getTenantId());
				structFloor = structFloorService.saveOrUpdate(structFloorParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				StructFloor structFloorVoTemp = this.selectById(structFloorParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(structFloorVoTemp, structFloorParamVo);

				structFloor = structFloorService.saveOrUpdate(structFloorVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(structFloor);
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
