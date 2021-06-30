package surabhi.demoTableSite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


/*
 * Count number of Employee with age More than 25, on first page
*/

public class TestCase6 extends BaseClass{
	
	@Test
	public void runCaseAgeGreaterThan25() {
		//explicitWait(driver);
		//Xpath to find age >25
		List<WebElement> arr=driver.findElements(By.xpath("//table[@id='example']//tr/td[4][text()>25]"));
		
		System.out.println("No of employees whose age is greater than 25 : "+arr.size());
	}
}

