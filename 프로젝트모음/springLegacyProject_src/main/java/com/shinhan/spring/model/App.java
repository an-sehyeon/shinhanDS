package com.shinhan.spring.model;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class App {
		
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aopdept.xml");
		DeptService service = ctx.getBean("dept",DeptService.class);
		service.selectAll();
		System.out.println("");
		service.selectById(100);
		System.out.println("");
		service.selectById(110);
		System.out.println("");
		service.selectById(120);
		
	
	
		
	}
	
	
	
}
