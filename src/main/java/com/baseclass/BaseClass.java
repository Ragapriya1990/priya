package com.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;
	public static String value;
	public static WebDriver Browserlaunch(String type) {
	if (type.equalsIgnoreCase("chrome")) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
 driver=new ChromeDriver();
	}
	else if (type.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.firefox.driver",".\\Driver\\chromedriver.exe"); 
	}
	driver.manage().window().maximize();
	return driver;
	}
	public static void ClickElement(WebElement element) {
		// TODO Auto-generated method stub
		element.click();
	}
	public static void Sendkeyelement(WebElement element,String value) {
		// TODO Auto-generated method stub
element.sendKeys(value);
	}
	public static WebDriver url(String value) {
		// TODO Auto-generated method stub
		driver.get(value);
		return driver;
	}
	public static WebDriver close() {
		// TODO Auto-generated method stub
driver.close();
return driver;
	}
	public static WebDriver quit() {
		// TODO Auto-generated method stub
driver.quit();
return driver;
	}
	public static WebDriver navigateto(String to) {
		// TODO Auto-generated method stub
driver.navigate().to(to);
return driver;
	}
	public static WebDriver navigateback() {
		// TODO Auto-generated method stub
driver.navigate().back();
return driver;
	}
	public static WebDriver navigaterefresh() {
		// TODO Auto-generated method stub
driver.navigate().refresh();
return driver;
	}
	public static WebDriver Alertaccept() {
		// TODO Auto-generated method stub
driver.switchTo().alert().accept();
return driver;
	}
	public static WebDriver alertdismiss() {
		// TODO Auto-generated method stub
driver.switchTo().alert().dismiss();
return driver;
	}
	public static WebDriver alerttext() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().getText();
		return driver;
	}
	public static WebDriver alertkeys(String key) {
		// TODO Auto-generated method stub
		driver.switchTo().alert().sendKeys(key);
		return driver;
	}
	public static WebDriver Frames(int index,String name,WebElement element) {
		// TODO Auto-generated method stub
driver.switchTo().frame(index);
driver.switchTo().frame(name);
driver.switchTo().frame(element);
driver.switchTo().parentFrame();
return driver;
	}
//	public static void Robot() {
//		// TODO Auto-generated method stub
//		Robot r=new Robot();
//
//	}
	public static WebDriver getcurrenturl() {
		// TODO Auto-generated method stub
		driver.getCurrentUrl();
		return driver;
	}
	public static WebDriver impwait(int sec) {
		// TODO Auto-generated method stub
		driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS );
		return driver;
	}
	public static void Screenshot(WebDriver driver) throws Throwable {
		// TODO Auto-generated method stub
TakesScreenshot scrshot= (TakesScreenshot) driver;
File scrFile = scrshot.getScreenshotAs(OutputType.FILE);
File dest=new File("");
FileUtils.copyFile(scrFile, dest);
	}
	public static void ScrollupAndDown(WebDriver driver,WebElement element) {
		// TODO Auto-generated method stub
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("window.scrollby(0,range)",element);
js.executeScript("window.scrollby(0,range)",element);
	}
	public static void select(WebElement element,String type,String value,int i) {
		// TODO Auto-generated method stub
Select s=new Select(element);
if(type.equalsIgnoreCase("selectbyValue")){
	s.selectByValue(value);
}
else if(type.equalsIgnoreCase("selectbyIndex")){
	int j = Integer.parseInt(value);
	System.out.println(j);
}
else if(type.equalsIgnoreCase("selectbyvisibility")) {
	s.selectByValue(value);
}
	}
	public static void selectall(WebElement element) {
		// TODO Auto-generated method stub
Select s=new Select(element);
s.getAllSelectedOptions();
	}
	public static void FirstSelect(WebElement element) {
		// TODO Auto-generated method stub
		Select s=new Select(element);
		s.getFirstSelectedOption();
	}
	public static void action(WebDriver driver,String name,WebElement element,WebElement target) {
		// TODO Auto-generated method stub
Actions act=new Actions(driver);
if(name.equalsIgnoreCase("click")) {
act.click();

} else if(name.equalsIgnoreCase("doubleClick")) {
	act.doubleClick(target);
}
else if(name.equalsIgnoreCase("ContextClick")) {
	act.contextClick();
}
else if(name.equalsIgnoreCase("drag and drop")) {
	act.dragAndDrop(element, target);
}
else if(name.equalsIgnoreCase("doubleClick")) {
	act.clickAndHold(target);
}
	}
	public static WebDriver WindowHandle(String type) {
		// TODO Auto-generated method stub
		String id = driver.getWindowHandle();
		List<WebElement> parent = driver.findElements(By.xpath(type));
		for (WebElement  allid: parent) {
			System.out.println(allid);
		}
		return driver;
	}
//	public static String  read_data(String path,String name,int row_index,int cell) throws Throwable {
//		// TODO Auto-generated method stub
//		File f=new File(path);
//		FileInputStream fis=new FileInputStream(f);
//		Workbook w=new XSSFWorkbook(fis);
//		Sheet s = w.getSheet(name);
//		Row r = s.getRow(row_index);
//		Cell c = r.getCell(cell);
//		CellType cellType = c.getCellType();
//		if (cellType.equals(CellType.STRING)) {
//			value = c.getStringCellValue();
//		} else if(cellType.equals(CellType.NUMERIC)) {
//			Object numericvalue = c.getNumericCellValue();
//			int data =(int) numericvalue;
//			value = String.valueOf(data);
//
//		}
//		return value;
//
//	}
	

}
