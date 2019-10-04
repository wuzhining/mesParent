package com.techsoft.client.service.quality;

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

import com.techsoft.entity.common.QualitySampleRuleItem;
import com.techsoft.entity.quality.QualitySampleRuleItemVo;
import com.techsoft.entity.quality.QualitySampleRuleItemParamVo;
import com.techsoft.service.quality.QualitySampleRuleItemService;

@org.springframework.stereotype.Service
public class ClientQualitySampleRuleItemServiceImpl extends BaseClientServiceImpl<QualitySampleRuleItem>
		implements ClientQualitySampleRuleItemService {
	@com.alibaba.dubbo.config.annotation.Reference
	private QualitySampleRuleItemService qualitySampleRuleItemService;

	@Override
	public BaseService<QualitySampleRuleItem> getBaseService() {
		return qualitySampleRuleItemService;
	}

	private QualitySampleRuleItemVo getVo(QualitySampleRuleItem qualitySampleRuleItem, CommonParam commonParam)
			throws BusinessException, SQLException {
		QualitySampleRuleItemVo vo = new QualitySampleRuleItemVo(qualitySampleRuleItem);

		return vo;
	}

	private QualitySampleRuleItemVo getExtendVo(QualitySampleRuleItem qualitySampleRuleItem, CommonParam commonParam)
			throws BusinessException, SQLException {
		QualitySampleRuleItemVo vo = this.getVo(qualitySampleRuleItem, commonParam);

		return vo;
	}

	private List<QualitySampleRuleItemVo> getVoList(List<QualitySampleRuleItem> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<QualitySampleRuleItemVo> voList = new ArrayList<QualitySampleRuleItemVo>();
		for (QualitySampleRuleItem entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<QualitySampleRuleItemVo> getExtendVoList(List<QualitySampleRuleItem> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<QualitySampleRuleItemVo> voList = new ArrayList<QualitySampleRuleItemVo>();
		for (QualitySampleRuleItem entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public QualitySampleRuleItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		QualitySampleRuleItem entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<QualitySampleRuleItemVo> selectListVoByParamVo(QualitySampleRuleItemParamVo qualitySampleRuleItem,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (qualitySampleRuleItem == null) {
			qualitySampleRuleItem = new QualitySampleRuleItemParamVo();
		}
		qualitySampleRuleItem.setTenantId(commonParam.getTenantId());

		List<QualitySampleRuleItem> list = (List<QualitySampleRuleItem>) this.getBaseService()
				.selectListByParamVo(qualitySampleRuleItem, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<QualitySampleRuleItemVo> selectPageVoByParamVo(QualitySampleRuleItemParamVo qualitySampleRuleItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (qualitySampleRuleItem == null) {
			qualitySampleRuleItem = new QualitySampleRuleItemParamVo();
		}
		qualitySampleRuleItem.setTenantId(commonParam.getTenantId());

		PageInfo<QualitySampleRuleItem> list = (PageInfo<QualitySampleRuleItem>) this.getBaseService()
				.selectPageByParamVo(qualitySampleRuleItem, commonParam, pageNo, pageSize);
		List<QualitySampleRuleItemVo> volist = new ArrayList<QualitySampleRuleItemVo>();

		Iterator<QualitySampleRuleItem> iter = list.getList().iterator();
		QualitySampleRuleItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<QualitySampleRuleItemVo> vpage = new Page<QualitySampleRuleItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public QualitySampleRuleItemVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		QualitySampleRuleItem entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<QualitySampleRuleItemVo> selectListExtendVoByParamVo(QualitySampleRuleItemParamVo qualitySampleRuleItem,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (qualitySampleRuleItem == null) {
			qualitySampleRuleItem = new QualitySampleRuleItemParamVo();
		}
		qualitySampleRuleItem.setTenantId(commonParam.getTenantId());

		List<QualitySampleRuleItem> list = (List<QualitySampleRuleItem>) this.getBaseService()
				.selectListByParamVo(qualitySampleRuleItem, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<QualitySampleRuleItemVo> selectPageExtendVoByParamVo(
			QualitySampleRuleItemParamVo qualitySampleRuleItem, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException {
		if (qualitySampleRuleItem == null) {
			qualitySampleRuleItem = new QualitySampleRuleItemParamVo();
		}
		qualitySampleRuleItem.setTenantId(commonParam.getTenantId());

		PageInfo<QualitySampleRuleItem> list = (PageInfo<QualitySampleRuleItem>) this.getBaseService()
				.selectPageByParamVo(qualitySampleRuleItem, commonParam, pageNo, pageSize);
		List<QualitySampleRuleItemVo> volist = new ArrayList<QualitySampleRuleItemVo>();

		Iterator<QualitySampleRuleItem> iter = list.getList().iterator();
		QualitySampleRuleItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<QualitySampleRuleItemVo> vpage = new Page<QualitySampleRuleItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(QualitySampleRuleItemParamVo qualitySampleRuleItemParamVo,
			CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		QualitySampleRuleItem qualitySampleRuleItem = null;
		try {
			if (qualitySampleRuleItemParamVo.getId() == null) {// 新增

				qualitySampleRuleItemParamVo.setTenantId(commonParam.getTenantId());
				qualitySampleRuleItem = qualitySampleRuleItemService.saveOrUpdate(qualitySampleRuleItemParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				QualitySampleRuleItem qualitySampleRuleItemVoTemp = this
						.selectById(qualitySampleRuleItemParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(qualitySampleRuleItemVoTemp, qualitySampleRuleItemParamVo);

				qualitySampleRuleItem = qualitySampleRuleItemService.saveOrUpdate(qualitySampleRuleItemVoTemp,
						commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(qualitySampleRuleItem);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultMessage;
	}

	@Override
	public ResultMessage batchInsertList(QualitySampleRuleItemVo qualitySampleRuleItemVo, CommonParam commonParam,
			List<QualitySampleRuleItem> qualitySampleRuleItem) {

		ResultMessage resultMessage = new ResultMessage();
		QualitySampleRuleItem sampleRuleItem = null;

		try {
			if (qualitySampleRuleItemVo.getId() == null) {// 新增

				qualitySampleRuleItemVo.setTenantId(commonParam.getTenantId());
				sampleRuleItem = qualitySampleRuleItemService.batchInsert(qualitySampleRuleItemVo, commonParam,
						qualitySampleRuleItem);
				resultMessage.setIsSuccess(true);

			} else { // 修改
				QualitySampleRuleItem qualitySampleRuleItemVoTemp = this.selectById(qualitySampleRuleItemVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(qualitySampleRuleItemVoTemp, qualitySampleRuleItemVo);

				sampleRuleItem = qualitySampleRuleItemService.batchUpdate(qualitySampleRuleItemVoTemp, commonParam,
						qualitySampleRuleItem);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(sampleRuleItem);
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
