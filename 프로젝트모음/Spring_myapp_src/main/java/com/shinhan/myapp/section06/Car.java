package com.shinhan.myapp.section06;

import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component		// 포함 @Repository  @Service @Controller
public class Car {
		
	String model = "붕붕이";
	int price = 50000;
	
	public Car() {
		System.out.println("Car의 기본생성자");
	}

	public Car(String model, int price) {
		this.model = model;
		this.price = price;
		System.out.println("arg2개 생정자");
	}
	
	
	
}
