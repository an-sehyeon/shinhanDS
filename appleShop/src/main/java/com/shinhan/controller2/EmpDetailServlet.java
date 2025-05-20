package com.shinhan.controller2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDTO;
import dept.DeptService;
import emp.EmpDTO;
import emp.EmpService;
import job.JobDAO;
import job.JobDTO;

/**
 * Servlet implementation class EmpDetailList
 */
@WebServlet("/emp/empdetail.do")
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int emp_id = Integer.parseInt(request.getParameter("empid"));

		EmpService eService = new EmpService();
		EmpDTO emp = eService.selectById(emp_id);

		DeptService dService = new DeptService();
		List<DeptDTO> deptlist = dService.selectAll();

		JobDAO jobDAO = new JobDAO();
		List<JobDTO> joblist = jobDAO.getAllJobs();

		request.setAttribute("emp", emp);
		request.setAttribute("deptlist", deptlist);
		request.setAttribute("joblist", joblist);

		request.getRequestDispatcher("empdetail.jsp").forward(request, response);
	}

}
