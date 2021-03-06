package com.techsoft.client.service.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ProductClasses;
import com.techsoft.entity.product.ProductClassesParamVo;
import com.techsoft.entity.product.ProductClassesVo;
import com.techsoft.service.config.ConfigCodeRuleService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.product.ProductClassesService;

@org.springframework.stereotype.Service
public class ClientProductClassesServiceImpl extends BaseClientServiceImpl<ProductClasses>
		implements ClientProductClassesService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductClassesService productClassesService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigCodeRuleService configCodeRuleService;

	@Override
	public BaseService<ProductClasses> getBaseService() {
		return productClassesService;
	}

	private ProductClassesVo getVo(ProductClasses productClasses, CommonParam commonParam)
			throws BusinessException, SQLException {
		ProductClassesVo vo = new ProductClassesVo(productClasses);

		return vo;
	}

	private ProductClassesVo getExtendVo(ProductClasses productClasses, CommonParam commonParam)
			throws BusinessException, SQLException {
		ProductClassesVo vo = this.getVo(productClasses, commonParam);

		return vo;
	}

	private List<ProductClassesVo> getVoList(List<ProductClasses> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ProductClassesVo> voList = new ArrayList<ProductClassesVo>();
		for (ProductClasses entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<ProductClassesVo> getExtendVoList(List<ProductClasses> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ProductClassesVo> voList = new ArrayList<ProductClassesVo>();
		for (ProductClasses entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public ProductClassesVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ProductClasses entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<ProductClassesVo> selectListVoByParamVo(ProductClassesParamVo productClasses, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (productClasses == null) {
			productClasses = new ProductClassesParamVo();
		}
		productClasses.setTenantId(commonParam.getTenantId());

		List<ProductClasses> list = (List<ProductClasses>) this.getBaseService().selectListByParamVo(productClasses,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ProductClassesVo> selectPageVoByParamVo(ProductClassesParamVo productClasses,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (productClasses == null) {
			productClasses = new ProductClassesParamVo();
		}
		productClasses.setTenantId(commonParam.getTenantId());

		PageInfo<ProductClasses> list = (PageInfo<ProductClasses>) this.getBaseService()
				.selectPageByParamVo(productClasses, commonParam, pageNo, pageSize);
		List<ProductClassesVo> volist = new ArrayList<ProductClassesVo>();

		Iterator<ProductClasses> iter = list.getList().iterator();
		ProductClassesVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ProductClassesVo> vpage = new Page<ProductClassesVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ProductClassesVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ProductClasses entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<ProductClassesVo> selectListExtendVoByParamVo(ProductClassesParamVo productClasses,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (productClasses == null) {
			productClasses = new ProductClassesParamVo();
		}
		productClasses.setTenantId(commonParam.getTenantId());

		List<ProductClasses> list = (List<ProductClasses>) this.getBaseService().selectListByParamVo(productClasses,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ProductClassesVo> selectPageExtendVoByParamVo(ProductClassesParamVo productClasses,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (productClasses == null) {
			productClasses = new ProductClassesParamVo();
		}
		productClasses.setTenantId(commonParam.getTenantId());

		PageInfo<ProductClasses> list = (PageInfo<ProductClasses>) this.getBaseService()
				.selectPageByParamVo(productClasses, commonParam, pageNo, pageSize);
		List<ProductClassesVo> volist = new ArrayList<ProductClassesVo>();

		Iterator<ProductClasses> iter = list.getList().iterator();
		ProductClassesVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ProductClassesVo> vpage = new Page<ProductClassesVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(ProductClassesParamVo productClassesParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		if (commonParam.getUserId() != null) {
			productClassesParamVo.setCreateUserId(Long.parseLong(commonParam.getUserId()));
		}
		if (commonParam.getTenantId() != null) {
			productClassesParamVo.setTenantId(commonParam.getTenantId());
		}
		if (productClassesParamVo.getCreateUserId() == null) {
			resultMessage.addErr("请先登录");
			return resultMessage;
		}
		if (productClassesParamVo.getParentId() == null) {
			resultMessage.addErr("物品ID不能为空");
			return resultMessage;
		}

		if (productClassesParamVo.getClassesName() == null) {
			resultMessage.addErr("物品分类名称不能为空");
			return resultMessage;
		}
		if (productClassesParamVo.getClassesName().length() > 32) {
			resultMessage.addErr("物品分类名称不能超过32个字符");
			return resultMessage;
		}
		if (productClassesParamVo.getSortNo() == null) {
			resultMessage.addErr("排序号不能为空");
			return resultMessage;
		}
		if(productClassesParamVo.getRemark()!=null){
			if (productClassesParamVo.getRemark().length() > 128) {
				resultMessage.addErr("备注不能超过128个字符");
				return resultMessage;
			}
		}
		ProductClasses productClasses = null;
		try {
			if (productClassesParamVo.getId() == null) {// 新增
				//生成编码
				String code = productClassesParamVo.getClassesCode();
				if(StringUtils.isBlank(code)){
					code =	configCodeRuleService.createCode(ProductClasses.class.getName(), null, null, commonParam);
					productClassesParamVo.setClassesCode(code);
				}
				if(StringUtils.isBlank(code)){
					resultMessage.addErr("物品分类编码不能为空");
					
				}
				productClassesParamVo.setTenantId(commonParam.getTenantId());
				productClasses = productClassesService.saveOrUpdate(productClassesParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				ProductClasses productClassesVoTemp = this.selectById(productClassesParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(productClassesVoTemp, productClassesParamVo);

				productClasses = productClassesService.saveOrUpdate(productClassesVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(productClasses);
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
