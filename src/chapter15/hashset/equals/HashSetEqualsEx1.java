package chapter15.hashset.equals;

import java.util.HashSet;
import java.util.Set;

public class HashSetEqualsEx1 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("java");
		set.add("python");
		set.add("c++");
		
		System.out.println(set);

		String s1 = "java";
		String s2 = new String("java");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		set.add(s1);
		set.add(s2);
		
		System.out.println(set);
	}
}









