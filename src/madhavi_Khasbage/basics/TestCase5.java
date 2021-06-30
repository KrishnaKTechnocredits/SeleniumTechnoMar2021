package madhavi_Khasbage.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import MadhaviKhasbage.basic.PredefinedActions;

/*String url= https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html';
1.open url on browser
2.Select any day from dropdown
3. select multiple values from multilist Demo 
4. deselect all the selected options and select remaining option
*/

public class TestCase5 {

	public static void main(String[] args) {
		System.out.println("STEP1:Open url on browser");
		String expectedURL = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
		WebDriver driver = PredefinedActions.setUp(expectedURL);
		
		System.out.println("STEP2:Select any day from dropdown");
		WebElement dayElement = driver.findElement(By.xpath("//select[@id='select-demo']"));
		Select dayDropDownElement = new Select(dayElement);
		dayDropDownElement.selectByVisibleText("Saturday");
		
		System.out.println("STEP2:Select multiple values from multilist Demo ");
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
