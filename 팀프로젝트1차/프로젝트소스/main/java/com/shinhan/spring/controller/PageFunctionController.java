package com.shinhan.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageFunctionController {
	
	@GetMapping("/info.do")
	public String f1() {
		return "drawfuture/PageFunction.jsp";
	}

}
