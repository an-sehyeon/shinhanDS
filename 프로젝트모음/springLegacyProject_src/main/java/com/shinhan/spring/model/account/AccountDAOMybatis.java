package com.shinhan.spring.model.account;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOMybatis {
	@Autowired
	SqlSession sqlSession;
	String namespace = "com.firstzone.account.";

	public void update1() throws DataAccessException {
		sqlSession.update(namespace + "update1");
	}

	public void update2() throws DataAccessException {
		sqlSession.update(namespace + "update2");
	}
}

