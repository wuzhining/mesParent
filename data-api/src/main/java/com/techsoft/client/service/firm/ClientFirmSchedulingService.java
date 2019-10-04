package com.techsoft.client.service.firm;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.FirmScheduling;
import com.techsoft.entity.firm.FirmSchedulingVo;
import com.techsoft.entity.firm.FirmSchedulingParamVo;

public interface ClientFirmSchedulingService extends BaseClientService<FirmScheduling> {

	public FirmSchedulingVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<FirmSchedulingVo> selectListVoByParamVo(FirmSchedulingParamVo firmScheduling, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<FirmSchedulingVo> selectPageVoByParamVo(FirmSchedulingParamVo firmScheduling,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public FirmSchedulingVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<FirmSchedulingVo> selectListExtendVoByParamVo(FirmSchedulingParamVo firmScheduling,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<FirmSchedulingVo> selectPageExtendVoByParamVo(FirmSchedulingParamVo firmScheduling,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(FirmSchedulingParamVo firmSchedulingParamVo, CommonParam commonParam);
}
