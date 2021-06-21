package rupali;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*Test Case 5 :
String url= https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html';
1.open url on browser
2.Select any day from dropdown
3. select multiple values from multilist Demo 
4. deselect all the selected options and select remaining option
 * 
 * 
 * package testSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * check text displayed when click on button, dropdown is selected . 
 * 
  /

public class TestCase10 {
	
	void runTestCase1(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.NANOSECONDS);
		System.out.println(driver.findElement(By.xpath("//html/body/p")).isDisplayed());
		driver.close();
	}
	
	void runTestCase2(WebDriver driver) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		if(driver.findElement(By.xpath("//input[@id='myText']")).isEnabled()) {
			Thread.sleep(3000);
			WebElement element=driver.findElement(By.xpath("//input[@id='myText']"));
			element.sendKeys("Surabhi");
			System.out.println(element.getText().length());
		}
		driver.close();
	}
	
	void runTestCase3(WebDriver driver) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='enableAndDisable']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//input[@id='myText']")).isEnabled());
		driver.findElement(By.xpath("//button[@id='enableAndDisable']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@id='myText']")).isEnabled());
		driver.close();
	}
	
	static WebDriver setupUrl() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/Shreyash%20Atal/Desktop/surabhi/JavaSelenium_GIT_Workspace/Krishna%20Requirement.html");
		driver.manage().window().maximize();
		return driver;
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	 	WebDriver driver=setupUrl();
		
		//check if text/element displayed
	 	new TestCase10().runTestCase1(driver);
		
		WebDriver driver2=setupUrl();
		//check if input text area disabled once click on button
		new TestCase10().runTestCase3(driver2);
	}

}



 */
public class DropDowndemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http:\\www.automationbykrishna.com");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//select[@class='form-control']")));
		
		// Declare the drop-down element as an instance of the Select class n find it with xpath of dropdown
		Select selectDD = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		System.out.println("FIRST PS - COunt of Options*****");
		System.out.println("Count of Options :"+selectDD.getOptions().size());
		
		//Select options
		selectDD.selectByVisibleText("2");
		selectDD.selectByVisibleText("3");
		selectDD.selectByVisibleText("4");
		
		List<WebElement> selectedWEList = selectDD.getAllSelectedOptions();
		System.out.println("Total Selected Options : "+selectedWEList.size());
		for(WebElement we : selectedWEList) 
			System.out.println("Selected Options Value : "+we.getText());

		System.out.println("FORTH PS - Deselect option  3 *****");
		selectDD.deselectByVisibleText("3");
		if(!driver.findElement(By.xpath("//select[@class='form-control']//option[3]")).isSelected()) 
			System.out.println("Option 3 deselected Succesfully");
		else
			System.out.println("Option 3 is still selected");
		System.out.println("FIFTH PS - Get First selected Option****");
		System.out.println("First Selected Option : "+selectDD.getAllSelectedOptions().get(0).getText());

		String lastSelected = "";
		for(WebElement we : selectedWEList) {
			lastSelected = we.getText();
		}

		System.out.println("Last Selected Option :"+lastSelected);

		System.out.println("SIXTH PS - Select All divisible by 2 ******");
		List<WebElement> listAllOptions = selectDD.getOptions();
		selectDD.deselectAll();
		for(WebElement weListItem : listAllOptions) {

			if(Integer.valueOf(weListItem.getText()) % 2 == 0) {
				selectDD.selectByVisibleText(weListItem.getText());

			}
			System.out.println(weListItem.getText() +" Selected Status :"+weListItem.isSelected());	
		}

		System.out.println("SEVENTH PS - Get all selected unselected and unselecetd Selected******");
		List<WebElement> allSelectedList = selectDD.getAllSelectedOptions();
		listAllOptions.removeAll(allSelectedList);
		selectDD.deselectAll();
		for(WebElement we : listAllOptions) {
			selectDD.selectByVisibleText(we.getText());
			//System.out.println(we.getText() +" Selected Status :"+we.isSelected());	
		}
		List<WebElement> finalList = selectDD.getOptions();
		for(WebElement fWE : finalList) {
			System.out.println(fWE.getText() +" Selected Status :"+fWE.isSelected());	
		}

		System.out.println("EIGHTH PS - Select Second Last******");
		selectDD.selectByIndex(finalList.size()-2);
		System.out.println(finalList.get(finalList.size()-2).getText()+ " Selected status : " +finalList.get(finalList.size()-2).isSelected());
		Thread.sleep(2000);
		driver.close();

	}
}
