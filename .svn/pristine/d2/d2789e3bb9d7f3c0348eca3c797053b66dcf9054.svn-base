package com.techsoft.dao.track;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.TrackBarcodeUnpack;
import com.techsoft.mapper.track.TrackBarcodeUnpackMapper;

@Repository
public class TrackBarcodeUnpackDaoImpl extends BaseDaoImpl<TrackBarcodeUnpack> implements TrackBarcodeUnpackDao {
	@Resource
	protected TrackBarcodeUnpackMapper trackBarcodeUnpackMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<TrackBarcodeUnpack> getEntityClass() {
		return TrackBarcodeUnpack.class;
	}	
	
	@Override
	public BaseMapper<TrackBarcodeUnpack> getBaseMapper() {
		return this.trackBarcodeUnpackMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "TRACK_BARCODE_UNPACK";
	}
	
	@Override
	public void insertSaveCheck(TrackBarcodeUnpack value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(TrackBarcodeUnpack value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(TrackBarcodeUnpack value) throws BusinessException, SQLException {
	
	}

	@Override
	public void insertBatchSn(List<TrackBarcodeUnpack> listsns, CommonParam commonParam)
			throws BusinessException, SQLException {
		try {
			for (TrackBarcodeUnpack item : listsns) {
				item.setCreateUserId(Long.valueOf(commonParam.getUserId()));
				item.setModifyUserId(Long.valueOf(commonParam.getUserId()));
			}
			int rows = this.trackBarcodeUnpackMapper.insertBatchSn(listsns);
			if (rows != listsns.size()) {
				throw new BusinessException("批量增加的条码数据与传入的条码列表数量不一致， 请检查!");
			}

		} catch (RuntimeException e) {
			throw new SQLException(e.getMessage());
		}
		
	}
			
}
