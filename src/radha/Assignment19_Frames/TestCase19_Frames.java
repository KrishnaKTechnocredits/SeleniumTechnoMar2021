package radha.Assignment19_Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class TestCase19_Frames {
WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver = PredefinedActions.start("http://demo.automationtesting.in/Frames.html");
	}
	
	@BeforeClass
	public void frameCount() {
		//STEP- Find no of Frames
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("singleframe")));
		int noOFFrames = driver.findElements(By.xpath("//iframe")).size();
		System.out.println("No of frames in the page- "+noOFFrames);
	}
	
	@Test(priority=-1)
	public void switchToSingleFrame() {
		//STEP- Switch to single frame
		driver.switchTo().frame(driver.findElement(By.id("singleframe")));
		//STEP- Send value to text box
		WebElement text = driver.findElement(By.xpath("//input[@type='text']"));
		text.sendKeys("Radha");
		driver.switchTo().defaultContent();
		Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Automation Demo Site","Switch back to main page");
	}
	
	@Test
	public void switchToMultipleFrames() {
		//STEP- Go to multiple frames
		driver.findElement(By.linkText("Iframe with in an Iframe")).click();
		//STEP- Switch to inner frames
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='Multiple']/iframe")));
		driver.switchTo().frame(element);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Saoji");
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Automation Demo Site","Switch back to main page");
	}
	
	@AfterTest
	public void tearDown() {
		PredefinedActions.tearDown();
	}
}
