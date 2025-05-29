package com.shinhan.myapp.section06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
	
	@Autowired
	Car car2;
	
	Car getCarInfo() {
		return car2; 
	}
}
