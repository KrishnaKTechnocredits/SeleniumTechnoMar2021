package trupti.assignment6;
//Print Employee Start date whose age is 66.
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmpStartDate {
		public static void main(String[] args) {
			System.out.println("Step 1 - Launch a chrome");
			System.setProperty("webdriver.chrome.driver", "..\\SeleniumTechnoMar2021\\resources\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Step 2 - Open Focus.html ");
			driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
			WebDriverWait wait=new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='example']")));
			WebElement element=driver.findElement(By.xpath("//table[@id='example']//tfoot/tr/th[1]"));
			JavascriptExecutor je=(JavascriptExecutor)driver;
			je.executeScript("arguments[0].scrollIntoView(true)",element);
			List<WebElement> elements=driver.findElements(By.xpath("//table[@id='example']//td[text()='66']//parent::tr/td[5]"));
			for(WebElement e : elements) {
				System.out.println(e.getText());
				
			}
			driver.close();
		}

	}
