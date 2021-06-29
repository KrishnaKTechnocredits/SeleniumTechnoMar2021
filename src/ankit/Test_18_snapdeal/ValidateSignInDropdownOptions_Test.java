package ankit.Test_18_snapdeal;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ankit.AM_base.PredefinedMethods;

public class ValidateSignInDropdownOptions_Test {
	private WebDriver driver;

	@BeforeClass
	void setUp(){
		driver = PredefinedMethods.launchBrowser("https://snapdeal.com");
	}

	private ArrayList<String> getListOfItemsUnderSignIn() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[@class='accountUserName col-xs-12 reset-padding']"))).click().perform();;
		List<WebElement> itemList =  driver.findElements(By.xpath("//div[@class='dropdownAccountNonLoggedIn']/div/ul/li/a"));
		ArrayList<String> actualItemLabelList = new ArrayList<String>();

		for(WebElement we:itemList) {
			actualItemLabelList.add(we.getText());
		}return actualItemLabelList;
	}
	@Test
	public void CheckItemListUnderSignIn() throws InterruptedException{
		ArrayList<String> actualItemLabelList = getListOfItemsUnderSignIn();
		ArrayList<String> expectedList = new  ArrayList<String>();
		expectedList.add("Your Account");
		expectedList.add("Your Orders");
		expectedList.add("Shortlist");
		expectedList.add("SD Cash");
		Assert.assertEquals(actualItemLabelList, expectedList);
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}
}
