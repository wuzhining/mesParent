package com.techsoft.client.service.equip;

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
import com.techsoft.entity.common.EquipWorkClasses;
import com.techsoft.entity.equip.EquipWorkClassesParamVo;
import com.techsoft.entity.equip.EquipWorkClassesVo;
import com.techsoft.service.equip.EquipWorkClassesService;

@org.springframework.stereotype.Service
public class ClientEquipWorkClassesServiceImpl extends BaseClientServiceImpl<EquipWorkClasses>
		implements ClientEquipWorkClassesService {
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipWorkClassesService equipWorkClassesService;

	@Override
	public BaseService<EquipWorkClasses> getBaseService() {
		return equipWorkClassesService;
	}

	private EquipWorkClassesVo getVo(EquipWorkClasses equipWorkClasses, CommonParam commonParam)
			throws BusinessException, SQLException {
		EquipWorkClassesVo vo = new EquipWorkClassesVo(equipWorkClasses);
		if (vo.getParentId() != null && vo.getParentId() > 0L) {
			EquipWorkClasses equipWorkClasses2 = equipWorkClassesService.selectById(vo.getParentId(), commonParam);
			if (equipWorkClasses2 != null) {
				vo.setEquipWorkClasses(equipWorkClasses2);
			}
		}
		return vo;
	}

	private EquipWorkClassesVo getExtendVo(EquipWorkClasses equipWorkClasses, CommonParam commonParam)
			throws BusinessException, SQLException {
		EquipWorkClassesVo vo = this.getVo(equipWorkClasses, commonParam);

		return vo;
	}

	private List<EquipWorkClassesVo> getVoList(List<EquipWorkClasses> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<EquipWorkClassesVo> voList = new ArrayList<EquipWorkClassesVo>();
		for (EquipWorkClasses entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<EquipWorkClassesVo> getExtendVoList(List<EquipWorkClasses> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<EquipWorkClassesVo> voList = new ArrayList<EquipWorkClassesVo>();
		for (EquipWorkClasses entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public EquipWorkClassesVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		EquipWorkClasses entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<EquipWorkClassesVo> selectListVoByParamVo(EquipWorkClassesParamVo equipWorkClasses,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (equipWorkClasses == null) {
			equipWorkClasses = new EquipWorkClassesParamVo();
		}
		equipWorkClasses.setTenantId(commonParam.getTenantId());

		List<EquipWorkClasses> list = (List<EquipWorkClasses>) this.getBaseService()
				.selectListByParamVo(equipWorkClasses, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<EquipWorkClassesVo> selectPageVoByParamVo(EquipWorkClassesParamVo equipWorkClasses,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (equipWorkClasses == null) {
			equipWorkClasses = new EquipWorkClassesParamVo();
		}
		equipWorkClasses.setTenantId(commonParam.getTenantId());

		PageInfo<EquipWorkClasses> list = (PageInfo<EquipWorkClasses>) this.getBaseService()
				.selectPageByParamVo(equipWorkClasses, commonParam, pageNo, pageSize);
		List<EquipWorkClassesVo> volist = new ArrayList<EquipWorkClassesVo>();

		Iterator<EquipWorkClasses> iter = list.getList().iterator();
		EquipWorkClassesVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<EquipWorkClassesVo> vpage = new Page<EquipWorkClassesVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public EquipWorkClassesVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		EquipWorkClasses entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<EquipWorkClassesVo> selectListExtendVoByParamVo(EquipWorkClassesParamVo equipWorkClasses,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (equipWorkClasses == null) {
			equipWorkClasses = new EquipWorkClassesParamVo();
		}
		equipWorkClasses.setTenantId(commonParam.getTenantId());

		List<EquipWorkClasses> list = (List<EquipWorkClasses>) this.getBaseService()
				.selectListByParamVo(equipWorkClasses, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<EquipWorkClassesVo> selectPageExtendVoByParamVo(EquipWorkClassesParamVo equipWorkClasses,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (equipWorkClasses == null) {
			equipWorkClasses = new EquipWorkClassesParamVo();
		}
		equipWorkClasses.setTenantId(commonParam.getTenantId());

		PageInfo<EquipWorkClasses> list = (PageInfo<EquipWorkClasses>) this.getBaseService()
				.selectPageByParamVo(equipWorkClasses, commonParam, pageNo, pageSize);
		List<EquipWorkClassesVo> volist = new ArrayList<EquipWorkClassesVo>();

		Iterator<EquipWorkClasses> iter = list.getList().iterator();
		EquipWorkClassesVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<EquipWorkClassesVo> vpage = new Page<EquipWorkClassesVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(EquipWorkClassesParamVo equipWorkClassesParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		EquipWorkClasses equipWorkClasses = null;
		try {
			if (equipWorkClassesParamVo.getId() == null) {// 新增

				equipWorkClassesParamVo.setTenantId(commonParam.getTenantId());
				equipWorkClasses = equipWorkClassesService.saveOrUpdate(equipWorkClassesParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				EquipWorkClasses equipWorkClassesVoTemp = this.selectById(equipWorkClassesParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(equipWorkClassesVoTemp, equipWorkClassesParamVo);

				equipWorkClasses = equipWorkClassesService.saveOrUpdate(equipWorkClassesVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(equipWorkClasses);
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
