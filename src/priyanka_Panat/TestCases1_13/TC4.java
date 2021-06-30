package priyanka_Panat.TestCases1_13;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC4 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\Priyanka Panat\\Downloads\\Krishna Requirement.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("STEP - TO Verify whether text box is visible or not ");
		driver.findElement(By.xpath("//input[@id='myText']")).sendKeys("Testing isEnabled");
		driver.findElement(By.xpath("//button[@id='enableAndDisable']")).click();
		boolean btnFlag = driver.findElement(By.xpath("//input[@id='myText']")).isEnabled();
		if (!btnFlag)
			System.out.println("PASS -Text box is disabled");
		else
			System.out.println("FAIL - Text box is enabled");

		System.out.println("STEP: Verifying visible button functionality by clicking on the Visible & Hidden Button");
		driver.findElement(By.xpath("//button[@id='visibleAndHidden']")).click();
		boolean flag = driver.findElement(By.xpath("//div[@id='myDIV']")).isDisplayed();
		if (!flag)
			System.out.println("PASS");
		else
			System.out.println("FAIL");

		driver.findElement(By.xpath("//button[@id='visibleAndHidden']")).click();
		boolean flag1 = driver.findElement(By.xpath("//div[@id='myDIV']")).isDisplayed();
		if (flag1)
			System.out.println("PASS-Block is not visible");
		else
			System.out.println("FAIL-Block is visible");
		driver.close();

	}
}
