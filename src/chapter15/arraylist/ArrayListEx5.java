package chapter15.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chapter15.array.Student;

public class ArrayListEx5 {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		boolean loop = true;
		
		while (loop) {
			System.out.println("-----------------------------------");
			System.out.println("1.입력|2.삭제|3.목록|4.통계|5.종료");
			System.out.println("-----------------------------------");
			System.out.print("선택>");
			int c = scanner.nextInt();
			
			switch (c) {
			case 1:
				addStudent(list);
				break;
			case 2:
				removeStudent(list);
				break;
			case 3:
				listStudent(list);
				break;
			case 4:
				stStudent(list);
				break;
			case 5:
				loop = false;
				break;
			default:
				break;
			}
		}
	}

	private static void stStudent(List<Student> list) {
		Student max = new Student();
		max.setMath(Integer.MIN_VALUE);
		Student min = new Student();
		min.setMath(Integer.MAX_VALUE);
		double avg = 0;
		
		for (Student s : list) {
			max = (max.getMath() < s.getMath()) ? s : max;
			min = (min.getMath() > s.getMath()) ? s : min;
			avg = avg + s.getMath();
		}
		avg = avg / list.size();
		
		System.out.println("최고점수: " + max);
		System.out.println("최저점수: " + min);
		System.out.println("평균점수: " + avg);
	}

	private static void removeStudent(List<Student> list) {
		System.out.print("삭제할 index>");
		int index = scanner.nextInt();
		list.remove(index);
	}

	private static void listStudent(List<Student> list) {
		System.out.println("--------학생 목록-----------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + ":" + list.get(i));
		}
	}

	private static void addStudent(List<Student> list) {
		Student s = new Student();
		System.out.print("이름>");
		String name = scanner.next();
		System.out.print("점수>");
		int math = scanner.nextInt();
		s.setName(name);
		s.setMath(math);
		list.add(s);
	}
}









