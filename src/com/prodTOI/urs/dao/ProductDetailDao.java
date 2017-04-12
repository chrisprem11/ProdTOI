package com.prodTOI.urs.dao;

import java.util.List;

import com.prodTOI.urs.model.ProductDetail;
import com.prodTOI.urs.model.ProductType;

public interface ProductDetailDao {

	List<ProductDetail> fetchAllProductDetails();

	List<ProductDetail> searchProductDetailsByProdcutType(ProductType product);

}
