package com.shinhan.myapp.aop.dept;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;



@Component
@Aspect		// advice(보조업무) + pointcut(target의 지점)
public class StopWatchAdvice{

	@Pointcut("execution(* com.shinhan.myapp.aop.dept.DeptService.select*(..))")
	public void targetMethod1() {};
	
	
	@Around("targetMethod1()")		// 주업무 전후로 수행되는 보조 업무임
	public Object invoke(ProceedingJoinPoint jp) throws Throwable {
		
		// 주 관심사 가기 전 
		System.out.println("[메서드 호출전의 StopWatchAdvice]" + jp.getSignature().getName() + " !!!!!!!!!");
		StopWatch watch = new StopWatch("수행시간");
		watch.start();
		
		// 주 관심사 가기
		Object obj = jp.proceed();
		if (obj instanceof List<?>) {
			List<?> list = (List<?>) obj;
			for (Object item : list) {
				System.out.println(item);
			}
		} else {
			System.out.println(obj);
		}
		
		// 주 관심사 다녀온 후 
		watch.stop();
		System.out.println("[메서드 호출후의 StopWatchAdvice]" + jp.getSignature().getName() + " #######");
		System.out.println("=============수행하는데 걸린시간 : " + watch.getTotalTimeSeconds()+" 초=============");
		
		return obj;
	}

}
