package com.shinhan.spring.model.dept;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;



@Component
@Aspect		// advice(λ³΄μ‘°?λ¬?) + pointcut(target? μ§?? )
public class StopWatchAdvice{

	@Pointcut("execution(* com.shinhan.myapp.aop.dept.DeptService.select*(..))")
	public void targetMethod1() {};
	
	
	@Around("targetMethod1()")		// μ£Όμλ¬? ? ?λ‘? ???? λ³΄μ‘° ?λ¬΄μ
	public Object invoke(ProceedingJoinPoint jp) throws Throwable {
		
		// μ£? κ΄??¬?¬ κ°?κΈ? ?  
		System.out.println("[λ©μ? ?ΈμΆμ ? StopWatchAdvice]" + jp.getSignature().getName() + " !!!!!!!!!");
		StopWatch watch = new StopWatch("???κ°?");
		watch.start();
		
		// μ£? κ΄??¬?¬ κ°?κΈ?
		Object obj = jp.proceed();
		if (obj instanceof List<?>) {
			List<?> list = (List<?>) obj;
			for (Object item : list) {
				System.out.println(item);
			}
		} else {
			System.out.println(obj);
		}
		
		// μ£? κ΄??¬?¬ ?€???¨ ? 
		watch.stop();
		System.out.println("[λ©μ? ?ΈμΆν? StopWatchAdvice]" + jp.getSignature().getName() + " #######");
		System.out.println("=============?????° κ±Έλ¦°?κ°? : " + watch.getTotalTimeSeconds()+" μ΄?=============");
		
		return obj;
	}

}
