package monika.TC5;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class TestCase5_2_MuliSelectDD {
	
	@Test
	static void operationsOnMultiSelectDD() {
		WebDriver driver = PredefinedActions.start("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		WebElement ddElement = driver.findElement(By.xpath("//select[@name='States']"));
		Select select = new Select(ddElement);
		List<WebElement> listOfElements = select.getOptions();
		System.out.println(listOfElements.size());
		for(WebElement allCities :listOfElements) {
			String nameofAllCities = allCities.getText();
			System.out.println(nameofAllCities);
		}
		
		select.selectByValue("Pennsylvania");
		select.selectByValue("New York");
		select.selectByValue("Texas");
		select.selectByValue("Washington");
		select.selectByValue("Ohio");
		
		List<WebElement> selectedList = select.getAllSelectedOptions();
		System.out.println(select.getAllSelectedOptions().size());
		for(WebElement e : selectedList) {
			String nameofCities = e.getText();
			System.out.println(nameofCities);
		}
		select.deselectByVisibleText("Washington");
		
	//	System.out.println(select.getFirstSelectedOption().getText());
		List<WebElement> ls = select.getAllSelectedOptions();
		System.out.println("After deselect Was: ");
		String lastCity = select.getAllSelectedOptions().get(ls.size()-1).getText();
		System.out.println(lastCity);
		
		driver.close();
	}

}
