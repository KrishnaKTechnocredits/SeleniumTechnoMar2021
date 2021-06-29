package ankit.Test_14_All_Test_TestNG_Conversion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ankit.AM_base.PredefinedMethods;

public class Test9_VerifyUserName {
	WebDriver driver ;
	@BeforeClass
	public void setUp(){
		driver = PredefinedMethods.launchBrowser("http://www.automationbykrishna.com");

	}
	@AfterClass
	public void tearDown(){
		driver.close();
	}

	@Test
	public void verifyUserName(){

		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));

		int totalRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		for(int index = 1 ; index <=totalRow ; index++) {
			String fName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			String lName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
			String ActualUserName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			String expectedUserName = fName.substring(0, 1).toLowerCase() + lName.toLowerCase() ;
			
			Assert.assertEquals(ActualUserName, expectedUserName);
		}
	}
}
