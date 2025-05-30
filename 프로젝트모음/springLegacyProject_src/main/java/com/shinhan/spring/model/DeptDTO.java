package com.shinhan.spring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//DTO(Data Transfer Object)...data?��?��?�� ?��?��?��?�� 객체?�� ??(template)
//JavaBeans기술?? default?��?��?���? ?��?��?��?��?��.
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DeptDTO {
	private int department_id;    
	private String department_name;  
	private int manager_id;       
	private int location_id;      
}