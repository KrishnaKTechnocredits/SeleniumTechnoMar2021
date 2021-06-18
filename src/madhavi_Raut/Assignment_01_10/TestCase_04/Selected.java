package madhavi_Raut.Assignment_01_10.TestCase_04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//3. validate isSelected on automationbykrishna's registration page if male radio button is selected 
//then click on female
public class Selected {

	void isSelected() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("registration2")).click();
		// wait
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("unameSignin"))));
		driver.findElement(By.id("radio-02")).click();
		System.out.println("STEP - To Verify which radio button is selected");
		if (driver.findElement(By.id("radio-02")).isSelected()) {
			System.out.println("Female radio button is selected.");
		} else {
			System.out.println("Male radio button is selected.");
		}
		driver.close();
	}

	public static void main(String[] args) {
		new Selected().isSelected();
	}
}
