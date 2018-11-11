package com.warren.bootstrap.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/4 17:03
 */
@Aspect
@Slf4j
public class Audience {

	@Pointcut("execution(* com.warren.bootstrap.aop.Performance.preform(..))")
	public void performance() {
	}

	@Pointcut("execution(* com.warren.bootstrap.aop.Performance.eat(..))")
	public void eat(){

	}

	/**
	 * 表演之前
	 */
	@Before("execution(* com.warren.bootstrap.aop.Performance.preform(..))")
	public void silenceCellPhones() {
		log.info("Silencing cell phones");
	}

	/**
	 * 表演之前
	 */
	@Before("execution(* com.warren.bootstrap.aop.Performance.preform(..))")
	public void taskSeats() {
		log.info("Taking seats");
	}

	/**
	 * 表演之后
	 */
	@AfterReturning("execution(* com.warren.bootstrap.aop.Performance.preform(..))")
	public void applause() {
		log.info("CLAP CLAP CLAP");
	}

	/**
	 * 表演失败之后
	 */
	@AfterThrowing("execution(* com.warren.bootstrap.aop.Performance.preform(..))")
	public void demandRefund() {
		log.info("Demanding a refund");
	}

	/**
	 * 环绕通知
	 * @param joinPoint
	 */
	@Around("eat()")
	public void watchPerformance(ProceedingJoinPoint joinPoint){
		try {
			log.info("Silencing cell phones");
			log.info("Taking seats");
			//执行方法
			joinPoint.proceed();
			log.info("CLAP CLAP CLAP");
		} catch (Throwable throwable) {
			log.info("Demanding a refund");
		}
	}
}
