package com.prodTOI.urs.DTO;

import java.util.List;

public class AttributeDTO {
	
	private int attributeId;

	private String attributes;

	private String value;
	
	private String attributeDisplayName;
	
	private List<ProductDetailDTO> productDetailsDTO;


	public int getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getAttributeDisplayName() {
		return attributeDisplayName;
	}

	public void setAttributeDisplayName(String attributeDisplayName) {
		this.attributeDisplayName = attributeDisplayName;
	}

	public List<ProductDetailDTO> getProductDetailsDTO() {
		return productDetailsDTO;
	}

	public void setProductDetailsDTO(List<ProductDetailDTO> productDetailsDTO) {
		this.productDetailsDTO = productDetailsDTO;
	}
	
	
	

}
