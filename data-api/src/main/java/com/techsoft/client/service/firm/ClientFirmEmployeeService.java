package com.techsoft.client.service.firm;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.FirmEmployee;
import com.techsoft.entity.firm.FirmEmployeeVo;
import com.techsoft.entity.firm.FirmEmployeeParamVo;

public interface ClientFirmEmployeeService extends BaseClientService<FirmEmployee> {

	public FirmEmployeeVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<FirmEmployeeVo> selectListVoByParamVo(FirmEmployeeParamVo firmEmployee, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<FirmEmployeeVo> selectPageVoByParamVo(FirmEmployeeParamVo firmEmployee, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public FirmEmployeeVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<FirmEmployeeVo> selectListExtendVoByParamVo(FirmEmployeeParamVo firmEmployee, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<FirmEmployeeVo> selectPageExtendVoByParamVo(FirmEmployeeParamVo firmEmployee,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(FirmEmployeeParamVo firmEmployeeParamVo, CommonParam commonParam);
}
