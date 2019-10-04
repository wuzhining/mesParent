
package com.techsoft.common.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
 


import org.apache.commons.lang3.StringUtils;

import com.techsoft.common.constants.Constants; 

/**
 * Cookie工具类
 * 
 * @version 
 */
public class CookieUtils {

	/**
	 * 设置 Cookie（生成时间为1天）
	 * @param name 名称
	 * @param value 值
	 */
	public static void setCookie(HttpServletResponse response, String name, String value) {
		setCookie(response, name, value, 60*60*24);
	}
	
	/**
	 * 设置 Cookie
	 * @param name 名称
	 * @param value 值
	 * @param maxAge 生存时间（单位秒）
	 * @param uri 路径
	 */
	public static void setCookie(HttpServletResponse response, String name, String value, String path) {
		setCookie(response, name, value, path, 60*60*24);
	}
	
	/**
	 * 设置 Cookie
	 * @param name 名称
	 * @param value 值
	 * @param maxAge 生存时间（单位秒）
	 * @param uri 路径
	 */
	public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
		setCookie(response, name, value, "/", maxAge);
	}
	
	/**
	 * 设置 Cookie
	 * @param name 名称
	 * @param value 值
	 * @param maxAge 生存时间（单位秒）
	 * @param uri 路径
	 */
	public static void setCookie(HttpServletResponse response, String name, String value, String path, int maxAge) {
		Cookie cookie = new Cookie(name, null);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		try {
			cookie.setValue(URLEncoder.encode(value, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.addCookie(cookie);
	}
	
	/**
	 * 获得指定Cookie的值
	 * @param name 名称
	 * @return 值
	 */
	public static String getCookie(HttpServletRequest request, String name) {
		return getCookie(request, null, name, false);
	}
	/**
	 * 获得指定Cookie的值，并删除。
	 * @param name 名称
	 * @return 值
	 */
	public static String getCookie(HttpServletRequest request, HttpServletResponse response, String name) {
		return getCookie(request, response, name, true);
	}
	/**
	 * 获得指定Cookie的值
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param name 名字
	 * @param isRemove 是否移除
	 * @return 值
	 */
	public static String getCookie(HttpServletRequest request, HttpServletResponse response, String name, boolean isRemove) {
		String value = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					try {
						value = URLDecoder.decode(cookie.getValue(), "utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					if (isRemove) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
			}
		}
		return value;
	}
	
	

	public static String getCookieValue(HttpServletRequest request,
			String cookieName) {
		return getCookieValue(request, cookieName, false);
	}

	public static String getCookieValue(HttpServletRequest request,
			String cookieName, boolean isDecoder) {
		Cookie cookieList[] = request.getCookies();
		if (cookieList == null || cookieName == null)
			return null;
		String retValue = null;
		try {
			for (int i = 0; i < cookieList.length; i++) {
				if (cookieList[i].getName().equals(cookieName)) {
					if (isDecoder) {
						retValue = URLDecoder.decode(cookieList[i].getValue(),
								"utf-8");
					} else {
						retValue = cookieList[i].getValue();
					}
					break;
				}
			}
		} catch (UnsupportedEncodingException e) {
			
		}
		return retValue;
	}

	
	public static void setCookie(HttpServletRequest request,
			HttpServletResponse response, String cookieName, String cookieValue) {
		setCookie(request, response, cookieName, cookieValue, -1);
	}

	public static void setCookie(HttpServletRequest request,
			HttpServletResponse response, String cookieName,
			String cookieValue, int cookieMaxage) {
		setCookie(request, response, cookieName, cookieValue, cookieMaxage,
				false);
	}

	public static void setSecret(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		String strUseful = "";
		strUseful = new BigInteger(32, new Random()).toString(16).toUpperCase();
		session.setAttribute(Constants.COOKIEKEY_SECRET, strUseful);
		CookieUtils.setCookie(request, response, Constants.COOKIEKEY_SECRET,
				EncryptUtil.getEncryptInstance().getSecureString(strUseful),
				Constants.COOKIEMAXAGE, true);
 
		
	}
	public static Boolean validSecret(HttpServletRequest request) {
		Boolean result = false;
		String secret = CookieUtils.getCookieValue(request,
				Constants.COOKIEKEY_SECRET);
	 
		if (StringUtils.isNotBlank(secret)) {
			if(secret.contains("%3D")){
				secret = secret.replace("%3D", "=");
			}
			secret = EncryptUtil.getEncryptInstance().getUsefulString(secret);
		 
			HttpSession session = request.getSession();
			String strUseful = (String) session
					.getAttribute(Constants.COOKIEKEY_SECRET);
		 
			if (secret.equals(strUseful))
				result = true;

		}
		return result;
	}


	public static void setCookie(HttpServletRequest request,
			HttpServletResponse response, String cookieName,
			String cookieValue, boolean isEncode) {
		setCookie(request, response, cookieName, cookieValue, -1, isEncode);
	}

	public static void setCookie(HttpServletRequest request,
			HttpServletResponse response, String cookieName,
			String cookieValue, int cookieMaxage, boolean isEncode) {
		doSetCookie(request, response, cookieName, cookieValue, cookieMaxage,
				isEncode);
	}

	public static void deleteCookie(HttpServletRequest request,
			HttpServletResponse response, String cookieName) {
		doSetCookie(request, response, cookieName, "", 0, false);
	}

	public static void deleteCookie(HttpServletResponse response,
			String cookieName) {
		doSetCookie(null, response, cookieName, "", 0, false);
	}

	private static final void doSetCookie(HttpServletRequest request,
			HttpServletResponse response, String cookieName,
			String cookieValue, int cookieMaxage, boolean isEncode) {
		try {
			if (cookieValue != null && cookieValue.equals("")) {
				cookieValue = null;
			} else if (isEncode) {
				cookieValue = URLEncoder.encode(cookieValue, "utf-8");
			}
			Cookie cookie = new Cookie(cookieName, cookieValue);
			if (cookieMaxage > 0)
				cookie.setMaxAge(cookieMaxage);
			else {
				if (cookieValue == null)
					cookie.setMaxAge(0);
			}

//			if (null != request)
//				cookie.setDomain(PropertiesUtil.getValue(request,
//						PropertiesUtil.WEBSITEDOMAINNAME));

			cookie.setPath("/");
			response.addCookie(cookie);
		} catch (Exception e) {
		}
	}

	public static void addCookie(HttpServletRequest request,
			HttpServletResponse response, Long userId, String userName) {
		//
		// CookieUtils.setCookie(request, response, "bbs_uid", "" + userId,
		// Constants.COOKIEMAXAGE, false);
	
		CookieUtils.setCookie(request, response,
				Constants.COOKIEKEY_LOGINUSERID, EncryptUtil
						.getEncryptInstance().getSecureString("" + userId),
				Constants.COOKIEMAXAGE, false);

		CookieUtils.setCookie(request, response,
				Constants.COOKIEKEY_LOGINUSERNAME, userName,
				Constants.COOKIEMAXAGE, true);
	}

	public static void clearCookie(HttpServletRequest request,
			HttpServletResponse response) {
		CookieUtils.deleteCookie(request, response,
				Constants.COOKIEKEY_LOGINUSERID);
		CookieUtils.deleteCookie(request, response,
				Constants.COOKIEKEY_LOGINUSERNAME);
		 
		CookieUtils.deleteCookie(request, response,
				Constants.COOKIEKEY_FROMOTHERSITEURL); 
	 
		CookieUtils
		.deleteCookie(request, response, Constants.COOKIEKEY_LOCATION_PROVINCEID); 
		CookieUtils.deleteCookie(request, response,
				Constants.COOKIEKEY_USERNICKNAME);

	}

	public static void setComponentparamIds(HttpServletRequest request,
			HttpServletResponse response, Long paramId) {
		String componentparamIds = getComponentparamIds(request);
		if (StringUtils.isNotBlank(componentparamIds)) {
			componentparamIds = componentparamIds + ";" + paramId;
		} else {
			componentparamIds = "" + paramId;
		}
		CookieUtils.setCookie(request, response,
				Constants.COOKIEKEY_COMPONENTPARAMID, componentparamIds,
				Constants.COOKIEMAXAGE, false);
	}

	public static String getComponentparamIds(HttpServletRequest request) {
		return CookieUtils.getCookieValue(request,
				Constants.COOKIEKEY_COMPONENTPARAMID);
	}

	  

	public static Long getLoginUserId(HttpServletRequest request) {
		String userId = CookieUtils.getCookieValue(request,
				Constants.COOKIEKEY_LOGINUSERID);

		if (StringUtils.isNotBlank(userId)) {
			userId = EncryptUtil.getEncryptInstance().getUsefulString(userId);
			return new Long(userId);
		} else
			return null;

	}

	/**
	 * 获取当前登陆的用户名
	 */
	public static String getLoginUserName(HttpServletRequest request) {
		//
		return CookieUtils.getCookieValue(request,
				Constants.COOKIEKEY_LOGINUSERNAME, true);
	}

	public static Long getProvinceId(HttpServletRequest request) {
		String provinceId = CookieUtils.getCookieValue(request,
				Constants.COOKIEKEY_LOCATION_PROVINCEID);

		if (StringUtils.isNotBlank(provinceId)) {
			// provinceId = EncryptUtil.getEncryptInstance().getUsefulString(
			// provinceId);
			return new Long(provinceId);
		} else
			return null;

	}

	public static void setProvinceId(HttpServletRequest request,
			HttpServletResponse response, Long provinceId) {
		CookieUtils.setCookie(request, response, Constants.COOKIEKEY_LOCATION_PROVINCEID,
				"" + provinceId, Constants.COOKIEMAXAGE, false);

	}

	 
 
	
	public static String getVisitIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String secret = EncryptUtil.getEncryptInstance().getUsefulString("dGFueWVrYWk6MTQ1MzM2NTMxMjo1RDhCNEY4MQ==");
		System.out.println(secret);
	}
}
