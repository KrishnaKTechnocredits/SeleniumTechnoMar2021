package madhavi_Raut.Assignment_01_10.TestCase_07;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*Test case : 7
rows and cols are dynamic, get the lastname of the emp whoes firstname is "Abhishek".*/
public class FindNameFromDynamicTable {

	void getLastName(String name) {
		WebDriver driver;
		driver = base.PredefinedActions.start("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		ArrayList<String> headerList = new ArrayList<String>();
		List<WebElement> listHeader = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		for (WebElement colHeading : listHeader) {
			headerList.add(colHeading.getText());
		}
		int index = 0;
		System.out.println("STEP-Getting column num of Last Name");
		for (String header : headerList) {
			if (header.equals("Last Name")) {
				index = headerList.indexOf(header);
				index++;
				break;
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@id='table1']/thead/tr/th[text()='Last Name']")));
		System.out.println("STEP - Getting Last Name of "+name);
		String lastName = driver
				.findElement(By.xpath(
						"//table[@id='table1']/tbody/tr/td[text()='" + name + "']//parent::tr/td[" + index + "]"))
				.getText();
		System.out.println("Last Name of " + name + " is " + lastName);
		driver.close();
	}

	public static void main(String[] args) {
		new FindNameFromDynamicTable().getLastName("Abhishek");
	}
}
