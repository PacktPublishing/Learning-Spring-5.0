package com.packt.ch04.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.packt.ch03.beans.Book;

@Aspect
public class MyLoggingAspect {

	Logger logger=Logger.getLogger(getClass());
	
	@Pointcut(value="execution(* com.packt.ch03.dao.BookDAO.addBook(com.packt.ch03.beans.Book))")
	public void selectAdd(){}
	
	@Pointcut(value="execution(* com.packt.ch03.dao.BookDAO.*(..))")
	public void selectAll(){}

	// old configuration
	/*
	@Before("execution(* com.packt.ch03.dao.BookDAO.addBook(com.packt.ch03.beans.Book))")
	public void beforeAdvise(JoinPoint joinPoint) {
		logger.info("method will be invoked :-"+joinPoint.getSignature());
	}
	*/
	@Before(value="selectAdd()")
	public void beforeAdvise(JoinPoint joinPoint) {
		logger.info("method will be invoked :-"+joinPoint.getSignature());
	}

	@After("selectAll()")
	public void afterAdvise(JoinPoint joinPoint) {
		logger.info("executed successfully :-"+joinPoint.getSignature());
	}

	@AfterThrowing(pointcut="execution(* com.packt.ch03.dao.BookDAO.addBook(com.packt.ch03.beans.Book))", throwing="exception")
	public void throwingAdvise(JoinPoint joinPoint, Exception exception) {
		logger.error(joinPoint.getSignature()+" got and exception" + "\t" + exception.toString());

	}

	@Around("selectAdd()")
	public int aroundAdvise(ProceedingJoinPoint joinPoint) {
		long start_time=System.currentTimeMillis();
		logger.info("around advise before "+joinPoint.getSignature() 
				+" B.L.method getting invoked");
		Integer o=null;
		
		try {
			o=(Integer)joinPoint.proceed();
			logger.info("number of rows affected:-"+o);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		logger.info("around advise after "+joinPoint.getSignature()+
				" B.L.method getting invoked");
		long end_time=System.currentTimeMillis();
		logger.info(joinPoint.getSignature()+" took " + 
		(end_time-start_time)+" to complete");
		
		return o.intValue();
	}

	@AfterReturning(pointcut="selectAll()", returning="val")
	public void returnAdvise(JoinPoint joinPoint, Object val) {
		logger.info(joinPoint.getSignature()+ " returning val:-" + val);

	}

}
