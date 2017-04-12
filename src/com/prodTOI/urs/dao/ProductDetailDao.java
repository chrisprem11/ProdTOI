package com.prodTOI.urs.dao;

import java.util.List;

import com.prodTOI.urs.DTO.ProductDTO;
import com.prodTOI.urs.DTO.ProductDetailDTO;

public interface ProductDetailDao {

	List<ProductDetailDTO> fetchAllProductDetails();

	List<ProductDetailDTO> searchProductDetailsByProdcutType(ProductDTO productDTO);

}
