/*
 TC#1 - First Box
- Enter Fname, Lname and Company name.
- click submit.
- you should get alert; get that text and verify.

 */

package ami.Case_2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Case_1 {
	public static String fName = "jems";
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\LEARNING\\eclips java code\\SeleniumTechnoMar2021\\resources\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		String url ="http://automationbykrishna.com/";
		driver.get(url);
		driver.manage().window().maximize();
		
		System.out.println("Click on basic Element ");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(1000);
		
	 
		String lName = "patel";
		String cmpName = "software";
		
		System.out.println("Enter First Name:");
		//driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(fName);
		driver.findElement(By.id("UserFirstName")).sendKeys(fName);
		
		System.out.println("Enter Last Name:");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(lName);
		
		System.out.println("Enter Company Name:");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(cmpName);
		
		System.out.println("Click submit Button");
		driver.findElement(By.xpath("//*[@id=\"firstRow\"]/div[1]/section/div/div[4]/button")).click();
		
		System.out.println("Get Alert popup by Javascript");
		String alert = driver.switchTo().alert().getText();
		
		String expectedresult = fName + " and " + lName + " and " + cmpName;
		if(alert.equals(expectedresult)) {
			System.out.println("test pass");
		}else {
			System.out.println("test fail");
		}
			
		driver.switchTo().alert().accept();
		driver.close();
		
	}

}
