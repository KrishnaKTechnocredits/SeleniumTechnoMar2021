package prachi.Assignment_1_to_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//Test case : 9 - verify username from table "EMPLOYEE BASIC INFORMATION"
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*Test case : 9
verify username from table "EMPLOYEE BASIC INFORMATION"

firstName
lastName
expectedUsername = "mkanani";
actualUserName = firstName.charAt(0) + lastName;
actualUserName = actualUserName.toLowerCase();
*/
public class Assignment_9 {
	void validateUserName() {
		WebDriver driver = base.PredefinedActions.start("http://automationbykrishna.com");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@id='table1']/thead/tr/th[text()='Last Name']")));
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("STEP - Verifying User Name");
		String empFname, empLname, empUserName;
		for (int index = 1; index <= rowCount; index++) {
			empFname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			empLname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
			empUserName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			if (empUserName.equals(empFname.substring(0, 1).toLowerCase() + empLname.toLowerCase())) {
				System.out.println(empFname + " " + empLname + "'s user name " + empUserName + " is correct.");
			} else {
				System.out.println(empFname + " " + empLname + "'s user name " + empUserName + " is incorrect.");
			}
		}
		System.out.println("STEP - Closing the browser");
		driver.close();
	}
	public static void main(String[] args){
		new Assignment_9().validateUserName();
	}
}
