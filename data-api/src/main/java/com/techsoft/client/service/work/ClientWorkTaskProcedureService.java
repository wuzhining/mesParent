package com.techsoft.client.service.work;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.entity.common.WorkTaskProcedure;
import com.techsoft.entity.equip.EquipWorkStackProductVo;
import com.techsoft.entity.work.WorkTaskProcedureParamVo;
import com.techsoft.entity.work.WorkTaskProcedureVo;

public interface ClientWorkTaskProcedureService extends BaseClientService<WorkTaskProcedure> {

	public WorkTaskProcedureVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<WorkTaskProcedureVo> selectListVoByParamVo(WorkTaskProcedureParamVo workTaskProcedure,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<WorkTaskProcedureVo> selectPageVoByParamVo(WorkTaskProcedureParamVo workTaskProcedure,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public WorkTaskProcedureVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException;

	public List<WorkTaskProcedureVo> selectListExtendVoByParamVo(WorkTaskProcedureParamVo workTaskProcedure,
			CommonParam commonParam) throws BusinessException, SQLException;

	public PageInfo<WorkTaskProcedureVo> selectPageExtendVoByParamVo(WorkTaskProcedureParamVo workTaskProcedure,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException;

	public ResultMessage saveOrUpdate(WorkTaskProcedureParamVo workTaskProcedureParamVo, CommonParam commonParam);

	// 贴标
	public ResultMessage labeling(CommonParam commonParam, Long factoryId, String workstationCode, String equipCode,
			String barcodeRaw, String barcodeNewList);

	// 通过工位上料
	public ResultMessage feedByWorkstation(CommonParam commonParam, Long factoryId, String workstationCode,
			String barcode);

	// 通过载料器上料
	public ResultMessage feedByFixture(CommonParam commonParam, Long factoryId, String equipCode, String fixtureCode,
			String barcode);

	// 通过栈位上料
	public ResultMessage feedByStack(CommonParam commonParam, Long factoryId, String equipStackCode,
			String fixtureStackCode, String barcode);

	// 通过接料上料
	public ResultMessage feedByConnectRaw(CommonParam commonParam, Long factoryId, String barcodeOld,
			String barcodeNew);

	// 扫描过站
	public ResultMessage passByScanner(CommonParam commonParam, Long factoryId, String macaddress, String code);

	// 通过组装扫描仪进站
	public ResultMessage enterByAssembleScanner(CommonParam commonParam, Long factoryId, String macaddress,
			String barcodeList);

	// 通过解绑载料器扫描仪进站
	public ResultMessage enterByUnbindFixtureScanner(CommonParam commonParam, Long factoryId, String macaddress,
			String equipFixtureCode);

	// 通过绑定载料器扫描仪进站
	public ResultMessage enterByBindFixtureScanner(CommonParam commonParam, Long factoryId, String macaddress,
			String code);

	// 解绑载料器
	public ResultMessage unbindFixture(CommonParam commonParam, Long factoryId, String equipCode,
			String equipFixtureCode);

	// 解绑设备栈位
	public ResultMessage unbindEquipStack(CommonParam commonParam, Long factoryId, String equipStackCode);

	// 查找工序任务
	public ResultMessage getVoByWorkstation(CommonParam commonParam, Long factoryId, Long billWorkorderId,
			Long workstationId, String workstationCode) throws BusinessException, SQLException;

}
