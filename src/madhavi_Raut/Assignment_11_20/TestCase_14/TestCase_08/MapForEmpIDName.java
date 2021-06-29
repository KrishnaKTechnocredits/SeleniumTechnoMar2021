package madhavi_Raut.Assignment_11_20.TestCase_14.TestCase_08;
//Test case : 8 Return a map of empId and empName

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MapForEmpIDName {
	
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
	void getMapForEmpIDName() {
		HashMap<Integer, String> empDetails = new HashMap<Integer, String>();
		HashMap<Integer, String> originalEmpDetails = new HashMap<Integer, String>();
		originalEmpDetails.put(76993,"Abhijit Mane");
		originalEmpDetails.put(76585,"Sumit Mate");
		originalEmpDetails.put(75599,"Sumit Kulkarni");
		originalEmpDetails.put(76113,"Prayag Mokate");
		originalEmpDetails.put(72299,"Pawan Belamkar");
		originalEmpDetails.put(75589,"Nikhil Patne");
		originalEmpDetails.put(20205,"Chetan Shewale");
		originalEmpDetails.put(20209,"Priyanka Bhale");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@id='table1']/thead/tr/th[text()='Last Name']")));
		int rowCount = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr")).size();
		int empId;
		String empName = "";
		System.out.println("STEP - Collecting Emp Id and respective Emp Name");
		for (int index = 1; index <= rowCount; index++) {
			empId = Integer.parseInt(
					driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + index + "]/td[2]")).getText());
			empName = driver
					.findElement(By
							.xpath("//div[@id='empmanager']//tbody/tr[" + index + "]/td[2]//following-sibling::td[1]"))
					.getText();

			if (!empDetails.containsKey(empId)) {
				empDetails.put(empId, empName);
			}
		}
		Assert.assertEquals(originalEmpDetails, empDetails, "Data Mismatched");	
	}
}
