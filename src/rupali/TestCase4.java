package rupali;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * TC#2 - Second Box
- Enter email
- Enter password
- verify message "You successfully clicked on it"

 */
public class TestCase4 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("Rupali.Lahoti");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Rupali123");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		Alert alert=driver.switchTo().alert();
		String actualtext=alert.getText();
		String expectedtext="You successfully clicked on it";
		if(actualtext.equals(expectedtext))
			System.out.println("Test case --pass");
		else
			System.out.println("Test case --fail");
		
		alert.accept();
		driver.close();
	}
}
