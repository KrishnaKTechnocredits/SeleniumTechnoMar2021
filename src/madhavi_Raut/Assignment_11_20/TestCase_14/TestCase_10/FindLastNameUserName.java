package madhavi_Raut.Assignment_11_20.TestCase_14.TestCase_10;
//Test case : 10 Name -> "Maulik", print lastName and UserName

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindLastNameUserName {
	
	WebDriver driver;

	@BeforeMethod
	void start() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("STEP: Navigating to website");
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
	}

	@AfterMethod
	void tearDown() {
		System.out.println("STEP: Closing the browser");
		driver.close();
	}

	@Test
	void getLastNameUserName() {
		String empName = "Maulik";
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("STEP - Fetching Employee Last Name and User Name");
		for (int index = 1; index <= rowCount; index++) {
			Assert.assertEquals((driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]")).getText()),(empName));
		}
	}
}
