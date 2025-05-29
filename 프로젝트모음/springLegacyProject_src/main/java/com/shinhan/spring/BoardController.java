package com.shinhan.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// Controller�� POJO(Plain Old Java Object)�� �����.
// @Controller : FrontController�� DispatcherServlet�� Controller��� �ν��Ѵ�.

@Controller
public class BoardController {
	
	@RequestMapping("/board/list")
	public String  f1() {
		return "NewFile";				// forward
	}

	@RequestMapping("/board/list2")
	public @ResponseBody String  f2() {
		return "NewFile!!!!!!!!!!!!";			// response.getWriter().append("fffffff");
	}
}
