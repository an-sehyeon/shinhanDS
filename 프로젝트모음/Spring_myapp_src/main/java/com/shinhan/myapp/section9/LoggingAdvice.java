package com.shinhan.myapp.section9;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect	//pointcut(지점) + advice(보조업무)
public class LoggingAdvice{
	
	@Pointcut("execution(* add(int,int)) || execution(* add(int))")
	public void tergetMethod() {}		//로직은 없지만 함수형태만 가능

	@Before("tergetMethod()")
	public void before2(JoinPoint jp) {
		String  fname = jp.getSignature().getName();
		System.out.println("================before================" + fname);
	}
	
	@AfterReturning("tergetMethod()")
	public void after2(JoinPoint jp) {
	String  fname = jp.getSignature().getName();
	System.out.println("================after================" + fname);
	}
	
	@Around("tergetMethod()")
	public Object around2(ProceedingJoinPoint jp) throws Throwable {
		
		// 주 관심사 가기 전 
		System.out.println("[메서드 호출전의 LoggingAdvice]" + jp.getSignature().getName());
		
		// 주 관심사 가기
		Object obj = jp.proceed();
		System.out.println("LoggingAdvice주관심사에서 return내용 : " + obj);
		
		// 주 관심사 다녀온 후 
		System.out.println("[메서드 호출후의 LoggingAdvice]" + jp.getSignature().getName() + "$$$$$$$$$$$$$");
		
		return obj;
	}

}
