package krati_Jain.test1_14_TestNG;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase3 {
	
	WebDriver driver;

	@BeforeClass
	public void setDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\krjain\\Documents\\Selenium TechnoCred\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void test1() throws InterruptedException {

		String fName = "Krati", lName = "Jain", company = "Deloitte";
		String alertToVerify = fName + " and " + lName + " and " + company;
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(1000);

		System.out.println("Entering Fname, Lname and Company name");

		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys("Krati");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Jain");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("Deloitte");
		
		Thread.sleep(500);

		System.out.println("Submitting details by clicking on submit");
		driver.findElement(By.xpath("//button[@type ='submit']")).click();

		Alert alert = driver.switchTo().alert();
		System.out.println("Handling the alert, getting the text and verifing the same");
		String actualAlert1 = alert.getText();
		if (alertToVerify.equals(actualAlert1))
			System.out.println("Alter message is as expected");
		else
			System.out.println("Alert message is not as expected");

		alert.accept();

	}
	
	@Test
	public void test2() throws InterruptedException {

		String email = "kr@jain.com", pwd = "1234#qwer";
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id=\"pwd\"]")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@id=\"submitb2\"]")).click();

		Alert alert2 = driver.switchTo().alert();
		String alertToVerify2 = "You successfully clicked on it";
		String actualAlert2 = alert2.getText();
		if (alertToVerify2.equals(actualAlert2))
			System.out.println("Alert message is correct");
		else
			System.out.println("Alert message is incorrect");
		alert2.accept();
	}
	
	@AfterClass
	public void quitBrowsers() {
		driver.quit();
	}

}
