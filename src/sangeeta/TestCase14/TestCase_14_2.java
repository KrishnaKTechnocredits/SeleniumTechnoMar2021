
package sangeeta.TestCase14;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_14_2 {
	
	@Test
	public void nevigation(){
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = "https://www.google.com/";
		driver.get(url);
		String expectedPageTitle = "Google";
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, expectedPageTitle);
		driver.navigate().to("http://www.automationbykrishna.com");
		String expectedPageTitleABK = "Login Signup Demo";
		String pageTitleOfABK = driver.getTitle();
		Assert.assertEquals(pageTitleOfABK, expectedPageTitleABK);
		driver.navigate().back();
		pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, expectedPageTitle);
		driver.navigate().forward();
		pageTitleOfABK = driver.getTitle();
		Assert.assertEquals(pageTitleOfABK, expectedPageTitleABK);
		driver.navigate().refresh();
		pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, expectedPageTitleABK);
		driver.quit();
	}


}
