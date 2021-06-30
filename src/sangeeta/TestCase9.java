//verify username from table "EMPLOYEE BASIC INFORMATION"

package sangeeta;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase9 {
	
	static void verifyUserName() {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		List<WebElement> fNameElement = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
		List<WebElement> lNameElement = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		ArrayList<String> fName = new ArrayList<String>();
		ArrayList<String> lName = new ArrayList<String>();
		for(WebElement firstName : fNameElement) {
			fName.add(firstName.getText());
		}
		
		for(WebElement lastName : lNameElement) {
			lName.add(lastName.getText());
		}
		
		List<WebElement> userName = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
		ArrayList<String> actualUserName = new ArrayList<String>();
		for(WebElement uName : userName) {
			actualUserName.add(uName.getText());
		}
		ArrayList<String> expectedUsername = new ArrayList<String>();
		for(int index =0; index<fName.size(); index++) {
				expectedUsername.add(userName(fName.get(index).toLowerCase(), lName.get(index)));
		}
		uNameComparision(expectedUsername, actualUserName);
		
	}
	
	static String userName(String fName, String lName) {
			String uName = "";
			uName = fName.charAt(0) + lName.toLowerCase();
			return uName;
	}
	
	static void uNameComparision(ArrayList<String> expectedUsername, ArrayList<String> actualUserName) {
		for(int index = 0; index<expectedUsername.size(); index++) {
			if(expectedUsername.get(index).equals(actualUserName.get(index)))
				System.out.println("Expected user name "+expectedUsername.get(index)+" is equal to "+" actual user name "+actualUserName.get(index));
			else
				System.out.println("Expected user name "+expectedUsername.get(index)+" is not equal to "+" actual user name "+actualUserName.get(index));
		}
	}
	
	public static void main(String[] args) {
		verifyUserName();
	}

}
