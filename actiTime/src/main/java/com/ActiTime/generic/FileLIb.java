package com.ActiTime.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLIb {
	public String GetProperty(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	public String GetExcelData(String sheet,int row,int column) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	public void SetExcelData(String data,String sheet,int row,int column) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).getCell(column).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("");
		wb.write(fos);
		wb.close();
	}

}
