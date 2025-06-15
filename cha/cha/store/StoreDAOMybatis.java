package com.shinhan.spring.cha.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class StoreDAOMybatis  implements StoreDAOInterface{
	
	@Autowired
	SqlSession sqlSession;
	
	 String namespace = "com.chacha.store.";
	
	@Override
	public List<StoreDTO> selectAll() {
		List<StoreDTO> storelist = sqlSession.selectList(namespace + "selectAll");
		log.info(storelist.size()+ "°Ç Á¶È¸µÊ");
		return storelist;
	}

}
