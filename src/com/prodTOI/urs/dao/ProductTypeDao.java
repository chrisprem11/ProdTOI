package com.prodTOI.urs.dao;

import java.util.List;

import com.prodTOI.urs.DTO.CategoryDTO;
import com.prodTOI.urs.DTO.ProductDTO;
import com.prodTOI.urs.model.ProductType;

public interface ProductTypeDao {
	
	void save(ProductDTO object);

	List<ProductDTO> fetchAllProducts();

	ProductDTO fetchProductById(Integer id);

	void deleteOneProductType(ProductDTO productTypeDTO);

	List<ProductDTO> searchProductTypeByName(String productName);

	ProductDTO saveProductType(CategoryDTO categoryDTO, ProductDTO productDTO, String encodedProductImage);

	ProductDTO searchProductAndAttributeByProductTypeId(Integer id);

}
