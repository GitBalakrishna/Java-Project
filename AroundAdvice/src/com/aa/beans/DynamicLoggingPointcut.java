package com.aa.beans;

import java.lang.reflect.Method;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class DynamicLoggingPointcut extends DynamicMethodMatcherPointcut {
	@Override
	public boolean matches(Method method, Class<?> classType, Object[] args) {
		System.out.println("method : " + method.getName());
		if (method.getName().equals("multiply") && classType.isAssignableFrom(Calculator.class)) {
			Integer a = (Integer) args[0];
			Integer b = (Integer) args[1];
			if (a > 100 && b > 100) {
				return true;
			}
		}
		return false;
	}

}
