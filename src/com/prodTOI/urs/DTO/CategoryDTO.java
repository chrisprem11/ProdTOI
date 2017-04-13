package com.prodTOI.urs.DTO;

import java.util.List;

import com.prodTOI.urs.model.ProductType;

public class CategoryDTO {

	private int productCategoryId;
	private String productCategory;
	private List<ProductType> productType;

	
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
	public List<ProductType> getProductType() {
		return productType;
	}
	public void setProductType(List<ProductType> productType) {
		this.productType = productType;
	}
	
	


}
