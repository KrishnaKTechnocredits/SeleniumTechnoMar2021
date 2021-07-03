package madhavi_Khasbage.Assignment_14;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import madhavi_Khasbage.base.PredefinedActions;

/*String url= https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html';
1.open url on browser
2.Select any day from dropdown
3. select multiple values from multilist Demo 
4. deselect all the selected options and select remaining option
*/

public class TestCase5 {
	
	WebDriver driver;
	String expectedURL;
	
	@BeforeTest
	void setUp() {
		System.out.println("STEP1:Launch browser");
		expectedURL = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
		driver = PredefinedActions.setUp(expectedURL);
		driver.manage().window().maximize();
	}

	@AfterTest
	void tearDown() {
		System.out.println("Step5: Close browser");
		driver.close();
	}

	@Test
	public void verifyDropDown() {		
		
		System.out.println("STEP2:Select any day from dropdown");
		WebElement dayElement = driver.findElement(By.xpath("//select[@id='select-demo']"));
		Select dayDropDownElement = new Select(dayElement);
		dayDropDownElement.selectByVisibleText("Saturday");
		
		System.out.println("STEP3:Select multiple values from multilist Demo ");
		WebElement selectCity = driver.findElement(By.id("multi-select"));
		Select cityMultiDropDown = new Select(selectCity);
		System.out.println(cityMultiDropDown.isMultiple());
		cityMultiDropDown.selectByValue("Florida");
		cityMultiDropDown.selectByValue("Ohio");
		cityMultiDropDown.selectByValue("Texas");
		cityMultiDropDown.selectByValue("Pennsylvania");
		cityMultiDropDown.selectByValue("Washington");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		System.out.println("STEP4:Deselect all the selected options and select remaining option");
		cityMultiDropDown.deselectAll();
		cityMultiDropDown.selectByValue("California");
		cityMultiDropDown.selectByValue("New Jersey");
		cityMultiDropDown.selectByValue("New York");
	}
}
