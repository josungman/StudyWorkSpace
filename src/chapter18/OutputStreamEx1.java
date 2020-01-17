package chapter18;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutputStreamEx1 {
	public static void main(String[] args) {
		try (OutputStream fos = new FileOutputStream("out2.txt");) {
			fos.write(97);
			fos.write(0);
			
			fos.write(new byte[] {97, 98, 99, 100, 101});
			
			fos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
