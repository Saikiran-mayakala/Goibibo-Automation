package com.qa.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities
{
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public ExcelUtilities(String excelpath,String sheetname)
	{
		try 
		{
			file=new FileInputStream(excelpath);
			workbook= new XSSFWorkbook(file);
			sheet=workbook.getSheet(sheetname);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public int getrowcount()
	{
		int rowcount=sheet.getPhysicalNumberOfRows();
		
		return rowcount;
		
	}
	
	public int getcolcount()
	{
		int colcount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		return colcount;
		
	}
	
	
	public String getcelldata(int rownum,int colnum)
	{
		
		String stringcellvalue=sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		return stringcellvalue;
		
	}
	
	
	
	

}
