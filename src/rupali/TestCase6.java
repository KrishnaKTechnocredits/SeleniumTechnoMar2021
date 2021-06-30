package rupali;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 *TC#5
JS Prompt
- click JS Prompt
- switch to alert
- enter name
- from the message verify that "given name" is present.


 * 
 */
public class TestCase6 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		
		Alert alert=driver.switchTo().alert();
		String sentToAlert = "Rupali";
		alert.sendKeys(sentToAlert);
		alert.accept();
		String actualLabelText=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println(actualLabelText);
		
		if(actualLabelText.contains(sentToAlert))
			System.out.println("Test case pass");
		else
			System.out.println("Test case fail");
		
		String expectedLabelText = "You pressed OK!";
		if(actualLabelText.equals(expectedLabelText))
			System.out.println("Label text is correct");
		else
			System.out.println("Label text is incorrect");
		driver.close();
		}

}
