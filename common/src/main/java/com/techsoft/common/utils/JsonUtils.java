package com.techsoft.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
 
 

/**
 * json工具类
 *
 */
public class JsonUtils {
	 

	/**
	 * 将list生成json
	 * 
	 * @param list
	 *            数据
	 * @param state
	 *            状态码
	 * @return json
	 */
	public static String getListJson(List<Map<String, String>> list,
			int pageCount, int state, String info) {
		String jsonStr = "";

		JSONObject json = new JSONObject();
		JSONArray jsonMembers = new JSONArray();

		if (list != null) {
			// 遍历list
			for (Map<String, String> map : list) {
				Iterator<String> iter = map.keySet().iterator();
				// json
				JSONObject member = new JSONObject();
				while (iter.hasNext()) {
					String key = iter.next();
					String value = map.get(key);

					member.put(key, value);
				}
				jsonMembers.add(member);
			}
		}
		json.put("state", state);
		json.put("info", info);
		// json.put("recordCount", recordCount);
		json.put("pageCount", pageCount);
		json.put("content", jsonMembers);

		jsonStr = json.toString();

		return jsonStr;
	}

	/**
	 * 将list生成json
	 * 
	 * @param list
	 *            数据
	 * @param state
	 *            状态码
	 * @return json
	 */
	public static String getListJson(List<Map<String, String>> list, int state,
			String info) {
		String jsonStr = "";

		JSONObject json = new JSONObject();
		JSONArray jsonMembers = new JSONArray();

		if (list != null) {
			// 遍历list
			for (Map<String, String> map : list) {

				// 遍历map
				Iterator<String> iter = map.keySet().iterator();
				// json
				JSONObject member = new JSONObject();
				while (iter.hasNext()) {

					String key = iter.next();
					String value = map.get(key);

					member.put(key, value);
				}
				jsonMembers.add(member);
			}
		}
		json.put("state", state);
		json.put("info", info);
		json.put("content", jsonMembers);

		jsonStr = json.toString();

		return jsonStr;
	}

	/**
	 * 将list生成json
	 * 
	 * @param list
	 *            数据
	 * @param state
	 *            状态码
	 * @return json
	 */
	public static String getJson(String jsonMembers, int state, String info) {
		String jsonStr = "";

		JSONObject json = new JSONObject();

		json.put("state", state);
		json.put("info", info);
		json.put("content", jsonMembers);

		jsonStr = json.toString();

		return jsonStr;
	}

	/**
	 * 根据节点名称解析json字符串
	 * 
	 * @param json
	 *            json字符串
	 * @param att
	 *            节点名称
	 * @return
	 */

	public static List conversionToList(String json, Class clazz) { 
		List list = (List) JSONArray.parseArray(json, clazz);
		return list;
	}

	public static Object conversionToObject(String json, Class clazz) { 
		return JSONObject.parseObject(json, clazz);
	}

	public static String conversionToJSON(Object object) { 
		return  JSONObject.toJSONString(object);
	}

	public static String conversionListToJSON(Object object) { 
		return JSONArray.toJSONString(object);
	}
 
	
	private static boolean isJsonObject(final String jsonStr) {
        if (jsonStr == null) return false;
        return Pattern.matches("^\\{.*\\}$", jsonStr.trim());
    }
     
    private static boolean isJsonArray(final String jsonStr) {
        if (jsonStr == null) return false;
        return Pattern.matches("^\\[.*\\]$", jsonStr.trim());
    }
 
	
	/**
	 * 对象转json格式的string，其中null不转
	 * @param o
	 * @return
	 */
	public static String toJSONString(Object o){
		com.alibaba.fastjson.JSONObject json = (com.alibaba.fastjson.JSONObject) com.alibaba.fastjson.JSONObject.toJSON(o);
		String str = json.toJSONString();
		return str;
	}

}
