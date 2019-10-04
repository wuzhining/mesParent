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

import com.techsoft.entity.common.AlarmLevel;
import com.techsoft.entity.common.AlarmProblem;
import com.techsoft.entity.alarm.AlarmLevelVo;
import com.techsoft.entity.alarm.AlarmLevelParamVo;
import com.techsoft.service.alarm.AlarmLevelService;
import com.techsoft.service.alarm.AlarmProblemService;

@org.springframework.stereotype.Service
public class ClientAlarmLevelServiceImpl extends BaseClientServiceImpl<AlarmLevel> implements ClientAlarmLevelService {
	@com.alibaba.dubbo.config.annotation.Reference
	private AlarmLevelService alarmLevelService;
	@com.alibaba.dubbo.config.annotation.Reference
	private AlarmProblemService alarmProblemService;

	@Override
	public BaseService<AlarmLevel> getBaseService() {
		return alarmLevelService;
	}

	private AlarmLevelVo getVo(AlarmLevel alarmLevel, CommonParam commonParam) throws BusinessException, SQLException {
		AlarmLevelVo vo = new AlarmLevelVo(alarmLevel);
		if (vo.getProblemId() != null && vo.getProblemId() > 0L) {
			AlarmProblem alarmProblem = alarmProblemService.selectById(vo.getProblemId(), commonParam);
			if (alarmProblem != null) {
				vo.setAlarmProblem(alarmProblem);
			}
		}
		return vo;
	}

	private AlarmLevelVo getExtendVo(AlarmLevel alarmLevel, CommonParam commonParam)
			throws BusinessException, SQLException {
		AlarmLevelVo vo = this.getVo(alarmLevel, commonParam);

		return vo;
	}

	private List<AlarmLevelVo> getVoList(List<AlarmLevel> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AlarmLevelVo> voList = new ArrayList<AlarmLevelVo>();
		for (AlarmLevel entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<AlarmLevelVo> getExtendVoList(List<AlarmLevel> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AlarmLevelVo> voList = new ArrayList<AlarmLevelVo>();
		for (AlarmLevel entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public AlarmLevelVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AlarmLevel entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<AlarmLevelVo> selectListVoByParamVo(AlarmLevelParamVo alarmLevel, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (alarmLevel == null) {
			alarmLevel = new AlarmLevelParamVo();
		}
		alarmLevel.setTenantId(commonParam.getTenantId());

		List<AlarmLevel> list = (List<AlarmLevel>) this.getBaseService().selectListByParamVo(alarmLevel, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AlarmLevelVo> selectPageVoByParamVo(AlarmLevelParamVo alarmLevel, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (alarmLevel == null) {
			alarmLevel = new AlarmLevelParamVo();
		}
		alarmLevel.setTenantId(commonParam.getTenantId());

		PageInfo<AlarmLevel> list = (PageInfo<AlarmLevel>) this.getBaseService().selectPageByParamVo(alarmLevel,
				commonParam, pageNo, pageSize);
		List<AlarmLevelVo> volist = new ArrayList<AlarmLevelVo>();

		Iterator<AlarmLevel> iter = list.getList().iterator();
		AlarmLevelVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AlarmLevelVo> vpage = new Page<AlarmLevelVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public AlarmLevelVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AlarmLevel entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<AlarmLevelVo> selectListExtendVoByParamVo(AlarmLevelParamVo alarmLevel, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (alarmLevel == null) {
			alarmLevel = new AlarmLevelParamVo();
		}
		alarmLevel.setTenantId(commonParam.getTenantId());

		List<AlarmLevel> list = (List<AlarmLevel>) this.getBaseService().selectListByParamVo(alarmLevel, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AlarmLevelVo> selectPageExtendVoByParamVo(AlarmLevelParamVo alarmLevel, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (alarmLevel == null) {
			alarmLevel = new AlarmLevelParamVo();
		}
		alarmLevel.setTenantId(commonParam.getTenantId());

		PageInfo<AlarmLevel> list = (PageInfo<AlarmLevel>) this.getBaseService().selectPageByParamVo(alarmLevel,
				commonParam, pageNo, pageSize);
		List<AlarmLevelVo> volist = new ArrayList<AlarmLevelVo>();

		Iterator<AlarmLevel> iter = list.getList().iterator();
		AlarmLevelVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AlarmLevelVo> vpage = new Page<AlarmLevelVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(AlarmLevelParamVo alarmLevelParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		AlarmLevel alarmLevel = null;
		if (alarmLevelParamVo.getMinuteRespond() == null) {
			resultMessage.addErr("响应分钟数不能为空");
			return resultMessage;
		}
		if (alarmLevelParamVo.getMinuteDeal() == null) {
			resultMessage.addErr("处理分钟数不能为空");
			return resultMessage;
		}
		try {
			if (alarmLevelParamVo.getId() == null) {// 新增

				alarmLevelParamVo.setTenantId(commonParam.getTenantId());
				alarmLevel = alarmLevelService.saveOrUpdate(alarmLevelParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				AlarmLevel alarmLevelVoTemp = this.selectById(alarmLevelParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(alarmLevelVoTemp, alarmLevelParamVo);

				alarmLevel = alarmLevelService.saveOrUpdate(alarmLevelVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(alarmLevel);
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
