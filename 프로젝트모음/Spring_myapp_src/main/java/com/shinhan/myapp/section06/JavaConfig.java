package com.shinhan.myapp.section06;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.shinhan.myapp.section06"})	// (basePackages 현재위치라면 생략가능)
public class JavaConfig {
	
	@Bean("book1")
	public Book getBook1() {
		return new Book("A",100,"IT");
	}
	@Bean("book2")
	public Book getBook2() {
		return new Book("B",2000,"IT");
	}
}
