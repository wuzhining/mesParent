package com.techsoft.controller.flow;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.techsoft.client.service.struct.ClientStructProcessNodeService;
import com.techsoft.client.service.struct.ClientStructProcessService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.maps.MapUserStatus;
import com.techsoft.common.maps.MapYesOrNo;
import com.techsoft.controller.BaseController;
import com.techsoft.entity.common.StructProcessNode;
import com.techsoft.entity.struct.StructProcessNodeParamVo;
import com.techsoft.entity.struct.StructProcessVo;

@Controller
@RequestMapping("/flow/technologicalProcess")
public class TechnologicalProcessController extends BaseController {
    
	@Autowired
	private ClientStructProcessService clientStructProcessService;
	
	@Autowired 
	private ClientStructProcessNodeService clientStructProcessNodeService;
	
	/**
	 * 页面关联数据初始化
	 * @param modelAndView
	 */
	public void initData(ModelAndView modelAndView) { 
		modelAndView.addObject("mapYesOrNo", MapYesOrNo.getMap());  
	    modelAndView.addObject("mapUserStatus", MapUserStatus.getMap());
	}
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request,Long id) {
		ModelAndView modelAndView = new ModelAndView();
		StructProcessVo entity = new StructProcessVo();
		if (id != null) {
			try {
				entity = clientStructProcessService.getVoByID(id, this.getCommonParam(request));
				
				StructProcessNodeParamVo paramVo = new StructProcessNodeParamVo();
				List<StructProcessNode> ProcessNodeList = clientStructProcessNodeService.selectListByParamVo(paramVo,
						this.getCommonParam(request));
				modelAndView.addObject("ProcessNodeList", ProcessNodeList);
				
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		modelAndView.addObject("entity", entity);
		initData(modelAndView);
		modelAndView.setViewName("flow/technologicalProcess-list");
		return modelAndView;
	}
}
