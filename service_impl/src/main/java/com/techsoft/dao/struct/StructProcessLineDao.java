package com.techsoft.dao.struct;

import java.util.List;

import com.techsoft.common.BaseDao;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.entity.common.StructProcessLine;

public interface StructProcessLineDao extends BaseDao<StructProcessLine> {

	/**
	 * 流程设计批量新增节点路线
	 * @author
	 * @param items
	 * @param commonParam
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public void insertBatch(List<StructProcessLine> items, CommonParam commonParam) throws BusinessException, SQLException;
	
	/**
	 * 原版本工艺路线流程 修改为已删除
	 * @param processLineList
	 * @param commonParam
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public int updateBatch(List<StructProcessLine> processLineList,CommonParam commonParam)  throws BusinessException, SQLException;
	
}
