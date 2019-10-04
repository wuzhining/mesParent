package com.techsoft.client.service.bill;

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
import com.techsoft.entity.bill.BillFixtureItemParamVo;
import com.techsoft.entity.bill.BillFixtureItemVo;
import com.techsoft.entity.common.BillFixtureItem;
import com.techsoft.service.bill.BillFixtureItemService;

@org.springframework.stereotype.Service
public class ClientBillFixtureItemServiceImpl extends BaseClientServiceImpl<BillFixtureItem>
		implements ClientBillFixtureItemService {
	@com.alibaba.dubbo.config.annotation.Reference
	private BillFixtureItemService billFixtureItemService;

	@Override
	public BaseService<BillFixtureItem> getBaseService() {
		return billFixtureItemService;
	}

	private BillFixtureItemVo getVo(BillFixtureItem billFixtureItem, CommonParam commonParam)
			throws BusinessException, SQLException {
		BillFixtureItemVo vo = new BillFixtureItemVo(billFixtureItem);

		return vo;
	}

	private BillFixtureItemVo getExtendVo(BillFixtureItem billFixtureItem, CommonParam commonParam)
			throws BusinessException, SQLException {
		BillFixtureItemVo vo = this.getVo(billFixtureItem, commonParam);

		return vo;
	}

	private List<BillFixtureItemVo> getVoList(List<BillFixtureItem> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BillFixtureItemVo> voList = new ArrayList<BillFixtureItemVo>();
		for (BillFixtureItem entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<BillFixtureItemVo> getExtendVoList(List<BillFixtureItem> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<BillFixtureItemVo> voList = new ArrayList<BillFixtureItemVo>();
		for (BillFixtureItem entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public BillFixtureItemVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BillFixtureItem entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<BillFixtureItemVo> selectListVoByParamVo(BillFixtureItemParamVo billFixtureItem,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (billFixtureItem == null) {
			billFixtureItem = new BillFixtureItemParamVo();
		}
		billFixtureItem.setTenantId(commonParam.getTenantId());

		List<BillFixtureItem> list = (List<BillFixtureItem>) this.getBaseService().selectListByParamVo(billFixtureItem,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<BillFixtureItemVo> selectPageVoByParamVo(BillFixtureItemParamVo billFixtureItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (billFixtureItem == null) {
			billFixtureItem = new BillFixtureItemParamVo();
		}
		billFixtureItem.setTenantId(commonParam.getTenantId());

		PageInfo<BillFixtureItem> list = (PageInfo<BillFixtureItem>) this.getBaseService()
				.selectPageByParamVo(billFixtureItem, commonParam, pageNo, pageSize);
		List<BillFixtureItemVo> volist = new ArrayList<BillFixtureItemVo>();

		Iterator<BillFixtureItem> iter = list.getList().iterator();
		BillFixtureItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<BillFixtureItemVo> vpage = new Page<BillFixtureItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public BillFixtureItemVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		BillFixtureItem entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<BillFixtureItemVo> selectListExtendVoByParamVo(BillFixtureItemParamVo billFixtureItem,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (billFixtureItem == null) {
			billFixtureItem = new BillFixtureItemParamVo();
		}
		billFixtureItem.setTenantId(commonParam.getTenantId());

		List<BillFixtureItem> list = (List<BillFixtureItem>) this.getBaseService().selectListByParamVo(billFixtureItem,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<BillFixtureItemVo> selectPageExtendVoByParamVo(BillFixtureItemParamVo billFixtureItem,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (billFixtureItem == null) {
			billFixtureItem = new BillFixtureItemParamVo();
		}
		billFixtureItem.setTenantId(commonParam.getTenantId());

		PageInfo<BillFixtureItem> list = (PageInfo<BillFixtureItem>) this.getBaseService()
				.selectPageByParamVo(billFixtureItem, commonParam, pageNo, pageSize);
		List<BillFixtureItemVo> volist = new ArrayList<BillFixtureItemVo>();

		Iterator<BillFixtureItem> iter = list.getList().iterator();
		BillFixtureItemVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<BillFixtureItemVo> vpage = new Page<BillFixtureItemVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(BillFixtureItemParamVo billFixtureItemParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		BillFixtureItem billFixtureItem = null;
		try {
			if (billFixtureItemParamVo.getId() == null) {// 新增

				billFixtureItemParamVo.setTenantId(commonParam.getTenantId());
				billFixtureItem = billFixtureItemService.saveOrUpdate(billFixtureItemParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				BillFixtureItem billFixtureItemVoTemp = this.selectById(billFixtureItemParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(billFixtureItemVoTemp, billFixtureItemParamVo);

				billFixtureItem = billFixtureItemService.saveOrUpdate(billFixtureItemVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(billFixtureItem);
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
