package priyanka_Panat.TestCases1_13;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC10 {
	static WebDriver driver;

	static WebDriver start() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("STEP: Navigating to website");
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		return driver;
	}

	static void tearDown() {
		System.out.println("STEP: Closing the browser");
		driver.close();
	}

	static ArrayList<String> getEmpInfo(String empName) {

		String lName = driver
				.findElement(
						By.xpath("//table[@id='table1']/tbody//td[text()='" + empName + "']//following-sibling::td[1]"))
				.getText();
		String userName = driver
				.findElement(
						By.xpath("//table[@id='table1']/tbody//td[text()='" + empName + "']//following-sibling::td[2]"))
				.getText();
		ArrayList<String> empDetailsList = new ArrayList<String>();
		empDetailsList.add(lName);
		empDetailsList.add(userName);
		return empDetailsList;
	}

	public static void main(String[] args) {
		start();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));
		ArrayList<String> result = getEmpInfo("Maulik");
		System.out.println(result);
		tearDown();
	}
}


