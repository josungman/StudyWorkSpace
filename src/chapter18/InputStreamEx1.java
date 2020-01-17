package chapter18;

import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamEx1 {

	public static void main(String[] args )throws Exception {
		
		InputStream is = new FileInputStream("output.txt");
		
		//byte b = (byte) is.read();
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
