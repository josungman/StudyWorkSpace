package chapter18;

import java.io.FileWriter;
import java.io.Writer;

public class WriterEx1 {

	public static void main(String[] args) throws Exception {
		
		Writer fw = new FileWriter("lionking.txt");
		
		fw.write('한');
		fw.close();
		
	}
	
	
}
