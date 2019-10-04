package com.techsoft.context.filter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
 
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/** 
 *
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
	boolean isUpData = false;//判断是否是上传 上传忽略
	
	public XssHttpServletRequestWrapper(HttpServletRequest servletRequest) {
		super(servletRequest);
		String contentType = servletRequest.getContentType();
        if (null != contentType)
            isUpData =contentType.startsWith("multipart");
	}

	@Override
	public String[] getParameterValues(String parameter) {
		String[] values = super.getParameterValues(parameter);
		if (values == null) {
			return null;
		}
		int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			encodedValues[i] = cleanXSS(values[i]);
		}
		return encodedValues;
	}

	@Override
	public String getParameter(String parameter) {
		String value = super.getParameter(parameter);
		if (value == null) {
			return null;
		}
		return cleanXSS(value);
	}

	/**
	 * 获取request的属性时.做xss过滤
	 */
	@Override
	public Object getAttribute(String name) {
		Object value = super.getAttribute(name);
		if (null != value && value instanceof String) {
			value = cleanXSS((String) value);
		}
		return value;
	}

	@Override
	public String getHeader(String name) {

		String value = super.getHeader(name);
		if (value == null)
			return null;
		return cleanXSS(value);
	}

	private static String cleanXSS(String value) {
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		value = value.replaceAll("script", "");
		value = value.replaceAll("(?i)delete", "");
		value = value.replaceAll("(?i)update", "");
		value = value.replaceAll("(?i)drop", "");
		value = value.replaceAll("(?i)truncate", "");
	 
        value = value.replaceAll("共产党", "");
        value = value.replaceAll("[操|草].{0,3}[妈|马|B]", "");
        /*value = value.replaceAll("\\(", "（");
        value = value.replaceAll("\\)", "）");*/
		return value;
	}
	
	@Override
    public ServletInputStream getInputStream() throws IOException {
        //System.out.println("getInputStream()       value ==");
        if (isUpData){
            return super.getInputStream();
        }else{
            final ByteArrayInputStream bais = new ByteArrayInputStream(inputHandlers(super.getInputStream()).getBytes());
            return new ServletInputStream() {
                @Override
                public int read() throws IOException {
                    return bais.read();
                }
               
            };
        }

    }
    public String inputHandlers(ServletInputStream servletInputStream){
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(servletInputStream, Charset.forName("UTF-8")));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (servletInputStream != null) {
                try {
                    servletInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  cleanXSS(sb.toString ());
    }

}