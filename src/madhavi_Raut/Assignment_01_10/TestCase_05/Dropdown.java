package madhavi_Raut.Assignment_01_10.TestCase_05;
/*Test Case 6 :
String url= https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html';
1.open url on browser
2.Select any day from dropdown
3. select multiple values from multilist Demo 
4. deselect all the selected options and select remaining option*/

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
	void dropdown() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		driver.manage().window().maximize();
		//Single Selection
		Select selectSingle = new Select(driver.findElement(By.id("select-demo")));
		selectSingle.selectByValue("Monday");
		//Multiple selection
		Select multipleSelection = new Select(driver.findElement(By.xpath("//select[@name='States']")));
		System.out.println("STEP - Selecting Ohio and Florida states");
		multipleSelection.selectByValue("Ohio");
		multipleSelection.selectByValue("Florida");
		System.out.println("STEP - Fetching selected states list");
		List<WebElement> listOfSelectedStates=multipleSelection.getAllSelectedOptions();
		System.out.println("STEP - Fetching All states list");
		List<WebElement> listOfAllStates=multipleSelection.getOptions();
		System.out.println("STEP - Selecting non-seleccted states");
		listOfAllStates.removeAll(listOfSelectedStates);
		multipleSelection.deselectAll();
		for(WebElement state: listOfAllStates) {
			multipleSelection.selectByValue(state.getText());
		}
		List<WebElement> selectedoptions = multipleSelection.getAllSelectedOptions();
		ArrayList<String> selectedStateList = new ArrayList<String>() ;
		for(WebElement states: selectedoptions) {
			selectedStateList.add(states.getText());
		}
		System.out.println("Selected non-selected states are: "+selectedStateList);
		System.out.println("STEP - Closing the browser");
		driver.close();
	}
	public static void main(String[] args) {
		new Dropdown().dropdown();
	}
}
