package com.shinhan.myapp.section05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {


		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		Car c1 = ctx.getBean("CarBean", Car.class);
		System.out.println(c1);
		Book b1 = ctx.getBean("bookBean", Book.class);
		System.out.println(b1);
	}

}
