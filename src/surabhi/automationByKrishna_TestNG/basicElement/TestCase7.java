package surabhi.automationByKrishna_TestNG.basicElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase7 extends BaseClass{
	
	@Test
	public void runTestCase7() {
		String word="surabhi";
		
		//click on javascript prompt button
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		
		//enter text in input area of alert window
		driver.switchTo().alert().sendKeys(word);
		
		System.out.println(driver.switchTo().alert().getText());
		//press ok 
		driver.switchTo().alert().accept();
		
		
		//get text after alert closed with ok button
		String textOnPTag=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println(textOnPTag);
		
		Assert.assertTrue(textOnPTag.contains(word),"pressed ok test case failed"); 
	}
	
	@Test
	public void runCancelMsgTestCase() {
		String word="surabhi";
		
		//click on javascript promt button
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
	
		//enter text in input area of alert window
		driver.switchTo().alert().sendKeys(word);
		System.out.println(driver.switchTo().alert().getText());
		
		//press ok 
		driver.switchTo().alert().dismiss();
		
		//get text after alert closed with ok button
		String textOnPTag=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println(textOnPTag);
		
		Assert.assertTrue(textOnPTag.contains("User cancelled the prompt."),"Test pressed on cancelled failed"); 
			
	}

}
