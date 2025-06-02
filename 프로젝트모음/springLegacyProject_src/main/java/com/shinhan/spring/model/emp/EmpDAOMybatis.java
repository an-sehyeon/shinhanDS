package com.shinhan.spring.model.emp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("empMybatis")
public class EmpDAOMybatis implements EmpDAOInterface{
	
	@Autowired
	SqlSession sqlSession;
	String namespace="com.firstzone.emp.";

	@Override
	public EmpDTO execure_sp(int empid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int empUpdate(EmpDTO emp) {
		int result = sqlSession.update(namespace + "update", emp);
		log.info(result + "건 update됨");
		return result;
	}

	@Override
	public int empInsert(EmpDTO emp) {
		int result = sqlSession.insert(namespace + "insert", emp);
		log.info(result + "건 입력됨");
		return result;
	}

	@Override
	public int empDeleteById(int empid) {
		int result = sqlSession.delete(namespace + "delete", empid);
		log.info(result + "건 삭제됨");
		return result;
	}

	@Override
	public List<EmpDTO> selectByCondition(Integer[] arr, String jobid, int salary, String hdate) {
		EmpRequestDTO dto = EmpRequestDTO.builder()
				.deptid(arr)
				.jobid(jobid)
				.salary(salary)
				.hire_date(hdate)
				.build();
		List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectByCondition", dto);
		log.info(emplist.size() + "건 조회");
		return emplist;
	}

	@Override
	public List<EmpDTO> selectByJobAndDept(String job, int dept) {
		Map<String , Object> mapData = new HashMap<>();
		mapData.put("jobid", job);
		mapData.put("deptid", dept);
		List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectByJobAndDept", job);
		log.info(emplist.size() + "건 조회");
		return emplist;
	}
	
	@Override
	public List<EmpDTO> selectByJob(String job) {
		List<EmpDTO> emp = sqlSession.selectList(namespace + "selectByJob", job);
		log.info(emp.size() + "건 조회");
		return emp;
	}

	@Override
	public List<EmpDTO> selectByDept(int deptid) {
		List<EmpDTO> emp = sqlSession.selectList(namespace + "selectByDept", deptid);
		log.info(emp.size() + "건 조회");
		return emp;
	}

	@Override
	public EmpDTO selectById(int empid) {
		EmpDTO emp = sqlSession.selectOne(namespace + "selectById", empid);
		log.info(emp.toString());
		return emp;
	}

	@Override
	public List<EmpDTO> selectAll() {
		List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectAll");
		log.info(emplist.size() + "건 조회됨[mybatis]");
		return emplist;
	}


}
