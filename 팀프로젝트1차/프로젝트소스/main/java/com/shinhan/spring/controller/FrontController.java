package com.shinhan.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {

	@GetMapping("mainpage.do")
	public String m_page() {
		return "drawfuture/MainPage";
	}
}
