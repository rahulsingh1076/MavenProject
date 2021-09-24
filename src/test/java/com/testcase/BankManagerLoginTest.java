package com.testcase;

import com.Base.TestBase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {

	@Test
	public void loginAsBankManager() throws InterruptedException {

		// to view link text of screen short need to set system property'
		System.getProperty("org.uncommons.reportng.escape-output" , "false");
		
		driver.findElement(By.cssSelector(OR.getProperty("bankManagerBtn"))).click();

		// driver.findElement(By.cssSelector("div > div:last-child >
		// .btn.btn-primary.btn-lg"));

		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))), "Loggin not Successfull");
		Reporter.log("Login successfully");
		Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\rahul\\Desktop\\Screenshort.jpg\"> ScrrenShort </a> ");

	}

}
