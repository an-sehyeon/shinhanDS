package com.shinhan.myapp.section02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class TVApp {
	public static void main(String[] args) {
		f1();
		//f2();
	}
	
	
	// ApplicationContext이용하기 > 사용하기 전에 미리 로딩, 모바일 환경에서는 유용하지 않음.
	public static void f2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("section02.xml"); 
		
//		TVInterface tv1 = (TVInterface) ctx.getBean("tv1");
//		TVInterface tv2 = (TVInterface) ctx.getBean("tv2");
//		tv1.tvOn();
//		tv1.tvOff();
//		tv2.tvOn();
//		tv1.tvOff();
		
	}
	
	// BeanFactory이용하기 > 모바일 환경에서 효율적(메모리를 적게 사용), 필요시에 load
	public static void f1() {
		Resource resource = new ClassPathResource("section02.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		TVInterface tv1 = (TVInterface) factory.getBean("tv1");
		TVInterface tv2 = (TVInterface) factory.getBean("tv2");
		tv1.tvOn();
		tv1.tvOff();
		tv2.tvOn();
		tv1.tvOff();
		
	}

}
