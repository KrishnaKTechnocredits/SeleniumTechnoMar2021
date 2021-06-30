package ankit.Test_14_All_Test_TestNG_Conversion;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ankit.AM_base.PredefinedMethods;

public class Test2 {
	WebDriver driver;
	@BeforeClass
	public void setUp(){
		driver = PredefinedMethods.launchBrowser("https://www.google.com");

	}
	@AfterClass
	public void tearDown(){
		driver.close();
	}
	@Test
	public void launchBrowerAndValidateNavigateCommand() throws InterruptedException {
		System.out.println("STEP -  Launch a chrome");
		System.out.println("STEP -  Open Google.com");


		System.out.println("STEP -  Get page title name");
		String actualTitle =  driver.getTitle();
		String expectedTitle = "Google" ;
		System.out.println("VERIFY -  expected title");
		Assert.assertEquals(actualTitle, expectedTitle);

		System.out.println("STEP -  navigate to automationbykrishna.com");
		driver.navigate().to("http://www.automationbykrishna.com");
		Thread.sleep(2000);
		System.out.println("STEP -  Get page title name ");
		String actualTitleAK = driver.getTitle();
		String expectedTitleAK = "Login Signup Demo";
		System.out.println("VERIFY -  Expected title");
		Assert.assertEquals(actualTitleAK, expectedTitleAK);
	
		Thread.sleep(2000);
		System.out.println("STEP -  navigate back in history");
		driver.navigate().back();

		System.out.println("STEP -  Get page title name and verify with expected title [google]");
		String actualBackTitle =  driver.getTitle();
		Assert.assertEquals(actualBackTitle, expectedTitle);

		Thread.sleep(2000);
		System.out.println("STEP -  navigate forward in the history");
		driver.navigate().forward();

		System.out.println("STEP -  Get page title name and verify with expected title [automationbykrishna]");
		String actualfwdTitleAK =  driver.getTitle();
		Assert.assertEquals(actualfwdTitleAK, expectedTitleAK);

		Thread.sleep(2000);
		System.out.println("STEP -  refresh the page and verify the expected title [automationbykrishna]");
		driver.navigate().refresh();
		
		System.out.println("STEP -  Close the browser.");
	}
}
