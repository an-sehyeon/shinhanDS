package com.shinhan.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
@Aspect		// advice(��������) + pointcut(target�� ����)
public class StopWatchAdvice{

	//@Pointcut("execution(* selectAll(..))")
	public void targetMethod1() {};

	@Pointcut("within(com.shinhan.spring.model.emp.EmpService)")
	public void targetMethod2() {};
	
	
	@Around("targetMethod2()")		// �־��� ���ķ� ����Ǵ� ���� ������
	public Object invoke(ProceedingJoinPoint jp) throws Throwable {
		
		// �� ���ɻ� ���� �� 
		log.info("[�޼��� ȣ������ StopWatchAdvice]" + jp.getSignature().getName());
		StopWatch watch = new StopWatch("����ð�");
		watch.start();
		
		// �� ���ɻ� ����
		Object obj = jp.proceed();
		log.info("StopWatchAdvice�ְ��ɻ翡�� return���� : " + obj);
		
		// �� ���ɻ� �ٳ�� �� 
		watch.stop();
		log.info("[�޼��� ȣ������ StopWatchAdvice]" + jp.getSignature().getName() + "#######");
		log.info("�����ϴµ� �ɸ��ð� : " + watch.getTotalTimeMillis());
		
		return obj;
	}

}
