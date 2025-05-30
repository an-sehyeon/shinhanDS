package com.shinhan.spring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//DTO(Data Transfer Object)...data? ?‘? ?¬?©?? κ°μ²΄? ??(template)
//JavaBeansκΈ°μ ?? default??±?κ°? ??΄?Ό??€.
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