package com.cxz.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ValidateApsect {

	@Before("com.cxz.utils.PointCuts.ImplAllPointCut()")
	public static void logStart(JoinPoint joinPoint) {
		System.out.println(
				"[ValidateApsect-前置]【" + joinPoint.getSignature().getName() + "】方法开始执行，其参数为：【" + Arrays.asList(joinPoint.getArgs()) + "】");
	}

	@AfterReturning(value = "com.cxz.utils.PointCuts.ImplAllPointCut()", returning = "result")
	public static void logReturn(JoinPoint joinPoint, Object result) {
		System.out.println("[ValidateApsect-返回]【" + joinPoint.getSignature().getName() + "】方法执行完成，其返回结果是：【" + result + "】");
	}

	@After("com.cxz.utils.PointCuts.ImplAllPointCut()")
	public static void logEnd(JoinPoint joinPoint) {
		System.out.println("[ValidateApsect-结束]【" + joinPoint.getSignature().getName() + "】方法结束了");
	}

	@AfterThrowing(value = "com.cxz.utils.PointCuts.ImplAllPointCut()", throwing = "ex")
	public static void logException(JoinPoint joinPoint, Exception ex) {
		System.out.println("[ValidateApsect-异常]【" + joinPoint.getSignature().getName() + "】方法执行异常，异常原因：" + ex);
	}

}
