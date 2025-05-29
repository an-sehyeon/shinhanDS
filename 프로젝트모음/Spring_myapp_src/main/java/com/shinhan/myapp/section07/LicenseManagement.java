package com.shinhan.myapp.section07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LicenseManagement {

	@Autowired
	@Qualifier("myLi")
	License aa;
	
	License call() {
		aa.setTitle("CC");
		aa.setYear(2025);

		return aa;
	}
}
