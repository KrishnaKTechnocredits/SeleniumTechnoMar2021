package monika.TC_WindowHandle;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Window_Handling {
	
	private WebDriver driver;
	@Test
	void windowHandle() {
		driver = PredefinedActions.start("https://www.naukri.com/");
		String mainWindow = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		
		for(String childWindows : s) {
			if(!childWindows.equals(mainWindow)) {
				driver.switchTo().window(childWindows);
				System.out.println(driver.getTitle());
			}
		}
		driver.switchTo().window(mainWindow);
		driver.close();
		for(String childWindows : s) {
			if(!childWindows.equals(mainWindow)) {
				driver.switchTo().window(childWindows);
				driver.close();
			}
		}
	}
}
