package com.aa.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.aa.beans.Calculator;
import com.aa.beans.DynamicLoggingPointcut;
import com.aa.beans.LoggingAdvice;
import com.aa.beans.LoggingPointcut;

public class AATest {
	public static void main(String[] args) {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(new Calculator());
		// proxyFactory.addAdvice(new LoggingAdvice());
		//proxyFactory.addAdvisor(new DefaultPointcutAdvisor(new LoggingPointcut(), new LoggingAdvice()));
		proxyFactory.addAdvisor(new DefaultPointcutAdvisor(new DynamicLoggingPointcut(), new LoggingAdvice()));

		Calculator proxy = (Calculator) proxyFactory.getProxy();
		// Calculator proxy = new Calculator();
		int sum = proxy.add(10, 20);
		System.out.println("sum : " + sum);

		int multiply = proxy.multiply(101, 201);
		System.out.println("multiply : " + multiply);
	}
}
