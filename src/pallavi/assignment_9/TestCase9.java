package pallavi.assignment_9;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase9 {

	static void getusername(WebDriver driver) {
		int size = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr")).size();
		for (int index = 1; index <= size; index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + index + "]/td[2]"))
					.getText();
			String LastName = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + index + "]/td[3]"))
					.getText();
			String expectedusername = driver
					.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + index + "]/td[4]")).getText();
			String actualUsername = firstName.charAt(0) + LastName;
			actualUsername = actualUsername.toLowerCase();
			if (actualUsername.equals(expectedusername))
				System.out.println(firstName + "  : " + LastName + " and " + actualUsername + " is correct");
			else
				System.out.println(firstName + "  : " + LastName + " and " + actualUsername + " is  not correct");

		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("demotable")).click();
		getusername(driver);
		driver.close();
	}

}
