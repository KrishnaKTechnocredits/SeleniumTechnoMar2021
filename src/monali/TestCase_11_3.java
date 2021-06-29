package monali;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//program 3: how many employees we have.


public class TestCase_11_3 {
	
	static int employeesList(WebDriver driver) {
		List<WebElement> listOfEmp = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr/td[3]"));
		HashSet<String> empList = new HashSet<String>();
		for(WebElement ele :listOfEmp ) {
			empList.add(ele.getText());
		}
	
			return empList.size();
	}
	
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		int count = employeesList(driver);
		System.out.println("count of employees in dept is "+count);
	}

}
