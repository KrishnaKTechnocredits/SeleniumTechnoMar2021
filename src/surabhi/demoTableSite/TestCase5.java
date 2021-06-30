package surabhi.demoTableSite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


/*
 * Find all Employees who hold Position as Software Engineer.
*/

public class TestCase5 extends BaseClass{
	
	@Test
	public void runTestCase() {
		//explicitWait(driver);
		//Xpath to find names of Software Engineer
		
		List<WebElement> arr=driver.findElements(By.xpath("//table[@id='example']//td[text()='Software Engineer']/preceding-sibling::td"));
		
		for(WebElement element:arr) {
			String name=element.getText();
			System.out.println(name);
		}
	}
}

