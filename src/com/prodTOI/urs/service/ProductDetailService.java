package com.prodTOI.urs.service;

import java.util.List;

import com.prodTOI.urs.DTO.ProductDTO;
import com.prodTOI.urs.DTO.ProductDetailDTO;

public interface ProductDetailService {

	List<ProductDetailDTO> fetchAllProductDetails();

	List<ProductDetailDTO> getAllDetailsByProductType(ProductDTO productDTO);

}
