package com.prodTOI.urs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prodTOI.urs.DTO.CategoryDTO;
import com.prodTOI.urs.DTO.ProductDTO;
import com.prodTOI.urs.model.ProductType;
import com.prodTOI.urs.service.CategoryService;
import com.prodTOI.urs.service.ProductTypeService;

@RestController
public class ProductTypeController {

	@Autowired
	private ProductTypeService productTypeService;

	@Autowired
	private CategoryService categoryService;

	/**
	 * This method is used to create one product type.
	 * 
	 * @param productType
	 * @return ProductType object
	 */
	@RequestMapping(value = "/createProduct/type", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> createOneProductType(@RequestBody ProductDTO productDTO) {
		CategoryDTO categoryDTO = categoryService.findCategoryByName(productDTO.getCategory());
		if (categoryDTO == null) {
			System.out.println("Category not found !");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		ProductDTO newProduct = productTypeService.createNewProduct(categoryDTO, productDTO);
		return new ResponseEntity<ProductDTO>(newProduct, HttpStatus.OK);
	}

	/**
	 * This method is used to retrieve all product type
	 * 
	 * @return ProductType list
	 */
	@RequestMapping(value = "/getAllProductType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> getAllProductType() {
		List<ProductDTO> productTypeDTOList = productTypeService.fetchAllProducts();
		if (productTypeDTOList == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ProductDTO>>(productTypeDTOList, HttpStatus.OK);

	}

	/**
	 * This method deletes one Product Type
	 * 
	 * @return Deleted ProductType Object
	 */
	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> deleteOneProductType(@PathVariable("id") Integer id) {
		ProductDTO deleteProduct = productTypeService.deleteOneProductType(id);
		return new ResponseEntity<ProductDTO>(deleteProduct, HttpStatus.OK);
	}

	/**
	 * This method is used to update one ProductType via its ID
	 * 
	 * @return Deleted ProductType Object
	 */
	@RequestMapping(value = "/updateOneProduct", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> updateOneProductType(@RequestBody ProductDTO productDTO) {
		ProductDTO updatedProduct = productTypeService.updateOneProductType(productDTO);
		return new ResponseEntity<ProductDTO>(updatedProduct, HttpStatus.OK);
	}

	/**
	 * This method is used to search a product by its name.
	 * 
	 * @param productName
	 * @return ProductType Object
	 */
	@RequestMapping(value = "/searchProductType/{productName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> searchProductType(@PathVariable("productName") String productName) {
		List<ProductDTO> existingProduct = productTypeService.searchProductTypeByName(productName);
		return new ResponseEntity<List<ProductDTO>>(existingProduct, HttpStatus.OK);
	}
}
