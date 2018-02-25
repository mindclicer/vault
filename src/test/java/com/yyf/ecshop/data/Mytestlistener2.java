package com.yyf.ecshop.data;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IRetryAnalyzer;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;


public class Mytestlistener2 implements IInvokedMethodListener{
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub	
	}
	@Override	
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		IRetryAnalyzer retry = method.getTestMethod().getRetryAnalyzer();
		if(retry == null) {
			method.getTestMethod().setRetryAnalyzer(new RetryAnalysis());
		}
	}
}
