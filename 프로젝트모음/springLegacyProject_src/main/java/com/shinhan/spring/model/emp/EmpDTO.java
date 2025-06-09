package com.shinhan.spring.model.emp;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO(Data Transfer Object)
// JavaBeans������� ��밡���ؾ��Ѵ�. (default������, getter/setter)
// Į���� �̸��� Field�� ��ġ�ϴ� ���� ����.
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class EmpDTO {
	private Integer employee_id;       
	private String first_name;  
	private String last_name;    
	private String email;
	private String phone_number; 
	private Date hire_date;            
	private String job_id;       
	private Double salary;        
	private Double commission_pct;  
	private Integer manager_id;        
	private Integer department_id;
	
	
	public EmpDTO(Integer employee_id, String first_name, String last_name) {
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
	} 
	
	

}
