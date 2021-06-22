package monali;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestCase_15_DataProvider {
	
	@Test(dataProvider = "loginDetailsProvider")
	public void registrationLoginTest(String userName,String passWard,String alertExpectedText) throws InterruptedException {
		
		WebDriver driver = PredefinedActions.start();
		
		System.out.println("STEP - click on registration link");
		driver.findElement(By.id("registration2")).click();
		
		Thread.sleep(2000);
		System.out.println("STEP - enter username");
		driver.findElement(By.id("unameSignin")).sendKeys(userName);
		
		System.out.println("STEP - enter password");
		driver.findElement(By.id("pwdSignin")).sendKeys(passWard);
		
		System.out.println("STEP - click on submit button");
		WebElement btnELement = driver.findElement(By.id("btnsubmitdetails"));
		btnELement.click();
		System.out.println("Verify - alert message");
		Alert alert = driver.switchTo().alert();
		String alterActualText = alert.getText();
		Assert.assertEquals(alertExpectedText,alterActualText);
		alert.accept();
	}
	
	@DataProvider(name = "loginDetailsProvider")
	public Object[][] login(){
		Object[][] obj = new Object[4][3];
		obj[0][0] = "monali";
		obj[0][1] = "monali123";
		obj[0][2] = "Success!";
		
		obj[1][0] = "saurav";
		obj[1][1] = "saurav123";
		obj[1][2] = "Success!";
		
		obj[2][0] = "jyoti";
		obj[2][1] = "jyoti123";
		obj[2][2] = "Failed! please enter strong password";
		
		obj[3][0] = "vikas";
		obj[3][1] = "vikas1234";
		obj[3][2] = "Success!";
		
		return obj;
	}
	}

