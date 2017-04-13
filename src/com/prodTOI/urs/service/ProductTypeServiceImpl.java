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
	public void saveProductType(ProductDTO object) {
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
	public ProductDTO deleteOneProductType(Integer id) {
		ProductDTO productTypeDTO = productDao.fetchProductById(id);
		productDao.deleteOneProductType(productTypeDTO);
		return productTypeDTO;
	}

	@Override
	public ProductDTO updateOneProductType(ProductDTO productTypeDTO) {
		ProductDTO productDTO = productDao.fetchProductById(productTypeDTO.getProductTypeId());
		productDao.save(productTypeDTO);
		return productDTO;
	}

	@Override
	public List<ProductDTO> searchProductTypeByName(String productName) {
		return productDao.searchProductTypeByName(productName);
	}

	@Override
	public ProductDTO searchProductTypeById(Integer id) {

		return productDao.fetchProductById(id);
	}

	@Override
	public ProductDTO searchProductTypeDTOById(Integer id) {
		return productDao.searchProductAndAttributeByProductTypeId(id);
	}

	

}
