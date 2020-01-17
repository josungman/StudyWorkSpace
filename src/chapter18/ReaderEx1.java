package chapter18;

import java.io.FileReader;
import java.io.Reader;

public class ReaderEx1 {
	public static void main(String[] args) throws Exception {
		Reader fr = new FileReader("lionking.txt");
		
		char c = (char) fr.read();
		System.out.println(c);
		
		c = (char) fr.read();
		System.out.println(c);
		
		c = (char) fr.read();
		System.out.println(c);

		int i;
		while ((i = fr.read()) != -1) {
			c = (char) i;
			System.out.println(c);
		}
		
		fr.close();
	}
}







