/*TC#2 - Second Box
- Enter email
- Enter password
- verify message "You successfully clicked on it"*/

package sangeeta;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase4 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://automationbykrishna.com/";
		driver.get(url);
		Thread.sleep(5000);
		
		System.out.println("STEP 1 :- Click on Basic Element link");
		WebElement element = driver.findElement(By.xpath("//*[@id='basicelements']"));
		element.click();
		Thread.sleep(2000);
		
		System.out.println("Step2:- Enter Email ID");
		WebElement emailID = driver.findElement(By.xpath("//*[@name='emailId']"));
		emailID.sendKeys("sangita.bhandarkar@yahoo.in");
		
		System.out.println("Step3:- Enter Password");
		WebElement password = driver.findElement(By.xpath("//*[@id='pwd']"));
		password.sendKeys("sangeeta@999");
		System.out.println("Step3:- Enter submit");
		WebElement element1 = driver.findElement(By.xpath("//button[@id='submitb2']"));
		element1.click();
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	} 
}
