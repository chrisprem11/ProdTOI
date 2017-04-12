package com.prodTOI.urs.service;

import java.util.List;

import com.prodTOI.urs.DTO.CategoryDTO;
import com.prodTOI.urs.model.Category;

public interface CategoryService {

	List<CategoryDTO> findAllCategories();
	
	public void saveCategory(CategoryDTO categoryDTO);
	
	public CategoryDTO findCategoryById(int id);
	
	public CategoryDTO findCategoryByName(String name);

	void updateCategory(CategoryDTO updateCategoryDTO);

	void deleteCategoryById(CategoryDTO deleteCategoryDTO);

	
	
}
