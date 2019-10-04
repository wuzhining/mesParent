package com.techsoft.client.service.track;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.TrackMaterial;
import com.techsoft.entity.track.TrackMaterialVo;
import com.techsoft.entity.track.TrackMaterialParamVo;

public interface ClientTrackMaterialService extends BaseClientService<TrackMaterial> {

	public TrackMaterialVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<TrackMaterialVo> selectListVoByParamVo(TrackMaterialParamVo trackMaterial, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<TrackMaterialVo> selectPageVoByParamVo(TrackMaterialParamVo trackMaterial, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public TrackMaterialVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<TrackMaterialVo> selectListExtendVoByParamVo(TrackMaterialParamVo trackMaterial,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<TrackMaterialVo> selectPageExtendVoByParamVo(TrackMaterialParamVo trackMaterial,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(TrackMaterialParamVo trackMaterialParamVo, CommonParam commonParam);
}
