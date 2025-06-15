package com.shinhan.spring.cha.d_category;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class D_categoryDAOMybatis  implements D_categoryDAOInterface{
	
	@Autowired
	SqlSession sqlSession;
	
	 String namespace = "com.chacha.d_cagegory.";

}
