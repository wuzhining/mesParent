package com.techsoft.client.service.track;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.TrackBarcodeUnpack;
import com.techsoft.entity.track.TrackBarcodeUnpackParamVo;
import com.techsoft.entity.track.TrackBarcodeUnpackVo;

public interface ClientTrackBarcodeUnpackService extends BaseClientService<TrackBarcodeUnpack> {

	public TrackBarcodeUnpackVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<TrackBarcodeUnpackVo> selectListVoByParamVo(TrackBarcodeUnpackParamVo trackBarcodeUnpack,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<TrackBarcodeUnpackVo> selectPageVoByParamVo(TrackBarcodeUnpackParamVo trackBarcodeUnpack,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public TrackBarcodeUnpackVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException;

	public List<TrackBarcodeUnpackVo> selectListExtendVoByParamVo(TrackBarcodeUnpackParamVo trackBarcodeUnpack,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<TrackBarcodeUnpackVo> selectPageExtendVoByParamVo(TrackBarcodeUnpackParamVo trackBarcodeUnpack,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(TrackBarcodeUnpackParamVo trackBarcodeUnpackParamVo, CommonParam commonParam);
}
