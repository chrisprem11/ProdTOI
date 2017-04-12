package com.prodTOI.urs.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prodTOI.urs.DTO.CategoryDTO;
import com.prodTOI.urs.DTO.ProductDTO;
import com.prodTOI.urs.dao.ProductTypeDao;
import com.prodTOI.urs.model.Category;
import com.prodTOI.urs.model.ProductType;

@Service("productTypeService")
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeDao productDao;

	@Override
	public void saveProductType(ProductType object) {
		productDao.save(object);
	}

	@Override
	public List<ProductDTO> fetchAllProducts() {
		return productDao.fetchAllProducts();
	}

	@Override
	public ProductDTO createNewProduct(CategoryDTO categoryDTO, ProductDTO productDTO) {
		String encodedProductImage = "";
		try {
			Path path = Paths.get("E:\\iphone.jpg");
			byte[] data = Files.readAllBytes(path);
			encodedProductImage = Base64.getEncoder().encodeToString(data);
			System.out.println("Product Image- " + encodedProductImage);

		} catch (IOException e) {
			e.printStackTrace();
		}
		ProductDTO newProduct = productDao.saveProductType(categoryDTO, productDTO, encodedProductImage);
		return newProduct;
	}

	@Override
	public ProductType deleteOneProductType(Integer id) {
		ProductType productType = productDao.fetchProductById(id);
		productDao.deleteOneProductType(productType);
		return productType;
	}

	@Override
	public ProductType updateOneProductType(ProductType productType) {
		ProductType product = productDao.fetchProductById(productType.getProductTypeId());
		product.setProductType(productType.getProductType());
		productDao.save(product);
		return product;
	}

	@Override
	public List<ProductType> searchProductTypeByName(String productName) {
		return productDao.searchProductTypeByName(productName);
	}

	@Override
	public ProductType searchProductTypeById(Integer id) {

		return productDao.fetchProductById(id);
	}

}
