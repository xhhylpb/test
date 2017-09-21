package com.xhhy.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private Logger log = Logger.getLogger(LoggingAspect.class);
	
	@Pointcut("execution(* com.xhhy.dao.*.*(..))")
	public void expre(){}

	@Before("expre()")
	public void beforeMethod(JoinPoint jp){
		String methodName =  jp.getSignature().getName();
		String className = jp.getTarget().getClass().getName();
		log.warn(className + "类的"+methodName+"方法开始执行...");
	}
	
	@After("expre()")
	public void afterMethod(JoinPoint jp){
		String methodName = jp.getSignature().getName();
		String className = jp.getTarget().getClass().getName();
		log.warn(className + "类的"+methodName+"方法执行完毕...");
	}
	@AfterReturning(value="expre()",returning="result")
	public void afterReturning(JoinPoint jp,Object result){
		String methodName = jp.getSignature().getName();
		String className = jp.getTarget().getClass().getName();
		log.warn(className + "类的"+methodName+"方法没有发生异常...处理结果是"+result);
	}
	
	@AfterThrowing(value="expre()",throwing="e")
	public void afterThrowing(JoinPoint jp,Exception e){
		String methodName = jp.getSignature().getName();
		String className = jp.getTarget().getClass().getName();
		log.warn(className + "类的"+methodName+"方法发生异常,异常种类是"+e.toString());
	}
	
}
