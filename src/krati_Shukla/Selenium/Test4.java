package krati_Shukla.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test4 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/krachaturvedi/Documents/TechnoCredits/Selenium%20Notepad++/Krishna%20Requirement.html");
		driver.manage().window().maximize();
		validations(driver);
	}
	
	static void validations(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		// checking functionality of Visible button
		boolean visibleFlag = driver.findElement(By.xpath("//button[@id='visibleAndHidden']")).isEnabled();
		String visibleText = driver.findElement(By.xpath("//div[@id='myDIV']")).getText();
		System.out.println("Flag For button is : " +visibleFlag);
		if(visibleFlag)
			System.out.println("The text displayed is : "+visibleText);
		
		driver.findElement(By.xpath("//button[@id='visibleAndHidden']")).click();
		
		 // Entering details into NAME textbox & the disabling the textbox
		driver.findElement(By.xpath("//input[@id='myText']")).sendKeys("Krati");
		driver.findElement(By.xpath("//button[@id='enableAndDisable']")).click();
		boolean nameFlag = driver.findElement(By.xpath("//input[@id='myText']")).isEnabled();
		System.out.println("Name is textbox is : "+nameFlag);
		
	}

}
