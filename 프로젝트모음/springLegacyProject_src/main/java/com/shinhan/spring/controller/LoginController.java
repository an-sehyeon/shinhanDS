package com.shinhan.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinhan.spring.model.emp.EmpDTO;
import com.shinhan.spring.model.emp.EmpService;

@Controller
@RequestMapping("/auth")
public class LoginController {
	
		@Autowired
		EmpService empService;

		@GetMapping("/login.do")
		public void f_getLogin() {
			
		}
		
		
		@GetMapping("/logout.do")
		public String f_logout(HttpSession session) {
			session.invalidate();		// 세션정보 전부 삭제
			return "redirect:login.do";
		}
		
		@PostMapping(value = "/login.do", produces = "text/plain;charset=utf-8")
		public @ResponseBody String f_postLogin(String userid, String pswd, HttpSession session) {
			int id = Integer.parseInt(userid);
			EmpDTO emp = empService.selectById(id);
			String message = "";
			session.setAttribute("loginEmp", emp);
			
			if(emp == null) {
				message = "존재하지 않는 사용자입니다.";
			}else if(emp.getEmail().equals(pswd)) {
				message = emp.getFirst_name() + " " + emp.getLast_name() + "님 환영합니다."; 
			}else {
				message = "비밀번호 오류입니다.";
			}
			
			return message;
		}
		
		
}
