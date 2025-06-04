package com.shinhan.spring.controller;



import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.shinhan.spring.model.dept.DeptService;
import com.shinhan.spring.model.emp.EmpDTO;
import com.shinhan.spring.model.emp.EmpRequestDTO;
import com.shinhan.spring.model.emp.EmpService;
import com.shinhan.spring.model.job.JobDAO;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired EmpService empService;
	@Autowired DeptService deptService;
	@Autowired JobDAO jobDAO;
	
	
	// @ResponseBody ������ ������ forward(�������� ã��)
	@GetMapping("/getEmpById.do")
	public @ResponseBody String f_empidChk(@RequestParam int empid) {
		EmpDTO emp = empService.selectById(empid);
		return emp==null?"0":"1";
	}
	
	@GetMapping("/emplist.do")
	public String selectAll(Model model, HttpServletRequest request) {
		
		// // redirect�� ���� ������ ���
				Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
				if(flashMap!=null) {
					model.addAttribute("resultMessage",flashMap.get("resultMessage"));
				}
		model.addAttribute("emplist",empService.selectAll());
		model.addAttribute("deptlist",deptService.selectAll());
		model.addAttribute("joblist",jobDAO.getAllJobs());
		return "emp/empAll";
	}
	
	@PostMapping("/selectByCondition.do")
	public String f_condition(@RequestBody EmpRequestDTO data, Model model) {
		
		System.out.println(data);
		
		Integer[] deptArr = data.getDeptid();
		model.addAttribute("emplist",empService.selectByCondition(deptArr, data.getJobid(),  data.getSalary(),  data.getHire_date(), data.getDate_check()));
		// 0. ���κ� : json�ޱ�(����).."{   }"
		// 1. JSON�� Object�� �ٲ۴�. (parse)
		// 2. �ش� data�����Ѵ�.
		// 3. ������ȸ
		// 4. ����� jsp��������forward�Ͽ� HTML�� ���� �� ajaxȣ��� ����.
		
		return "emp/empByCondition";
	}
	
	@GetMapping("empdetail.do")
	public void get_detail( @RequestParam("empid") int empid, Model model) {
		model.addAttribute("emp",empService.selectById(empid));
		model.addAttribute("deptlist",deptService.selectAll());
		model.addAttribute("joblist",jobDAO.getAllJobs());
	}
	
	@PostMapping("empdetail.do")
	public String get_detail( @ModelAttribute EmpDTO emp, RedirectAttributes attr) {
		int result = empService.empUpdate(emp);
		attr.addFlashAttribute("resultMessage",result>0?"update success":"updae fail");
		
		return "redirect:emplist.do";
	}
	
	@GetMapping("/empdelete.do")
	public String delete(int empid,RedirectAttributes attr) {
		int result = empService.empDeleteById(empid);
		attr.addFlashAttribute("resultMessage",result>0?"delete success":"delete fail");
		
		return "redirect:emplist.do";
	}
	
	@GetMapping("empinsert.do")
	public void get_insert(Model model) {
		model.addAttribute("deptlist",deptService.selectAll());
		model.addAttribute("joblist",jobDAO.getAllJobs());
	}
	
	@PostMapping("/empinsert.do")
	public String post_insert( @ModelAttribute EmpDTO emp, RedirectAttributes attr) {
		System.out.println(emp);
		
		int result = empService.empInsert(emp);
		attr.addFlashAttribute("resultMessage",result>0?"insert success":"insert fail");
		return "redirect:emplist.do";
	}
	
	@PostMapping("empAll.do")
	public String insertPost(@ModelAttribute("emp") EmpDTO emp) {
		int result = empService.empInsert(emp);
		return "emp/result";
	}
	

}
