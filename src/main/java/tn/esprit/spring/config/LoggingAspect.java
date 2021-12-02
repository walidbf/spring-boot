package tn.esprit.spring.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
	@Before("execution(* tn.esprit.spring.service.*.*(..))")
	public void logMethodEntry(JoinPoint joinPoint){
		String name = joinPoint.getSignature().getName();
		log.info("in method : "+ name + " : ");
	}
	@AfterReturning("execution(* tn.esprit.spring.service.*.*(..))")
	public void logMethodExit1(JoinPoint joinPoint){
		String name = joinPoint.getSignature().getName();
		log.info("out of method without errors : "+ name + " : ");
	}
	@AfterThrowing("execution(* tn.esprit.spring.service.*.*(..))")
	public void logMethodExit2(JoinPoint joinPoint){
		String name = joinPoint.getSignature().getName();
		log.info("out of method with errors : "+ name + " : ");
	}
	@After("execution(* tn.esprit.spring.service.*.*(..))")
	public void logMethodExit(JoinPoint joinPoint){
		String name = joinPoint.getSignature().getName();
		log.info("out of method ( in all cases ) : "+ name + " : ");
	}

}
