package com.shinhan.myapp.section01;

public class TvUser {

	public static void main(String[] args) {
		
		f1();
		f2();

	}

	private static void f2() {
		//TVInterface tv = new SamsungTV();
		TVInterface tv = TVFactory.makeTV("엘지", null);
		tv.tvOn();
		tv.tvOff();
		
	}

	private static void f1() {
		/*
		 * SamsungTV tv = new SamsungTV(); tv.trunOn(); tv.trunOff();
		 */
		
		LgTV tv = (LgTV)TVFactory.makeTV("엘지", null);
		
		tv.powerOn();
		tv.powerOff();
	}

}
