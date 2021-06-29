package monali;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
 
public class TestCase_17_MouseHover {
	@Test
	public void mouseHover() {
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//div[text()='Fashion']"));
		action.moveToElement(ele).build().perform();
		
		WebElement element = driver.findElement(By.linkText("Men's Top Wear"));
		action.moveToElement(element).build().perform();
		List<WebElement> list1 = driver.findElements(By.xpath("//span[@class='xtXmba'] //following-sibling::a"));
		System.out.println(list1.size());
		for(WebElement ele1 : list1 ) {
			System.out.println(ele1.getText());
		}

		
		WebElement element1 = driver.findElement(By.linkText("Men's Bottom Wear"));
		action.moveToElement(element1).build().perform();
		List<WebElement> list2 = driver.findElements(By.xpath("//span[@class='xtXmba'] //following-sibling::a"));
		System.out.println(list2.size());
		for(WebElement ele1 : list2 ) {
			System.out.println(ele1.getText());
		}	
		
		WebElement element2 = driver.findElement(By.linkText("Women Ethnic"));
		action.moveToElement(element2).build().perform();
		List<WebElement> list3 = driver.findElements(By.xpath("//span[@class='xtXmba'] //following-sibling::a"));
		System.out.println(list3.size());
		for(WebElement ele1 : list3 ) {
			System.out.println(ele1.getText());
		}	
		
		WebElement element4 = driver.findElement(By.linkText("Women Western"));
		action.moveToElement(element4).build().perform();
		List<WebElement> list4 = driver.findElements(By.xpath("//span[@class='xtXmba'] //following-sibling::a"));
		System.out.println(list4.size());
		for(WebElement ele1 : list4 ) {
			System.out.println(ele1.getText());
		}
		
		WebElement element5 = driver.findElement(By.linkText("Men Footwear"));
		action.moveToElement(element5).build().perform();
		List<WebElement> list5 = driver.findElements(By.xpath("//span[@class='xtXmba'] //following-sibling::a"));
		System.out.println(list5.size());
		for(WebElement ele1 : list5 ) {
			System.out.println(ele1.getText());
		}
		
		WebElement element6 = driver.findElement(By.linkText("Women Footwear"));
		action.moveToElement(element6).build().perform();
		List<WebElement> list6 = driver.findElements(By.xpath("//span[@class='xtXmba'] //following-sibling::a"));
		System.out.println(list6.size());
		for(WebElement ele1 : list6 ) {
			System.out.println(ele1.getText());
		}
		
		WebElement element7 = driver.findElement(By.linkText("Watches and Accessories"));
		action.moveToElement(element7).build().perform();
		List<WebElement> list7 = driver.findElements(By.xpath("//span[@class='xtXmba'] //following-sibling::a"));
		System.out.println(list7.size());
		for(WebElement ele1 : list7 ) {
			System.out.println(ele1.getText());
		}
		
		WebElement element8 = driver.findElement(By.linkText("Bags, Suitcases & Luggage"));
		action.moveToElement(element8).build().perform();
		List<WebElement> list8 = driver.findElements(By.xpath("//span[@class='xtXmba'] //following-sibling::a"));
		System.out.println(list8.size());
		for(WebElement ele1 : list8 ) {
			System.out.println(ele1.getText());
		}		
		
		WebElement element9 = driver.findElement(By.linkText("Kids"));
		action.moveToElement(element9).build().perform();
		List<WebElement> list9 = driver.findElements(By.xpath("//span[@class='xtXmba'] //following-sibling::a"));
		System.out.println(list9.size());
		for(WebElement ele1 : list9 ) {
			System.out.println(ele1.getText());
		}
		
		WebElement element10 = driver.findElement(By.linkText("Essentials"));
		action.moveToElement(element10).build().perform();
		List<WebElement> list10 = driver.findElements(By.xpath("//span[@class='xtXmba'] //following-sibling::a"));
		System.out.println(list10.size());
		for(WebElement ele1 : list10 ) {
			System.out.println(ele1.getText());
		}	
		
		WebElement element11 = driver.findElement(By.linkText("Winter"));
		action.moveToElement(element11).build().perform();
		List<WebElement> list11 = driver.findElements(By.xpath("//span[@class='xtXmba'] //following-sibling::a"));
		System.out.println(list11.size());
		for(WebElement ele1 : list11 ) {
			System.out.println(ele1.getText());
		}		
		
	}

}
