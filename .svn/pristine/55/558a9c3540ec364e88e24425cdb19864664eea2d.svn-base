package com.techsoft.client.service.track;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.TrackFixture;
import com.techsoft.entity.track.TrackFixtureVo;
import com.techsoft.entity.track.TrackFixtureParamVo;

public interface ClientTrackFixtureService extends BaseClientService<TrackFixture> {

	public TrackFixtureVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<TrackFixtureVo> selectListVoByParamVo(TrackFixtureParamVo trackFixture, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<TrackFixtureVo> selectPageVoByParamVo(TrackFixtureParamVo trackFixture, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public TrackFixtureVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<TrackFixtureVo> selectListExtendVoByParamVo(TrackFixtureParamVo trackFixture, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<TrackFixtureVo> selectPageExtendVoByParamVo(TrackFixtureParamVo trackFixture,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(TrackFixtureParamVo trackFixtureParamParamVo, CommonParam commonParam);
}
