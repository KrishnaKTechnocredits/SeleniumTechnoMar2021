package technocredits.basics;

import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet;

public class Tricky1 {

	public static void main(String[] args) {
		TreeSet<Integer> s = new TreeSet<Integer>(Collections.reverseOrder());
		s.add(10);
		s.add(12);
		
		System.out.println(s);
		
		TreeMap<String,String> tm = new TreeMap<String,String>(Collections.reverseOrder());
	}
}
