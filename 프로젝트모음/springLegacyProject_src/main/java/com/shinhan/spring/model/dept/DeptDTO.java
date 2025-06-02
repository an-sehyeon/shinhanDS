package com.shinhan.spring.model.dept;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//DTO(Data Transfer Object)...data���۽� ���Ǵ� ��ü�� Ʋ(template)
//JavaBeans����� default�����ڰ� �־���Ѵ�.
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DeptDTO {
	private Integer department_id;      		// �⺻��(int)�� null�� ������ ����.
	private String department_name;
	private Integer manager_id;       
	private Integer location_id;      
}