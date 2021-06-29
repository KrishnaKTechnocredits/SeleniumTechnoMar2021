/*
Test case : 10

Name -> "Maulik", print lastName and UserName
 */
package sourabh.testCase10;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test10AlternativeSolution {
	static HashMap<String, String> getLastNameAndUserNameWithOutLoop(WebDriver driver, String targetName){
		HashMap<String, String> empInfoMap= new HashMap<String, String>();

		String lastName= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[text()='"+targetName+"']/following-sibling::td[1]")).getText();
		String userName= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[text()='"+targetName+"']/following-sibling::td[2]")).getText();
		
		empInfoMap.put(lastName, userName);
		return empInfoMap; 
	}
	
	public static void main(String[] args) {
		System.out.println("Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		System.out.println("Open Url");
		String url= "http://automationbykrishna.com/";
		driver.get(url);
		driver.manage().window().maximize();
		//----------------------------------------------------------------------------------
		driver.findElement(By.linkText("Demo Tables")).click();
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));
		HashMap<String, String> output= getLastNameAndUserNameWithOutLoop(driver, "Maulik");
		System.out.println("FirstName : Maulik: "+output);
	}
}

