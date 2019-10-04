package com.techsoft.entity.equip;

import com.techsoft.entity.common.EquipWorkProduct;

public class EquipWorkProductVo extends EquipWorkProduct {
	private static final long serialVersionUID = 5172225075027442152L;

	public EquipWorkProductVo() {
	}

	public EquipWorkProductVo(EquipWorkProduct value) {
		value.cloneProperties(this);
	}
}
