package com.techsoft.service.bill;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.bill.BillWorkorderParamVo;
import com.techsoft.entity.bill.BillWorkorderVo;
import com.techsoft.entity.common.BillWorkorder;
import com.techsoft.entity.product.ProductBomVo;
import com.techsoft.entity.struct.StructProductionlineParamVo;

public interface BillWorkorderService extends BaseService<BillWorkorder> {
	/**
	 * 获取工单下的所有工艺路线
	 * @param id
	 * @param commonParam
	 * @return
	 */
	public List<ProductBomVo> listProductBomProcess(Long id,CommonParam commonParam);
	

	
	/**
	 * 工单审核校验该工单等 
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public ResultMessage updateAudit(Long id,CommonParam commonParam);
	

	/**
	 * 工单开立校验该工单对应物品ID是否存在BOM、对应BOM、半成品是否存在工艺路线、工序、工序工具、指令步骤等 
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public ResultMessage updateStart(Long id,List<StructProductionlineParamVo> productionlineList, CommonParam commonParam);
	
	/**
	*工单生成条码 
	*@auther:Wang
	*@version:2019年9月5日下午5:04:48
	*@param:
	*@description
	*/
	public ResultMessage insertPrintBarcode(Long id,CommonParam commonParam);
	
}
