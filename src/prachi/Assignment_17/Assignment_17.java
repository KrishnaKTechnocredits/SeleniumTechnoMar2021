package prachi.Assignment_17;

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

public class Assignment_17 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = Predefined_Actions.launchBrowser("https://flipkart.com");	
	}

	@Test
	public void getOption() {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@alt='Fashion']"))).build().perform();
		List<WebElement> optionList = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a"));
		LinkedHashMap<String, ArrayList<String>> categoryAndSubCategory= new LinkedHashMap<String, ArrayList<String>>();
		for(WebElement listItems:optionList) {
			String pageItemText = listItems.getText();

			if(!pageItemText.contains("'")) {
				action.moveToElement(driver.findElement(By.xpath
						("//div[@class='_3XS_gI _7qr1OC']/a[contains(text(),'"+pageItemText+"')]"))).perform();
				ArrayList<String> childList = getListOfChildItems();
				categoryAndSubCategory.put(pageItemText,childList);
			}
			
			else {
				int indexOfComma = pageItemText.indexOf("'");
				String textOnScreenSubStr = pageItemText.substring(indexOfComma+1);
				action.moveToElement(driver.findElement(By.xpath
						("//div[@class='_3XS_gI _7qr1OC']/a[contains(text(),'"+textOnScreenSubStr+"')]"))).perform();
				ArrayList<String> childList = getListOfChildItems();
				categoryAndSubCategory.put(pageItemText,childList);
			}
		}	
		System.out.println(categoryAndSubCategory);
	}

	private ArrayList<String> getListOfChildItems() {
		ArrayList<String> outputList = new ArrayList<String>();
		List<WebElement> childItemObjects = driver.findElements
				(By.xpath("//div[@class='_3XS_gI']//a[@class='_6WOcW9 _3YpNQe']"));
		for(WebElement weSubMenu : childItemObjects) {
			outputList.add(weSubMenu.getText());
		}
		return outputList;
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}