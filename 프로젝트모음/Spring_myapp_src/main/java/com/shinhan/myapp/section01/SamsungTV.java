package com.shinhan.myapp.section01;

public class SamsungTV implements TVInterface{
	
	
	public SamsungTV(String model) {
		System.out.println(model + "삼성TV생성");
	}
	
	
	public void trunOn() {
		System.out.println(this.getClass().getSimpleName() + "전원을 켠다");
	}
	public void trunOff() {
		System.out.println(this.getClass().getSimpleName() + "전원을 끈다");
	}
	@Override
	public void tvOn() {
		System.out.println("❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️");
		trunOn();
	}
	@Override
	public void tvOff() {
		System.out.println("❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️");
		 trunOff();
		
	}

}
