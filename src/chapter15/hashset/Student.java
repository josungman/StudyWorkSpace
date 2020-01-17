package chapter15.hashset;

public class Student {

	public int i;
	public String name;
	

	@Override
	public int hashCode() {
		return i + name.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		Student student = (Student) obj;
		return student.i == this.i && student.name.equals(name);
	}


	public Student(int i, String name) {
		this.i = i;
		this.name = name;
	}

	
	
}
