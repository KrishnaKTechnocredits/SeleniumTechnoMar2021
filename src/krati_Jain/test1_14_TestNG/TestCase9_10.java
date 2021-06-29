package krati_Jain.test1_14_TestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase9_10 {

	WebDriver driver;

	@BeforeClass
	public void setDriver() throws InterruptedException {	
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\krjain\\Documents\\Selenium TechnoCred\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@Test
	public void verifyUserName() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		List<WebElement> sizeList = driver.findElements(By.xpath("//table[@id='table1']//tr"));
		int size = sizeList.size();
		System.out.println();
		Thread.sleep(3000);
		for (int index = 1; index < size; index++) {
		String fname = driver.findElement(By.xpath("//table[@id='table1']//tr["+index+"]//td[2]")).getText();
		String lname = driver.findElement(By.xpath("//table[@id='table1']//tr["+index+"]//td[3]")).getText();
		String actualUName = "" + fname.charAt(0) + lname;
		System.out.println(actualUName.toLowerCase());
		}
	}
	@AfterClass
	public void quitBrowsers() {
		driver.quit();
	}

	
}
