package com.yyf.ecshop.data;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MytestListern1 extends TestListenerAdapter{
	@Override
	public void onTestFailure(ITestResult tr) {
		try {
			Field field =  tr.getTestClass().getRealClass().getField("driver");
			WrappedRemoteWebDriver driver =  (WrappedRemoteWebDriver) field.get(tr.getInstance());	
			String className = tr.getTestClass().getName();
			String methodName = tr.getName();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss_SSS");
			String time = sdf.format(new Date());
		    driver.takeScreenShot(className+"-"+methodName+"-"+time+".png");		
			//File file = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
			//file.renameTo(new File("testpic.png"));
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
}
	}
