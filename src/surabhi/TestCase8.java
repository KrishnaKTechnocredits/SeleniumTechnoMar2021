package surabhi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * check text displayed when click on button. 
 * 
 * */

public class TestCase8 {
	
	void runTestCase1(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.NANOSECONDS);
		System.out.println(driver.findElement(By.xpath("//html/body/p")).isDisplayed());
		driver.close();
	}
	
	void runTestCase2(WebDriver driver) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		if(driver.findElement(By.xpath("//input[@id='myText']")).isEnabled()) {
			Thread.sleep(3000);
			WebElement element=driver.findElement(By.xpath("//input[@id='myText']"));
			element.sendKeys("Surabhi");
			System.out.println(element.getText().length());
		}
		driver.close();
	}
	
	void runTestCase3(WebDriver driver) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='enableAndDisable']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//input[@id='myText']")).isEnabled());
		driver.findElement(By.xpath("//button[@id='enableAndDisable']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@id='myText']")).isEnabled());
		driver.close();
	}
	
	static WebDriver setupUrl() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/Shreyash%20Atal/Desktop/surabhi/JavaSelenium_GIT_Workspace/Krishna%20Requirement.html");
		driver.manage().window().maximize();
		return driver;
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	 	WebDriver driver=setupUrl();
	 	TestCase8 testCase8=new TestCase8();
		
		//check if text/element displayed
	 	testCase8.runTestCase1(driver);
		
		WebDriver driver2=setupUrl();
		//check if input text area disabled once click on button
		testCase8.runTestCase3(driver2);
	}

}
