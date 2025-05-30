package com.shinhan.spring.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shinhan.spring.model.DeptDTO;
import com.shinhan.spring.model.EmpDTO;
import com.shinhan.spring.model.EmpService;
import com.shinhan.spring.model.JobDTO;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@GetMapping("/empAll.do")
	public void selectAll(Model model) {
		model.addAttribute("emplist",empService.selectAll());
	}
	
	@GetMapping("empdetail.do")
	public void detail(int empid, Model model) {
		model.addAttribute("emp",empService.selectById(empid));
		
	}
	
	@PostMapping(value="/deptupdate.do", produces = "text/plain;charset=utf-8")
	public String update(EmpDTO emp, RedirectAttributes redirect) {
		int result = empService.empUpdate(emp);
		redirect.addFlashAttribute("resultMessage", result>0?"수정성공(Flash)" : "수정실패(Flash)");
		return "redirect:empAll.do";
	}
	

}
