package chapter18;

import java.io.FileWriter;
import java.io.Writer;

public class WriterEx1 {

	public static void main(String[] args) throws Exception {
		
		Writer fw = new FileWriter("output.txt");
		
		//세로줄 \n
		fw.write(new char[] {'한','글','날','\n','만','세'});
		
		
		
		
		fw.close();
		
	}
	
	
}
