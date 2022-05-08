package com.company.MyToshika;

import java.util.ArrayList;
import java.util.List;

class Sample {

	private int id;
	private String name;
	private String course;
	private String country;
	private int age;
	private String lastname;



	public Sample(int id, String name, String course, String country, int age, String lastname) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.country = country;
		this.age = age;
		this.lastname = lastname;
	}




	public Sample() {
		super();
		// TODO Auto-generated constructor stub
	}




	public int getId() {
		return id;
	}

//	public List<Integer> getById() {
//		List<Integer> li=new ArrayList<Integer>();
//		for (int i: id) {
//			li.add(i);
//		}
//		return li;
//	}



	public String getName() {
		return name;
	}



	public String getCourse() {
		return course;
	}



	public String getCountry() {
		return country;
	}



	public int getAge() {
		return age;
	}



	public String getLastname() {
		return lastname;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setCourse(String course) {
		this.course = course;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public static void main(String[] args) {

	}

}

class Example {
	public static void main(String[] args) {

		List<Sample> s1=new ArrayList<Sample>();
		s1.add(new Sample(1,"Ankit","core java","india",24,"giri"));
		s1.add(new Sample(2,"vivek","sports","india",21,"giri"));
		s1.add(new Sample(3,"Aman","core java","india",14,"giri"));
		s1.add(new Sample(4,"Aayush","sports","india",24,"giri"));
		s1.add(new Sample(5,"Arman","core java","india",4,"giri"));

////		Map<Integer,String> idWithName=new HashMap<Integer,String>();
////		for (Sample sample : s1) {
////			idWithName.put(sample.getId(), sample.getName());
////		}
//		System.out.println(idWithName);
//
//		Map<String,String> Name=new HashMap<String,String>();
//		for (Sample sample : s1) {
//			Name.put(sample.getName(), sample.getLastname());
//		}
//		System.out.println(Name);

//		Map<Integer,Object> id=new HashMap<Integer,Object>();
//		for(Sample s:s1) {
//			int i=1;
//			if(i==s.getId()) {
//				List<String> l1=new LinkedList<>();
//				l1.add(s.getName());
//				l1.add(s.getCountry());
//				id.put(s.getId(),l1);
//			}
//		}
//		System.out.println(id);
//
//		Map<Integer, List<Sample>> postsPerType = s1.stream()
//				  .collect(groupingBy(put::get));

//
//
	}
}
