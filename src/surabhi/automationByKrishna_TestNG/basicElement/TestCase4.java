package surabhi.automationByKrishna_TestNG.basicElement;

import org.openqa.selenium.By;

/*- Enter email
- Enter password
- verify message "You successfully clicked on it"*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase4 extends BaseClass{

	@Test
	public void runCase2() {
		TestCase3.waitForElementLocated(driver, 5);
		String expectedAlert="You successfully clicked on it";
		driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("surabhi@gmail.com");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		
		TestCase3.waitForElementLocated(driver, 5);
		
		//check alert message got is expected or not
		String alertMessage=driver.switchTo().alert().getText();
		Assert.assertEquals(alertMessage, expectedAlert, "Test case for alert is failed");
		
		driver.switchTo().alert().accept();
	}

}
