/*
 TC#5
JS Prompt
- click JS Prompt
- switch to alert
- enter name
- from the message verify that "given name" is present.
 */


package ami.Case_2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Case_5 extends Test_Case_1 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\LEARNING\\eclips java code\\SeleniumTechnoMar2021\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url ="http://automationbykrishna.com/";
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("Click on basic Element ");
	driver.findElement(By.id("basicelements")).click();;
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		System.out.println("click JS Prompt");
		WebElement element =  driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		
		//Test_Case_1 case1 =new Test_Case_1();
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(fName);
		alert.accept();
		
		WebElement okMsg = driver.findElement(By.xpath("//p[@id ='pgraphdemo']"));
		String line = okMsg.getText();
	
		if(line.contains(fName)) {
			System.out.println("test pass");
		}else {
			System.out.println("test fail");
		}
		
		driver.close();
	}
}

