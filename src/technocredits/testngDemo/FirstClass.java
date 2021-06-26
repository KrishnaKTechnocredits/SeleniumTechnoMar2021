package technocredits.testngDemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstClass {

	@BeforeTest
	public void beforeTest() {
		System.out.println("FirstClass - Before Test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("FirstClass - BeforeClass");
	}
	
	@Test
	public void m1() {
		System.out.println("First Class - M1");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("FirstClass - after class");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("FirstClass - After Test");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("FirstClass - After Suite");
	}
}
