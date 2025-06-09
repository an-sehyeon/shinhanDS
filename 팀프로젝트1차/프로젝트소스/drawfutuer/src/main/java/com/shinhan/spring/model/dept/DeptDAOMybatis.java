package com.shinhan.spring.model.dept;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DeptDAOMybatis implements DeptDAOInterface{
	
	@Autowired
	SqlSession sqlSession;
	
	 String namespace = "com.firstzone.dept.";

	@Override
	public List<DeptDTO> selectAll() {
		List<DeptDTO> deptlist = sqlSession.selectList(namespace + "selectAll");
		log.info(deptlist.size() + "건 조회됨");
		return deptlist;
	}

	@Override
	public DeptDTO selectById(int deptid) {
		DeptDTO dept = sqlSession.selectOne(namespace + "selectById",deptid) ;
		log.info(dept.toString());
		return dept;
	}

	@Override
	public int insertDept(DeptDTO dept) {
		int result = sqlSession.insert(namespace + "insert",dept) ;
		log.info(result + "입력(Mybatis)");
		return result;
	}

	@Override
	public int updateDept(DeptDTO dept) {
		int result = sqlSession.update(namespace + "update",dept) ;
		log.info(result + "건 수정(Mybatis)");
		return result;
	}

	@Override
	public int deleteDept(int deptid) {
		int result = sqlSession.delete(namespace + "delete",deptid) ;
		log.info(result + "건 tkrwp(Mybatis)");
		return result;
	}
	
	

}
