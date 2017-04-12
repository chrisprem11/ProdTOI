package com.prodTOI.urs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prodTOI.urs.DTO.AttributeDTO;
import com.prodTOI.urs.model.Attribute;
import com.prodTOI.urs.service.AttributeService;

@RestController
public class AttributeController {

	@Autowired
	AttributeService attributeService;

	/**
	 * This method is used to create a new attribute
	 * 
	 * @return Attribute Object
	 */
	@RequestMapping(value = "/createAttribute", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttributeDTO> createAttribute(@RequestBody AttributeDTO attributeDTO) {
		AttributeDTO newAttributeDTO = attributeService.createAttribute(attributeDTO);
		return new ResponseEntity<AttributeDTO>(newAttributeDTO, HttpStatus.OK);
	}

	/**
	 * This method is used to retrieve all the attributes
	 * 
	 * @return Attribute Object
	 */
	@RequestMapping(value = "/getAllAttribute", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AttributeDTO>> getAllAttribute() {
		List<AttributeDTO> allAttributes = attributeService.fetchAllAttributes();
		return new ResponseEntity<List<AttributeDTO>>(allAttributes, HttpStatus.OK);

	}

	/**
	 * This method is used to update one Attribute
	 * 
	 * @return Attribute Object
	 */
	@RequestMapping(value = "/updateOneAttribute", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttributeDTO> updateOneAttribute(@RequestBody AttributeDTO attributeDTO) {
		AttributeDTO updateAttribute = attributeService.updateOneAttribute(attributeDTO);
		if (updateAttribute == null) {
			System.out.println("Attribute Not found !!!");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<AttributeDTO>(updateAttribute, HttpStatus.OK);
	}
	
	/**
	 * This method is used to delete one Attribute
	 * @return Attribute Object
	 */
	@RequestMapping(value="/deleteOneAttribute/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttributeDTO> deleteOneAttribute(@PathVariable("id") Integer id){
		AttributeDTO attributeDTO = attributeService.findAttributeById(id);
		if(attributeDTO == null) {
			System.out.println("Attribute with id -" + id +" is not found.");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		attributeService.deleteOneAttribute(attributeDTO);
		return new ResponseEntity<AttributeDTO>(attributeDTO, HttpStatus.OK);
		
	}
}
