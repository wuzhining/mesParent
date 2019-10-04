package com.techsoft.client.service.bill;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.BillFixtureItem;
import com.techsoft.entity.bill.BillFixtureItemVo;
import com.techsoft.entity.bill.BillFixtureItemParamVo;

public interface ClientBillFixtureItemService extends BaseClientService<BillFixtureItem> {

	public BillFixtureItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillFixtureItemVo> selectListVoByParamVo(BillFixtureItemParamVo billFixtureItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<BillFixtureItemVo> selectPageVoByParamVo(BillFixtureItemParamVo billFixtureItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public BillFixtureItemVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillFixtureItemVo> selectListExtendVoByParamVo(BillFixtureItemParamVo billFixtureItem,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<BillFixtureItemVo> selectPageExtendVoByParamVo(BillFixtureItemParamVo billFixtureItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(BillFixtureItemParamVo billFixtureItemParamVo, CommonParam commonParam);
}
