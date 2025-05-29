package com.shinhan.myapp.section8;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		// 주 관심사 가기 전 
		System.out.println("[메서드 호출전의 LoggingAdvice]" + invocation.getMethod().getName());
		
		// 주 관심사 가기
		Object obj = invocation.proceed();
		System.out.println("LoggingAdvice주관심사에서 return내용 : " + obj);
		
		// 주 관심사 다녀온 후 
		System.out.println("[메서드 호출후의 LoggingAdvice]" + invocation.getMethod().getName() + "$$$$$$$$$$$$$");
		
		return obj;
	}

}
