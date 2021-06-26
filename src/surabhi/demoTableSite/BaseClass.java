package surabhi.demoTableSite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	WebDriver driver;
	
	static void waitImplicit(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@BeforeClass
	public void getDriver() {
		System.setProperty("webdriver.chrome.driver", ".//resources//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().window().maximize();
		waitImplicit(driver);
	}
}
