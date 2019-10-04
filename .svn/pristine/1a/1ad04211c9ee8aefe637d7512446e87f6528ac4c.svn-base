package com.techsoft.common.maps;

import java.util.HashMap;
import java.util.Map;

import com.techsoft.common.enums.EnumYesOrNo;

public class MapYesOrNo {
	private static Map<String, String> map = null;

	public static Map<String, String> getMap() {
		if (MapYesOrNo.map == null) {
			Map<String, String> maps = new HashMap<String, String>();
			maps.put(EnumYesOrNo.YES.getValue(), "是");
			maps.put(EnumYesOrNo.NO.getValue(), "否");  
			MapYesOrNo.map = maps;
		}
		return MapYesOrNo.map;
	}

	public static String getValue(String key) {
		if (MapYesOrNo.map == null) {
			getMap();
		}

		return MapYesOrNo.map.get(key);
	}
}
