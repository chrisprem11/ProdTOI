package com.prodTOI.urs.service;

import java.util.List;

import com.prodTOI.urs.DTO.CategoryDTO;
import com.prodTOI.urs.DTO.ProductDTO;
import com.prodTOI.urs.model.ProductType;

public interface ProductTypeService {
	
	public void saveProductType(ProductDTO object);

	public List<ProductDTO> fetchAllProducts();

	public ProductDTO createNewProduct(CategoryDTO categoryDTO, ProductDTO productDTO);

	public ProductDTO deleteOneProductType(Integer id);

	public ProductDTO updateOneProductType(ProductDTO productDTO);

	public List<ProductDTO> searchProductTypeByName(String productName);

	public ProductDTO searchProductTypeById(Integer id);

	public ProductDTO searchProductTypeDTOById(Integer id);


}
