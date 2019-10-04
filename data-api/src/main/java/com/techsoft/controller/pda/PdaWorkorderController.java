package com.techsoft.controller.pda;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techsoft.client.service.bill.ClientBillWorkorderService;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.product.ClientProductBomService;
import com.techsoft.client.service.product.ClientProductMainService;
import com.techsoft.client.service.struct.ClientStructProcessNodeService;
import com.techsoft.client.service.struct.ClientStructProcessProductService;
import com.techsoft.client.service.struct.ClientStructProcessService;
import com.techsoft.client.service.struct.ClientStructWorkshopService;
import com.techsoft.client.service.work.ClientWorkPlanMaterialService;
import com.techsoft.client.service.work.ClientWorkTaskProcedureService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.enums.EnumAuditStatus;
import com.techsoft.common.enums.EnumProductType;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.bill.BillWorkorderParamVo;
import com.techsoft.entity.bill.BillWorkorderVo;
import com.techsoft.entity.common.StructProcess;
import com.techsoft.entity.product.ProductBomVo;
import com.techsoft.entity.struct.StructProcessNodeParamVo;
import com.techsoft.entity.struct.StructProcessNodeVo;
import com.techsoft.entity.struct.StructProcessProductParamVo;
import com.techsoft.entity.struct.StructProcessProductVo;
import com.techsoft.entity.work.WorkPlanMaterialParamVo;
import com.techsoft.entity.work.WorkPlanMaterialVo;
import com.techsoft.entity.work.WorkTaskProcedureParamVo;
import com.techsoft.entity.work.WorkTaskProcedureVo;

/**
 * pda请求工单controller层
 * 
 * @author
 *
 */
@Controller
@RequestMapping("/pda/workorder")
public class PdaWorkorderController extends BaseController {
	@Autowired
	private ClientBillWorkorderService clientBillWorkorderService;
	@Autowired
	private ClientProductBomService clientProductBomService;
	@Autowired
	private ClientWorkTaskProcedureService clientWorkTaskProcedureService;
	@Autowired
	private ClientWorkPlanMaterialService clientWorkPlanMaterialService;
	@Autowired
	private ClientStructProcessProductService clientStructProcessProductService;
	@Autowired
	private ClientStructProcessNodeService clientStructProcessNodeService;

