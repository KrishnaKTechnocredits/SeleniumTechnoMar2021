package radha.Assigmnent_1_12_withoutTestNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSPrompt_TestCase3 {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("launching browser.....");
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();;
		Thread.sleep(2000);
		System.out.println("Step 1-");
		WebElement prompt =  driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", prompt);
		prompt.click();
		System.out.println("Switching to alert...");
		Alert alertPrompt = driver.switchTo().alert();
		String name = "Radha";
		System.out.println("Passed name- "+name);
		alertPrompt.sendKeys(name);
		alertPrompt.accept();
		String labelMsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println(labelMsg);
		if(labelMsg.contains(name))
			System.out.println("Passed name is present in the label message");
		else
			System.out.println("Passed name is not present in the label message");
		driver.close();
	}

}
