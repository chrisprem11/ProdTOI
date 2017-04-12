package com.prodTOI.urs.service;

import java.util.List;

import com.prodTOI.urs.model.ProductDetail;
import com.prodTOI.urs.model.ProductType;

public interface ProductDetailService {

	List<ProductDetail> fetchAllProductDetails();

	List<ProductDetail> getAllDetailsByProductType(ProductType product);

}
