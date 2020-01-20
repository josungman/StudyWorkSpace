package chapter18.buffered;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

//이것이 자바다 1033p 예제 각 메소드로 나눔
public class BufferedInputStreamExample {
	static long start = 0;
	static long end = 0;

	public static void main(String[] args) throws Exception {

		InputStream();

		BufferInputStream();

	}

	private static void BufferInputStream() throws Exception {
		FileInputStream fis1 = new FileInputStream("TestImage.jpg");
		// 보조 스트림 FileInputStream 객체가 먼저 있어야 된다.
		BufferedInputStream bis = new BufferedInputStream(fis1);

		start = System.currentTimeMillis();
		while (bis.read() != -1) {
		}
		end = System.currentTimeMillis();

		System.out.println("Buffer 사용하였을때:" + (end - start) + "ms");

	}

	private static void InputStream() throws Exception {
		FileInputStream fis1 = new FileInputStream("TestImage.jpg");

		start = System.currentTimeMillis();
		while (fis1.read() != -1) {
		}
		end = System.currentTimeMillis();

		System.out.println("사용하지 않았을때:" + (end - start) + "ms");

	}

}
