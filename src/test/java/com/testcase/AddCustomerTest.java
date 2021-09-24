package com.testcase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.TestBase;

public class AddCustomerTest extends TestBase {

	@Test(dataProvider = "getData")
	void addCoustomer(String firstName, String lastName, String postCode, String status) throws InterruptedException {
//		
//		driver.findElement(By.cssSelector(OR.getProperty("bankManagerBtn"))).click();
////		Thread.sleep(30000);
		driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("firstName"))).sendKeys(firstName);
		
		driver.findElement(By.cssSelector(OR.getProperty("lastName"))).sendKeys(lastName);
		driver.findElement(By.cssSelector(OR.getProperty("postCode"))).sendKeys(postCode);
		driver.findElement(By.cssSelector(OR.getProperty("addBtn"))).click();
		
		
		Alert alert =wait.until(ExpectedConditions.alertIsPresent());
		
		//System.out.println(alert.getText());
		Assert.assertTrue(alert.getText().contains(status), "Failed unable to add new customer");
		
		alert.accept();
		
	}

	@DataProvider (name = "getData")
	public Object[][] getData() {

		String sheetName = "AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			for (int colNum = 0; colNum < cols; colNum++) {

				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;

	}
}
