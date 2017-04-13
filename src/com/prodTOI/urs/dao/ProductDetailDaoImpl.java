package com.prodTOI.urs.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prodTOI.urs.DTO.ProductDTO;
import com.prodTOI.urs.DTO.ProductDetailDTO;
import com.prodTOI.urs.model.ProductDetail;
import com.prodTOI.urs.model.ProductType;

@Repository("productDetailDao")
public class ProductDetailDaoImpl extends AbstractDao<Integer, ProductDetail> implements ProductDetailDao {

	@Autowired
	ProductTypeDao productTypeDao;
	
	@SuppressWarnings("unchecked")
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
		ProductType productType = productTypeDao.getProductTypeFromProductDTO(productDTO);
		criteria.add(Restrictions.eq("productType", productType));
		List<ProductDetail> allProductDetails = (List<ProductDetail>) criteria.list();
		List<ProductDetailDTO> productDetailDTOList = new ArrayList<ProductDetailDTO>();
		for(int i=0;i<allProductDetails.size();i++){
			ProductDetailDTO productDetailDTO = new ProductDetailDTO();
			productDetailDTO.setProductType(allProductDetails.get(i).getProductType());
			productDetailDTO.setAttribute(allProductDetails.get(i).getAttribute());
			productDetailDTOList.add(productDetailDTO);
		}
		return  productDetailDTOList;
	}

}
