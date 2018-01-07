package com.market.project.ws.order.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	@Before("execution(* com.markit.project.ws.order.service.OrderServiceImpl.create(..))")
	public void logBefore(JoinPoint joinpoint)
	{
		System.out.println("Before calling");
	}
	
	
	@After("execution(* com.markit.project.ws.order.service.OrderServiceImpl.create(..))")
	public void logAfter(JoinPoint joinpoint)
	{
		System.out.println("After calling");
	}
}
