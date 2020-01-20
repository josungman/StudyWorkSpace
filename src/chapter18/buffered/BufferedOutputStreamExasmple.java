package chapter18.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//이것이 자바다 1036p BufferFileOutputStream 
public class BufferedOutputStreamExasmple {

	static FileInputStream fis = null;
	static FileOutputStream fos = null;
	static BufferedInputStream bis = null;
	static BufferedOutputStream bos = null;

	public static void main(String[] args) throws Exception {

		FileOutputStream();
		BufferFileOutputStream();

	}

	private static void FileOutputStream() throws Exception {

		int data = -1;
		long start = 0;
		long end = 0;

		// 파일 읽어들이고
		fis = new FileInputStream("TestImage.jpg");
		bis = new BufferedInputStream(fis);

		// 파일을 내보낸다.(복붙)
		fos = new FileOutputStream("TestImage(Copy).jpg");

		start = System.currentTimeMillis();// 작업 시간 체크

		while ((data = bis.read()) != -1) {
			fos.write(data);
		}

		fos.flush();
		end = System.currentTimeMillis();// 작업 시간 체크 종료
		fos.close();
		bis.close();
		fis.close();
		System.out.println("사용하지 않았을때 : " + (end - start) + "ms");

	}

	private static void BufferFileOutputStream() throws Exception {

		int data = -1;
		long start = 0;
		long end = 0;

		// 파일 읽어들이고
		fis = new FileInputStream("TestImage.jpg");
		bis = new BufferedInputStream(fis);

		// 파일을 내보낸다.(복붙)
		fos = new FileOutputStream("TestImage(Copy).jpg");
		bos = new BufferedOutputStream(fos);
		start = System.currentTimeMillis();// 작업 시간 체크

		while ((data = bis.read()) != -1) {
			bos.write(data);
		}

		fos.flush();
		end = System.currentTimeMillis();
		fos.close();
		bis.close();
		fis.close();
		System.out.println("사용하였을때 : " + (end - start) + "ms");

	}

}
