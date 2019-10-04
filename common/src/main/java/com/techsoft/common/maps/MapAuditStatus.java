package com.techsoft.common.maps;

import java.util.HashMap;
import java.util.Map;

import com.techsoft.common.enums.EnumAuditStatus;


/**
 * 
 * @author tanyekai
 * 
 */
public class MapAuditStatus {
	private static Map<Long, String> map = null;
	private static Map<Long, String> mapActivity = null;

	public static Map<Long, String> getMap() {
		if (MapAuditStatus.map == null) {
			Map<Long, String> maps = new HashMap<Long, String>();
			maps.put(EnumAuditStatus.UNAUDITED.getValue(), "申请审核中");
			maps.put(EnumAuditStatus.AUDITED.getValue(), "审核通过");
			maps.put(EnumAuditStatus.NONAPPROVAL.getValue(), "审核不通过");
			/*maps.put(EnumAuditStatus.CANCEL.getValue(), "已取消");*/
			
			
			MapAuditStatus.map = maps;
		}
		return MapAuditStatus.map;
	}
	

	public static Map<Long, String> getMapActivity() {
		if (MapAuditStatus.mapActivity == null) {
			Map<Long, String> maps = new HashMap<Long, String>();
			//maps.put(EnumAuditStatus.SAVE.getValue(), "未提交审核"); 
			maps.put(EnumAuditStatus.UNAUDITED.getValue(), "申请审核中");
			maps.put(EnumAuditStatus.AUDITED.getValue(), "审核通过");
			maps.put(EnumAuditStatus.NONAPPROVAL.getValue(), "审核不通过");
			MapAuditStatus.mapActivity = maps;
		}
		return MapAuditStatus.mapActivity;
	}


	public static String getValue(String key) {
		if (MapAuditStatus.mapActivity == null) {
			getMapActivity();
		}

		return MapAuditStatus.mapActivity.get(key);
	}
}
