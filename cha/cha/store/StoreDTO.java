package com.shinhan.spring.cha.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class StoreDTO {
	private int store_id;
	private int seller_id;
	private String logo_img;
	private String store_name;
	private String store_detail;
	private String store_url;

}
