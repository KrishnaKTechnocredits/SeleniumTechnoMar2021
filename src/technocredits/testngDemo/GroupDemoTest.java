package technocredits.testngDemo;

import org.testng.annotations.Test;

public class GroupDemoTest {

	
	@Test(groups="smoke")
	public void m1() {
		System.out.println("M1");
	}
	
	@Test(groups="regression")
	public void m2() {
		System.out.println("M2");
	}
	
	@Test(groups= {"e2e","smoke"})
	public void m3() {
		System.out.println("M3");
	}
}
