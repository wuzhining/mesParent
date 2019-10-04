package com.techsoft.client.service.track;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.TrackPallet;
import com.techsoft.entity.track.TrackPalletVo;
import com.techsoft.entity.track.TrackPalletParamVo;

public interface ClientTrackPalletService extends BaseClientService<TrackPallet> {

	public TrackPalletVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<TrackPalletVo> selectListVoByParamVo(TrackPalletParamVo trackPallet, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<TrackPalletVo> selectPageVoByParamVo(TrackPalletParamVo trackPallet, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public TrackPalletVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<TrackPalletVo> selectListExtendVoByParamVo(TrackPalletParamVo trackPallet, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<TrackPalletVo> selectPageExtendVoByParamVo(TrackPalletParamVo trackPallet, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(TrackPalletParamVo trackPalletParamVo, CommonParam commonParam);
}
