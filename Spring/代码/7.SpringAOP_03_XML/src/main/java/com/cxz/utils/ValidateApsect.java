package com.cxz.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class ValidateApsect {

	public static void logStart(JoinPoint joinPoint) {
		System.out.println("[ValidateApsect-前置]【" + joinPoint.getSignature().getName() + "】方法开始执行，其参数为：【"
				+ Arrays.asList(joinPoint.getArgs()) + "】");
	}

	public static void logReturn(JoinPoint joinPoint, Object result) {
		System.out.println(
				"[ValidateApsect-返回]【" + joinPoint.getSignature().getName() + "】方法执行完成，其返回结果是：【" + result + "】");
	}

	public static void logEnd(JoinPoint joinPoint) {
		System.out.println("[ValidateApsect-结束]【" + joinPoint.getSignature().getName() + "】方法结束了");
	}

	public static void logException(JoinPoint joinPoint, Exception ex) {
		System.out.println("[ValidateApsect-异常]【" + joinPoint.getSignature().getName() + "】方法执行异常，异常原因：" + ex);
	}

}
