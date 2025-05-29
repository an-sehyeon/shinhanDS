package com.shinhan.myapp.section07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		//f1();
		//f2();
		f3();
	}

	private static void f3() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("section07-1.xml");
		//License li = ctx.getBean("myLi",License.class);
		LicenseManagement li = ctx.getBean("licenseManagement",LicenseManagement.class);
		System.out.println(li.call());
	}

	private static void f2() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		License a = ctx.getBean("l2",License.class);
		License b = ctx.getBean("l1",License.class);
		System.out.println(b);
		System.out.println(a);
	}

	private static void f1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("section07.xml");
		License li1 = ctx.getBean("l1",License.class);
		License li2 = ctx.getBean("l2",License.class);
		System.out.println(li1);
		System.out.println(li2);
	}
}
