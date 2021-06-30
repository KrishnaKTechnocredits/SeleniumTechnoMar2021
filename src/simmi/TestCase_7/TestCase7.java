package simmi.TestCase_7;

/*Test case : 7
rows and cols are dynamic, get the lastname of the emp whoes firstname is "Abhishek".*/

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase7 {

	static ArrayList<String> getLastName(WebDriver driver) {
		ArrayList<String> listName = new ArrayList<String>();
		List<WebElement> headElement = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		for (WebElement element : headElement) {
			listName.add(element.getText());
		}
		return listName;
	}

	static String getEmpDataByName(WebDriver driver, String name, int index) {
		return driver.findElement(By.xpath("//td[text()='" + name + "']//parent::tr/td[" + index + "]")).getText();

	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		ArrayList<String> listOfNames = getLastName(driver);
		int index = listOfNames.indexOf("Last Name") + 1;

		String lastName = getEmpDataByName(driver, "Abhishek", index);
		System.out.println("Last Name of the employee whose name Abhishek is " + lastName);

		driver.close();
	}
}
