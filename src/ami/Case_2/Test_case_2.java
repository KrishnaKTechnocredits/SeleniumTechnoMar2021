/*
 TC#2 - Second Box
- Enter email
- Enter password
- verify message "You successfully clicked on it"
 */

package ami.Case_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_case_2 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\LEARNING\\eclips java code\\SeleniumTechnoMar2021\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url ="http://automationbykrishna.com/";
		driver.get(url);
		driver.manage().window().maximize();
		
		System.out.println("Click on basic Element ");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		System.out.println("Enter Email");
		driver.findElement(By.xpath("//*[@id='exampleInputEmail1']")).sendKeys("Xyz@gmail.com");
		
		System.out.println("Enter Password");
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys("xyzquew");
		
		System.out.println("Click on button");
		driver.findElement(By.xpath("//*[@id=\"submitb2\"]")).click();
		
		System.out.println("verify Message");
		String expectResult = "You successfully clicked on it";
		String actualResult = driver.switchTo().alert().getText();
		if(expectResult.equals(actualResult)) {
				System.out.println("Test pass");
				driver.switchTo().alert().accept();
				driver.close();
		}else {
			System.out.println("Test Fail");
		}	
		
	}

}
