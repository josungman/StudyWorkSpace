package chapter18;

import java.io.FileInputStream;
import java.io.InputStream;


public class InputStreamEx2 {
	public static void main(String[] args) {
		try (InputStream is = new FileInputStream("다형성1.png");) {
			byte[] byteArr = new byte[10000];
			
			int cnt = 0;
			int r = 0;
			
			while ((r = is.read(byteArr)) != -1) {
				cnt += r;
			}
			System.out.println(cnt + "bytes 크기의 파일");			
//			cnt = is.read(byteArr);
//			System.out.println(cnt);
//			cnt = is.read(byteArr);
//			System.out.println(cnt);
//			cnt = is.read(byteArr);
//			System.out.println(cnt);
			
//			while (is.read() != -1) {
//				cnt++;
//			}
//			
//			System.out.println(cnt + "bytes 크기의 파일");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
