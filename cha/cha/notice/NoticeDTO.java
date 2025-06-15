package com.shinhan.spring.cha.notice;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class NoticeDTO {
	private int notice_id;
	private int store_id;
	private char notice_check;
	private String notice_title;
	private String notice_text;
	private LocalDate notice_date;

}
