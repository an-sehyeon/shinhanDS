package com.shinhan.spring.cha.u_category;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class U_categoryDTO {
	 private int chatting_id;
	 private int chatroom_id;
	 private String chatting_text;
	 private LocalDate chatting_date;

}
