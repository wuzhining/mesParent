package com.techsoft.client.service.firm;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.entity.firm.FirmDepartmentVo;
import com.techsoft.entity.firm.FirmDepartmentParamVo;

public interface ClientFirmDepartmentService extends BaseClientService<FirmDepartment> {

	public FirmDepartmentVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<FirmDepartmentVo> selectListVoByParamVo(FirmDepartmentParamVo firmDepartment, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<FirmDepartmentVo> selectPageVoByParamVo(FirmDepartmentParamVo firmDepartment,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public FirmDepartmentVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<FirmDepartmentVo> selectListExtendVoByParamVo(FirmDepartmentParamVo firmDepartment,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<FirmDepartmentVo> selectPageExtendVoByParamVo(FirmDepartmentParamVo firmDepartment,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(FirmDepartmentParamVo firmDepartmentParamVo, CommonParam commonParam);
}
