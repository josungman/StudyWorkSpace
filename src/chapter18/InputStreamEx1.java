package chapter18;

import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamEx1 {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("output.txt");
		
//		byte b = (byte) is.read();
		int i;
		int cnt = 0;
		while ((i = is.read()) != -1) {
			System.out.println(i);
			cnt++;
		}
		
		System.out.println(cnt + "bytes 크기의 파일");
		
		
		is.close();
	}
}
