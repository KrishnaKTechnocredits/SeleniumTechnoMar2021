package shivani.Assignment_1_10;


	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	/*Test - 3

	TC#1 - First Box
	- Enter Fname, Lname and Company name.
	- click submit.
	- you should get alert; get that text and verify.

	TC#2 - Second Box
	- Enter email
	- Enter password
	- verify message "You successfully clicked on it"*/
	public class SeleniumTest3 {
		
		public static void main(String[] args) throws InterruptedException {
			
			String expectedFailedMessage="Failed! please enter strong password";
			String expectedSuccessMessage="Success!";
			System.setProperty("webdriver.chrom.driver", "chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://automationbykrishna.com/");
			System.out.println("Step : click on registration link");
			driver.findElement(By.id("registration2")).click();
			Thread.sleep(2000);
			System.out.println("Step : Enetr User Name");
			driver.findElement(By.id("unameSignin")).sendKeys("shivani");
			
			System.out.println("Step : enter Password");
			String password ="shivani123";
		driver.findElement(By.id("pwdSignin")).sendKeys(password);
		System.out.println("Step : click on submit");
		driver.findElement(By.id("btnsubmitdetails")).click();
		
		System.out.println("Verif alert message");
		Alert alert=driver.switchTo().alert();
		
		String actualAlert=alert.getText();
		if(password.length()>8) {
			if(actualAlert.equals(expectedSuccessMessage)) {
			System.out.println("TestPass");
			}
		
		else
		{
			System.out.println("TestFail");
		}
		}	else
				{
				if(actualAlert.equals(expectedFailedMessage)) {
					System.out.println("Test pass");
			}
				else
					System.out.println("Test Fail");
				
			}
			}
		
		



}
