
package sangeeta.TestCase14;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_14_4 {
	
	@Test
	public void basicForm() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://automationbykrishna.com/";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("STEP 1 :- Click on Basic Element link");
		WebElement element = driver.findElement(By.xpath("//*[@id='basicelements']"));
		element.click();

		System.out.println("Step2:- Enter Email ID");
		WebElement emailID = driver.findElement(By.xpath("//*[@name='emailId']"));
		emailID.sendKeys("sangita.bhandarkar@yahoo.in");

		System.out.println("Step3:- Enter Password");
		WebElement password = driver.findElement(By.xpath("//*[@id='pwd']"));
		password.sendKeys("sangeeta@999");
		System.out.println("Step3:- Enter submit");
		WebElement element1 = driver.findElement(By.xpath("//button[@id='submitb2']"));
		element1.click();
		
		String expectedAlertMsg = "You successfully clicked on it";
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		Assert.assertEquals(alertMsg, expectedAlertMsg);
		alert.accept();
	} 
}
