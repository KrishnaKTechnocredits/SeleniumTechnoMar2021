package madhavi_Khasbage.Assignment_11;

import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import madhavi_Khasbage.base.PredefinedActions;

/*Test Case 11
program 1: How many Depts we have.
ans : 4
*/

public class TestCase11_1 {

	static void getTotalDepartment() throws InterruptedException {
	
		System.out.println("Step1:Open URL");
		WebDriver driver = PredefinedActions.setUp("http://automationbykrishna.com/#");
		
		System.out.println("Step2:Click on tab");
		driver.findElement(By.id("demotable")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));
		
		System.out.println("Step3:Get unique department");
		TreeSet<String> deptSet = new TreeSet<String>();
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']//tr")).size();

		for (int index = 1; index < totalRows; index++) {
			deptSet.add(driver.findElement(By.xpath("//table[@class='table table-striped']//tr[" + index + "]//td[5]"))
					.getText());
		}
		
		System.out.println("Total department count >> " + deptSet.size());		
		System.out.println("Step4:Close browser");
		driver.close();
	}	

	public static void main(String[] args) throws InterruptedException {
		TestCase11_1.getTotalDepartment();
	}
}
