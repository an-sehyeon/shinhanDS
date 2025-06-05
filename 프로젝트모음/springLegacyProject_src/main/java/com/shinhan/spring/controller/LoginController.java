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
			session.invalidate();		// �������� ���� ����
			return "redirect:login.do";
		}
		
		@PostMapping(value = "/login.do", produces = "text/plain;charset=utf-8")
		public @ResponseBody String f_postLogin(String userid, String pswd, HttpSession session) {
			int id = Integer.parseInt(userid);
			EmpDTO emp = empService.selectById(id);
			String message = "";
			session.setAttribute("loginEmp", emp);
			
			if(emp == null) {
				message = "�������� �ʴ� ������Դϴ�.";
			}else if(emp.getEmail().equals(pswd)) {
				message = emp.getFirst_name() + " " + emp.getLast_name() + "�� ȯ���մϴ�."; 
			}else {
				message = "��й�ȣ �����Դϴ�.";
			}
			
			return message;
		}
		
		
}
