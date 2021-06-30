package technocredits.basics;

import java.util.TreeSet;

public class Tricky2 {

	public static void main(String[] args) {
		TreeSet<String> al1 = new TreeSet<String>();
		al1.add("Techno");
		al1.add("Credits");
		
		TreeSet<String> al2 = new TreeSet<String>();
		al2.add("Techno");
		al2.add("Credits");
		
		System.out.println(al1.equals(al2));
		/*boolean flag = true;
		if(al1.size() == al2.size()) {
			for(int index=0;index<al1.size();index++) {
				if(!al1.get(index).equals(al2.get(index))) {
					flag = false;
					break;
				}
			}
		}else
			flag = false;
		if(flag)
			System.out.println("Equal");
		else
			System.out.println("Not Equal");*/
	}
	

		
}
