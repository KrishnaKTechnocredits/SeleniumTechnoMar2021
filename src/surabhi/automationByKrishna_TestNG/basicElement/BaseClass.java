package surabhi.automationByKrishna_TestNG.basicElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	static WebDriver driver;
	
	public static void waitForElementLocated(WebDriver driver, int secs) {
		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
	}
	
	@BeforeTest
	public void runBefore() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//a[@id='basicelements'])")).click();
		waitForElementLocated(driver, 10);
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
