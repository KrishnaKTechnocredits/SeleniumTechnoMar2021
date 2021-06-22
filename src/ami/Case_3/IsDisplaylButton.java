/*
 file:///C:/Users/mo/Downloads/Krishna%20Requirement.html

1. validate visible button functionality click on 
button and validate button is displayed or not and vice versa
 */

package ami.Case_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsDisplaylButton {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"E:\\LEARNING\\eclips java code\\SeleniumTechnoMar2021\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/mo/Downloads/Krishna%20Requirement.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		WebElement element = driver.findElement(By.id("visibleAndHidden"));
		element.click();
		boolean isdisplayResult = driver.findElement(By.xpath("//*[@id='myDIV']")).isDisplayed();
		
		if (isdisplayResult) {
			System.out.println("button visible");
		} else {
			System.out.println("button is not visible");
		}
		driver.close();
	}
}


