package surabhi.demoTableSite;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestCase3 extends BaseClass{
	@Test
	public void runCaseAge() {
		String age=driver.findElement(By.xpath("//table[@id='example']/tbody//td[text()='Caesar Vance']/following-sibling::td[3]")).getText();
		System.out.println(Integer.parseInt(age));
	}
	
}
