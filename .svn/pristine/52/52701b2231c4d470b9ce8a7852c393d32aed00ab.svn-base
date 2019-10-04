package com.techsoft.common.maps;

import java.util.HashMap;
import java.util.Map;

import com.techsoft.common.enums.EnumUserStatus;

/**
 * 
 * @author tanyekai
 *  
 */
public class MapUserStatus {
	private static Map<String, String> map = null;

	public static Map<String, String> getMap() {
		if (MapUserStatus.map == null) {
			Map<String, String> maps = new HashMap<String, String>();
			maps.put(EnumUserStatus.ENABLED.getValue(), "启用");
			maps.put(EnumUserStatus.DISABLED.getValue(), "停用"); 

			MapUserStatus.map = maps;
		}
		return MapUserStatus.map;
	}

	public static String getValue(String key) {
		if (MapUserStatus.map == null) {
			getMap();
		}

		return MapUserStatus.map.get(key);
	}
}
