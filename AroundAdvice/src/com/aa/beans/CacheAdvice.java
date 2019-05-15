package com.aa.beans;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.aa.helper.Cache;

public class CacheAdvice implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		String methodName = null;
		Object[] args = null;
		Cache cache = null;
		String key = null;
		Object ret = null;

		methodName = methodInvocation.getMethod().getName();
		args = methodInvocation.getArguments();
		key = methodInvocationAsString(methodName, args);
		cache = Cache.getInstance();
		if (cache.containsKey(key) == true) {
			ret = cache.get(key);
		} else {
			ret = methodInvocation.proceed();
			cache.put(key, ret);
		}

		return ret;
	}

	private String methodInvocationAsString(String methodName, Object[] args) {
		StringBuilder key = null;

		key = new StringBuilder();
		key.append(methodName).append("(");
		for (int i = 0; i < args.length; i++) {
			if (i == 0) {
				key.append(args[i]);
				continue;
			}
			key.append(",").append(args[i]);
		}
		key.append(")");
		return key.toString();
	}
}
