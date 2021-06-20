package pallavi.assignment_10;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Test case : 10

Name -> "Maulik", print lastName and UserName*/
public class TestCase10 {

	static HashMap<String, String> getEmpDetails(WebDriver driver, String name) {
		HashMap<String, String> empDetail = new HashMap<String, String>();
		String empName = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr//td[text()='" + name + "']"))
				.getText();
		String lastname = driver
				.findElement(By.xpath(
						"//table[@id='table1']//tbody/tr//td[text()='" + empName + "']//following-sibling::td[1]"))
				.getText();
		String userName = driver
				.findElement(By.xpath(
						"//table[@id='table1']//tbody/tr//td[text()='" + empName + "']//following-sibling::td[2]"))
				.getText();
		empDetail.put(lastname, userName);
		return empDetail;
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("demotable")).click();
		HashMap<String, String> empdetails = getEmpDetails(driver, "Maulik");
		System.out.println(empdetails);
		driver.close();

	}

}
