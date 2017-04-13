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

import com.prodTOI.urs.DTO.ProductDTO;
import com.prodTOI.urs.DTO.ProductDetailDTO;
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
	public ResponseEntity<List<ProductDetailDTO>> getAllProductDetails() {
		List<ProductDetailDTO> allProductDetails = productDetailService.fetchAllProductDetails();
		return new ResponseEntity<List<ProductDetailDTO>>(allProductDetails, HttpStatus.OK);
	}
	
	/**
	 * This method is used to find all the related attributes to a particular product type
	 * @param id
	 * @return ProductDetails List
	 */
	@RequestMapping(value="/getProductDetails/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDetailDTO>> getProductDetails(@PathVariable("id") Integer id){
		ProductDTO productDTO = productTypeService.searchProductTypeById(id);
		List<ProductDetailDTO> allProductDetails = productDetailService.getAllDetailsByProductType(productDTO);
		return new ResponseEntity<List<ProductDetailDTO>>(allProductDetails, HttpStatus.OK);
	}

}
