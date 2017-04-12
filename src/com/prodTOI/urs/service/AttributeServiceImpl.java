package com.prodTOI.urs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prodTOI.urs.DTO.AttributeDTO;
import com.prodTOI.urs.dao.AttributeDao;
import com.prodTOI.urs.model.Attribute;

@Service("attributeService")
@Transactional
public class AttributeServiceImpl implements AttributeService {

	@Autowired
	AttributeDao attributeDao;

	@Override
	public void saveAttribute(Attribute attribute) {
		attributeDao.saveAttribute(attribute);

	}

	@Override
	public AttributeDTO createAttribute(AttributeDTO attributeDTO) {
		AttributeDTO newAttribute = attributeDao.saveNewAttribute(attributeDTO);
		return newAttribute;
	}

	@Override
	public List<AttributeDTO> fetchAllAttributes() {
		return attributeDao.fetchAllAttributes();
	}

	@Override
	public AttributeDTO updateOneAttribute(AttributeDTO attributeDTO) {
		AttributeDTO existingAttribute = attributeDao.updateAttribute(attributeDTO);
		return existingAttribute;
	}

	@Override
	public AttributeDTO  findAttributeById(Integer id) {
		  return attributeDao.findAttributeById(id);
	}

	@Override
	public void deleteOneAttribute(AttributeDTO attributeDTO) {
		attributeDao.delelteOneAttribute(attributeDTO);
	}

}
