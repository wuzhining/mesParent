
package com.techsoft.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * 字符串工具类, 继承org.apache.commons.lang3.StringUtils类
 * 
 * @version 2017-05-22
 */
public class StringUtil extends org.apache.commons.lang3.StringUtils {
	
    private static final char SEPARATOR = '_';
    private static final String CHARSET_NAME = "UTF-8";
    

	public static boolean verifyNull(String info) {
		boolean result = false;
		if (info == null)
			result = true;
		else if (info.trim().length() <= 0)
			result = true;
		return result;
	}
	
    public static boolean verifyMobile(String mobile) {
		if (!verifyNull(mobile)) {
			final String mobileRegexp = "^1[0-9]{10}$";
			try {
				final Pattern pattern = Pattern.compile(mobileRegexp);
				if (pattern.matcher(mobile).find())
					return true;
			} catch (Exception e) {
				;
			}
		}
		return false;
	}
    
    /**
	 * 浮点型判断
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDecimal(String str) {
		if (str == null || "".equals(str))
			return false;
		Pattern pattern = Pattern.compile("[0-9]*(\\.?)[0-9]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * 整型判断
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str) {
		if (str == null)
			return false;
		Pattern pattern = Pattern.compile("[0-9]+");
		return pattern.matcher(str).matches();
	}

	
    /**
     * 转换为字节数组
     * @param str
     * @return
     */
    public static byte[] getBytes(String str){
    	if (str != null){
    		try {
				return str.getBytes(CHARSET_NAME);
			} catch (UnsupportedEncodingException e) {
				return null;
			}
    	}else{
    		return null;
    	}
    }
    
    /**
     * 判断字符串是否都为数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
    	if (isBlank(str)) {
    		return false;
    	}
    	for (int i = 0; i < str.length(); i++){
    		if (!Character.isDigit(str.charAt(i))){
    			return false;
    		}
    	}
    	return true;
    }
    
    /**
	 * 转换为Boolean类型
	 * 'true', 'on', 'y', 't', 'yes' or '1' (case insensitive) will return true. Otherwise, false is returned.
	 */
	public static Boolean toBoolean(final Object val){
		if (val == null){
			return false;
		}
		return BooleanUtils.toBoolean(val.toString()) || "1".equals(val.toString());
	}
	
    /**
     * 转换为字节数组
     * @param str
     * @return
     */
    public static String toString(byte[] bytes){
    	try {
			return new String(bytes, CHARSET_NAME);
		} catch (UnsupportedEncodingException e) {
			return EMPTY;
		}
    }
    
    /**
	 * 如果对象为空，则使用defaultVal值 
	 * 	see: ObjectUtils.toString(obj, defaultVal)
	 * @param obj
	 * @param defaultVal
	 * @return
	 */
    public static String toString(final Object obj, final String defaultVal) {
    	 return obj == null ? defaultVal : obj.toString();
    }
    
    /**
     * 是否包含字符串
     * @param str 验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inString(String str, String... strs){
    	if (str != null){
        	for (String s : strs){
        		if (str.equals(trim(s))){
        			return true;
        		}
        	}
    	}
    	return false;
    }
 
	public static boolean verifyNumber(String number) {
		if (!verifyNull(number)) {
			final String numberRegexp = "^([0-9]+)$";
			try {
				final Pattern pattern = Pattern.compile(numberRegexp);
				if (pattern.matcher(number.trim()).find()) {
					return true;
				}
			} catch (Exception e) {
				;
			}
		}
		return false;
	}

	public static boolean verifyFloat(String number) {
		if (!verifyNull(number)) {
			final String numberRegexp = "^([0-9]+)[.]*([0-9]*)$";
			try {
				final Pattern pattern = Pattern.compile(numberRegexp);
				if (pattern.matcher(number.trim()).find()) {
					return true;
				}
			} catch (Exception e) {
				;
			}
		}
		return true;
	}
	/**
	 * 替换掉HTML标签方法
	 */
	public static String replaceHtml(String html) {
		if (isBlank(html)){
			return "";
		}
		String regEx = "<.+?>";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(html);
		String s = m.replaceAll("");
		return s;
	}
	
	
	public static boolean verifyLoginName(String loginname) {
		if (!verifyNull(loginname)) {
			final String loginnameRegexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{4,10}$";
			try {
				final Pattern patternname = Pattern.compile(loginnameRegexp);
				if (patternname.matcher(loginname).find())
					return true;
			} catch (Exception e) {
				;
			}
		}
		return false;
	}
	/**
	 * 替换为手机识别的HTML，去掉样式及属性，保留回车。
	 * @param html
	 * @return
	 */
	public static String replaceMobileHtml(String html){
		if (html == null){
			return "";
		}
		return html.replaceAll("<([a-z]+?)\\s+?.*?>", "<$1>");
	}
	
 

