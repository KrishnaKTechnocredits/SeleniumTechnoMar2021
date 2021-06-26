package kajal.assignments;

//Name -> "Maulik", print lastName and UserName

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC10PrintLastNmUserNm {
	static void getLastName(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("demotable")).click();
		Thread.sleep(5000);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
		int countSize = rows.size();

		for (int index = 0; index < countSize; index++) {
			WebElement fName = driver
					.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + (index + 1) + "]//td[2]"));
			String firstName = fName.getText();
			System.out.println("First Name is :" + firstName);
			if (firstName.equals("Maulik")) {
				WebElement lName = driver
						.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + (index + 1) + "]//td[3]"));
				WebElement userName = driver
						.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + (index + 1) + "]//td[4]"));
				System.out.println("Last Name is :" + lName.getText());
				System.out.println("User Name is :" + userName.getText());
				break;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		getLastName(driver);
		driver.close();
	}

}