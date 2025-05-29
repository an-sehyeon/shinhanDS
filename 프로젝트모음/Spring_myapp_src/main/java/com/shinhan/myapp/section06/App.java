package com.shinhan.myapp.section06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		//f1();
		//f2();
		//f3();
		f4();
	}

	private static void f4() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("section06-1.xml");
		CarService service = ctx.getBean("carService", CarService.class);
		System.out.println(service.getCarInfo());
		
	}

	private static void f3() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("section06-1.xml");
		Car c1 = ctx.getBean("car", Car.class);
		System.out.println(c1);
	}

	private static void f2() {
		// Java설정파일 이용하기
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		Book b1 = ctx.getBean("book1",Book.class);
		Book b2 = ctx.getBean("book2",Book.class);
		System.out.println(b1);
		System.out.println(b2);
		
	}

	public static void f1() {
		//XML파일설정 가져오기
		ApplicationContext ctx = new ClassPathXmlApplicationContext("section06.xml");
		
		Book b1 = ctx.getBean("book1",Book.class);
		Book b2 = ctx.getBean("book2",Book.class);
		System.out.println(b1);
		System.out.println(b2);
		
	}
}
