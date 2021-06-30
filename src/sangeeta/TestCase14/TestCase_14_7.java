//rows and cols are dynamic, get the lastname of the emp whoes firstname is "Abhishek".
package sangeeta.TestCase14;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class TestCase_14_7 {
	
	@Test
	public void getLastName() {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		String name = "Abhishek";
		ArrayList<String> headerList = new ArrayList<String>();
		List<WebElement> headElementList = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		for(WebElement element : headElementList){
			headerList.add(element.getText());
		}
		int index = headerList.indexOf("Last Name") + 1;
		String lName = driver.findElement(By.xpath("//td[text()='"+name+"']//parent::tr/td["+index+"]")).getText();
		System.out.println("Last name of employee whose first name is Abhishek is: "+lName);
	}
}

