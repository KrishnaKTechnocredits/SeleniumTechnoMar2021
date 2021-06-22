package madhavi_Raut.Assignment_11_20.TestCase_14.TestCase_07;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*Test case : 7
rows and cols are dynamic, get the lastname of the emp whoes firstname is "Abhishek".*/
public class FindNameFromDynamicTable {

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
	void getLastName() {
		String name = "Abhishek";
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		ArrayList<String> headerList = new ArrayList<String>();

		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));

		List<WebElement> listHeader = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));

		for (WebElement colHeading : listHeader) {
			headerList.add(colHeading.getText());
		}
		int index = 0;
		System.out.println("STEP-Getting column num of Last Name");
		for (String header : headerList) {
			if (header.equals("Last Name")) {
				index = headerList.indexOf(header);
				index++;
				break;
			}
		}
		System.out.println("STEP - Getting Last Name of " + name);
		String lastName = driver
				.findElement(By.xpath(
						"//table[@id='table1']/tbody/tr/td[text()='" + name + "']//parent::tr/td[" + index + "]"))
				.getText();
		System.out.println("Last Name of " + name + " is " + lastName);
	}
}
