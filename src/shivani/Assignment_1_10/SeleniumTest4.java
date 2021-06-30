package shivani.Assignment_1_10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;

/*TC#3
click Alert button
Verify - "You must be TechnoCredits student"
*/

public class SeleniumTest4 {
	
 public static void main(String[] args) throws InterruptedException {
	 System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
	 
	 WebDriver driver = new ChromeDriver();
	 driver.get("http://automationbykrishna.com/");
	 driver.manage().window().fullscreen();
	 System.out.println("click on basic Element");
	 driver.findElement(By.xpath("//a[@id='basicelements']")).click();
	 Thread.sleep(1000);
	 System.out.println("Click on alert");
	 driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
	 Alert alert=driver.switchTo().alert();
	 String alterMessage = alert.getText();
	 String ExpectedAlertMessage ="You must be TechnoCredits student!!";
	 if(alterMessage.equals(ExpectedAlertMessage)) {
		 System.out.println("Test Pass");
	 }
	 else
		 System.out.println("Test Fail");
	 
	 driver.close();
			 
}

}
