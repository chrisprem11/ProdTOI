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
import com.prodTOI.urs.service.CategoryService;

@RestController
public class ProductController {

	@Autowired
	private CategoryService categoryService;

	/**
	 * This method is used to list all the existing categories
	 * 
	 * @return category list
	 */
	@RequestMapping(value = "/categoryList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoryDTO>> getCategoryList() {
		List<CategoryDTO> categoryList = categoryService.findAllCategories();
		return new ResponseEntity<List<CategoryDTO>>(categoryList, HttpStatus.OK);
	}

	/**
	 * This method is used to create one new category
	 * 
	 * @return Category object
	 */
	@RequestMapping(value = "/createOneCategory", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryDTO> createOneCategory(@RequestBody CategoryDTO categoryDTO) {
		categoryService.saveCategory(categoryDTO);
		return new ResponseEntity<CategoryDTO>(HttpStatus.OK);
	}

	/**
	 * This method is used to find one Category object via one category ID
	 * 
	 * @param id
	 * @param category
	 * @return Category object
	 */
	@RequestMapping(value = "/findOneCategory/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryDTO> findOneCategory(@PathVariable("id") Integer id) {
		CategoryDTO existingCategory = categoryService.findCategoryById(id);
		if (existingCategory == null) {
			System.out.println("Category with id - " + id + " not found !!");
			return new ResponseEntity<CategoryDTO>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<CategoryDTO>(existingCategory, HttpStatus.OK);
	}

	/**
	 * This method is used to update one category via one CategoryID
	 * 
	 * @param category
	 * @return Category object
	 */
	@RequestMapping(value = "/updateOneCategory", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryDTO> updateOneCategory(@RequestBody CategoryDTO categoryDTO) {
		CategoryDTO updateCategoryDTO = categoryService.findCategoryById(categoryDTO.getProductCategoryId());
		if (updateCategoryDTO == null) {
			return new ResponseEntity<CategoryDTO>(HttpStatus.NO_CONTENT);
		}
		updateCategoryDTO.setProductCategory(categoryDTO.getProductCategory());
		categoryService.updateCategory(updateCategoryDTO);
		return new ResponseEntity<CategoryDTO>(updateCategoryDTO, HttpStatus.OK);
	}

	/**
	 * This method is used to delete on Category via one category ID
	 * 
	 * @param id
	 * @return Category object
	 */
	@RequestMapping(value = "/deleteOneCategory/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryDTO> deleteOneCategory(@PathVariable("id") Integer id) {
		CategoryDTO deleteCategory = categoryService.findCategoryById(id);
		if (deleteCategory == null) {
			System.out.println("Category not found !");
			return new ResponseEntity<CategoryDTO>(HttpStatus.NO_CONTENT);
		}
		categoryService.deleteCategoryById(deleteCategory);
		return new ResponseEntity<CategoryDTO>(deleteCategory, HttpStatus.OK);
	}

	/**
	 * This method is used to search one category by its name
	 * 
	 * @return Category object
	 */
	@RequestMapping(value = "/searchCategory/{categoryName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable("categoryName") String category) {
		CategoryDTO categoryObject = categoryService.findCategoryByName(category);
		if (categoryObject == null) {
			System.out.println("Category Not found !!");
			return new ResponseEntity<CategoryDTO>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<CategoryDTO>(categoryObject, HttpStatus.OK);
	}

}
