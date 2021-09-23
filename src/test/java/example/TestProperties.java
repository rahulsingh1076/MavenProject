package example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProperties {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		
		Properties config = new Properties();
		
		//FileInputStream fis = new FileInputStream("C:\\Users\\rahul\\Desktop\\PageObjectModel\\ProjectGit\\src\\test\\resources\\properties\\config.properties");
		System.out.println(System.getProperty("user.dir"));
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		config.load(fis);
		
		System.out.println(config.getProperty("browser"));
		System.out.println(config.get("testSiteUrl"));
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
		driver.findElement(By.cssSelector("div > div:last-child > .btn.btn-primary.btn-lg")).click();
	
		Thread.sleep(2000);
		driver.quit();
	}

}
