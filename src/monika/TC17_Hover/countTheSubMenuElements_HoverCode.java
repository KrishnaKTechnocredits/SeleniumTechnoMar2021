package monika.TC17_Hover;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class countTheSubMenuElements_HoverCode {

	private WebDriver driver;
	
	@Test
	public void getCountOnHover() throws InterruptedException {
		driver = PredefinedActions.start("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Step: click on cross");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		System.out.println("Step: Hover on Fashion");
		WebElement fashion = driver.findElement(By.xpath("//div[@class='xtXmba'][text()='Fashion']"));
		Actions act = new Actions(driver);
		act.moveToElement(fashion).build().perform();
		
		System.out.println("Step: find all elements on fashion");
		List<WebElement> oneMenuElements = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']//a"));
		Assert.assertEquals(oneMenuElements.size(), 11);
		
		
		System.out.println("Step: Hover on 1st menu");
		WebDriverWait extWait = new WebDriverWait(driver,30);		
		act.moveToElement(oneMenuElements.get(0)).build().perform();
		 
		System.out.println("Step: Hover on 1st Menu subset");
		List<WebElement> e1_1 = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		Assert.assertEquals(e1_1.size(), 11);
		
		System.out.println("Step: Hover on 2nd Menu subset");
			act.moveToElement(oneMenuElements.get(1)).build().perform();
			List<WebElement> e1_2 = driver.findElements(By.xpath("//div[@class='_3XS_gI']//a"));
			Assert.assertEquals(e1_2.size(), 10);
			
		driver.close();
	}
	
}
