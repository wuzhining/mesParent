package com.techsoft.client.service.bill;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.BillWorkorder;
import com.techsoft.entity.product.ProductBomVo;
import com.techsoft.entity.struct.StructProductionlineParamVo;
import com.techsoft.entity.bill.BillWorkorderVo;
import com.techsoft.entity.bill.BillWorkorderParamVo;

public interface ClientBillWorkorderService extends BaseClientService<BillWorkorder> {

	public BillWorkorderVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillWorkorderVo> selectListVoByParamVo(BillWorkorderParamVo billWorkorder, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<BillWorkorderVo> selectPageVoByParamVo(BillWorkorderParamVo billWorkorder, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public BillWorkorderVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillWorkorderVo> selectListExtendVoByParamVo(BillWorkorderParamVo billWorkorder,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<BillWorkorderVo> selectPageExtendVoByParamVo(BillWorkorderParamVo billWorkorder,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(BillWorkorderParamVo billWorkorderParamVo, CommonParam commonParam);
	
	public BillWorkorderVo getVoByCode(String code, CommonParam commonParam) throws BusinessException, SQLException;
	
	
	public ResultMessage updateAudit(Long id, CommonParam commonParam);
	
	/**
	 * 获取工单下的所有工艺路线  (分页)
	 * @param id
	 * @param commonParam
	 * @return
	 */
	public PageInfo<ProductBomVo> listProductBomProcessPage(Long id, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;
	
	/**
	 * 工单开立校验该工单对应物品ID是否存在BOM、对应BOM、半成品是否存在工艺路线、工序、工序工具、指令步骤等 
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public ResultMessage updatStart(Long id,List<StructProductionlineParamVo> productionlineList, CommonParam commonParam);
	
	/**
	*工单生成条码 
	*@auther:Wang
	*@version:2019年9月5日下午5:04:48
	*@param:
	*@description
	*/
	public ResultMessage printBarcode(Long id, CommonParam commonParam) throws BusinessException, SQLException;
}
