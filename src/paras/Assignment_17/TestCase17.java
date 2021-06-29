/*
Test Case 17: 
Today's assignment (25/6/2021)
www.flipcart.com
1. Hover on Fashion icon
2. Hover on the first  item>> count the number of elements display on hovering.
3. Do it for rest of all submenu list
 */
package paras.Assignment_17;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase17 {

	private static WebDriver driver;

	@BeforeMethod
	public void start() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// Fashion --> Men's Top Wear
	@Test
	public void item1() {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement item1 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(item1).build().perform();
		WebElement category1 = driver.findElement(By.linkText("Men's Top Wear"));
		action.moveToElement(category1).perform();
		List<WebElement> item1List = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(item1List.size());
		for (WebElement item : item1List) {
			System.out.println(item.getText());
		}
	}

	// Fashion --> Men's Bottom Wear
	@Test
	public void item2() {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement item2 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(item2).build().perform();
		WebElement category2 = driver.findElement(By.linkText("Men's Bottom Wear"));
		action.moveToElement(category2).perform();
		List<WebElement> item2List = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(item2List.size());
		for (WebElement item : item2List) {
			System.out.println(item.getText());
		}
	}

	// Fashion --> Women Ethnic
	@Test
	public void item3() {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement item3 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(item3).build().perform();
		WebElement category3 = driver.findElement(By.linkText("Women Ethnic"));
		action.moveToElement(category3).perform();
		List<WebElement> item3List = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(item3List.size());
		for (WebElement item : item3List) {
			System.out.println(item.getText());
		}
	}

	// Fashion --> Women Western
	@Test
	public void item4() {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement item4 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(item4).build().perform();
		WebElement category4 = driver.findElement(By.linkText("Women Western"));
		action.moveToElement(category4).perform();
		List<WebElement> item4List = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(item4List.size());
		for (WebElement item : item4List) {
			System.out.println(item.getText());
		}
	}

	// Fashion --> Men Footwear
	@Test
	public void item5() {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement item5 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(item5).build().perform();
		WebElement category5 = driver.findElement(By.linkText("Men Footwear"));
		action.moveToElement(category5).perform();
		List<WebElement> item5List = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(item5List.size());
		for (WebElement item : item5List) {
			System.out.println(item.getText());
		}
	}

	// Fashion --> Women Footwear
	@Test
	public void item6() {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement item6 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(item6).build().perform();
		WebElement category6 = driver.findElement(By.linkText("Women Footwear"));
		action.moveToElement(category6).perform();
		List<WebElement> item6List = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(item6List.size());
		for (WebElement item : item6List) {
			System.out.println(item.getText());
		}
	}

	// Fashion --> Watches and Accessories
	@Test
	public void item7() {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement item7 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(item7).build().perform();
		WebElement category7 = driver.findElement(By.linkText("Watches and Accessories"));
		action.moveToElement(category7).perform();
		List<WebElement> item7List = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(item7List.size());
		for (WebElement item : item7List) {
			System.out.println(item.getText());
		}
	}

	// Fashion --> Bags, Suitcases & Luggage
	@Test
	public void item8() {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement item8 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(item8).build().perform();
		WebElement category8 = driver.findElement(By.linkText("Bags, Suitcases & Luggage"));
		action.moveToElement(category8).perform();
		List<WebElement> item8List = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(item8List.size());
		for (WebElement item : item8List) {
			System.out.println(item.getText());
		}
	}

	// Fashion --> Kids
	@Test
	public void item9() {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement item9 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(item9).build().perform();
		WebElement category9 = driver.findElement(By.linkText("Kids"));
		action.moveToElement(category9).perform();
		List<WebElement> item9List = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(item9List.size());
		for (WebElement item : item9List) {
			System.out.println(item.getText());
		}
	}

	// Fashion --> Essentials
	@Test
	public void item10() {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement item10 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(item10).build().perform();
		WebElement category10 = driver.findElement(By.linkText("Essentials"));
		action.moveToElement(category10).perform();
		List<WebElement> item10List = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(item10List.size());
		for (WebElement item : item10List) {
			System.out.println(item.getText());
		}
	}

	// Fashion --> Winter
	@Test
	public void item11() {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement item11 = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(item11).build().perform();
		WebElement category11 = driver.findElement(By.linkText("Winter"));
		action.moveToElement(category11).perform();
		List<WebElement> item11List = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		System.out.println(item11List.size());
		for (WebElement item : item11List) {
			System.out.println(item.getText());
		}
	}

	@AfterMethod
	void End() {
		driver.close();
	}
}
