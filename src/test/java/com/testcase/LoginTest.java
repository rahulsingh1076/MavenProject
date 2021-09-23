package com.testcase;

import com.Base.TestBase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		
		driver.findElement(By.cssSelector(OR.getProperty("bankManagerBtn"))).click();
		
		//driver.findElement(By.cssSelector("div > div:last-child > .btn.btn-primary.btn-lg"));
		
		Thread.sleep(2000);
	}

}
