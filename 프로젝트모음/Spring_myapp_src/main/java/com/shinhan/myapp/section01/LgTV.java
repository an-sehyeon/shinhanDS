package com.shinhan.myapp.section01;

public class LgTV implements TVInterface{
	
	public LgTV(String model) {
		// TODO Auto-generated constructor stub
	}
	// 
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
