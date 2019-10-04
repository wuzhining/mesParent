package com.techsoft.dao.work;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.techsoft.common.BaseDaoImpl;
import com.techsoft.common.BaseMapper;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumWorkPlanStatus;
import com.techsoft.common.enums.EnumYesOrNo;
import com.techsoft.mapper.sys.MycatSequenceMapper;
import com.techsoft.entity.common.WorkPlanEquip;
import com.techsoft.entity.work.WorkPlanEquipParamVo;
import com.techsoft.mapper.work.WorkPlanEquipMapper;

@Repository
public class WorkPlanEquipDaoImpl extends BaseDaoImpl<WorkPlanEquip> implements WorkPlanEquipDao {
	@Resource
	protected WorkPlanEquipMapper workPlanEquipMapper;
	@Resource
	protected MycatSequenceMapper mycatSequenceMapper;	
	
	@Override
	public Class<WorkPlanEquip> getEntityClass() {
		return WorkPlanEquip.class;
	}	
	
	@Override
	public BaseMapper<WorkPlanEquip> getBaseMapper() {
		return this.workPlanEquipMapper;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public BaseMapper getSeqMapper() {
		return mycatSequenceMapper;
	}
	
	@Override
	public String getTableName() {
		return "WORK_PLAN_EQUIP";
	}
	
	@Override
	public void insertSaveCheck(WorkPlanEquip value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void updateSaveCheck(WorkPlanEquip value) throws BusinessException, SQLException {
	
	}
	
	@Override
	public void deleteSaveCheck(WorkPlanEquip value) throws BusinessException, SQLException {
	
	}

	@Override
	public void insertBatch(List<WorkPlanEquip> items, CommonParam commonParam) throws BusinessException, SQLException {
		// TODO Auto-generated method stub
		int rows = workPlanEquipMapper.insertBatch(items);
		if (rows != items.size()) {
			throw new BusinessException("新增行数不一致！请检查");
		}
	}

	@Override
	public List<WorkPlanEquip> selectListCanWorking(WorkPlanEquipParamVo workPlanEquipParamVo, CommonParam commonParam)
			throws BusinessException, SQLException {
		if(workPlanEquipParamVo==null){
			workPlanEquipParamVo = new WorkPlanEquipParamVo();
			workPlanEquipParamVo.setTenantId(commonParam.getTenantId());
		}
		List<WorkPlanEquip> list = new ArrayList<WorkPlanEquip>();
		workPlanEquipParamVo.setIsLocked(EnumYesOrNo.NO.getValue());// 未锁定的，
		workPlanEquipParamVo.setPlanStatusDictId(EnumWorkPlanStatus.NOTSTARTED.getValue());// 未开始
		List<WorkPlanEquip> list1 = workPlanEquipMapper.selectListByEntityParamVo(workPlanEquipParamVo);
		if ((list1 != null) && (!list1.isEmpty())) {
			list.addAll(list1);
		}
		
		workPlanEquipParamVo.setPlanStatusDictId(EnumWorkPlanStatus.DOING.getValue());// 进行中的
		List<WorkPlanEquip> list2 = workPlanEquipMapper.selectListByEntityParamVo(workPlanEquipParamVo);
		if ((list2 != null) && (!list2.isEmpty())) {
			list.addAll(list2);
		}
		return list;
	}
			
}
