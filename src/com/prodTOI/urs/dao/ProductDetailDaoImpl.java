package com.prodTOI.urs.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.prodTOI.urs.model.ProductDetail;
import com.prodTOI.urs.model.ProductType;

@Repository("productDetailDao")
public class ProductDetailDaoImpl extends AbstractDao<Integer, ProductDetail> implements ProductDetailDao {

	@Override
	public List<ProductDetail> fetchAllProductDetails() {
		Criteria criteria = createEntityCriteria();
		List<ProductDetail> allProductDetails = (List<ProductDetail>) criteria.list();
		return allProductDetails;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDetail> searchProductDetailsByProdcutType(ProductType product) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("productType", product));
		List<ProductDetail> allProductDetails = (List<ProductDetail>) criteria.list();
		return allProductDetails;
	}

}
