package com.techsoft.client.service.firm;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;

import com.techsoft.entity.common.FirmPost;
import com.techsoft.entity.firm.FirmPostVo;
import com.techsoft.entity.firm.FirmPostParamVo;

public interface ClientFirmPostService extends BaseClientService<FirmPost> {

	public FirmPostVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<FirmPostVo> selectListVoByParamVo(FirmPostParamVo firmPost, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<FirmPostVo> selectPageVoByParamVo(FirmPostParamVo firmPost, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException;

	public FirmPostVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<FirmPostVo> selectListExtendVoByParamVo(FirmPostParamVo firmPost, CommonParam commonParam)
			throws BusinessException, SQLException;

	public PageInfo<FirmPostVo> selectPageExtendVoByParamVo(FirmPostParamVo firmPost, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(FirmPostParamVo firmPostParamVo, CommonParam commonParam);
}
