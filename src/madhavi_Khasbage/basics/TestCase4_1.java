package madhavi_Khasbage.basics;
/*
 * http://automationbykrishna.com/index.html#
 * validate isSelected on automationbykrishna's registration page if male radio button is selected then click on female*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import MadhaviKhasbage.basic.PredefinedActions;
import java.util.concurrent.TimeUnit;

public class TestCase4_1 {
	
	public static void main(String[] args) throws InterruptedException {
		String expectedURL1 = "http://automationbykrishna.com/index.html#";
		WebDriver driver1 = PredefinedActions.setUp(expectedURL1);
		driver1.manage().timeouts().implicitlyWait(250,TimeUnit.MILLISECONDS);
		driver1.findElement(By.id("registration2")).click();
		driver1.manage().window().maximize();
		boolean isSelected = driver1.findElement(By.id("radio-01")).isSelected();
		
		if(isSelected) {
			driver1.findElement(By.id("radio-02")).click();
			System.out.println("Test Pass");
		}
	}

}
