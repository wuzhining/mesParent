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
import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.TrackBarcodeUnpack;
import com.techsoft.entity.common.UserPassport;
import com.techsoft.entity.track.TrackBarcodeUnpackVo;
import com.techsoft.entity.track.TrackBarcodeUnpackParamVo;
import com.techsoft.service.barcode.BarcodeMainService;
import com.techsoft.service.struct.StructFactoryService;
import com.techsoft.service.sys.UserPassportService;
import com.techsoft.service.track.TrackBarcodeUnpackService;

@org.springframework.stereotype.Service
public class ClientTrackBarcodeUnpackServiceImpl extends BaseClientServiceImpl<TrackBarcodeUnpack>
		implements ClientTrackBarcodeUnpackService {
	@com.alibaba.dubbo.config.annotation.Reference
	private TrackBarcodeUnpackService trackBarcodeUnpackService;
	//操作人
	@com.alibaba.dubbo.config.annotation.Reference
	private UserPassportService userPassportService;
	//工厂名称
	@com.alibaba.dubbo.config.annotation.Reference
	private StructFactoryService structFactoryService;
	//条码
	@com.alibaba.dubbo.config.annotation.Reference
	private BarcodeMainService barcodeMainService;
	@Override
	public BaseService<TrackBarcodeUnpack> getBaseService() {
		return trackBarcodeUnpackService;
	}

	private TrackBarcodeUnpackVo getVo(TrackBarcodeUnpack trackBarcodeUnpack, CommonParam commonParam)
			throws BusinessException, SQLException {
		TrackBarcodeUnpackVo vo = new TrackBarcodeUnpackVo(trackBarcodeUnpack);

		//操作人
		if (vo.getCreateUserId() != null && vo.getCreateUserId() > 0L) {
			UserPassport userPassport = userPassportService.selectById(vo.getCreateUserId(), commonParam);
			if (userPassport != null) {
				vo.setUserPassportList(userPassport);
			}
		}
		//工厂名称
		if (vo.getFactoryId() != null && vo.getFactoryId() > 0L) {
			StructFactory structFactory = structFactoryService.selectById(vo.getFactoryId(), commonParam);
			if (structFactory != null) {
				vo.setStructFactorylist(structFactory);
			}
		}
		//条码
		if (vo.getBarcodeId() != null && vo.getBarcodeId() > 0L) {
			BarcodeMain barcodeMain = barcodeMainService.selectById(vo.getBarcodeId(), commonParam);
			if (barcodeMain != null) {
				vo.setBarcodeMainlist(barcodeMain);
			}
		}

		return vo;
	}

	private TrackBarcodeUnpackVo getExtendVo(TrackBarcodeUnpack trackBarcodeUnpack, CommonParam commonParam)
			throws BusinessException, SQLException {
		TrackBarcodeUnpackVo vo = this.getVo(trackBarcodeUnpack, commonParam);

		return vo;
	}

	private List<TrackBarcodeUnpackVo> getVoList(List<TrackBarcodeUnpack> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<TrackBarcodeUnpackVo> voList = new ArrayList<TrackBarcodeUnpackVo>();
		for (TrackBarcodeUnpack entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<TrackBarcodeUnpackVo> getExtendVoList(List<TrackBarcodeUnpack> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<TrackBarcodeUnpackVo> voList = new ArrayList<TrackBarcodeUnpackVo>();
		for (TrackBarcodeUnpack entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public TrackBarcodeUnpackVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		TrackBarcodeUnpack entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<TrackBarcodeUnpackVo> selectListVoByParamVo(TrackBarcodeUnpackParamVo trackBarcodeUnpack,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (trackBarcodeUnpack == null) {
			trackBarcodeUnpack = new TrackBarcodeUnpackParamVo();
		}
		trackBarcodeUnpack.setTenantId(commonParam.getTenantId());

		List<TrackBarcodeUnpack> list = (List<TrackBarcodeUnpack>) this.getBaseService()
				.selectListByParamVo(trackBarcodeUnpack, commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<TrackBarcodeUnpackVo> selectPageVoByParamVo(TrackBarcodeUnpackParamVo trackBarcodeUnpack,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (trackBarcodeUnpack == null) {
			trackBarcodeUnpack = new TrackBarcodeUnpackParamVo();
		}
		trackBarcodeUnpack.setTenantId(commonParam.getTenantId());

		PageInfo<TrackBarcodeUnpack> list = (PageInfo<TrackBarcodeUnpack>) this.getBaseService()
				.selectPageByParamVo(trackBarcodeUnpack, commonParam, pageNo, pageSize);
		List<TrackBarcodeUnpackVo> volist = new ArrayList<TrackBarcodeUnpackVo>();

		Iterator<TrackBarcodeUnpack> iter = list.getList().iterator();
		TrackBarcodeUnpackVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<TrackBarcodeUnpackVo> vpage = new Page<TrackBarcodeUnpackVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public TrackBarcodeUnpackVo getExtendVoByID(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		TrackBarcodeUnpack entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<TrackBarcodeUnpackVo> selectListExtendVoByParamVo(TrackBarcodeUnpackParamVo trackBarcodeUnpack,
			CommonParam commonParam) throws BusinessException, SQLException {
		if (trackBarcodeUnpack == null) {
			trackBarcodeUnpack = new TrackBarcodeUnpackParamVo();
		}
		trackBarcodeUnpack.setTenantId(commonParam.getTenantId());

		List<TrackBarcodeUnpack> list = (List<TrackBarcodeUnpack>) this.getBaseService()
				.selectListByParamVo(trackBarcodeUnpack, commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<TrackBarcodeUnpackVo> selectPageExtendVoByParamVo(TrackBarcodeUnpackParamVo trackBarcodeUnpack,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (trackBarcodeUnpack == null) {
			trackBarcodeUnpack = new TrackBarcodeUnpackParamVo();
		}
		trackBarcodeUnpack.setTenantId(commonParam.getTenantId());

		PageInfo<TrackBarcodeUnpack> list = (PageInfo<TrackBarcodeUnpack>) this.getBaseService()
				.selectPageByParamVo(trackBarcodeUnpack, commonParam, pageNo, pageSize);
		List<TrackBarcodeUnpackVo> volist = new ArrayList<TrackBarcodeUnpackVo>();

		Iterator<TrackBarcodeUnpack> iter = list.getList().iterator();
		TrackBarcodeUnpackVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<TrackBarcodeUnpackVo> vpage = new Page<TrackBarcodeUnpackVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(TrackBarcodeUnpackParamVo trackBarcodeUnpackParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		TrackBarcodeUnpack trackBarcodeUnpack = null;
		try {
			if (trackBarcodeUnpackParamVo.getId() == null) {// 新增

				trackBarcodeUnpackParamVo.setTenantId(commonParam.getTenantId());
				trackBarcodeUnpack = trackBarcodeUnpackService.saveOrUpdate(trackBarcodeUnpackParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				TrackBarcodeUnpack trackBarcodeUnpackVoTemp = this.selectById(trackBarcodeUnpackParamVo.getId(),
						commonParam);

				BeanUtil.copyNotNullProperties(trackBarcodeUnpackVoTemp, trackBarcodeUnpackParamVo);

				trackBarcodeUnpack = trackBarcodeUnpackService.saveOrUpdate(trackBarcodeUnpackVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(trackBarcodeUnpack);
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
