package ankit.Test_17_Flipkart;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ankit.AM_base.PredefinedMethods;

public class FlipCartItemList {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = PredefinedMethods.launchBrowser("https://flipkart.com");	
	}

	@Test
	public void findItemsUnderOption() {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@alt='Fashion']"))).build().perform();
		List<WebElement> optionList = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a"));
		LinkedHashMap<String, ArrayList<String>> categorySubCategHM = new LinkedHashMap<String, ArrayList<String>>();
		for(WebElement listItems:optionList) {
			String textOnScreen = listItems.getText();

			if(!textOnScreen.contains("'")) {
				action.moveToElement(driver.findElement(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a[contains(text(),'"+textOnScreen+"')]"))).perform();
				ArrayList<String> childList = getListOfChildItems();
				categorySubCategHM.put(textOnScreen,childList);
			}
			else {
				int indexOfComma = textOnScreen.indexOf("'");
				String textOnScreenSubStr = textOnScreen.substring(indexOfComma+1);
				action.moveToElement(driver.findElement(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a[contains(text(),'"+textOnScreenSubStr+"')]"))).perform();
				ArrayList<String> childList = getListOfChildItems();
				categorySubCategHM.put(textOnScreen,childList);
			}
		}	
		System.out.println(categorySubCategHM);
	}

	private ArrayList<String> getListOfChildItems() {
		ArrayList<String> output = new ArrayList<String>();
		List<WebElement> childItemObjects = driver.findElements(By.xpath("//div[@class='_3XS_gI']//a[@class='_6WOcW9 _3YpNQe']"));
		for(WebElement weChildItems : childItemObjects) {
			output.add(weChildItems.getText());
		}
		return output;
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
















