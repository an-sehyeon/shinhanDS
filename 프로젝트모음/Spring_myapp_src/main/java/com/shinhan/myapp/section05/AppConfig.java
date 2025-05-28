package com.shinhan.myapp.section05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Configuration			// 이 자바파일이 설정파일임을 의미(XML파일과 같다)
@ComponentScan		
public class AppConfig {

	@Bean	// <bean id ="" class="">
	public Car CarBean() {
		return new Car("ABC모델",1000);
	}
	@Bean
	public Book bookBean() {
		
		return new Book("자바다",10000, "IT");
	}
}
