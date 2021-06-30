package surabhi.demoTableSite;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

//How many rows in Table on first page.

public class TestCase9 extends BaseClass {
	@Test
	public void runTestCase() {
		int rowCount=driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
		System.out.println(rowCount);
	}
}
