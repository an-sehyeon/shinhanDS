package com.shinhan.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shinhan.spring.model.dept.DeptDTO;
import com.shinhan.spring.model.dept.DeptService;

@Controller
@RequestMapping("/first")			// 공통적인 주소는 class level에서 작성
public class HelloController {
	
	@Autowired
	DeptService deptService;

	@RequestMapping(value="/hello3.do" )
	@GetMapping("/hello3.do")
	public ModelAndView f3() {
		
		DeptDTO dept = deptService.selectById(60);
		System.out.println(dept);
		ModelAndView mv = new ModelAndView();
		mv.addObject("myname","박새로이");
		mv.addObject("major","이태원보안관");
		mv.setViewName("section01/hello");
		
		return mv;
	}
	@RequestMapping(value="/hello2.do",method =RequestMethod.GET )
	public ModelAndView f2() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("myname","안새로이");
		mv.addObject("major","족쟁이");
		mv.setViewName("section01/hello");
		
		return mv;
	}
	@RequestMapping(value="/hello.do",method =RequestMethod.GET )
	public String f1(Model model) {
		model.addAttribute("myname","권새로이");
		model.addAttribute("major","술집알바생");
		
		return "section/hello";
	}
}
