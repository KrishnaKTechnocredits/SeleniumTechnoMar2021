package priyanka_Panat.TestCases1_13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC9 {
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

	public static void main(String[] args) {
		start();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));
		int totalRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		for (int index = 1; index <= totalRow; index++) {
			String fName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String lName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			String actualUserName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			String expectedUserName = fName.charAt(0) + lName;
			expectedUserName = expectedUserName.toLowerCase();
			if (actualUserName.equals(expectedUserName)) {
				System.out.println(fName + " " + lName + " User Name " + actualUserName + " is Correct - PASS");
			} else {
				System.out.println(fName + " " + lName + " User Name " + actualUserName + " is Incorrect - FAIL");
			}
		}
		tearDown();

	}

}
