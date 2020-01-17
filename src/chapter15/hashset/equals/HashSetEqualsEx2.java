package chapter15.hashset.equals;

import java.util.HashSet;
import java.util.Set;

public class HashSetEqualsEx2 {
	public static void main(String[] args) {
		Set<Person> set = new HashSet<>();
		
		Person p1 = new Person(1, "anna");
		Person p2 = new Person(2, "simba");
		Person p3 = new Person(3, "toy");
		
		set.add(p1);
		set.add(p2);
		set.add(p3);
		
		System.out.println(set);
		
		set.add(new Person(2, "simba"));
		
		System.out.println(set);
	}
}





