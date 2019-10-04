package com.techsoft.client.service.firm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.FirmDepartment;
import com.techsoft.entity.common.FirmPost;
import com.techsoft.entity.firm.FirmPostVo;
import com.techsoft.entity.firm.FirmPostParamVo;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.firm.FirmDepartmentService;
import com.techsoft.service.firm.FirmPostService;

@org.springframework.stereotype.Service
public class ClientFirmPostServiceImpl extends BaseClientServiceImpl<FirmPost> implements ClientFirmPostService {
	@com.alibaba.dubbo.config.annotation.Reference
	private FirmPostService firmPostService;
	@com.alibaba.dubbo.config.annotation.Reference
	private FirmDepartmentService firmDepartmentService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;

	@Override
	public BaseService<FirmPost> getBaseService() {
		return firmPostService;
	}

	private FirmPostVo getVo(FirmPost firmPost, CommonParam commonParam) throws BusinessException, SQLException {
		FirmPostVo vo = new FirmPostVo(firmPost);
		if (vo.getDepartmenId() != null && vo.getDepartmenId() > 0L) {
			FirmDepartment firmDepartment = firmDepartmentService.selectById(vo.getDepartmenId(), commonParam);
			if (firmDepartment != null) {
				vo.setFirmDepartment(firmDepartment);
			}
		}
		if (vo.getParentId() != null && vo.getParentId() >= 0L) {
			FirmPost firmPost2 = firmPostService.selectById(vo.getParentId(), commonParam);
			if (firmPost2 != null) {
				vo.setFirmPost(firmPost2);
			}
		}
		return vo;
	}

	private FirmPostVo getExtendVo(FirmPost firmPost, CommonParam commonParam) throws BusinessException, SQLException {
		FirmPostVo vo = this.getVo(firmPost, commonParam);

		return vo;
	}

	private List<FirmPostVo> getVoList(List<FirmPost> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<FirmPostVo> voList = new ArrayList<FirmPostVo>();
		for (FirmPost entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<FirmPostVo> getExtendVoList(List<FirmPost> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<FirmPostVo> voList = new ArrayList<FirmPostVo>();
		for (FirmPost entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public FirmPostVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		FirmPost entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<FirmPostVo> selectListVoByParamVo(FirmPostParamVo firmPost, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (firmPost == null) {
			firmPost = new FirmPostParamVo();
		}
		firmPost.setTenantId(commonParam.getTenantId());

		List<FirmPost> list = (List<FirmPost>) this.getBaseService().selectListByParamVo(firmPost, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<FirmPostVo> selectPageVoByParamVo(FirmPostParamVo firmPost, CommonParam commonParam, int pageNo,
			int pageSize) throws BusinessException, SQLException {
		if (firmPost == null) {
			firmPost = new FirmPostParamVo();
		}
		firmPost.setTenantId(commonParam.getTenantId());

		PageInfo<FirmPost> list = (PageInfo<FirmPost>) this.getBaseService().selectPageByParamVo(firmPost, commonParam,
				pageNo, pageSize);
		List<FirmPostVo> volist = new ArrayList<FirmPostVo>();

		Iterator<FirmPost> iter = list.getList().iterator();
		FirmPostVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<FirmPostVo> vpage = new Page<FirmPostVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public FirmPostVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		FirmPost entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<FirmPostVo> selectListExtendVoByParamVo(FirmPostParamVo firmPost, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (firmPost == null) {
			firmPost = new FirmPostParamVo();
		}
		firmPost.setTenantId(commonParam.getTenantId());

		List<FirmPost> list = (List<FirmPost>) this.getBaseService().selectListByParamVo(firmPost, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<FirmPostVo> selectPageExtendVoByParamVo(FirmPostParamVo firmPost, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (firmPost == null) {
			firmPost = new FirmPostParamVo();
		}
		firmPost.setTenantId(commonParam.getTenantId());

		PageInfo<FirmPost> list = (PageInfo<FirmPost>) this.getBaseService().selectPageByParamVo(firmPost, commonParam,
				pageNo, pageSize);
		List<FirmPostVo> volist = new ArrayList<FirmPostVo>();

		Iterator<FirmPost> iter = list.getList().iterator();
		FirmPostVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<FirmPostVo> vpage = new Page<FirmPostVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(FirmPostParamVo firmPostParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		if (firmPostParamVo.getDepartmenId() == null) {
			resultMessage.addErr("所属部门不能为空");
			return resultMessage;
		}
		if (firmPostParamVo.getPostName() == null) {
			resultMessage.addErr("岗位名称不能为空");
			return resultMessage;
		}
		if (firmPostParamVo.getIsValid() == null) {
			resultMessage.addErr("是否有效不能为空");
			return resultMessage;
		}
		FirmPost firmPost = null;
		try {
			if (firmPostParamVo.getId() == null) {// 新增
				//生成编码
				String code = firmPostParamVo.getPostCode();
				if(StringUtils.isBlank(code)){
					code = configCodeRuleService.createCode(FirmPost.class.getName(), null, null, commonParam);
					firmPostParamVo.setPostCode(code);
				}
				if(StringUtils.isBlank(code)){
					resultMessage.addErr("岗位编码不能为空");
				}
				//检验编码是否已存在
				FirmPostParamVo firmPostSearch = new FirmPostParamVo();
				firmPostSearch.setPostCode(code);
				List<FirmPost> list = firmPostService.selectListByParamVo(firmPostSearch, commonParam);
				if((list!=null)&&(!list.isEmpty())){
					resultMessage.addErr("岗位编码已存在");
					return resultMessage;
				}
				firmPostParamVo.setTenantId(commonParam.getTenantId());
				firmPost = firmPostService.saveOrUpdate(firmPostParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				FirmPost firmPostVoTemp = this.selectById(firmPostParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(firmPostVoTemp, firmPostParamVo);

				firmPost = firmPostService.saveOrUpdate(firmPostVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(firmPost);
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
