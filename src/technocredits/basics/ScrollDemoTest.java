package technocredits.basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.PredefinedActions;

public class ScrollDemoTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.id("javascriptPromp"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",element);
		element.click();
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Surbhi");
		Thread.sleep(5000);
		alert.accept();
		//je.executeScript("document.getElementById('javascriptAlert').click()");
		
		WebElement bdayElement = driver.findElement(By.xpath("//select[@id='continent']"));
		Select bdayDropdownElement = new Select(bdayElement);
		
		bdayDropdownElement.selectByIndex(0); // 1
		bdayDropdownElement.selectByValue("6");
		bdayDropdownElement.selectByVisibleText("Australia");
	
	}
}
