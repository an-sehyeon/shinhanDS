package com.shinhan.spring.cha.store;

import java.util.List;

public interface StoreDAOInterface {
	
	//  1. 모든 스토어 조회
	public List<StoreDTO> selectAll();

}
