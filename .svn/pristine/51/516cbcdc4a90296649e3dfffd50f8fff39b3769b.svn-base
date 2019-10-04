package com.techsoft.client.service.history;

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
import com.techsoft.entity.common.BillFixture;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.HistoryBillFixtureStatus;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.history.HistoryBillFixtureStatusParamVo;
import com.techsoft.entity.history.HistoryBillFixtureStatusVo;
import com.techsoft.service.bill.BillFixtureService;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.history.HistoryBillFixtureStatusService;
import com.techsoft.service.sys.UserPassportService;

@org.springframework.stereotype.Service
public class ClientHistoryBillFixtureStatusServiceImpl extends BaseClientServiceImpl<HistoryBillFixtureStatus>
		implements ClientHistoryBillFixtureStatusService {
	@com.alibaba.dubbo.config.annotation.Reference
	private HistoryBillFixtureStatusService historyBillFixtureStatusService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private UserPassportService userPassportService;
	@com.alibaba.dubbo.config.annotation.Reference
	private BillFixtureService billFixtureService;

	@Override
	public BaseService<HistoryBillFixtureStatus> getBaseService() {
		return historyBillFixtureStatusService;
	}

	private HistoryBillFixtureStatusVo getVo(HistoryBillFixtureStatus historyBillFixtureStatus, CommonParam commonParam)
			throws BusinessException, SQLException {
		HistoryBillFixtureStatusVo vo = new HistoryBillFixtureStatusVo(historyBillFixtureStatus);
		
		//工具单据类型
		if (vo.getBillTypeFixtureDictId() != null && vo.getBillTypeFixtureDictId() > 0L) {
			ConfigDictionary billTypeFixture = configDictionaryService.selectById(vo.getBillTypeFixtureDictId(),commonParam);
			if (billTypeFixture != null) {
				vo.setBillTypeFixture(billTypeFixture);
			}
		}
		//工具单据状态
		if (vo.getBillStatusFixtureDictId() != null && vo.getBillStatusFixtureDictId() > 0L) {
			ConfigDictionary billStatusFixture = configDictionaryService.selectById(vo.getBillStatusFixtureDictId(),commonParam);
			if (billStatusFixture != null) {
				vo.setBillStatusFixture(billStatusFixture);
			}
		}
		
		//工具单据编码
		if (vo.getBillFixtureId() != null && vo.getBillFixtureId() > 0L) {
			BillFixture billFixture = billFixtureService.selectById(vo.getBillFixtureId(),commonParam);
			if (billFixture != null) {
				vo.setBillFixture(billFixture);
			}
		}
		//创建人
		if (vo.getCreateUserId() != null && vo.getCreateUserId() > 0L) {
			UserPassport userPassport =userPassportService.selectById(vo.getCreateUserId(),
					commonParam);
			if (userPassport != null) {
				vo.setCaretUserPassport(userPassport);
			}
		}	
		//修改人
		if (vo.getModifyUserId() != null && vo.getModifyUserId() > 0L) {
			UserPassport userPassport =userPassportService.selectById(vo.getModifyUserId(),
					commonParam);
			if (userPassport != null) {
				vo.setModifyUserPassport(userPassport);
			}
		}
		

		return vo;
	}

	private HistoryBillFixtureStatusVo getExtendVo(HistoryBillFixtureStatus historyBillFixtureStatus,
			CommonParam commonParam) throws BusinessException, SQLException {
		HistoryBillFixtureStatusVo vo = this.getVo(historyBillFixtureStatus, commonParam);

		return vo;
	}

	private List<HistoryBillFixtureStatusVo> getVoList(List<HistoryBillFixtureStatus> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<HistoryBillFixtureStatusVo> voList = new ArrayList<HistoryBillFixtureStatusVo>();
		for (HistoryBillFixtureStatus entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<HistoryBillFixtureStatusVo> getExtendVoList(List<HistoryBillFixtureStatus> list,
			CommonParam commonParam) throws BusinessException, SQLException {
		List<HistoryBillFixtureStatusVo> voList = new ArrayList<HistoryBillFixtureStatusVo>();
		for (HistoryBillFixtureStatus entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public HistoryBillFixtureStatusVo getVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		HistoryBillFixtureStatus entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<HistoryBillFixtureStatusVo> selectListVoByParamVo(
			HistoryBillFixtureStatusParamVo historyBillFixtureStatus, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (historyBillFixtureStatus == null) {
			historyBillFixtureStatus = new HistoryBillFixtureStatusParamVo();
		}
		historyBillFixtureStatus.setTenantId(commonParam.getTenantId());

		List<HistoryBillFixtureStatus> list = (List<HistoryBillFixtureStatus>) this.getBaseService()
				.selectListByParamVo(historyBillFixtureStatus, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<HistoryBillFixtureStatusVo> selectPageVoByParamVo(
			HistoryBillFixtureStatusParamVo historyBillFixtureStatus, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException {
		if (historyBillFixtureStatus == null) {
			historyBillFixtureStatus = new HistoryBillFixtureStatusParamVo();
		}
		historyBillFixtureStatus.setTenantId(commonParam.getTenantId());

		PageInfo<HistoryBillFixtureStatus> list = (PageInfo<HistoryBillFixtureStatus>) this.getBaseService()
				.selectPageByParamVo(historyBillFixtureStatus, commonParam, pageNo, pageSize);
		List<HistoryBillFixtureStatusVo> volist = new ArrayList<HistoryBillFixtureStatusVo>();

		Iterator<HistoryBillFixtureStatus> iter = list.getList().iterator();
		HistoryBillFixtureStatusVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<HistoryBillFixtureStatusVo> vpage = new Page<HistoryBillFixtureStatusVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public HistoryBillFixtureStatusVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		HistoryBillFixtureStatus entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<HistoryBillFixtureStatusVo> selectListExtendVoByParamVo(
			HistoryBillFixtureStatusParamVo historyBillFixtureStatus, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (historyBillFixtureStatus == null) {
			historyBillFixtureStatus = new HistoryBillFixtureStatusParamVo();
		}
		historyBillFixtureStatus.setTenantId(commonParam.getTenantId());

		List<HistoryBillFixtureStatus> list = (List<HistoryBillFixtureStatus>) this.getBaseService()
				.selectListByParamVo(historyBillFixtureStatus, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<HistoryBillFixtureStatusVo> selectPageExtendVoByParamVo(
			HistoryBillFixtureStatusParamVo historyBillFixtureStatus, CommonParam commonParam, int pageNo, int pageSize)
			throws BusinessException, SQLException {
		if (historyBillFixtureStatus == null) {
			historyBillFixtureStatus = new HistoryBillFixtureStatusParamVo();
		}
		historyBillFixtureStatus.setTenantId(commonParam.getTenantId());

		PageInfo<HistoryBillFixtureStatus> list = (PageInfo<HistoryBillFixtureStatus>) this.getBaseService()
				.selectPageByParamVo(historyBillFixtureStatus, commonParam, pageNo, pageSize);
		List<HistoryBillFixtureStatusVo> volist = new ArrayList<HistoryBillFixtureStatusVo>();

		Iterator<HistoryBillFixtureStatus> iter = list.getList().iterator();
		HistoryBillFixtureStatusVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<HistoryBillFixtureStatusVo> vpage = new Page<HistoryBillFixtureStatusVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(HistoryBillFixtureStatusParamVo historyBillFixtureStatusParamVo,
			CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		HistoryBillFixtureStatus historyBillFixtureStatus = null;
		try {
			if (historyBillFixtureStatusParamVo.getId() == null) {// 新增

				historyBillFixtureStatusParamVo.setTenantId(commonParam.getTenantId());
				historyBillFixtureStatus = historyBillFixtureStatusService.saveOrUpdate(historyBillFixtureStatusParamVo,
						commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				HistoryBillFixtureStatus historyBillFixtureStatusVoTemp = this
						.selectById(historyBillFixtureStatusParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(historyBillFixtureStatusVoTemp, historyBillFixtureStatusParamVo);

				historyBillFixtureStatus = historyBillFixtureStatusService.saveOrUpdate(historyBillFixtureStatusVoTemp,
						commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(historyBillFixtureStatus);
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
