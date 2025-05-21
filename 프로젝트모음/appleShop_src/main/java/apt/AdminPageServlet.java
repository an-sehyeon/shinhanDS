package apt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application_office.OfficeDTO;
import application_office.OfficeService;

/**
 * Servlet implementation class AdminPageServlet
 */
@WebServlet("/office/search")
public class AdminPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword = request.getParameter("columnName");
		String value = request.getParameter("inputValue");
		
		if(keyword == "bno" || keyword == "housing_area") {
			Integer.parseInt(value);
		}
		System.out.println("keyword : " + keyword + "value : " + value);
		
		OfficeService officeService = new OfficeService();
        List<OfficeDTO> list = officeService.selectDetail(keyword, value);
        
        request.setAttribute("userinfolist", list);
        request.getRequestDispatcher("/office/userSearchResult.jsp")
        	.forward(request, response);
		
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}
