package chapter15.hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetEqualsEx2 {

	public static void main(String[] args) {
		
		
		Set<Person> set = new HashSet<>();
		
		
		Person q1 = new Person(1, "anna");
		Person q2 = new Person(2, "sungman");
		Person q3 = new Person(3, "jojo");
		
	
		set.add(q1);
		set.add(q2);
		set.add(q3);
	
		System.out.println(set);
	
		set.add(new Person(2,"simba"));
		
		
	}
}
