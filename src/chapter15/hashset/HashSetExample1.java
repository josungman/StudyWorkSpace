package chapter15.hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample1 {

	public static void main(String[] args) {
		
		
		Set<String> set = new HashSet<String>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("JAVA");
		set.add("JAVA");
		
		
		
		int size = set.size();
		
		System.out.println("총 객체수:" + size);
		
	
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println(element);
			
		}
		
		System.out.println();
		
		set.remove("JDBC");
		
		
		System.out.println("총 객체수: " + set.size());
		
		iterator = set.iterator();
		
		while(iterator.hasNext()) {
			
			String element = iterator.next();
			System.out.println(element);
			
		}
		
		
		set.clear();
		if(set.isEmpty()) {System.out.println("비어있음");}
		
		
	}
	
	
}
