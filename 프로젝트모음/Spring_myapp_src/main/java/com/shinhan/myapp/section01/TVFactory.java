package com.shinhan.myapp.section01;

public class TVFactory {
	
	public static TVInterface makeTV(String brand, String model) {
		
		TVInterface tv = null;
		if(brand.equals("삼성")) {
			tv = new SamsungTV(model);
		}else if(brand.equals("엘지")) {
			tv = new LgTV(model);
		}
		return tv;
	}

}
