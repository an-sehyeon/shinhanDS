package com.shinhan.myapp.section03;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {

	String name;
	String phone;
	Car car;
	List<String> majorList;
	List<License> licenceList;
	Map<String, Book> myLibrary;
	Set<String> friendSet;
	Properties myProfile;
	
	public Person(String name, String phone, Car car) {
		System.out.println("Person생성");
		this.name = name;
		this.phone = phone;
		this.car = car;
	}
	
}
