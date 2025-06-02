package com.shinhan.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shinhan.spring.model.dept.DeptService;


// ��û �ּ� ����

@Controller
@RequestMapping("/section02")		// class(type) level���� �ּ� ����
public class SampleController {
	
	@Autowired
	DeptService deptService;		// Spring�� new�ؼ� injection�Ѵ�.
	
	
		@RequestMapping(value = "/sample7.do", params = {"userid=a","userpass", "!email"})
		public @ResponseBody String call() {
			return "hello~~~!!";
		}
		// @ResponseBody : ���乮���� data�� ������.
		// @ResponseBody�� ������ jsp�������� forward�� default�̴�.
		// HTTP ���� 400 - �߸��� ��û
		// ��û�� ������ ��������
	
	
	// �Լ�level���� path����
		@GetMapping({"/sample5.do","/sample6.do"})
		public ModelAndView f5() {		// Model�� jsp�������� ���� Map<Stirng, Object>
			ModelAndView mv = new ModelAndView();
			mv.addObject("subject","css");
			mv.addObject("day","30");
			mv.addObject("dept",deptService.selectById(60));
			mv.addObject("deptlist",deptService.selectAll());
			mv.setViewName("section02/sample1");
			return mv;
		}
		
		
	
	
	// �Լ�level���� path����
		@RequestMapping("/sample4.do")
		public ModelAndView f4() {		// Model�� jsp�������� ���� Map<Stirng, Object>
			ModelAndView mv = new ModelAndView();
			mv.addObject("subject","����");
			mv.addObject("day","30");
			mv.addObject("dept",deptService.selectById(60));
			mv.addObject("deptlist",deptService.selectAll());
			mv.setViewName("section02/sample1");
			return mv;
		}
		
		
	
	// �Լ�level���� path����
	@RequestMapping(value = "/sample3.do",method = RequestMethod.GET)
	public ModelAndView f3() {		// Model�� jsp�������� ���� Map<Stirng, Object>
		ModelAndView mv = new ModelAndView();
		mv.addObject("subject","�ڹ�");
		mv.addObject("day","30");
		mv.addObject("dept",deptService.selectById(60));
		mv.addObject("deptlist",deptService.selectAll());
		mv.setViewName("section02/sample1");
		return mv;
	}
	
	
	// �Լ�level���� path����
	@RequestMapping(value = "/sample2.do",method = RequestMethod.GET)
	public String f2(Model model) {		// Model�� jsp�������� ���� Map<Stirng, Object>
		model.addAttribute("subject","����Ʈ");
		model.addAttribute("day","30");
		model.addAttribute("dept",deptService.selectById(60));
		model.addAttribute("deptlist",deptService.selectAll());
		return "section02/sample1";		// ���λ�(/WEB-INF/views/) + view�̸� + ���̻�(.jsp)
	}
	
	
	// value = "/sample1" �� jsp�̸��� ������ return �ּ� ��������
	@RequestMapping(value = "/sample1.do",method = RequestMethod.GET)
	public void f1(Model model) {		// Model�� jsp�������� ���� Map<Stirng, Object>
		model.addAttribute("subject","�����������ӿ�ũ");
		model.addAttribute("day","30");
		model.addAttribute("dept",deptService.selectById(60));
		model.addAttribute("deptlist",deptService.selectAll());
	}

}
