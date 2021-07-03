package madhavi_Khasbage.Assignment_14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import madhavi_Khasbage.base.PredefinedActions;

/*Task for today  
1. validate visible button functionality click on button and validate button is displayed or not and vice versa
2. validate enable button functionality click on button and validate button is disable or not and vice versa
3. validate isSelected on automationbykrishna's registration page if male radio button is selected then click on female
Note: 1 & 2 perform on HTML which is shared
*/

public class TestCase4 {	
	WebDriver driver;
	String expectedURL;
	
	@BeforeTest
	void setUp() {
		System.out.println("STEP1:Launch browser");
		 expectedURL = "file:///C:/Users/madha/Downloads/Krishna%20Requirement.html";
		driver = PredefinedActions.setUp(expectedURL);
		driver.manage().window().maximize();
	}

	@AfterTest
	void tearDown() {
		System.out.println("Step5: Close browser");
		driver.close();
	}
	
	@Test
	public void validateButtons() {
		System.out.println("STEP2:Send key to textbox");
		driver.findElement(By.xpath("//input[@id='myText']")).sendKeys("madhavi");
		
		System.out.println("STEP3:Click on botton and check enabled or not");
		driver.findElement(By.xpath("//button[@id='enableAndDisable']")).click();
		boolean isEnabled = driver.findElement(By.xpath("//input[@id='myText']")).isEnabled();
		System.out.println("Button enabled:" + isEnabled);

		System.out.println("STEP4:Click on botton and check enabled or not");
		driver.findElement(By.xpath("//button[@id='enableAndDisable']")).click();
		isEnabled = driver.findElement(By.xpath("//input[@id='myText']")).isEnabled();
		System.out.println("Button enabled:" +isEnabled);		
	}
}
