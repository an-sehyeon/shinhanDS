package com.shinhan.spring.model;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;



@Component
@Aspect		// advice(ë³´ì¡°?—…ë¬?) + pointcut(target?˜ ì§?? )
public class StopWatchAdvice{

	@Pointcut("execution(* com.shinhan.myapp.aop.dept.DeptService.select*(..))")
	public void targetMethod1() {};
	
	
	@Around("targetMethod1()")		// ì£¼ì—…ë¬? ? „?›„ë¡? ?ˆ˜?–‰?˜?Š” ë³´ì¡° ?—…ë¬´ì„
	public Object invoke(ProceedingJoinPoint jp) throws Throwable {
		
		// ì£? ê´??‹¬?‚¬ ê°?ê¸? ? „ 
		System.out.println("[ë©”ì„œ?“œ ?˜¸ì¶œì „?˜ StopWatchAdvice]" + jp.getSignature().getName() + " !!!!!!!!!");
		StopWatch watch = new StopWatch("?ˆ˜?–‰?‹œê°?");
		watch.start();
		
		// ì£? ê´??‹¬?‚¬ ê°?ê¸?
		Object obj = jp.proceed();
		if (obj instanceof List<?>) {
			List<?> list = (List<?>) obj;
			for (Object item : list) {
				System.out.println(item);
			}
		} else {
			System.out.println(obj);
		}
		
		// ì£? ê´??‹¬?‚¬ ?‹¤???˜¨ ?›„ 
		watch.stop();
		System.out.println("[ë©”ì„œ?“œ ?˜¸ì¶œí›„?˜ StopWatchAdvice]" + jp.getSignature().getName() + " #######");
		System.out.println("=============?ˆ˜?–‰?•˜?Š”?° ê±¸ë¦°?‹œê°? : " + watch.getTotalTimeSeconds()+" ì´?=============");
		
		return obj;
	}

}
