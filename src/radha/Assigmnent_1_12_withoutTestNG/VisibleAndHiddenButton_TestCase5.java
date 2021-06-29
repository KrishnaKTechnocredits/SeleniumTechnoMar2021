package radha.Assigmnent_1_12_withoutTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VisibleAndHiddenButton_TestCase5 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Launch browser");
		System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("E:\\JAVA Selenium\\Selenium\\Krishna Requirement.html");
		driver.manage().window().maximize();
		boolean isVisible = driver.findElement(By.xpath("//button[@id='visibleAndHidden']")).isDisplayed();
		Thread.sleep(2000);
		System.out.println(isVisible);
		Thread.sleep(2000);
		boolean isvisible = driver.findElement(By.xpath("//div[@id='myDIV']")).isDisplayed();
		if(isvisible)
			System.out.println("Element is visible");
		else
			System.out.println("Element is hidden");
		driver.findElement(By.xpath("//button[@id='visibleAndHidden']")).click();
		Thread.sleep(2000);
		boolean isInVisible = driver.findElement(By.xpath("//div[@id='myDIV']")).isDisplayed();
		System.out.println(isInVisible);
		if(isInVisible)
			System.out.println("Element is visible");
		else
			System.out.println("Element is hidden");
		System.out.println("Close browser");
		driver.close();
	}
}
