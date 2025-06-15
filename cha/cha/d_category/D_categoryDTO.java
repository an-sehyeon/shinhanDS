package com.shinhan.spring.cha.d_category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class D_categoryDTO {
	private int d_category_id;
	private int u_category_id;
	private String d_category_name;

}
