package com.company.MyToshika.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MyToshikaResponse {

	private int id;
	private String firstName;
	private String lastName;
	private String position;
	private double salary;
	private LocalDate createDate;
	private int age;
	
	
	
}
