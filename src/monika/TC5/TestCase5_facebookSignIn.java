package monika.TC5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class TestCase5_facebookSignIn {

	private static WebDriver driver;
	
	@Test
	static void verifyPageElement() throws InterruptedException {
		System.out.println("STEP: Launch a browser with URL");
		 driver = PredefinedActions.start("https://en-gb.facebook.com/");
		System.out.println("STEP: click on create account button");
		driver.findElement(By.xpath("//a[@data-testid= 'open-registration-form-button']")).click();
		
		System.out.println("STEP: Fill in the form ");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//First Name
		driver.findElement(By.xpath("//input[@name='firstname'][@type = 'text']")).sendKeys("Magan");
		//Last Name
		driver.findElement(By.xpath("//input[@name='lastname'][@type = 'text']")).sendKeys("Chagan");
		//EMail
		driver.findElement(By.xpath("//input[@name='reg_email__'][@type = 'text']")).sendKeys("magan@demo.com");
		//re- enter email
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__'][@type = 'text']")).sendKeys("magan@demo.com");
		//password
		driver.findElement(By.xpath("//input[@name='reg_passwd__'][@type = 'password']")).sendKeys("mk@123#");
		//dropdown - date
		Select dddate = new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
		dddate.selectByValue("5");
		
		Select ddmonth = new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
		ddmonth.selectByValue("9");
		
		Select ddyear = new Select(driver.findElement(By.xpath("//select[@name='birthday_year']")));
		ddyear.selectByValue("1992");
		
		driver.findElement(By.xpath("//input[@value='1']")).click();
		
		boolean femaleFlag = driver.findElement(By.xpath("//input[@value='1']")).isSelected();
		Assert.assertEquals(femaleFlag, true);
		
		boolean maleFlag = driver.findElement(By.xpath("//input[@value='2']")).isSelected();
		Assert.assertEquals(maleFlag, false);
		
		boolean customFlag = driver.findElement(By.xpath("//input[@value='-1']")).isSelected();
		Assert.assertEquals(customFlag, false);
		
		driver.close();
	}

}
