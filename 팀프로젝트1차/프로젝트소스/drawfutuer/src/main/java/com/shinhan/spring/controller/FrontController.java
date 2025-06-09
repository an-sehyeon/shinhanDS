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
			name = "������";
		} else if (ip.equals("192.168.0.190")) {
			name = "õ����";
		} else if (ip.equals("192.168.0.240")) {
			name = "������";
		} else if (ip.equals("192.168.0.196")) {
			name = "������";
		} else if (ip.equals("192.168.0.83")) {
			name = "���ΰ�";
		} else {
			name = "����ħ����";
		}
		
		log.info("======���� ������ : " + name);
		log.info("======���� ������ ip : " + ip);
		
		request.setAttribute("name", name);
		return "drawfuture/MainPage";
	}
}
