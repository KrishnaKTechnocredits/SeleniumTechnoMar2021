package radha.Assigmnent_1_12_withoutTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonIsSelected_TestCase5 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		driver.findElement(By.xpath("//input[@id='fullName']")).sendKeys("Radha Saoji");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Mehkar");
		driver.findElement(By.xpath("//input[@id='useremail']")).sendKeys("abc@mail.com");
		driver.findElement(By.xpath("//input[@id='usercity']")).sendKeys("Pune");
		driver.findElement(By.xpath("//input[@id='organization']")).sendKeys("Atos-Syntel");
		boolean isMaleRadioButtonSelected = driver.findElement(By.xpath("//input[@id='radio-01']")).isSelected();
		if(isMaleRadioButtonSelected)
			System.out.println("'Male' radio button is Selected.");
		else
			System.out.println("'Male' radio button is not Selected.");
		boolean isFemaleRadioButtonEnabled = driver.findElement(By.xpath("//input[@id='radio-02']")).isEnabled();
		if(isFemaleRadioButtonEnabled)
			System.out.println("'Female' radio button is Enabled.");
		else
			System.out.println("'Female' radio button is not Enabled.");
		driver.findElement(By.xpath("//input[@id='radio-02']")).click();
		boolean isFemaleRadioButtonSelected = driver.findElement(By.xpath("//input[@id='radio-02']")).isSelected();
		if(isFemaleRadioButtonSelected)
			System.out.println("'Female' radio button is Selected.");
		else
			System.out.println("'Female' radio button is not Selected.");
		System.out.println("is Female radio button selected? - "+isFemaleRadioButtonSelected);
		System.out.println("Close browser...");
		driver.close();
	}
}
