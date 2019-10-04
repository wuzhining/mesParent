package com.techsoft.entity.config;

import com.techsoft.entity.common.ConfigAppInterface;
import com.techsoft.entity.common.ConfigDictionary;

public class ConfigAppInterfaceVo extends ConfigAppInterface {
	private static final long serialVersionUID = 338819168096694538L;

	private ConfigDictionary interfaceTypeDic;
	
	private ConfigDictionary interfaceTypeCallerDic;

	public ConfigAppInterfaceVo() {	
	}
	
	
	public ConfigDictionary getInterfaceTypeCallerDic() {
		return interfaceTypeCallerDic;
	}


	public void setInterfaceTypeCallerDic(ConfigDictionary interfaceTypeCallerDic) {
		this.interfaceTypeCallerDic = interfaceTypeCallerDic;
	}


	public ConfigDictionary getInterfaceTypeDic() {
		return interfaceTypeDic;
	}

	public void setInterfaceTypeDic(ConfigDictionary interfaceTypeDic) {
		this.interfaceTypeDic = interfaceTypeDic;
	}



	public ConfigAppInterfaceVo(ConfigAppInterface value) {
		value.cloneProperties(this);
	}		
}
