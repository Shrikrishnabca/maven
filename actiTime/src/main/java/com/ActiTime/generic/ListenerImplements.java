package com.ActiTime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplements  extends BaseClass implements ITestListener{
    
	public void onFinish(ITestContext context) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onTestFailure(ITestResult result) {
		TakesScreenshot t=(TakesScreenshot) driver;
		File src=t.getScreenshotAs(OutputType.FILE);
		File desc=new File("./screenshot/ss.png");
		try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			FileInputStream fis=new FileInputStream("");
			Workbook wb = WorkbookFactory.create(fis);
			wb.getSheet("").getRow(0).getCell(0).setCellValue("fail");
			FileOutputStream fos=new FileOutputStream("");
			wb.write(fos);
			wb.close();
			
		} catch (IOException | EncryptedDocumentException e) {
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		FileInputStream fis;
		try {
		fis = new FileInputStream("");
		Workbook wb;
		wb = WorkbookFactory.create(fis);
		wb.getSheet("").getRow(0).getCell(0).setCellValue("pass");
		FileOutputStream fos;
		fos = new FileOutputStream("");
		wb.write(fos);
		wb.close();
	}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
