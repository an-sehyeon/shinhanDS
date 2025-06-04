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

import com.shinhan.spring.model.emp.EmpDTO;
import com.shinhan.spring.model.emp.EmpService;

import lombok.extern.slf4j.Slf4j;


@RestController		// Spring5�������� ���� = @Controller + @ResponseBody
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
		return result>0?"delete����":"delete����";
	}
	
	
	@PutMapping(value = "/empupdate.do", 
			produces ="text/plain;charset=utf-8", 
			consumes =MediaType.APPLICATION_JSON_VALUE)
	public String f6(@RequestBody EmpDTO emp) {
		log.info(emp.toString());
		int result = empService.empUpdate(emp);
		return result>0?"update����":"update����";
	}
	
	
	@PostMapping(value = "/empinsert.do", 
			produces ="text/plain;charset=utf-8", 
			consumes =MediaType.APPLICATION_JSON_VALUE)
	public String f5(@RequestBody EmpDTO emp) {
		log.info(emp.toString());
		int result = empService.empInsert(emp);
		return result>0?"insert����":"insert����";
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
	
	
	@GetMapping(value="/empdetail.do/{empid}", produces ="application/json" )
	public EmpDTO f2(@PathVariable("empid") int empid) {
		return empService.selectById(empid);
	}

	@GetMapping(value="/emp.do", produces = "text/plain;charset=utf-8")
	public String f1() {
		return "����API����";
	}
}
