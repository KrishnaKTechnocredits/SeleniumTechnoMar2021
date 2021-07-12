package monika.TC_WindowHandle;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class GetTextOfElement {
	private WebDriver driver;
	@BeforeTest
	void beforeMethod() {
		driver = PredefinedActions.start("https://www.snapdeal.com/");
	}

	
	private List<String> getText() {
		List<String> actualList = new ArrayList<String>();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[text()='Sign In']"))).build().perform();
		List<WebElement> ls = driver.findElements(By.xpath("//div[@class='dropdownAccountNonLoggedIn']/div[@class='accountList']/ul/li/a"));
		for(WebElement e :ls) {
			actualList.add(e.getText());
		}
		return actualList;	
	}
	@Test
	public void getTextResult() {
		List<String> actualList = getText();
		List<String> expList = new ArrayList<String>();
		
		expList.add("Your Account");
		expList.add("Your Orders");
		expList.add("Shortlist");
		expList.add("SD Cash");
		//int count = 0;
		/*for(String exp : expList) {
			Assert.assertEquals(actualList.get(count),exp);
			count++;
		}*/
		
		Assert.assertEquals(actualList,expList);
		driver. close();
	}
	

}
