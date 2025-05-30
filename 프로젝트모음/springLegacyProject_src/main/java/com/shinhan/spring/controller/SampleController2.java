package com.shinhan.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinhan.spring.model.DeptDTO;
import com.shinhan.spring.model.DeptService;

// parameter ����

@Controller
@RequestMapping("/section02")
public class SampleController2 {
	
	@Autowired
	DeptService deptService;

	
	
	// �μ���ȸ
	@GetMapping("/deptlist.do")
	public String f7(Model model) {
		model.addAttribute("deptListData",deptService.selectAll());
		return "dept/deptlist";
	}
	
	// @RequestParam�� �������� �ʴ´�.
	@PostMapping("/deptinsert.do")
	public @ResponseBody String f6(@RequestParam Map<String, Object> dataMap) {
						
		System.out.println("job : " + dataMap.get("job"));
		
		System.out.println(dataMap); 
		for(String key:dataMap.keySet()) {
			System.out.println(key + " ==> " + dataMap.get(key));
		}
		
		return "parameter OK";
	}

	
	
	@PostMapping("/deptinsert3.do")
	public @ResponseBody String f5(DeptDTO dept, String job) {
						
		System.out.println("job : " + job);
		System.out.println("Java Beans: " + dept);
		deptService.insertDept(dept);
		
		DeptDTO inserDept = deptService.selectById(dept.getDepartment_id());
		System.out.println(inserDept);
		
		return "parameter OK";
	}
	
	
	@PostMapping("/deptinsert2.do")
	public @ResponseBody String f4(String job,
							int department_id,
							String department_name,
							int manager_id,
							int location_id) {
		System.out.println(job);
		System.out.println(department_id);
		System.out.println(department_name);
		System.out.println(manager_id);
		System.out.println(location_id);
		
		return "parameter OK";
	}
	
	@GetMapping("/deptinsert.do")
	public String f3() {
		return "dept/deptinsert";
	}
	
	@GetMapping("/inputForm.do")
	public void f2() {
		// WEB-INF/views/section02/inputForm.jsp
	}

	@GetMapping("/friday.do")
	public String f1( @RequestParam String userid, 
						  @RequestParam("pwd") String password, 
						  String email) {
		System.out.println("����ڹ�ȣ : " + userid);
		System.out.println("��й�ȣ : " + password);
		System.out.println("�̸��� : " + email);
		
		return "section02/paramtest";
	}
	
}
