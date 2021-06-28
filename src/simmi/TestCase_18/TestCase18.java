package simmi.TestCase_18;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/*Test Case - 18 : 27th Jun'2021
Write a method to return Text of Menu elements. 
Hint : Please watch video 27th_Jun_Session-17.1_Selenium_Practice for more details.*/

public class TestCase18 {

	@Test
	static ArrayList<String> getAllElements(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//span[@class = 'accountUserName col-xs-12 reset-padding']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

		List<WebElement> e = driver
				.findElements(By.xpath("//div[@class = 'dropdownAccountNonLoggedIn']//div[@class='accountList']//a"));

		Assert.assertEquals(
				driver.findElements(
						By.xpath("//div[@class = 'dropdownAccountNonLoggedIn']//div[@class='accountList']//a")).size(),
				4);
		ArrayList<String> output = new ArrayList<String>();

		for (WebElement elementList : e) {
			if (e.size() <= 4) {
				output.add(elementList.getText());
			}
		}
		return output;
	}

	@Test
	public void operation() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");

		ArrayList<String> elementList = getAllElements(driver);
		System.out.println(elementList);
		driver.close();
	}

}
