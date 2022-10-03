package com.basemethob;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseMethod {
	public static WebDriver driver;
	
	//@BeforeTest
	public static void browserLaunch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP\\eclipse-workspace\\Fbook\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https:facebook.com");
		driver.manage().window().maximize();
	}
	@Test
	public static void login() throws IOException, InterruptedException {
		WebElement uname=driver.findElement(By.id("email"));
		uname.sendKeys("kowsipriya@gmail.com");
		WebElement pword=driver.findElement(By.id("pass"));
		pword.sendKeys("Ragapriya@19");
		WebElement sign=driver.findElement(By.name("login"));
		sign.click();
		Thread.sleep(5000);
		TakesScreenshot scrshot= (TakesScreenshot) driver;
		File scrFile = scrshot.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\HP\\Desktop\\New folder (2)\\screen.png");
		FileUtils.copyFile(scrFile, dest);

		driver.navigate().back();
		
	}
	
	@AfterTest
	public static void createaccount() {
	//WebElement createElement=driver.findElement(By.xpath("//*[@id=\"login_link\"]/div[3]/a"));
	WebElement fname=driver.findElement(By.id("firstname"));
	WebElement sname=driver.findElement(By.id("lastname"));
	WebElement mnum=driver.findElement(By.name("reg_email__"));
	WebElement npassword=driver.findElement(By.name("reg_passwd__"));
	
		
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		
		browserLaunch();
		login();
		createaccount();
	}

}
