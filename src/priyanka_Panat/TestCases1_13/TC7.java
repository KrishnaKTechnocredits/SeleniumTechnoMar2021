package priyanka_Panat.TestCases1_13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC7 {
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

	static ArrayList<String> getColList(WebDriver driver) {
		ArrayList<String> headerList = new ArrayList<String>();
		List<WebElement> headElementList = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		for (WebElement element : headElementList) {
			headerList.add(element.getText());
		}
		return headerList;
	}

	static String getEmpDataByName(WebDriver driver, String name, int index) {
		return driver.findElement(By.xpath("//td[text()='" + name + "']//parent::tr/td[" + index + "]")).getText();
	}

	public static void main(String[] args) {
		start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
		ArrayList<String> headerList = getColList(driver);
		int index = headerList.indexOf("Last Name") + 1;
		String lastName = getEmpDataByName(driver, "Abhishek", index);
		System.out.println("Last name of emp whose first name abhishek is : " + lastName);
		tearDown();

	}
}
