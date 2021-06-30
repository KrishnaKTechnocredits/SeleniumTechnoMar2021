package amrutaM.testcases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import amrutaM.base.PredefinedActions;

/*Test case : 10
  Name -> "Maulik", print lastName and UserName
*/
public class TC10_PrintLastnameUsername {
	
	ArrayList<String> getEmployeeInfo(WebDriver driver , String empName) {
		System.out.println("Searing for First Name as Maulik");
		String lastname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[text()='"+empName+"']//following-sibling::td[1]")).getText();
		String username = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[text()='"+empName+"']//following-sibling::td[2]")).getText();
		ArrayList<String> empDetailsList = new ArrayList<String>();
		empDetailsList.add(lastname);
		empDetailsList.add(username);
		return empDetailsList;
	
	}
	public static void main(String[] args) {
		TC10_PrintLastnameUsername tc10_PrintLastnameUsername = new TC10_PrintLastnameUsername();
		WebDriver driver = PredefinedActions.setUp();
		System.out.println("Navigating to Demo Tables");
		driver.findElement(By.linkText("Demo Tables")).click();
		System.out.println("Waiting for thre table to be visible ");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));
		ArrayList<String> empData = tc10_PrintLastnameUsername.getEmployeeInfo(driver, "Maulik");
		System.out.println("Last name and Username of Maulik is --> "+empData);
		PredefinedActions.tearDown();
	}
}
