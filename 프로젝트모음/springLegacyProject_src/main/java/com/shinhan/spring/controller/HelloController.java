package com.shinhan.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/first")			// �������� �ּҴ� class level���� �ۼ�
public class HelloController {

	@RequestMapping(value="/hello3.do" )
	public ModelAndView f3() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("myname","�ڻ�����");
		mv.addObject("major","���¿�û�Һ�");
		mv.setViewName("section01/hello");
		
		return mv;
	}
	@RequestMapping(value="/hello2.do",method =RequestMethod.GET )
	public ModelAndView f2() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("myname","�Ȼ�����");
		mv.addObject("major","������");
		mv.setViewName("section01/hello");
		
		return mv;
	}
	@RequestMapping(value="/hello.do",method =RequestMethod.GET )
	public String f1(Model model) {
		model.addAttribute("myname","�ǻ�����");
		model.addAttribute("major","�����˹ٻ�");
		
		return "section/hello";
	}
}
