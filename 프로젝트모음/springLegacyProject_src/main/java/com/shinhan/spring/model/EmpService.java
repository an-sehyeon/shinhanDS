package com.shinhan.spring.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service : business logic ����
// 1) ��ü���� : �����ϱ�, �Ա��ϱ�
// 2) ��й�ȣ ��ȣȭ
@Service
public class EmpService {
	
	@Autowired
	EmpDAO empDAO;
	
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
	
	public List<EmpDTO> selectByCondition(Integer[] deptArr,String jobid,int salary,String hire_date) {
		return empDAO.selectByCondition(deptArr,jobid,salary,hire_date);
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
