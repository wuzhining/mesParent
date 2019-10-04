package com.techsoft.common.utils;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class EncryptUtil {

	private static final String SECURE_KEY = "tasdf323nyekai";

	private static EncryptUtil instance;

	public synchronized static EncryptUtil getEncryptInstance() {
		if (instance == null) {
			instance = new EncryptUtil();
		}
		return instance;
	}

	/**
	 * 加密字符串-明文输入，密文输出
	 * 
	 * @param strUseful
	 * @return
	 */
	public String getSecureString(String strUseful) {
		return createPar(strUseful);
	}

	/**
	 * 解密字符串-密文输入，明文输出
	 * 
	 * @param strSecure
	 * @return
	 */
	public String getUsefulString(String strSecure) {
		String[] rtArr = unPar(strSecure);
		if (rtArr != null && rtArr.length > 0) {
			return rtArr[rtArr.length - 1];
		}
		return "";
	}

	private String[] unPar(String strSecure) {
		if (strSecure == null || strSecure.trim().equals(""))
			return null;
		try {
			String strUseful = unEncrypt(strSecure);
			if (strUseful == null || strUseful.trim().equals("")) {
				return null;
			}
			return strUseful.split(":");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String createPar(String strUseful) {
		if (strUseful == null || strUseful.trim().equals(""))
			return "";
		String time = String.valueOf(System.currentTimeMillis() / 1000);
		StringBuffer sb = new StringBuffer();
		sb.append(SECURE_KEY).append(":");
		sb.append(time).append(":");
		sb.append(strUseful);
		return encrypt(sb.toString());
	}

	private String encrypt(String str) {
		if (str == null || str.equals("")) {
			return "";
		}
		Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(str.getBytes());
	}

	private String unEncrypt(String str) {
		if (str == null || str.equals("")) {
			return "";
		}
		Decoder decoder = Base64.getDecoder();
		byte[] b = decoder.decode(str);
		return new String(b);
	}
	
	public static void main(String args[]) {
		String bb = EncryptUtil.getEncryptInstance().getSecureString("QQQQQQQQQQ");
		String aa = EncryptUtil.getEncryptInstance().getUsefulString(bb);
		System.out.println(bb);
		System.out.println(aa);
	}
}
