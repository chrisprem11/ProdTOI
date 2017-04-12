package com.prodTOI.urs.dao;

import java.util.List;

import com.prodTOI.urs.DTO.CategoryDTO;
import com.prodTOI.urs.model.Category;

public interface CategoryDao {

	List<CategoryDTO> findAllCategories();

	void save(CategoryDTO categoryDTO);
	
	public CategoryDTO findCategoryById(int id);
	
	public CategoryDTO findByCategoryName(String name);

	void updateCategory(CategoryDTO updateCategoryDTO);

	void deleteCategory(CategoryDTO deleteCategoryDTO);

}
