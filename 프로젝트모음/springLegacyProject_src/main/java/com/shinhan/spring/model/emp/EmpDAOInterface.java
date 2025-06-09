package com.shinhan.spring.model.emp;

import java.util.List;


public interface EmpDAOInterface {

	// Stored Procedure를 실행하기 (직원번호를 받아서 이메일과 급여를 return)
	public EmpDTO execure_sp(int empid);
	// 업데이트
	public int empUpdate(EmpDTO emp);
	// 입력
	public int empInsert(EmpDTO emp);
	// 삭제
	public int empDeleteById(int empid) ;
	// deptArr(다중 조회),job, salary, hire_date로 조회
	public List<EmpDTO> selectByCondition(Integer[] arr, String jobid, int salary, String hdate);

	public List<EmpDTO> selectByCondition(Integer[] arr, String jobid, int salary, String hdate, String date_check);
	
	// job, dept으로 직원조회
	public List<EmpDTO> selectByJobAndDept(String job, int dept);
	// job으로 직원조회
	public List<EmpDTO> selectByJob(String job);	
	// 부서의 직원조회
	public List<EmpDTO> selectByDept(int deptid);
	// 직원번호로 직원의 정보를 상세보기
	public EmpDTO selectById(int empid);
	// 모든 직원 조회
	public List<EmpDTO> selectAll(); 
}
