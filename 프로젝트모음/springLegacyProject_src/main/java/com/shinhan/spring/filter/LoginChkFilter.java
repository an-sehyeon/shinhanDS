package com.shinhan.spring.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * @WebFilter : ���� 3�������� ����. ���������� web.xml�� �̿��ؼ� filter���
 * LoginChkFilter�� .do��� ��û�ÿ��� �����ϵ��� �ϱ�
 */
@WebFilter("*.do")
public class LoginChkFilter implements Filter {

   
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		System.out.println("LoginChkFilter ��û�ּ� Ȯ�� : " + req.getRequestURL());
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void destroy() {
		
		
	}

}
