/*Test Case 5 :
String url= https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html';
1.open url on browser
2.Select any day from dropdown
3. select multiple values from multilist Demo 
4. deselect all the selected options and select remaining option*/

package sangeeta;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestCase5 {
	
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("//select[@id='select-demo']"));
		Select select1 = new Select(element);
		System.out.println(select1.isMultiple());
		select1.selectByValue("Sunday");
		
		WebElement element2 = driver.findElement(By.xpath("//select[@id='multi-select']"));
		Select select2 = new Select(element2);
		System.out.println(select2.isMultiple());
		select2.selectByValue("California");
		select2.selectByValue("Texas");
		select2.selectByValue("New York");	
	}

}
