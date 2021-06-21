package trupti.assignment3;
/*Basic Elements Page
 * TC#1 - First Box
 - Enter Fname, Lname and Company name.
- click submit.
- you should get alert; get that text and verify.*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {
	WebDriver driver;
	Assignment3(){
		System.out.println("Step 1-Launch a chrome");
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
	}
	private void basicElements() throws InterruptedException {
		
		System.out.println("Step 2-Open Google.com");
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		System.out.println("Step 3-Navigate to automationbykrishna.com ");
		driver.navigate().to("http://automationbykrishna.com/");
		System.out.println("Click on Basic Elements Link");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		System.out.println("Step 4-Enter First Name");
		driver.findElement(By.id("UserFirstName")).sendKeys("Trupti");
		System.out.println("Step 5-Enter Last Name");
		driver.findElement(By.id("UserLastName")).sendKeys("Wadkar");
		System.out.println("Step 6-Enter Company Name");
		driver.findElement(By.id("UserCompanyName")).sendKeys("Capgemini");
		System.out.println("Step 7-Click on Submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		System.out.println("Step 8-Alert recieved");
		Alert alert=driver.switchTo().alert();
		String actualAlert=alert.getText();
		String expectedAlert="Trupti and Wadkar and Capgemini";
		if(actualAlert.equals(expectedAlert)) {
			System.out.println("Alert matching with actual alert");
		}
		else {
			System.out.println("Alert not matching with actual alert");
		}
		alert.accept();


	}

	private void basicForms() {
		System.out.println("Step 1-Enter Email address");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("truptiwadkar@rediff.com");
		System.out.println("Step 2-Enter Password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("trupti123");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		Alert alert1=driver.switchTo().alert();
		String actualAlert1=alert1.getText();
		String expectedAlert1="You successfully clicked on it";
		if(actualAlert1.equals(expectedAlert1)) {
			System.out.println("Alert matching with actual alert");
		}
		else {
			System.out.println("Alert not matching with actual alert");
		}
		alert1.accept();

	}

	private void alertExampleOne() {
		System.out.println("Click on Alert");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		Alert alert2=driver.switchTo().alert();
		System.out.println("Step 1:Alert-Verify alert");
		String actualAlert3=alert2.getText();
		String expectedAlert3="You must be TechnoCredits student!!";
		if(actualAlert3.equals(expectedAlert3)) {
			System.out.println("Alert-Alert matching with actual alert");
		}
		else {
			System.out.println("Alert-Alert not matching with actual alert");
		}
		alert2.accept();

	}

	private void jsConfirmation(String myaction) {
		System.out.println("Click on Alert-Javascript Confirmation");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		Alert alert3=driver.switchTo().alert();
		System.out.println("Step 1:Javascript Confirmation-Verify alert");
		String actualAlert4=alert3.getText();
		String expectedAlert4="You must be TechnoCredits student!!";
		if(actualAlert4.equals(expectedAlert4)) {
			System.out.println("Alert-Alert matching with actual alert");
		}
		else {
			System.out.println("Alert-Alert not matching with actual alert");
		}
	
		if(myaction.equals("OK"))
			alert3.accept();
		else
			alert3.dismiss();
		String resultText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String resultOK = "You pressed OK!";
		String resultCancel = "You pressed Cancel!";
		if(resultText.equals(resultOK)) {
			System.out.println("You pressed OK!");
		}
		else if(resultText.equals(resultCancel)) {
			System.out.println("You pressed Cancel!");
		}else {
			System.out.println("An error occurred during JS confirmation box result check");
		}
		

	}

	private void jsPrompt(String myaction) {

		System.out.println("Click on Javascript Prompt alert");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		Alert alert4=driver.switchTo().alert();
		alert4.sendKeys("Trupti");
		if(myaction.equals("OK"))
			alert4.accept();
		else
			alert4.dismiss();
		String resultText1 = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (resultText1.contains("Trupti")) {
			System.out.println("Given name is present in message");
		}
		else {
			System.out.println("Given name is not present in message");
		}
	}


	public static void main(String[] args) throws InterruptedException {
		Assignment3 test3=new Assignment3();
		
		System.out.println("Test Case 1");
		System.out.println("==============================");
		test3.basicElements();
		System.out.println("==============================");
		System.out.println("\nTest Case 2");
		System.out.println("==============================");
		test3.basicForms();
		System.out.println("==============================");
		System.out.println("\nTest Case 3");
		System.out.println("==============================");
		test3.alertExampleOne();
		System.out.println("==============================");
		System.out.println("\nTest Case 4");
		System.out.println("==============================");
		System.out.println("\nWith \"OK\" option");
		System.out.println("-----------------------");
		test3.jsConfirmation("OK");
		System.out.println("\nWith \"Cancel\" option");
		System.out.println("-----------------------");
		test3.jsConfirmation("Cancel");
		System.out.println("==============================");
		System.out.println("\nTest Case 5");
		System.out.println("==============================");
		System.out.println("\nWith \"OK\" option");
		System.out.println("-----------------------");
		test3.jsPrompt("OK");
		System.out.println("\nWith \"Cancel\" option");
		System.out.println("-----------------------");
		test3.jsPrompt("Cancel");
	
		test3.driver.close();
		int n = Integer.valueOf("12345");
		System.out.println(n);
	}
}

