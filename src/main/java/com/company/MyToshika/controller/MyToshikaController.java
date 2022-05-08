package com.company.MyToshika.controller;


import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.company.MyToshika.dto.MyToshikaDto;
import com.company.MyToshika.dto.MyToshikaResponse;
import com.company.MyToshika.entity.MyToshikaEntity;
import com.company.MyToshika.service.MyToshikaService;

@RestController
public class MyToshikaController {
	@Autowired
	private MyToshikaService myToshikaService;

	@PostMapping("/AddAllEmployeeData")
	public ResponseEntity<MyToshikaDto> AddAllEmployeeData(@RequestBody MyToshikaDto myToshikaDto) {
		myToshikaService.AddAllEmployeeData(myToshikaDto);
		return new ResponseEntity<MyToshikaDto>(myToshikaDto, HttpStatus.CREATED);
	}


	@GetMapping("/getEmployeeDetailsById/{id}")
	public MyToshikaResponse getEmployeeDetailsById(@PathVariable(value="id")int id) {
		return myToshikaService.getEmployeeDetailsById(id);
	}

//	@GetMapping("/findByFirstNameAndSalary")
//	public Map<String,List<String>> FindByFirstNameAndSalary(){
//		return myToshikaService.FindByFirstNameAndSalary();
//	}

	@GetMapping("/findByAgeGreatherThan/{age}")
	public List<MyToshikaEntity> findByAgeGreaterThan(@PathVariable(value="age")int age){
			return myToshikaService.findByAgeGreaterThan(age);
    }



	//File Uploading in the folder in a Static Way. it means when our project is shifting to another Computer it is not working
	@PostMapping("/staticUpload_file")
	public String staticUpload_file(@RequestParam("file")MultipartFile file){

		try {
			myToshikaService.staticUploadFile(file);
		}catch(Exception e) {
			e.printStackTrace();
		}


		return "File Upload Sucessfully ";

	}

	@PostMapping("/dynamicUpload_FIle")
	public String dynamicUpload_FIle(@RequestParam("file")MultipartFile file) {
		myToshikaService.dynamicUpload_Directory(file);
		return "File Is Uploaded Successfully";
	}

	//file uploading in the folder in the dynamic way.it is the standard way to save the data and mostly used in the company.
	//if we are shifting our project from one computer to another computer it will be able to save the data

	@DeleteMapping("/delete-file/{filename}")
	public String deleteFile(@PathVariable("filename")Path filename) throws IOException {
		myToshikaService.deleteFile(filename);
		return "Image Deleted Successfully";
	}
}

