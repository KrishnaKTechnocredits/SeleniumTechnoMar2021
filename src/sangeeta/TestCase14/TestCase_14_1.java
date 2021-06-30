package sangeeta.TestCase14;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_14_1 {
	
	@Test
	public void browserActivity(){
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://www.google.com/";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String pageTitle = driver.getTitle();
		int lengthOfPageTitle = pageTitle.length();
		System.out.println("Page title of current URL is "+pageTitle);
		System.out.println("Length of page title is " +lengthOfPageTitle);
		String currentURL = driver.getCurrentUrl();
		
		Assert.assertEquals(currentURL, url);
		String pageSource = driver.getPageSource();
		int pageSourceLength = pageSource.length();
		System.out.println("Length of page source is "+pageSourceLength);

		driver.close();
	}

}
