package com.techsoft.service.barcode;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseEntity;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.barcode.BarcodeMainParamVo;
import com.techsoft.entity.barcode.BarcodeMainVo;
import com.techsoft.entity.common.BarcodeMain;

public interface BarcodeMainService extends BaseService<BarcodeMain> {
	public int insertPrintBarcodeMain(BarcodeMainParamVo barcodeMainParamVo, CommonParam commonParam)
			throws BusinessException, SQLException;

	/**
	 * @auther:Wang
	 * @version:2019年5月13日下午1:40:15
	 * @param:barcodeMain 条码表对象
	 * @description 根据条件查询条码总数量
	 */
	public Double selectSumQtyByEntity(BarcodeMainParamVo paramVo, CommonParam commonParam)
			throws BusinessException, SQLException;

	public BarcodeMain updateBatch(List<BarcodeMain> everybarList, CommonParam commonParam)
			throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年6月24日上午11:44:27
	*@param paramVo PDA传回的查询条件封装对象
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description         根据输入的条件汇总仓库库存
	*/
	public List<BarcodeMainVo> selectSumQtyByCondition(BarcodeMainParamVo paramVo) throws BusinessException, SQLException;
	

	public BarcodeMain getByCode(String code, CommonParam commonParam) throws BusinessException, SQLException;

	
}
