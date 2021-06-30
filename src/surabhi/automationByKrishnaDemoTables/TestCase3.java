package surabhi.automationByKrishnaDemoTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/*Test case : 9
verify username from table "EMPLOYEE BASIC INFORMATION"*/

public class TestCase3 extends BaseClass {
	
	@Test
	void verifyUserName() {
		WebDriverWait wait=new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("table1")));
		
		int size=driver.findElements(By.xpath("//table[@id='table1']//tbody/tr")).size();
		
		for(int index=1;index<=size;index++) {
			String fName=driver.findElement(By.xpath("//table[@id='table1']//tbody/tr["+index+"]/td[2]")).getText();
			String lName=driver.findElement(By.xpath("//table[@id='table1']//tbody/tr["+index+"]/td[3]")).getText();
			String actualUserName=driver.findElement(By.xpath("//table[@id='table1']//tbody/tr["+index+"]/td[4]")).getText();
			
			Assert.assertEquals((String.valueOf(fName.charAt(0))+lName).toLowerCase(), actualUserName,"user Name not matched");
		}
	}

}
