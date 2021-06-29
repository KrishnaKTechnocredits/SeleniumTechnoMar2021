package kajal.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsEnabled {

	public static void main(String[] args) {
		System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		driver.get("file:///C:/Users/Kajal/Downloads/Krishna%20Requirement.html");
		driver.manage().timeouts().implicitlyWait(250,TimeUnit.SECONDS );
		driver.manage().window().maximize();
				
		System.out.println("step1: to find whether btn is enabled or not");
		WebElement textBox = driver.findElement(By.xpath("//input[@id='myText']"));
		textBox.isEnabled();
		System.out.println("step 2: sendkeys kaju");
		textBox.sendKeys("kaju");
		
		WebElement enableDisableBtn= driver.findElement(By.xpath("//button[@id='enableAndDisable']"));
		enableDisableBtn.click();
				
		System.out.println("step3: make button disable, to see wht will happen when we entering into disable textbox");
		textBox.isEnabled();
		/*System.out.println("step to see Exception");//reapeted above steps
		textBox.sendKeys("kaju");// got elements not ineractable exception, when text box is disable and you try to send keys
		*/
		driver.close();
	}

}
