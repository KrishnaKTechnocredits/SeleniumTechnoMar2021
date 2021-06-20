package pallavi.assignment_7;

import java.util.ArrayList;
import java.util.List;
/*Test case : 7
rows and cols are dynamic, get the lastname of the emp whoes firstname is "Abhishek".*/
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase7 {

	static ArrayList<String> getColList(WebDriver driver) {
		ArrayList<String> headerList = new ArrayList<String>();
		List<WebElement> headElmentList = driver.findElements(By.xpath("//div[@id='empbasic']//tr/th"));
		for (WebElement element : headElmentList) {
			headerList.add(element.getText());
		}
		return headerList;
	}

	static String getEmpLastName(WebDriver driver, String name, int index) {
		String lastname = driver.findElement(By.xpath("//td[text()='" + name + "']//parent::tr/td[" + index + "]"))
				.getText();
		return lastname;

	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("demotable")).click();

		ArrayList<String> headerList = getColList(driver);
		int index = headerList.indexOf("Last Name") + 1;

		String LastName = getEmpLastName(driver, "Abhishek", index);
		System.out.println(LastName);
		driver.close();

	}

}
