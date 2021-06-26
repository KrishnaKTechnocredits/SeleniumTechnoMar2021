package surabhi;

/*String url= https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html';
1.open url on browser
2.Select any day from dropdown
3. select multiple values from multilist Demo 
4. deselect all the selected options and select remaining option*/

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase9 {
	void runTestCase(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element=driver.findElement(By.xpath("//select[@id='multi-select']"));
		Select select=new Select(element);
		select.selectByValue("New Jersey");
		select.selectByValue("Ohio");
		select.selectByValue("Texas");
		List<WebElement> selectedList=select.getAllSelectedOptions();
		List<WebElement> remainOptions=select.getOptions();
		remainOptions.removeAll(selectedList);
		for(WebElement el1:selectedList) {
			System.out.println(el1.getText());
			select.deselectByVisibleText(el1.getText());
		}
		for(WebElement el2:remainOptions) {
			select.selectByVisibleText(el2.getText());
			System.out.println("after deselected select options :"+el2.getText());
		}
		
		driver.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".//resources//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		new TestCase9().runTestCase(driver);
	}

}
