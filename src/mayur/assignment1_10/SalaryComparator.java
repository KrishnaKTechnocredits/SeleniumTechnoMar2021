package mayur.assignment1_10;

import java.util.Comparator;

import org.openqa.selenium.WebElement;

public class SalaryComparator implements Comparator<WebElement> {

	
	public int compare(WebElement o1, WebElement o2) {
		
		int i1 = Integer.parseInt(o1.getText().replace("$", "").replace(",", ""));
		int i2 = Integer.parseInt(o2.getText().replace("$", "").replace(",", ""));
		if (i1 > i2)
			return 1;
		else
			return -1;
	}
}