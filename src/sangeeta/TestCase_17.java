/*Today's assignment (25/6/2021)
www.flipcart.com
1. Hover on Fashion icon
2. Hover on the first  item>> count the number of elements display on hovering.
3. Do it for rest of all submenu list
Program 2: Drag and Drop
https://jqueryui.com/resources/demos/droppable/default.html*/
package sangeeta;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class TestCase_17 {
	
	@Test
	public void mouseHover_1() {
		WebDriver driver = PredefinedActions.start("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement element1 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(element1).build().perform();
		WebElement element2 = driver.findElement(By.linkText("Men's Top Wear"));
		action.moveToElement(element2).perform();
		List<WebElement> elements = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(elements.size());
		for(WebElement e : elements) {
			System.out.println(e.getText());
		}
		driver.close();
	}
	
	@Test
	public void mouseHover_2() {
		WebDriver driver = PredefinedActions.start("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement element1 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(element1).build().perform();
		WebElement element2 = driver.findElement(By.linkText("Men's Bottom Wear"));
		action.moveToElement(element2).perform();
		List<WebElement> elements = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(elements.size());
		for(WebElement e : elements) {
			System.out.println(e.getText());
		}
		driver.close();
	}
	
	@Test
	public void mouseHover_3() {
		WebDriver driver = PredefinedActions.start("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement element1 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(element1).build().perform();
		WebElement element2 = driver.findElement(By.linkText("Women Ethnic"));
		action.moveToElement(element2).perform();
		List<WebElement> elements = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(elements.size());
		for(WebElement e : elements) {
			System.out.println(e.getText());
		}
		driver.close();
	}
	
	@Test
	public void mouseHover_4() {
		WebDriver driver = PredefinedActions.start("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement element1 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(element1).build().perform();
		WebElement element2 = driver.findElement(By.linkText("Women Western"));
		action.moveToElement(element2).perform();
		List<WebElement> elements = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(elements.size());
		for(WebElement e : elements) {
			System.out.println(e.getText());
		}
		driver.close();
	}
	
	@Test
	public void mouseHover_5() {
		WebDriver driver = PredefinedActions.start("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement element1 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(element1).build().perform();
		WebElement element2 = driver.findElement(By.linkText("Men Footwear"));
		action.moveToElement(element2).perform();
		List<WebElement> elements = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(elements.size());
		for(WebElement e : elements) {
			System.out.println(e.getText());
		}
		driver.close();
	}
	
	@Test
	public void mouseHover_6() {
		WebDriver driver = PredefinedActions.start("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement element1 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(element1).build().perform();
		WebElement element2 = driver.findElement(By.linkText("Women Footwear"));
		action.moveToElement(element2).perform();
		List<WebElement> elements = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(elements.size());
		for(WebElement e : elements) {
			System.out.println(e.getText());
		}
		driver.close();
	}
	
	@Test
	public void mouseHover_7() {
		WebDriver driver = PredefinedActions.start("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement element1 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(element1).build().perform();
		WebElement element2 = driver.findElement(By.linkText("Watches and Accessories"));
		action.moveToElement(element2).perform();
		List<WebElement> elements = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(elements.size());
		for(WebElement e : elements) {
			System.out.println(e.getText());
		}
		driver.close();
	}
	
	@Test
	public void mouseHover_8() {
		WebDriver driver = PredefinedActions.start("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement element1 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(element1).build().perform();
		WebElement element2 = driver.findElement(By.linkText("Bags, Suitcases & Luggage"));
		action.moveToElement(element2).perform();
		List<WebElement> elements = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(elements.size());
		for(WebElement e : elements) {
			System.out.println(e.getText());
		}
		driver.close();
	}
	
	@Test
	public void mouseHover_9() {
		WebDriver driver = PredefinedActions.start("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement element1 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(element1).build().perform();
		WebElement element2 = driver.findElement(By.linkText("Kids"));
		action.moveToElement(element2).perform();
		List<WebElement> elements = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(elements.size());
		for(WebElement e : elements) {
			System.out.println(e.getText());
		}
		driver.close();
	}
	
	@Test
	public void mouseHover_10() {
		WebDriver driver = PredefinedActions.start("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement element1 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(element1).build().perform();
		WebElement element2 = driver.findElement(By.linkText("Essentials"));
		action.moveToElement(element2).perform();
		List<WebElement> elements = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(elements.size());
		for(WebElement e : elements) {
			System.out.println(e.getText());
		}
		driver.close();
	}
	
	@Test
	public void mouseHover_11() {
		WebDriver driver = PredefinedActions.start("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement element1 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(element1).build().perform();
		WebElement element2 = driver.findElement(By.linkText("Winter"));
		action.moveToElement(element2).perform();
		List<WebElement> elements = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(elements.size());
		for(WebElement e : elements) {
			System.out.println(e.getText());
		}
		driver.close();
	}
}
