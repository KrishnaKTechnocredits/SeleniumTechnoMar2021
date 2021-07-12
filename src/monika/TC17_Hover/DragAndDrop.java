package monika.TC17_Hover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class DragAndDrop {

	@Test
	public void drag() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = PredefinedActions.start("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
		Actions a = new Actions(driver);
	//	Thread.sleep(3000);
		//a.clickAndHold(driver.findElement(By.xpath("//span[text()='Draggable 1']")))
		int x = driver.findElement(By.id("mydropzone")).getLocation().x;
		int y = driver.findElement(By.id("mydropzone")).getLocation().y;
		a.dragAndDropBy(driver.findElement(By.xpath("//span[text()='Draggable 1']")),x,y).build().perform();

		//a.contextClick(target)
	//	Thread.sleep(3000);
		Assert.assertTrue(
				driver.findElement(By.xpath("//div[@id='droppedlist']/span[text()='Draggable 1']")).isDisplayed());

	}

}
