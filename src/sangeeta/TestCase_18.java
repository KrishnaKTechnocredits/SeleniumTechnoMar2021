/*Test Case - 18 : 27th Jun'2021
Write a method to return Text of Menu elements. 
Hint : Please watch video 27th_Jun_Session-17.1_Selenium_Practice for more details.*/

package sangeeta;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCase_18 {
	
	@Test
	public void signInMenuList() {
		WebDriver driver = PredefinedActions.start("https://www.snapdeal.com/");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='accountInner']/span[text()='Sign In']")));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='dropdownAccountNonLoggedIn']/div[@class='accountList']/ul/li/a"));
		System.out.println(list.size());
		for(WebElement e : list) {
			System.out.println(e.getText());
		}
	}

}
