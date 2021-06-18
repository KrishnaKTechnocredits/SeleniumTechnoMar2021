package shivani.Assignment_1_10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//TC#5
//JS Prompt
//- click JS Prompt
//- switch to alert
//- enter name
//- from the message verify that "given name" is present
public class SeleniumTest6 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 driver.get("http://automationbykrishna.com/");
		 driver.manage().window().fullscreen();
		 System.out.println("click on basic Element");
		 driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		 Thread.sleep(1000);
		 System.out.println("Click on Js Prompt");
		 driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		 Alert alert=driver.switchTo().alert();
		 Thread.sleep(1000);
		 //String alterMessage=alert.getText();
		 String name="Shivani";
		 
		alert.sendKeys(name);
		// alterMessage=alert.getText();
		System.out.println("verify Text contain given name");
		
		alert.accept();
		
		 //String ExpectedAlertMessage ="Hello shivani! How are you today?";
		 if(driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText().contains(name)) 
			 System.out.println("Test Pass");
		 
		 else
			 System.out.println("Test Fail");
		 driver.close();
	}

}
