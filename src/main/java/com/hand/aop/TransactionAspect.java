package com.hand.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {
	
	@Pointcut("execution(* com.hand.service.CustomerService.insertSelective(..) )")
	public void pc(){}
	
	@Before("pc()")
	public void func1(){
		System.out.println("Before Insert Customer Data.");
	}
	
	@After("pc()")
	public void func2(){
		System.out.println("After Insert Customer Data.");
	}
}
