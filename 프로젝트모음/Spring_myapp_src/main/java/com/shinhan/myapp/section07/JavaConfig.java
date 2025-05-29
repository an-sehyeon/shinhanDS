package com.shinhan.myapp.section07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class JavaConfig {

	@Bean("l1")
	public License getLicense1() {
		return new License();
	}
	@Bean("l2")
	public License getLicense2() {
		return new License("정보처리기사",2024);
	}
}
