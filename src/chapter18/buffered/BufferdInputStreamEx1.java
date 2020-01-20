package chapter18.buffered;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferdInputStreamEx1 {
	public static void main(String[] args) throws Exception {
		bufferedinputstream();
		inputstream();
		
	}
	public static void bufferedinputstream() throws Exception {
		FileInputStream fis = new FileInputStream("out.txt");
		//보조 스트림 FileStream보다 읽는 속도가 빠르다.
		BufferedInputStream bis = new BufferedInputStream(fis);

 
		long start = System.currentTimeMillis();
		while (bis.read() != -1) {
			
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println((end-start) + "밀리초");
		
		System.out.println("읽기 완료.");
		
		bis.close();
	}
	
	public static void inputstream() throws Exception {
		FileInputStream fis = new FileInputStream("out.txt");

		long start = System.currentTimeMillis();
		while (fis.read() != -1) {
			
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println((end-start) + "밀리초");
		
		System.out.println("읽기 완료.");
		
		fis.close();
	}
}
