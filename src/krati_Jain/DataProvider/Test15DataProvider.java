package krati_Jain.DataProvider;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test15DataProvider {
	WebDriver driver;

	@BeforeTest
	public void navigateToTab() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\krjain\\Documents\\Selenium TechnoCred\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Test(dataProvider = "loginDetailsProvider")
	public void registrationTab(String uname, String pwd, String expectedAlertMsg) throws InterruptedException {
		//String expectedLoginMsg = "Success!";
		//String expectedFailMsg = "Failed! please enter strong password";
		driver.findElement(By.xpath("//a[text()='Registration']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		Alert alert = driver.switchTo().alert();
		String actualAlertMsg = alert.getText();
		alert.accept();
		Assert.assertEquals(expectedAlertMsg, actualAlertMsg);
	}
	
	@DataProvider(name = "loginDetailsProvider")
	public Object[][] setInputData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "krati";
		data[0][1] = "krati123";
		data[0][2] = "Failed! please enter strong password";
		
		data[1][0] = "anshul";
		data[1][1] = "anshul123";
		data[1][2] = "Success!";
		
		return data;
	}
	
	
	@AfterClass
	public void closeBrowser() { 
		driver.quit();
	 }
	 

}
