package com.techsoft.client.service.track;

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
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipFixture;
import com.techsoft.entity.common.TrackFixture;
import com.techsoft.entity.track.TrackFixtureVo;
import com.techsoft.entity.track.TrackFixtureParamVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.equip.EquipFixtureService;
import com.techsoft.service.track.TrackFixtureService;

@org.springframework.stereotype.Service
public class ClientTrackFixtureServiceImpl extends BaseClientServiceImpl<TrackFixture>
		implements ClientTrackFixtureService {
	@com.alibaba.dubbo.config.annotation.Reference
	private TrackFixtureService trackFixtureService;
	@com.alibaba.dubbo.config.annotation.Reference
	private EquipFixtureService equipFixtureService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;

	@Override
	public BaseService<TrackFixture> getBaseService() {
		return trackFixtureService;
	}

	private TrackFixtureVo getVo(TrackFixture trackFixture, CommonParam commonParam)
			throws BusinessException, SQLException {
		TrackFixtureVo vo = new TrackFixtureVo(trackFixture);
		// 工具
		if (vo.getFixtureId() != null && vo.getFixtureId() > 0L) {
			EquipFixture equipFixture = equipFixtureService.selectById(vo.getFixtureId(), commonParam);
			if (equipFixture != null) {
				vo.setEquipFixture(equipFixture);
			}
		}
		// 单据类型
		if (vo.getBillTypeFixtureDictId() != null && vo.getBillTypeFixtureDictId() > 0L) {
			ConfigDictionary configDictionary = configDictionaryService.selectById(vo.getBillTypeFixtureDictId(),
					commonParam);
			if (configDictionary != null) {
				vo.setConfigDictionary(configDictionary);
			}
		}
		// 状态
		if (vo.getBillStatusDictId() != null && vo.getBillStatusDictId() > 0L) {
			ConfigDictionary configDictionaryStatus = configDictionaryService.selectById(vo.getBillStatusDictId(),
					commonParam);
			if (configDictionaryStatus != null) {
				vo.setConfigDictionaryStatus(configDictionaryStatus);
			}
		}
		return vo;
	}

	private TrackFixtureVo getExtendVo(TrackFixture trackFixture, CommonParam commonParam)
			throws BusinessException, SQLException {
		TrackFixtureVo vo = this.getVo(trackFixture, commonParam);

		return vo;
	}

	private List<TrackFixtureVo> getVoList(List<TrackFixture> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<TrackFixtureVo> voList = new ArrayList<TrackFixtureVo>();
		for (TrackFixture entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<TrackFixtureVo> getExtendVoList(List<TrackFixture> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<TrackFixtureVo> voList = new ArrayList<TrackFixtureVo>();
		for (TrackFixture entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public TrackFixtureVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		TrackFixture entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<TrackFixtureVo> selectListVoByParamVo(TrackFixtureParamVo trackFixture, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (trackFixture == null) {
			trackFixture = new TrackFixtureParamVo();
		}
		trackFixture.setTenantId(commonParam.getTenantId());

		List<TrackFixture> list = (List<TrackFixture>) this.getBaseService().selectListByParamVo(trackFixture,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<TrackFixtureVo> selectPageVoByParamVo(TrackFixtureParamVo trackFixture, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (trackFixture == null) {
			trackFixture = new TrackFixtureParamVo();
		}
		trackFixture.setTenantId(commonParam.getTenantId());

		PageInfo<TrackFixture> list = (PageInfo<TrackFixture>) this.getBaseService().selectPageByParamVo(trackFixture,
				commonParam, pageNo, pageSize);
		List<TrackFixtureVo> volist = new ArrayList<TrackFixtureVo>();

		Iterator<TrackFixture> iter = list.getList().iterator();
		TrackFixtureVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<TrackFixtureVo> vpage = new Page<TrackFixtureVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public TrackFixtureVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		TrackFixture entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<TrackFixtureVo> selectListExtendVoByParamVo(TrackFixtureParamVo trackFixture, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (trackFixture == null) {
			trackFixture = new TrackFixtureParamVo();
		}
		trackFixture.setTenantId(commonParam.getTenantId());

		List<TrackFixture> list = (List<TrackFixture>) this.getBaseService().selectListByParamVo(trackFixture,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<TrackFixtureVo> selectPageExtendVoByParamVo(TrackFixtureParamVo trackFixture,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (trackFixture == null) {
			trackFixture = new TrackFixtureParamVo();
		}
		trackFixture.setTenantId(commonParam.getTenantId());

		PageInfo<TrackFixture> list = (PageInfo<TrackFixture>) this.getBaseService().selectPageByParamVo(trackFixture,
				commonParam, pageNo, pageSize);
		List<TrackFixtureVo> volist = new ArrayList<TrackFixtureVo>();

		Iterator<TrackFixture> iter = list.getList().iterator();
		TrackFixtureVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<TrackFixtureVo> vpage = new Page<TrackFixtureVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(TrackFixtureParamVo trackFixtureParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		TrackFixture trackFixture = null;
		try {
			if (trackFixtureParamVo.getId() == null) {// 新增

				trackFixtureParamVo.setTenantId(commonParam.getTenantId());
				trackFixture = trackFixtureService.saveOrUpdate(trackFixtureParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				TrackFixture trackFixtureVoTemp = this.selectById(trackFixtureParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(trackFixtureVoTemp, trackFixtureParamVo);

				trackFixture = trackFixtureService.saveOrUpdate(trackFixtureVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(trackFixture);
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
