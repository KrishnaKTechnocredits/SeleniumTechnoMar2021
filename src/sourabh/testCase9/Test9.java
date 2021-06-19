/*
Test case : 9

verify username from table "EMPLOYEE BASIC INFORMATION"

firstName
lastName
expectedUsername = "mkanani";
actualUserName = firstName.charAt(0) + lastName;
actualUserName = actualUserName.toLowerCase(); 
 */

package sourabh.testCase9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test9 {
	static void getVerifyUserName(WebDriver driver) {
		List<WebElement> listTR= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int countTR= listTR.size();
		String firstName, lastName, exceptedUserName = null, actualUserNameTemp,actualUserName = null; 
		for(int index=1; index<=countTR; index++ ) {
			firstName= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			lastName= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
			exceptedUserName= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			actualUserNameTemp= firstName.charAt(0)+lastName;
			actualUserName=actualUserNameTemp.toLowerCase();
			System.out.println(exceptedUserName);
			System.out.println(actualUserName);
			
		if(actualUserName.equals(exceptedUserName))
			System.out.println("UserName Matched!!");
		else
			System.out.println("UserName Not Matched!!");
		}
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
			getVerifyUserName(driver);
			
	}

}
