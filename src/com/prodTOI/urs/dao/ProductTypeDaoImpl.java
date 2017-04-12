package com.prodTOI.urs.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prodTOI.urs.DTO.CategoryDTO;
import com.prodTOI.urs.DTO.ProductDTO;
import com.prodTOI.urs.model.Category;
import com.prodTOI.urs.model.ProductDetail;
import com.prodTOI.urs.model.ProductType;

@Repository("productTypeDao")
public class ProductTypeDaoImpl extends AbstractDao<Integer, ProductType> implements ProductTypeDao {
	
	@Autowired
	CategoryDao categoryDao;

	@Override
	public void save(ProductDTO object) {
		ProductType productType = getByKey(object.getProductTypeId());
		productType.setProductDisplayName(object.getProductDisplayName());
		productType.setProductImage(object.getProductImage());
		productType.setProductPrice(object.getProductPrice());
		productType.setProductType(object.getProductType());
		
		persist(productType);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDTO> fetchAllProducts() {
		Criteria criteria = createEntityCriteria();
		List<ProductDTO> allProducts = (List<ProductDTO>) criteria.list();
		return allProducts;
	}

	@Override
	public ProductDTO fetchProductById(Integer id) {
		ProductType product = getByKey(id);
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductTypeId(product.getProductTypeId());
		productDTO.setProductType(product.getProductType());
		productDTO.setProductPrice(product.getProductPrice());
		productDTO.setProductImage(product.getProductImage());
		productDTO.setProductDisplayName(product.getProductDisplayName());
		return productDTO;
	}

	@Override
	public void deleteOneProductType(ProductDTO productTypeDTO) {
		ProductType product = getByKey(productTypeDTO.getProductTypeId());
		delete(product);
	}

	@Override
	public List<ProductDTO> searchProductTypeByName(String productName) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.ilike("productDisplayName", productName, MatchMode.ANYWHERE));
		@SuppressWarnings("unchecked")
		List<ProductDTO> matchingProducts = (List<ProductDTO>) criteria.list();
		return matchingProducts;
	}

	@Override
	public ProductDTO saveProductType(CategoryDTO categoryDTO, ProductDTO productDTO, String encodedProductImage) {
		ProductType newProduct =new ProductType();
		Category category = new Category();
		category.setProductCategoryId(categoryDTO.getProductCategoryId());
		category.setProductCategory(categoryDTO.getProductCategory());
		newProduct.setCategory(category);
		newProduct.setProductType(productDTO.getProductType());
		newProduct.setProductDisplayName(productDTO.getProductDisplayName());
		newProduct.setProductImage(encodedProductImage);
		newProduct.setProductPrice(productDTO.getProductPrice());
		persist(newProduct);
		
		//Return Product DTO Object
		ProductDTO productDaoDTO = new ProductDTO();
		productDaoDTO.setCategoryDTO(categoryDTO);
		productDaoDTO.setProductDisplayName(newProduct.getProductDisplayName());
		productDaoDTO.setProductPrice(newProduct.getProductPrice());
		productDaoDTO.setProductType(newProduct.getProductType());
		productDaoDTO.setProductImage(newProduct.getProductImage());
		productDaoDTO.setProductTypeId(newProduct.getProductTypeId());
		
		return productDaoDTO;
		
	}

	@Override
	public ProductDTO searchProductAndAttributeByProductTypeId(Integer id) {
		ProductType productType = getByKey(id);
		
		return null;
	}

}