	// 工单列表
	@ResponseBody
	@RequestMapping("/list")
	public ResultMessage list(HttpServletRequest request, Long factoryId, Long workshopId, Long status) {
 
		ResultMessage resultMessage = new ResultMessage();
		List<BillWorkorderVo> list = new ArrayList<BillWorkorderVo>();
		if (factoryId == null) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工厂ID不能为空");
		}
		if (status == null) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("状态不能为空");
		}
		try {
			BillWorkorderParamVo structFactoryParamVo = new BillWorkorderParamVo();
			structFactoryParamVo.setTenantId(getLoginTenantId(request));
			structFactoryParamVo.setAuditStatusDictId(EnumAuditStatus.AUDITED.getValue());
			structFactoryParamVo.setWorkorderStatusDictId(status);
			structFactoryParamVo.setFactoryId(factoryId); 
			 
			list = clientBillWorkorderService.selectListVoByParamVo(structFactoryParamVo, this.getCommonParam(request));

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

	// 工单明细
	@ResponseBody
	@RequestMapping("/detail")
	public ResultMessage detail(HttpServletRequest request, String orderCode) {

		ResultMessage resultMessage = new ResultMessage();

		BillWorkorderVo entity = new BillWorkorderVo();
		try {
			if (StringUtils.isNotBlank(orderCode)) {
				entity = clientBillWorkorderService.getVoByCode(orderCode, this.getCommonParam(request));
				resultMessage.put(entity);
			} else {
				resultMessage.addErr("工单编码不能为空");
			}
		} catch (BusinessException e) {
			resultMessage.addErr("业务运行异常");
		} catch (SQLException e) {
			resultMessage.addErr("SQL查询异常");
		}

		return resultMessage;
	}

	// 工单的工序任务列表
	@ResponseBody
	@RequestMapping("/taskProcedureList")
	public ResultMessage taskProcedureList(HttpServletRequest request, String orderCode) {
		ResultMessage resultMessage = new ResultMessage();
		List<WorkTaskProcedureVo> list = new ArrayList<WorkTaskProcedureVo>();

		if (StringUtils.isBlank(orderCode)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工单编码不能为空");
		}
		try {
			BillWorkorderVo entity = clientBillWorkorderService.getVoByCode(orderCode, this.getCommonParam(request));
			if (entity == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到工单");
			}
			WorkTaskProcedureParamVo workTaskProcedureParamVo = new WorkTaskProcedureParamVo();
			workTaskProcedureParamVo.setTenantId(getLoginTenantId(request));
			workTaskProcedureParamVo.setBillWorkorderId(entity.getId());
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

	// 工单的工艺路线列表
	@ResponseBody
	@RequestMapping("/processList")
	public ResultMessage processList(HttpServletRequest request, String orderCode) {
		ResultMessage resultMessage = new ResultMessage();

		if (StringUtils.isBlank(orderCode)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工单编码不能为空");
		}
		try {
			BillWorkorderVo entity = clientBillWorkorderService.getVoByCode(orderCode, this.getCommonParam(request));
			if (entity == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到工单");
			}
			Long bomId = entity.getBomId();

			List<StructProcess> list = new ArrayList();
			List<ProductBomVo> bomTreeList = clientProductBomService.selectListBomTree(bomId,
					this.getCommonParam(request));
			if ((bomTreeList != null) && (!bomTreeList.isEmpty())) {
 
				for (ProductBomVo productBomVo : bomTreeList) {
					//System.out.println("   productBomVo.getId()==" + productBomVo.getId()+"   productBomVo.getProductType().getId()==" + productBomVo.getProductType().getId()); 
					//if (!EnumProductType.RAWMATERIAL.getValue().equals(productBomVo.getProductType().getId())) {
					
						StructProcessProductParamVo structProcessProductParamVo = new StructProcessProductParamVo();
						structProcessProductParamVo.setTenantId(getLoginTenantId(request));
						structProcessProductParamVo.setBomId(productBomVo.getId());
						List<StructProcessProductVo> processProductList = clientStructProcessProductService
								.selectListVoByParamVo(structProcessProductParamVo, this.getCommonParam(request));
					 
						if ((processProductList != null) && (!processProductList.isEmpty())) {
							list.add(processProductList.get(0).getStructProcess());
						}

					//}
				}
			}

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

	// 工单工序列表
	@ResponseBody
	@RequestMapping("/processNodeList")
	public ResultMessage processNodeList(HttpServletRequest request, String orderCode, Long processId) {
		ResultMessage resultMessage = new ResultMessage();

		if (StringUtils.isBlank(orderCode)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工单编码不能为空");
		}
		if (processId == null) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工单编码不能为空");
		}
		try {
			BillWorkorderVo entity = clientBillWorkorderService.getVoByCode(orderCode, this.getCommonParam(request));
			if (entity == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到工单");
			}
			StructProcessNodeParamVo structProcessNodeParamVo = new StructProcessNodeParamVo();
			structProcessNodeParamVo.setTenantId(getLoginTenantId(request));
			structProcessNodeParamVo.setProcessId(processId);
			List<StructProcessNodeVo> list = clientStructProcessNodeService
					.selectListVoByParamVo(structProcessNodeParamVo, this.getCommonParam(request));

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

	// 工单的物料列表
	@ResponseBody
	@RequestMapping("/materialList")
	public ResultMessage materialList(HttpServletRequest request, String orderCode, Long processNodeId) {
		ResultMessage resultMessage = new ResultMessage();
		List<WorkPlanMaterialVo> list = new ArrayList<WorkPlanMaterialVo>();

		if (StringUtils.isBlank(orderCode)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工单编码不能为空");
		}
		try {
			BillWorkorderVo entity = clientBillWorkorderService.getVoByCode(orderCode, this.getCommonParam(request));
			if (entity == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到工单");
			}

			WorkPlanMaterialParamVo workPlanMaterial = new WorkPlanMaterialParamVo(); 
			workPlanMaterial.setTenantId(getLoginTenantId(request));
			workPlanMaterial.setBillWorkorderId(entity.getId());
			workPlanMaterial.setProcessNodeId(processNodeId);
			list = clientWorkPlanMaterialService.selectListVoByParamVo(workPlanMaterial, this.getCommonParam(request));

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
