package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 405 - 허용되지 않는 메소드, 요청한 메서드가 정의되지 않음
 * 404 - 요청한 주소의 Mapping이 없음
 * 서버시작오류? 서버시작시 web.xml실행 @WebServlet
 * 서블릿 default 경로는 contextPath :  / appleShop
 */
@WebServlet("/auth/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// get요청으로 한글이 넘어오면 자동으로 encoding, decoding된다 (깨짐없음)
	// post는 한글이 넘어오면 요청문서의 body로 encoding없이 넘어온다.(깨짐)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String u_id = request.getParameter("userid");
		String u_pwd = request.getParameter("pswd"); 
		String u_remember = request.getParameter("remember"); 
		
		String[] arr = request.getParameterValues("subject");
		
		
		System.out.println("u_id : " + u_id);
		System.out.println("u_pwd : " + u_pwd);
		System.out.println("u_remember : " + u_remember);
		System.out.println("subject배열 = " + Arrays.toString(arr));
		
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String param = names.nextElement();
			if(param.equals("subject")) {
				String[] data = request.getParameterValues("subject");
				System.out.println("data= " + Arrays.toString(data));
			}else {
				String data = request.getParameter(param);
				System.out.println("data=> " + data);
			}
			
		}
		
		// MVC2모델은 Servlet과 JSP가 함께 각자 담당 구현
		// servlet = JAVA + HTML
		// JSP = JAVA + HTML
		
		// 응답문서를 설정하고 만들기
		// 주의 : 설정 후 문서만들기가 되어야한다.
		response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	out.print("<h1>응답문서</h1>");
    	out.print("<h1>path:" + request.getContextPath() + "</h1>");
    	out.print("<h1>접속한 client: " + request.getRemoteAddr() + "</h1>");
		out.print("<h1>Served at : "+ request.getContextPath() +"</h1>");
	}


}
