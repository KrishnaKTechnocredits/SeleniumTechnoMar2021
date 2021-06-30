/*
 2. validate enable button functionality click on button 
 and validate button is disable or not and vice versa
 */

package ami.Case_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class isEnableButton {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"E:\\LEARNING\\eclips java code\\SeleniumTechnoMar2021\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/mo/Downloads/Krishna%20Requirement.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//driver.findElement(By.id("enableAndDisable")).click();
		boolean isEnblButton = driver.findElement(By.id("enableAndDisable")).isEnabled();
		
		if(isEnblButton) {
			driver.findElement(By.id("myText")).sendKeys("Ami Lakkad");
		}else {
			System.out.println("button is disable");
			//exception when button disable ElementsNotInteractable
		}
		 	
		
	}
}