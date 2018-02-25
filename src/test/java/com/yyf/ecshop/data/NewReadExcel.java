package com.yyf.ecshop.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.yyf.ecshop.pages.LRpage;

public class NewReadExcel {
	public static Object[][] getDataFromExcel(String path,String sheetname){
		//读取竖向数据
		Object[][] str = null;	
		InputStream is = ReadExcel.class.getClassLoader().getResourceAsStream(path);
		//File Excelfile = new File(path);
		try {
			Workbook wk = new XSSFWorkbook(is);
			Sheet LRpagesheet = wk.getSheet(sheetname);
			int lastRowNum = LRpagesheet.getLastRowNum();
			int lastCellNum = LRpagesheet.getRow(lastRowNum).getLastCellNum();
			str = new Object[lastRowNum][lastCellNum];
			System.out.println(lastRowNum);
			System.out.println(lastCellNum);
				for(int r = 1; r <= lastRowNum; r++) {
					for(int c = 0; c < lastCellNum; c++) {
					String string = LRpagesheet.getRow(r).getCell(c).getStringCellValue();
					str[r-1][c] = string;	
//					if(string.equalsIgnoreCase("<Empty>")) {
//						 str[r-1][c] = ""; }		
//					else{
//					 str[r-1][c] = string;
//					}
				}
			}
			wk.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();					
	}
		return str;		
}
}


