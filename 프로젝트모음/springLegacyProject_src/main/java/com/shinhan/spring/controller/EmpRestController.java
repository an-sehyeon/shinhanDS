package com.shinhan.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shinhan.spring.model.dept.DeptService;
import com.shinhan.spring.model.emp.EmpDTO;
import com.shinhan.spring.model.emp.EmpRequestDTO;
import com.shinhan.spring.model.emp.EmpService;
import com.shinhan.spring.model.job.JobService;

import lombok.extern.slf4j.Slf4j;


@RestController		// Spring5버전부터 지원 = @Controller + @ResponseBody
@RequestMapping("/emp/api")
@Slf4j
public class EmpRestController {
	
	@Autowired
	EmpService empService;
	
	
	@DeleteMapping(value = "/empdelete.do/{empid}", 
			produces ="text/plain;charset=utf-8")
	public String f7(@PathVariable("empid") int empid) {
		log.info("empid : " + empid);
		int result = empService.empDeleteById(empid);
		return result>0?"delete성공":"delete실패";
	}
	
	
	@PutMapping(value = "/empupdate.do", 
			produces ="text/plain;charset=utf-8", 
			consumes =MediaType.APPLICATION_JSON_VALUE)
	public String f6(@RequestBody EmpDTO emp) {
		log.info(emp.toString());
		int result = empService.empUpdate(emp);
		return result>0?"update성공":"update실패";
	}
	
	
	@PostMapping(value = "/empinsert.do", 
			produces ="text/plain;charset=utf-8", 
			consumes =MediaType.APPLICATION_JSON_VALUE)
	public String f5(@RequestBody EmpDTO emp) {
		log.info(emp.toString());
		int result = empService.empInsert(emp);
		return result>0?"insert성공":"insert실패";
	}
	
	@GetMapping(value="/emplist-map.do", produces = "application/json")
	public Map<Integer,EmpDTO> f4() {
		
		Map<Integer, EmpDTO> mapData = new HashMap<>();
		empService.selectAll().forEach(emp->mapData.put(emp.getEmployee_id(), emp));
		
		return mapData;
	}
	
	@GetMapping(value="/emplist.do", produces = "application/json")
	public List<EmpDTO> f3() {
		return empService.selectAll();
	}
	
	@Autowired
	DeptService deptService;
	@Autowired
	JobService jobService;
	@GetMapping(value="/empdetail.do/{empid}", produces ="application/json" )
	public Map<String, Object> f2(@PathVariable("empid") int empid) {
		Map<String, Object> mapData = new HashMap<>();
		mapData.put("emp", empService.selectById(empid));
		mapData.put("deptlist", deptService.selectAll());
		mapData.put("joblist", jobService.getAllJobs());
		
		return mapData;
	}

	@GetMapping(value="/emp.do", produces = "text/plain;charset=utf-8")
	public String f1() {
		return "직원API연습";
	}
}
