package com.shinhan.myapp.section8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop8.xml");
		Calculator cal = ctx.getBean("proxyCal",Calculator.class);
		cal.add(20,30);
		//cal.divide(10,20);
	}
}
