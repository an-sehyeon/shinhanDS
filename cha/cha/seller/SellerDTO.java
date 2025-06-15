package com.shinhan.spring.cha.seller;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SellerDTO {
	private int seller_id;
	private int user_id;
	private LocalDate opening_date;
	private String account;
	private String account_bank;
	private String profile_info;

}
