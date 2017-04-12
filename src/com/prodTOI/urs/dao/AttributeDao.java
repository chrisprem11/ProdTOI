package com.prodTOI.urs.dao;

import java.util.List;

import com.prodTOI.urs.DTO.AttributeDTO;
import com.prodTOI.urs.model.Attribute;

public interface AttributeDao {

	public void saveAttribute(Attribute attribute);

	public List<AttributeDTO> fetchAllAttributes();

	public AttributeDTO findAttributeById(int attributeId);

	public AttributeDTO updateAttribute(AttributeDTO existingAttribute);

	public void delelteOneAttribute(AttributeDTO attribute);

	public AttributeDTO saveNewAttribute(AttributeDTO attributeDTO);
}
