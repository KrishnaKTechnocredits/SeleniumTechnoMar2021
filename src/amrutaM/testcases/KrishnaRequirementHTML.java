package amrutaM.testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import amrutaM.base.PredefinedActions;

/*
 *  1. validate visible button functionality click on button and validate button is displayed or not and vice versa
	2. validate enable button functionality click on button and validate button is disable or not and vice versa
	3. validate isSelected on automationbykrishna's registration page if male radio button is selected then click on female
	
	Note: 1 & 2 perform on HTML which is shared
*/
public class KrishnaRequirementHTML {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.setUp("/SeleniumTechnoMar2021/src/amrutaM/resources/Krishna Requirement.html");
		// #1 validate visible button functionality click on button and validate button is displayed or not and vice versa
		System.out.println("STEP: Verifying visible button functionality by clicking on the Visible & Hidden Button");
		driver.findElement(By.xpath("//button[@id='visibleAndHidden']")).click();
		System.out.println("STEP: Verify that the below div section is not visible or not");
		boolean divVisibility = driver.findElement(By.xpath("//div[@id='myDIV']")).isDisplayed();
		System.out.println("Is the div section visible ? "+divVisibility);
		if(!divVisibility) 
			System.out.println("PASS");
		else
			System.out.println("FAIL");
		System.out.println("Again clicking on the Visible & Hidden Button");
		driver.findElement(By.xpath("//button[@id='visibleAndHidden']")).click();
		boolean divVisibility1 = driver.findElement(By.xpath("//div[@id='myDIV']")).isDisplayed();
		System.out.println("Is the div section visible ? "+divVisibility1);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(divVisibility1)
			System.out.println("PASS");
		else 
			System.out.println("FAIL");
		//#2. validate enable button functionality click on button and validate button is disable or not and vice versa
		System.out.println("Entering text into the Name field");
		driver.findElement(By.xpath("//input[@id='myText']")).sendKeys("Testing isEnabled");
		System.out.println("Clicking on the Enable & Disable Button");
		driver.findElement(By.xpath("//button[@id='enableAndDisable']")).click();
		System.out.println("Verifying if the text input field is disabled or not");
		boolean btnEnabilityFlag = driver.findElement(By.xpath("//input[@id='myText']")).isEnabled();
		if(!btnEnabilityFlag)
			System.out.println("PASS - Text field is disabled");
		else
			System.out.println("FAIL - Text field is enabled");
	}
}
