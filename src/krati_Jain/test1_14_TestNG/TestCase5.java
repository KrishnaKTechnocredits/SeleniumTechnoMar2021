package krati_Jain.test1_14_TestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase5 {

	WebDriver driver;

	@BeforeClass
	public void setDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\krjain\\Documents\\Selenium TechnoCred\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	@Test
	public void test5Picklist() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element1 = driver.findElement(By.xpath("//select[@id='select-demo']"));
		je.executeScript("arguments[0].scrollIntoView(true)", element1);
		element1.click();
		// WebElement dayToSelect = driver.findElement(element1);
		Select select = new Select(element1);
		select.selectByValue("Sunday");
		element1.click();
	}

	@Test
	public void test5MultiPicklist() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element2 = driver.findElement(By.xpath("//select[@id='multi-select']"));
		je.executeScript("arguments[0].scrollIntoView(true)", element2);
		Select select = new Select(element2);
		select.selectByValue("California");
		select.selectByValue("New Jersey");
		select.selectByValue("Pennsylvania");
		select.selectByValue("Washington");

		List<WebElement> selectedList = select.getAllSelectedOptions();
		for (WebElement selectsElements : selectedList) {
			System.out.println(selectsElements.getText());
		}

		List<WebElement> allList = select.getOptions();
		/*
		 * for(WebElement allElements : allList) { allElements.click(); }
		 */

		allList.removeAll(selectedList);
		for (WebElement allElements : allList) {
			System.out.println("Non Selected Elements are : " + allElements.getText());
		}
	}

	@AfterClass
	public void quitBrowsers() {
		driver.quit();
	}
}
