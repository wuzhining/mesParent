package com.techsoft.client.service.firm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumUserStatus;
import com.techsoft.common.enums.EnumUserSystemRoletype;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.common.utils.Md5Token;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmEmployee;
import com.techsoft.entity.common.FirmPost;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.common.UserTenant;
import com.techsoft.entity.firm.FirmEmployeeParamVo;
import com.techsoft.entity.firm.FirmEmployeeVo;
import com.techsoft.entity.sys.UserPassportParamVo;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.firm.FirmEmployeeService;
import com.techsoft.service.firm.FirmPostService;
import com.techsoft.service.sys.UserPassportService;
import com.techsoft.service.sys.UserTenantService;

@org.springframework.stereotype.Service
public class ClientFirmEmployeeServiceImpl extends BaseClientServiceImpl<FirmEmployee>
		implements ClientFirmEmployeeService {
	@com.alibaba.dubbo.config.annotation.Reference
	private FirmEmployeeService firmEmployeeService;
	@com.alibaba.dubbo.config.annotation.Reference
	private FirmPostService firmPostService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;
	@com.alibaba.dubbo.config.annotation.Reference
	private UserTenantService userTenantService;
	@com.alibaba.dubbo.config.annotation.Reference
	private UserPassportService userPassportService;

	@Override
	public BaseService<FirmEmployee> getBaseService() {
		return firmEmployeeService;
	}

	private FirmEmployeeVo getVo(FirmEmployee firmEmployee, CommonParam commonParam)
			throws BusinessException, SQLException {
		FirmEmployeeVo vo = new FirmEmployeeVo(firmEmployee);
		if (vo.getWorkpostId() != null && vo.getWorkpostId() > 0L) {
			FirmPost firmPost = firmPostService.selectById(vo.getWorkpostId(), commonParam);
			if (firmPost != null) {
				vo.setFirmPost(firmPost);
			}
		}
		if (vo.getEmployeeStatusDictId() != null && vo.getEmployeeStatusDictId() > 0L) {
			ConfigDictionary configDictionary = configDictionaryService.selectById(vo.getEmployeeStatusDictId(),
					commonParam);
			if (configDictionary != null) {
				vo.setConfigDictionary(configDictionary);
			}
		}
		if (vo.getUserId() != null && vo.getUserId() > 0L) {
			UserPassport userPassport = userPassportService.selectById(vo.getUserId(), commonParam);
			if (userPassport != null) {
				vo.setUserPassport(userPassport);
			}
		}
		return vo;
	}

	private FirmEmployeeVo getExtendVo(FirmEmployee firmEmployee, CommonParam commonParam)
			throws BusinessException, SQLException {
		FirmEmployeeVo vo = this.getVo(firmEmployee, commonParam);

		return vo;
	}

	private List<FirmEmployeeVo> getVoList(List<FirmEmployee> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<FirmEmployeeVo> voList = new ArrayList<FirmEmployeeVo>();
		for (FirmEmployee entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<FirmEmployeeVo> getExtendVoList(List<FirmEmployee> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<FirmEmployeeVo> voList = new ArrayList<FirmEmployeeVo>();
		for (FirmEmployee entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public FirmEmployeeVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		FirmEmployee entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<FirmEmployeeVo> selectListVoByParamVo(FirmEmployeeParamVo firmEmployee, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (firmEmployee == null) {
			firmEmployee = new FirmEmployeeParamVo();
		}
		firmEmployee.setTenantId(commonParam.getTenantId());

		List<FirmEmployee> list = (List<FirmEmployee>) this.getBaseService().selectListByParamVo(firmEmployee,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<FirmEmployeeVo> selectPageVoByParamVo(FirmEmployeeParamVo firmEmployee, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (firmEmployee == null) {
			firmEmployee = new FirmEmployeeParamVo();
		}
		firmEmployee.setTenantId(commonParam.getTenantId());

		PageInfo<FirmEmployee> list = (PageInfo<FirmEmployee>) this.getBaseService().selectPageByParamVo(firmEmployee,
				commonParam, pageNo, pageSize);
		List<FirmEmployeeVo> volist = new ArrayList<FirmEmployeeVo>();

		Iterator<FirmEmployee> iter = list.getList().iterator();
		FirmEmployeeVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<FirmEmployeeVo> vpage = new Page<FirmEmployeeVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public FirmEmployeeVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		FirmEmployee entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<FirmEmployeeVo> selectListExtendVoByParamVo(FirmEmployeeParamVo firmEmployee, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (firmEmployee == null) {
			firmEmployee = new FirmEmployeeParamVo();
		}
		firmEmployee.setTenantId(commonParam.getTenantId());

		List<FirmEmployee> list = (List<FirmEmployee>) this.getBaseService().selectListByParamVo(firmEmployee,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<FirmEmployeeVo> selectPageExtendVoByParamVo(FirmEmployeeParamVo firmEmployee,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (firmEmployee == null) {
			firmEmployee = new FirmEmployeeParamVo();
		}
		firmEmployee.setTenantId(commonParam.getTenantId());

		PageInfo<FirmEmployee> list = (PageInfo<FirmEmployee>) this.getBaseService().selectPageByParamVo(firmEmployee,
				commonParam, pageNo, pageSize);
		List<FirmEmployeeVo> volist = new ArrayList<FirmEmployeeVo>();

		Iterator<FirmEmployee> iter = list.getList().iterator();
		FirmEmployeeVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<FirmEmployeeVo> vpage = new Page<FirmEmployeeVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(FirmEmployeeParamVo firmEmployeeParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		FirmEmployee firmEmployee = null;
		if (firmEmployeeParamVo.getRealName() == null) {
			resultMessage.addErr("员工名称不能为空");
			return resultMessage;
		}
		if (firmEmployeeParamVo.getEmployeeStatusDictId() == null) {
			resultMessage.addErr("员工状态不能为空");
			return resultMessage;
		}
		if (firmEmployeeParamVo.getWorkpostId() == null) {
			resultMessage.addErr("所属岗位不能为空");
			return resultMessage;
		}
		try {

			UserTenant userTenant = userTenantService.selectById(commonParam.getTenantId(), commonParam);
			UserPassport userTenantPassport = userPassportService.selectById(userTenant.getUserId(), commonParam);

			if (firmEmployeeParamVo.getId() == null) {// 新增
				// 生成工号 
				String employeeCode = firmEmployeeParamVo.getEmployeeCode();
				if (StringUtils.isBlank(employeeCode)) {
					employeeCode = configCodeRuleService.createCode(FirmEmployee.class.getName(), null, null,
	    					commonParam);
					firmEmployeeParamVo.setEmployeeCode(employeeCode);
				}
				if (StringUtils.isBlank(employeeCode)) {
					resultMessage.addErr("工号不能为空");
					return resultMessage;
				}
				//检验编码是否已存在
				FirmEmployeeParamVo firmEmployeeSearch = new FirmEmployeeParamVo();
				firmEmployeeSearch.setEmployeeCode(employeeCode);
				List<FirmEmployee> list = firmEmployeeService.selectListByParamVo(firmEmployeeSearch, commonParam);
				if((list!=null)&&(!list.isEmpty())){
					resultMessage.addErr("工号已经存在");
					return resultMessage;
				}
				
				
				firmEmployeeParamVo.setTenantId(commonParam.getTenantId());

				UserPassportParamVo userPassportParamVo = new UserPassportParamVo();
				userPassportParamVo.setUserName(userTenantPassport.getUserName() + "_" + employeeCode);
				userPassportParamVo.setSystemRoletype(EnumUserSystemRoletype.EMPLOYEE.getValue());
				userPassportParamVo.setStatus(EnumUserStatus.ENABLED.getValue());
				userPassportParamVo.setPassword(Md5Token.getInstance().getLongToken(employeeCode));
				userPassportParamVo.setTenantId(commonParam.getTenantId());
				userPassportParamVo.setRealName(firmEmployeeParamVo.getRealName());
				UserPassport userPassport = userPassportService.saveOrUpdate(userPassportParamVo, commonParam);
				firmEmployeeParamVo.setUserId(userPassport.getId());

				firmEmployee = firmEmployeeService.saveOrUpdate(firmEmployeeParamVo, commonParam);

				resultMessage.setIsSuccess(true);
			} else { // 修改
				FirmEmployee firmEmployeeVoTemp = this.selectById(firmEmployeeParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(firmEmployeeVoTemp, firmEmployeeParamVo);

				firmEmployee = firmEmployeeService.saveOrUpdate(firmEmployeeVoTemp, commonParam);

				if (StringUtils.isNotBlank(firmEmployeeParamVo.getEmployeeCode())) {
					UserPassport userPassport = userPassportService.selectById(firmEmployee.getUserId(), commonParam);
					userPassport.setUserName(
							userTenantPassport.getUserName() + "_" + firmEmployeeParamVo.getEmployeeCode());
					userPassportService.saveOrUpdate(userPassport, commonParam);
				}

				if (StringUtils.isNotBlank(firmEmployeeParamVo.getRealName())) {
					UserPassport userPassport = userPassportService.selectById(firmEmployee.getUserId(), commonParam);
					userPassport.setRealName(firmEmployeeParamVo.getRealName());
					userPassportService.saveOrUpdate(userPassport, commonParam);
				}

				resultMessage.setIsSuccess(true);
			}
			if (resultMessage.getIsSuccess()) {

			}

			resultMessage.setBaseEntity(firmEmployee);
		} catch (BusinessException e) {
			resultMessage.addErr(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultMessage;
	}
}
