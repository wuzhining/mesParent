package com.techsoft.controller.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techsoft.client.service.work.ClientWorkTaskProcedureService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumWorkTaskStatus;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.work.WorkTaskProcedureParamVo;
import com.techsoft.entity.work.WorkTaskProcedureVo;

@Controller
@RequestMapping("/board/workTask")
public class BoardWorkTaskProcedureController extends BaseController {
	@Autowired
	private ClientWorkTaskProcedureService clientWorkTaskProcedureService;

	// 生产线工序任务列表
	@ResponseBody
	@RequestMapping("/list")
	public ResultMessage list(HttpServletRequest request, Long factoryId, Long workshopId) {
		ResultMessage resultMessage = new ResultMessage();
		List<WorkTaskProcedureVo> list = new ArrayList<WorkTaskProcedureVo>();
		if (factoryId == null) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工厂ID不能为空");
		}
		try {

			WorkTaskProcedureParamVo workTaskProcedureParamVo = new WorkTaskProcedureParamVo();
			workTaskProcedureParamVo.setTenantId(getLoginTenantId(request));
			workTaskProcedureParamVo.setFactoryId(factoryId);
			workTaskProcedureParamVo.setWorkshopId(workshopId);
			workTaskProcedureParamVo.setTaskStatusDictId(EnumWorkTaskStatus.DOING.getValue());
			list = clientWorkTaskProcedureService.selectListVoByParamVo(workTaskProcedureParamVo,
					this.getCommonParam(request));

			if ((list == null) || (list.isEmpty())) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("无信息");
			} else {
				resultMessage.setIsSuccess(true);
				resultMessage.put(list);
			}

		} catch (BusinessException e) {
			resultMessage.addErr("业务运行异常");
		} catch (SQLException e) {
			resultMessage.addErr("SQL查询异常");
		}

		return resultMessage;
	}
}
