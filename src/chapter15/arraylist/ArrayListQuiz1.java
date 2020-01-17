package chapter15.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chapter15.array.Student;

public class ArrayListQuiz1 {
	public static List<Student> listStudents() {
		List<Student> list = new ArrayList<>();

		Student s1 = new Student();
		s1.setName("안나");
		s1.setMath(80);

		Student s2 = new Student();
		s2.setName("엘사");
		s2.setMath(85);

		Student s3 = new Student();
		s3.setName("올라프");
		s3.setMath(75);

		Student s4 = new Student();
		s4.setName("스벤");
		s4.setMath(60);

		Student s5 = new Student();
		s5.setName("크리스토퍼");
		s5.setMath(73);

		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);

		return list;
	}

	public static void main(String[] args) {
		List<Student> sList = listStudents();

		Scanner scanner = new Scanner(System.in);

		System.out.println("두 명의 학생의 이름과 점수를 입력하세요.");

		for (int i = 0; i < 2; i++) {
			Student s = new Student();
			System.out.print("이름>");
			String name = scanner.next();
			System.out.print("점수>");
			int math = scanner.nextInt();
			sList.add(s);
			s.setName(name);
			s.setMath(math);
		}
		scanner.close();

		System.out.println("=====학생 목록=====");
		for (Student s : sList) {
			System.out.println(s);
		}
		
		
		System.out.println("=====점수 통계=====");
		
		// 최고 점수를 얻은 학생이름과 점수
		Student max = new Student();
		max.setMath(Integer.MIN_VALUE);
		
		for (Student s : sList) {
			max = (max.getMath() < s.getMath()) ? s : max;
		}
		System.out.println("최고점수:" + max);
		
		// 최저 점수를 얻은 학생이름과 점수
		Student min = new Student();
		min.setMath(Integer.MAX_VALUE);
		
		for (int i = 0; i < sList.size(); i++) {
			Student s  = sList.get(i);
			if (min.getMath() > s.getMath()) {
				min = s;
			}
		}
		System.out.println("최저점수:" + min);
		
		
		
		// 평균 점수를 출력 (총점,)
		double avg = 0;

		for (Student s : sList) {
			avg = avg + s.getMath();
		}
		avg = avg / sList.size();
		System.out.println("평균: " + avg);
	}
}









