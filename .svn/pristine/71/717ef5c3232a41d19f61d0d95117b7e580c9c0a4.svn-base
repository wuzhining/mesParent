package com.techsoft.client.service.bill;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.bill.BillWarehouseParamVo;
import com.techsoft.entity.bill.BillWarehouseVo;
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.BillDelivery;
import com.techsoft.entity.common.BillSaleorder;
import com.techsoft.entity.common.BillSaleorderItem;
import com.techsoft.entity.common.BillWarehouse;
import com.techsoft.entity.common.BillWorkorder;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.entity.track.TrackBarcodeVo;

public interface ClientBillWarehouseService extends BaseClientService<BillWarehouse> {

	public BillWarehouseVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillWarehouseVo> selectListVoByParamVo(BillWarehouseParamVo billWarehouse, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<BillWarehouseVo> selectPageVoByParamVo(BillWarehouseParamVo billWarehouse, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public BillWarehouseVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillWarehouseVo> selectListExtendVoByParamVo(BillWarehouseParamVo billWarehouse,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<BillWarehouseVo> selectPageExtendVoByParamVo(BillWarehouseParamVo billWarehouse,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(BillWarehouseParamVo billWarehouseParamVo, CommonParam commonParam);

	/**
	 * @auther:Wang
	 * @version:2019年5月29日下午4:34:37
	 * @param:
	 * @description 生产领料单新增
	 */
	/*public ResultMessage pickInsert(BillWarehouseVo billWarehouseVo, List<BillWorkorderBomVo> list,
			CommonParam commonParam);*/

	/**
	 * @auther:Chen
	 * @version:2019年5月29日下午4:40:14
	 * @param billWarehouseVo
	 *            单据对象
	 * @return resultMessage 结果集
	 * @description 来料单审核生成质检单
	 */
	public ResultMessage billCheck(BillWarehouseVo billWarehouseVo, CommonParam commonParam);
	
	/**
	 * @auther:Chen
	 * @version:2019年5月29日下午4:40:14
	 * @param billWarehouseVo
	 *            单据对象
	 * @return resultMessage 结果集
	 * @description 来料单审核处理中
	 */
	public ResultMessage printCheck(BillWarehouseVo billWarehouseVo, CommonParam commonParam);

	/**
	 * @auther:Chen
	 * @version:2019年5月29日下午2:57:22
	 * @param list
	 *            BarcodeMain条码集合
	 * @param fromWarehouseId
	 *            源仓库ID
	 * @param toWarehouseId
	 *            目标仓库ID
	 * @description 根据传回的下架标签LIST进行统一下架出库，及生成目标仓库的上架单
	 */
	public ResultMessage allocationOutput(List<BarcodeMain> list, Long fromWarehouseId, Long toWarehouseId,Long factoryId,
			CommonParam commonParam);

	/**
	 * @auther:Chen
	 * @version:2019年5月29日下午3:30:39
	 * @param trackBarcodeVo
	 *            单据条码表对象Vo
	 * @description 根据传回的物料标签进行调拨上架
	 */
	public ResultMessage allocationnBillBarcodeInput(TrackBarcodeVo trackBarcodeVo, CommonParam commonParam);

	/**
	 * @auther:Wang
	 * @version:2019年5月29日下午4:34:37
	 * @param:
	 * @description 非生产领料单新增
	 */
	public ResultMessage unPickInsert(BillWarehouseVo billWarehouseVo, List<ProductMaterial> list,
			CommonParam commonParam);

	/**
	 * @auther:Chen
	 * @version:2019年5月31日下午3:01:02
	 * @param list
	 *            工单List
	 * @param commonParam
	 * @return
	 * @description 根据选择工单生成退料单
	 */
	public ResultMessage workerReturnSava(List<BillWorkorder> list, CommonParam commonParam);

	public PageInfo<BillWarehouseVo> selectPrepareMaterialsScreen(CommonParam commonParam)
			throws BusinessException, SQLException;

	/**
	 * @auther:Chen
	 * @version:2019年6月5日上午10:32:34
	 * @param billDelivery
	 * @param commonParam
	 * @return
	 * @description
	 */
	public ResultMessage deliverySave(List<BillDelivery> billDelivery,Long factoryId,CommonParam commonParam);

	/**
	*@auther:Chen
	*@version:2019年6月13日下午3:53:03
	*@param barcodeList   退料标签List
	*@param commonParam
	*@return
	*@description  扫描标签生成退料单以及入库上架单
	*/
	public ResultMessage barcodeReturn(List<BarcodeMain> barcodeList, CommonParam commonParam);
	
	
	/**
	*@auther:Wang
	*@version:2019年6月25日下午1:18:03
	*@param:
	*@description 销售出库单新增
	*/
	public ResultMessage shipInsert(BillWarehouseVo billWarehouseVo, List<BillSaleorderItem> list,
			CommonParam commonParam);
	
	/**
	*@auther:Wang
	*@version:2019年7月8日下午1:57:21
	*@param:barcodeList 标签List
	*@description 扫描标签生成报废单
	*/
	public ResultMessage discardedOutInsert(List<BarcodeMain> barcodeList,Long factoryId, CommonParam commonParam) throws BusinessException, SQLException;

	/**
	*@auther:Chen
	*@version:2019年7月9日上午11:21:12
	*@param barcodeList
	*@param commonParam
	*@return
	*@description
	*/
	public ResultMessage barcodeSaleReturn(List<BarcodeMain> barcodeList, CommonParam commonParam);
}
