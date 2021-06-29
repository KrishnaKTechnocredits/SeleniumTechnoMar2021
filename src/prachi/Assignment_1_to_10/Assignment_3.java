package prachi.Assignment_1_to_10;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*TC#1 - First Box
- Enter Fname, Lname and Company name.
- click submit.
- you should get alert; get that text and verify.


TC#2 - Second Box
- Enter email
- Enter password
- verify message "You successfully clicked on it"

Javascript
TC#3
click Alert button
Verify - "You must be TechnoCredits student"

TC#4
JS confirmation
Read message and accordingly click - OK and cancel
A label is added. get this label using getText(); and now verify based on below conditions -
based on OK - "You pressed OK" 
based on Cancel -  "You pressed Cancel!"

TC#5
JS Prompt
- click JS Prompt
- switch to alert
- enter name
- from the message verify that "given name" is present.*/


public class Assignment_3{
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		System.out.println("TC#1- First Box");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize(); 
		driver.findElement(By.xpath("//*[@id='basicelements']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='ufname']")).sendKeys("Prachi");
		driver.findElement(By.xpath("//*[@name='ulname']")).sendKeys("Lonkar");
		driver.findElement(By.xpath("//*[@name='cmpname']")).sendKeys("GS Lab");
		driver.findElement(By.xpath("//*[@onclick='myFunctionPopUp()']")).click();


		driver.switchTo().alert();
		String ExpectedAlertMsg=driver.switchTo().alert().getText();
		String ActualAlertMsg="Prachi and Lonkar and GS Lab";
		if(ExpectedAlertMsg.equals(ActualAlertMsg)) {
			System.out.println("Alert Matched.");
		}else{
			System.out.println("Alert mismatched.");
		} 
		driver.switchTo().alert().accept();
		System.out.println("-----------------------------------------------------------");

		System.out.println("TC#2 - Second Box");
		driver.findElement(By.xpath("//*[@name='emailId']")).sendKeys("ppp@gmail.com");
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys("ppp");
		driver.findElement(By.xpath("//*[@onclick='myFunction()']")).click();
		driver.switchTo().alert();
		String ExpectedAlertMsg2=driver.switchTo().alert().getText();
		String ActualAlertMsg2="You successfully clicked on it";
		if(ExpectedAlertMsg2.equals(ActualAlertMsg2)) {
			System.out.println("Alert Matched.");
		}else{
			System.out.println("Alert mismatched.");
		}
		driver.switchTo().alert().accept();
		System.out.println("-----------------------------------------------------------");

		System.out.println("TC#3");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("//*[@id='javascriptAlert']")).click();
		driver.switchTo().alert();
		String ExpectedAlertMsg3=driver.switchTo().alert().getText();
		String ActualAlertMsg3="You must be TechnoCredits student!!";
		if(ExpectedAlertMsg3.equals(ActualAlertMsg3)) {
			System.out.println("Alert Matched.");
		}else{
			System.out.println("Alert mismatched.");
		}
		driver.switchTo().alert().accept();
		System.out.println("-----------------------------------------------------------");

		System.out.println("TC#4");
		driver.findElement(By.xpath("//*[@id='javascriptConfirmBox']")).click();
		driver.switchTo().alert();
		driver.switchTo().alert().accept();
		String ExpectedMsg4=driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText();
		String ActualMsg4="You pressed OK!";
		if(ExpectedMsg4.equals(ActualMsg4)) {
			System.out.println("OK Text Matched.");
		}else{
			System.out.println("OK Text mismatched.");
		}
		driver.findElement(By.xpath("//*[@id='javascriptConfirmBox']")).click();
		driver.switchTo().alert();
		driver.switchTo().alert().dismiss();
		String ExpectedMsg5=driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText();
		String ActualMsg5="You pressed Cancel!";
		if(ExpectedMsg5.equals(ActualMsg5)) {
			System.out.println("Cancel Text Matched.");
		}else{
			System.out.println("Cancel Text mismatched.");
		}
		System.out.println("-----------------------------------------------------------");

		System.out.println("TC#5");
		driver.findElement(By.xpath("//*[@id='javascriptPromp']")).click();
		driver.switchTo().alert();
		driver.switchTo().alert().sendKeys("Prachi");
		driver.switchTo().alert().accept();
		String ExpectedMsg6=driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText();
		String ActualMsg6="Hello Prachi! Howwww are you today?";
		if(ExpectedMsg6.equals(ActualMsg6)) {
			System.out.println("Prompt Text Matched.");
		}else{
			System.out.println("Prompt Text mismatched.");
		}

		driver.findElement(By.xpath("//*[@id='javascriptPromp']")).click();
		driver.switchTo().alert();
		driver.switchTo().alert().sendKeys("Prachi");
		driver.switchTo().alert().dismiss();
		String ExpectedMsg7=driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText();
		String ActualMsg7="User cancelled the prompt.";
		if(ExpectedMsg7.equals(ActualMsg7)) {
			System.out.println("PromptCancel Text Matched.");
		}else{
			System.out.println("PromptCancel Text mismatched.");
		}
		System.out.println("-----------------------------------------------------------");

		driver.close();

	}
}
