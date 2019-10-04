package com.techsoft.client.service.product;

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
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.ConfigLabel;
import com.techsoft.entity.common.ProductLabel;
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.product.ProductLabelParamVo;
import com.techsoft.entity.product.ProductLabelVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.config.ConfigLabelService;
import com.techsoft.service.product.ProductLabelService;
import com.techsoft.service.product.ProductMainService;

@org.springframework.stereotype.Service
public class ClientProductLabelServiceImpl extends BaseClientServiceImpl<ProductLabel>
		implements ClientProductLabelService {
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductLabelService productLabelService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService productMainService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigLabelService configLabelService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;

	@Override
	public BaseService<ProductLabel> getBaseService() {
		return productLabelService;
	}

	private ProductLabelVo getVo(ProductLabel productLabel, CommonParam commonParam)
			throws BusinessException, SQLException {
		ProductLabelVo vo = new ProductLabelVo(productLabel);
		// 物品
		if (vo.getProductId() != null && vo.getProductId() > 0L) {
			ProductMain productMain = productMainService.selectById(vo.getProductId(), commonParam);
			if (productMain != null) {
				vo.setProductMain(productMain);
			}
		}
		// 标签文档
		if (vo.getLabelId() != null && vo.getLabelId() > 0L) {
			ConfigLabel configLabel = configLabelService.selectById(vo.getLabelId(), commonParam);
			if (configLabel != null) {
				vo.setConfigLabel(configLabel);
			}
		}
		// 标签文档
		if (vo.getBarcodeRuleDictId() != null && vo.getBarcodeRuleDictId() > 0L) {
			ConfigDictionary barcodeRuleDict = configDictionaryService.selectById(vo.getBarcodeRuleDictId(),
					commonParam);
			if (barcodeRuleDict != null) {
				vo.setBarcodeRuleDict(barcodeRuleDict);
			}
		}

		return vo;
	}

	private ProductLabelVo getExtendVo(ProductLabel productLabel, CommonParam commonParam)
			throws BusinessException, SQLException {
		ProductLabelVo vo = this.getVo(productLabel, commonParam);

		return vo;
	}

	private List<ProductLabelVo> getVoList(List<ProductLabel> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ProductLabelVo> voList = new ArrayList<ProductLabelVo>();
		for (ProductLabel entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<ProductLabelVo> getExtendVoList(List<ProductLabel> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<ProductLabelVo> voList = new ArrayList<ProductLabelVo>();
		for (ProductLabel entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public ProductLabelVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ProductLabel entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<ProductLabelVo> selectListVoByParamVo(ProductLabelParamVo productLabel, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (productLabel == null) {
			productLabel = new ProductLabelParamVo();
		}
		productLabel.setTenantId(commonParam.getTenantId());

		List<ProductLabel> list = (List<ProductLabel>) this.getBaseService().selectListByParamVo(productLabel,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ProductLabelVo> selectPageVoByParamVo(ProductLabelParamVo productLabel, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (productLabel == null) {
			productLabel = new ProductLabelParamVo();
		}
		productLabel.setTenantId(commonParam.getTenantId());

		PageInfo<ProductLabel> list = (PageInfo<ProductLabel>) this.getBaseService().selectPageByParamVo(productLabel,
				commonParam, pageNo, pageSize);
		List<ProductLabelVo> volist = new ArrayList<ProductLabelVo>();

		Iterator<ProductLabel> iter = list.getList().iterator();
		ProductLabelVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ProductLabelVo> vpage = new Page<ProductLabelVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ProductLabelVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		ProductLabel entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<ProductLabelVo> selectListExtendVoByParamVo(ProductLabelParamVo productLabel, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (productLabel == null) {
			productLabel = new ProductLabelParamVo();
		}
		productLabel.setTenantId(commonParam.getTenantId());

		List<ProductLabel> list = (List<ProductLabel>) this.getBaseService().selectListByParamVo(productLabel,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<ProductLabelVo> selectPageExtendVoByParamVo(ProductLabelParamVo productLabel,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (productLabel == null) {
			productLabel = new ProductLabelParamVo();
		}
		productLabel.setTenantId(commonParam.getTenantId());

		PageInfo<ProductLabel> list = (PageInfo<ProductLabel>) this.getBaseService().selectPageByParamVo(productLabel,
				commonParam, pageNo, pageSize);
		List<ProductLabelVo> volist = new ArrayList<ProductLabelVo>();

		Iterator<ProductLabel> iter = list.getList().iterator();
		ProductLabelVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<ProductLabelVo> vpage = new Page<ProductLabelVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(ProductLabelParamVo productLabelParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		if (commonParam.getUserId() != null) {
			productLabelParamVo.setCreateUserId(Long.parseLong(commonParam.getUserId()));
		}
		if (commonParam.getTenantId() != null) {
			productLabelParamVo.setTenantId(commonParam.getTenantId());
		}
		if (productLabelParamVo.getCreateUserId() == null) {
			resultMessage.addErr("请先登录");
			return resultMessage;
		}
		if (productLabelParamVo.getProductId() == null || productLabelParamVo.getProductId().equals(0L)) {
			resultMessage.addErr("物品不能为空");
			return resultMessage;
		}
		if (productLabelParamVo.getLabelId() == null || productLabelParamVo.getLabelId().equals(0L)) {
			resultMessage.addErr("模板标签不能为空");
			return resultMessage;
		}
		if (productLabelParamVo.getBarcodeRuleDictId() == null
				|| productLabelParamVo.getBarcodeRuleDictId().equals(0L)) {
			resultMessage.addErr("条码规则类型不能为空");
			return resultMessage;
		}
		ProductLabel productLabel = null;
		try {
			if (productLabelParamVo.getId() == null) {// 新增

				productLabelParamVo.setTenantId(commonParam.getTenantId());
				productLabel = productLabelService.saveOrUpdate(productLabelParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				ProductLabel productLabelVoTemp = this.selectById(productLabelParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(productLabelVoTemp, productLabelParamVo);

				productLabel = productLabelService.saveOrUpdate(productLabelVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(productLabel);
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
