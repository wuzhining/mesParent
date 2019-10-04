package com.techsoft.controller.equip;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.techsoft.client.service.config.ClientConfigDictionaryService;
import com.techsoft.client.service.equip.ClientEquipClassesWorkService;
import com.techsoft.client.service.equip.ClientEquipSpecsWorkService;
import com.techsoft.client.service.equip.ClientEquipWorkService;
import com.techsoft.client.service.struct.ClientStructFactoryService;
import com.techsoft.client.service.struct.ClientStructProductionlineService;
import com.techsoft.client.service.struct.ClientStructWorkshopAreaService;
import com.techsoft.client.service.struct.ClientStructWorkshopService;
import com.techsoft.client.service.struct.ClientStructWorkstationService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.constants.Constants;
import com.techsoft.common.enums.EnumDictionary;
import com.techsoft.common.enums.EnumEquipStatusType;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.persistence.ReturnPageInfo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.EquipClassesWork;
import com.techsoft.entity.common.EquipSpecsWork;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.StructProductionline;
import com.techsoft.entity.common.StructWorkshop;
import com.techsoft.entity.common.StructWorkshopArea;
import com.techsoft.entity.common.StructWorkstation;
import com.techsoft.entity.equip.EquipClassesWorkParamVo;
import com.techsoft.entity.equip.EquipSpecsWorkParamVo;
import com.techsoft.entity.equip.EquipWorkParamVo;
import com.techsoft.entity.equip.EquipWorkVo;
import com.techsoft.entity.quality.QualityInspectDocumentParamVo;
import com.techsoft.entity.struct.StructFactoryParamVo;
import com.techsoft.entity.struct.StructProductionlineParamVo;
import com.techsoft.entity.struct.StructWorkshopAreaParamVo;
import com.techsoft.entity.struct.StructWorkshopParamVo;

@Controller
@RequestMapping("/equip/equipWork")
public class EquipWorkController extends BaseController {
	@Autowired
	private ClientEquipWorkService clientEquipWorkService;
	@Autowired
	private ClientStructFactoryService clientStructFactoryService;
	@Autowired
	private ClientConfigDictionaryService clientConfigDictionaryService;
	@Autowired
	private ClientStructProductionlineService clientStructProductionlineService;
	@Autowired
	private ClientStructWorkshopAreaService clientStructWorkshopAreaService;
	@Autowired
	private ClientEquipClassesWorkService clientEquipClassesWorkService;
	@Autowired
	private ClientStructWorkshopService clientStructWorkshopService;
	@Autowired
	private ClientEquipSpecsWorkService clientEquipSpecsWorkService;
	@Autowired
	private ClientStructWorkstationService clientStructWorkstationService;
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		try {
			
			StructFactoryParamVo paramVo = new StructFactoryParamVo();
			List<StructFactory> factoryList = clientStructFactoryService.selectListByParamVo(paramVo,
					this.getCommonParam(null));
			modelAndView.addObject("factoryList1", factoryList);
			
			StructProductionlineParamVo SPParamVo = new StructProductionlineParamVo();
			List<StructProductionline> ProducList = clientStructProductionlineService
					.selectListByParamVo(SPParamVo, this.getCommonParam(null));
			modelAndView.addObject("ProducList1", ProducList);
			
			StructWorkshopAreaParamVo SWAParamVo = new StructWorkshopAreaParamVo();
			List<StructWorkshopArea> areaList = clientStructWorkshopAreaService
					.selectListByParamVo(SWAParamVo, this.getCommonParam(null));
			modelAndView.addObject("areaList1", areaList);
			
			EquipClassesWorkParamVo EWparamVo = new EquipClassesWorkParamVo();
			List<EquipClassesWork> EquipWorkList = clientEquipClassesWorkService.selectListByParamVo(EWparamVo,
					this.getCommonParam(null));
			modelAndView.addObject("configDictionaryType1", EquipWorkList);
			
			List<ConfigDictionary> configDictionaryStatus = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.FIXTURE_STATUS.getValue());
			modelAndView.addObject("configDictionaryStatus1", configDictionaryStatus);
			
