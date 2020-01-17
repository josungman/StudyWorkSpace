package chapter15.array;

import chapter08.exercise03.Soundable;

public class ArrayEx1 {
	public static void main(String[] args) {
		Student[] students = new Student[3];
		Student s1 = new Student();
		s1.setName("안나");
		s1.setMath(80);
		
		Student s2 = new Student();
		s2.setName("엘사");
		s2.setMath(85);
		
		Student s3 = new Student();
		s3.setName("올라프");
		s3.setMath(75);
		
		students[0] = s1;
		students[1] = s2;
		students[2] = s3;
		
		Student s4 = new Student();
		s4.setName("스벤");
		s4.setMath(60);
		
		Student[] students2 = new Student[6];
		
		for (int i = 0; i < students.length; i++) {
			students2[i] = students[i];
		} 
		students2[3] = s4;
		
		for (int i = 0; i < 4; i++) {
			System.out.println(students2[i].getName());
		}
		
		System.out.println();
		
		for (int i = 3; i < students2.length; i++) {
			students2[i-1] = students2[i];
		}
		
		for (int i = 0; i < 3; i++) {
			System.out.println(students2[i].getName());
		}
		
	}
}










