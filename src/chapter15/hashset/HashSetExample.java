package chapter15.hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class HashSetExample {

	
	public static void main(String[] args) {
		
		Set<Student> set = new HashSet<Student>();
		
		set.add(new Student(1,"홍길동"));
		set.add(new Student(2,"홍길a"));
		set.add(new Student(1,"홍길동"));
		
		
		Iterator<Student> iteator = set.iterator();
		while(iteator.hasNext()) {
			
			Student student = iteator.next();
			System.out.println(student.i + ":" + student.name);
			
			
		}
		
		
	}
	
}
