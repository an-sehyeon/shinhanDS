package com.shinhan.controller2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.EmpService;

/**
 * Servlet implementation class EmpListServlet
 */
@WebServlet("/emp/emplist.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트가 요청한 업무로직 수행
		EmpService empService = new EmpService();
		// 데이터 저장
		request.setAttribute("emplist", empService.selectAll());
		
		// 2. JSP(View담당)에게 위임, 응답은 JSP가 한다.
		request.getRequestDispatcher("empAll.jsp")
			.forward(request, response);
	}


}
