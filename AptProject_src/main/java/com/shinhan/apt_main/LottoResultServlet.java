package com.shinhan.apt_main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application_office.model.OfficeDTO;
import application_office.model.OfficeService;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/lottoresult.do")
public class LottoResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		OfficeService officeService = new OfficeService();
		OfficeDTO office = officeService.luckyDetail(bno);
		
		request.setAttribute("office", office);
		
		if(office.getArea_rank() <= 30) {
			request.getRequestDispatcher("/lottoresult/winningpage.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/lottoresult/losingpage.jsp").forward(request, response);
		}
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
