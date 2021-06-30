package monika.TC13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

/*Test case - 13 : 
program 1: count number of employee under each manager, verify count against properties file.
output : 20209 -> 3
         20205 -> 4
		 10101 -> 2
*/
public class TC13_UsingTestNG {
	static WebDriver driver;
	
	@Test
	public static void verifyEmpCountUnderMgr() throws IOException {
		driver = PredefinedActions.start();
		driver.findElement(By.id("demotable")).click();
		List<WebElement> listOFMgrIds = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr/td[4]"));
		for(WebElement e : listOFMgrIds) {
			String mgrID = e.getText();
			List<WebElement> listOfactualEmpCount = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr/td[4][text()='"+mgrID+"']"));
			String actualEmpCount = String.valueOf(listOfactualEmpCount.size());
			File file = new File(".\\src\\monika\\MgrInfo.properties");
			FileInputStream inputStream = new FileInputStream(file);
			Properties propfile = new Properties();
			propfile.load(inputStream);
			String expEmpCount = propfile.getProperty(mgrID);
			Assert.assertEquals(actualEmpCount, expEmpCount);
		}
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	
	
	

}
