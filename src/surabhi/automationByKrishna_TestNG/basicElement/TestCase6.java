package surabhi.automationByKrishna_TestNG.basicElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/*JS confirmation
Read message and accordingly click - OK and cancel
A label is added. get this label using getText(); and now verify based on below conditions -
based on OK - "You pressed OK" 
based on Cancel -  "You pressed Cancel!"*/

public class TestCase6 extends BaseClass{

	@Test
	public void testCaseOKMessage() {
		
		String expectedOKMsg="You pressed OK!" ;
		
		driver.findElement(By.xpath("//button[@onclick='callJavaScriptConfirmBox()']")).click();
		
		driver.switchTo().alert().accept();
		String messageOK=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		Assert.assertTrue(messageOK.equals(expectedOKMsg), "TestOKpress failed");
	}
	
	@Test
	public void testCaseCancelMessage() {
		
		String expectedCancelMsg="You pressed Cancel!";
		
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='callJavaScriptConfirmBox()']"))).click();
		
		driver.switchTo().alert().dismiss();
		
		String messageCancel=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		Assert.assertEquals(messageCancel, expectedCancelMsg, "Test Cancel Alert failed");
	
	}

}
