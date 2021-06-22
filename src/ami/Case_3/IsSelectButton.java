/*
 3. validate isSelected on automationbykrishna's registration page if male radio
  button is selected then click on female
 */

package ami.Case_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsSelectButton {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"E:\\LEARNING\\eclips java code\\SeleniumTechnoMar2021\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("registration2")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		
		
		//input[@id='radio-02'] - female 
		//input[@id='radio-01'] - male
		
		//driver.findElement(By.xpath("//input[@id='radio-02']")).click();
		
		boolean isSelectMaleRadioButton = driver.findElement(By.xpath("//input[@id='radio-01']")).isSelected();
		System.out.println(isSelectMaleRadioButton);
		//female select
		
		if(isSelectMaleRadioButton) {
			driver.findElement(By.xpath("//input[@id='radio-02']")).click();
		}else {
			driver.findElement(By.xpath("//input[@id='radio-01']")).click();
		}
		
	}

}
