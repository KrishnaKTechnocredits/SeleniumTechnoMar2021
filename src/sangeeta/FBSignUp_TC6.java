package sangeeta;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FBSignUp_TC6 {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start("https://en-gb.facebook.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Step 1: Click on Sign up button");
		driver.findElement(By.xpath("//a[@role='button'] [@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		System.out.println("Strp 2: Write Firstname");
		WebElement element = driver.findElement(By.xpath("//input [@name='firstname']"));
		element.click();
		element.sendKeys("Sangeeta");
		
		System.out.println("Strp 3: Write Lastname");
		WebElement element2 = driver.findElement(By.xpath("//input [@name='lastname']"));
		element2.click(); 
		element2.sendKeys("Bhandarkar");
		
		System.out.println("Strp 4: Write E-Mail ID or Mobile no");
		WebElement element3 = driver.findElement(By.xpath("//input [@name='reg_email__']"));
		element3.click();
		element3.sendKeys("9011168708");
		
		System.out.println("Strp 5: Write Password");
		WebElement element4 = driver.findElement(By.xpath("//input [@name='reg_passwd__']"));
		element4.click();
		element4.sendKeys("Sangeeta@999");
		
		System.out.println("Strp 6: Select birth date");
		WebElement element5 = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select birthDateDropdown = new Select(element5);
		birthDateDropdown.selectByIndex(27);
		
		System.out.println("Strp 7: Select birth month");
		WebElement element6 = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select birthMonthDropdown = new Select(element6);
		birthMonthDropdown.selectByIndex(8);
		
		System.out.println("Strp 8: Select birth year");
		WebElement element7 = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select birthYearDropdown = new Select(element7);
		birthYearDropdown.selectByValue("1989");
		
		System.out.println("Strp 9: Select Gender");
		WebElement element8 = driver.findElement(By.xpath("//input[@value='1']"));
		WebElement element9 = driver.findElement(By.xpath("//input[@value='2']"));
		WebElement element10 = driver.findElement(By.xpath("//input[@value='-1']"));
		
		element8.click();
		element9.click();
		element10.click();
		
		System.out.println("Strp 10: If custom gender then select preffered pronoun");
		WebElement element11 = driver.findElement(By.xpath("//select[@name='preferred_pronoun']"));
		Select selectPronoun = new Select(element11);
		selectPronoun.selectByIndex(1);
		
		System.out.println("Strp 11: If custom gender then write gender");
		WebElement element12 = driver.findElement(By.xpath("//input[@name='custom_gender']"));
		element12.sendKeys("Custom Gender");
		
		System.out.println("Strp 12: Close browser");
		driver.close();
	}

}
