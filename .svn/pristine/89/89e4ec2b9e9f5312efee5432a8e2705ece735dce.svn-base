package com.techsoft.controller.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.equip.ClientEquipWorkService;
import com.techsoft.client.service.scada.ClientScadaDfldipService;
import com.techsoft.client.service.track.ClientTrackBarcodeService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.equip.EquipWorkParamVo;
import com.techsoft.entity.equip.EquipWorkVo;
import com.techsoft.entity.scada.ScadaDfldipParamVo;
import com.techsoft.entity.scada.ScadaDfldipVo;
import com.techsoft.entity.track.TrackBarcodeParamVo;
import com.techsoft.entity.track.TrackBarcodeVo;

@Controller
@RequestMapping("/board/equipWork")
public class BoardEquipWorkController extends BaseController {
	@Autowired
	private ClientEquipWorkService clientEquipWorkService;
	@Autowired
	private ClientScadaDfldipService clientScadaDfldipService;
	@Autowired
	private ClientTrackBarcodeService clientTrackBarcodeService;

	@ResponseBody
	@RequestMapping("/list")
	public ResultMessage list(HttpServletRequest request, Long factoryId, Long workshopId,Long switchStatus) {
		ResultMessage resultMessage = new ResultMessage();
		List<EquipWorkVo> equipWorkList = new ArrayList<EquipWorkVo>();
		if (factoryId == null) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工厂ID不能为空");
		}
		 
		try { 
		 
			EquipWorkParamVo equipWorkParamVo = new EquipWorkParamVo();
			equipWorkParamVo.setTenantId(getLoginTenantId(request));
			equipWorkParamVo.setFactoryId(factoryId);
			equipWorkParamVo.setWorkshopId(workshopId);
			equipWorkParamVo.setSwitchStatusDictId(switchStatus);
			equipWorkParamVo.setIsMonitor(EnumYesOrNo.YES.getValue());
			equipWorkList = clientEquipWorkService.selectListVoByParamVo(equipWorkParamVo,
					this.getCommonParam(request));

			if ((equipWorkList == null) || (equipWorkList.isEmpty())) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("无生产设备信息");
			} else {
				resultMessage.setIsSuccess(true);
				resultMessage.put(equipWorkList);
			}

		} catch (BusinessException e) {
			resultMessage.addErr("业务运行异常");
		} catch (SQLException e) {
			resultMessage.addErr("SQL查询异常");
		} 
		return resultMessage;
	}

	@ResponseBody
	@RequestMapping("/detail")
	public ResultMessage detail(HttpServletRequest request, Long factoryId, String equipCode) {
		ResultMessage resultMessage = new ResultMessage();
		if (factoryId == null) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工厂ID不能为空");
		}
		if (StringUtils.isBlank(equipCode)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("设备编码不能为空");
			return resultMessage;
		}

		try {

			EquipWorkVo equipWorkVo = clientEquipWorkService.getByEquipCode(equipCode, this.getCommonParam(request));

			if (equipWorkVo == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到生产设备");
			} else {
				List<EquipWorkVo> equipWorkList = new ArrayList<EquipWorkVo>();
				equipWorkList.add(equipWorkVo);
				resultMessage.setIsSuccess(true);
				resultMessage.put(equipWorkList);
			}

		} catch (BusinessException e) {
			resultMessage.addErr("业务运行异常");
		} catch (SQLException e) {
			resultMessage.addErr("SQL查询异常");
		}

		return resultMessage;
	}

	@ResponseBody
	@RequestMapping("/listScada")
	public ResultMessage listScada(HttpServletRequest request, Long factoryId, String equipCode) {
		ResultMessage resultMessage = new ResultMessage();

		if (factoryId == null) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工厂ID不能为空");
		}

		try {
			List<String> paramnameList = new ArrayList();
			paramnameList.add("Speed");// 运行速度
			paramnameList.add("InsertCell");// 插件数
			paramnameList.add("TakeCell");// 取料数
			paramnameList.add("ThrowCell");// 抛料数
			paramnameList.add("NullCell");// 空取数
			paramnameList.add("AverageSpeed");// 平均插件速度
			paramnameList.add("TotalCount");// 插件个数
			paramnameList.add("LineSpeed");// 产线节拍
			paramnameList.add("MachineSpeed");// 机器节拍

			Map<String, Object> map = new HashMap();
			for (String paramname : paramnameList) {
				ScadaDfldipParamVo scadaDfldipParamVo = new ScadaDfldipParamVo();
				scadaDfldipParamVo.setParamname(paramname);
				List<ScadaDfldipVo> list = null;
				Integer pageNumber = Constants.SEARCH_PAGE_SIZE;
				PageInfo pageInfo = clientScadaDfldipService.selectPageVoByParamVo(scadaDfldipParamVo,
						this.getCommonParam(request), 1, pageNumber);
				if (pageInfo != null && pageInfo.getTotal() > 0) {
					list = pageInfo.getList();
				} 
				if ((list != null) && (!list.isEmpty())) {
					map.put(paramname, list);
				}
			}

			if ((map == null) || (map.isEmpty())) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("无Scada生产信息");
			} else {
				resultMessage.setIsSuccess(true);
				resultMessage.setMap(map); 
			}

		} catch (BusinessException e) {
			resultMessage.addErr("业务运行异常");
		} catch (SQLException e) {
			resultMessage.addErr("SQL查询异常");
		}

		return resultMessage;
	}

	@ResponseBody
	@RequestMapping("/listWork")
	public ResultMessage listWork(HttpServletRequest request, Long factoryId, String equipCode) {
		ResultMessage resultMessage = new ResultMessage();
		if (factoryId == null) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("工厂ID不能为空");
		}

		if (StringUtils.isBlank(equipCode)) {
			resultMessage.setIsSuccess(false);
			resultMessage.addErr("设备编码不能为空");
			return resultMessage;
		}

		try {

			EquipWorkVo equipWorkVo = clientEquipWorkService.getByEquipCode(equipCode, this.getCommonParam(request));

			if (equipWorkVo == null) {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("找不到生产设备");
				return resultMessage;
			}
			TrackBarcodeParamVo trackBarcodeParamVo = new TrackBarcodeParamVo();
			trackBarcodeParamVo.setTenantId(getLoginTenantId(request));
			trackBarcodeParamVo.setFactoryId(factoryId);
			trackBarcodeParamVo.setEquipWorkId(equipWorkVo.getId()); 
			 
			List<TrackBarcodeVo> list = null;
			Integer pageNumber = Constants.SEARCH_PAGE_SIZE;
			PageInfo pageInfo = clientTrackBarcodeService.selectPageVoByParamVo(trackBarcodeParamVo,
					this.getCommonParam(request), 1, pageNumber);
 
			if (pageInfo != null && pageInfo.getTotal() > 0) {
				list = pageInfo.getList();  
			} 
			if ((list != null) && (!list.isEmpty())) {
				resultMessage.setIsSuccess(true);
				resultMessage.put(list);
			} else {
				resultMessage.setIsSuccess(false);
				resultMessage.addErr("无作业信息");
			}

		} catch (BusinessException e) {
			resultMessage.addErr("业务运行异常");
		} catch (SQLException e) {
			e.printStackTrace();
			resultMessage.addErr("SQL查询异常");
		}

		return resultMessage;
	}
}
