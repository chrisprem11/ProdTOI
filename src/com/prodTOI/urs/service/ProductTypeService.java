package com.prodTOI.urs.service;

import java.util.List;

import com.prodTOI.urs.DTO.CategoryDTO;
import com.prodTOI.urs.DTO.ProductDTO;
import com.prodTOI.urs.model.ProductType;

public interface ProductTypeService {
	
	public void saveProductType(ProductType object);

	public List<ProductDTO> fetchAllProducts();

	public ProductDTO createNewProduct(CategoryDTO categoryDTO, ProductDTO productDTO);

	public ProductType deleteOneProductType(Integer id);

	public ProductType updateOneProductType(ProductType product);

	public List<ProductType> searchProductTypeByName(String productName);

	public ProductType searchProductTypeById(Integer id);

}
