package com.yyf.ecshop.data;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

public class LoginProvider {
	 @DataProvider(name = "logindata")
	  public static Object[][] logindata() throws Exception {
//	    return new Object[][] {
//	      new Object[] 
//	    		  {"qqq001", "111111","登录成功"},
//	    		  {"yy0001", "111111","用户名或密码错误"},
//	    		  {"", "111111","用户名不能为空"}
//	    };
		 return NewReadExcel2.getDataFromExcel("H:\\mindclicer\\LoginTest.xlsx","LRpage");
		 //return NewReadExcel.getDataFromExcel("LoginTest2.xlsx","LRpage");
}
	 @DataProvider(name = "shoppingdata")
	  public static Object[][] shoppingdata(){
	    return new Object[][] {
	      new Object[] 
	    		  {"qqq001", "111111"},
	    }; 		 
	 } 	 
}
