package com.techsoft.client.service.quality;

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
import com.techsoft.entity.common.QualityInspectItem;
import com.techsoft.entity.common.QualityInspectType;
import com.techsoft.entity.quality.QualityInspectItemParamVo;
import com.techsoft.entity.quality.QualityInspectItemVo;
import com.techsoft.service.quality.QualityInspectItemService;
import com.techsoft.service.quality.QualityInspectTypeService;

@org.springframework.stereotype.Service
public class ClientQualityInspectItemServiceImpl extends BaseClientServiceImpl<QualityInspectItem>
		implements ClientQualityInspectItemService {
	@com.alibaba.dubbo.config.annotation.Reference
	private QualityInspectItemService qualityInspectItemService;
	@com.alibaba.dubbo.config.annotation.Reference
	private QualityInspectTypeService qualityInspectTypeService;

	@Override
	public BaseService<QualityInspectItem> getBaseService() {
		return qualityInspectItemService;
	}

	private QualityInspectItemVo getVo(QualityInspectItem qualityInspectItem, CommonParam commonParam)
			throws BusinessException, SQLException {
		QualityInspectItemVo vo = new QualityInspectItemVo(qualityInspectItem);
		
		// 检验类型名称
		if (vo.getInspectTypeId() != null && vo.getInspectTypeId() > 0L) {
			QualityInspectType inspectType = qualityInspectTypeService.selectById(vo.getInspectTypeId(), commonParam);
			if (inspectType != null) {
				vo.setQualityInspectTypeVo(inspectType);
			}
		}
		
		// 检验项父名称
		if (vo.getParentId() != null) {
			QualityInspectItem inspectItem = qualityInspectItemService.selectById(vo.getParentId(), commonParam);
			if (inspectItem != null) {
				vo.setQualityInspectItemVo(inspectItem);
			}
		}
		return vo;
	}

	private QualityInspectItemVo getExtendVo(QualityInspectItem qualityInspectItem, CommonParam commonParam)
			throws BusinessException, SQLException {
		QualityInspectItemVo vo = this.getVo(qualityInspectItem, commonParam);

		return vo;
	}

	private List<QualityInspectItemVo> getVoList(List<QualityInspectItem> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<QualityInspectItemVo> voList = new ArrayList<QualityInspectItemVo>();
		for (QualityInspectItem entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<QualityInspectItemVo> getExtendVoList(List<QualityInspectItem> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<QualityInspectItemVo> voList = new ArrayList<QualityInspectItemVo>();
		for (QualityInspectItem entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public QualityInspectItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		QualityInspectItem entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<QualityInspectItemVo> selectListVoByParamVo(QualityInspectItemParamVo qualityInspectItem,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (qualityInspectItem == null) {
			qualityInspectItem = new QualityInspectItemParamVo();
		}
		qualityInspectItem.setTenantId(commonParam.getTenantId());

		List<QualityInspectItem> list = (List<QualityInspectItem>) this.getBaseService()
				.selectListByParamVo(qualityInspectItem, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<QualityInspectItemVo> selectPageVoByParamVo(QualityInspectItemParamVo qualityInspectItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (qualityInspectItem == null) {
			qualityInspectItem = new QualityInspectItemParamVo();
		}
		qualityInspectItem.setTenantId(commonParam.getTenantId());

		PageInfo<QualityInspectItem> list = (PageInfo<QualityInspectItem>) this.getBaseService()
				.selectPageByParamVo(qualityInspectItem, commonParam, pageNo, pageSize);
		List<QualityInspectItemVo> volist = new ArrayList<QualityInspectItemVo>();

		Iterator<QualityInspectItem> iter = list.getList().iterator();
		QualityInspectItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<QualityInspectItemVo> vpage = new Page<QualityInspectItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public QualityInspectItemVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		QualityInspectItem entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<QualityInspectItemVo> selectListExtendVoByParamVo(QualityInspectItemParamVo qualityInspectItem,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (qualityInspectItem == null) {
			qualityInspectItem = new QualityInspectItemParamVo();
		}
		qualityInspectItem.setTenantId(commonParam.getTenantId());

		List<QualityInspectItem> list = (List<QualityInspectItem>) this.getBaseService()
				.selectListByParamVo(qualityInspectItem, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<QualityInspectItemVo> selectPageExtendVoByParamVo(QualityInspectItemParamVo qualityInspectItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (qualityInspectItem == null) {
			qualityInspectItem = new QualityInspectItemParamVo();
		}
		qualityInspectItem.setTenantId(commonParam.getTenantId());

		PageInfo<QualityInspectItem> list = (PageInfo<QualityInspectItem>) this.getBaseService()
				.selectPageByParamVo(qualityInspectItem, commonParam, pageNo, pageSize);
		List<QualityInspectItemVo> volist = new ArrayList<QualityInspectItemVo>();

		Iterator<QualityInspectItem> iter = list.getList().iterator();
		QualityInspectItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<QualityInspectItemVo> vpage = new Page<QualityInspectItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(QualityInspectItemParamVo qualityInspectItemParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		QualityInspectItem qualityInspectItem = null;
		try {
			if (qualityInspectItemParamVo.getId() == null) {// 新增

				qualityInspectItemParamVo.setTenantId(commonParam.getTenantId());
				qualityInspectItem = qualityInspectItemService.saveOrUpdate(qualityInspectItemParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				QualityInspectItem qualityInspectItemVoTemp = this.selectById(qualityInspectItemParamVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(qualityInspectItemVoTemp, qualityInspectItemParamVo);

				qualityInspectItem = qualityInspectItemService.saveOrUpdate(qualityInspectItemVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(qualityInspectItem);
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
