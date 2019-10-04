package com.techsoft.service.struct;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.dao.struct.StructProcessDao;
import com.techsoft.dao.struct.StructProcessLineDao;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.entity.common.ConfigDictionary;
import com.techsoft.entity.common.StructProcessLine;
import com.techsoft.entity.struct.StructProcessLineVo;
import com.techsoft.entity.struct.StructProcessVo;

@Service
public class StructProcessLineServiceImpl extends BaseServiceImpl<StructProcessLine> implements StructProcessLineService {
	@Autowired
	private StructProcessLineDao structProcessLineDao;
	@Autowired
	private StructProcessDao structProcessDao;
	
	@Override
	public BaseDao<StructProcessLine> getBaseDao() {
		return structProcessLineDao;
	}	
	
	@Override
	public Class<StructProcessLine> getEntityClass() {
		return StructProcessLine.class;
	}
	
	@Override
	protected StructProcessLine insertEntity(StructProcessLine entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected StructProcessLine updatePartEntity(StructProcessLine entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected StructProcessLine updateEntity(StructProcessLine entity, CommonParam commonParam) throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public void insertEntityAndItem(List<ConfigDictionary> listDictionary,StructProcessVo entity,String[] data, List<StructProcessLineVo> processLineList,CommonParam commonParam)
			throws BusinessException, SQLException {
		// TODO Auto-generated method stub
		
		List<StructProcessLine> listLine = new ArrayList<StructProcessLine>();
		if(processLineList.size()>0){
			for (int i = 0; i < processLineList.size(); i++) {
				StructProcessLine line = new StructProcessLine();
				line.setModifyUserId(Long.valueOf(commonParam.getUserId()));
				line.setId(processLineList.get(i).getId());
				listLine.add(line);
			}
			int result = structProcessLineDao.updateBatch(listLine, commonParam);
			if(result > 0){
				structProcessLineDao.insertBatch(this.returnList(listDictionary, entity, data, processLineList, commonParam), commonParam);
				entity.setProcessVersion(entity.getProcessVersion()+1);
				structProcessDao.updateEntity(entity, commonParam);
			}
		}else{
			structProcessLineDao.insertBatch(this.returnList(listDictionary, entity, data, processLineList, commonParam), commonParam);
		}
	}

	
	public List<StructProcessLine> returnList(List<ConfigDictionary> listDictionary,StructProcessVo entity,String[] data, List<StructProcessLineVo> processLineList,CommonParam commonParam){
		Integer index = 0;
		String idString = "";
		Long idLong = 0L;
		Long id = structProcessLineDao.getIdValue();
		DecimalFormat locationdf = new DecimalFormat("000000");
		
		String prevNodeId ="";
		String lineTypeDictIdString = "";
		String nextNodeId = "";
		Long lineTypeDictId = null;
		
		Integer BlockX = null;
		Integer BlockY = null;
		
		Integer prevBlockX = null;
		Integer nextBlockY = null;
		
		List<StructProcessLine> list = new ArrayList<StructProcessLine>();
		if(StringUtils.isNotEmpty(data[0])){
			System.out.print(data[0]);
			System.out.print(data[1]);
    		JSONArray modifyArray=JSONArray.parseArray(data[0]);
    		JSONArray modifyArrayNode=JSONArray.parseArray(data[1]);
    		for(int i=0;i<modifyArray.size();i++){
    			prevNodeId =  JSONObject.parseObject(JSONObject.toJSONString(modifyArray.get(i))).getString("PageSourceId");
    			lineTypeDictIdString = JSONObject.parseObject(JSONObject.toJSONString(modifyArray.get(i))).getString("connectionLabel");
    			nextNodeId = JSONObject.parseObject(JSONObject.toJSONString(modifyArray.get(i))).getString("PageTargetId");
    			
    		   //找节点坐标
    			for(int X=0;X<modifyArrayNode.size();X++){
    				if(prevNodeId.equals(JSONObject.parseObject(JSONObject.toJSONString(modifyArrayNode.get(X))).getString("BlockId"))){
    					BlockX = Integer.parseInt(JSONObject.parseObject(JSONObject.toJSONString(modifyArrayNode.get(X))).getString("BlockX"));
    					BlockY = Integer.parseInt(JSONObject.parseObject(JSONObject.toJSONString(modifyArrayNode.get(X))).getString("BlockY"));
    				}
    				if(nextNodeId.equals(JSONObject.parseObject(JSONObject.toJSONString(modifyArrayNode.get(X))).getString("BlockId"))){
    					prevBlockX = Integer.parseInt(JSONObject.parseObject(JSONObject.toJSONString(modifyArrayNode.get(X))).getString("BlockX"));
    					nextBlockY = Integer.parseInt(JSONObject.parseObject(JSONObject.toJSONString(modifyArrayNode.get(X))).getString("BlockY"));
    				}
    				
    			}
    			
    			for (int j = 0; j < listDictionary.size(); j++) {
    				if(listDictionary.get(j).getDictValue().equals(lineTypeDictIdString)){
    					lineTypeDictId = listDictionary.get(j).getId();
    				}
    			}
    			StructProcessLine processLine = new StructProcessLine();
    			index++;
    			idString = locationdf.format(index);
    			idLong = Long.valueOf(id.toString() + idString);
    			processLine.setFactoryId(entity.getFactoryId());
    			processLine.setProcessId(entity.getId());
    			
    			if(processLineList.size()>0){
    				processLine.setProcessVersion(entity.getProcessVersion()+1);
    			}else{
    				processLine.setProcessVersion(entity.getProcessVersion());
    			}
    			processLine.setPrevNodeId(Long.parseLong(prevNodeId.substring(0, prevNodeId.indexOf("_"))));
    			processLine.setNextNodeId(Long.parseLong(nextNodeId.substring(0, nextNodeId.indexOf("_"))));
    			processLine.setLineTypeDictId(lineTypeDictId);
    			processLine.setId(idLong);
    			processLine.setTenantId(commonParam.getTenantId());
    			processLine.setCreateUserId(Long.valueOf(commonParam.getUserId()));
    			processLine.setModifyUserId(Long.valueOf(commonParam.getUserId()));
    			processLine.setPrevNodeCoordinateX(BlockX);
    			processLine.setPrevNodeCoordinateY(BlockY);
    			processLine.setNextNodeCoordinateX(prevBlockX);
    			processLine.setNextNodeCoordinateY(nextBlockY);
    			list.add(processLine);
    		}
		}
		return list;
	}
}
