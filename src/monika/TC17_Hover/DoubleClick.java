package monika.TC17_Hover;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.AbstractParallelWorker.Arguments;

import base.PredefinedActions;

public class DoubleClick {

	@Test
	public void doubleClick() {
		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.id("basicelements")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.xpath("//a[text()='Double-click on me']")));
		Actions a = new Actions(driver);
		a.doubleClick(driver.findElement(By.xpath("//div[@class='form-group']/a[text()='Double-click on me']"))).build().perform();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.close();
	}
}
