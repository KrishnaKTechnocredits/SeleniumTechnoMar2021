package madhavi_Khasbage.Assignment_11;

import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import madhavi_Khasbage.basic.PredefinedActions;

/*Test Case 11
program 2 : how many managers we have.
ans : 3
*/
public class TestCase11_2 {
	static void getTotalManager() throws InterruptedException {
		
		System.out.println("Step1:Open URL");
		WebDriver driver = PredefinedActions.setUp("http://automationbykrishna.com/#");
		
		System.out.println("Step2:Click on tab");
		driver.findElement(By.id("demotable")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));
		
		System.out.println("Step3:Get unique manager");
		TreeSet<String> managerSet = new TreeSet<String>();
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']//tr")).size();

		for (int index = 1; index < totalRows; index++) {
			managerSet.add(driver.findElement(By.xpath("//table[@class='table table-striped']//tr[" + index + "]//td[4]"))
					.getText());
		}
		
		System.out.println("Total manager count >> " + managerSet.size());		
		System.out.println("Step4:Close browser");
		driver.close();
	}	

	public static void main(String[] args) throws InterruptedException {
		TestCase11_2.getTotalManager();
	}
}
