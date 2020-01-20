package chapter18.buffered;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamEx1 {
	public static void main(String[] args) throws Exception {
		//FileOutputStream fos = new FileOutputStream("C:\\Users\\USER\\Desktop\\out.txt");
		FileOutputStream fos = new FileOutputStream("out.txt");
		
		//해당 내용이 너무 많을시 Package Exploer에 내용표시 안됨...
		int loop = 1 * 1024 * 1024;
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < loop; i++) {
			fos.write(97);
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start) + "밀리초, 작성완료.");
		
		fos.flush();
		fos.close();
		///////////////////////////
		FileOutputStream fos2 = new FileOutputStream("C:\\Users\\USER\\Desktop\\out.txt");
		//보조 스트림 FileStream보다 쓰는 속도가 빠르다.
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		start = System.currentTimeMillis();
		for (int i = 0; i < loop; i++) {
			bos.write(97);
		}
		end = System.currentTimeMillis();
		System.out.println((end - start) + "밀리초, 작성완료.");
		
		bos.flush();
		bos.close();
	}
}



