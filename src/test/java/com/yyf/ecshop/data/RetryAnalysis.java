package com.yyf.ecshop.data;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalysis implements IRetryAnalyzer{
    private static final int Maxtry_Times = 1;
	public int Trycount = 0;
	
	@Override
	public boolean retry(ITestResult result) {
		if(Trycount <  Maxtry_Times) {
			Trycount++;
			return true;
		}else{ 		
			return false;
		}
	}
}
