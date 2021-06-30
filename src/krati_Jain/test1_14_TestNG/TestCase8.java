package krati_Jain.test1_14_TestNG;
// Test case : 8 Return a map of empId and empName

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase8 {
	
	WebDriver driver;

	@BeforeClass
	public void setDriver() throws InterruptedException {	
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\krjain\\Documents\\Selenium TechnoCred\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	@Test
	public void getIDName() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		
		List<WebElement> table = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		int size = table.size();

		HashMap<String,String> empData = new HashMap<String,String>();
		Thread.sleep(3000);
		
		for(int index = 1; index <= size; index++) {
			String empIDList = driver.findElement(By.xpath("//table[@class='table table-striped']//tr["+index+"]//td[2]")).getText();
			String empIDName = driver.findElement(By.xpath("//table[@class='table table-striped']//tr["+index+"]//td[3]")).getText();
			empData.put(empIDList, empIDName);
		}
		
		System.out.println(empData);
	}
	
	@AfterClass
	public void quitBrowsers() {
		driver.quit();
	}


}
