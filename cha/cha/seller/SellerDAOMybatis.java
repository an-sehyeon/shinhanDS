package com.shinhan.spring.cha.seller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SellerDAOMybatis  implements SellerDAOInterface{
	
	@Autowired
	SqlSession sqlSession;
	
	 String namespace = "com.chacha.seller.";

}
