package upasana.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;

public class TestCase3_4 {
	public static void main(String[] args) throws InterruptedException {

		String alertMsgExpectedOk = "You pressed OK!";
		String alertMsgExpectedCancel = "You pressed Cancel!";

		System.out.println("Step 1: Launch a chrome");
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); // Maximize window

		System.out.println("Step 2: Open Google.com");
		driver.get("https://google.com/");

		System.out.println("Step 3: navigate to \"http://automationbykrishna.com\"");
		driver.navigate().to("http://automationbykrishna.com");

		driver.manage().window().maximize();

		System.out.println("Step 4: Click on BasicElements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(2000);

		System.out.println("Step 5: Click on Javascript Confirmation tab");
		driver.findElement(By.xpath("//button[@id = 'javascriptConfirmBox']")).click();

		System.out.println("Step 6: Switch to Alert and Press OK or Cancel to proceed ");
		Alert alert = driver.switchTo().alert();

		alert.accept();
		//alert.dismiss();
		
		System.out.println("Step 7 : Get the label text and verify with expected ");
		String msg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		
		System.out.print("Step 8: On pressing OK, ");
		if (alertMsgExpectedOk.equals(msg))
			System.out.println("actual msg is same as expected : " + msg);
		else
			System.out.println("actual msg is not same as expected");
		
		
/*		System.out.print("Step 8: On pressing Cancel, ");
		if (alertMsgExpectedCancel.equals(msg))
			System.out.println("actual msg is same as expected : " + msg);
		else
			System.out.println("actual msg is not same as expected");*/

		 driver.close();

	}

}
