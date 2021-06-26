package technocredits.testngDemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Example2 {

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BM");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("AF");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("BC");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("AC");
	}
	
	@Test
	public void m1() {
		System.out.println("T1");
	}
	
	@Test
	public void m2() {
		System.out.println("T2");
	}
	
}
