package radha.Assigmnent_1_12_withoutTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;

public class VerifyUserName_TestCase9 {
	
	void verifyUserName(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 4);
		int size = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index=1;index<=size;index++) {
			String fName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			String lName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]//following-sibling::td")).getText();
			String expectedUName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]//following-sibling::td[2]")).getText();
			String actualUName= fName.toLowerCase().charAt(0)+lName.toLowerCase();
			if(expectedUName.equals(actualUName))
				System.out.println(expectedUName+ " - UserName is correct");
			else 
				System.out.println("UserName should be - "+expectedUName);
		}
	}
	
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		VerifyUserName_TestCase9 user = new VerifyUserName_TestCase9();
		user.verifyUserName(driver);
		driver.close();
	}

}
