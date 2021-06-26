package surabhi.automationByKrishna_TestNG.basicElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/*TC#3
click Alert button
Verify - "You must be TechnoCredits student"*/

public class TestCase5 extends BaseClass {
	
	@Test
	public void runCaseAlert() {
		String expectedAlertMsg="You must be TechnoCredits student!!";
		
		//click on alert button
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		
		String alertText=driver.switchTo().alert().getText();
		Assert.assertTrue(alertText.equals(expectedAlertMsg), "Test case alert 3 failed");
		
		driver.switchTo().alert().accept();
	}

}
