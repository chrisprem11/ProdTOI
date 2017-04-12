package com.prodTOI.urs.DTO;

import java.util.List;

public class CategoryDTO {

	private int productCategoryId;
	private String productCategory;
	private List<ProductDTO> productTypeDTO;

	
	public int getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public List<ProductDTO> getProductTypeDTO() {
		return productTypeDTO;
	}
	public void setProductTypeDTO(List<ProductDTO> productTypeDTO) {
		this.productTypeDTO = productTypeDTO;
	}
	
	


}
