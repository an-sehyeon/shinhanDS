package com.shinhan.spring.model.dept;

import java.util.List;







public interface DeptDAOInterface {
	//1.Select(Read)..모두보기 
	public List<DeptDTO> selectAll() ;
	//2.Select(Read)..상세보기
	public DeptDTO selectById(int deptid) ;
	//3.Inert
	public int insertDept(DeptDTO dept) ;
	//4.Update
	public int updateDept(DeptDTO dept) ;
	//5.Delete
	public int deleteDept(int deptid) ;
	
}

