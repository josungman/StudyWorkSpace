package chapter18.buffered;

import java.io.FileOutputStream;
import java.io.PrintStream;


//이것이 자바다 1040 PrintStream 예제
public class PrintStreamExample {

	public static void main(String[] args) throws Exception {
			
		FileOutputStream fos = new FileOutputStream("out3.txt");
		
		PrintStream ps = new PrintStream(fos);
		
		//프린터가 출력하는것처럼
		ps.println("[프린터 보조 스트림]");
		ps.print("마치");
		ps.println("프린터가 출력하는 것처럼");
		ps.println("출력한다.");
		
		ps.flush();fos.close();
		ps.close();
		
	}

}
