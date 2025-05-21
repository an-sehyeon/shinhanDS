package com.shinhan.controller2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.EmpService;

/**
 * Servlet implementation class EmpDeleteServlet
 */
@WebServlet("/emp/empdelete.do")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empid = request.getParameter("empid");
		if(empid!=null && empid!="") {
			EmpService empService = new EmpService();
			empService.empDeleteById(Integer.parseInt(empid));
		}
		response.sendRedirect("emplist.do");
	}
}
