package com.techsoft.client.service.track;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.techsoft.common.BaseClientServiceImpl;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.SQLException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.persistence.ResultMessage;
import com.techsoft.common.utils.BeanUtil;

import com.techsoft.entity.common.TrackPallet;
import com.techsoft.entity.track.TrackPalletVo;
import com.techsoft.entity.track.TrackPalletParamVo;
import com.techsoft.service.track.TrackPalletService;

@org.springframework.stereotype.Service
public class ClientTrackPalletServiceImpl extends BaseClientServiceImpl<TrackPallet>
		implements ClientTrackPalletService {
	@com.alibaba.dubbo.config.annotation.Reference
	private TrackPalletService trackPalletService;

	@Override
	public BaseService<TrackPallet> getBaseService() {
		return trackPalletService;
	}

	private TrackPalletVo getVo(TrackPallet trackPallet, CommonParam commonParam)
			throws BusinessException, SQLException {
		TrackPalletVo vo = new TrackPalletVo(trackPallet);

		return vo;
	}

	private TrackPalletVo getExtendVo(TrackPallet trackPallet, CommonParam commonParam)
			throws BusinessException, SQLException {
		TrackPalletVo vo = this.getVo(trackPallet, commonParam);

		return vo;
	}

	private List<TrackPalletVo> getVoList(List<TrackPallet> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<TrackPalletVo> voList = new ArrayList<TrackPalletVo>();
		for (TrackPallet entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<TrackPalletVo> getExtendVoList(List<TrackPallet> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<TrackPalletVo> voList = new ArrayList<TrackPalletVo>();
		for (TrackPallet entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public TrackPalletVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		TrackPallet entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<TrackPalletVo> selectListVoByParamVo(TrackPalletParamVo trackPallet, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (trackPallet == null) {
			trackPallet = new TrackPalletParamVo();
		}
		trackPallet.setTenantId(commonParam.getTenantId());

		List<TrackPallet> list = (List<TrackPallet>) this.getBaseService().selectListByParamVo(trackPallet,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<TrackPalletVo> selectPageVoByParamVo(TrackPalletParamVo trackPallet, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (trackPallet == null) {
			trackPallet = new TrackPalletParamVo();
		}
		trackPallet.setTenantId(commonParam.getTenantId());

		PageInfo<TrackPallet> list = (PageInfo<TrackPallet>) this.getBaseService().selectPageByParamVo(trackPallet,
				commonParam, pageNo, pageSize);
		List<TrackPalletVo> volist = new ArrayList<TrackPalletVo>();

		Iterator<TrackPallet> iter = list.getList().iterator();
		TrackPalletVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<TrackPalletVo> vpage = new Page<TrackPalletVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public TrackPalletVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		TrackPallet entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<TrackPalletVo> selectListExtendVoByParamVo(TrackPalletParamVo trackPallet, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (trackPallet == null) {
			trackPallet = new TrackPalletParamVo();
		}
		trackPallet.setTenantId(commonParam.getTenantId());

		List<TrackPallet> list = (List<TrackPallet>) this.getBaseService().selectListByParamVo(trackPallet,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<TrackPalletVo> selectPageExtendVoByParamVo(TrackPalletParamVo trackPallet, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (trackPallet == null) {
			trackPallet = new TrackPalletParamVo();
		}
		trackPallet.setTenantId(commonParam.getTenantId());

		PageInfo<TrackPallet> list = (PageInfo<TrackPallet>) this.getBaseService().selectPageByParamVo(trackPallet,
				commonParam, pageNo, pageSize);
		List<TrackPalletVo> volist = new ArrayList<TrackPalletVo>();

		Iterator<TrackPallet> iter = list.getList().iterator();
		TrackPalletVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<TrackPalletVo> vpage = new Page<TrackPalletVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(TrackPalletParamVo trackPalletParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		TrackPallet trackPallet = null;
		try {
			if (trackPalletParamVo.getId() == null) {// 新增

				trackPalletParamVo.setTenantId(commonParam.getTenantId());
				trackPallet = trackPalletService.saveOrUpdate(trackPalletParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				TrackPallet trackPalletVoTemp = this.selectById(trackPalletParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(trackPalletVoTemp, trackPalletParamVo);

				trackPallet = trackPalletService.saveOrUpdate(trackPalletVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(trackPallet);
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
