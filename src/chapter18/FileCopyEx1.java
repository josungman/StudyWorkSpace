package chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyEx1 {

	public static void main(String[] args) {

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {

			fis = new FileInputStream("다형성1.png");
			fos = new FileOutputStream("다형성2.png");

			int r = 0;

			while ((r = fis.read()) != -1) {
				fos.write(r);
			}

			System.out.println("복사완료");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				fis.close();
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
