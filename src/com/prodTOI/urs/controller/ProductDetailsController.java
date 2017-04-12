package com.prodTOI.urs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prodTOI.urs.model.ProductDetail;
import com.prodTOI.urs.model.ProductType;
import com.prodTOI.urs.service.ProductDetailService;
import com.prodTOI.urs.service.ProductTypeService;

@RestController
public class ProductDetailsController {

	@Autowired
	private ProductDetailService productDetailService;
	
	@Autowired
	private ProductTypeService productTypeService;

	/**
	 * This method is used to get all the Product Details
	 * 
	 * @return ProductDetails List
	 */
	@RequestMapping(value = "/getAllProductDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDetail>> getAllProductDetails() {
		List<ProductDetail> allProductDetails = productDetailService.fetchAllProductDetails();
		return new ResponseEntity<List<ProductDetail>>(allProductDetails, HttpStatus.OK);
	}
	
	/**
	 * This method is used to find all the related attributes to a particular product type
	 * @param id
	 * @return ProductDetails List
	 */
	@RequestMapping(value="/getProductDetails/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDetail>> getProductDetails(@PathVariable("id") Integer id){
		ProductType product = productTypeService.searchProductTypeById(id);
		List<ProductDetail> allProductDetails = productDetailService.getAllDetailsByProductType(product);
		return new ResponseEntity<List<ProductDetail>>(allProductDetails, HttpStatus.OK);
	}

}
