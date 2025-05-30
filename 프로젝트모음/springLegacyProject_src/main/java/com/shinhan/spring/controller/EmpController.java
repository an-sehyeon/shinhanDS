package com.shinhan.spring.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shinhan.spring.model.EmpService;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@GetMapping("/empAll.do")
	public void selectAll(Model model) {
	
	}
	
	@GetMapping("empdetail.do")
	public void detail(int empid, Model model) {
		model.addAttribute("emp",empService.selectById(empid));
		
	}

}
