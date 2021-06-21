package trupti.assignment6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalEntry {

	public static void main(String[] args) {
		System.out.println("Step 1 - Launch a chrome");
		System.setProperty("webdriver.chrome.driver", "..\\SeleniumTechnoMar2021\\resources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Step 2 - Open Focus.html ");
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebElement element=driver.findElement(By.xpath("//div[@id='example_info']"));
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",element);
		String textMsg=element.getText();
		String [] arr=textMsg.split(" ");
		int row =Integer.parseInt(arr[arr.length-2]);
		System.out.println("Total No.of rows "+row);

	}

}
