package com.Pyga.Vtigergenericutlity;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImp implements IRetryAnalyzer {
     int count=0,retryLimit=3;
     
	@Override
	public boolean retry(ITestResult result) {
		if(count<retryLimit) {
			count++;
			return true;
		}
		return false;
	}

}
