package monika.IFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Iframe {
	
	@Test
	public void iframe() throws InterruptedException {
		WebDriver driver = PredefinedActions.start("http://demo.automationtesting.in/Frames.html");
	//	driver.findElement(By.linkText("IFrame Demo")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//iframe[@id='singleframe']"));
		//System.out.println(totalframes);
		driver.switchTo().frame("singleframe");
		System.out.println(driver.getTitle());
		driver.switchTo().defaultContent();
		System.out.println(driver.getTitle());
		
		
		
	}

}
