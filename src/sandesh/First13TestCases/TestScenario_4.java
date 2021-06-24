/*
1. validate visible button functionality click on button and validate button is displayed or not and vice versa
2. validate enable button functionality click on button and validate button is disable or not and vice versa
3. validate isSelected on automationbykrishna's registration page if male radio button is selected then click on female

Note: 1 & 2 perform on HTML which is shared*/

package sandesh.First13TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestScenario_4 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"file:///C:/Users/Sandesh/Downloads/TechnoCredits_Material/Recordings/SELENIUM/Krishna%20Requirement.html");
		// input[@id='myText']
		// p[text()=' TECHNOCREDITS']
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=' TECHNOCREDITS']")));

		if (driver.findElement(By.id("myText")).isEnabled()) {
			driver.findElement(By.id("enableAndDisable")).click();
			if (!driver.findElement(By.id("myText")).isEnabled()) {
				System.out.println("Enable disable Test Passed");
			}
		} else
			System.out.println("The input field is disabled");

		if (driver.findElement(By.xpath("//div[contains(text(),'This is TECHNOCREDITS')]")).isDisplayed()) {
			driver.findElement(By.id("visibleAndHidden")).click();
			System.out.println("Now the Banner will be hidden");
			if (!driver.findElement(By.xpath("//div[contains(text(),'This is TECHNOCREDITS')]")).isDisplayed()) {
				System.out.println("The Banner is not displayed now");
			}
		} else
			System.out.println("The Banner is not displayed");
	}
}
