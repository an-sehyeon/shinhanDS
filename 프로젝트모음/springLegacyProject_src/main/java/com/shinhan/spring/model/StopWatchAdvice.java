package com.shinhan.spring.model;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;



@Component
@Aspect		// advice(보조?���?) + pointcut(target?�� �??��)
public class StopWatchAdvice{

	@Pointcut("execution(* com.shinhan.myapp.aop.dept.DeptService.select*(..))")
	public void targetMethod1() {};
	
	
	@Around("targetMethod1()")		// 주업�? ?��?���? ?��?��?��?�� 보조 ?��무임
	public Object invoke(ProceedingJoinPoint jp) throws Throwable {
		
		// �? �??��?�� �?�? ?�� 
		System.out.println("[메서?�� ?��출전?�� StopWatchAdvice]" + jp.getSignature().getName() + " !!!!!!!!!");
		StopWatch watch = new StopWatch("?��?��?���?");
		watch.start();
		
		// �? �??��?�� �?�?
		Object obj = jp.proceed();
		if (obj instanceof List<?>) {
			List<?> list = (List<?>) obj;
			for (Object item : list) {
				System.out.println(item);
			}
		} else {
			System.out.println(obj);
		}
		
		// �? �??��?�� ?��???�� ?�� 
		watch.stop();
		System.out.println("[메서?�� ?��출후?�� StopWatchAdvice]" + jp.getSignature().getName() + " #######");
		System.out.println("=============?��?��?��?��?�� 걸린?���? : " + watch.getTotalTimeSeconds()+" �?=============");
		
		return obj;
	}

}
