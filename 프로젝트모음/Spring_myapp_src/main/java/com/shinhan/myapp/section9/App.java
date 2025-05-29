package com.shinhan.myapp.section9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop9.xml");
		Calculator cal = ctx.getBean("proxyCal2",Calculator.class);
		cal.divide(10, 10);
	}
}
