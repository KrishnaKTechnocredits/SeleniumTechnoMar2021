package technocredits.testngDemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondClass {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("SecondClass - Before Suite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("SecondClass - Before Test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("SecondClass - Before class");
	}
	
	@Test
	public void m1() {
		System.out.println("Second Class - M1");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("SecondClass - after class");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("SecondClass - After Test");
	}
	
}
