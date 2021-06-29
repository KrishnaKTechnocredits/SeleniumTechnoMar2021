package krati_Jain.test1_14_TestNG;

import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase11 {

	WebDriver driver;
	
	@BeforeClass
	public void setDriver() throws InterruptedException {	
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\krjain\\Documents\\Selenium TechnoCred\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		getDepts();
	}
	
	@Test
		public void getDepts() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		List<WebElement> allDepts = driver.findElements(By.xpath("//table[@class='table table-striped']//tr/td[5]"));
		System.out.println();
		Thread.sleep(3000);
		TreeSet<String> uniqueDept = new TreeSet<String>();
		for(WebElement dept : allDepts) {
			uniqueDept.add(dept.getText());
		}
		System.out.println(uniqueDept);
		driver.close();
		System.out.println(uniqueDept.size());
	}
		@AfterClass
		public void quitBrowsers() {
			driver.quit();
		}
}
