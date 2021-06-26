package surabhi.demoTableSite;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

//How many rows in Table on first page.
public class TestCase10 extends BaseClass{
	
	@Test
	void runTestCase() {
		List <WebElement> rowText=driver.findElements(By.xpath("//table[@id='example']//tr"));
		
		for(WebElement ele:rowText) {
			System.out.println(ele.getText());
		}
	}

}
