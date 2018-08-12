/**
 * 
 */
package com.sample.app;

import javax.swing.Spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author	Joseph
 * @since	1.0.0
 *
 * An @Aspect @Component for logging
 * @see Spring Core AOP {@link} https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#aop
 * 
 */
@Slf4j
@Aspect
@Component
public class LoggingAspect {

	@Before("execution(public * com.sample..*.on*(..))")
	public void logEntry(JoinPoint point) {
        log.info(point.getSignature().getDeclaringTypeName() + " and " + point.getSignature().getName() + " called...");
    }
	
	@After("execution(public * com.sample..*.on*(..))")
	public void logExit(JoinPoint point) {
		log.info(point.getSignature().getDeclaringTypeName() + " and " + point.getSignature().getName() + " completed...");
    }
}