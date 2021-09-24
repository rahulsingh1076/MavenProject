package com.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.utilities.ExcelReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

//	WebDriver 
//	Properties 
//	Logs
//	ExtentReport
//	DB
//	Excel
//	Mail

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static  org.apache.logging.log4j.Logger log = LogManager.getLogger(TestBase.class.getName());
	
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\TestData.xlsx");
	
	public static WebDriverWait wait ;

	@BeforeSuite
	public void setup() {

	
		if (driver == null) {
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("config properties Loaded");
				log.info("Logger info ");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\properties\\ObjectReprository.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("Object Repo properties Loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("chrome")) {

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (config.getProperty("browser").equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("edge")) {
				WebDriverManager.iedriver().setup();
				driver = new EdgeDriver();
			}
		}

		driver.get(config.getProperty("testSiteUrl"));
		log.debug("Driver Launched");
		// driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver , 10);

	}

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	
	public boolean isElementPresent(By by) {
		
		try {
			driver.findElement(by);
			return true;
		}catch (NoSuchElementException e) {
			return false;
		}		
	}

}