			List<ConfigDictionary> equipSwitchStatus = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.EQUIP_SWITCH_STATUS.getValue());
			modelAndView.addObject("equipSwitchStatus", equipSwitchStatus);
			//取车间集合
			List<StructWorkshop> structWorkshopList = clientStructWorkshopService.selectListByParamVo(new StructWorkshopParamVo(),this.getCommonParam(null));
			modelAndView.addObject("structWorkshopList", structWorkshopList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());
	}
	
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("equip/equipWork-list");
		return modelAndView;
	}
	

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, Long id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			
			StructFactoryParamVo paramVo = new StructFactoryParamVo();
			List<StructFactory> factoryList = clientStructFactoryService.selectListByParamVo(paramVo,
					this.getCommonParam(null));
			modelAndView.addObject("factoryList", factoryList);
			
			EquipSpecsWorkParamVo EWparamVo = new EquipSpecsWorkParamVo();
			List<EquipSpecsWork> equipSpecsWorkList = clientEquipSpecsWorkService.selectListByParamVo(EWparamVo,this.getCommonParam(null));
			modelAndView.addObject("equipSpecsWorkList", equipSpecsWorkList);
			
			List<ConfigDictionary> configDictionaryStatus = clientConfigDictionaryService
					.selectListByParentId(EnumDictionary.FIXTURE_STATUS.getValue());
			modelAndView.addObject("configDictionaryStatus", configDictionaryStatus);
			
			EquipWorkVo entity = new EquipWorkVo();
			if (id != null) {
				entity = clientEquipWorkService.getVoByID(id, this.getCommonParam(request));

				//获取工厂
				if(entity.getFactoryId()!=null && entity.getFactoryId() > 0L ){
					StructFactory structFactory = clientStructFactoryService.getVoByID(entity.getFactoryId(), this.getCommonParam(request));
					modelAndView.addObject("structFactory", structFactory);
				}
				//获取车间
				if(entity.getWorkshopId()!=null && entity.getWorkshopId() > 0L ){
					StructWorkshop structWorkshop = clientStructWorkshopService.getVoByID(entity.getWorkshopId(), this.getCommonParam(request));
					modelAndView.addObject("structWorkshop", structWorkshop);
				}
				//获取车间区域
				if(entity.getWorkshopAreaId()!=null && entity.getWorkshopAreaId() > 0L){
					StructWorkshopArea structWorkshopArea = clientStructWorkshopAreaService.getVoByID(entity.getWorkshopAreaId(), this.getCommonParam(request));
					modelAndView.addObject("structWorkshopArea", structWorkshopArea);
				}
				//获取工位
				if(entity.getWorkstationId()!=null && entity.getWorkstationId() > 0L){
					StructWorkstation structWorkstation = clientStructWorkstationService.getVoByID(entity.getWorkstationId(), this.getCommonParam(request));
					modelAndView.addObject("structWorkstation", structWorkstation);
				}
				//设备分类
				if(entity.getClassesId()!=null && entity.getClassesId() > 0L){
					EquipClassesWork equipClassesWork = clientEquipClassesWorkService.getVoByID(entity.getClassesId(), this.getCommonParam(request));
					modelAndView.addObject("equipClassesWork", equipClassesWork);
				}
			}
			modelAndView.addObject("entity", entity);
			modelAndView.setViewName("equip/equipWork-edit");
			initData(modelAndView);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/list/json")
	@SuppressWarnings("rawtypes")	
	public ReturnPageInfo listJson(HttpServletRequest request,
			EquipWorkParamVo equipWorkParamVo, Integer pageIndex, Integer pageSize) {
		PageInfo pageInfo = null;
		Integer pageNumber = 0;
		if (pageSize != null) {
			pageNumber = pageSize;
		} else {
			pageNumber = Constants.SEARCH_PAGE_SIZE;
		}		
		try {
            if(equipWorkParamVo==null){
            	equipWorkParamVo = new EquipWorkParamVo();
            }
			pageInfo = clientEquipWorkService.selectPageVoByParamVo(
					equipWorkParamVo, this.getCommonParam(request),
					pageIndex, pageNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return new ReturnPageInfo(pageInfo);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage save(HttpServletRequest request,
			EquipWorkParamVo equipWorkParamVo) {
		ResultMessage resultMessage = new ResultMessage();
	 
	    equipWorkParamVo.setModifyUserId(getLoginUserId(request)); 
		resultMessage = clientEquipWorkService.saveOrUpdate(equipWorkParamVo,
				this.getCommonParam(request));

		return resultMessage;
	}
	
	
	@RequestMapping("/equipWorkOpen")
	public ModelAndView equipWorkOpen(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		initData(modelAndView);
		modelAndView.setViewName("equip/equipWork-Open");
		return modelAndView;
	}
	
	@RequestMapping(value = "/saveFile")
	@ResponseBody
	public ResultMessage saveFile(HttpServletRequest request,@RequestParam(value = "imagePath", required = false) MultipartFile multipartFile) {
		ResultMessage resultMessage = new ResultMessage();
		EquipWorkParamVo equipWorkParamVo = new EquipWorkParamVo();
		String equipCode = request.getParameter("equipCode");
		String equipLabel = request.getParameter("equipLabel");
		String equipName = request.getParameter("equipName");
		String equipPattern = request.getParameter("equipPattern");
		String specsWorkId = request.getParameter("specsWorkId");
		String classesId = request.getParameter("classesId");
		String equipStatusDictId = request.getParameter("equipStatusDictId");
		String switchStatusDictId = request.getParameter("switchStatusDictId");
		String isMonitor = request.getParameter("isMonitor");
		String factoryId = request.getParameter("factoryId");
		String workshopId = request.getParameter("workshopId");
		String workshopAreaId = request.getParameter("workshopAreaId");
		String workstationId = request.getParameter("workstationId");
		/*String productionlineId = request.getParameter("productionlineId");
		String processNodeId = request.getParameter("processNodeId");*/
		String speedWorktime = request.getParameter("speedWorktime");
		String speedQuantity = request.getParameter("speedQuantity");
		String macaddress = request.getParameter("macaddress");
		String ipaddress = request.getParameter("ipaddress");
		String quantityOutput = request.getParameter("quantityOutput");
		String hoursWork = request.getParameter("hoursWork");
		String hoursShutdown = request.getParameter("hoursShutdown");
		String hoursFault = request.getParameter("hoursFault");
		String hoursMaintain = request.getParameter("hoursMaintain");
		String standarlive = request.getParameter("standarlive");
		String dateMake = request.getParameter("dateMake");
		String dateEnter = request.getParameter("dateEnter");
		String remark = request.getParameter("remark");
		
		String id = request.getParameter("id");
		String version = request.getParameter("version");
		if(id!=null && !"".equals(id)){
			equipWorkParamVo.setId(Long.parseLong(id));
		}
		if(version!=null && !"".equals(version)){
			equipWorkParamVo.setVersion(Long.parseLong(version));
		}
		
		equipWorkParamVo.setEquipCode(equipCode);
		equipWorkParamVo.setEquipLabel(equipLabel);
		equipWorkParamVo.setEquipName(equipName);
		equipWorkParamVo.setEquipPattern(equipPattern);
		equipWorkParamVo.setSpecsWorkId(Long.parseLong(specsWorkId));
		equipWorkParamVo.setClassesId(Long.parseLong(classesId));
		equipWorkParamVo.setEquipStatusDictId(Long.parseLong(equipStatusDictId));
		equipWorkParamVo.setSwitchStatusDictId(Long.parseLong(switchStatusDictId));
		equipWorkParamVo.setIsMonitor(isMonitor);
		equipWorkParamVo.setFactoryId(Long.parseLong(factoryId));
		equipWorkParamVo.setWorkshopId(Long.parseLong(workshopId));
		equipWorkParamVo.setWorkshopAreaId(Long.parseLong(workshopAreaId));
		if(workstationId!=null){
		equipWorkParamVo.setWorkstationId(Long.parseLong(workstationId));
		}
		/*equipWorkParamVo.setProductionlineId(Long.parseLong(productionlineId));
		equipWorkParamVo.setProcessNodeId(Long.parseLong(processNodeId));*/
		equipWorkParamVo.setSpeedWorktime(Long.parseLong(speedWorktime));
		equipWorkParamVo.setSpeedQuantity(Double.parseDouble(speedQuantity));
		equipWorkParamVo.setMacaddress(macaddress);
		equipWorkParamVo.setIpaddress(ipaddress);
		equipWorkParamVo.setQuantityOutput(Double.parseDouble(quantityOutput));
		equipWorkParamVo.setHoursWork(Double.parseDouble(hoursWork));
		equipWorkParamVo.setHoursFault(Double.parseDouble(hoursFault));
		equipWorkParamVo.setHoursShutdown(Double.parseDouble(hoursShutdown));
		equipWorkParamVo.setHoursMaintain(Double.parseDouble(hoursMaintain));
		equipWorkParamVo.setStandarlive(Integer.parseInt(standarlive));
		equipWorkParamVo.setDateMake(dateMake);
		equipWorkParamVo.setDateEnter(dateEnter);
		equipWorkParamVo.setRemark(remark);
		
		//获取当前日期作为文件名前8位
		Date date = new Date();
		//格式化时间
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyyMMdd"); 
		String dataFile= dFormat.format(date);
		System.out.println(dataFile);
		
		//获取一个不重复的文件名
		//String fileName = UUID.randomUUID().toString().replace("-", "");
		String fileName = UUID.randomUUID().toString().substring(0,6).replace("-", "");
		System.out.println(fileName);
		//获取前段传过来的真实文件名
		String realName = multipartFile.getOriginalFilename();
		//获取文件名的后缀名
		String typeName= realName.substring(realName.lastIndexOf(".")); 
		String saveFileName = dataFile + "-" +  fileName + typeName;
		//获取当前站点中上传文件的位置物理路径
		//String savePath = request.getSession().getServletContext().getRealPath("/upload/inspect");
		
		//获取项目路径
		File systemFile = new File(this.getClass().getResource("/../../").getPath());
		//获取工作空间路径
		String path0 = systemFile.toString().substring(0, systemFile.toString().indexOf(".metadata"));
		String savePath = path0+"mesParent\\dubbo-admin\\src\\main\\webapp\\upload\\images";
		System.out.println("文件保存路径为:"+savePath);
		
        File createFile = new File(savePath);

        if  (!createFile.exists() && !createFile.isDirectory()) {   
        	  createFile.mkdirs();
        	  System.out.println("创建文件夹路径为："+ createFile.getPath());	
           }

    		
		try {
			File file = new File(savePath+"/"+ saveFileName);
			String pathName = file.toString().substring(file.toString().lastIndexOf("upload"));
			
			equipWorkParamVo.setImagePath("\\"+pathName);
			equipWorkParamVo.setModifyUserId(getLoginUserId(request));
			resultMessage = clientEquipWorkService.saveOrUpdate(equipWorkParamVo,this.getCommonParam(request));
			
			long startTime=System.currentTimeMillis();   //获取开始时间
			multipartFile.transferTo(file);
			long endTime=System.currentTimeMillis(); //获取结束时间 
			
			System.out.println("程序startTime时间： "+(startTime)+"ms");
			System.out.println("程序endTime时间： "+(endTime)+"ms");
			System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resultMessage;
	}
}
