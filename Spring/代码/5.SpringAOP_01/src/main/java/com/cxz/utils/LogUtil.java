package com.cxz.utils;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LogUtil {

	public static void logStart(Method method, Object... args) {
		System.out.println("【" + method.getName() + "】方法开始执行，使用的参数列表时：【" + Arrays.asList(args) + "】");
	}

	public static void logEnd(Method method, Object result) {
		System.out.println("【" + method.getName() + "】方法执行完成，运算结果是：【" + result + "】");
	}

	public static void logException(Method method, Exception e) {
		System.out.println("【" + method.getName() + "】方法执行异常，异常信息：" + e.getCause());
	}

	public static void LogFinsh(Method method) {
		System.out.println("【" + method.getName() + "】方法执行结束");
	}
}
