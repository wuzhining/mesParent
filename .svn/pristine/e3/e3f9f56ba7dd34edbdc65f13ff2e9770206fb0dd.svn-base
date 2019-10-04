package com.techsoft.client.service.alarm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;

import com.techsoft.entity.common.AlarmGroupUser;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.FirmEmployee;
import com.techsoft.entity.alarm.AlarmGroupUserVo;
import com.techsoft.entity.alarm.AlarmGroupUserParamVo;
import com.techsoft.service.alarm.AlarmGroupUserService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.firm.FirmEmployeeService;

@org.springframework.stereotype.Service
public class ClientAlarmGroupUserServiceImpl extends BaseClientServiceImpl<AlarmGroupUser>
		implements ClientAlarmGroupUserService {
	@com.alibaba.dubbo.config.annotation.Reference
	private AlarmGroupUserService alarmGroupUserService;
	@com.alibaba.dubbo.config.annotation.Reference
	private FirmEmployeeService firmEmployeeService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;

	@Override
	public BaseService<AlarmGroupUser> getBaseService() {
		return alarmGroupUserService;
	}

	private AlarmGroupUserVo getVo(AlarmGroupUser alarmGroupUser, CommonParam commonParam)
			throws BusinessException, SQLException {
		AlarmGroupUserVo vo = new AlarmGroupUserVo(alarmGroupUser);
		if (vo.getUserId() != null && vo.getUserId() > 0L) {
			FirmEmployee firmEmployee = firmEmployeeService.selectById(vo.getUserId(), commonParam);
			if (firmEmployee != null) {
				vo.setFirmEmployee(firmEmployee);
			}
		}

		if (vo.getAlarmGroupDictId() != null && vo.getAlarmGroupDictId() > 0L) {
			ConfigDictionary configDictionary = configDictionaryService.selectById(vo.getAlarmGroupDictId(),
					commonParam);
			if (configDictionary != null) {
				vo.setConfigDictionary(configDictionary);
			}
		}
		return vo;
	}

	private AlarmGroupUserVo getExtendVo(AlarmGroupUser alarmGroupUser, CommonParam commonParam)
			throws BusinessException, SQLException {
		AlarmGroupUserVo vo = this.getVo(alarmGroupUser, commonParam);

		return vo;
	}

	private List<AlarmGroupUserVo> getVoList(List<AlarmGroupUser> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AlarmGroupUserVo> voList = new ArrayList<AlarmGroupUserVo>();
		for (AlarmGroupUser entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<AlarmGroupUserVo> getExtendVoList(List<AlarmGroupUser> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AlarmGroupUserVo> voList = new ArrayList<AlarmGroupUserVo>();
		for (AlarmGroupUser entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public AlarmGroupUserVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AlarmGroupUser entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<AlarmGroupUserVo> selectListVoByParamVo(AlarmGroupUserParamVo alarmGroupUser, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (alarmGroupUser == null) {
			alarmGroupUser = new AlarmGroupUserParamVo();
		}
		alarmGroupUser.setTenantId(commonParam.getTenantId());

		List<AlarmGroupUser> list = (List<AlarmGroupUser>) this.getBaseService().selectListByParamVo(alarmGroupUser,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AlarmGroupUserVo> selectPageVoByParamVo(AlarmGroupUserParamVo alarmGroupUser,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (alarmGroupUser == null) {
			alarmGroupUser = new AlarmGroupUserParamVo();
		}
		alarmGroupUser.setTenantId(commonParam.getTenantId());

		PageInfo<AlarmGroupUser> list = (PageInfo<AlarmGroupUser>) this.getBaseService()
				.selectPageByParamVo(alarmGroupUser, commonParam, pageNo, pageSize);
		List<AlarmGroupUserVo> volist = new ArrayList<AlarmGroupUserVo>();

		Iterator<AlarmGroupUser> iter = list.getList().iterator();
		AlarmGroupUserVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AlarmGroupUserVo> vpage = new Page<AlarmGroupUserVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public AlarmGroupUserVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AlarmGroupUser entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<AlarmGroupUserVo> selectListExtendVoByParamVo(AlarmGroupUserParamVo alarmGroupUser,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (alarmGroupUser == null) {
			alarmGroupUser = new AlarmGroupUserParamVo();
		}
		alarmGroupUser.setTenantId(commonParam.getTenantId());

		List<AlarmGroupUser> list = (List<AlarmGroupUser>) this.getBaseService().selectListByParamVo(alarmGroupUser,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AlarmGroupUserVo> selectPageExtendVoByParamVo(AlarmGroupUserParamVo alarmGroupUser,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (alarmGroupUser == null) {
			alarmGroupUser = new AlarmGroupUserParamVo();
		}
		alarmGroupUser.setTenantId(commonParam.getTenantId());

		PageInfo<AlarmGroupUser> list = (PageInfo<AlarmGroupUser>) this.getBaseService()
				.selectPageByParamVo(alarmGroupUser, commonParam, pageNo, pageSize);
		List<AlarmGroupUserVo> volist = new ArrayList<AlarmGroupUserVo>();

		Iterator<AlarmGroupUser> iter = list.getList().iterator();
		AlarmGroupUserVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AlarmGroupUserVo> vpage = new Page<AlarmGroupUserVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(AlarmGroupUserParamVo alarmGroupUserParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		AlarmGroupUser alarmGroupUser = null;
		try {
			if (alarmGroupUserParamVo.getId() == null) {// 新增

				alarmGroupUserParamVo.setTenantId(commonParam.getTenantId());
				alarmGroupUser = alarmGroupUserService.saveOrUpdate(alarmGroupUserParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				AlarmGroupUser alarmGroupUserVoTemp = this.selectById(alarmGroupUserParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(alarmGroupUserVoTemp, alarmGroupUserParamVo);

				alarmGroupUser = alarmGroupUserService.saveOrUpdate(alarmGroupUserVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(alarmGroupUser);
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
