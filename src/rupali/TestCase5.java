package rupali;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Javascript
TC#3
click Alert button
Verify - "You must be TechnoCredits student"

Observations: we need to scroll the window in order to click on the alert as the alert button is not visible so receiving - org.openqa.selenium.ElementClickInterceptedException

 */
public class TestCase5 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		
		Alert alert=driver.switchTo().alert();
		String actualtext=alert.getText();
		String expectedtext="You must be TechnoCredits student!!";
		
		if(actualtext.equals(expectedtext))
			System.out.println("Test case--pass");
		else
			System.out.println("Test Case --fail");
		
		alert.accept();
		driver.close();
	}

}
