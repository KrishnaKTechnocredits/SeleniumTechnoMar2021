/*
 * Test case : 7
 * rows and cols are dynamic, get the lastname of the emp whose firstname is "Abhishek".
 */

package sandesh.First13TestCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScenario_7 {

	private ArrayList<String> getLastNameIndex(WebDriver dr) {
		dr.get("http://automationbykrishna.com/index.html#");
		dr.findElement(By.id("demotable")).click();
		ArrayList<String> listOfHeaders = new ArrayList<String>();
		List<WebElement> headersList = dr.findElements(By.xpath("//table[@id='table1']//th"));
		for (WebElement wl : headersList) {
			listOfHeaders.add(wl.getText());
		}
		return listOfHeaders;
	}

	private String getLastName(WebDriver dr, String firstName, int index) {
		return dr.findElement(By.xpath("//table[@id='table1']//td[text()='Abhishek']//parent::tr/td[" + index + "]"))
				.getText();
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		ArrayList<String> headersList = new TestScenario_7().getLastNameIndex(driver);
		int indexOfLastName = headersList.indexOf("Last Name");
		System.out.println("Last name of employee whose first name is Abhishek is -: ");
		System.out.println(new TestScenario_7().getLastName(driver, "Abhishek", indexOfLastName + 1));
	}
}
