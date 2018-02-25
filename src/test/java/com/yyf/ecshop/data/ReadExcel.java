package com.yyf.ecshop.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	
public class ReadExcel {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Workbook wb = new XSSFWorkbook(new FileInputStream(new File("H:\\mindclicer\\LoginTest2.xlsx")));
		Sheet LRpagesheet = wb.getSheet("LRpage1");
		int lastRowNum = LRpagesheet.getLastRowNum();
		//System.out.println(LRpagesheet.getRow(lastRowNum).getCell(3).getStringCellValue());
		int lastCellNum = LRpagesheet.getRow(lastRowNum).getLastCellNum();
		System.out.println(lastRowNum);
		System.out.println(lastCellNum);
		//int Firstrow = LRpagesheet.getFirstRowNum();
		System.out.println(LRpagesheet.getRow(1).getCell(1).getRichStringCellValue());	
//		for(int i = 0; i <= lastRowNum; i++) {
//			for(int j = 0; j < lastCellNum; j++) {
//				System.out.print(LRpagesheet.getRow(i).getCell(j).getStringCellValue()+"\t");
//			}
//			System.out.println();
//		}
		for(int c = 0; c < lastCellNum;c++ ) {
			for(int r = 0; r <=lastRowNum;r++ ) {
				System.out.print(LRpagesheet.getRow(r).getCell(c).getRichStringCellValue()+"\t");
			}
			System.out.println();
		}		
		wb.close();		
		}       
	}

