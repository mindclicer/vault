package com.yyf.ecshop.data;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

public class LoginProvider {
	 @DataProvider(name = "logindata")
	  public static Object[][] logindata() throws Exception {
//	    return new Object[][] {
//	      new Object[] 
//	    		  {"qqq001", "111111","��¼�ɹ�"},
//	    		  {"yy0001", "111111","�û������������"},
//	    		  {"", "111111","�û�������Ϊ��"}
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
