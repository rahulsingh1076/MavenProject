package com.testcase;

import com.Base.TestBase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		
		driver.findElement(By.cssSelector(OR.getProperty("bankManagerBtn"))).click();
		
		//driver.findElement(By.cssSelector("div > div:last-child > .btn.btn-primary.btn-lg"));
			
				
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))), "Loggin not Successfull");
		
		
	}

}
