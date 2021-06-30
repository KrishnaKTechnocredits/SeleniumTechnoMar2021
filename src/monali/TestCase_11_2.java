package monali;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//program 2 : how many managers we have.


public class TestCase_11_2 {

	static int managerList(WebDriver driver) {
		List<WebElement> managerList = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr/td[4]"));
		HashSet<String> listOfManager = new HashSet<String>();
		for(WebElement ele :managerList ) {
			listOfManager.add(ele.getText());
		}
	
			return listOfManager.size();
	}
	
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		int count = managerList(driver);
		System.out.println("count of manager in dept is "+count);
	}
}
