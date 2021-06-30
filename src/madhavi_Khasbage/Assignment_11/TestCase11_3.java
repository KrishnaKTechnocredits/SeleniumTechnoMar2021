package madhavi_Khasbage.Assignment_11;

import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MadhaviKhasbage.basic.PredefinedActions;

/*program 3: how many employees we have.
ans : 8
*/

public class TestCase11_3 {
static void getTotalEmployee() throws InterruptedException {
		
		System.out.println("Step1:Open URL");
		WebDriver driver = PredefinedActions.setUp("http://automationbykrishna.com/#");
		
		System.out.println("Step2:Click on tab");
		driver.findElement(By.id("demotable")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));
		
		System.out.println("Step3:Get unique employee");
		TreeSet<String> empSet = new TreeSet<String>();
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']//tr")).size();

		for (int index = 1; index < totalRows; index++) {
			empSet.add(driver.findElement(By.xpath("//table[@class='table table-striped']//tr[" + index + "]//td[2]"))
					.getText());
		}
		
		System.out.println("Total employee count >> " + empSet.size());		
		System.out.println("Step4:Close browser");
		driver.close();
	}	

	public static void main(String[] args) throws InterruptedException {
		TestCase11_3.getTotalEmployee();
	}
}
