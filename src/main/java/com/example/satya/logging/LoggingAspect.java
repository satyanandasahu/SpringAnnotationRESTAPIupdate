package com.example.satya.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger logger = LogManager.getLogger();
	
	/**
	 * Declaring after advice
	 * 
	 * @param jointPoint
	 * @throws Throwable
	 */
	@After("execution(* com.example.satya.*.*.*(..))")
	public void afterAdviceForAllMethods(JoinPoint jointPoint) throws Throwable {
		logger.info("\nLoggingAspect.afterAdviceForAllMethods() ============================================================================================ " + jointPoint.getThis().getClass().getName());
	}

	/**
	 * Declaring after advice for all transfer methods whose taking three arguments
	 * of any type of all classes in the package com.doj.aopapp.service
	 * 
	 * @param jointPoint
	 * @throws Throwable
	 */
	@Before("execution(* com.example.satya.*.*.*(..))")
	public void beforeAdviceForMethods(JoinPoint jointPoint) throws Throwable {
		logger.info(
				"\nLoggingAspect.beforeAdviceForAllMethods() ====================================================================================================== " + jointPoint.getThis().getClass().getName() + "\n");
	}

}
