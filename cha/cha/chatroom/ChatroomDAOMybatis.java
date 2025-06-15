package com.shinhan.spring.cha.chatroom;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ChatroomDAOMybatis  implements ChatroomDAOInterface{
	
	@Autowired
	SqlSession sqlSession;
	
	 String namespace = "com.chacha.chatroom.";

}
