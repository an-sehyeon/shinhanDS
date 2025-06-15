package com.shinhan.spring.cha.u_category;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class U_categoryDAOMybatis  implements U_categoryDAOInterface{
	
	@Autowired
	SqlSession sqlSession;
	
	 String namespace = "com.chacha.u_category.";

}
