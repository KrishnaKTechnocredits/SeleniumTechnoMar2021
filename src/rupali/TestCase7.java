package rupali;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * TC#5
JS Prompt
- click JS Prompt
- switch to alert
- enter name
- from the message verify that "given name" is present.


 /*TC#4
 JS confirmation
 Read message and accordingly click - OK and cancel
 A label is added. get this label using getText(); and now verify based on below conditions -
 based on OK - "You pressed OK"
 based on Cancel - "You pressed Cancel!"
*/
public class TestCase7 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationbykrishna.com");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);

		System.out.println("STEP - Click on Alert Button");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();

		System.out.println("STEP - Get Text from Alert");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expectedText = "Are you are doing your homework regularly, Press Okay else Cancel!!";

		System.out.println("VERIFY - Alert text");
		if(actualText.equals(expectedText)) 
			System.out.println("Alert Text is correct - PASS");
		else 
			System.out.println("Alert Text is Incorrect - FAIL");

		System.out.println("STEP - Close or Accept Alert");
		alert.accept();

		System.out.println("STEP - Verify Label Text ");
		String actualLabelText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedLabelText = "You pressed OK!";

		if(actualLabelText.equals(expectedLabelText)) 
			System.out.println("Label Text is correct - PASS");
		else 
			System.out.println("Label Text is Incorrect - FAIL");

		System.out.println("STEP - Close Browser ");
		driver.close();
	}
}
