package radha.Assignment18;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class ReturnTextOfMenuItems {
	WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		driver = PredefinedActions.start("https://www.snapdeal.com/");
	}
	
	private ArrayList<String> findSignOptionsList() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement signin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='accountUserName col-xs-12 reset-padding']")));
		System.out.println("Mouse hovered on -" + signin.getText());
		Actions actions = new Actions(driver);
		actions.moveToElement(signin).build().perform();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='dropdownAccountNonLoggedIn']/div[@class='accountList']/ul/li/a"));
		System.out.println("Size of list of elements in Sign-in option-" + list.size());
		ArrayList<String> actualOptionsList = new ArrayList<>();
		for (WebElement e : list) {
			actualOptionsList.add(e.getText());
		}
		System.out.println(actualOptionsList);
		return actualOptionsList;
	}
	
	@Test
	public void signInHover() {
		ArrayList<String> actualOptionsList =findSignOptionsList();
		ArrayList<String> expOptionsList = new ArrayList<>();
		expOptionsList.add("Your Account");
		expOptionsList.add("Your Orders");
		expOptionsList.add("Shortlist");
		expOptionsList.add("SD Cash");
		Assert.assertEquals(expOptionsList, actualOptionsList);
		System.out.println("Test is completed!!!");
	}

	@AfterClass
	public void tearDown() {
		PredefinedActions.tearDown();
	}
}
