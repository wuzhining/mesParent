package com.techsoft.client.service.bill;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.BillFixture;
import com.techsoft.entity.bill.BillFixtureVo;
import com.techsoft.entity.bill.BillFixtureParamVo;

public interface ClientBillFixtureService extends BaseClientService<BillFixture> {

	public BillFixtureVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillFixtureVo> selectListVoByParamVo(BillFixtureParamVo billFixture, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<BillFixtureVo> selectPageVoByParamVo(BillFixtureParamVo billFixture, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public BillFixtureVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<BillFixtureVo> selectListExtendVoByParamVo(BillFixtureParamVo billFixture, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<BillFixtureVo> selectPageExtendVoByParamVo(BillFixtureParamVo billFixture, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(BillFixtureParamVo billFixtureParamVo, CommonParam commonParam);
}
