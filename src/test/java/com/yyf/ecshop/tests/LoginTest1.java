package com.yyf.ecshop.tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.yyf.ecshop.data.LoginProvider;
import com.yyf.ecshop.pages.HomePage;
import com.yyf.ecshop.pages.LRpage;

public class LoginTest1 extends Basetest{
	  @Test(dataProvider="logindata",dataProviderClass = LoginProvider.class)
	  public void testLogin_success(String username,String password,String expectedText) {	  
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,5);      
        driver.get("http://localhost/ECshop/index.php");
        driver.manage().window().maximize();
        //ExpectedConditions.titleIs("ECSHOP演示站");
	    HomePage Homepage = new HomePage(driver);
	    Homepage.clicklogin();
	    LRpage Lrpage = new LRpage(driver);
	    //ExpectedConditions.titleIs("用户中心");
        Lrpage.input_username(username);
        Lrpage.input_password(password);
        Lrpage.click_WebElement(Lrpage.submit_btn);
        if(username.equals("")||password.equals("")) {
        	 wait.until(ExpectedConditions.alertIsPresent());
        	Lrpage.assert_alert(expectedText);      	
        }
        else {
        Lrpage.assert_result(expectedText);
        }
	   
}}

