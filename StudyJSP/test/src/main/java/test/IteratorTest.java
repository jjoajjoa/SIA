package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("JSP");
		list.add("Servlet");
		
		for(String str : list) {
			System.out.println(str);
		}
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String next = it.next();
			System.out.println(next);
		}
	}
}
