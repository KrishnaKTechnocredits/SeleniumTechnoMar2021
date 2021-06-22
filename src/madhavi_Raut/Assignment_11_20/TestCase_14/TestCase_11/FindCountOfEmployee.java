package madhavi_Raut.Assignment_11_20.TestCase_14.TestCase_11;

//how many employees we have - 8
import java.util.HashSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindCountOfEmployee {
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
	void getEmployeeCount() {
		driver.findElement(By.id("demotable")).click();
		HashSet<String> EmployeeList = new HashSet<String>();
		
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));
		
		driver.findElement(By.xpath("//div[@id='empmanager']"));
		
		int rowCount = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr")).size();
		System.out.println("STEP - Fetching record of Employee present");
		for (int index = 1; index <= rowCount; index++) {
			EmployeeList.add(
					driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + index + "]/td[2]")).getText());
		}
		Assert.assertEquals(8, EmployeeList.size(), "Employee count mismatched");
	}
}
