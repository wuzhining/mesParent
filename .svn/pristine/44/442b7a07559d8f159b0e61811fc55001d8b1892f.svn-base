package com.techsoft.client.service.firm;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.FirmPartner;
import com.techsoft.entity.firm.FirmPartnerVo;
import com.techsoft.entity.firm.FirmPartnerParamVo;

public interface ClientFirmPartnerService extends BaseClientService<FirmPartner> {

	public FirmPartnerVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<FirmPartnerVo> selectListVoByParamVo(FirmPartnerParamVo firmPartner, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<FirmPartnerVo> selectPageVoByParamVo(FirmPartnerParamVo firmPartner, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public FirmPartnerVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<FirmPartnerVo> selectListExtendVoByParamVo(FirmPartnerParamVo firmPartner, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<FirmPartnerVo> selectPageExtendVoByParamVo(FirmPartnerParamVo firmPartner, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(FirmPartnerParamVo firmPartnerParamVo, CommonParam commonParam);
}
