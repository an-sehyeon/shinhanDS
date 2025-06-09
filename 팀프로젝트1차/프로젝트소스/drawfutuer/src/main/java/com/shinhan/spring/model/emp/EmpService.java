package com.shinhan.spring.model.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// Service : business logic 수행
// 1) 이체업무 : 인출하기, 입금하기
// 2) 비밀번호 암호화
@Service
public class EmpService {
	
	@Autowired
	@Qualifier("empMybatis")
	EmpDAOMybatis empDAO;
	
	public EmpDTO execure_sp(int empid) {
		return empDAO.execure_sp(empid);
	}
	
	public int empUpdate(EmpDTO emp) {
		return empDAO.empUpdate(emp);
	}
	
	public int empInsert(EmpDTO emp) {
		return empDAO.empInsert(emp);
	}
	
	public int empDeleteById(int empid) {
		return empDAO.empDeleteById(empid);
	}
	
	public List<EmpDTO> selectByCondition
		(Integer[] deptArr, String jobid, int salary, String hire_date, String date_check) {
		return empDAO.selectByCondition(deptArr,jobid,salary,hire_date, date_check);
	}
	
	public List<EmpDTO> selectByJobAndDept(String job, int dept) {
		return empDAO.selectByJobAndDept(job,dept);
	}
	
	public List<EmpDTO> selectByJob(String job) {
		return empDAO.selectByJob(job);
	}
	
	public List<EmpDTO> selectByDept(int deptid) {
		return empDAO.selectByDept(deptid);
	}
	
	public EmpDTO selectById(int empid) {
		return empDAO.selectById(empid);
	}
	
	public List<EmpDTO> selectAll() {
		
		return empDAO.selectAll();
	}

}
