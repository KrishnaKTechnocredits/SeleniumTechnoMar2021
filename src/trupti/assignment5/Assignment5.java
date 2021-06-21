package trupti.assignment5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Assignment5 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Step 1 - Launch a chrome");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Step 2 - Open automationbykrishna.com ");
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		System.out.println("Step 3- Select option from dropdown");
		System.out.println("===============================");
		WebElement element= driver.findElement(By.xpath("//select[@class='form-control m-bot15']"));
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",element);
		Select select=new Select(element);
		select.selectByIndex(3);
		
		System.out.println("The day selected from dropdown is "+ select.getFirstSelectedOption().getText()); 
		System.out.println("===============================");
		WebElement element1= driver.findElement(By.xpath("//select[@class='form-control']"));
		Select select1=new Select(element1);
		
		Actions action = new Actions(driver);
		if(select1.isMultiple()) {
			System.out.println("Step 4 - Multiselect option");
			System.out.println("===============================");
			
			List <WebElement> list1=select1.getOptions();
			for (WebElement e:list1) {
				System.out.println(e.getText());
				if(Integer.parseInt(e.getText()) % 2 == 0 ) {
					select1.selectByVisibleText(e.getText());
				}
			}
			
			Thread.sleep(2000);
			System.out.println("Step 5 - Multiselect option - list1 => select, list2 => deSelect");
			System.out.println("===============================");
			List <WebElement> list2=select1.getAllSelectedOptions();
			list1.removeAll(list2);
			
			//For loop to deSelect elements from list2
			for (WebElement e:list2) {
				select1.deselectByVisibleText(e.getText());
			}
			
			//For loop to select elements from list1
			for (WebElement e:list1) {;
				select1.selectByVisibleText(e.getText());
			}	
			
		}
		
		Thread.sleep(2000);
		driver.close();
	}

}
