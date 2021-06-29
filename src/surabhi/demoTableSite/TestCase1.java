package surabhi.demoTableSite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


//1. How many total entries are there in table?


public class TestCase1 extends BaseClass{
	
	@Test
	public void runTestCase() {
		List<WebElement>el=driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		System.out.println(el.size());
	}
}
