package com.shinhan.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect	//pointcut(지점) + advice(보조업무)
public class LoggingAdvice{
	
	//@Pointcut("execution(* selectAll(..))")
	@Pointcut("within(com.shinhan.spring.model.emp.EmpService)")
	public void tergetMethod() {}		//로직은 없지만 함수형태만 가능

	@Before("targetMethod()")
	public void before2(JoinPoint jp) {
		String  fname = jp.getSignature().getName();
		log.info("================before================" + fname);
	}
	
	@AfterReturning("tergetMethod()")
	public void after2(JoinPoint jp) {
	String  fname = jp.getSignature().getName();
	log.info("================after================" + fname);
	}
	
	@Around("tergetMethod()")
	public Object around2(ProceedingJoinPoint jp) throws Throwable {
		
		// 주 관심사 가기 전 
		log.info("[메서드 호출전의 LoggingAdvice]" + jp.getSignature().getName());
		
		// 주 관심사 가기
		Object obj = jp.proceed();
		log.info("LoggingAdvice주관심사에서 return내용 : " + obj);
		
		// 주 관심사 다녀온 후 
		log.info("[메서드 호출후의 LoggingAdvice]" + jp.getSignature().getName() + "$$$$$$$$$$$$$");
		
		return obj;
	}

}
