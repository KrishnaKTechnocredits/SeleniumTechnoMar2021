package technocredits.testngDemo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest1 {

	@Parameters(value="browser")
	@Test
	public void m1(String b) {
		System.out.println(b);
	}
}
