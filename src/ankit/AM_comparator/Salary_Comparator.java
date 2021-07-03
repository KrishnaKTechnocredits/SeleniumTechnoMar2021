package ankit.AM_comparator;

import java.util.Comparator;

import org.openqa.selenium.WebElement;

public class Salary_Comparator implements Comparator<WebElement>{



	@Override
	public int compare(WebElement o1, WebElement o2) {
		// TODO Auto-generated method stub
		int i1 = Integer.parseInt(o1.getText().replace("$", "").replaceAll(",",""));
		int i2 = Integer.parseInt(o2.getText().replace("$", "").replaceAll(",",""));
		if(i1>i2)
			return 1;
		else
			return -1;
	}
}
