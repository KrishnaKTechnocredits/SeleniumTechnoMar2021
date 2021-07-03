package madhavi_Khasbage.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import madhavi_Khasbage.Assignment_12.PredefinedActions;

/*Name -> "Maulik", print lastName and UserName*/

public class TestCase10 {

	void printName(String name) {
		System.out.println("STEP1: Open url on browser");
		String expectedURL = "http://automationbykrishna.com/";
		WebDriver driver = PredefinedActions.setUp(expectedURL);
		driver.findElement(By.id("demotable")).click();

		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']")));

		System.out.println("STEP2: Find table");
		List<WebElement> element = driver.findElements(By.xpath("//table[@id='table1']//tr"));

		int totalRows = element.size();

		System.out.println("STEP3: Find " + name + " Firstname and Username");

		for (int index = 1; index < totalRows; index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();

			if (firstName.equals("Maulik")) {
				String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
						.getText();

				String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
						.getText();

				System.out.println("Maulik's Last name= " + lastName + " and User name = " + userName);
			}
		}
		
		System.out.println("STEP4: Close browser");
		driver.close();

	}

	public static void main(String[] args) {
		new TestCase10().printName("Maulik");
	}
}
