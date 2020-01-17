package chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class StreamEx1 {

	public static void main(String[] args) throws Exception {
		
		InputStream fis = new FileInputStream("Lionking.txt");
		OutputStream fos = new FileOutputStream("Lionking.txt");
		
		Reader fr = new FileReader("lionking.txt");
		Writer fw = new FileWriter("bbbb.txt");
		
		fis.close();
		fos.close();
		
		
		
		
	}
	
		
	
	
}
