package monali;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase_18_returnTheTextOfMenuElements {
	@Test
	public void getText() {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		driver.get("https://www.snapdeal.com/");
		WebElement ele = driver.findElement(By.xpath("//span[@class='accountUserName col-xs-12 reset-padding']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).build().perform();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='dropdownAccountNonLoggedIn']/div/ul/li/a"));
		ac.moveToElement(list.get(0)).build().perform();
	    System.out.println(list.size());
	    for(WebElement ele1 : list) {
	    	System.out.println(ele1.getText());
	    }
	}

}
