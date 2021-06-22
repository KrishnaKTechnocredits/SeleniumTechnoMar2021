package monali;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice_TestCase_5 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "Chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(" https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		WebElement e = driver.findElement(By.id("select-demo"));
		e.click();
		Select select = new Select(e);
		select.selectByValue("Tuesday");
		
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",e);
		e.click();
		
		Thread.sleep(2000);
		WebElement e1 = driver.findElement(By.id("multi-select"));
		e1.click();
		Select select1 = new Select(e);
		System.out.println(select.isMultiple());
		Thread.sleep(3000);
		select1.selectByValue("New York");
		select1.selectByValue("Texas");
		select1.selectByValue("Washington");
		System.out.println(driver.findElement(By.xpath("//select[@name='States']")).isSelected());
		
		}

}
