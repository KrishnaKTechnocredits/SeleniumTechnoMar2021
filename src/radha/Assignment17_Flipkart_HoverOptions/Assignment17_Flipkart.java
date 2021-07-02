package radha.Assignment17_Flipkart_HoverOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment17_Flipkart {
WebDriver driver;
	
	@BeforeClass
	public void openBrowser() {
		driver = PredefinedActions.start("https://www.flipkart.com/");
	}
	
	@Test
	public void mouseHover() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		WebElement e = driver.findElement(By.xpath("//div[@class='xtXmba'][text()='Fashion']"));
		String category = e.getText();
		Actions action = new Actions(driver);
		System.out.println("STEP- Hover mouse on Fashion category");
		action.moveToElement(e).build().perform();
		System.out.println("STEP- Get list of sub-categories");
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a"));
		Assert.assertEquals(list.size(), 11);
		System.out.println(category + " has " + list.size() + " sub-categories.\n");
		System.out.println("STEP- Get options in each sub-category - \n");
		for (int i = 0; i < list.size(); i++) {
			action.moveToElement(list.get(i)).build().perform();
			System.out.println(list.get(i).getText() + " has "+ driver.findElements(By.xpath("//span[@class='xtXmba']//following-sibling::a")).size()+ " options");
		}
	}
	
	@AfterClass
	public void tearDown() {
		PredefinedActions.tearDown();
	}
}