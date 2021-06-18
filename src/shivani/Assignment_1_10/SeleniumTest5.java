package shivani.Assignment_1_10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*JS confirmation
Read message and accordingly click - OK and cancel
A label is "
based on Cancel - "You pressed Cancel!"added. get this label using getText(); and now verify based on below conditions -
based on OK - "You pressed OK
*/

public class SeleniumTest5 {
	public static void main(String[] args) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		 
		 WebDriver driver = new ChromeDriver();
		 driver.get("http://automationbykrishna.com/");
		 driver.manage().window().fullscreen();
		 System.out.println("click on basic Element");
		 driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		 Thread.sleep(1000);
		 System.out.println("Click on Js confirmation");
		 driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		 Alert alert=driver.switchTo().alert();
		 String alterMessage = alert.getText();
		 String ExpectedAlertMessage ="Are you are doing your homework regularly, Press Okay else Cancel!!";
		 if(alterMessage.equals(ExpectedAlertMessage)) {
			 System.out.println("Test Pass");
		 }
		 else
			 System.out.println("Test Fail");
		 Thread.sleep(1000);
		 alert.accept();
		 System.out.println("verify alert label");
		 String labelActualtext =driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		 String expected="You pressed OK";
		 if(labelActualtext.equals(expected)) {
			 System.out.println("label text Matched");
		 }
		 
		 else
			 System.out.println("label text Failed");
//		 alert.dismiss();
//		 System.out.println("verify alert label");
//		 String labelActualtext2 =driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
//		 String expected2="You pressed Cancel!";
//		 if(labelActualtext2.equals(expected2)) {
//			 System.out.println("label2 text Matched");
//		 }
//		 
//		 else
//			 System.out.println("label2 text Failed");
		 
		 driver.close();
		

}
}
