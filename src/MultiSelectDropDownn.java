import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiSelectDropDownn {
	public static void main(String[] args) {
		System.setProperty("webderver.driver.chrome", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.id("regestration2")).click();
	}

}
