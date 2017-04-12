package com.prodTOI.urs.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.prodTOI.urs.DTO.AttributeDTO;
import com.prodTOI.urs.model.Attribute;

@Repository("attributeDao")
public class AttributeDaoImpl extends AbstractDao<Integer, Attribute> implements AttributeDao {

	@Override
	public void saveAttribute(Attribute attribute) {
		persist(attribute);
	}

	@Override
	public List<AttributeDTO> fetchAllAttributes() {
		Criteria criteria = createEntityCriteria();
		@SuppressWarnings("unchecked")
		List<AttributeDTO> allAttributes = (List<AttributeDTO>) criteria.list();
		return allAttributes;
	}

	@Override
	public AttributeDTO findAttributeById(int attributeId) {
		Attribute attribute = getByKey(attributeId);
		AttributeDTO foundAttribute = new AttributeDTO();
		foundAttribute.setAttributeDisplayName(attribute.getAttributeDisplayName());
		foundAttribute.setAttributeId(attribute.getAttributeId());
		foundAttribute.setAttributes(attribute.getAttributes());
		foundAttribute.setValue(attribute.getValue());
		return foundAttribute;
	}

	@Override
	public AttributeDTO updateAttribute(AttributeDTO updateAttributeDTO) {
		Attribute existingAttribute = getByKey(updateAttributeDTO.getAttributeId());
		existingAttribute.setAttributeDisplayName(updateAttributeDTO.getAttributeDisplayName());
		existingAttribute.setAttributes(updateAttributeDTO.getAttributes());
		existingAttribute.setValue(updateAttributeDTO.getValue());
		update(existingAttribute);
		AttributeDTO attributeDaoDTO = new AttributeDTO();
		attributeDaoDTO.setAttributeId(existingAttribute.getAttributeId());
		attributeDaoDTO.setAttributeDisplayName(existingAttribute.getAttributeDisplayName());
		attributeDaoDTO.setAttributes(existingAttribute.getAttributes());
		attributeDaoDTO.setValue(existingAttribute.getValue());
		return attributeDaoDTO;
	}

	@Override
	public void delelteOneAttribute(AttributeDTO attributeDTO) {
		Attribute attribute = getByKey(attributeDTO.getAttributeId());
		delete(attribute);
	}

	@Override
	public AttributeDTO saveNewAttribute(AttributeDTO attributeDTO) {
		Attribute attribute = new Attribute();
		attribute.setAttributes(attributeDTO.getAttributes());
		attribute.setValue(attributeDTO.getValue());
		attribute.setAttributeDisplayName(attributeDTO.getAttributeDisplayName());
		persist(attribute);
		AttributeDTO savedAttributeDTO = new AttributeDTO();
		savedAttributeDTO.setAttributeId(attribute.getAttributeId());
		savedAttributeDTO.setAttributeDisplayName(attribute.getAttributeDisplayName());
		savedAttributeDTO.setValue(attribute.getValue());
		savedAttributeDTO.setAttributes(attribute.getAttributes());
		return savedAttributeDTO;
	}

}
