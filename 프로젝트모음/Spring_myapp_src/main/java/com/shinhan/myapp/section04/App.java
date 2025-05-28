package com.shinhan.myapp.section04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		f1();

	}

	private static void f1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("section04.xml");
		// default =  Singleton
		// prototype  = 요청시마다 만든다.
		Person p1 = ctx.getBean("person1",Person.class);
		Person p2 = ctx.getBean("person1",Person.class);
		System.out.println(p1);
		System.out.println(p1==p2);		// 주소 같음
		
	}

}
