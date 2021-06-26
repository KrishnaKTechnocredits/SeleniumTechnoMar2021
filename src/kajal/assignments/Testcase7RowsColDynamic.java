package kajal.assignments;

//rows and cols are dynamic, get the lastname of the emp whoes firstname is "Abhishek".

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase7RowsColDynamic {

	static ArrayList<String> getLastName(WebDriver driver) throws InterruptedException {
		System.out.println("rows and cols are dynamic, get the lastname of the emp whoes firstname is Abhishek");
		driver.findElement(By.id("demotable")).click();
		Thread.sleep(5000);
		ArrayList<String> list = new ArrayList<String>();
		List<WebElement> lastName = driver
				.findElements(By.xpath("//table[@id='table1']//td[text()='Abhishek']//following::td[1]"));

		for (WebElement temp : lastName) {
			list.add(temp.getText());
			System.out.println(list);
		}
		return list;
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		ArrayList<String> output = getLastName(driver);
		System.out.println(output);
		driver.close();
	}
}