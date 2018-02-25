package com.yyf.ecshop.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import traning1202.DriverUtils;

public class Basetest {
public WebDriver driver;
	
	@AfterSuite
	public void closeService() {
		DriverUtils.stopService();
	}
	
	@BeforeMethod
	public void initDriver() {
		Config config = new Config("Config.properties");
        System.setProperty("yyf.selenium.browser", config.getConfig("browser"));
		driver = DriverUtils.getDriver();
	}
	
	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}
}


