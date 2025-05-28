package com.shinhan.myapp.section02;

public class LgTV implements TVInterface{
	
	public LgTV() {
		System.out.println("LgTV생성자");
	}
	
	public void powerOn() {
		System.out.println(this.getClass().getSimpleName() + "전원을 켠다");
	}
	public void powerOff() {
		System.out.println(this.getClass().getSimpleName() + "전원을 끈다");
	}
	@Override
	public void tvOn() {
		System.out.println("💕💕💕💕💕💕💕💕💕");
		powerOn();
		
	}
	@Override
	public void tvOff() {
		System.out.println("💕💕💕💕💕💕💕💕💕");
		powerOff();
		
	}

}
