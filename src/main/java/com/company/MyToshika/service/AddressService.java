package com.company.MyToshika.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.MyToshika.dto.AddressDto;
import com.company.MyToshika.entity.AddressEntity;
import com.company.MyToshika.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public AddressDto setAddress(AddressDto addressDto) {
		AddressEntity addressEntity = modelMapper.map(addressDto, AddressEntity.class);
		addressRepository.save(addressEntity);
		return addressDto;
	}

}
