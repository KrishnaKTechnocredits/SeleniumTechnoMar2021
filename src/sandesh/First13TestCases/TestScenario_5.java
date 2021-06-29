/*
 Take any website and practice for multi drop down
 */

package sandesh.First13TestCases;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestScenario_5 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'This is Maulik')]")));

		driver.findElement(By.id("basicelements")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true)",
				driver.findElement(By.xpath("//select[@class='form-control']")));
		Select select = new Select(driver.findElement(By.xpath("//select[@class='form-control m-bot15']")));
		List<WebElement> listOfOptions = select.getOptions();
		Iterator<WebElement> itr = listOfOptions.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().getText());
		}
	}
}
