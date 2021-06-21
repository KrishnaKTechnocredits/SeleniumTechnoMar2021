package rupali;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*//3. validate isSelected on automationbykrishna's registration page if male radio button is selected then click on female
 */
public class TestRadioButton {
	
		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("http://automationbykrishna.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//a[@id='registration2']")).click();
			
			if(driver.findElement(By.xpath("//input[@id='radio-01']")).isSelected()) {
				driver.findElement(By.xpath("//input[@id='radio-02']")).click();
			}
			if(driver.findElement(By.xpath("//input[@id='radio-02']")).isSelected()) 
				System.out.println("Female Selected : PASS ");
			else
				System.out.println("Female not selected : FAIL");
			driver.close();
		}
}
