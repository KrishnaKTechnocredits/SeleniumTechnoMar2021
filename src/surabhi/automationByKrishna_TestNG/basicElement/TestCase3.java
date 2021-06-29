package surabhi.automationByKrishna_TestNG.basicElement;

import java.util.concurrent.TimeUnit;

/*- Enter Fname, Lname and Company name. Basic Element tab
- click submit.
- you should get alert; get that text and verify.*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase3 extends BaseClass {
	
	@Test
	public void runTest() {
		String firstName="surabhi",  lastName="atal", companyName="cg";
		String expectedAlert=firstName+" and "+lastName+" and " +companyName;  //surabhi and atal and cg
		String alertText="";
		
		//enter first name, Last name, company name and click submit
		driver.findElement(By.xpath("//input[@name='ufname']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name='ulname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='cmpname']")).sendKeys(companyName);
		
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		
		waitForElementLocated(driver, 10);
		
		//check if alert came from webpage is equal to expected or not
		alertText=driver.switchTo().alert().getText();
		System.out.println(alertText);
		System.out.println(expectedAlert);
		
		Assert.assertEquals(alertText, expectedAlert,"Alert name and surname and company format test case failed");
		driver.switchTo().alert().accept();
	}

}
