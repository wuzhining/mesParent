package com.techsoft.client.service.track;

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
import com.techsoft.entity.common.ProductMain;
import com.techsoft.entity.common.TrackPackbox;
import com.techsoft.entity.track.TrackPackboxParamVo;
import com.techsoft.entity.track.TrackPackboxVo;
import com.techsoft.service.config.ConfigDictionaryService;
import com.techsoft.service.product.ProductMainService;
import com.techsoft.service.track.TrackPackboxService;

@org.springframework.stereotype.Service
public class ClientTrackPackboxServiceImpl extends BaseClientServiceImpl<TrackPackbox>
		implements ClientTrackPackboxService {
	@com.alibaba.dubbo.config.annotation.Reference
	private TrackPackboxService trackPackboxService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ConfigDictionaryService configDictionaryService;
	@com.alibaba.dubbo.config.annotation.Reference
	private ProductMainService productMainService;

	@Override
	public BaseService<TrackPackbox> getBaseService() {
		return trackPackboxService;
	}

	private TrackPackboxVo getVo(TrackPackbox trackPackbox, CommonParam commonParam)
			throws BusinessException, SQLException {
		TrackPackboxVo vo = new TrackPackboxVo(trackPackbox);
		// 单据类型
		if (vo.getBillTypeDictId() != null && vo.getBillTypeDictId() > 0L) {
			ConfigDictionary configDictionary = configDictionaryService.selectById(vo.getBillTypeDictId(), commonParam);
			if (configDictionary != null) {
				vo.setConfigDictionary(configDictionary);
			}
		}
		// 状态
		if (vo.getBillStatusDictId() != null && vo.getBillStatusDictId() > 0L) {
			ConfigDictionary configDictionaryStatus = configDictionaryService.selectById(vo.getBillStatusDictId(),
					commonParam);
			if (configDictionaryStatus != null) {
				vo.setConfigDictionaryStatus(configDictionaryStatus);
			}
		}
		// 物品
		if (vo.getProductId() != null && vo.getProductId() > 0L) {
			ProductMain productMain = productMainService.selectById(vo.getProductId(), commonParam);
			if (productMain != null) {
				//物品类型
				if(productMain.getProductTypeDictId() != null && productMain.getProductTypeDictId() >0L){
					ConfigDictionary productType = configDictionaryService.selectById(productMain.getProductTypeDictId(), commonParam);
					if(productType != null){
						vo.setProductType(productType);
					}
				}
				vo.setProductMain(productMain);
			}
		}
		return vo;
	}

	private TrackPackboxVo getExtendVo(TrackPackbox trackPackbox, CommonParam commonParam)
			throws BusinessException, SQLException {
		TrackPackboxVo vo = this.getVo(trackPackbox, commonParam);

		return vo;
	}

	private List<TrackPackboxVo> getVoList(List<TrackPackbox> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<TrackPackboxVo> voList = new ArrayList<TrackPackboxVo>();
		for (TrackPackbox entity : list) {
			voList.add(this.getVo(entity, commonParam));
		}

		return voList;
	}

	private List<TrackPackboxVo> getExtendVoList(List<TrackPackbox> list, CommonParam commonParam)
			throws BusinessException, SQLException {
		List<TrackPackboxVo> voList = new ArrayList<TrackPackboxVo>();
		for (TrackPackbox entity : list) {
			voList.add(this.getExtendVo(entity, commonParam));
		}

		return voList;
	}

	public TrackPackboxVo getVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		TrackPackbox entity = this.getBaseService().selectById(id, commonParam);

		return this.getVo(entity, commonParam);
	}

	public List<TrackPackboxVo> selectListVoByParamVo(TrackPackboxParamVo trackPackbox, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (trackPackbox == null) {
			trackPackbox = new TrackPackboxParamVo();
		}
		trackPackbox.setTenantId(commonParam.getTenantId());

		List<TrackPackbox> list = (List<TrackPackbox>) this.getBaseService().selectListByParamVo(trackPackbox,
				commonParam);

		return getVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<TrackPackboxVo> selectPageVoByParamVo(TrackPackboxParamVo trackPackbox, CommonParam commonParam,
			int pageNo, int pageSize) throws BusinessException, SQLException {
		if (trackPackbox == null) {
			trackPackbox = new TrackPackboxParamVo();
		}
		trackPackbox.setTenantId(commonParam.getTenantId());

		PageInfo<TrackPackbox> list = (PageInfo<TrackPackbox>) this.getBaseService().selectPageByParamVo(trackPackbox,
				commonParam, pageNo, pageSize);
		List<TrackPackboxVo> volist = new ArrayList<TrackPackboxVo>();

		Iterator<TrackPackbox> iter = list.getList().iterator();
		TrackPackboxVo vo = null;
		while (iter.hasNext()) {
			vo = this.getVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<TrackPackboxVo> vpage = new Page<TrackPackboxVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public TrackPackboxVo getExtendVoByID(Long id, CommonParam commonParam) throws BusinessException, SQLException {
		TrackPackbox entity = this.getBaseService().selectById(id, commonParam);

		return this.getExtendVo(entity, commonParam);
	}

	public List<TrackPackboxVo> selectListExtendVoByParamVo(TrackPackboxParamVo trackPackbox, CommonParam commonParam)
			throws BusinessException, SQLException {
		if (trackPackbox == null) {
			trackPackbox = new TrackPackboxParamVo();
		}
		trackPackbox.setTenantId(commonParam.getTenantId());

		List<TrackPackbox> list = (List<TrackPackbox>) this.getBaseService().selectListByParamVo(trackPackbox,
				commonParam);

		return this.getExtendVoList(list, commonParam);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageInfo<TrackPackboxVo> selectPageExtendVoByParamVo(TrackPackboxParamVo trackPackbox,
			CommonParam commonParam, int pageNo, int pageSize) throws BusinessException, SQLException {
		if (trackPackbox == null) {
			trackPackbox = new TrackPackboxParamVo();
		}
		trackPackbox.setTenantId(commonParam.getTenantId());

		PageInfo<TrackPackbox> list = (PageInfo<TrackPackbox>) this.getBaseService().selectPageByParamVo(trackPackbox,
				commonParam, pageNo, pageSize);
		List<TrackPackboxVo> volist = new ArrayList<TrackPackboxVo>();

		Iterator<TrackPackbox> iter = list.getList().iterator();
		TrackPackboxVo vo = null;
		while (iter.hasNext()) {
			vo = this.getExtendVo(iter.next(), commonParam);
			volist.add(vo);
		}

		Page<TrackPackboxVo> vpage = new Page<TrackPackboxVo>();
		vpage.addAll(volist);
		vpage.setPageNum(list.getPageNum());
		vpage.setPageSize(list.getPageSize());
		vpage.setTotal(list.getTotal());

		return new PageInfo(vpage);
	}

	public ResultMessage saveOrUpdate(TrackPackboxParamVo trackPackboxParamVo, CommonParam commonParam) {
		ResultMessage resultMessage = new ResultMessage();
		TrackPackbox trackPackbox = null;
		try {
			if (trackPackboxParamVo.getId() == null) {// 新增

				trackPackboxParamVo.setTenantId(commonParam.getTenantId());
				trackPackbox = trackPackboxService.saveOrUpdate(trackPackboxParamVo, commonParam);
				resultMessage.setIsSuccess(true);
			} else { // 修改
				TrackPackbox trackPackboxVoTemp = this.selectById(trackPackboxParamVo.getId(), commonParam);

				BeanUtil.copyNotNullProperties(trackPackboxVoTemp, trackPackboxParamVo);

				trackPackbox = trackPackboxService.saveOrUpdate(trackPackboxVoTemp, commonParam);

				resultMessage.setIsSuccess(true);
			}

			resultMessage.setBaseEntity(trackPackbox);
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
