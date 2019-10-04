package com.techsoft.dao.track;

import java.util.List;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.TrackBarcodeUnpack;

public interface TrackBarcodeUnpackDao extends BaseDao<TrackBarcodeUnpack> {
	/**
	*@auther:Wang
	*@version:2019年5月24日上午10:41:32
	*@param:List<TrackBarcodeUnpack> listsns  对象list
	*@description拆包记录批量插入
	*/
	public void insertBatchSn(List<TrackBarcodeUnpack> listsns, CommonParam commonParam) throws BusinessException, SQLException;
}