	/**
	 * 缩略字符串（不区分中英文字符）
	 * @param str 目标字符串
	 * @param length 截取长度
	 * @return
	 */
	public static String abbr(String str, int length) {
		if (str == null) {
			return "";
		}
		try {
			StringBuilder sb = new StringBuilder();
			int currentLength = 0;
			for (char c : replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray()) {
				currentLength += String.valueOf(c).getBytes("GBK").length;
				if (currentLength <= length - 3) {
					sb.append(c);
				} else {
					sb.append("...");
					break;
				}
			}
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
 
	
	/**
	 * 转换为Double类型
	 */
	public static Double toDouble(Object val){
		if (val == null){
			return 0D;
		}
		try {
			return Double.valueOf(trim(val.toString()));
		} catch (Exception e) {
			return 0D;
		}
	}

	/**
	 * 转换为Float类型
	 */
	public static Float toFloat(Object val){
		return toDouble(val).floatValue();
	}

	/**
	 * 转换为Long类型
	 */
	public static Long toLong(Object val){
		return toDouble(val).longValue();
	}

	/**
	 * 转换为Integer类型
	 */
	public static Integer toInteger(Object val){
		if (val == null){
			return 0;
		}
		try {
			return Integer.valueOf(trim(val.toString()));
		} catch (Exception e) {
			return 0;
		}
	}
 
	
	/**
	 * 获得用户远程地址
	 */
	public static String getRemoteAddr(HttpServletRequest request){
		String remoteAddr = request.getHeader("X-Real-IP");
        if (isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("X-Forwarded-For");
        }else if (isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("Proxy-Client-IP");
        }else if (isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
	}

	/**
	 * 驼峰命名法工具
	 * @return
	 * 		toCamelCase("hello_world") == "helloWorld" 
	 * 		toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 * 		toUnderScoreCase("helloWorld") = "hello_world"
	 */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }

        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
	 * 驼峰命名法工具
	 * @return
	 * 		toCamelCase("hello_world") == "helloWorld" 
	 * 		toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 * 		toUnderScoreCase("helloWorld") = "hello_world"
	 */
    public static String toCapitalizeCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = toCamelCase(s);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
    
    /**
	 * 驼峰命名法工具
	 * @return
	 * 		toCamelCase("hello_world") == "helloWorld" 
	 * 		toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 * 		toUnderScoreCase("helloWorld") = "hello_world"
	 */
    public static String toUnderScoreCase(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean nextUpperCase = true;

            if (i < (s.length() - 1)) {
                nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
            }

            if ((i > 0) && Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) {
                    sb.append(SEPARATOR);
                }
                upperCase = true;
            } else {
                upperCase = false;
            }

            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }
 
    /**
     * 转换为JS获取对象值，生成三目运算返回结果
     * @param objectString 对象串
     *   例如：row.user.id
     *   返回：!row?'':!row.user?'':!row.user.id?'':row.user.id
     */
    public static String jsGetVal(String objectString){
    	StringBuilder result = new StringBuilder();
    	StringBuilder val = new StringBuilder();
    	String[] vals = split(objectString, ".");
    	for (int i=0; i<vals.length; i++){
    		val.append("." + vals[i]);
    		result.append("!"+(val.substring(1))+"?'':");
    	}
    	result.append(val.substring(1));
    	return result.toString();
    }
    
	/**
	 * 判断手机号是否合法
	 * 
	 * @param phone
	 * @return
	 */
	public static boolean isPhone(String phone) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^1[0-9]{10}$");
		m = p.matcher(phone);
		b = m.matches();
		return b;
	}
	
	/**
	 * 字符串首字母小写
	 * 
	 * @param 字符串
	 * @return 字符串
	 */
	public static String toLowerCaseFirstChar(String str) {
		if (str == null || "".equals(str))
			return str;
		if (Character.isLowerCase(str.charAt(0)))
			return str;
		else
			return (new StringBuilder()).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1))
					.toString();
	}

	/**
	 * 字符串首字母大写
	 * 
	 * @param 字符串
	 * 
	 * @return 字符串
	 */
	public static String toUpperCaseFirstChar(String str) {
		if (str == null || "".equals(str))
			return str;
		if (Character.isUpperCase(str.charAt(0)))
			return str;
		else
			return (new StringBuilder()).append(Character.toUpperCase(str.charAt(0))).append(str.substring(1))
					.toString();
	}

	/**
	 * @param 待处理的字符串
	 * 
	 * @return 返回骆驼式命名法的字符器
	 * 
	 *         第一个单词小写，其他单词第一个字母大写
	 * 
	 *         字段名称以一到多个单词， 单词之间用下划线区分
	 */
	public static String camelCase(String value) {
		String[] words = value.split("_");
		StringBuilder result = new StringBuilder();
		String word = null;
		String firstChar = null;
		String otherChars = null;
		for (int i = 0; i < words.length; i++) {
			word = words[i];
			if (i == 0) {
				result.append(word.toLowerCase());
			} else {
				firstChar = word.substring(0, 1);
				otherChars = word.substring(1, word.length());
				result.append(firstChar.toUpperCase()).append(otherChars.toLowerCase());
			}
		}

		return result.toString();
	}

	/**
	 * 将驼峰式命名的字符串转换为下划线大写方式。如果转换前的驼峰式命名的字符串为空，则返回空字符串。
	 * 
	 * 例如：HelloWorld->HELLO_WORLD
	 * 
	 * @param name
	 *            转换前的驼峰式命名的字符串
	 * 
	 * @return 转换后下划线大写方式命名的字符串
	 */
	public static String underScoreName(String name) {
		StringBuilder result = new StringBuilder();
		if (name != null && name.length() > 0) {
			// 将第一个字符处理成大写
			result.append(name.substring(0, 1).toUpperCase());
			// 循环处理其余字符
			for (int i = 1; i < name.length(); i++) {
				String s = name.substring(i, i + 1);
				// 在大写字母前添加下划线
				if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
					result.append("_");
				}
				// 其他字符直接转成大写
				result.append(s.toUpperCase());
			}
		}
		return result.toString();
	}

	public static boolean isBlank(String value) {
		return ((value == null) || (value.equals("")));
	}

	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	
	/**
	 * 遍历集合
	 * @param numbers
	 * @return
	 */
	public static String addNumbersForIn(Collection<? extends Number> numbers) {
		if(numbers != null && numbers.size() != 0){
			StringBuilder sb = new StringBuilder("");
			for(Number num : numbers){
				sb.append(num);
				sb.append(",");
			}
			sb.replace(sb.length()-1, sb.length(), "");
			return sb.toString();
		}
		return null;
	}

	public static void main(String args[]) {
		System.out.println(getUUID());
	}
}
