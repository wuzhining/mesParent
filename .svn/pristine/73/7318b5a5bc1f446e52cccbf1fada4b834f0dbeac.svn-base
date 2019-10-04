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
import com.techsoft.entity.alarm.AlarmProblemParamVo;
import com.techsoft.entity.alarm.AlarmProblemVo;
import com.techsoft.entity.common.AlarmProblem;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.service.alarm.AlarmProblemService;
import com.techsoft.service.config.ConfigDictionaryService;

@org.springframework.stereotype.Service
public class ClientAlarmProblemServiceImpl extends BaseClientServiceImpl<AlarmProblem>
		implements ClientAlarmProblemService {
	@com.alibaba.dubbo.config.annotation.Reference
	private AlarmProblemService alarmProblemService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;

	@Override
	public BaseService<AlarmProblem> getBaseService() {
		return alarmProblemService;
	}

	private AlarmProblemVo getVo(AlarmProblem alarmProblem, CommonParam commonParam)
			throws BusinessException, SQLException {
		AlarmProblemVo vo = new AlarmProblemVo(alarmProblem);
		if (vo.getAlarmTypeDictId() != null && vo.getAlarmTypeDictId() > 0L) {
			ConfigDictionary configDictionary = configDictionaryService.selectById(vo.getAlarmTypeDictId(),
					commonParam);
			if (configDictionary != null) {
				vo.setConfigDictionary(configDictionary);
			}
		}
		return vo;
	}

	private AlarmProblemVo getExtendVo(AlarmProblem alarmProblem, CommonParam commonParam)
			throws BusinessException, SQLException {
		AlarmProblemVo vo = this.getVo(alarmProblem, commonParam);

		return vo;
	}

	private List<AlarmProblemVo> getVoList(List<AlarmProblem> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AlarmProblemVo> voList = new ArrayList<AlarmProblemVo>();
		for (AlarmProblem entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<AlarmProblemVo> getExtendVoList(List<AlarmProblem> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<AlarmProblemVo> voList = new ArrayList<AlarmProblemVo>();
		for (AlarmProblem entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public AlarmProblemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AlarmProblem entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<AlarmProblemVo> selectListVoByParamVo(AlarmProblemParamVo alarmProblem, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (alarmProblem == null) {
			alarmProblem = new AlarmProblemParamVo();
		}
		alarmProblem.setTenantId(commonParam.getTenantId());

		List<AlarmProblem> list = (List<AlarmProblem>) this.getBaseService().selectListByParamVo(alarmProblem,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AlarmProblemVo> selectPageVoByParamVo(AlarmProblemParamVo alarmProblem, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (alarmProblem == null) {
			alarmProblem = new AlarmProblemParamVo();
		}
		alarmProblem.setTenantId(commonParam.getTenantId());

		PageInfo<AlarmProblem> list = (PageInfo<AlarmProblem>) this.getBaseService().selectPageByParamVo(alarmProblem,
				commonParam, pageNo, pageSize);
		List<AlarmProblemVo> volist = new ArrayList<AlarmProblemVo>();

		Iterator<AlarmProblem> iter = list.getList().iterator();
		AlarmProblemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AlarmProblemVo> vpage = new Page<AlarmProblemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public AlarmProblemVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		AlarmProblem entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<AlarmProblemVo> selectListExtendVoByParamVo(AlarmProblemParamVo alarmProblem, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (alarmProblem == null) {
			alarmProblem = new AlarmProblemParamVo();
		}
		alarmProblem.setTenantId(commonParam.getTenantId());

		List<AlarmProblem> list = (List<AlarmProblem>) this.getBaseService().selectListByParamVo(alarmProblem,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<AlarmProblemVo> selectPageExtendVoByParamVo(AlarmProblemParamVo alarmProblem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (alarmProblem == null) {
			alarmProblem = new AlarmProblemParamVo();
		}
		alarmProblem.setTenantId(commonParam.getTenantId());

		PageInfo<AlarmProblem> list = (PageInfo<AlarmProblem>) this.getBaseService().selectPageByParamVo(alarmProblem,
				commonParam, pageNo, pageSize);
		List<AlarmProblemVo> volist = new ArrayList<AlarmProblemVo>();

		Iterator<AlarmProblem> iter = list.getList().iterator();
		AlarmProblemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<AlarmProblemVo> vpage = new Page<AlarmProblemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(AlarmProblemParamVo alarmProblemParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		AlarmProblem alarmProblem = null;
		try {
			if (alarmProblemParamVo.getId() == null) {// 新增

				alarmProblemParamVo.setTenantId(commonParam.getTenantId());
				alarmProblem = alarmProblemService.saveOrUpdate(alarmProblemParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				AlarmProblem alarmProblemVoTemp = this.selectById(alarmProblemParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(alarmProblemVoTemp, alarmProblemParamVo);

				alarmProblem = alarmProblemService.saveOrUpdate(alarmProblemVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(alarmProblem);
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
