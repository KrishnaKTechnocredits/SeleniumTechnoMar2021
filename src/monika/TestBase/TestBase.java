package monika.TestBase;

import org.testng.asserts.SoftAssert;
public class TestBase {
	
	public static SoftAssert softAssert() {
		SoftAssert softassert = new SoftAssert();
		return softassert;
	}
}
