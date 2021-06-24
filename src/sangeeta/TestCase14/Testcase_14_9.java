
package sangeeta.TestCase14;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Testcase_14_9 {
	
	@Test
	public void verifyUserName() {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		List<WebElement> fNameElement = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
		List<WebElement> lNameElement = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		ArrayList<String> fName = new ArrayList<String>();
		ArrayList<String> lName = new ArrayList<String>();
		for(WebElement firstName : fNameElement) {
			fName.add(firstName.getText());
		}

		for(WebElement lastName : lNameElement) {
			lName.add(lastName.getText());
		}

		List<WebElement> userName = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
		ArrayList<String> actualUserName = new ArrayList<String>();
		for(WebElement uName : userName) {
			actualUserName.add(uName.getText());
		}
		ArrayList<String> expectedUsername = new ArrayList<String>();
		String uName = "";
		for(int index =0; index<fName.size(); index++) {
			uName = fName.get(index).toLowerCase().charAt(0) + lName.get(index).toLowerCase();
			expectedUsername.add(uName);
		}
		
		for(int index = 0; index<expectedUsername.size(); index++) {
			Assert.assertEquals(actualUserName, expectedUsername);
		}
	}
}
