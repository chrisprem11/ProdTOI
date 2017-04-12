package com.prodTOI.urs.service;

import java.util.List;

import com.prodTOI.urs.DTO.AttributeDTO;
import com.prodTOI.urs.model.Attribute;

public interface AttributeService {

	public void saveAttribute(Attribute attribute);

	public AttributeDTO createAttribute(AttributeDTO attributeDTO);

	public List<AttributeDTO> fetchAllAttributes();

	public AttributeDTO updateOneAttribute(AttributeDTO attributeDTO);

	public AttributeDTO findAttributeById(Integer id);

	public void deleteOneAttribute(AttributeDTO attribute);
}
