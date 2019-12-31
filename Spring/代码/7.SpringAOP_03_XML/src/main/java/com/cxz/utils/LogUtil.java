package com.cxz.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 将这些通知方法，切入到指定方法的指定位置 使用切入点表达式，指定切入点
 * 
 * @author 22527
 *
 */
public class LogUtil {

	/**
	 * 声明的切入点函数，便于切入点表达式的重用
	 */
	public void MyPonitCut() {
	}

	/**
	 * 想切入到calculator的各个方法开始处执行
	 */
	public static void logStart(JoinPoint joinPoint) {
		System.out.println(
				"[LogUtils-前置]【" + joinPoint.getSignature().getName() + "】方法开始执行，其参数为：【" + Arrays.asList(joinPoint.getArgs()) + "】");
	}

	/**
	 * 想切入到calculator的各个方法执行返回处执行 第一步：通知方法中，声明一个Object参数，用于接收目标方法返回值
	 * 第二步：@AfterReturning()中，指定目标返回值填充到哪个变量中
	 */
	public static void logReturn(JoinPoint joinPoint, Object result) {
		System.out.println("[LogUtils-返回]【" + joinPoint.getSignature().getName() + "】方法执行完成，其返回结果是：【" + result + "】");
	}

	/**
	 * 向切入到calculator的各个方法结束处执行
	 */
	public static void logEnd(JoinPoint joinPoint) {
		System.out.println("[LogUtils-后置]【" + joinPoint.getSignature().getName() + "】方法结束了");
	}

	/**
	 * 先切入到calcuator的各个方法异常处执行
	 */
	public static void logException(JoinPoint joinPoint, Exception ex) {
		System.out.println("[LogUtils-异常]【" + joinPoint.getSignature().getName() + "】方法执行异常，异常原因：" + ex);
	}

	/**
	 * 环绕通知--四合一
	 * 
	 * @param pjd
	 * @throws Throwable
	 */
	public Object myAround(ProceedingJoinPoint pjd) throws Throwable {

		Object result = null;
		try {
			System.out.println(
					"[LogUtils]【环绕前置通知，目标方法是：" + pjd.getSignature().getName() + "()，方法参数是：" + Arrays.asList(pjd.getArgs()) + "】"); // 方法开始
			result = pjd.proceed(); // 就是method.invoke()
			System.out.println("[LogUtils]【环绕返回通知，目标方法是：" + pjd.getSignature().getName() + "()，返回值是：" + result + "】"); // 方法返回
		} catch (Exception e) {
			System.out.println("[LogUtils]【环绕异常通知，目标方法是：" + pjd.getSignature().getName() + "()，异常原因是：" + e + "】"); // 方法异常
			throw e; // 将异常抛出，否则@AfterThrowing接收不到异常
		} finally {
			System.out.println("[LogUtils]【环绕后置通知，目标方法是：" + pjd.getSignature().getName() + "() 】"); // 方法开始
		}
		return result;
	}
}
