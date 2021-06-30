package surabhi.demoTableSite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


/*
 * Print Employee Start date whose age is 66.
*/

public class TestCase7 extends BaseClass{
	
	@Test
	public void runTestCase() {
		//print name of employees whose age is 66
		String str=driver.findElement(By.xpath("//table[@id='example']//tr/td[4][text()=66]/following-sibling::td")).getText();
		System.out.println(str);
	}
}

