package com.prodTOI.urs.DTO;

public class ProductDetailDTO {

	private int id;

	private ProductDTO productTypeDTO;
	
	private AttributeDTO attributeDTO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductDTO getProductTypeDTO() {
		return productTypeDTO;
	}

	public void setProductTypeDTO(ProductDTO productTypeDTO) {
		this.productTypeDTO = productTypeDTO;
	}

	public AttributeDTO getAttributeDTO() {
		return attributeDTO;
	}

	public void setAttributeDTO(AttributeDTO attributeDTO) {
		this.attributeDTO = attributeDTO;
	}
	
	


	
}
