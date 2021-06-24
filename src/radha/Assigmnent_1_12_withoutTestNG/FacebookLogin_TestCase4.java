package radha.Assigmnent_1_12_withoutTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.PredefinedActions;

public class FacebookLogin_TestCase4 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("launch browser");
		WebDriver driver = PredefinedActions.start("https://en-gb.facebook.com/campaign/landing.php?&campaign_id=973072070&extra_1=s%7Cc%7C231346543652%7Ce%7Cfacebook%20english%7C&placement&creative=231346543652&keyword=facebook%20english&partner_id=googlesem&extra_2=campaignid%3D973072070%26adgroupid%3D54006255091%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-302991057522%26loc_physical_ms%3D20462%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=Cj0KCQjw8IaGBhCHARIsAGIRRYppGTpbh4PYy4g2aRupBs4zyfJ-BF5uyZ7sOevSvVM0lV_PjKfqKAsaAtgmEALw_wcB");
		Thread.sleep(3000);
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.sendKeys("Radha");
		System.out.println(firstName.getAttribute("value"));
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		lastName.sendKeys("Saoji");
		System.out.println(lastName.getAttribute("value"));
		WebElement email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		email.sendKeys("Radha@saoji.com");
		System.out.println(email.getAttribute("value"));
		WebElement reEnterEmail  = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__'][@type='text']"));
		reEnterEmail.sendKeys("Radha@saoji.com");
		System.out.println(reEnterEmail.getAttribute("value"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password_step_input']"));
		password.sendKeys("radhaS123");
		System.out.println(password.getAttribute("value"));
		System.out.println("birthdate dropdown - ");
		WebElement date = driver.findElement(By.xpath("//select[@id='day']"));
		Select selct  = new Select(date);
		selct.selectByValue("14");
		WebElement month = driver.findElement(By.xpath("//select[@title='Month']"));
		Select mnth  = new Select(month);
		mnth.selectByValue("6");
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		Select selYear  = new Select(year);
		selYear.selectByVisibleText("1995");
		System.out.println("Selecting gender...");
		driver.findElement(By.xpath("//input[@type='radio'][@value='1']")).click();
		driver.quit();

	}
}
