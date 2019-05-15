package com.aa.beans;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		String methodName = null;
		Object[] args = null;
		Object ret = 0;

		methodName = methodInvocation.getMethod().getName();
		args = methodInvocation.getArguments();
		System.out.print("entering into method : " + methodName + "(");
		for (int i = 0; i < args.length; i++) {
			if (i == 0) {
				System.out.print(args[i]);
				continue;
			}
			System.out.print("," + args[i]);
		}
		System.out.println(")");

		//args[0] = (Integer) args[0] + 1;
		//args[1] = (Integer) args[1] + 1;

		if ((Integer) args[0] > 0 && (Integer) args[1] > 0) {
			ret = methodInvocation.proceed();
		}
		
		System.out.println("exiting from method : " + methodName + " with ret : " + ret);
		//ret = (Integer) ret + 1;

		return ret;
	}

}
