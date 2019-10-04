package com.techsoft.dao.barcode;

import java.util.List;

import com.github.pagehelper.Page;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.barcode.BarcodeMainParamVo;
import com.techsoft.entity.barcode.BarcodeMainVo;
import com.techsoft.entity.common.BarcodeMain;

public interface BarcodeMainDao extends BaseDao<BarcodeMain> {

	/**
	 * 批量增加条码打印主表记录
	 * @param barcodeMainVo
	 * @param commonParam
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public int insertPrintBarcodeMain(List<BarcodeMain> lists, CommonParam commonParam) throws BusinessException, SQLException;
	/**
	*@auther:Wang
	*@version:2019年5月2日下午4:14:51
	*@param  list 条码list
	*@description 批量更新条码状态
	*/
	public void updateBatch(List<BarcodeMain> list,CommonParam commonParam)  throws BusinessException, SQLException;
	
	/**
	*@auther:Wang
	*@version:2019年5月13日下午1:40:15
	*@param:barcodeMain 条码表对象
	*@description 根据条件查询条码总数量
	*/
	public Double selectSumQtyByEntity(BarcodeMainParamVo paramVo,CommonParam commonParam) throws BusinessException, SQLException;
	
	/**
	*@auther:Wang
	*@version:2019年5月27日上午11:10:56
	*@param:
	*@description
	*/
	public BarcodeMain selectByBarCode(String barCode, CommonParam commonParam) throws BusinessException, SQLException;
	
	/**
	*@auther:Chen
	*@version:2019年6月24日上午11:40:38
	*@param paramVo   PDA传回的查询条件封装对象
	*@return
	*@throws BusinessException
	*@throws SQLException
	*@description             根据输入的条件汇总仓库库存
	*/
	public List<BarcodeMainVo> selectSumQtyByCondition(BarcodeMainParamVo paramVo) throws BusinessException, SQLException;
	
	public List<BarcodeMainVo> selectSumQtyByWarehouse(BarcodeMainParamVo paramVo) throws BusinessException, SQLException;
	
	/**
	*@auther:Chen
	*@version:2019年7月6日上午10:49:51
	*@param barcodeMain
	*@param commonParam
	*@throws BusinessException
	*@throws SQLException
	*@description
	*/
	public void updateStatusByBarcode(BarcodeMain barcodeMain, CommonParam commonParam) throws BusinessException, SQLException;
	
}
