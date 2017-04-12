package com.prodTOI.urs.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.prodTOI.urs.DTO.CategoryDTO;
import com.prodTOI.urs.model.Category;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao {

	@Override
	public List<CategoryDTO> findAllCategories() {
		Criteria criteria = createEntityCriteria();
		List<CategoryDTO> categories = (List<CategoryDTO>) criteria.list();
		return categories;
	}

	@Override
	public void save(CategoryDTO categoryDTO) {
		Category newCategory = new Category();
		newCategory.setProductCategory(categoryDTO.getProductCategory());
		persist(newCategory);
	}

	@Override
	public CategoryDTO findCategoryById(int id) {
		Category category = getByKey(id);
		CategoryDTO foundCategory = new CategoryDTO();
		foundCategory.setProductCategoryId(category.getProductCategoryId());
		foundCategory.setProductCategory(category.getProductCategory());
		return foundCategory;
	}

	@Override
	public void updateCategory(CategoryDTO updateCategoryDTO) {
		Category changedCategory = new Category();
		changedCategory.setProductCategory(updateCategoryDTO.getProductCategory());
		changedCategory.setProductCategoryId(updateCategoryDTO.getProductCategoryId());
		update(changedCategory);
	}

	@Override
	public void deleteCategory(CategoryDTO deleteCategoryDTO) {
		Category deleteCategory = getByKey(deleteCategoryDTO.getProductCategoryId());
		delete(deleteCategory);
	}

	@Override
	public CategoryDTO findByCategoryName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("productCategory", name));
		Category category = (Category) criteria.uniqueResult();
		CategoryDTO existingCategoryDTO= new CategoryDTO(); 
		existingCategoryDTO.setProductCategory(category.getProductCategory());
		existingCategoryDTO.setProductCategoryId(category.getProductCategoryId());
		return existingCategoryDTO;
	}

}
