package com.company.MyToshika.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.company.MyToshika.dto.AddressDto;
import com.company.MyToshika.dto.MyToshikaDto;
import com.company.MyToshika.dto.MyToshikaResponse;
import com.company.MyToshika.entity.AddressEntity;
import com.company.MyToshika.entity.MyToshikaEntity;
import com.company.MyToshika.repository.AddressRepository;
import com.company.MyToshika.repository.MyToshikaRepository;

@Service
public class MyToshikaService {
	@Autowired
	private MyToshikaRepository myToshikaRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AddressRepository addressRepository;
	
	public final String staticUpload_Directory="J:\\training project\\MyToshika.zip_expanded\\MyToshika\\src\\main\\resources\\static\\image";
	public final String dynamicUpload_Directory=new ClassPathResource("static/image/").getFile().getAbsolutePath(); 
	
	public MyToshikaService()throws IOException{}

	
	
public MyToshikaDto AddAllEmployeeData(MyToshikaDto myToshikaDto) {
		LocalDate date = LocalDate.now(); 
		MyToshikaEntity myToshikaEntity = modelMapper.map(myToshikaDto, MyToshikaEntity.class);
		//myToshikaEntity.setCreateDate(LocalDate.now());
		for ( AddressDto address : myToshikaDto.getAddressList()) {
			AddressEntity addressEntity = modelMapper.map(address, AddressEntity.class);
			addressRepository.save(addressEntity);
		}
		
		myToshikaRepository.save(myToshikaEntity);
		return myToshikaDto;
	}

public MyToshikaDto addAddress(AddressEntity address) {
	return null;
	
}

	public MyToshikaResponse getEmployeeDetailsById(int id) {
		Optional<MyToshikaEntity> myToshikaEntityOptional = myToshikaRepository.findById(id);
		MyToshikaEntity myToshikaEntity = myToshikaEntityOptional.get();
//		MyToshikaDto myToshikaDto=new MyToshikaDto();
//		myToshikaDto.setFirstName(myToshikaEntity.getFirstName());
//		myToshikaDto.setLastName(myToshikaEntity.getLastName());
//		myToshikaDto.setPosition(myToshikaEntity.getPosition());
//		myToshikaDto.setSalary(myToshikaEntity.getSalary());
		
		
		return modelMapper.map(myToshikaEntity, MyToshikaResponse.class);
	}

//	public List<MyToshikaEntity> findByFirstNameOrLastName(String firstName) {
//		List<MyToshikaEntity> EmployeeList=myToshikaRepository.findByFirstNameAndSalary(firstName);
//		//MyToshikaEntity myToshikaEntity=new MyToshikaEntity();
//		return  EmployeeList;
//		
//	}

//	public Map<String, List<String>> FindByFirstNameAndSalary() {
//		List<MyToshikaEntity> employeeEntity=myToshikaRepository.findAll();
//		List<String> employeeName=employeeEntity.stream().map(myToshikaEntity -> myToshikaEntity.getFirstName()).collect(Collectors.toList());
//		List<String> employeeposition=employeeEntity.stream().map(myToshikaEntity -> myToshikaEntity.getPosition()).collect(Collectors.toList());
//		Map< String ,List<String>> map=new HashMap<>();
//		map.put("MyToshika All Employee Name", employeeName);
//		map.put("MyToshika All Employee Name Positions", employeeposition);
//		return map;
//	}

	public List<MyToshikaEntity> findByAgeGreaterThan(int age) {
		List<MyToshikaEntity> EmployeeListAgeGeatherThen=myToshikaRepository.findByAgeGreaterThan(age);
		return EmployeeListAgeGeatherThen;
	}
	
	public String staticUploadFile(MultipartFile file) {
		
		try {
			
			Files.copy(file.getInputStream(), Paths.get(staticUpload_Directory+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "File Save Sucessfully";
	}
	
	
	public void dynamicUpload_Directory(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(),Paths.get(dynamicUpload_Directory+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteFile(Path filename) throws IOException {
		Path p1=Paths.get("J:\\training project\\MyToshika.zip_expanded\\MyToshika\\src\\main\\resources\\static\\image\\"+filename);
		Files.delete(p1);
	}



	

	
}
