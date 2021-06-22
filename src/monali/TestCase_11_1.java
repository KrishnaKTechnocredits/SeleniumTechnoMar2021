package monali;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//program 1: How many Depts we have.


public class TestCase_11_1 {

	static int uniqueDept(WebDriver driver) {
		List<WebElement> deptList = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		HashSet<String> deptNamesList = new HashSet<String>();
		for(WebElement ele :deptList ) {
			deptNamesList.add(ele.getText());
		}
	
			return deptNamesList.size();
	}
	
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		int count = uniqueDept(driver);
		System.out.println("count of unique dept is "+count);
	}
}
