/*
Test Case 5 :
String url= https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html';
1.open url on browser
2.Select any day from dropdown
3. select multiple values from multilist Demo 
4. deselect all the selected options and select remaining option
 */

package sourabh.testCase5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("STEP 1: Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP 2: Open url on browser");
		String url = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
		driver.get(url);
		driver.manage().window().maximize();
		
		System.out.println("STEP 3: Select any day from dropdown");
		WebElement dayElement= driver.findElement(By.xpath("//select[@id='select-demo']"));
		Select dayDropDownElement= new Select(dayElement);		
		dayDropDownElement.selectByValue("Tuesday");
		
		System.out.println("STEP 4: select multiple values from multilist Demo ");
		WebElement multilistElement= driver.findElement(By.xpath("//select[@id='multi-select']"));
		Select multilistDropDownElement= new Select(multilistElement);
		multilistDropDownElement.selectByValue("California");
		multilistDropDownElement.selectByValue("Ohio");
		multilistDropDownElement.selectByValue("Washington");
		
		System.out.println("STEP 5: Deselect all the selected options and select remaining option");
		
		//multilistDropDownElement.deselectAll();
		List<WebElement> listofDropDownElement= multilistDropDownElement.getOptions();
		List<WebElement> listofSelectedDropDownElement= multilistDropDownElement.getAllSelectedOptions();
		listofDropDownElement.removeAll(listofSelectedDropDownElement);
		
		multilistDropDownElement.deselectAll();
		
		for(WebElement DropDownElement: listofDropDownElement) {
			multilistDropDownElement.selectByVisibleText(DropDownElement.getText());
			
		}
	}

}

