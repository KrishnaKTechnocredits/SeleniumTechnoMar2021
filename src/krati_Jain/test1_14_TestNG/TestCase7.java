package krati_Jain.test1_14_TestNG;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase7 {

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
	public void getLastName() throws InterruptedException {
		int index = 0;
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		ArrayList<String> tableHeader = new ArrayList<String>();
		List<WebElement> tHeader = driver.findElements(By.xpath("//table[@id='table1']/thead//th"));
		for (WebElement listToArrayList : tHeader) {
			tableHeader.add(listToArrayList.getText());
		}
		for (String lNameCheck : tableHeader) {
			if (lNameCheck.equals("Last Name"))
				index = tableHeader.indexOf(lNameCheck) + 1;
		}
		Thread.sleep(2000);
		WebElement lastName = driver.findElement(By.xpath(
				"//table[@id='table1']/thead//following::tr/td[2][text()='Abhishek']//parent::tr/td[" + index + "]"));
		System.out.println("LastName : " + lastName.getText());
	}
	
	@AfterClass
	public void quitBrowsers() {
		driver.quit();
	}

}
