package krati_Shukla.Selenium;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test5 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		driver.manage().window().maximize();
		multiPicklist(driver);
		driver.close();
	}
	
	static void multiPicklist(WebDriver driver) throws InterruptedException{
		
		//Select any day from dropdown
		WebElement element = driver.findElement(By.xpath("//select[@id='select-demo']"));
		Thread.sleep(5000);
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoViews", element);
		element.click();
		Select day = new Select(element); // Selecting the element from droplist
		day.selectByValue("Wednesday");
		element.click();
		
		//MultiPicklist
		WebElement multiElement = driver.findElement(By.xpath("//select[@id='multi-select']"));
		JavascriptExecutor je1 = (JavascriptExecutor)driver;
		je1.executeScript("arguments[0].scrollIntoViews", multiElement);
		Select multiSelect = new Select(multiElement);
		multiSelect.selectByValue("Florida");
		multiSelect.selectByValue("New Jersey");
		multiSelect.selectByValue("Ohio");
		
		//De-select all the selected options and select remaining option
		List<WebElement> list = multiSelect.getOptions();
		for(WebElement temp : list) {
			System.out.println(temp.getText());
			temp.click();
		}
	}
}
