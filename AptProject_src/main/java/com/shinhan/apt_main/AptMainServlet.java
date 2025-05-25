package com.shinhan.apt_main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AptMainServlet
 */
@WebServlet("/mainpage")
public class AptMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그인페이지 접속");
		request.getRequestDispatcher("auth/login.jsp").forward(request, response);
		
	}

}
