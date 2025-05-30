package com.shinhan.spring.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.shinhan.spring.model.DeptDTO;
import com.shinhan.spring.model.DeptService;
import com.shinhan.spring.model.EmpDTO;

@Controller
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	DeptService deptService;
	
	
	@GetMapping("/deptlist.do")
	public void selectAll(Model model, HttpServletRequest request, HttpSession session) {
		
		String ip = request.getRemoteAddr();
		String uri = request.getRequestURI();
		
		System.out.println("�� ��û�� ���� Ŭ���̾�Ʈ�� ip�ּ� : " + ip);
		System.out.println("�� ��û�� ���� Ŭ���̾�Ʈ�� ��û�ּ� : " + uri);
		
		EmpDTO emp = EmpDTO.builder()
				.first_name("������")
				.build();
		session.setAttribute("loginEmp", emp);
		
		// // redirect�� ���� ������ ���
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			model.addAttribute("resultMessage",flashMap.get("resultMessage"));
		}
		
		model.addAttribute("deptListData",deptService.selectAll());
	}
	
	
	
	@GetMapping("/deptinsert.do")
	public void insertForm(){
		
	}
	
	@PostMapping("/deptinsert.do")
	public String insertPost(@ModelAttribute("dept") DeptDTO dept) {
		int result = deptService.insertDept(dept);
		return"dept/result";		// forward
	}
	
	@PostMapping("/deptSaveAjax.do")
	public @ResponseBody String deptsaveAjax(@RequestParam("job") String job, DeptDTO dept) {
		
		int result = 0;
		if(job.equals("insert")) {
			result = deptService.insertDept(dept);
		}else {
			result = deptService.updateDept(dept);
		}
		
		return result+"";
	}
	
	@GetMapping(value = "/deptdetail.do")
	public String detail(int deptid, Model model) {
		
		model.addAttribute("dept", deptService.selectById(deptid));
		return "dept/deptdetail";
	}
	
	// post�϶� request.getParameter("")�ϱ� ����
	// request.setCharacterEncoding("utf-8") --> spring
	@PostMapping(value = "/deptupdate.do", produces = "text/plain;charset=utf-8")
	public String update(DeptDTO dept,  RedirectAttributes redirectAttr) {
		int result = deptService.updateDept(dept);
		
		
		// redirect�� ��û�� ���޵��� ����
				redirectAttr.addFlashAttribute("resultMessage", result>0?"��������(Flash)" : "��������(Flash)");
		// redirect�� ��û�� ���޵��� ����
		return "redirect:deptlist.do";
	}
	
	@GetMapping(value = "/deptdelete.do", produces = "text/plain;charset=utf-8")
	public String delete(int deptid, RedirectAttributes redirectAttr) {
		int result = deptService.deleteDept(deptid);
		redirectAttr.addFlashAttribute("resultMessage", result>0?"��������(Flash)" : "��������(Flash)");
		
		return "redirect:deptlist.do";
	}
	
	
	// ���� �̸��� ������ ���� ������(�迭)�޾Ƽ� ó��
	@PostMapping(value = "/deptdelete.do", produces = "text/plain;charset=utf-8")
	public String delete(@RequestParam("del") int[] deptArr) {
		
		int result = 0;
		for(int deptid:deptArr) {
			result += deptService.deleteDept(deptid);
		}
		
		return "redirect:deptlist.do"; 		// ���û
		
		
	}
	
}
