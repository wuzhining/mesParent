package com.techsoft.service.struct;
import java.util.List;
import com.techsoft.common.BaseService;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.StructProcessLine;
import com.techsoft.entity.struct.StructProcessLineVo;
import com.techsoft.entity.struct.StructProcessVo;

public interface StructProcessLineService extends BaseService<StructProcessLine> {
	/**
	 * 批量新增工艺流程路线
	 * @param listDictionary
	 * @param entity
	 * @param data
	 * @param commonParam
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public void insertEntityAndItem(List<ConfigDictionary> listDictionary,StructProcessVo entity,String[] data,List<StructProcessLineVo> processLineList,CommonParam commonParam) throws BusinessException, SQLException;

}
