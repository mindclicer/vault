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

public class NewReadExcel2 {
	public static Object[][] getDataFromExcel(String path,String sheetname) throws InvalidFormatException, IOException{
		Object[][] str = null;	
		//读取横向数据
		//InputStream is = ReadExcel.class.getClassLoader().getResourceAsStream(path);
		File Excelfile = new File(path);
		Workbook wk = new XSSFWorkbook(Excelfile);
		try {			
			Sheet LRpagesheet = wk.getSheet(sheetname);
			int lastRowNum = LRpagesheet.getLastRowNum();
			int lastCellNum = LRpagesheet.getRow(lastRowNum).getLastCellNum();
			//str = new Object[lastRowNum][lastCellNum];
			str = new Object[lastCellNum-1][lastRowNum+1];		
			System.out.println(lastRowNum);
			System.out.println(lastCellNum);	
			for(int c = 1; c < lastCellNum; c++) {
				for(int r = 0; r <= lastRowNum; r++) {				
					String string = LRpagesheet.getRow(r).getCell(c).getStringCellValue();
					if(string.equalsIgnoreCase("Empty")) {
						str[c-1][r]= "";		
					}
					else {
						str[c-1][r]= string;
					}	
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


