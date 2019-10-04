package com.techsoft.entity.common;

import com.techsoft.common.BaseEntity;

public class ConfigAppInterface extends BaseEntity {
	private static final long serialVersionUID = 6967120341484652838L;


	public ConfigAppInterface(){	
	}
	
	private Long tenantId;	
	   
	private String interfaceCode;	
	   
	private String interfaceName;	
	   
	private Long interfaceTypeDictId;	
	   
	private Long interfaceCallerDictId;	
	   
	private String isValid;	
	   
	private String isTiming;	
	   
                		
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
                		
	public String getInterfaceCode() {
		return interfaceCode;
	}

	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}
                		
	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
                		
	public Long getInterfaceTypeDictId() {
		return interfaceTypeDictId;
	}

	public void setInterfaceTypeDictId(Long interfaceTypeDictId) {
		this.interfaceTypeDictId = interfaceTypeDictId;
	}
                		
	public Long getInterfaceCallerDictId() {
		return interfaceCallerDictId;
	}

	public void setInterfaceCallerDictId(Long interfaceCallerDictId) {
		this.interfaceCallerDictId = interfaceCallerDictId;
	}
                		
	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
                		
	public String getIsTiming() {
		return isTiming;
	}

	public void setIsTiming(String isTiming) {
		this.isTiming = isTiming;
	}
}
