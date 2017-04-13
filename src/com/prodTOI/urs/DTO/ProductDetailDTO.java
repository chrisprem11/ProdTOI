package com.prodTOI.urs.DTO;

import com.prodTOI.urs.model.Attribute;
import com.prodTOI.urs.model.ProductType;

public class ProductDetailDTO {

	private int id;

	private ProductType productType;
	
	private Attribute attribute;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}
	
	

	}
