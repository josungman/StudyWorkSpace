package chapter18;

import java.io.FileReader;
import java.io.Reader;

public class ReaderEx2 {
	public static void main(String[] args) {
		try (Reader fr = new FileReader("lionking.txt");) {
			char[] charArray = new char[10];
			
			fr.read(charArray);
			
			System.out.println(charArray[0]);
			System.out.println(charArray[9]);
			
			int i;
			
			while ((i = fr.read(charArray)) != -1) {
				System.out.println(charArray);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
