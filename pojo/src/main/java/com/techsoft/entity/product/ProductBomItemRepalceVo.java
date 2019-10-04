package com.techsoft.entity.product;

import com.techsoft.entity.common.ProductBomItemRepalce;

public class ProductBomItemRepalceVo extends ProductBomItemRepalce {
	private static final long serialVersionUID = -6216324388350217868L;

	public ProductBomItemRepalceVo() {	
	}
	
	public ProductBomItemRepalceVo(ProductBomItemRepalce value) {
		value.cloneProperties(this);
	}		
}
