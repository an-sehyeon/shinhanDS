package com.shinhan.spring.model.dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import lombok.extern.java.Log;

//서비스 :비지니스 로직을 수행한다. DB에 가는 업무는 DAO를 호출한다. 
@Log
@Component("dept")		// @Componet + 서비스역할
public class DeptService {
	
	@Autowired		//타입이 같으면 injection, 같은 타입이 여러개있으면 이름으로 injection
	@Qualifier("deptDAOMybatis")			// 같은이름의 bean을 injection한다.
	DeptDAOInterface deptDAO;

	public List<DeptDTO> selectAll() {
		List<DeptDTO> deptlist = deptDAO.selectAll();
		log.info("[롬복]DeptService에서 로그출력:" + deptlist.size() + "건");
		// System.out.println("DeptService에서 로그출력:" + deptlist.size() + "건");
		return deptlist;
	}

	// 2.Select(Read)..상세보기
	public DeptDTO selectById(int deptid) {
		DeptDTO dept = deptDAO.selectById(deptid);
		log.info("DeptService에서 로그출력:" + dept.toString());
		return dept;
	}

	// 3.Inert
	public int insertDept(DeptDTO dept) {	
		int result = deptDAO.insertDept(dept);
		log.info("DeptService에서 로그출력:" + result + "건 insert");
		return result;
	}

	// 4.Update
	public int updateDept(DeptDTO dept) {
		int result = deptDAO.updateDept(dept);
		log.info("DeptService에서 로그출력:" + result + "건 update");
		return result;
	}

	// 5.Delete
	public int deleteDept(int deptid) {
		int result = deptDAO.deleteDept(deptid);
		log.info("DeptService에서 로그출력:" + result + "건 delete");
		return result;
	}
}

