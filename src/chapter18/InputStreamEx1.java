package chapter18;

import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamEx1 {

	public static void main(String[] args )throws Exception {
		
		//InputStream 클래스는 바이트 키반 입력 스트림이 기본적으로 가져야할 메서드가 정의 되어있다.
		InputStream is = new FileInputStream("output.txt");
		
		//byte b = (byte) is.read();
		//read() 메서드는 1바이트를 읽고 4바이트 int타입으로 출력 한다.
		int i;
		int count=0;
		while((i = is.read()) != -1) {
			System.out.println(i);
			
			count++;
			
			if(count %4 == 0) {
				System.out.println();
			}
			
			
			
		}
		
		System.out.println();
		System.out.println(count + "bytes크기의 파일");
		
		is.close();
		
	}
	
}
