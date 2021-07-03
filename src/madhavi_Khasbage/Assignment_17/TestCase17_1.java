package madhavi_Khasbage.Assignment_17;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import madhavi_Khasbage.base.PredefinedActions;

public class TestCase17_1 {
	
	WebDriver driver;

	@BeforeTest
	void startUp() {		
		System.out.println("Step1:Launch Brower");
		String expectedUrl="http://automationbykrishna.com/";		
		driver = PredefinedActions.setUp(expectedUrl);
		driver.manage().window().maximize();		
	}

	@AfterTest
	void tearDown() {
		driver.close();
	}

}
