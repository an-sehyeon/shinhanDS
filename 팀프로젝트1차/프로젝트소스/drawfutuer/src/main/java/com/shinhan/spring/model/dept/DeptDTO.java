package com.shinhan.spring.model.dept;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//DTO(Data Transfer Object)...data전송시 사용되는 객체의 틀(template)
//JavaBeans기술은 default생성자가 있어야한다.
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DeptDTO {
	private Integer department_id;      		// 기본형(int)은 null을 넣을수 없다.
	private String department_name;
	private Integer manager_id;       
	private Integer location_id;      
}