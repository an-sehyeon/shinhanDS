package com.shinhan.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FrontController {

	@GetMapping("mainpage.do")
	public String m_page(HttpServletRequest request, HttpServletResponse response) {
		String ip = request.getRemoteAddr();
		String name = null;
		
		if (ip.equals("192.168.0.156")) {
			name = "이재희";
		} else if (ip.equals("192.168.0.190")) {
			name = "천희찬";
		} else if (ip.equals("192.168.0.240")) {
			name = "최윤정";
		} else if (ip.equals("192.168.0.196")) {
			name = "김지민";
		} else if (ip.equals("192.168.0.83")) {
			name = "차민건";
		} else {
			name = "무단침입자";
		}
		
		log.info("======현재 접속자 : " + name);
		log.info("======현재 접속자 ip : " + ip);
		
		request.setAttribute("name", name);
		return "drawfuture/MainPage";
	}
}
