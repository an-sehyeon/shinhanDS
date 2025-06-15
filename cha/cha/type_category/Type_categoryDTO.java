package com.shinhan.spring.cha.type_category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Type_categoryDTO {
	private int type_category_id;
	private String type_category_name;

}
