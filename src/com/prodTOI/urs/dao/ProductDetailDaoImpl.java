package com.prodTOI.urs.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.prodTOI.urs.DTO.ProductDTO;
import com.prodTOI.urs.DTO.ProductDetailDTO;
import com.prodTOI.urs.model.ProductDetail;
import com.prodTOI.urs.model.ProductType;

@Repository("productDetailDao")
public class ProductDetailDaoImpl extends AbstractDao<Integer, ProductDetail> implements ProductDetailDao {

	@Override
	public List<ProductDetailDTO> fetchAllProductDetails() {
		Criteria criteria = createEntityCriteria();
		List<ProductDetailDTO> allProductDetails = (List<ProductDetailDTO>) criteria.list();
		return allProductDetails;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDetailDTO> searchProductDetailsByProdcutType(ProductDTO productDTO) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("productType", productDTO));
		List<ProductDetailDTO> allProductDetails = (List<ProductDetailDTO>) criteria.list();
		return allProductDetails;
	}

}
