package com.prodTOI.urs.dao;

import java.util.List;

import com.prodTOI.urs.DTO.CategoryDTO;
import com.prodTOI.urs.DTO.ProductDTO;
import com.prodTOI.urs.model.ProductType;

public interface ProductTypeDao {
	
	void save(ProductType object);

	List<ProductDTO> fetchAllProducts();

	ProductType fetchProductById(Integer id);

	void deleteOneProductType(ProductType productType);

	List<ProductType> searchProductTypeByName(String productName);

	ProductDTO saveProductType(CategoryDTO categoryDTO, ProductDTO productDTO, String encodedProductImage);

}
