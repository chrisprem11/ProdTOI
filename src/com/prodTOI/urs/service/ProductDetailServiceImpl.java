package com.prodTOI.urs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prodTOI.urs.dao.ProductDetailDao;
import com.prodTOI.urs.model.ProductDetail;
import com.prodTOI.urs.model.ProductType;

@Service("productDetailService")
@Transactional
public class ProductDetailServiceImpl implements ProductDetailService{
	
	@Autowired
	ProductDetailDao productDetailDao;

	@Override
	public List<ProductDetail> fetchAllProductDetails() {
		
		return productDetailDao.fetchAllProductDetails();
	}

	@Override
	public List<ProductDetail> getAllDetailsByProductType(ProductType product) {
		return productDetailDao.searchProductDetailsByProdcutType(product);
	}

}
