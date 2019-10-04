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

import com.techsoft.entity.common.QualitySampleLevel;
import com.techsoft.entity.quality.QualitySampleLevelVo;
import com.techsoft.entity.quality.QualitySampleLevelParamVo;
import com.techsoft.service.quality.QualitySampleLevelService;

@org.springframework.stereotype.Service
public class ClientQualitySampleLevelServiceImpl extends BaseClientServiceImpl<QualitySampleLevel>
		implements ClientQualitySampleLevelService {
	@com.alibaba.dubbo.config.annotation.Reference
	private QualitySampleLevelService qualitySampleLevelService;

	@Override
	public BaseService<QualitySampleLevel> getBaseService() {
		return qualitySampleLevelService;
	}

	private QualitySampleLevelVo getVo(QualitySampleLevel qualitySampleLevel, CommonParam commonParam)
			throws BusinessException, SQLException {
		QualitySampleLevelVo vo = new QualitySampleLevelVo(qualitySampleLevel);

		return vo;
	}

	private QualitySampleLevelVo getExtendVo(QualitySampleLevel qualitySampleLevel, CommonParam commonParam)
			throws BusinessException, SQLException {
		QualitySampleLevelVo vo = this.getVo(qualitySampleLevel, commonParam);

		return vo;
	}

	private List<QualitySampleLevelVo> getVoList(List<QualitySampleLevel> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<QualitySampleLevelVo> voList = new ArrayList<QualitySampleLevelVo>();
		for (QualitySampleLevel entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<QualitySampleLevelVo> getExtendVoList(List<QualitySampleLevel> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<QualitySampleLevelVo> voList = new ArrayList<QualitySampleLevelVo>();
		for (QualitySampleLevel entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public QualitySampleLevelVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		QualitySampleLevel entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<QualitySampleLevelVo> selectListVoByParamVo(QualitySampleLevelParamVo qualitySampleLevel,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (qualitySampleLevel == null) {
			qualitySampleLevel = new QualitySampleLevelParamVo();
		}
		qualitySampleLevel.setTenantId(commonParam.getTenantId());

		List<QualitySampleLevel> list = (List<QualitySampleLevel>) this.getBaseService()
				.selectListByParamVo(qualitySampleLevel, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<QualitySampleLevelVo> selectPageVoByParamVo(QualitySampleLevelParamVo qualitySampleLevel,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (qualitySampleLevel == null) {
			qualitySampleLevel = new QualitySampleLevelParamVo();
		}
		qualitySampleLevel.setTenantId(commonParam.getTenantId());

		PageInfo<QualitySampleLevel> list = (PageInfo<QualitySampleLevel>) this.getBaseService()
				.selectPageByParamVo(qualitySampleLevel, commonParam, pageNo, pageSize);
		List<QualitySampleLevelVo> volist = new ArrayList<QualitySampleLevelVo>();

		Iterator<QualitySampleLevel> iter = list.getList().iterator();
		QualitySampleLevelVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<QualitySampleLevelVo> vpage = new Page<QualitySampleLevelVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public QualitySampleLevelVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		QualitySampleLevel entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<QualitySampleLevelVo> selectListExtendVoByParamVo(QualitySampleLevelParamVo qualitySampleLevel,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (qualitySampleLevel == null) {
			qualitySampleLevel = new QualitySampleLevelParamVo();
		}
		qualitySampleLevel.setTenantId(commonParam.getTenantId());

		List<QualitySampleLevel> list = (List<QualitySampleLevel>) this.getBaseService()
				.selectListByParamVo(qualitySampleLevel, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<QualitySampleLevelVo> selectPageExtendVoByParamVo(QualitySampleLevelParamVo qualitySampleLevel,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (qualitySampleLevel == null) {
			qualitySampleLevel = new QualitySampleLevelParamVo();
		}
		qualitySampleLevel.setTenantId(commonParam.getTenantId());

		PageInfo<QualitySampleLevel> list = (PageInfo<QualitySampleLevel>) this.getBaseService()
				.selectPageByParamVo(qualitySampleLevel, commonParam, pageNo, pageSize);
		List<QualitySampleLevelVo> volist = new ArrayList<QualitySampleLevelVo>();

		Iterator<QualitySampleLevel> iter = list.getList().iterator();
		QualitySampleLevelVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<QualitySampleLevelVo> vpage = new Page<QualitySampleLevelVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(QualitySampleLevelParamVo qualitySampleLevelParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		QualitySampleLevel qualitySampleLevel = null;
		try {
			if (qualitySampleLevelParamVo.getId() == null) {// 新增

				qualitySampleLevelParamVo.setTenantId(commonParam.getTenantId());
				qualitySampleLevel = qualitySampleLevelService.saveOrUpdate(qualitySampleLevelParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				QualitySampleLevel qualitySampleLevelVoTemp = this.selectById(qualitySampleLevelParamVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(qualitySampleLevelVoTemp, qualitySampleLevelParamVo);

				qualitySampleLevel = qualitySampleLevelService.saveOrUpdate(qualitySampleLevelVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(qualitySampleLevel);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultMessage;
	}
	
	/**
	 *@auther :Yang
	 *@version :2019年7月11日
	 *@param
	 *@return
	 *@description
	 */
	@Override
	public ResultMessage saveBatchSampleLevel(QualitySampleLevelParamVo qualitySampleLevelParamVo, CommonParam commonParam,List<QualitySampleLevel> itemList) {
		
		ResultMessage resultMessage = new ResultMessage();
		QualitySampleLevel qualitySampleLevel = null;
		try {
			if (qualitySampleLevelParamVo.getId() == null) {// 新增
				qualitySampleLevelService.deleteQualitySampleLevel();
				qualitySampleLevelParamVo.setTenantId(commonParam.getTenantId());
				qualitySampleLevel = qualitySampleLevelService.saveBatchInsert(qualitySampleLevelParamVo, commonParam,itemList);
				resultMessage.setIsSuccess(true);
			} else { // 修改时相对于重新插入新的数据，先把表里的数据先删除
				qualitySampleLevelService.deleteQualitySampleLevel();
				qualitySampleLevelParamVo.setTenantId(commonParam.getTenantId());
				qualitySampleLevel = qualitySampleLevelService.saveBatchInsert(qualitySampleLevelParamVo, commonParam,itemList);
				resultMessage.setIsSuccess(true);
			}
			resultMessage.setBaseEntity(qualitySampleLevel);
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
	public List<QualitySampleLevelVo> selectSampleLetter() throws BusinessException, SQLException {
		
		return qualitySampleLevelService.selectSampleLetter();
	}
}
