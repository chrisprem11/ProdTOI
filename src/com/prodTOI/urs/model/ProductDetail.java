package com.prodTOI.urs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the product_details database table.
 * 
 */
@Entity
@Table(name="product_details")
public class ProductDetail implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to ProductType
	@ManyToOne
	@JoinColumn(name="product_type_id")
	private ProductType productType;

	//bi-directional many-to-one association to Attribute
	@ManyToOne
	@JoinColumn(name="attribute_id")
	private Attribute attribute;

	public ProductDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductType getProductType() {
		return this.productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Attribute getAttribute() {
		return this.attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

}