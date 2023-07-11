package com.Pyga.Vtigergenericutlity;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerImp implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		TakesScreenshot t=(TakesScreenshot)BaseClass.sdriver;
		File src = t.getScreenshotAs(OutputType.FILE);
		LocalDateTime ldt=LocalDateTime.now();
		String dateTime = ldt.toString().replace(" : ", "_").replace(":", "_");
		File dst = new File("./ScreenShots/"+methodName+"_"+dateTime+".png");
		
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//ITestListener.super.onTestFailure(result);
	}
 
	
}
