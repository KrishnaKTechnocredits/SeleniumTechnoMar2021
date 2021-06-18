package madhavi_Raut.Assignment_01_10.TestCase_10;
//Test case : 10 Name -> "Maulik", print lastName and UserName

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindLastNameUserName {

	void getLastNameUserName(String empName) {
		WebDriver driver = base.PredefinedActions.start("http://automationbykrishna.com");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("STEP - Fetching Employee Last Name and User Name");
		for (int index = 1; index <= rowCount; index++) {
			if ((driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]")).getText())
					.equals(empName)) {
				System.out.println("Employee Last name is: " + driver
						.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]")).getText());
				System.out.println("Employee User name is: " + driver
						.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]")).getText());
			}
		}
		System.out.println("STEP - Closing the browser");
		driver.close();
	}

	public static void main(String[] args) {
		new FindLastNameUserName().getLastNameUserName("Maulik");
	}
}
