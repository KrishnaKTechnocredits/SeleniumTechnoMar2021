package priyanka_Panat.TestCases1_13;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC5 {
	public static void main(String[] args) {
		System.out.println("STEP1:Open url on browser");
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		System.out.println("STEP2:Select any day from dropdown");
		WebElement dayElement = driver.findElement(By.xpath("//select[@id='select-demo']"));
		Select dayDropDownElement = new Select(dayElement);
		dayDropDownElement.selectByVisibleText("Friday");
		System.out.println("STEP3:Select multiple values from multilist Demo ");
		WebElement selectCity = driver.findElement(By.id("multi-select"));
		Select cityMultiDropDown = new Select(selectCity);
		System.out.println(cityMultiDropDown.isMultiple());
		cityMultiDropDown.selectByValue("California");
		cityMultiDropDown.selectByValue("New York");
		cityMultiDropDown.selectByValue("Ohio");
		cityMultiDropDown.selectByValue("Pennsylvania");
		cityMultiDropDown.selectByValue("Washington");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("STEP4: Deselect all the selected options and select remaining option");
		cityMultiDropDown.deselectAll();
		cityMultiDropDown.selectByValue("Florida");
		cityMultiDropDown.selectByValue("New Jersey");
		cityMultiDropDown.selectByValue("Texas");
		driver.close();
	}
}
