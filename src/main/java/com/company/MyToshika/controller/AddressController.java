package com.company.MyToshika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.MyToshika.dto.AddressDto;
import com.company.MyToshika.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping("/setAddress")
	public ResponseEntity<AddressDto> setAddress(@RequestBody AddressDto addressDto) {
		addressService.setAddress(addressDto);
		return new ResponseEntity<AddressDto>(addressDto ,HttpStatus.CREATED); 
	}
}
