package com.shinhan.myapp.section07;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Component("myLi")
public class License {
	String title = "aa";
	int year = 2000;
	
	public License() {
		System.out.println("License 기본생성자");
	}
	
	public  License(String title, int year) {
		System.out.println("License arg2 생성자");
	}
}
