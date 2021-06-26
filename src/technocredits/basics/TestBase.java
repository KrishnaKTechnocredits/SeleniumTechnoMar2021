package technocredits.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestBase {

	public void gotoDemoTable(WebDriver driver) {
		driver.findElement(By.linkText("Demo Tables")).click();
	}
}
