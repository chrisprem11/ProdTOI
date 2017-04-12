package com.prodTOI.urs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prodTOI.urs.DTO.CategoryDTO;
import com.prodTOI.urs.dao.CategoryDao;
import com.prodTOI.urs.model.Category;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<CategoryDTO> findAllCategories() {
		return categoryDao.findAllCategories();
	}

	@Override
	public void saveCategory(CategoryDTO categoryDTO) {
		categoryDao.save(categoryDTO);
	}

	@Override
	public CategoryDTO findCategoryById(int id) {
		return categoryDao.findCategoryById(id);
	}

	@Override
	public void updateCategory(CategoryDTO updateCategoryDTO) {
			categoryDao.updateCategory(updateCategoryDTO);
	}

	@Override
	public void deleteCategoryById(CategoryDTO deleteCategoryDTO) {
		categoryDao.deleteCategory(deleteCategoryDTO);
		
	}

	@Override
	public CategoryDTO findCategoryByName(String name) {
		return categoryDao.findByCategoryName(name);
	}
	

}
