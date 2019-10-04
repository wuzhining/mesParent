package com.techsoft.client.service.alarm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.alarm.AlarmReasonParamVo;
import com.techsoft.entity.alarm.AlarmReasonVo;
import com.techsoft.entity.common.AlarmProblem;
import com.techsoft.entity.common.AlarmReason;
import com.techsoft.service.alarm.AlarmProblemService;
import com.techsoft.service.alarm.AlarmReasonService;

@org.springframework.stereotype.Service
public class ClientAlarmReasonServiceImpl extends BaseClientServiceImpl<AlarmReason>
		implements ClientAlarmReasonService {
	@com.alibaba.dubbo.config.annotation.Reference
	private AlarmReasonService alarmReasonService;
	@com.alibaba.dubbo.config.annotation.Reference
	private AlarmProblemService alarmProblemService;

	@Override
	public BaseService<AlarmReason> getBaseService() {
		return alarmReasonService;
	}

	private AlarmReasonVo getVo(AlarmReason alarmReason, CommonParam commonParam)
			throws BusinessException, SQLException {
		AlarmReasonVo vo = new AlarmReasonVo(alarmReason);
		if (vo.getProblemId() != null && vo.getProblemId() > 0L) {
			AlarmProblem alarmProblem = alarmProblemService.selectById(vo.getProblemId(), commonParam);
			if (alarmProblem != null) {
				vo.setAlarmProblem(alarmProblem);
			}
		}
		return vo;
	}

	private AlarmReasonVo getExtendVo(AlarmReason alarmReason, CommonParam commonParam)
			throws BusinessException, SQLException {
		AlarmReasonVo vo = this.getVo(alarmReason, commonParam);

		return vo;
	}

	private List<AlarmReasonVo> getVoList(List<AlarmReason> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AlarmReasonVo> voList = new ArrayList<AlarmReasonVo>();
		for (AlarmReason entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<AlarmReasonVo> getExtendVoList(List<AlarmReason> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AlarmReasonVo> voList = new ArrayList<AlarmReasonVo>();
		for (AlarmReason entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public AlarmReasonVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AlarmReason entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<AlarmReasonVo> selectListVoByParamVo(AlarmReasonParamVo alarmReason, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (alarmReason == null) {
			alarmReason = new AlarmReasonParamVo();
		}
		alarmReason.setTenantId(commonParam.getTenantId());

		List<AlarmReason> list = (List<AlarmReason>) this.getBaseService().selectListByParamVo(alarmReason,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AlarmReasonVo> selectPageVoByParamVo(AlarmReasonParamVo alarmReason, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (alarmReason == null) {
			alarmReason = new AlarmReasonParamVo();
		}
		alarmReason.setTenantId(commonParam.getTenantId());

		PageInfo<AlarmReason> list = (PageInfo<AlarmReason>) this.getBaseService().selectPageByParamVo(alarmReason,
				commonParam, pageNo, pageSize);
		List<AlarmReasonVo> volist = new ArrayList<AlarmReasonVo>();

		Iterator<AlarmReason> iter = list.getList().iterator();
		AlarmReasonVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AlarmReasonVo> vpage = new Page<AlarmReasonVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public AlarmReasonVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AlarmReason entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<AlarmReasonVo> selectListExtendVoByParamVo(AlarmReasonParamVo alarmReason, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (alarmReason == null) {
			alarmReason = new AlarmReasonParamVo();
		}
		alarmReason.setTenantId(commonParam.getTenantId());

		List<AlarmReason> list = (List<AlarmReason>) this.getBaseService().selectListByParamVo(alarmReason,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AlarmReasonVo> selectPageExtendVoByParamVo(AlarmReasonParamVo alarmReason, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (alarmReason == null) {
			alarmReason = new AlarmReasonParamVo();
		}
		alarmReason.setTenantId(commonParam.getTenantId());

		PageInfo<AlarmReason> list = (PageInfo<AlarmReason>) this.getBaseService().selectPageByParamVo(alarmReason,
				commonParam, pageNo, pageSize);
		List<AlarmReasonVo> volist = new ArrayList<AlarmReasonVo>();

		Iterator<AlarmReason> iter = list.getList().iterator();
		AlarmReasonVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AlarmReasonVo> vpage = new Page<AlarmReasonVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(AlarmReasonParamVo alarmReasonParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		AlarmReason alarmReason = null;
		if (alarmReasonParamVo.getReason() == null) {
			resultMessage.addErr("异常原因不能为空");
			return resultMessage;
		}
		try {
			if (alarmReasonParamVo.getId() == null) {// 新增

				alarmReasonParamVo.setTenantId(commonParam.getTenantId());
				alarmReason = alarmReasonService.saveOrUpdate(alarmReasonParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				AlarmReason alarmReasonVoTemp = this.selectById(alarmReasonParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(alarmReasonVoTemp, alarmReasonParamVo);

				alarmReason = alarmReasonService.saveOrUpdate(alarmReasonVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(alarmReason);
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
