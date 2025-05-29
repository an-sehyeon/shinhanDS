package com.shinhan.myapp.section8;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class StopWatchAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		// 주 관심사 가기 전 
		System.out.println("[메서드 호출전의 StopWatchAdvice]" + invocation.getMethod().getName());
		StopWatch watch = new StopWatch("수행시간");
		watch.start();
		
		// 주 관심사 가기
		Object obj = invocation.proceed();
		System.out.println("StopWatchAdvice주관심사에서 return내용 : " + obj);
		
		// 주 관심사 다녀온 후 
		watch.stop();
		System.out.println("[메서드 호출후의 StopWatchAdvice]" + invocation.getMethod().getName() + "#######");
		System.out.println("수행하는데 걸린시간 : " + watch.getTotalTimeMillis());
		
		return obj;
	}

}
