package com.techsoft.client.service.track;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.TrackPackbox;
import com.techsoft.entity.track.TrackPackboxVo;
import com.techsoft.entity.track.TrackPackboxParamVo;

public interface ClientTrackPackboxService extends BaseClientService<TrackPackbox> {

	public TrackPackboxVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<TrackPackboxVo> selectListVoByParamVo(TrackPackboxParamVo trackPackbox, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<TrackPackboxVo> selectPageVoByParamVo(TrackPackboxParamVo trackPackbox, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public TrackPackboxVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<TrackPackboxVo> selectListExtendVoByParamVo(TrackPackboxParamVo trackPackbox, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<TrackPackboxVo> selectPageExtendVoByParamVo(TrackPackboxParamVo trackPackbox,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(TrackPackboxParamVo trackPackboxParamVo, CommonParam commonParam);
}
