package com.shinhan.spring.cha.chatroom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ChatroomDTO {
	private int chatroom_id;
	private int store_id;
	private int user_id;
}
