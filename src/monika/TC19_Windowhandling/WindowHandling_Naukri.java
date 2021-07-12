package monika.TC19_Windowhandling;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class WindowHandling_Naukri {
	private WebDriver driver;
	@Test
	void windowHandling() {
		driver = PredefinedActions.start("https://www.naukri.com/");
		System.out.println(driver.getWindowHandles().size());
		
	}

}
