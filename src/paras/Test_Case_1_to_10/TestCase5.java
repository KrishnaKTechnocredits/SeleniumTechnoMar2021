package paras.Test_Case_1_to_10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase5 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\TechnoCredits\\Softwares\\Selenium Software/chromedriver.exe");
		// Launch Chrome Browser
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//select[@class='form-control']")));
		
		WebElement multipleSelectDrodown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropDown = new Select(multipleSelectDrodown);
		System.out.println("\nTest Case - 1");
		System.out.println("\nTotal Available Options in Dropdown :"+dropDown.getOptions().size());
		
		System.out.println("\nTest Case - 2");
		dropDown.selectByIndex(2);
		dropDown.selectByIndex(3);
		System.out.println("Index Select Successfully - Test Pass");
		
		System.out.println("\nTest Case - 3");
		
		List<WebElement> listOfOptions = dropDown.getAllSelectedOptions();
		System.out.println("Total Selected Options : "+listOfOptions.size());
		for(WebElement element : listOfOptions) 
			System.out.println("Selected Options Value : "+element.getText());
		
		System.out.println("\nTest Case - 4");
		
		dropDown.deselectByIndex(3);
		System.out.println("element de-selected having text 3");
		
		System.out.println("\nTest Case - 5");
		
		System.out.println("First Selected Option in dropdown : "+dropDown.getAllSelectedOptions().get(0).getText());

		String lastSelected = "";
		for(WebElement element1 : listOfOptions) {
			lastSelected = element1.getText();
		}

		System.out.println("Last Selected Option :"+lastSelected);
		
		System.out.println("\nTest Case - 6");
		List<WebElement> listAllElements = dropDown.getOptions();
		dropDown.deselectAll();
		for(WebElement element : listAllElements) {

			if(Integer.valueOf(element.getText()) % 2 == 0) {
				dropDown.selectByVisibleText(element.getText());

			}
			System.out.println(element.getText() +" Selected Status :"+element.isSelected());	
		}

		System.out.println("\nTest Case - 7");
		List<WebElement> allSelectedList = dropDown.getAllSelectedOptions();
		listAllElements.removeAll(allSelectedList);
		dropDown.deselectAll();
		for(WebElement we : listAllElements) {
			dropDown.selectByVisibleText(we.getText());
			//System.out.println(we.getText() +" Selected Status :"+we.isSelected());	
		}
		List<WebElement> finalList = dropDown.getOptions();
		for(WebElement element : finalList) {
			System.out.println(element.getText() +" Selected Status :"+element.isSelected());	
		}

		System.out.println("\nTest Case - 8");
		dropDown.selectByIndex(finalList.size()-2);
		System.out.println(finalList.get(finalList.size()-2).getText()+ " Selected status : " +finalList.get(finalList.size()-2).isSelected());
		Thread.sleep(2000);
		driver.close();
	}
}