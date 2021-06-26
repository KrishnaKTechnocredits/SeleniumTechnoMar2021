package surabhi.demoTableSite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


//3. Print Employee First Name of all employees working from London Office.

public class TestCase4 extends BaseClass{
	
	@Test
	public void runTestCase() {
		List<WebElement>ls=driver.findElements(By.xpath("//table[@id='example']//td[text()='London']/preceding-sibling::td[2]"));
		for(WebElement el:ls) {
			String name=el.getText();
			System.out.println(name.substring(0, name.indexOf(' ')));
		}
	}

}
