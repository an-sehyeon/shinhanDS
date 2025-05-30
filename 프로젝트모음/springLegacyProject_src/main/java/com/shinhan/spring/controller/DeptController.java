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
		
		System.out.println("이 요청을 보낸 클라이언트의 ip주소 : " + ip);
		System.out.println("이 요청을 보낸 클라이언트의 요청주소 : " + uri);
		
		EmpDTO emp = EmpDTO.builder()
				.first_name("주인장")
				.build();
		session.setAttribute("loginEmp", emp);
		
		// // redirect시 받은 정보를 얻기
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
	
	// post일때 request.getParameter("")하기 전에
	// request.setCharacterEncoding("utf-8") --> spring
	@PostMapping(value = "/deptupdate.do", produces = "text/plain;charset=utf-8")
	public String update(DeptDTO dept,  RedirectAttributes redirectAttr) {
		int result = deptService.updateDept(dept);
		
		
		// redirect는 요청이 전달되지 않음
				redirectAttr.addFlashAttribute("resultMessage", result>0?"수정성공(Flash)" : "수정실패(Flash)");
		// redirect는 요청이 전달되지 않음
		return "redirect:deptlist.do";
	}
	
	@GetMapping(value = "/deptdelete.do", produces = "text/plain;charset=utf-8")
	public String delete(int deptid, RedirectAttributes redirectAttr) {
		int result = deptService.deleteDept(deptid);
		redirectAttr.addFlashAttribute("resultMessage", result>0?"삭제성공(Flash)" : "삭제실패(Flash)");
		
		return "redirect:deptlist.do";
	}
	
	
	// 같은 이름의 변수의 값이 여러개(배열)받아서 처리
	@PostMapping(value = "/deptdelete.do", produces = "text/plain;charset=utf-8")
	public String delete(@RequestParam("del") int[] deptArr) {
		
		int result = 0;
		for(int deptid:deptArr) {
			result += deptService.deleteDept(deptid);
		}
		
		return "redirect:deptlist.do"; 		// 재요청
		
		
	}
	
}
