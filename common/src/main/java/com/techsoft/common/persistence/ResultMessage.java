package com.techsoft.common.persistence;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.techsoft.common.BaseEntity;

/**
 * 
 * @author tanyekai
 *
 */
public class ResultMessage implements java.io.Serializable {
	private static final long serialVersionUID = 8395411159547661179L;
	private BaseEntity baseEntity; //返回对象
	private Long id;  //对象ID
	private Boolean isSuccess = false;   //true:操作成功;flase:操作失败
	private Integer mark = 1;  //标记
	private String resultCode;   //信息内容
	private String message = "";   //信息内容
	private Map<String, Object> map;
	
	public ResultMessage() {
		map = new HashMap<String, Object>();
		this.message = "";
	}
	
	public ResultMessage(Boolean isSuccess) {
		map = new HashMap<String, Object>();
		this.message = "";
		this.isSuccess = isSuccess; 
	}
	
	/**
	 * 根据业务规定检验表单数据
	 * 
	 * @param msg
	 */
	public void addErr(String msg) {
		if (StringUtils.isBlank(this.message)) {
			this.message = msg;
		} else {
			this.message += "，" + msg;
		}
		this.isSuccess = false;
	}
	
	public BaseEntity getBaseEntity() {
		return baseEntity;
	}

	public void setBaseEntity(BaseEntity baseEntity) {
		this.baseEntity = baseEntity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	public void put(String k, Object v) {
		map.put(k, v);
	}

	public Object get(String key) {
		return map.get(key);
	}	
	public void put( Object v) {
		map.put("list", v);
	}
}
