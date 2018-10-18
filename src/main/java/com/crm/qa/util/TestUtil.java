package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IllegalFormatException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 10;
	public static long IMPLICIT_WAIT = 10;

	public static String TEST_DATA_SHEET_PATH = "D://Workspace//ashish//freeCRMTest//src//main//java//com//crm//qa//testdata//FreeCRMTestData.xlsx";

	public static XSSFWorkbook book;
	public static XSSFSheet sheet;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public WebElement elementTobeClickable(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		return wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TEST_DATA_SHEET_PATH);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		try {
			book = new XSSFWorkbook(file);
			sheet = book.getSheet(sheetName);

		} catch (IllegalFormatException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		int lastRowNum = sheet.getLastRowNum();
		int lastColNum = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[lastRowNum][lastColNum];
		for (int i = 0; i < lastRowNum; i++) {
			for (int k = 0; k < lastColNum; k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}

		return data;
	}
}
