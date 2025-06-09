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
@Aspect	//pointcut(����) + advice(��������)
public class LoggingAdvice{
	
	//@Pointcut("execution(* selectAll(..))")
	@Pointcut("within(com.shinhan.spring.model.emp.EmpService)")
	public void tergetMethod() {}		//������ ������ �Լ����¸� ����

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
		
		// �� ���ɻ� ���� �� 
		log.info("[�޼��� ȣ������ LoggingAdvice]" + jp.getSignature().getName());
		
		// �� ���ɻ� ����
		Object obj = jp.proceed();
		log.info("LoggingAdvice�ְ��ɻ翡�� return���� : " + obj);
		
		// �� ���ɻ� �ٳ�� �� 
		log.info("[�޼��� ȣ������ LoggingAdvice]" + jp.getSignature().getName() + "$$$$$$$$$$$$$");
		
		return obj;
	}

}
