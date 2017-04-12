package com.prodTOI.urs.DTO;

import java.util.List;

public class ProductDTO {
	
	private int productTypeId;

	private String productType;
	
	private String category;
	
	private String productDisplayName;
	
	private String productImage;
	
	private double productPrice;
	
	private CategoryDTO categoryDTO;
	
	private List<ProductDetailDTO> productDetailsDTO;


	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProductDisplayName() {
		return productDisplayName;
	}

	public void setProductDisplayName(String productDisplayName) {
		this.productDisplayName = productDisplayName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}

	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public List<ProductDetailDTO> getProductDetailsDTO() {
		return productDetailsDTO;
	}

	public void setProductDetailsDTO(List<ProductDetailDTO> productDetailsDTO) {
		this.productDetailsDTO = productDetailsDTO;
	}
	
	
	
	
	
}
