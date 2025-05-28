package com.shinhan.myapp.section03;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Car {
		
	String model;
	int price;
	
	public Car() {
		System.out.println("Car의 기본생성자");
	}

	public Car(String model, int price) {
		this.model = model;
		this.price = price;
		System.out.println("arg2개 생정자");
	}
	
	
	
}
